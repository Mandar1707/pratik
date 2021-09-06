package com.carwash.usermanipulation.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.carwash.usermanipulation.model.Addons;
//import com.carwash.Admin.model.Packagess;
import com.carwash.usermanipulation.model.MyOrders;
import com.carwash.usermanipulation.model.Packagess;
import com.carwash.usermanipulation.model.User;
import com.carwash.usermanipulation.repository.MyOrdersRepository;

@Service
public class MyOrderService {

	@Autowired
	private MyOrdersRepository myOrdersRepository;
	
	private JavaMailSender mailSender;

	@Autowired
	RestTemplate restTemplate;
	
	private SimpleMailMessage message;

	private User user;

	private MyOrders order;

	public void invoiceGenerationq(String username) {
		String uri = "http://localhost:8084/Orders/findAllMyOrders/" + order.getUsername();
		String msg = restTemplate.getForObject(uri, String.class);
		System.out.println(msg);
	}

	public List invoiceGeneration(String packageName) {
		return restTemplate.getForObject(
				"http://localhost:8084/Packagess/findPackageForInvoice/" + order.getPackageName(), List.class);
	}

	public List<Packagess> findPackage(String packageName) {
		return restTemplate.getForObject("http://localhost:8084/Packagess/findPackage/" + packageName,
				new ArrayList<MyOrders>().getClass());
	}

	public List<Addons> findAddon() {
		return restTemplate.getForObject("http://localhost:8084/Addons/findAllAddons",
				new ArrayList<MyOrders>().getClass());

	}

	public void sendSimpleEmail(String toEmail, String body, String subject) {
		//SimpleMailMessage message = new SimpleMailMessage();

		message.setFrom("pratikbharatpatil@gmail.com");
		message.setTo(toEmail);
		message.setText(body);
		message.setSubject(subject);

		mailSender.send(message);
		System.out.println("Mail Sent...");
	}

}
