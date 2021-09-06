package com.carwash.usermanipulation.resource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.MediaType;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.carwash.usermanipulation.model.Addons;
import com.carwash.usermanipulation.model.MyOrders;
import com.carwash.usermanipulation.model.User;
//import com.carwash.Admin.model.User;
import com.carwash.usermanipulation.repository.MyOrdersRepository;

@RestController
@RequestMapping("/Orders")
public class MyOrdersController {
	
	 private JavaMailSender mailSender;

	@Autowired
	private MyOrdersRepository myOrdersRepository;

	@Autowired
	MyOrderService myOrderService;
	
	private User user;

	@Autowired
	private RestTemplate restTemplate;

	Date dNow = new Date();
	SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
	String date;

	// User Booking a Car Wash
	@PostMapping("/acceptOrder")
	public String acceptOrderRequest(@RequestBody MyOrders order) {
		if (order.getOrderStatus() == null) {
			order.setOrderStatus("Pending");
		}
		if (order.getWashInstance() == null) {
			order.setWashInstance("Wash now");
			try {
				date = formatter.format(dNow);
				order.setOrderDate(formatter.parse(date));
			} catch (ParseException exp) {
				exp.printStackTrace();
			}
		}
		myOrdersRepository.save(order);
		return "Order added : " + order.getId();
	}

	// This method will be invoked when Admin assigns order to Washer
	@PostMapping("/assignToWasher")
	public String assignToWasher(@RequestBody MyOrders order) {
		if (order.getOrderStatus() == null) {
			order.setOrderStatus("Pending");
			}
		
		try {
			date = formatter.format(dNow);
			order.setAdminAssignDate(formatter.parse(date));
		} catch (ParseException exp) {
			exp.printStackTrace();
		}

		myOrdersRepository.save(order);
		return "Order added : " + order.getId();
	}

	// This method will be invoked when Washer accepts wash order
	@PostMapping("/washerAcceptOrder")
	public String washerAcceptOrder(@RequestBody MyOrders order) {

		order.setOrderStatus("Accepted");
		order.setCarWasher(order.getAssignedTo());
		try {
			date = formatter.format(dNow);
			order.setAdminAssignDate(formatter.parse(date));
		} catch (ParseException exp) {
			exp.printStackTrace();
		}
		myOrdersRepository.save(order);
		return "Order added : " + order.getId();
	}

	// This method will be invoked when Washer rejects wash order
	@PostMapping("/washerRejectOrder")
	public String washerRejectOrder(@RequestBody MyOrders order) {

		order.setOrderStatus("Pending");

		try {
			date = formatter.format(dNow);
			order.setAdminAssignDate(formatter.parse(date));
		} catch (ParseException exp) {
			exp.printStackTrace();
		}

		myOrdersRepository.save(order);
		return "Order added : " + order.getId();
	}

	// This method will be invoked when Washer completes wash order
	@PostMapping("/completeWashOrder")
	public String completeWashOrder(@RequestBody MyOrders order) {

		order.setOrderStatus("Completed");

		try {
			date = formatter.format(dNow);
			order.setAdminAssignDate(formatter.parse(date));
		} catch (ParseException exp) {
			exp.printStackTrace();
		}

		myOrdersRepository.save(order);
		return "Order added : " + order.getId();
	}

	// Update normal user details
	@PutMapping("/updateOrder")
	public String updateMyOrder(@RequestBody MyOrders order) {
		myOrdersRepository.save(order);
		return "Order updated : " + order.getId();
	}

	// Find all orders
	@RequestMapping(value = "/findAllOrders", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<MyOrders> getMyOrder() {
		return myOrdersRepository.findAll();
	}

	// Find all orders of a specific user
	@GetMapping("/findAllMyOrdersByName/{username}")
	public List<MyOrders> getMyOrderByName(@PathVariable String username) {
		return myOrdersRepository.findByusername(username);
	}

	// Find all pending orders that are assigned to car washer
	@GetMapping("/findWashersPendingOrder/{assignedTo}")
	public List<MyOrders> getWasherPendingOrder(@PathVariable String assignedTo) {
		return myOrdersRepository.findPendingByOrderStatus(assignedTo);
	}

	// Find all the completed orders by the car washer
	@GetMapping("/findWashersCompletedOrder/{carWasher}")
	public List<MyOrders> getWasherCompletedOrder(@PathVariable String carWasher) {
		return myOrdersRepository.findCompletedOrderStatus(carWasher);
	}

	// Find order depending on order status
	@GetMapping("findAllOrderStatus/{orderStatus}")
	public List<MyOrders> getAllOrderStatus1(@PathVariable String orderStatus) {
		return myOrdersRepository.findByorderStatus(orderStatus);
	}

	@GetMapping("findPackage/{packageName}")
	public List getPackage(@PathVariable String packageName) {
		return myOrderService.findPackage(packageName);
	}

	@GetMapping("findAddons")
	public List<Addons> getAddons() {
		return myOrderService.findAddon();
	}

	@GetMapping("findOrder/{username}")
	public List getPackage1(@PathVariable String packageName) {
		return myOrderService.findPackage(packageName);
	}
	@PostMapping("/addOrder")
	public String addOrder(@RequestBody MyOrders order) {
	if (order.getOrderStatus() == null) {
	order.setOrderStatus("Pending");
	}
	if (order.getWashInstance() == null) {
	order.setWashInstance("Wash now");
	try {
	date = formatter.format(dNow);
	order.setOrderDate(formatter.parse(date));
	} catch (ParseException exp) {
	exp.printStackTrace();
	}
	}
	myOrdersRepository.save(order);
	return "Order Placed : " + order.getId();
	}
	
	@PostMapping("/generatInvoice/{email}")
	//@EventListener(ApplicationReadyEvent.class)
	public void triggerMail(@PathVariable String email) throws MessagingException {

		  myOrderService.sendSimpleEmail(email,
				"Your Order is completed",
				"Your Oder status is Completed");
		  System.out.print("Done");
	}
	
}
