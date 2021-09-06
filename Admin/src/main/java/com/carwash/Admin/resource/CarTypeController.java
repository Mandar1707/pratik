package com.carwash.Admin.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.carwash.Admin.model.CarType;
import com.carwash.Admin.repository.CartypeRepository;

public class CarTypeController {
	
	@Autowired
	private CartypeRepository cartypeRepository;	
	
	
	@PostMapping("/addCarType")
	public String saveCarType(@RequestBody CarType ct) {
		if (ct.getCartypStatus() ==null) {
			ct.setCartypStatus("Active");
		}
		cartypeRepository.save(ct);
		return "New Car Type added : " + ct.getId();
	}

	@PutMapping("/updateCarType")
	public String updateMyOrder(@RequestBody CarType ct) {
		cartypeRepository.save(ct);
		return "Car Type updated : " + ct.getId();
	}
	
	
	@RequestMapping(value = "/findAllAddons", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<CarType> getAddons() {
		return cartypeRepository.findAll();}



}
