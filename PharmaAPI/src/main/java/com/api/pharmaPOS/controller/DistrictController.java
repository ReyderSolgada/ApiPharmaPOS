package com.api.pharmaPOS.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.api.pharmaPOS.entity.District;
import com.api.pharmaPOS.service.DistrictService;

@RestController
@RequestMapping("/api")

public class DistrictController {

	// Dependency injection

	@Autowired
	private DistrictService districtService;

	// Method to get all districts
	@RequestMapping(value="/districts",method=RequestMethod.GET,headers="Accept=application/json")
	public ResponseEntity<List<District>> getAllDistricts(){
		List<District> lista=new ArrayList<District>();
		lista=districtService.getAllDistricts();

		return  new ResponseEntity<List<District>>(lista,HttpStatus.OK);
	}
	// Method to get districts by id

	@RequestMapping("/districts/{id}")
	public Optional<District> getDistrict(@PathVariable int id) {
		return districtService.getDistrict(id);
	}

	// Method to add a district

	@RequestMapping(method = RequestMethod.POST, value = "/districts")
	public void addDistrict(@RequestBody District district) {
		districtService.addDistrict(district);
	}

	// Method to update a district

	@RequestMapping(method = RequestMethod.PUT, value = "/districts/{id}")
	public void updateDistrict(@RequestBody District district, @PathVariable int id) {
		districtService.updateDistrict(id, district);
	}

	// Method to delete a district

	@RequestMapping(method = RequestMethod.DELETE, value = "/districts/{id}")
	public void deleteDistrict(@PathVariable int id) {
		districtService.deleteDistrict(id);
	}

}
