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

import com.carwash.Admin.model.Addons;
import com.carwash.Admin.repository.AddonsRepository;

@RestController
@RequestMapping("/Addons")
public class AddonsController {
	
	@Autowired
	private AddonsRepository addonsRepository;	
	
	@PostMapping("/addAddons")
	public String saveAddons(@RequestBody Addons addons) {
		if (addons.getAddonStatus()==null) {
			addons.setAddonStatus("Active");
		}
		addonsRepository.save(addons);
		return "Addons added : " + addons.getId();
	}

	@PutMapping("/updateAddons")
	public String updateAddons(@RequestBody Addons addons) {
		addonsRepository.save(addons);
		return "Addon updated : " + addons.getId();
	}
	
	
	//@GetMapping("/findAllAddons")
			@RequestMapping(value = "/findAllAddons", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
			public List<Addons> getAddons() {
				return addonsRepository.findAll();}
			
			@RequestMapping(value = "/findActiveAddons", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
			public List<Addons> getActiveAddons() {
				return addonsRepository.findByAddonStatus();}

			
			@GetMapping("/findAllAddon/{id}")
			public Optional<Addons> getAddon(@PathVariable int id) {
				return addonsRepository.findById(id);
			}
			//Activate Addon
			@PutMapping("/activateAddons")
			public String activateAddons(@RequestBody Addons addons) {
				addonsRepository.save(addons);
				return "Addon activated : " + addons.getId();
			}
			
			// Inactivate Addon
			@PutMapping("/inactivateAddons")
			public String disableAddons(@RequestBody Addons addons) {
				addonsRepository.save(addons);
				return "Addon inactivate : " + addons.getId();
			}
}
