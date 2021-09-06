package com.carwash.Admin.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.carwash.Admin.model.Packagess;
import com.carwash.Admin.model.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, Integer>{
	@Query("{ prodStatus: 'Active' }")
	List<Product> findByProductStatus();
		
}


	
	

