package com.telecom.user.service;

import java.util.List;

import com.telecom.user.dto.MoneyAmount;
import com.telecom.user.dto.OfferReq;
import com.telecom.user.model.Offer;
import com.telecom.user.dto.Order;
import com.telecom.user.dto.PhoneNumbers;
import com.telecom.user.dto.Price;
import com.telecom.user.dto.Product;
import com.telecom.user.model.Phonenumber;
import com.telecom.user.model.PriceData;


public interface UserOrderService 
{

	public Offer saveOfferDetails(OfferReq offerReq);
	
	public Product saveProductDetails(Product productReq);
	
	public Order saveOrderDetails(String userId,String phoneNumber,String offerId);
	
	public List<Order> getOrderDetailsByUserId(String userId);
	
	public Order getOrderDetailsByOrderId(String userId,String orderId) ;
	
	public List<Order> getOrderDetailsByPhoneNumber(String userId,String phonenumber) ;
	
	public Phonenumber savePhoneDetails(Phonenumber phonenumber);
	
	public PhoneNumbers getPhoneDetailsByUserId(String userId) ;
	
	public PriceData savePriceDetails(PriceData priceReq);
	
	public MoneyAmount saveMoneyDetails(MoneyAmount moneyReq);
	
	public List<com.telecom.user.dto.Offer> getOfferDetailsUsers(String userId,String phoneNumber);
//	
//	public List<Order> getAllOrders();
	
}
