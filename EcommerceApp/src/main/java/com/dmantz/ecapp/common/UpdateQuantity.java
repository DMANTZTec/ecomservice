package com.dmantz.ecapp.common;

public class UpdateQuantity {
	
	private String productSku;
	private String newQuantity;
	
	
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
		return "UpdateQuantity [productSku=" + productSku + ", newQuantity=" + newQuantity + ", getProductSku()="
				+ getProductSku() + ", getNewQuantity()=" + getNewQuantity() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
	
	
	
	

}
