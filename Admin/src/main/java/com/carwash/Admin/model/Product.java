package com.carwash.Admin.model;

import java.util.Arrays;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString

@Document(collection = "Product")
public class Product {
	@Id
	private int id;
	private String productName;
	private String[] prodCategory;
	private String prodStatus;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String[] getProdCategory() {
		return prodCategory;
	}
	public void setProdCategory(String[] prodCategory) {
		this.prodCategory = prodCategory;
	}
	public String getProdStatus() {
		return prodStatus;
	}
	public void setProdStatus(String prodStatus) {
		this.prodStatus = prodStatus;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", productName=" + productName + ", prodCategory=" + Arrays.toString(prodCategory)
				+ ", prodStatus=" + prodStatus + "]";
	}
	
	
}
