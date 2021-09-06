package com.carwash.CarWasher.repository;

import java.util.List;
import java.util.Optional;

//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.carwash.CarWasher.model.MyOrders;
//import com.carwash.usermanipulation.model.User;


//@Repository("myOrdersRepo")
@Repository
public interface MyOrdersRepository extends MongoRepository<MyOrders, Integer>{
	
	List<MyOrders> findByusername(String username);
	
	@Query("{ 'orderStatus': ?0 }")
	List<MyOrders> findByorderStatus(String orderStatus);
	
	@Query("{ 'assignedTo': ?0 }")
	List<MyOrders> findBycarWasher(String assignedTo);
	
	
	
	
	//List<MyOrders> findByUsername(User username);
	

}
