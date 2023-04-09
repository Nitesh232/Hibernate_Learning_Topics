package com.nitesh.hib.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class Address {
	
	//@Column(name="Street_Name")
	private String street;
	
	//@Column(name="City_Name")
	private String city;
	
	//@Column(name="State_Name")
	private String state;
	
	//@Column(name="Area_PinCode")
	private String pinCode;

	public Address(String street, String city, String state, String pinCode) {
		this.street = street;
		this.city = city;
		this.state = state;
		this.pinCode = pinCode;
	}

	public Address() {
	
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
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

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	@Override
	public String toString() {
		return "Address [street=" + street + ", city=" + city + ", state=" + state + ", pinCode=" + pinCode + "]";
	}
	
	
		

}
