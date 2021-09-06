package com.carwash.Admin.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

@Document(collection = "Addons")
public class Addons {
	@Id
	private int id;
	private String addon;
	private int price;
	//@Value("${addonStatus:Active}")
	private String addonStatus;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAddon() {
		return addon;
	}
	public void setAddon(String addon) {
		this.addon = addon;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getAddonStatus() {
		return addonStatus;
	}
	public void setAddonStatus(String addonStatus) {
		this.addonStatus = addonStatus;
	}
	@Override
	public String toString() {
		return "Addons [id=" + id + ", addon=" + addon + ", price=" + price + ", addonStatus=" + addonStatus + "]";
	}
	
	

}
