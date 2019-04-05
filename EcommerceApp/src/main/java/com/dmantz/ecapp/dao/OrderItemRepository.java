package com.dmantz.ecapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dmantz.ecapp.common.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem,Integer>{
	public List<OrderItem> findByProductSku(String productSku);
	@Query(value="select o from OrderItem o where o.order_id=?1 and o.productSku=?2")
	public OrderItem findByOrderIdAndProductSku(int order_id,String productSku);
	
	}
