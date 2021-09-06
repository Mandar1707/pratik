package com.carwash.CarWasher.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.carwash.CarWasher.model.MyOrders;
import com.carwash.CarWasher.repository.MyOrdersRepository;

@Service
public class MyOrderService {

	@Autowired
	private MyOrdersRepository myOrdersRepository;
	

	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	MongoTemplate mongoTemplate;

	
	public List<MyOrders> findOrder(String username) {
		return restTemplate.getForObject( "http://localhost:8083/Orders/findAllMyOrdersByName/"+username, new ArrayList<MyOrders>().getClass());
		
		}
		
	public List<MyOrders> findUserOrderStatus(String orderStatus) {
		return restTemplate.getForObject( "http://localhost:8083/Orders/findAllOrderStatus/"+orderStatus, new ArrayList<MyOrders>().getClass());
		
		}		
	
}
