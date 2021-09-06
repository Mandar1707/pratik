package com.carwash.Admin.model;

import java.util.Arrays;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString

@Document(collection = "MyOrders")
public class MyOrders {
	@Id
	private int id;
	private String username;
	private String packageName;
	private String orderStatus;
	private int ratings;
	private String carWasher;
	private String assignedTo; 
	private String[] addOn;
	private String washInstance;
	private Date orderDate;
	private Date adminAssignDate;
	private Date washerAcceptDate;
	private Date washerRejectDate;
	private String mobile;
	private String address;
	private String streetAddress;
	private String addressLine2;
	private int pin;
	private String carNo;
	private String carName;
	private String carColour;
	
	
	
	public MyOrders() {
		super();
	}


	public MyOrders(int id, String username, String packageName, String orderStatus, int ratings, String carWasher,
			String assignedTo, String[] addOn, String washInstance, Date orderDate, Date adminAssignDate,
			Date washerAcceptDate, Date washerRejectDate, String mobile, String address, String streetAddress,
			String addressLine2, int pin) {
		super();
		this.id = id;
		this.username = username;
		this.packageName = packageName;
		this.orderStatus = orderStatus;
		this.ratings = ratings;
		this.carWasher = carWasher;
		this.assignedTo = assignedTo;
		this.addOn = addOn;
		this.washInstance = washInstance;
		this.orderDate = orderDate;
		this.adminAssignDate = adminAssignDate;
		this.washerAcceptDate = washerAcceptDate;
		this.washerRejectDate = washerRejectDate;
		this.mobile = mobile;
		this.address = address;
		this.streetAddress = streetAddress;
		this.addressLine2 = addressLine2;
		this.pin = pin;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPackageName() {
		return packageName;
	}


	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}


	public String getOrderStatus() {
		return orderStatus;
	}


	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}


	public int getRatings() {
		return ratings;
	}


	public void setRatings(int ratings) {
		this.ratings = ratings;
	}


	public String getCarWasher() {
		return carWasher;
	}


	public void setCarWasher(String carWasher) {
		this.carWasher = carWasher;
	}


	public String getAssignedTo() {
		return assignedTo;
	}


	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
	}


	public String[] getAddOn() {
		return addOn;
	}


	public void setAddOn(String[] addOn) {
		this.addOn = addOn;
	}


	public String getWashInstance() {
		return washInstance;
	}


	public void setWashInstance(String washInstance) {
		this.washInstance = washInstance;
	}


	public Date getOrderDate() {
		return orderDate;
	}


	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}


	public Date getAdminAssignDate() {
		return adminAssignDate;
	}


	public void setAdminAssignDate(Date adminAssignDate) {
		this.adminAssignDate = adminAssignDate;
	}


	public Date getWasherAcceptDate() {
		return washerAcceptDate;
	}


	public void setWasherAcceptDate(Date washerAcceptDate) {
		this.washerAcceptDate = washerAcceptDate;
	}


	public Date getWasherRejectDate() {
		return washerRejectDate;
	}


	public void setWasherRejectDate(Date washerRejectDate) {
		this.washerRejectDate = washerRejectDate;
	}


	public String getMobile() {
		return mobile;
	}


	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getStreetAddress() {
		return streetAddress;
	}


	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}


	public String getAddressLine2() {
		return addressLine2;
	}


	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}


	public int getPin() {
		return pin;
	}


	public void setPin(int pin) {
		this.pin = pin;
	}


	public String getCarNo() {
		return carNo;
	}


	public void setCarNo(String carNo) {
		this.carNo = carNo;
	}


	public String getCarName() {
		return carName;
	}


	public void setCarName(String carName) {
		this.carName = carName;
	}


	public String getCarColour() {
		return carColour;
	}


	public void setCarColour(String carColour) {
		this.carColour = carColour;
	}


	@Override
	public String toString() {
		return "MyOrders [id=" + id + ", username=" + username + ", packageName=" + packageName + ", orderStatus="
				+ orderStatus + ", ratings=" + ratings + ", carWasher=" + carWasher + ", assignedTo=" + assignedTo
				+ ", addOn=" + Arrays.toString(addOn) + ", washInstance=" + washInstance + ", orderDate=" + orderDate
				+ ", adminAssignDate=" + adminAssignDate + ", washerAcceptDate=" + washerAcceptDate
				+ ", washerRejectDate=" + washerRejectDate + ", mobile=" + mobile + ", address=" + address
				+ ", streetAddress=" + streetAddress + ", addressLine2=" + addressLine2 + ", pin=" + pin + ", carNo="
				+ carNo + ", carName=" + carName + ", carColour=" + carColour + "]";
	}	
	
}

