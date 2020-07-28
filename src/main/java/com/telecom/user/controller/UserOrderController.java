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

import com.telecom.user.dto.Order;
import com.telecom.user.service.UserOrderService;

@RestController
public class UserOrderController {
	
	@Autowired
	private UserOrderService userOrderService;

	@PostMapping(value = "/order")
	public ResponseEntity<Order> createOrder(@Valid @RequestBody Order orderDto) 
	{
		userOrderService.saveOrder(orderDto);
		return ResponseEntity.ok(orderDto);
	}

	@GetMapping(path = "/order/{orderNumber}", produces = "application/json")
	public Order retrieveOrder(@PathVariable(value = "orderNumber") int orderNumber) 
	{
		return userOrderService.getOrderById(orderNumber);
	}
	
	@GetMapping(path = "/order", produces = "application/json")
	public List<Order> retrieveOrder() 
	{
		return userOrderService.getAllOrders();
	}
	
}
