package com.dmantz.ecapp.common;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.dmantz.ecapp.request.CreateOrderRequestPO;

/**
 * @author Mounika
 *
 */
@Entity
@Table(name = "order_item")
public class OrderItem {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int orderItemId;
	
	@ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "orderId")
    private  CreateOrderRequestPO order;
	
//	private int orderId;
	
	// @ManyToOne(cascade = CascadeType.ALL)
	// @JoinColumn(name="orderId")
	// private CreateOrderRequestPO createOrderRequestPO;
	// private int orderItemId1;
	
	private int productId;
	private String productSku;
	private String mrpPrice;
	private String price;
	private String discountApplied;
	private String quantity;
	private String giftWrapped;
	private String productName;
	public int getOrderItemId() {
		return orderItemId;
	}
	public void setOrderItemId(int orderItemId) {
		this.orderItemId = orderItemId;
	}
	/*
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	*/
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductSku() {
		return productSku;
	}
	public void setProductSku(String productSku) {
		this.productSku = productSku;
	}
	public String getMrpPrice() {
		return mrpPrice;
	}
	public void setMrpPrice(String mrpPrice) {
		this.mrpPrice = mrpPrice;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getDiscountApplied() {
		return discountApplied;
	}
	public void setDiscountApplied(String discountApplied) {
		this.discountApplied = discountApplied;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getGiftWrapped() {
		return giftWrapped;
	}
	public void setGiftWrapped(String giftWrapped) {
		this.giftWrapped = giftWrapped;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}

}
