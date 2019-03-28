package com.dmantz.ecapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dmantz.ecapp.common.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem,Integer>{
	public List<OrderItem> findByProductSku(String productSku);

}
