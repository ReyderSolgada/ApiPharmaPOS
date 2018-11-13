package com.api.pharmaPOS.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.api.pharmaPOS.entity.District;
import com.api.pharmaPOS.repository.DistrictRepository;

@Service

public class DistrictService {

	/*
	 * When Spring creates an instance of DistrictService, the DistrictRepository
	 * class is going to be injected.
	 */

	@Autowired
	private DistrictRepository districtRepository;

	// Method to list all districts

	public List<District> getAllDistricts() {
		List<District> districts = new ArrayList<>();
		districtRepository.findAll().forEach(districts::add);
		return districts;
	}

	// Method to add a new district

	public void addDistrict(District district) {
		districtRepository.save(district);
	}

	// Method to find a district by id

	public Optional<District> getDistrict(int id) {
		return districtRepository.findById(id);
	}

	// Method to update a district

	public void updateDistrict(int id, District district) {
		districtRepository.save(district);
	}

	// Method to delete a district

	public void deleteDistrict(int id) {
		districtRepository.deleteById(id);
	}

}
