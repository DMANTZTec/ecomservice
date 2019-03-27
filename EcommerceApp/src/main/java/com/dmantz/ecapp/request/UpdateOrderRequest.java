package com.dmantz.ecapp.request;

import com.dmantz.ecapp.common.BillingAddress;
import com.dmantz.ecapp.common.PaymentMethod;
import com.dmantz.ecapp.common.ShippingAddress;
import com.dmantz.ecapp.common.UpdateQuantity;

public class UpdateOrderRequest {
	
	private int orderId;
	private String customerId;
	private int shippingAddressId;
	private UpdateQuantity updateQuantity;
	private int billingAddressId;
    private  String couponCode ;
    private PaymentMethod paymentMethod;
    
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public int getShippingAddressId() {
		return shippingAddressId;
	}
	public void setShippingAddressId(int shippingAddressId) {
		this.shippingAddressId = shippingAddressId;
	}
	public UpdateQuantity getUpdateQuantity() {
		return updateQuantity;
	}
	public void setUpdateQuantity(UpdateQuantity updateQuantity) {
		this.updateQuantity = updateQuantity;
	}
	public int getBillingAddressId() {
		return billingAddressId;
	}
	public void setBillingAddressId(int billingAddressId) {
		this.billingAddressId = billingAddressId;
	}
	public String getCouponCode() {
		return couponCode;
	}
	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}
	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	@Override
	public String toString() {
		return "UpdateOrderRequest [orderId=" + orderId + ", customerId=" + customerId + ", shippingAddressId="
				+ shippingAddressId + ", updateQuantity=" + updateQuantity + ", billingAddressId=" + billingAddressId
				+ ", couponCode=" + couponCode + ", paymentMethod=" + paymentMethod + ", getOrderId()=" + getOrderId()
				+ ", getCustomerId()=" + getCustomerId() + ", getShippingAddressId()=" + getShippingAddressId()
				+ ", getUpdateQuantity()=" + getUpdateQuantity() + ", getBillingAddressId()=" + getBillingAddressId()
				+ ", getCouponCode()=" + getCouponCode() + ", getPaymentMethod()=" + getPaymentMethod()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
    
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
    
}
