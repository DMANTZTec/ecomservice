package com.dmantz.ecapp.response;

public class UserRegistrationRes {
private String status;

public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
}

@Override
public String toString() {
	return "UserRegistrationRes [status=" + status + "]";
}

}
