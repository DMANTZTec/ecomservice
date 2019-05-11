package com.dmantz.ecapp.response;

import com.dmantz.ecapp.common.Order;
import com.dmantz.ecapp.common.ShippingAddress;

public class ViewOrderResponse {
	private Order order;
	private double totalAmount;
	private ShippingAddress shippingAddress;
	
	
	
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public ShippingAddress getShippingAddress() {
		return shippingAddress;
	}
	public void setShippingAddress(ShippingAddress shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	

}
