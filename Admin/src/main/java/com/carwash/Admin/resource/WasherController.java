package com.carwash.Admin.resource;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.carwash.Admin.model.CarWasher;
import com.carwash.Admin.model.MyOrders;
import com.carwash.Admin.repository.WasherRepository;
//import com.carwash.usermanipulation.model.User;
//import com.carwash.usermanipulation.repository.UserRepository;

@RestController
@RequestMapping("/Washer")
public class WasherController {

	@Autowired
	private WasherRepository repository;

	RestTemplate restTemplate = new RestTemplate();

	@RequestMapping("/")
	public String home() {
		return "home";
	}

	@RequestMapping("/welcome")
	public String welcome() {
		return "home";
	}

	@RequestMapping("/login")
	public String loginPage() {
		return "login";
	}

	@RequestMapping("/logout-success")
	public String logoutPage() {
		return "logout.jsp";
	}

	@PostMapping("/addWasher")
	@RequestMapping(value = "/addWasher", method = RequestMethod.POST)
	public String assignToWasher(@RequestBody MyOrders order) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<MyOrders> entity = new HttpEntity<MyOrders>(order, headers);

		return restTemplate
				.exchange("http://localhost:8083/addWasher", HttpMethod.POST, entity, String.class)
				.getBody();
	}

	@PutMapping("/updateWasher")
	public String updateWasher(@RequestBody CarWasher washer) {
		repository.save(washer);
		return "Washer updated : " + washer.getId();
	}

	// @GetMapping("/findAllUsers")
	@RequestMapping(value = "/findAllWasher", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<CarWasher> getWasher() {
		return repository.findAll();
	}

	@GetMapping("/findAllWashers/{id}")
	public Optional<CarWasher> getWasher(@PathVariable int id) {
		return repository.findById(id);

	}

}
