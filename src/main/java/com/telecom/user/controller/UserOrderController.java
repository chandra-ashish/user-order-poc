package com.telecom.user.controller;

import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telecom.user.dto.CreatePurchaseOrderByPhoneNumberInvoice;
import com.telecom.user.model.Offer;
import com.telecom.user.dto.Order;
import com.telecom.user.dto.Orders;
import com.telecom.user.dto.PhoneNumbers;
import com.telecom.user.dto.Price;
import com.telecom.user.dto.Product;
import com.telecom.user.model.Phonenumber;
import com.telecom.user.model.PriceData;
import com.telecom.user.service.UserOrderService;

import com.telecom.user.dto.MoneyAmount;
import com.telecom.user.dto.OfferReq;

@RestController
@RequestMapping(path = "/users")
public class UserOrderController {
	
	@Autowired
	private UserOrderService userOrderService;

	@PostMapping(value = "/offer")
	public ResponseEntity<Offer> createOffer(@Valid @RequestBody OfferReq offerReq) 
	{
		return ResponseEntity.ok(userOrderService.saveOfferDetails(offerReq));
	}
	
	@PostMapping(value = "/product")
	public ResponseEntity<Product> createProduct(@Valid @RequestBody Product productReq) 
	{
		return ResponseEntity.ok(userOrderService.saveProductDetails(productReq));
	}
	
	@PostMapping(value = "/phonenumber")
	public ResponseEntity<Phonenumber> savePhoneDetails(@Valid @RequestBody Phonenumber phonenum) 
	{
		return ResponseEntity.ok(userOrderService.savePhoneDetails(phonenum));
	}
	
	@PostMapping(value = "/money")
	public ResponseEntity<MoneyAmount> createMoney(@Valid @RequestBody MoneyAmount moneyReq) 
	{
		return ResponseEntity.ok(userOrderService.saveMoneyDetails(moneyReq));
	}
	
	@PostMapping(value = "/price")
	public ResponseEntity<PriceData> createPrice(@Valid @RequestBody PriceData priceReq) 
	{
		return ResponseEntity.ok(userOrderService.savePriceDetails(priceReq));
	}
	
	@PostMapping(value = "/{user_id}/phone-numbers/{phone_number}/orders/purchase/invoice")
	public ResponseEntity<Order> createUserOrder( @PathVariable("user_id") String userId ,
			@PathVariable("phone_number") String phoneNumber,@Valid @RequestBody CreatePurchaseOrderByPhoneNumberInvoice orderReq) 
	{
		String offerId = "" ;
		if(orderReq != null && orderReq.getOfferId() != null)
		{
			offerId = orderReq.getOfferId() ;
		}
		return ResponseEntity.ok(userOrderService.saveOrderDetails(userId,phoneNumber,offerId));
	}

	@GetMapping(path = "/{user_id}/orders", produces = "application/json")
	public ResponseEntity<Orders> retrieveOrder( @PathVariable("user_id") String userId ) 
	{
		Orders orders = new Orders();
		orders.addAll(userOrderService.getOrderDetailsByUserId(userId));
		return ResponseEntity.ok(orders);
	}
	
	@GetMapping(path = "/{user_id}/orders/{order_id}", produces = "application/json")
	public ResponseEntity<Order> retrieveOrderByOrderId( @PathVariable("user_id") String userId,@PathVariable("order_id") String orderId ) 
	{
		Order order = new Order();
		order = userOrderService.getOrderDetailsByOrderId(userId, orderId);
		return ResponseEntity.ok(order);
	}
	
	@GetMapping(path = "/{user_id}/phone-numbers/{phone_number}/orders", produces = "application/json")
	public ResponseEntity<Orders> retrieveOrderByPhoneNumber( @PathVariable("user_id") String userId,@PathVariable("phone_number") String phonenumber ) 
	{
		Orders orders = new Orders();
		orders.addAll(userOrderService.getOrderDetailsByPhoneNumber(userId, phonenumber));
		return ResponseEntity.ok(orders);
	}
	
	@GetMapping(path = "/{user_id}/phone-numbers", produces = "application/json")
	public ResponseEntity<PhoneNumbers> retrievePhoneNumberByUserId( @PathVariable("user_id") String userId ) 
	{
		PhoneNumbers phnNm = new PhoneNumbers();
		phnNm = userOrderService.getPhoneDetailsByUserId(userId);
		return ResponseEntity.ok(phnNm);
	}
	
	@GetMapping(value = "/{user_id}/phone-numbers/{phone_number}/offers")
	public ResponseEntity<List<com.telecom.user.dto.Offer>> retieveOfferDetails( @PathVariable("user_id") String userId ,
			@PathVariable("phone_number") String phoneNumber) 
	{
		return ResponseEntity.ok(userOrderService.getOfferDetailsUsers(userId, phoneNumber));
	}
	
//	@GetMapping(path = "/order", produces = "application/json")
//	public List<Order> retrieveOrder() 
//	{
//		return userOrderService.getAllOrders();
//	}
	
}
