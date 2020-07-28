package com.telecom.user.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telecom.user.dto.Order;
import com.telecom.user.repository.OrderRepository;
import com.telecom.user.service.UserOrderService;

@Service
public class UserOrderServiceImpl implements UserOrderService
{
	
	@Autowired
	OrderRepository orderRepository;
	
	@Override
	public void saveOrder(Order orderDto)
	{
		orderRepository.save(orderDto);
	}


	@Override
	public Order getOrderById(int orderNumber) 
	{
		return orderRepository.findById(orderNumber);
	}
	
	@Override
	public List<Order> getAllOrders() {
        List<Order> orders = new ArrayList<Order>();
        orderRepository.findAll().forEach(order -> orders.add(order));
        return orders;
    }

}
