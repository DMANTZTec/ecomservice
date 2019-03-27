package com.dmantz.ecapp.request;

import java.util.List;

import com.dmantz.ecapp.common.OrderItem;

public class CreateOrderRequestPO {
	
	private String customerId;
	private int id;
	private List<OrderItem> orderItemObj;
	
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<OrderItem> getOrderItemObj() {
		return orderItemObj;
	}
	public void setOrderItemObj(List<OrderItem> orderItemObj) {
		this.orderItemObj = orderItemObj;
	}
	@Override
	public String toString() {
		return "CreateOrderRequestPO [customerId=" + customerId + ", id=" + id + ", orderItemObj=" + orderItemObj
				+ ", getCustomerId()=" + getCustomerId() + ", getId()=" + getId() + ", getOrderItemObj()="
				+ getOrderItemObj() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
	

}
