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
import com.api.pharmaPOS.entity.JobTitle;
import com.api.pharmaPOS.service.JobTitleService;

@RestController
@RequestMapping("/api")
public class JobTitleController {
	
	// Dependency injection

	@Autowired
	private JobTitleService jobTitleService;

	// Method to get all jobtitles
	@RequestMapping(value="/jobtitles",method=RequestMethod.GET,headers="Accept=application/json")
	public ResponseEntity<List<JobTitle>> getAllJobTitles(){
		List<JobTitle> lista=new ArrayList<JobTitle>();
		lista=jobTitleService.getAllJobTitles();

		return  new ResponseEntity<List<JobTitle>>(lista,HttpStatus.OK);
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
