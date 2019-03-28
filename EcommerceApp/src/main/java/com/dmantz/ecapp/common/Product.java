package com.dmantz.ecapp.common;

import java.util.ArrayList;

public class Product {

	Integer productId;
	String productManufacturerName;
	String brandName;
	String productName;
	ArrayList<ProductSku> productSkus;
	
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
		
	
	
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getProductManufacturerName() {
		return productManufacturerName;
	}
	public void setProductManufacturerName(String productManufacturerName) {
		this.productManufacturerName = productManufacturerName;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public ArrayList<ProductSku> getProductSkus() {
		return productSkus;
	}
	public void setProductSkus(ArrayList<ProductSku> productSkus) {
		this.productSkus = productSkus;
	}
	
	
	
	
	
	
	
	
	
	
		
       
}
