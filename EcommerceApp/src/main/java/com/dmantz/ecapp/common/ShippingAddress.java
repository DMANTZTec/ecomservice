package com.dmantz.ecapp.common;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="shipping_address")
public class ShippingAddress {
	
	@Id
	
	@Column(name="shipping_address_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String customerId;
	private String firstName;
	private String middleName;
	private String lastName;
	private double mobileNo;
	private String flatNo;
	private String area;
	private String landmark;
	private String city;
	private String state;
	private int pincode;
	private String primaryFlg;
	private String lastFlg;
	
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public double getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(double  mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getFlatNo() {
		return flatNo;
	}
	public void setFlatNo(String flatNo) {
		this.flatNo = flatNo;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getLandmark() {
		return landmark;
	}
	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public String getPrimaryFlg() {
		return primaryFlg;
	}
	public void setPrimaryFlg(String primaryFlg) {
		this.primaryFlg = primaryFlg;
	}
	public String getLastFlg() {
		return lastFlg;
	}
	public void setLastFlg(String lastFlg) {
		this.lastFlg = lastFlg;
	}
	@Override
	public String toString() {
		return "ShippingAddress [id=" + id + ", customerId=" + customerId + ", firstName=" + firstName + ", middleName="
				+ middleName + ", lastName=" + lastName + ", mobileNo=" + mobileNo + ", flatNo=" + flatNo + ", area="
				+ area + ", landmark=" + landmark + ", city=" + city + ", state=" + state + ", pincode=" + pincode
				+ ", primaryFlg=" + primaryFlg + ", lastFlg=" + lastFlg + ", getId()=" + getId() + ", getCustomerId()="
				+ getCustomerId() + ", getFirstName()=" + getFirstName() + ", getMiddleName()=" + getMiddleName()
				+ ", getLastName()=" + getLastName() + ", getMobileNo()=" + getMobileNo() + ", getFlatNo()="
				+ getFlatNo() + ", getArea()=" + getArea() + ", getLandmark()=" + getLandmark() + ", getCity()="
				+ getCity() + ", getState()=" + getState() + ", getPincode()=" + getPincode() + ", getPrimaryFlg()="
				+ getPrimaryFlg() + ", getLastFlg()=" + getLastFlg() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
	
		
	
	
	
	

}
