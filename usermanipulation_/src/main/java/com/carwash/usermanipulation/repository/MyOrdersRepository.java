package com.carwash.usermanipulation.repository;

import java.util.List;
import java.util.Optional;

//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.carwash.usermanipulation.model.MyOrders;
//import com.carwash.usermanipulation.model.User;

//@Repository("myOrdersRepo")
public interface MyOrdersRepository extends MongoRepository<MyOrders, Integer> {
	@Query("{ 'username': ?0 }")
	List<MyOrders> findByusername(String username);
	
	

	@Query("{ 'orderStatus': ?0 }")
	List<MyOrders> findByorderStatus(String orderStatus);

	@Query("{ 'id': ?0 }")
	List<MyOrders> findById(int id);

	@Query("{assignedTo: ?0,orderStatus: 'Pending'}")
	List<MyOrders> findPendingByOrderStatus(String assignTo);
	
	@Query("{carWasher: ?0,orderStatus: 'Complete'}")
	List<MyOrders> findCompletedOrderStatus(String carWasher);


	// List<MyOrders> findByUsername(User username);

}