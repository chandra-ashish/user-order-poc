package com.telecom.user.controller;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.Valid;

import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
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
import com.telecom.user.dto.CreatePurchaseOrderPayment;
import com.telecom.user.model.Offer;
import com.telecom.user.dto.Order;
import com.telecom.user.dto.OrderPayment;
import com.telecom.user.dto.Orders;
import com.telecom.user.dto.PhoneNumbers;
import com.telecom.user.dto.ProductReq;
import com.telecom.user.dto.Quotas;
import com.telecom.user.exception.OrderNotFoundException;
import com.telecom.user.exception.OrderValidationException;
import com.telecom.user.exception.UserPermissionException;
import com.telecom.user.model.Phonenumber;
import com.telecom.user.model.PriceData;
import com.telecom.user.model.User;
import com.telecom.user.service.UserOrderService;
import com.telecom.user.validation.UserOrderValidation;
import com.telecom.user.dto.MoneyAmount;
import com.telecom.user.dto.OfferReq;

@RestController
@RequestMapping(path = "/users")
public class UserOrderController {

	private static final Logger logger = LogManager.getLogger(UserOrderController.class);

	@Autowired
	private UserOrderService userOrderService;

	private JWTTokenUtil jwtTokenUtil;
	
	@Autowired
    UserOrderValidation userOrderValidation;

	@PostMapping(value = "/offer")
	public ResponseEntity<Offer> createOffer(@Valid @RequestBody OfferReq offerReq) {
		return ResponseEntity.ok(userOrderService.saveOfferDetails(offerReq));
	}

	@PostMapping(value = "/product")
	public ResponseEntity<ProductReq> createProduct(@Valid @RequestBody ProductReq productReq) {
		return ResponseEntity.ok(userOrderService.saveProductDetails(productReq));
	}

	@PostMapping(value = "/phonenumber")
	public ResponseEntity<Phonenumber> savePhoneDetails(@Valid @RequestBody Phonenumber phonenum) {
		return ResponseEntity.ok(userOrderService.savePhoneDetails(phonenum));
	}

	@PostMapping(value = "/money")
	public ResponseEntity<MoneyAmount> createMoney(@Valid @RequestBody MoneyAmount moneyReq) {
		return ResponseEntity.ok(userOrderService.saveMoneyDetails(moneyReq));
	}

	@PostMapping(value = "/price")
	public ResponseEntity<PriceData> createPrice(@Valid @RequestBody PriceData priceReq) {
		return ResponseEntity.ok(userOrderService.savePriceDetails(priceReq));
	}

	@PostMapping(value = "/quota")
	public ResponseEntity<Quotas> createQuota(@Valid @RequestBody Quotas quotas) {
		return ResponseEntity.ok(userOrderService.saveQuotaDetails(quotas));
	}
	

	@PostMapping(value = "/useradd")
	public ResponseEntity<User> saveUserDetails(@Valid @RequestBody User user) {
		return ResponseEntity.ok(userOrderService.saveUserDetails(user));
	}

	@PostMapping(value = "/{user_id}/phone-numbers/{phone_number}/orders/purchase/invoice")
	public ResponseEntity<Order> createUserOrder(@Valid@RequestHeader(value = "x-correlator", required = false) String coreelatorId  ,@RequestHeader("Authorization") String token,
			@PathVariable("user_id") String userId, @PathVariable("phone_number") String phoneNumber,
			@Valid @RequestBody CreatePurchaseOrderByPhoneNumberInvoice orderReq) throws UserPermissionException,OrderNotFoundException{
		logger.info("x-correlator " + coreelatorId + " # Create Order -" + LocalDateTime.now() + " - request received from end user", userId);
		logger.info("x-correlator " + coreelatorId + " # Create Order -" + LocalDateTime.now() + " - Order Authorization token", token);
		String inputToken = token.substring(7);
		jwtTokenUtil = new JWTTokenUtil();
		String resp = jwtTokenUtil.validateAuthorizationDetails(inputToken, userId);
		logger.info("x-correlator " + coreelatorId + " # Create Order -" + LocalDateTime.now() + " - User from Auth validation", resp);
		logger.info("x-correlator " + coreelatorId + " # Create Order -" + LocalDateTime.now() + " - User validated with authentication and proceed to raise order for offer ", orderReq.getOfferId());
		userOrderValidation.validateUserOrderDetails(userId, phoneNumber);
		String offerId = "";
		if (orderReq != null && orderReq.getOfferId() != null) {
			offerId = orderReq.getOfferId();
		}
		HttpHeaders responseHeaders = new HttpHeaders();
	    responseHeaders.set("x-correlator", coreelatorId);
		return ResponseEntity.ok().headers(responseHeaders).body(userOrderService.saveOrderDetails(userId, phoneNumber, offerId,coreelatorId));
	}
	
	@PostMapping(value = "/{user_id}/phone-numbers/{phone_number}/orders/purchase/payment")
	public ResponseEntity<OrderPayment> createUserOrderPayment(@Valid@RequestHeader(value = "x-correlator", required = false) String coreelatorId  ,@RequestHeader("Authorization") String token,
			@PathVariable("user_id") String userId, @PathVariable("phone_number") String phoneNumber,
			@Valid @RequestBody CreatePurchaseOrderPayment orderReq) throws UserPermissionException,OrderNotFoundException,OrderValidationException{
		logger.info("x-correlator " + coreelatorId + " # Payment Order -" + LocalDateTime.now() + " - request received from end user", userId);
		logger.info("x-correlator " + coreelatorId + " # Payment Order -" + LocalDateTime.now() + " - Order Authorization token", token);
		String inputToken = token.substring(7);
		jwtTokenUtil = new JWTTokenUtil();
		String resp = jwtTokenUtil.validateAuthorizationDetails(inputToken, userId);
		logger.info("x-correlator " + coreelatorId + " # Create Order -" + LocalDateTime.now() + " - User from Auth validation", resp);
		String orderId = "";
		if (orderReq != null && !StringUtils.isBlank(orderReq.getOrderId())) {
			orderId = orderReq.getOrderId();
		}
		userOrderValidation.validateUserOrderDetailsPhone(userId, phoneNumber,orderId);
		logger.info("x-correlator " + coreelatorId + " # Create Order -" + LocalDateTime.now() + " - User validated with authentication and proceed to raise order for offer ", orderId);
		HttpHeaders responseHeaders = new HttpHeaders();
	    responseHeaders.set("x-correlator", coreelatorId);
		return ResponseEntity.ok().headers(responseHeaders).body(userOrderService.sendPaymentDetails(userId, phoneNumber, orderId,coreelatorId));
	}

	@GetMapping(path = "/{user_id}/orders", produces = "application/json")
	public ResponseEntity<Orders> retrieveOrder(@Valid@RequestHeader(value = "x-correlator", required = false) String coreelatorId,@RequestHeader("Authorization") String token,
			@PathVariable("user_id") String userId) throws UserPermissionException,OrderNotFoundException {
		logger.info("x-correlator " + coreelatorId + " # Fetch Order by UserId -" + LocalDateTime.now() + " - request received from end user", userId);
		logger.info("x-correlator " + coreelatorId + " # Fetch Order by UserId -" + LocalDateTime.now() + " -  Authorization token", token);
		String inputToken = token.substring(7);
		jwtTokenUtil = new JWTTokenUtil();
		String resp = jwtTokenUtil.validateAuthorizationDetails(inputToken, userId);
		logger.info("x-correlator " + coreelatorId + " # Fetch Order by UserId -" + LocalDateTime.now() + " -   User from Auth validation", resp);
		userOrderValidation.validateUserDetails(userId);
		Orders orders = new Orders();
		orders.addAll(userOrderService.getOrderDetailsByUserId(userId,coreelatorId));
		HttpHeaders responseHeaders = new HttpHeaders();
	    responseHeaders.set("x-correlator", coreelatorId);
		return ResponseEntity.ok().headers(responseHeaders).body(orders);
	}

	@GetMapping(path = "/{user_id}/orders/{order_id}", produces = "application/json")
	public ResponseEntity<Order> retrieveOrderByOrderId(@Valid@RequestHeader(value = "x-correlator", required = false) String coreelatorId,@RequestHeader("Authorization") String token,
			@PathVariable("user_id") String userId, @PathVariable("order_id") String orderId)
			throws UserPermissionException,OrderNotFoundException {
		logger.info("x-correlator " + coreelatorId + " # Fetch Order by UserId and orderId -" + LocalDateTime.now() + " - request received from end user", userId);
		logger.info("x-correlator " + coreelatorId + " # Fetch Order by UserId and orderId-" + LocalDateTime.now() + " -  Authorization token", token);
		String inputToken = token.substring(7);
		jwtTokenUtil = new JWTTokenUtil();
		String resp = jwtTokenUtil.validateAuthorizationDetails(inputToken, userId);
		logger.info("x-correlator " + coreelatorId + " # Fetch Order by UserId and orderId -" + LocalDateTime.now() + " -   User from Auth validation", resp);
		userOrderValidation.validateUserDetails(userId);
		Order order = new Order();
		order = userOrderService.getOrderDetailsByOrderId(userId, orderId,coreelatorId);
		HttpHeaders responseHeaders = new HttpHeaders();
	    responseHeaders.set("x-correlator", coreelatorId);
		return ResponseEntity.ok().headers(responseHeaders).body(order);
	}

	@GetMapping(path = "/{user_id}/phone-numbers/{phone_number}/orders", produces = "application/json")
	public ResponseEntity<Orders> retrieveOrderByPhoneNumber(@Valid@RequestHeader(value = "x-correlator", required = false) String coreelatorId,@RequestHeader("Authorization") String token,
			@PathVariable("user_id") String userId, @PathVariable("phone_number") String phonenumber)
			throws UserPermissionException,OrderNotFoundException {
		logger.info("x-correlator " + coreelatorId + " # Fetch Order by UserId and PhoneNumber -" + LocalDateTime.now() + " - request received from end user", userId);
		logger.info("x-correlator " + coreelatorId + " # Fetch Order by UserId and PhoneNumber-" + LocalDateTime.now() + " -  Authorization token", token);
		String inputToken = token.substring(7);
		jwtTokenUtil = new JWTTokenUtil();
		String resp = jwtTokenUtil.validateAuthorizationDetails(inputToken, userId);
		logger.info("x-correlator " + coreelatorId + " # Fetch Order by UserId and PhoneNumber -" + LocalDateTime.now() + " -   User from Auth validation", resp);
		userOrderValidation.validateUserOrderDetails(userId, phonenumber);
		Orders orders = new Orders();
		orders.addAll(userOrderService.getOrderDetailsByPhoneNumber(userId, phonenumber,coreelatorId));
		HttpHeaders responseHeaders = new HttpHeaders();
	    responseHeaders.set("x-correlator", coreelatorId);
		return ResponseEntity.ok().headers(responseHeaders).body(orders);
	}

	@GetMapping(path = "/{user_id}/phone-numbers", produces = "application/json")
	public ResponseEntity<PhoneNumbers> retrievePhoneNumberByUserId(@Valid@RequestHeader(value = "x-correlator", required = false) String coreelatorId,@RequestHeader("Authorization") String token,
			@PathVariable("user_id") String userId) throws UserPermissionException,OrderNotFoundException {
		logger.info("x-correlator " + coreelatorId + " # Fetch Phone numbers by UserId -" + LocalDateTime.now() + " - request received from end user", userId);
		logger.info("x-correlator " + coreelatorId + " # Fetch Phone numbers by UserId -" + LocalDateTime.now() + " -  Authorization token", token);
		String inputToken = token.substring(7);
		jwtTokenUtil = new JWTTokenUtil();
		String resp = jwtTokenUtil.validateAuthorizationDetails(inputToken, userId);
		logger.info("x-correlator " + coreelatorId + " # Fetch Phone numbers by UserId -" + LocalDateTime.now() + " -   User from Auth validation", resp);
		userOrderValidation.validateUserDetails(userId);
		PhoneNumbers phnNm = new PhoneNumbers();
		phnNm = userOrderService.getPhoneDetailsByUserId(userId,coreelatorId);
		HttpHeaders responseHeaders = new HttpHeaders();
	    responseHeaders.set("x-correlator", coreelatorId);
		return ResponseEntity.ok().headers(responseHeaders).body(phnNm);
	}

	@GetMapping(value = "/{user_id}/phone-numbers/{phone_number}/offers")
	public ResponseEntity<List<com.telecom.user.dto.Offer>> retieveOfferDetails(@Valid@RequestHeader(value = "x-correlator", required = false) String coreelatorId,
			 @RequestHeader("Authorization") String token, @PathVariable("user_id") String userId,
			@PathVariable("phone_number") String phoneNumber) throws UserPermissionException,OrderNotFoundException {
		logger.info("x-correlator " + coreelatorId + " # Fetch offers by userId and PhoneNumber -" + LocalDateTime.now() + " - request received from end user", userId);
		logger.info("x-correlator " + coreelatorId + " # Fetch offers by userId and PhoneNumber -" + LocalDateTime.now() + " -  Authorization token", token);
		String inputToken = token.substring(7);
		jwtTokenUtil = new JWTTokenUtil();
		String resp = jwtTokenUtil.validateAuthorizationDetails(inputToken,userId);
		logger.info("x-correlator " + coreelatorId + " # Fetch offers by userId and PhoneNumber -" + LocalDateTime.now() + " -   User from Auth validation", resp);
		userOrderValidation.validateUserOrderDetails(userId, phoneNumber);
		HttpHeaders responseHeaders = new HttpHeaders();
	    responseHeaders.set("x-correlator", coreelatorId);
		return ResponseEntity.ok().headers(responseHeaders).body(userOrderService.getOfferDetailsUsers(userId, phoneNumber,coreelatorId));
	}

}
