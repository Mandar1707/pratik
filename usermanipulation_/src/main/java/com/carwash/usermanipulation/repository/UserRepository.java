package com.carwash.usermanipulation.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.carwash.usermanipulation.model.MyOrders;
import com.carwash.usermanipulation.model.User;

public interface UserRepository extends MongoRepository<User, Integer>{
	
	User findByUsername(String username);
	
	@Query("{ status: 'Active' }")
	List<User> findByStatus();
	
	@Query("{'role': 'Washer'}")
	List<User> findCarWasherList();
	
}
