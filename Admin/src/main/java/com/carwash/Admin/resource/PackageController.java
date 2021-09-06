package com.carwash.Admin.resource;

import java.util.List;

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
import org.springframework.web.bind.annotation.RestController;

import com.carwash.Admin.model.Packagess;
import com.carwash.Admin.repository.PackageRepository;

@RestController
@RequestMapping("/Packagess")
public class PackageController {
	@Autowired
	private PackageRepository packageRepository;

	@Autowired
	MyOrderService myOrderService;

	@PostMapping("/addPackage")
	public String savePackage(@RequestBody Packagess pack) {
		if (pack.getPackageStatus() == null) {
			pack.setPackageStatus("Active");
		}
		packageRepository.save(pack);
		return "Package added : " + pack.getId();
	}

	@PutMapping("/updatePackage")
	public String updatePackage(@RequestBody Packagess pack) {
		packageRepository.save(pack);
		return "Package updated : " + pack.getId();
	}

	@RequestMapping(value = "/findAllPackages", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Packagess> getPackage() {
		return packageRepository.findAll();
	}
	
	@RequestMapping(value = "/findAllActivePackages", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Packagess> getActivePackage() {
		return packageRepository.findByPackageStatus();
	}
	
	//Enable Package
	@PutMapping("/enablePackage")
	public String activePackage(@RequestBody Packagess pack) {
		pack.setPackageStatus("Active");
		packageRepository.save(pack);
		return "Package Activated : " + pack.getId();
	}
	
	//Disable Package
		@PutMapping("/disablePackage")
		public String disablePackage(@RequestBody Packagess pack) {
			pack.setPackageStatus("Inactive");
			packageRepository.save(pack);
			return "Package Activated : " + pack.getId();
		}
	
	
	

	@GetMapping("/findPackage/{packageName}")
	public List<Packagess> getMyOrder(@PathVariable String packageName) {
		// MyOrders order = myOrderService.findOrder(username);
		System.out.println(packageName);
		return packageRepository.findBypackageName(packageName);
	}
	
	
	// sen

	/*
	 * @GetMapping("/findPackagePrice/{packageName}") public float
	 * getPackagePrice(@PathVariable String packageName) { Packagess packagess =
	 * packageRepository.findBypackageName(packageName); return
	 * packagess.getPrice(); }
	 */

	
	}


