package com.dmantz.ecapp.response;

public class UpdateOrderResponse {

	private String totalQuantity;
	private String status;
	
	public String getTotalQuantity() {
		return totalQuantity;
	}
	public void setTotalQuantity(String totalQuantity) {
		this.totalQuantity = totalQuantity;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "UpdateOrderResponse [totalQuantity=" + totalQuantity + ", status=" + status + ", getTotalQuantity()="
				+ getTotalQuantity() + ", getStatus()=" + getStatus() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
}
