package com.telecom.user.service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.telecom.user.dao.UserOrderDao;
import com.telecom.user.dto.DataQuota;
import com.telecom.user.dto.Description;
import com.telecom.user.dto.Descriptions;
import com.telecom.user.dto.Destination;
import com.telecom.user.dto.ModelPackage;
import com.telecom.user.model.Offer;
import com.telecom.user.dto.Order;
import com.telecom.user.dto.OrderPayment;
import com.telecom.user.dto.OrderStatus;
import com.telecom.user.dto.Origin;
import com.telecom.user.dto.Packages;
import com.telecom.user.dto.PhoneNumbers;
import com.telecom.user.dto.Price;
import com.telecom.user.dto.Product;
import com.telecom.user.dto.ProductReq;
import com.telecom.user.dto.Quotas;
import com.telecom.user.dto.SmsQuota;
import com.telecom.user.dto.TimeBand;
import com.telecom.user.dto.VoiceQuota;
import com.telecom.user.exception.OrderNotFoundException;
import com.telecom.user.exception.UserPermissionException;
import com.telecom.user.model.Money;
import com.telecom.user.model.Phonenumber;
import com.telecom.user.model.PriceData;
import com.telecom.user.model.Quota;
import com.telecom.user.model.User;
import com.telecom.user.dto.MoneyAmount;
import com.telecom.user.dto.OfferCategory;
import com.telecom.user.dto.OfferReq;
import com.telecom.user.dto.OfferedProduct;

@Service
public class UserOrderServiceImpl implements UserOrderService
{
	
	@Autowired
	UserOrderDao orderDao;
	
	@Autowired
	Environment env;
	
	private ObjectMapper mapper;
	
	 private static final Logger logger = LogManager.getLogger(UserOrderServiceImpl.class);
	
	private RestTemplate restTemplate;
	 @Override
	public Offer saveOfferDetails(OfferReq offerReq)
	{
		Map<String,String> offerCatMap = new HashMap<String,String>();
		offerReq.getCategories().forEach(category->{
			offerCatMap.put(category.getName(),category.getId().toString());
		});
		Offer offerDb = new Offer();
		BeanUtils.copyProperties(offerReq, offerDb);
		offerDb.setCategories(offerCatMap);
		return orderDao.saveOfferDetails(offerDb);
	}
	
	@Override
	public ProductReq saveProductDetails(ProductReq productReq)
	{
		try {
		com.telecom.user.model.Product prodDb = new com.telecom.user.model.Product();
		Map<String,String> mapDesc = new HashMap<String, String>();
		Map<String,String> catDesc = new HashMap<String, String>();
		BeanUtils.copyProperties(productReq, prodDb);
		if(productReq.getDescriptions() != null && !productReq.getDescriptions().isEmpty())
		{
		for( Description descObj:productReq.getDescriptions())
		{
			String text = !StringUtils.isBlank(descObj.getText())?descObj.getText():"UNKNOWN";
			String url = !StringUtils.isBlank(descObj.getUrl())?descObj.getUrl():"UNKNOWN";
			mapDesc.put(text, url);
		}
		prodDb.setDescriptions(mapDesc);
		}
		if(productReq.getPackages() != null && !productReq.getPackages().isEmpty())
		{
		for( ModelPackage descpack:productReq.getPackages())
		{
			catDesc.put(descpack.getPackageId(), descpack.getName());
		}
		prodDb.setPackages(catDesc);;
		}
		prodDb.setQuotaIds(productReq.getQuotaIds() != null && !productReq.getQuotaIds().isEmpty() ?productReq.getQuotaIds():null);
		prodDb.setProduct_id(java.util.UUID.randomUUID().toString());
		prodDb.setProductType(productReq.getProductType().toString());
		prodDb.setSubscriptionType(productReq.getSubscriptionType() != null ? productReq.getSubscriptionType().toString():null);
		orderDao.saveProductDetails(prodDb);
		
		}catch(Exception e)
            {
			logger.error("Error Occured during product details saving", e);
                }
		return productReq;
		
	}
	@Override
	public Order saveOrderDetails(String userId,String phoneNumber,String offerId,String coreelatorId)
	{
		 com.telecom.user.model.Order orderDb = new com.telecom.user.model.Order();
		Order orderDto = new Order();
		orderDb.setId(java.util.UUID.randomUUID().toString());
		
		orderDb.setIdentifier(phoneNumber);
		orderDb.setOfferId(offerId);
		orderDb.setCreationDate(getCurrentTimeInStr());
		orderDb.setStatus("pending");
		orderDb.setType("purchase");
		orderDb.setUserId(userId);
		BeanUtils.copyProperties(orderDb, orderDto);
		orderDto.setStatus(OrderStatus.PENDING);
		orderDto.setType(Order.TypeEnum.PURCHASE);
		orderDto.setCreationDate(new Date());
		orderDao.saveOrderDetails(orderDb);
		 com.telecom.user.model.Order orderDbResp = new com.telecom.user.model.Order();
		 orderDbResp = orderDao.saveOrderDetails(orderDb);
		 String message ="x-correlator " + coreelatorId + " # Create Order -" + LocalDateTime.now() + " - Order created successfully for user " + userId + " with PhoneNumber " + phoneNumber + "::" + orderDbResp.getId();
		 logger.info(message);
		restTemplate = new RestTemplate();
	    String	createPersonUrl = env.getProperty("kafka.publish.url");
	    UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(createPersonUrl)
	            .queryParam("message", "users");
	 restTemplate.postForObject(builder.toUriString(), message, String.class);
	  logger.info(message);
		return orderDto;
	}

	@Override
	public OrderPayment sendPaymentDetails(String userId,String phoneNumber,String orderId,String coreelatorId)
	{
		 String message = "";
		 OrderPayment orderPaymentDto = new OrderPayment();
		try {
		
		 mapper = new ObjectMapper();
		 orderPaymentDto.setDescription("Payment status processed successfully");
		 orderPaymentDto.setIdentifier(phoneNumber);
		 orderPaymentDto.setCoreelatorId(coreelatorId);
		 orderPaymentDto.setOrderId(orderId);
			message = mapper.writeValueAsString(orderPaymentDto);
			logger.info("publish message" +message);
		restTemplate = new RestTemplate();
	    String	createPersonUrl = env.getProperty("kafka.payment.publish.url");
	    UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(createPersonUrl)
	            .queryParam("message", "users");
	   restTemplate.postForObject(builder.toUriString(), message, String.class);
	  logger.info("x-correlator " + coreelatorId + " # Publish payment Order -" + LocalDateTime.now() + " - Payment message posted to kafka successfully for Order number::  " +orderId);
		
		} catch (Exception e) {
			logger.error("Error Occured during posting message to Kafka", e);
		}
		return orderPaymentDto;
	}

	@Override
	public List<Order> getOrderDetailsByUserId(String userId,String coreelatorId) 
	{
		List<Order> orderList = new ArrayList<Order>();
		List<com.telecom.user.model.Order> orderListDb = new ArrayList<com.telecom.user.model.Order>();
		try {
		
		orderListDb = orderDao.getOrdersByUserId(userId);
		for(com.telecom.user.model.Order orderDb:orderListDb)
		{
		   if(orderDb.getUserId().equalsIgnoreCase(userId))
		   {
			Order order = new Order();
			BeanUtils.copyProperties(orderDb, order);
			order.setCreationDate(getCurrentTimeInStr(orderDb.getCreationDate()));
			order.setStatus(OrderStatus.fromValue(orderDb.getStatus()));
			order.setType(Order.TypeEnum.fromValue(orderDb.getType()));
			orderList.add(order);
		}
		}
		
		logger.info("x-correlator " + coreelatorId + " # Fetch Order by UserId -" + LocalDateTime.now() + " -   Order details fetched successfully with no of orders "+orderList.size());
		}catch(Exception e) {	
		}
		return orderList;
	}
	
	@Override
	public Order getOrderDetailsByOrderId(String userId,String orderId,String coreelatorId) 
	{
		Order order = new Order();
		com.telecom.user.model.Order ordetDb = new com.telecom.user.model.Order();
		try {
			logger.info("x-correlator " + coreelatorId + " # Fetch Order by UserId and PhoneNumber -" + LocalDateTime.now() + " - Fetching order details from database ");
			ordetDb = orderDao.getOrderByOrderId(orderId);
	
		   if(ordetDb.getUserId().equalsIgnoreCase(userId))
		   {
			
			BeanUtils.copyProperties(ordetDb, order);
			order.setCreationDate(getCurrentTimeInStr(ordetDb.getCreationDate()));
			order.setStatus(OrderStatus.fromValue(ordetDb.getStatus()));
			order.setType(Order.TypeEnum.fromValue(ordetDb.getType()));
		    }
		
		  logger.info("x-correlator " + coreelatorId + " # Fetch Order by UserId and PhoneNumber -" + LocalDateTime.now() + " -   Order details fetched successfully ");
		}catch(Exception e) {	
		}
		return order;
	}
	@Override
	public List<Order> getOrderDetailsByPhoneNumber(String userId,String phonenumber,String coreelatorId)
	{
	List<Order> orderList = new ArrayList<Order>();
	List<com.telecom.user.model.Order> orderListDb = new ArrayList<com.telecom.user.model.Order>();
	try {
		logger.info("x-correlator " + coreelatorId + " # Fetch Order by UserId and PhoneNumber -" + LocalDateTime.now() + " - Fetching order details from database ");
	orderListDb = orderDao.getOrdersByUserId(userId);
	for(com.telecom.user.model.Order orderDb:orderListDb)
	{
	   if(orderDb.getIdentifier().equalsIgnoreCase(phonenumber))
	   {
		Order order = new Order();
		BeanUtils.copyProperties(orderDb, order);
		order.setCreationDate(getCurrentTimeInStr(orderDb.getCreationDate()));
		order.setStatus(OrderStatus.PENDING);
		order.setType(Order.TypeEnum.PURCHASE);
		orderList.add(order);
	}
	}
	logger.info("x-correlator " + coreelatorId + " # Fetch Order by UserId and PhoneNumber -" + LocalDateTime.now() + " - Order details fetched successfully ");
	
	}catch(Exception e) {	
	}
	return orderList;
}
	
	
	@Override
	public Phonenumber savePhoneDetails(Phonenumber phonenumber)
	{
		phonenumber.setId(java.util.UUID.randomUUID().toString());
		return orderDao.savePhoneDetails(phonenumber);
	}
	
	@Override
	public PhoneNumbers getPhoneDetailsByUserId(String userId, String coreelatorId)
	{
	PhoneNumbers phoneNum = new PhoneNumbers();
	List<Phonenumber> phoneList = new ArrayList<Phonenumber>();
	List<String> numberList = new ArrayList<String>();
	List<String> distinctnumberList = new ArrayList<String>();
	try {
		logger.info("x-correlator " + coreelatorId + " # Fetch Phone numbers by UserId  -" + LocalDateTime.now() + " - Fetching order details from database ");  
		User userDb = new User();
		userDb = orderDao.getUserByUserId(userId);
		phoneList = orderDao.getPhoneDetailsByUserId(userId);
		
		if(!phoneList.isEmpty())
		{
			if(userDb != null && userDb.getRole().equalsIgnoreCase("admin"))
			{
			phoneList.forEach(phoneNumber->{
					numberList.add(phoneNumber.getIdentifier());
			});
			}
			else
			{
				phoneList.forEach(phoneNumber->{
					if(phoneNumber.getUserId().equalsIgnoreCase(userId))
					{
					numberList.add(phoneNumber.getIdentifier());
					}
			});
			}
		 distinctnumberList = numberList.stream().distinct().collect(Collectors.toList());
		}
		phoneNum.setUserId(userId);
		phoneNum.setIdentifiers(distinctnumberList);
		logger.info("x-correlator " + coreelatorId + " # Fetch Phone numbers by UserId  -" + LocalDateTime.now() + " - Fetching order details from database ");	
	}catch(Exception e) {	
	}
	return phoneNum;
}
	

	@Override
	public User saveUserDetails(User user)
	{
	    orderDao.saveUserDetails(user);
	 return user;
	}

	@Override
	public PriceData savePriceDetails(PriceData priceReq)
	{

		priceReq.setPrice_id(java.util.UUID.randomUUID().toString());

		PriceData priceResp = orderDao.savePriceDetails(priceReq);
		return priceResp;
	}
	

	@Override
	public MoneyAmount saveMoneyDetails(MoneyAmount moneyReq)
	{
		Money money= new Money();
		
		BeanUtils.copyProperties(moneyReq, money);
		money.setTaxIncluded(moneyReq.isTaxIncluded());
		money.setId(java.util.UUID.randomUUID().toString());
	    orderDao.saveMoneyDetails(money);
	 return moneyReq;
	}
	
	@Override
	public List<com.telecom.user.dto.Offer> getOfferDetailsUsers(String userId,String phoneNumber,String coreelatorId)
	{
		List<com.telecom.user.dto.Offer> dtoOfferList = new ArrayList<com.telecom.user.dto.Offer>();
		List<Offer> offerList = new ArrayList<Offer>();
		offerList = orderDao.getOfferDetails();
		
		for(Offer offerObj:offerList )
		{
			if(offerObj.getIdentifiers().contains(phoneNumber))
			{
				com.telecom.user.dto.Offer offerResp = new com.telecom.user.dto.Offer();
				List<Price> priceList = new ArrayList<Price>();
				BeanUtils.copyProperties(offerObj, offerResp);
				offerResp.setId(UUID.fromString(offerObj.getId()));
				OfferedProduct productdto = convertProductModel(orderDao.getProductDetails(offerObj.getProduct_id()));
				offerResp.setProduct(productdto);
				for(String offerId :offerObj.getPrices())
				{
					Price offerPrice = new Price();
				offerPrice = orderDao.getPriceDetails(offerId);
				priceList.add(offerPrice);
				}
				offerResp.setPrices(priceList);
		
				
				List<OfferCategory> catList = new ArrayList<OfferCategory>();
				offerObj.getCategories().forEach((key,Value)->{
					OfferCategory desc = new OfferCategory();
					desc.setName(key);
					desc.setId(Value);
					catList.add(desc);
				});
				offerResp.setCategories(catList);
				dtoOfferList.add(offerResp);
			}
		}
		
		return dtoOfferList;
		
	}
	
	@Override
	public Quotas saveQuotaDetails(Quotas quotas)
	{
		List<Quota> quotaList = new ArrayList<Quota>();
		if(quotas != null && quotas.getData() != null && !quotas.getData().isEmpty())
		{
			for(DataQuota dataQ:quotas.getData())
			{
				Quota quota = new Quota();
				quota.setId(java.util.UUID.randomUUID().toString());
				quota.setMax(dataQ.getMax().intValueExact());
				//quota.setOrigins(
						if(dataQ.getOrigins() != null && !dataQ.getOrigins().isEmpty())
						{
							List<String> originList = new ArrayList<String>();
							dataQ.getOrigins().forEach(origin->{
								originList.add(origin.toString());
							});
							quota.setOrigins(originList);
						}
						if(dataQ.getTimeBands() != null && !dataQ.getTimeBands().isEmpty())
						{
							List<String> timrbrandList = new ArrayList<String>();
							dataQ.getTimeBands().forEach(brand->{
								timrbrandList.add(brand.toString());
							});
							quota.setTime_bands(timrbrandList);
						}
						quota.setType("data");	
						quota.setUnit(dataQ.getUnit().toString());
						quotaList.add(quota);
			}
		}
		if(quotas != null && quotas.getSms() != null && !quotas.getSms().isEmpty())
		{
			for(SmsQuota smsQ:quotas.getSms())
			{
				Quota quota = new Quota();
				quota.setId(java.util.UUID.randomUUID().toString());
				quota.setMax(smsQ.getMax().intValueExact());
				//quota.setOrigins(
						if(smsQ.getOrigins() != null && !smsQ.getOrigins().isEmpty())
						{
							List<String> originList = new ArrayList<String>();
							smsQ.getOrigins().forEach(origin->{
								originList.add(origin.toString());
							});
							quota.setOrigins(originList);
						}
						if(smsQ.getTimeBands() != null && !smsQ.getTimeBands().isEmpty())
						{
							List<String> timrbrandList = new ArrayList<String>();
							smsQ.getTimeBands().forEach(brand->{
								timrbrandList.add(brand.toString());
							});
							quota.setTime_bands(timrbrandList);
						}
						if(smsQ.getDestinations() != null && !smsQ.getDestinations().isEmpty())
						{
							List<String> destinationList = new ArrayList<String>();
							smsQ.getDestinations().forEach(destination->{
								destinationList.add(destination.toString());
							});
							quota.setDestinations(destinationList);
						}
						quota.setType("sms");	
						quota.setUnit(smsQ.getUnit().toString());
						quotaList.add(quota);
			}
		}
		if(quotas != null && quotas.getVoice() != null && !quotas.getVoice().isEmpty())
		{
			for(VoiceQuota voiceQ:quotas.getVoice())
			{
				Quota quota = new Quota();
				quota.setId(java.util.UUID.randomUUID().toString());
				quota.setMax(voiceQ.getMax().intValueExact());
				//quota.setOrigins(
						if(voiceQ.getOrigins() != null && !voiceQ.getOrigins().isEmpty())
						{
							List<String> originList = new ArrayList<String>();
							voiceQ.getOrigins().forEach(origin->{
								originList.add(origin.toString());
							});
							quota.setOrigins(originList);
						}
						if(voiceQ.getTimeBands() != null && !voiceQ.getTimeBands().isEmpty())
						{
							List<String> timrbrandList = new ArrayList<String>();
							voiceQ.getTimeBands().forEach(brand->{
								timrbrandList.add(brand.toString());
							});
							quota.setTime_bands(timrbrandList);
						}
						if(voiceQ.getDestinations() != null && !voiceQ.getDestinations().isEmpty())
						{
							List<String> destinationList = new ArrayList<String>();
							voiceQ.getDestinations().forEach(destination->{
								destinationList.add(destination.toString());
							});
							quota.setDestinations(destinationList);
						}
						quota.setType("voice");	
						quota.setUnit(voiceQ.getUnit().toString());
						quotaList.add(quota);
			}
		}
		
		orderDao.saveQuotatDetails(quotaList);
		return quotas;
	}
	
	public Quotas getQuotaDetails(List<String> quotaIds)
	{
		Quotas quotas = new Quotas();
		List<Quota> quotaList = new ArrayList<Quota>();
		quotaList = orderDao.getQuotaDetails();
		List<SmsQuota> quotasmsList = new ArrayList<SmsQuota>();
		List<VoiceQuota> quotavoiceList = new ArrayList<VoiceQuota>();
		List<DataQuota> quotadataList = new ArrayList<DataQuota>();
		for(Quota quota:quotaList)
		{
			if(quotaIds.contains(quota.getId()) && quota.getType().equalsIgnoreCase("sms"))
			{
				SmsQuota smsQu = new SmsQuota();
				if(quota.getTime_bands() != null && !quota.getTime_bands().isEmpty())
				{
					smsQu.setTimeBands(convertTimeBand(quota.getTime_bands()));
				}
				if(quota.getDestinations() != null && !quota.getDestinations().isEmpty())
				{
					smsQu.setDestinations(convertDestination(quota.getDestinations()));
				}
				if(quota.getOrigins() != null && !quota.getOrigins().isEmpty())
				{
					smsQu.setOrigins(convertOrigin(quota.getOrigins()));
				}
				smsQu.setUnit(quota.getUnit() != null ?SmsQuota.UnitEnum.fromValue(quota.getUnit()):null);
				smsQu.setMax(quota.getMax() != null? BigDecimal.valueOf(quota.getMax()):null);
				quotasmsList.add(smsQu);
			}
			if(quotaIds.contains(quota.getId()) && quota.getType().equalsIgnoreCase("voice"))
			{
				VoiceQuota voiceQu = new VoiceQuota();
				if(quota.getTime_bands() != null && !quota.getTime_bands().isEmpty())
				{
					voiceQu.setTimeBands(convertTimeBand(quota.getTime_bands()));
				}
				if(quota.getDestinations() != null && !quota.getDestinations().isEmpty())
				{
					voiceQu.setDestinations(convertDestination(quota.getDestinations()));
				}
				if(quota.getOrigins() != null && !quota.getOrigins().isEmpty())
				{
					voiceQu.setOrigins(convertOrigin(quota.getOrigins()));
				}
				voiceQu.setUnit(quota.getUnit() != null ?VoiceQuota.UnitEnum.fromValue(quota.getUnit()):null);
				voiceQu.setMax(quota.getMax() != null? BigDecimal.valueOf(quota.getMax()):null);
				quotavoiceList.add(voiceQu);
			}
			
			if(quotaIds.contains(quota.getId()) && quota.getType().equalsIgnoreCase("data"))
			{
				DataQuota dataQu = new DataQuota();
				if(quota.getTime_bands() != null && !quota.getTime_bands().isEmpty())
				{
					dataQu.setTimeBands(convertTimeBand(quota.getTime_bands()));
				}
				if(quota.getOrigins() != null && !quota.getOrigins().isEmpty())
				{
					dataQu.setOrigins(convertOrigin(quota.getOrigins()));
				}
				dataQu.setUnit(quota.getUnit() != null ?DataQuota.UnitEnum.fromValue(quota.getUnit()):null);
				dataQu.setMax(quota.getMax() != null? BigDecimal.valueOf(quota.getMax()):null);
				quotadataList.add(dataQu);
			}
		}
		quotas.setData(!quotadataList.isEmpty()?quotadataList:null);
		quotas.setSms(!quotasmsList.isEmpty()?quotasmsList:null);
		quotas.setVoice(!quotavoiceList.isEmpty()?quotavoiceList:null);
		return quotas;
	}
	
	public OfferedProduct convertProductModel(com.telecom.user.model.Product productDb)
	{
		OfferedProduct offerProduct = new OfferedProduct();
		try {
		Product productDto = new Product();
		
		BeanUtils.copyProperties(productDb, productDto);
		BeanUtils.copyProperties(productDto, offerProduct);
		List<Description> descList = new ArrayList<Description>();
		List<ModelPackage> modelList = new ArrayList<ModelPackage>();
		if(productDb.getDescriptions() != null && !productDb.getDescriptions().isEmpty())
		{
		productDb.getDescriptions().forEach((key,value)->{
			Description desc = new Description();
			desc.setText(key);
			desc.setUrl(!value.equalsIgnoreCase("UNKNOWN")?value:null);
			descList.add(desc);
		});
		Descriptions descriptions = new Descriptions();
		descriptions.addAll(descList);
		offerProduct.setDescriptions(descriptions);
		}
		if(productDb.getPackages() != null && !productDb.getPackages().isEmpty())
		{
		productDb.getPackages().forEach((key,Value)->{
			ModelPackage desc = new ModelPackage();
			desc.setPackageId(key);
			desc.setName(Value);
			modelList.add(desc);
		});
		Packages packages = new Packages();
		packages.addAll(modelList);
		offerProduct.setPackages(packages);
		}
		Quotas quotas = new Quotas();
		if(productDb.getQuotaIds() != null && !productDb.getQuotaIds().isEmpty())
		{
		quotas = getQuotaDetails(productDb.getQuotaIds());
		offerProduct.setQuota(quotas);
		}
		
		}catch(Exception e)
		{
		 logger.error("Error Occured during product details fetching", e);
		}
		return offerProduct ;
	}
	
	public List<TimeBand> convertTimeBand(List<String> timeBands)
	{
		List<TimeBand> timeBandList = new ArrayList<TimeBand>();
		
		for(String timeBand:timeBands)
		{
			timeBandList.add(TimeBand.fromValue(timeBand));
		}
		
		return timeBandList;
	}
	public List<Destination> convertDestination(List<String> destinations)
	{
		List<Destination> destinationList = new ArrayList<Destination>();
		
		for(String destination:destinations)
		{
			destinationList.add(Destination.fromValue(destination));
			//destinationList.add(Class.forName(destination));

		}
		
		return destinationList;
	}
	public List<Origin> convertOrigin(List<String> origins)
	{
		List<Origin> originList = new ArrayList<Origin>();
		
		for(String origin:origins)
		{
			originList.add(Origin.fromValue(origin));
		}
		
		return originList;
	}
//	@Override
//	public List<Order> getAllOrders() {
//        List<Order> orders = new ArrayList<Order>();
//        orderRepository.findAll().forEach(order -> orders.add(order));
//        return orders;
//    }
	
	public String getCurrentTimeInStr()
	{
	Date date = new Date(System.currentTimeMillis());
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss:SSS'Z'");
	String text = sdf.format(date);
	return text;
	}
	
	public Date getCurrentTimeInStr(String text) throws ParseException
	{
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss:SSS'Z'");
	//String text = sdf.format(date);
	Date date = sdf.parse(text);
	return date;
	}
	

}
