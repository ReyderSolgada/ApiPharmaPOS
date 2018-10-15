package com.api.pharmaPOS.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.api.pharmaPOS.entity.JobTitle;
import com.api.pharmaPOS.service.JobTitleService;

@RestController

public class JobTitleController {
	
	// Dependency injection

	@Autowired
	private JobTitleService jobTitleService;

	// Method to get all jobtitles

	@RequestMapping("/jobtitles")
	public List<JobTitle> getAllJobTitles() {
		return jobTitleService.getAllJobTitles();
	}

	// Method to get jobtitles by id

	@RequestMapping("/jobtitles/{id}")
	public Optional<JobTitle> getJobTitle(@PathVariable int id) {
		return jobTitleService.getJobTitle(id);
	}

	// Method to add a jobtitle

	@RequestMapping(method = RequestMethod.POST, value = "/jobtitles")
	public void addJobTitle(@RequestBody JobTitle jobTitle) {
		jobTitleService.addJobTitle(jobTitle);
	}

	// Method to update a jobtitle

	@RequestMapping(method = RequestMethod.PUT, value = "/jobtitles/{id}")
	public void updateJobTitle(@RequestBody JobTitle jobTitle, @PathVariable int id) {
		jobTitleService.updateJobTitle(id, jobTitle);
	}

	// Method to delete a jobtitle

	@RequestMapping(method = RequestMethod.DELETE, value = "/jobtitles/{id}")
	public void deleteJobTitle(@PathVariable int id) {
		jobTitleService.deleteJobTitle(id);
	}

}
