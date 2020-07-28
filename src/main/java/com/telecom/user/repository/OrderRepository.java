package com.telecom.user.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.telecom.user.dto.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> 
{
	Order findById(int id);
}
