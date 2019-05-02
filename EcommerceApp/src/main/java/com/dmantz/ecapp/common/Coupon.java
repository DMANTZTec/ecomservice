package com.dmantz.ecapp.common;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="coupon")
public class Coupon {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int couponId;
	private int orderId;
	private String couponCode;
	private Date startingDate;
	private Date endingDate;
	private String percentage;
	private int marketPartnerId;
	private String lastUpdateBy;
	private String lastUpdateTime;
	
	public int getCouponId() {
		return couponId;
	}
	public void setCouponId(int couponId) {
		this.couponId = couponId;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getCouponCode() {
		return couponCode;
	}
	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}
	public Date getStartingDate() {
		return startingDate;
	}
	public void setStartingDate(Date startingDate) {
		this.startingDate = startingDate;
	}
	public Date getEndingDate() {
		return endingDate;
	}
	public void setEndingDate(Date endingDate) {
		this.endingDate = endingDate;
	}
	public String getPercentage() {
		return percentage;
	}
	public void setPercentage(String percentage) {
		this.percentage = percentage;
	}
	public int getMarketPartnerId() {
		return marketPartnerId;
	}
	public void setMarketPartnerId(int marketPartnerId) {
		this.marketPartnerId = marketPartnerId;
	}
	public String getLastUpdateBy() {
		return lastUpdateBy;
	}
	public void setLastUpdateBy(String lastUpdateBy) {
		this.lastUpdateBy = lastUpdateBy;
	}
	public String getLastUpdateTime() {
		return lastUpdateTime;
	}
	public void setLastUpdateTime(String lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}
	@Override
	public String toString() {
		return "Coupon [couponId=" + couponId + ", orderId=" + orderId + ", couponCode=" + couponCode
				+ ", startingDate=" + startingDate + ", endingDate=" + endingDate + ", percentage=" + percentage
				+ ", marketPartnerId=" + marketPartnerId + ", lastUpdateBy=" + lastUpdateBy + ", lastUpdateTime="
				+ lastUpdateTime + "]";
	}
	
	
	
	

}
