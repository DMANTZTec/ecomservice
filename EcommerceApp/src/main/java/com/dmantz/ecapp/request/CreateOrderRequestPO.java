package com.dmantz.ecapp.request;

import com.dmantz.ecapp.common.OrderItem;

public class CreateOrderRequestPO {
	 private String customerId;
	 OrderItem orderItem; 
	  public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public OrderItem getOrderItem() {
		return orderItem;
	}
	public void setOrderItem(OrderItem orderItem) {
		this.orderItem = orderItem;
	}
	
	  
	

	
	
	

}
