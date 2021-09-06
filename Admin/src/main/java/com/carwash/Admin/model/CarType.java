package com.carwash.Admin.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

@Document(collection = "CarType")
public class CarType {
	@Id
	private int id;
	private String carTyp;
	private String cartypStatus;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCarTyp() {
		return carTyp;
	}
	public void setCarTyp(String carTyp) {
		this.carTyp = carTyp;
	}
	public String getCartypStatus() {
		return cartypStatus;
	}
	public void setCartypStatus(String cartypStatus) {
		this.cartypStatus = cartypStatus;
	}
	@Override
	public String toString() {
		return "CarType [id=" + id + ", carTyp=" + carTyp + ", cartypStatus=" + cartypStatus + "]";
	}

}
