package com.telecom.user.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.telecom.user.model.Offer;
import com.telecom.user.dto.Price;
import com.telecom.user.model.Money;
import com.telecom.user.model.Order;
import com.telecom.user.model.Phonenumber;
import com.telecom.user.model.PriceData;
import com.telecom.user.model.Product;
import com.telecom.user.repository.MoneyRepository;
import com.telecom.user.repository.OfferRepository;
import com.telecom.user.repository.OrderRepository;
import com.telecom.user.repository.PhoneRepository;
import com.telecom.user.repository.PriceRepository;
import com.telecom.user.repository.ProductRepository;
import com.telecom.user.dto.MoneyAmount;

@Component
public class UserOrderDaoImpl implements UserOrderDao
{
	
	@Autowired
	OfferRepository offerRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	PhoneRepository phoneRepository;
	
	@Autowired
	MoneyRepository moneyRepository;
	
	@Autowired
	PriceRepository priceRepository;
	
	@Override
	public Offer saveOfferDetails(Offer offerReq)
	{
		return offerRepository.save(offerReq);
	}
	@Override
	public Product saveProductDetails(Product productReq)
	{
		return productRepository.save(productReq);
	}
	@Override
	public Product getProductDetails(String product_id)
	{
		Product productDb = null;
		Optional<Product> optProduct = productRepository.findById(product_id) ;
		if(optProduct.isPresent())
			productDb = productRepository.findById(product_id).get();
		return productDb;
	}
   
	@Override
	public Order saveOrderDetails(Order order)
	{
		return orderRepository.save(order);
	}

	@Override
	public List<Order> getOrdersByUserId(String userId)
	{
		List<Order> orderListDb = orderRepository.findAll();
		
		return orderListDb;
	}
	
	@Override
	public Order getOrderByOrderId(String id)
	{
		Order orderDb = null;
		Optional<Order> optOrder = orderRepository.findById(id) ;
		if(optOrder.isPresent())
			orderDb = orderRepository.findById(id).get();
		return orderDb;
	}
	
	@Override
	public Phonenumber savePhoneDetails(Phonenumber phonenumber)
	{
		return phoneRepository.save(phonenumber);
	}
	
	@Override
	public List<Phonenumber> getPhoneDetailsByUserId(String userId)
	{
		return phoneRepository.findAll();
	}
	
	@Override
	public Money saveMoneyDetails(Money moneyReq)
	{
		return moneyRepository.save(moneyReq);
	}
	
	@Override
	public PriceData savePriceDetails(PriceData priceReq)
	{
		return priceRepository.save(priceReq);
	}
	
	@Override
	public Price getPriceDetails(String  price_id)
	{
		PriceData retrivedPrice =null;
		Price priceDto = new Price();
		Optional<PriceData> optPrice = priceRepository.findById(price_id) ;
		if(optPrice.isPresent())
			retrivedPrice = priceRepository.findById(price_id).get();
		Money moneyDb = null;
		Optional<Money> optMoney = moneyRepository.findById(retrivedPrice.getMoney_id()) ;
		if(optMoney.isPresent())
			moneyDb = moneyRepository.findById(retrivedPrice.getMoney_id()).get();
		BeanUtils.copyProperties(retrivedPrice, priceDto);
		MoneyAmount moneydto = new MoneyAmount();
		BeanUtils.copyProperties(moneyDb, moneydto);
		priceDto.setAmount(moneydto);
		return priceDto;
	}
	
	@Override
	public List<Offer> getOfferDetails()
	{
		return offerRepository.findAll();
	}
//	
//	@Override
//	public List<Order> getAllOrders() {
//        List<Order> orders = new ArrayList<Order>();
//     //   offerRepository.findAll().forEach(order -> orders.add(order));
//        return orders;
//    }

}
