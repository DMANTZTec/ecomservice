package com.dmantz.ecapp.common;

import java.util.ArrayList;

public class OrderItem {
	 private String productSku;
	  public String getProductSku() {
		return productSku;
	}
	public void setProductSku(String productSku) {
		this.productSku = productSku;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public double getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}
	public String getAppliedDiscount() {
		return appliedDiscount;
	}
	public void setAppliedDiscount(String appliedDiscount) {
		this.appliedDiscount = appliedDiscount;
	}
	public float getAppliedPrice() {
		return appliedPrice;
	}
	public void setAppliedPrice(float appliedPrice) {
		this.appliedPrice = appliedPrice;
	}
	public ArrayList<ItemOptions> getItemOptions() {
		return itemOptions;
	}
	public void setItemOptions(ArrayList<ItemOptions> itemOptions) {
		this.itemOptions = itemOptions;
	}
	private String itemName;
	  private double itemPrice;
	  private String appliedDiscount;
	  private float appliedPrice;
	  ArrayList<ItemOptions> itemOptions = new ArrayList<ItemOptions>();
	
	  
}
