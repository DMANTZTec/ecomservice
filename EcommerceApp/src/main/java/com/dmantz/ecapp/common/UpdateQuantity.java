package com.dmantz.ecapp.common;

public class UpdateQuantity {
	private int orderId;
	private String productSku;
	private String newQuantity;
	
	
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
	public String getNewQuantity() {
		return newQuantity;
	}
	public void setNewQuantity(String newQuantity) {
		this.newQuantity = newQuantity;
	}
	@Override
	public String toString() {
		return "UpdateQuantity [orderId=" + orderId + ", productSku=" + productSku + ", newQuantity=" + newQuantity
				+ "]";
	}
	
	
	
	
	

}
