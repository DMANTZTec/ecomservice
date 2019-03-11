package com.dmantz.ecapp.request;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.dmantz.ecapp.common.OrderItem;

@Entity
@Table(name = "orders")
public class CreateOrderRequestPO {

	private String customerId;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int orderId;

	/**
	 * 
	 */
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "order", cascade = CascadeType.ALL)
	private List<OrderItem> orderItemObj;

	public List<OrderItem> getOrderItemObj() {
		return orderItemObj;
	}

	public void setOrderItemObj(List<OrderItem> orderItemObj) {
		this.orderItemObj = orderItemObj;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	@Override
	public String toString() {
		return "CreateOrderRequestPO [customerId=" + customerId + ", orderItemObj=" + orderItemObj + "]";
	}

}
