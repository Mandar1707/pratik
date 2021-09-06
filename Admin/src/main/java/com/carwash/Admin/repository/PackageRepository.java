package com.carwash.Admin.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.carwash.Admin.model.Packagess;

@Repository
public interface PackageRepository extends MongoRepository<Packagess, Integer>{

	//@Query("{ price : { 'packageName': ?0 }}")
	/*
	 * @Query("{ 'packageName': ?0 },{'price':1, '_id': 0}") Optional<Packagess>
	 * findBypackagePrice(String packageName);
	 */
	
	@Query("{ 'packageName': ?0 }")
	List<Packagess> findBypackageName(String packageName);
	
	@Query("{ packageStatus: 'Active' }")
	List<Packagess> findByPackageStatus();

	//List findOrder(String packageName);
	
	


}
