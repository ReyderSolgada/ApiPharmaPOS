package com.api.pharmaPOS.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.api.pharmaPOS.entity.Laboratory;
import com.api.pharmaPOS.repository.LaboratoryRepository;

@Service

public class LaboratoryService {

	/*
	 * When Spring creates an instance of LaboratoryService, the
	 * LaboratoryRepository class is going to be injected.
	 */

	@Autowired
	private LaboratoryRepository laboratoryRepository;

	// Method to list all laboratories

	public List<Laboratory> getAllLaboratories() {
		List<Laboratory> laboratories = new ArrayList<>();
		laboratoryRepository.findAll().forEach(laboratories::add);
		return laboratories;
	}

	// Method to add a new laboratory

	public void addLaboratory(Laboratory laboratory) {
		laboratoryRepository.save(laboratory);
	}

	// Method to find a laboratory by id

	public Optional<Laboratory> getLaboratory(int id) {
		return laboratoryRepository.findById(id);
	}

	// Method to update a laboratory

	public void updateLaboratory(int id, Laboratory laboratory) {
		laboratoryRepository.save(laboratory);
	}

	// Method to delete a laboratory

	public void deleteLaboratory(int id) {
		laboratoryRepository.deleteById(id);
	}

}
