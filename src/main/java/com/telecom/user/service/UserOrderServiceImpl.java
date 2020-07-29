package com.telecom.user.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telecom.user.dao.UserOrderDao;
import com.telecom.user.dto.Description;
import com.telecom.user.dto.Descriptions;
import com.telecom.user.model.Offer;
import com.telecom.user.dto.Order;
import com.telecom.user.dto.OrderStatus;
import com.telecom.user.dto.PhoneNumbers;
import com.telecom.user.dto.Price;
import com.telecom.user.dto.Product;
import com.telecom.user.model.Money;
import com.telecom.user.model.Phonenumber;
import com.telecom.user.model.PriceData;
import com.telecom.user.repository.OfferRepository;
import com.telecom.user.dto.MoneyAmount;
import com.telecom.user.dto.OfferCategory;
import com.telecom.user.dto.OfferReq;
import com.telecom.user.dto.OfferedProduct;

@Service
public class UserOrderServiceImpl implements UserOrderService
{
	
	@Autowired
	UserOrderDao orderDao;
	
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
	public Product saveProductDetails(Product productReq)
	{
		com.telecom.user.model.Product prodDb = new com.telecom.user.model.Product();
		Map<String,String> mapDesc = new HashMap<String, String>();
		BeanUtils.copyProperties(productReq, prodDb);
		for( Description descObj:productReq.getDescriptions())
		{
			mapDesc.put(descObj.getText(), descObj.getUrl());
		}
		prodDb.setDescriptions(mapDesc);
		prodDb.setProduct_id(java.util.UUID.randomUUID().toString());
		prodDb.setProductType(productReq.getProductType().toString());
		prodDb.setSubscriptionType(productReq.getSubscriptionType().toString());
		orderDao.saveProductDetails(prodDb);
		System.out.println("fromdb" +orderDao.getProductDetails(prodDb.getProduct_id()));
		return productReq;
	}
	@Override
	public Order saveOrderDetails(String userId,String phoneNumber,String offerId)
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
		Map<String,String> mapError = new HashMap<String, String>();
		BeanUtils.copyProperties(orderDb, orderDto);
		orderDto.setStatus(OrderStatus.PENDING);
		orderDto.setType(Order.TypeEnum.PURCHASE);
		orderDto.setCreationDate(new Date());
		orderDao.saveOrderDetails(orderDb);
		return orderDto;
	}

	

	@Override
	public List<Order> getOrderDetailsByUserId(String userId) 
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
			order.setStatus(OrderStatus.PENDING);
			order.setType(Order.TypeEnum.PURCHASE);
			orderList.add(order);
		}
		}
		
		
		}catch(Exception e) {	
		}
		return orderList;
	}
	
	@Override
	public Order getOrderDetailsByOrderId(String userId,String orderId) 
	{
		Order order = new Order();
		com.telecom.user.model.Order ordetDb = new com.telecom.user.model.Order();
		try {
		
			ordetDb = orderDao.getOrderByOrderId(orderId);
	
		   if(ordetDb.getUserId().equalsIgnoreCase(userId))
		   {
			
			BeanUtils.copyProperties(ordetDb, order);
			order.setCreationDate(getCurrentTimeInStr(ordetDb.getCreationDate()));
			order.setStatus(OrderStatus.PENDING);
			order.setType(Order.TypeEnum.PURCHASE);
		    }
		
		
		}catch(Exception e) {	
		}
		return order;
	}
	@Override
	public List<Order> getOrderDetailsByPhoneNumber(String userId,String phonenumber)
	{
	List<Order> orderList = new ArrayList<Order>();
	List<com.telecom.user.model.Order> orderListDb = new ArrayList<com.telecom.user.model.Order>();
	try {
	
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
	public PhoneNumbers getPhoneDetailsByUserId(String userId)
	{
	PhoneNumbers phoneNum = new PhoneNumbers();
	List<Phonenumber> phoneList = new ArrayList<Phonenumber>();
	List<String> numberList = new ArrayList<String>();
	try {
	
		phoneList = orderDao.getPhoneDetailsByUserId(userId);
		
		if(!phoneList.isEmpty())
		{
			phoneList.forEach(phoneNumber->{
				if(phoneNumber.getUserId().equalsIgnoreCase(userId))
				{
					numberList.add(phoneNumber.getIdentifier());
				}
			});
		}
		phoneNum.setUserId(userId);
		phoneNum.setIdentifiers(numberList);
	
	}catch(Exception e) {	
	}
	return phoneNum;
}

	@Override
	public PriceData savePriceDetails(PriceData priceReq)
	{

		priceReq.setPrice_id(java.util.UUID.randomUUID().toString());

		PriceData priceResp = orderDao.savePriceDetails(priceReq);
		//System.out.println("fromdb" +orderDao.getProductDetails(prodDb.getProduct_id()));
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
	public List<com.telecom.user.dto.Offer> getOfferDetailsUsers(String userId,String phoneNumber)
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
	
	
	
	public OfferedProduct convertProductModel(com.telecom.user.model.Product productDb)
	{
		Product productDto = new Product();
		OfferedProduct offerProduct = new OfferedProduct();
		BeanUtils.copyProperties(productDb, productDto);
		BeanUtils.copyProperties(productDto, offerProduct);
		List<Description> descList = new ArrayList<Description>();
		productDb.getDescriptions().forEach((key,Value)->{
			Description desc = new Description();
			desc.setText(key);
			desc.setUrl(Value);
			descList.add(desc);
		});
		Descriptions descriptions = new Descriptions();
		descriptions.addAll(descList);
		offerProduct.setDescriptions(descriptions);
		
		return offerProduct ;
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
