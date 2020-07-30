package com.telecom.user.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telecom.user.config.JWTTokenUtil;
import com.telecom.user.dto.CreatePurchaseOrderByPhoneNumberInvoice;
import com.telecom.user.model.Offer;
import com.telecom.user.dto.Order;
import com.telecom.user.dto.Orders;
import com.telecom.user.dto.PhoneNumbers;
import com.telecom.user.dto.Price;
import com.telecom.user.dto.Product;
import com.telecom.user.dto.Quotas;
import com.telecom.user.exception.UserPermissionException;
import com.telecom.user.model.Phonenumber;
import com.telecom.user.model.PriceData;
import com.telecom.user.service.UserOrderService;

import com.telecom.user.dto.MoneyAmount;
import com.telecom.user.dto.OfferReq;

@RestController
@RequestMapping(path = "/users")
public class UserOrderController {
	
	 private static final Logger logger = LogManager.getLogger(UserOrderController.class);
	
	@Autowired
	private UserOrderService userOrderService;
	
	private JWTTokenUtil jwtTokenUtil;

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
	@PostMapping(value = "/quota")
	public ResponseEntity<Quotas> createQuota(@Valid @RequestBody Quotas quotas) 
	{
		return ResponseEntity.ok(userOrderService.saveQuotaDetails(quotas));
	}
	
	@PostMapping(value = "/{user_id}/phone-numbers/{phone_number}/orders/purchase/invoice")
	public ResponseEntity<Order> createUserOrder(@RequestHeader("Authorization") String token, @PathVariable("user_id") String userId ,
			@PathVariable("phone_number") String phoneNumber,@Valid @RequestBody CreatePurchaseOrderByPhoneNumberInvoice orderReq) throws UserPermissionException
	{
		logger.info("Order {} received from end user", userId);
		System.out.println("Authorization" +token);
		String inputToken = token.substring(7);
		System.out.println("inputToken" +inputToken);
		jwtTokenUtil = new JWTTokenUtil();
		String resp = jwtTokenUtil.validateAuthorizationDetails(inputToken,userId);
		logger.info("User validated with authentication and proceed to raise orderfor offer ", orderReq.getOfferId());
		System.out.println("resp" +resp);
		String offerId = "" ;
		if(orderReq != null && orderReq.getOfferId() != null)
		{
			offerId = orderReq.getOfferId() ;
		}
		return ResponseEntity.ok(userOrderService.saveOrderDetails(userId,phoneNumber,offerId));
	}

	@GetMapping(path = "/{user_id}/orders", produces = "application/json")
	public ResponseEntity<Orders> retrieveOrder(@RequestHeader("Authorization") String token, @PathVariable("user_id") String userId ) throws UserPermissionException
	{
		System.out.println("Authorization" +token);
		String inputToken = token.substring(7);
		System.out.println("inputToken" +inputToken);
		jwtTokenUtil = new JWTTokenUtil();
		String resp = jwtTokenUtil.validateAuthorizationDetails(inputToken,userId);
		System.out.println("resp" +resp);
		Orders orders = new Orders();
		orders.addAll(userOrderService.getOrderDetailsByUserId(userId));
		return ResponseEntity.ok(orders);
	}
	
	@GetMapping(path = "/{user_id}/orders/{order_id}", produces = "application/json")
	public ResponseEntity<Order> retrieveOrderByOrderId(@RequestHeader("Authorization") String token, @PathVariable("user_id") String userId,@PathVariable("order_id") String orderId ) throws UserPermissionException
	{
		logger.info("Getting request for fetching order details for OrderId",orderId);
		System.out.println("Authorization" +token);
		String inputToken = token.substring(7);
		System.out.println("inputToken" +inputToken);
		jwtTokenUtil = new JWTTokenUtil();
		String resp = jwtTokenUtil.validateAuthorizationDetails(inputToken,userId);
		logger.info("User validated sucessfully for fetching order details for OrderId",orderId);
		System.out.println("resp" +resp);
		Order order = new Order();
		order = userOrderService.getOrderDetailsByOrderId(userId, orderId);
		return ResponseEntity.ok(order);
	}
	
	@GetMapping(path = "/{user_id}/phone-numbers/{phone_number}/orders", produces = "application/json")
	public ResponseEntity<Orders> retrieveOrderByPhoneNumber(@RequestHeader("Authorization") String token, @PathVariable("user_id") String userId,@PathVariable("phone_number") String phonenumber )throws UserPermissionException 
	{
		System.out.println("Authorization" +token);
		String inputToken = token.substring(7);
		System.out.println("inputToken" +inputToken);
		jwtTokenUtil = new JWTTokenUtil();
		String resp = jwtTokenUtil.validateAuthorizationDetails(inputToken,userId);
		System.out.println("resp" +resp);
		Orders orders = new Orders();
		orders.addAll(userOrderService.getOrderDetailsByPhoneNumber(userId, phonenumber));
		return ResponseEntity.ok(orders);
	}
	
	@GetMapping(path = "/{user_id}/phone-numbers", produces = "application/json")
	public ResponseEntity<PhoneNumbers> retrievePhoneNumberByUserId(@RequestHeader("Authorization") String token, @PathVariable("user_id") String userId ) throws UserPermissionException
	{
		System.out.println("Authorization" +token);
		String inputToken = token.substring(7);
		System.out.println("inputToken" +inputToken);
		jwtTokenUtil = new JWTTokenUtil();
		String resp = jwtTokenUtil.validateAuthorizationDetails(inputToken,userId);
		System.out.println("resp" +resp);
		PhoneNumbers phnNm = new PhoneNumbers();
		phnNm = userOrderService.getPhoneDetailsByUserId(userId,resp);
		return ResponseEntity.ok(phnNm);
	}
	
	@GetMapping(value = "/{user_id}/phone-numbers/{phone_number}/offers")
	public ResponseEntity<List<com.telecom.user.dto.Offer>> retieveOfferDetails(@RequestHeader("Authorization") String token, @PathVariable("user_id") String userId ,
			@PathVariable("phone_number") String phoneNumber) throws UserPermissionException
	{
		System.out.println("Authorization" +token);
		String inputToken = token.substring(7);
		System.out.println("inputToken" +inputToken);
		jwtTokenUtil = new JWTTokenUtil();
		String resp = jwtTokenUtil.validateAuthorizationDetails(inputToken,userId);
		System.out.println("resp" +resp);
		return ResponseEntity.ok(userOrderService.getOfferDetailsUsers(userId, phoneNumber));
	}
	
//	@GetMapping(path = "/order", produces = "application/json")
//	public List<Order> retrieveOrder() 
//	{
//		return userOrderService.getAllOrders();
//	}
	
}
