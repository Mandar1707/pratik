package com.carwash.CarWasher.resource;

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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.carwash.CarWasher.model.MyOrders;
//import com.carwash.Admin.model.User;
import com.carwash.CarWasher.repository.MyOrdersRepository;
import com.carwash.CarWasher.service.MyOrderService;

@RestController
@RequestMapping("/Orders")
public class MyOrdersController {

	@Autowired
	private MyOrdersRepository myOrdersRepository;

	private MyOrderService myOrderService;

	@Autowired
	private RestTemplate restTemplate;

	Date dNow = new Date();
	SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
	String date;

	/*
	 * @PostMapping("/addOrder") public String saveMyOrder(@RequestBody MyOrders
	 * order) { if (order.getOrderStatus() == null) {
	 * order.setOrderStatus("Pending"); } if (order.getWashInstance() == null) {
	 * order.setWashInstance("Wash now"); try { date = formatter.format(dNow);
	 * order.setDate(formatter.parse(date)); } catch (ParseException exp) {
	 * exp.printStackTrace(); } }
	 * 
	 * myOrdersRepository.save(order); return "Order added : " + order.getId(); }
	 */
	@PutMapping("/updateUserOrder")
	public String updateUserOrder(@RequestBody MyOrders order) {
		myOrdersRepository.save(order);
		return "Order updated : " + order.getId();
	}

	/*
	 * @RequestMapping(value = "/updateUserOrderByCarWasher", method =
	 * RequestMethod.POST) public String UpdateCustomerStatusWasher(@RequestBody
	 * MyOrders order) { HttpHeaders headers = new HttpHeaders();
	 * headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	 * HttpEntity<MyOrders> entity = new HttpEntity<MyOrders>(order, headers);
	 * 
	 * return restTemplate.exchange("http://localhost:8083/Orders/addOrder",
	 * HttpMethod.POST, entity, String.class) .getBody(); }
	 */

	@RequestMapping(value = "/washerAcceptUserOrder", method = RequestMethod.POST)
	public String washerAcceptUserOrder(@RequestBody MyOrders order) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<MyOrders> entity = new HttpEntity<MyOrders>(order, headers);

		return restTemplate.exchange("http://localhost:8083/Orders/washerAcceptOrder", HttpMethod.POST, entity, String.class)
				.getBody();
	}

	@RequestMapping(value = "/washerRejectUserOrder", method = RequestMethod.POST)
	public String washerRejectUserOrder(@RequestBody MyOrders order) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<MyOrders> entity = new HttpEntity<MyOrders>(order, headers);

		return restTemplate.exchange("http://localhost:8083/Orders/washerRejectOrder", HttpMethod.POST, entity, String.class)
				.getBody();
	}
	
	@RequestMapping(value = "/washerCompleteUserOrder", method = RequestMethod.POST)
	public String washerCompleteUserOrder(@RequestBody MyOrders order) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<MyOrders> entity = new HttpEntity<MyOrders>(order, headers);

		return restTemplate.exchange("http://localhost:8083/Orders/completeWashOrder", HttpMethod.POST, entity, String.class)
				.getBody();
	}

		
	@RequestMapping(value = "/findAllOrders", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<MyOrders> getMyOrder() {
		return myOrdersRepository.findAll();
	}

	/*
	 * @GetMapping("/findAllMyOrders/{id}") public Optional<MyOrders>
	 * getMyOrder(@PathVariable int id) { return myOrdersRepository.findById(id);
	 */

	@GetMapping("/findCarWasherOrders/{assignedTo}")
	public List<MyOrders> getCarWasherOrder(@PathVariable String assignedTo) {
		return myOrdersRepository.findBycarWasher(assignedTo);
	}

	// when Car Washer views request of specific user 
	@GetMapping("/findAllMyOrders/{username}")
	public String getUserOders(@PathVariable String username) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		return restTemplate.exchange("http://localhost:8083/Orders/findAllMyOrdersByName/" + username, HttpMethod.GET,
				entity, String.class).getBody();
	}
	
	//Car Washer can views orders that are assigned to him and which are currently pending
	@GetMapping("/findAllPendingOrderStatus/{assignedTo}")
	public String getPendingCarWashRequest(@PathVariable String assignedTo) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		return restTemplate.exchange("http://localhost:8083/Orders/findWashersPendingOrder/" + assignedTo, HttpMethod.GET,
				entity, String.class).getBody();
	}
	
	//Car Washer can views orders that are assigned to him and which are complete
		@GetMapping("/findAllCompletedOrderStatus/{carWasher}")
		public String getCompleteCarWashRequest(@PathVariable String carWasher) {
			HttpHeaders headers = new HttpHeaders();
			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			HttpEntity<String> entity = new HttpEntity<String>(headers);
			return restTemplate.exchange("http://localhost:8083/Orders/findWashersCompletedOrder/" + carWasher, HttpMethod.GET,
					entity, String.class).getBody();
		}

}