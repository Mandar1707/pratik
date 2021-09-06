package com.carwash.usermanipulation.model;

import java.util.Arrays;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString

//@Document(collection = "Packages")
public class Packagess {
	@Id
	private int id;
	private String packageName;
	private String carType;
	private String[] prods;
	private float price;
	private String packageStatus;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPackageName() {
		return packageName;
	}
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
	public String getCarType() {
		return carType;
	}
	public void setCarType(String carType) {
		this.carType = carType;
	}
	public String[] getProds() {
		return prods;
	}
	public void setProds(String[] prods) {
		this.prods = prods;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getPackageStatus() {
		return packageStatus;
	}
	public void setPackageStatus(String packageStatus) {
		this.packageStatus = packageStatus;
	}
	@Override
	public String toString() {
		return "Packagess [id=" + id + ", packageName=" + packageName + ", carType=" + carType + ", prods="
				+ Arrays.toString(prods) + ", price=" + price + ", packageStatus=" + packageStatus + "]";
	}
	
	
}
