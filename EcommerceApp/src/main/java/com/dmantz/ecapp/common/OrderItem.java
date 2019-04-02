package com.dmantz.ecapp.common;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

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
	
	/*@ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "orderId")
    private  CreateOrderRequestPO order;*/
	@Column(name="order_id")
	private int order_id;


	private int productId;
	
	//@Column(unique=true)
	@Column(name="productSku")
	private String productSku;
	
	private String mrpPrice;
	private double price;
	private String discountApplied;
	private String quantity;
	private String giftWrapped;
	private String productName;
	
	
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public int getOrderItemId() {
		return orderItemId;
	}
	public void setOrderItemId(int orderItemId) {
		this.orderItemId = orderItemId;
	}
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
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "OrderItem [orderItemId=" + orderItemId + ", order_id=" + order_id + ", productId=" + productId
				+ ", productSku=" + productSku + ", mrpPrice=" + mrpPrice + ", price=" + price + ", discountApplied="
				+ discountApplied + ", quantity=" + quantity + ", giftWrapped=" + giftWrapped + ", productName="
				+ productName + ", getOrder_id()=" + getOrder_id() + ", getOrderItemId()=" + getOrderItemId()
				+ ", getProductId()=" + getProductId() + ", getProductSku()=" + getProductSku() + ", getMrpPrice()="
				+ getMrpPrice() + ", getDiscountApplied()=" + getDiscountApplied() + ", getQuantity()=" + getQuantity()
				+ ", getGiftWrapped()=" + getGiftWrapped() + ", getProductName()=" + getProductName() + ", getPrice()="
				+ getPrice() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
	

}
