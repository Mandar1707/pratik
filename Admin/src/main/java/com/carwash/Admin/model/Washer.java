package com.carwash.Admin.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

@Document(collection = "Admin")
public class Washer {
	@Id
	private int id;
	private String name;
	private String lastName;
	private long mobileNo;
	private String emailId;
	private String username;
	private String password;
	private String ratings;
	private String review;
	/*
	 * public User(int id, String name, String lastName, long mobileNo, String
	 * emailId, String gender, String car, String username, String password, String
	 * customerStatus) { super(); this.id = id; this.name = name; this.lastName =
	 * lastName; this.mobileNo = mobileNo; this.emailId = emailId; this.gender =
	 * gender; this.car = car; this.username = username; this.password = password;
	 * this.customerStatus = customerStatus; }
	 */
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRatings() {
		return ratings;
	}
	public void setRatings(String ratings) {
		this.ratings = ratings;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	@Override
	public String toString() {
		return "Washer [id=" + id + ", name=" + name + ", lastName=" + lastName + ", mobileNo=" + mobileNo
				+ ", emailId=" + emailId + ", username=" + username + ", password=" + password + ", ratings=" + ratings
				+ ", review=" + review + "]";
	}
	
	
}
