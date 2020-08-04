package com.telecom.user.service;

import java.util.List;

import com.telecom.user.dto.MoneyAmount;
import com.telecom.user.dto.OfferReq;
import com.telecom.user.model.Offer;
import com.telecom.user.dto.Order;
import com.telecom.user.dto.OrderPayment;
import com.telecom.user.dto.PhoneNumbers;
import com.telecom.user.dto.ProductReq;
import com.telecom.user.model.Phonenumber;
import com.telecom.user.model.PriceData;
import com.telecom.user.model.User;
import com.telecom.user.dto.Quotas;

public interface UserOrderService 
{

	public Offer saveOfferDetails(OfferReq offerReq);
	
	public ProductReq saveProductDetails(ProductReq productReq);
	
	public Order saveOrderDetails(String userId,String phoneNumber,String offerId,String coreelatorId);
	public OrderPayment sendPaymentDetails(String userId,String phoneNumber,String orderId,String coreelatorId);
	
	public List<Order> getOrderDetailsByUserId(String userId,String coreelatorId);
	
	public Order getOrderDetailsByOrderId(String userId,String orderId,String coreelatorId) ;
	
	public List<Order> getOrderDetailsByPhoneNumber(String userId,String phonenumber,String coreelatorId) ;
	
	public Phonenumber savePhoneDetails(Phonenumber phonenumber);
	
	public PhoneNumbers getPhoneDetailsByUserId(String userId,String coreelatorId) ;
	
	public PriceData savePriceDetails(PriceData priceReq);
	
	public MoneyAmount saveMoneyDetails(MoneyAmount moneyReq);
	
	public List<com.telecom.user.dto.Offer> getOfferDetailsUsers(String userId,String phoneNumber,String coreelatorId);
	
	public Quotas saveQuotaDetails(Quotas quotas);
	
	public User saveUserDetails(User user);
//	
//	public List<Order> getAllOrders();
	
}
