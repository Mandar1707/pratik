package com.carwash.Admin.resource;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.carwash.Admin.model.MyOrders;
//import com.carwash.Admin.model.User;
import com.carwash.Admin.repository.MyOrdersRepository;

@RestController
@RequestMapping("/Orders")
public class MyOrdersController {

	@Autowired
	private MyOrdersRepository myOrdersRepository;

	// MyOrders myOrders;

	@Autowired
	MyOrderService myOrderService;

	@Autowired
	private RestTemplate restTemplate;

	Date dNow = new Date();
	SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
	String date;

	

	@PutMapping("/updateOrder")
	public String updateMyOrder(@RequestBody MyOrders order) {
		myOrdersRepository.save(order);
		return "Order updated : " + order.getId();
	}

	@RequestMapping(value = "/findAllOrders", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<MyOrders> getAllOrders() {
		String url = "http://localhost:8083/findAllOrders";
		MyOrders order = restTemplate.getForObject(url, MyOrders.class);
		return (List<MyOrders>) order;
	}
	
	@RequestMapping(value = "/assignToWasher", method = RequestMethod.POST)
	   public String assignToWasher(@RequestBody MyOrders order) {
	      HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity<MyOrders> entity = new HttpEntity<MyOrders>(order,headers);
	      
	      return restTemplate.exchange(
	         "http://localhost:8083/Orders/assignToWasher", HttpMethod.POST, entity, String.class).getBody();
	   }
	// this will return the washer List in Admin panel
	@RequestMapping(value = "/washerList")
	   public String getWasherList() {
	      HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity <String> entity = new HttpEntity<String>(headers);
	      
	      return restTemplate.exchange("  http://localhost:8083/products", HttpMethod.GET, entity, String.class).getBody();
	   }
	

	@GetMapping("/findAllMyOrders")
	public List<MyOrders> getMyOrder(@RequestParam String username) {
		//MyOrders order = myOrderService.findOrder(username);
		System.out.println(username);
		return myOrderService.findOrder(username);
	}


	@GetMapping("/findAllOrderStatus")
	public List<MyOrders> getUserOrderStatus(@RequestParam String orderStatus) {
		//MyOrders order = myOrderService.findOrder(username);
		System.out.println(orderStatus);
		return myOrderService.findUserOrderStatus(orderStatus);
	}
	
	
	
	
}
