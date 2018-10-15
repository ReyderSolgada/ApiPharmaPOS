package com.api.pharmaPOS.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.api.pharmaPOS.entity.Laboratory;
import com.api.pharmaPOS.service.LaboratoryService;

@RestController

public class LaboratoryController {

	// Dependency injection

	@Autowired
	private LaboratoryService laboratoryService;

	// Method to get all laboratories

	@RequestMapping("/laboratories")
	public List<Laboratory> getAllLaboratories() {
		return laboratoryService.getAllLaboratories();
	}

	// Method to get laboratory by id

	@RequestMapping("/laboratories/{id}")
	public Optional<Laboratory> getLaboratory(@PathVariable int id) {
		return laboratoryService.getLaboratory(id);
	}

	// Method to add a laboratory

	@RequestMapping(method = RequestMethod.POST, value = "/laboratories")
	public void addLaboratory(@RequestBody Laboratory laboratory) {
		laboratoryService.addLaboratory(laboratory);
	}

	// Method to update a laboratory

	@RequestMapping(method = RequestMethod.PUT, value = "/laboratories/{id}")
	public void updateLaboratory(@RequestBody Laboratory laboratory, @PathVariable int id) {
		laboratoryService.updateLaboratory(id, laboratory);
	}

	// Method to delete a laboratory

	@RequestMapping(method = RequestMethod.DELETE, value = "/laboratories/{id}")
	public void deleteLaboratory(@PathVariable int id) {
		laboratoryService.deleteLaboratory(id);
	}

}
