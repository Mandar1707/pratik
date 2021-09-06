package com.carwash.Admin.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.carwash.Admin.model.Addons;
import com.carwash.Admin.model.CarType;
@Repository
public interface CartypeRepository extends MongoRepository<CarType, Integer>{

}
