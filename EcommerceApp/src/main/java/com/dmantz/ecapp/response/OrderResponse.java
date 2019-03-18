package com.dmantz.ecapp.response;

public class OrderResponse {
	private String status;
	private int orderId;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	
	@Override
	public String toString() {
		return "OrderResponse [status=" + status + ", orderId=" + orderId + ", getStatus()=" + getStatus()
				+ ", getOrderId()=" + getOrderId() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	

}
