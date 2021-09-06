package com.carwash.Admin.resource;

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
import org.springframework.web.bind.annotation.RestController;
import com.carwash.Admin.model.Product;
//import com.carwash.Admin.model.User;
import com.carwash.Admin.repository.ProductRepository;

@RestController
public class ProductController {
	
	@Autowired
	private ProductRepository productRepository;
	
	List<Product> lp;
	
	@PostMapping("/addProduct")
	public String saveProduct(@RequestBody Product product) {
		if (product.getProdStatus()==null) {
			product.setProdStatus("Active");
		}
		productRepository.save(product);
		return "Product added : " + product.getId();
	}

	@PutMapping("/updateProduct")
	public String updateProduct(@RequestBody Product product) {
		productRepository.save(product);
		return "Product updated : " + product.getId();
	}
		
	//@GetMapping("/findAllProducts")
		@RequestMapping(value = "/findAllProducts", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public List<Product> getUser() {
			return productRepository.findAll();
	}
			
		@RequestMapping(value = "/findActiveProducts", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public List<Product> getActiveProducts() {
			return productRepository.findByProductStatus();
	}

	@GetMapping("/findAllProducts/{id}")
	public Optional<Product> getProduct(@PathVariable int id) {
		return productRepository.findById(id);
	}
	//To make product active
	@PutMapping("/activeProduct")
	public String activeProduct(@RequestBody Product product) {
		productRepository.save(product);
		return "Product activated : " + product.getId();
	}
	
	//To make product inactive
		@PutMapping("/inactiveProduct")
		public String inactiveProduct(@RequestBody Product product) {
			productRepository.save(product);
			return "Product inactivated : " + product.getId();
		}
	
	
	
}



