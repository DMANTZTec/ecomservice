package com.dmantz.ecapp.common;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="orders")


public class Order {

	private String customerId;
    
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="order_id")
	private int id;
	
	@OneToMany(cascade= CascadeType.ALL,orphanRemoval=true)
	@JoinColumn(name="order_id",referencedColumnName="order_id")
	private List<OrderItem> orderItemObj;
	
	@ManyToOne(cascade=CascadeType.ALL)
	
	private ShippingAddress shippingAddress;

	public List<OrderItem> getOrderItemObj() {
		return orderItemObj;
	}

	public void setOrderItemObj(List<OrderItem> orderItemObj) {
		this.orderItemObj = orderItemObj;
	}

	
	
	public ShippingAddress getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(ShippingAddress shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	
	

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "CreateOrderRequestPO [customerId=" + customerId + ", orderItemObj=" + orderItemObj + "]";
	}

}
