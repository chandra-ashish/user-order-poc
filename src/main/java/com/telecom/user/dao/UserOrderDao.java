package com.telecom.user.dao;

import java.util.List;

import com.telecom.user.model.Offer;
import com.telecom.user.dto.PhoneNumbers;
import com.telecom.user.dto.Price;
import com.telecom.user.model.Money;
import com.telecom.user.model.Order;
import com.telecom.user.model.Phonenumber;
import com.telecom.user.model.PriceData;
import com.telecom.user.model.Product;

public interface UserOrderDao 
{

	public Offer saveOfferDetails(Offer offerReq);
	public Product saveProductDetails(Product productReq);
	public Product getProductDetails(String  product_id);
	
	public Order saveOrderDetails(Order order);
	public List<Order> getOrdersByUserId(String userId);
	public Order getOrderByOrderId(String id);
	public Phonenumber savePhoneDetails(Phonenumber phonenumber);
	
	public List<Phonenumber> getPhoneDetailsByUserId(String userId) ;
	public Money saveMoneyDetails(Money moneyReq);
	public PriceData savePriceDetails(PriceData priceReq);
	public Price getPriceDetails(String  price_id);
	
	public List<Offer> getOfferDetails();
//	
//	public List<Order> getAllOrders();
	
}
