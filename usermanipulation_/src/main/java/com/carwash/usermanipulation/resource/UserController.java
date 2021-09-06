package com.carwash.usermanipulation.resource;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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

import com.carwash.usermanipulation.model.User;
import com.carwash.usermanipulation.repository.UserRepository;


@RestController
public class UserController {

	@Autowired
	private UserRepository repository;
	
	RestTemplate restTemplate = new RestTemplate(); 
	
	@RequestMapping("/")
	public String home()
	{
		return "home";
	}
	
	@RequestMapping("/welcome")
	public String welcome(){
		return "home";
	}

	@RequestMapping("/login")
	public String loginPage()
	{
		return "login";
	}

	@RequestMapping("/logout-success")
	public String logoutPage()
	{
		return "logout.jsp";
	}

	@PostMapping("/addUser")
	public String saveUser(@RequestBody User user) {
		user.setRole("User");
		repository.save(user);
		return "User added : " + user.getId();
	}

	@PutMapping("/updateUser")
	public String updateUser(@RequestBody User user) {
		repository.save(user);
		return "User updated : " + user.getId();
	}
	
	@PutMapping("/setBusyStatus")
	public String updateBusyStatus(@RequestBody User user) {
		user.setStatus("Busy");
		repository.save(user);
		return "Status Updated as busy: " + user.getId();
	}
	
	@PutMapping("/setAvailabiltyStatus")
	public String setAvailabiltyStatus(@RequestBody User user) {
		user.setStatus("Available");
		repository.save(user);
		return "Status Updated as available: " + user.getId();
	}
		
	//@GetMapping("/findAllUsers")
	@RequestMapping(value = "/findAllUsers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<User> getUser() {
		return repository.findAll();
	}
	
	@RequestMapping(value = "/findActiveUsers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<User> findActiveUsers() {
		return repository.findByStatus();
	}

	@GetMapping("/findAllUsers/{id}")
	public Optional<User> getUser(@PathVariable int id) {
		return repository.findById(id);
	}
	
	@RequestMapping(value = "/findAllCarWahers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<User> getWasherList() {
		return repository.findCarWasherList();
	}
	
	@PostMapping("/addWasher")
	public String addWasher(@RequestBody User user) {
		user.setRole("Washer");
		repository.save(user);
		return "Washer added : " + user.getId();
	}
	
	

}
