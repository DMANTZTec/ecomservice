package com.dmantz.ecapp.common;

public class UpdateQuantity {
	private int orderId;
	private String productSku;
	private String totalQuantity;
	
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
		public String getProductSku() {
		return productSku;
	}
	public void setProductSku(String productSku) {
		this.productSku = productSku;
	}
	public String getTotalQuantity() {
		return totalQuantity;
	}
	public void setTotalQuantity(String totalQuantity) {
		this.totalQuantity = totalQuantity;
	}
	
	@Override
	public String toString() {
		return "UpdateQuantity [orderId=" + orderId + ", productSku=" + productSku + ", totalQuantity=" + totalQuantity
				+ ", getOrderId()=" + getOrderId() + ", getProductSku()=" + getProductSku() + ", getTotalQuantity()="
				+ getTotalQuantity() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
	

}
