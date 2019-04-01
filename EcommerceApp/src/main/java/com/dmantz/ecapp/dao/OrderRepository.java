package com.dmantz.ecapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dmantz.ecapp.common.Order;
import com.dmantz.ecapp.common.OrderItem;
import com.dmantz.ecapp.common.ShippingAddress;
import com.dmantz.ecapp.request.CreateOrderRequestPO;

public interface OrderRepository extends JpaRepository<Order,Integer> {

	public List<Order> findByCustomerId(String customerId);

	
	
}
