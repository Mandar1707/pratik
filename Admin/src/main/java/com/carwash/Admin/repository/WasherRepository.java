package com.carwash.Admin.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.carwash.Admin.model.CarWasher;
//import com.carwash.carwasher.model.User;
@Repository
public interface WasherRepository extends MongoRepository<CarWasher, Integer>{
	
	CarWasher findByUsername(String username);
}
