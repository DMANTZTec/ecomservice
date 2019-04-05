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
	
	@OneToMany(cascade= CascadeType.ALL,orphanRemoval = true)
	@JoinColumn(name="order_id",referencedColumnName="order_id")
	private List<OrderItem> orderItemObj;
	 
	private int shippingAddressId;
	
	/*@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="shipping_address_id",referencedColumnName="order_id")
	private ShippingAddress shippingAddress;*/

	public List<OrderItem> getOrderItemObj() {
		return orderItemObj;
	}

	public void setOrderItemObj(List<OrderItem> orderItemObj) {
		this.orderItemObj = orderItemObj;
	}

	
	
	
	public int getShippingAddressId() {
		return shippingAddressId;
	}

	public void setShippingAddressId(int shippingAddressId) {
		this.shippingAddressId = shippingAddressId;
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
