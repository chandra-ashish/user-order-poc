package com.telecom.user.service;

import java.util.List;

import com.telecom.user.dto.Order;

public interface UserOrderService 
{

	public void saveOrder(Order userPreferenceDto);
	
	public Order getOrderById(int orderNumber);
	
	public List<Order> getAllOrders();
	
}
