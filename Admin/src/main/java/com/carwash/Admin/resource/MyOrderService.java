package com.carwash.Admin.resource;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
//import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.carwash.Admin.model.MyOrders;
import com.carwash.Admin.model.Packagess;
import com.carwash.Admin.repository.MyOrdersRepository;
import com.carwash.Admin.repository.PackageRepository;

@Service
public class MyOrderService {

	@Autowired
	private MyOrdersRepository myOrdersRepository;
	
	@Autowired
	private PackageRepository packageRepository; 

	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	MongoTemplate mongoTemplate;

	//public MyOrders order;
	
	public List<MyOrders> findOrder(String username) {
		return restTemplate.getForObject( "http://localhost:8083/Orders/findAllMyOrdersByName/"+username, new ArrayList<MyOrders>().getClass());
		
		}
		
	public List<MyOrders> findUserOrderStatus(String orderStatus) {
		return restTemplate.getForObject( "http://localhost:8083/Orders/findAllOrderStatus/"+orderStatus, new ArrayList<MyOrders>().getClass());
		
		}
	
		/*
		 * public Optional<Packagess> invoiceGeneration(String packageName){ return
		 * packageRepository.(packageName); }
		 */
		
	//String uri = "http://localhost:8083/Orders/findAllMyOrders/"+order.getUsername();
	//return restTemplate.getForObject(uri, MyOrders.class);
	// order.setOrderStatus("CANCELLED");
	// orderRepository.save(order);
	
}
