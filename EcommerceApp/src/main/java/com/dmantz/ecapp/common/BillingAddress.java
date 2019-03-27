package com.dmantz.ecapp.common;

public class BillingAddress {
	
	private int billingAddressId;
	private String customerId;
	private String firstName;
	private String middleName;
	private String lastName;
	private int mobileNo;
	private String flatNo;
	private String area;
	private String landmark;
	private String city;
	private String state;
	private int pincode;
	
	public int getBillingAddressId() {
		return billingAddressId;
	}
	public void setBillingAddressId(int billingAddressId) {
		this.billingAddressId = billingAddressId;
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
	public int getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(int mobileNo) {
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
	
	@Override
	public String toString() {
		return "BillingAddress [billingAddressId=" + billingAddressId + ", customerId=" + customerId + ", firstName="
				+ firstName + ", middleName=" + middleName + ", lastName=" + lastName + ", mobileNo=" + mobileNo
				+ ", flatNo=" + flatNo + ", area=" + area + ", landmark=" + landmark + ", city=" + city + ", state="
				+ state + ", pincode=" + pincode + ", getBillingAddressId()=" + getBillingAddressId()
				+ ", getCustomerId()=" + getCustomerId() + ", getFirstName()=" + getFirstName() + ", getMiddleName()="
				+ getMiddleName() + ", getLastName()=" + getLastName() + ", getMobileNo()=" + getMobileNo()
				+ ", getFlatNo()=" + getFlatNo() + ", getArea()=" + getArea() + ", getLandmark()=" + getLandmark()
				+ ", getCity()=" + getCity() + ", getState()=" + getState() + ", getPincode()=" + getPincode()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
	

}
