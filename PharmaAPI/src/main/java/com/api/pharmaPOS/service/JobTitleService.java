package com.api.pharmaPOS.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.api.pharmaPOS.entity.JobTitle;
import com.api.pharmaPOS.repository.JobTitleRepository;

@Service

public class JobTitleService {

	/*
	 * When Spring creates an instance of JobTitleService, the JobTitleRepository
	 * class is going to be injected.
	 */

	@Autowired
	private JobTitleRepository jobTitleRepository;

	// Method to list all jobTitles

	public List<JobTitle> getAllJobTitles() {
		List<JobTitle> jobTitles = new ArrayList<>();
		jobTitleRepository.findAll().forEach(jobTitles::add);
		return jobTitles;
	}

	// Method to add a new jobTitle

	public void addJobTitle(JobTitle jobTitle) {
		jobTitleRepository.save(jobTitle);
	}

	// Method to find a jobTitle by id

	public Optional<JobTitle> getJobTitle(int id) {
		return jobTitleRepository.findById(id);
	}

	// Method to update a jobTitle

	public void updateJobTitle(int id, JobTitle jobTitle) {
		jobTitleRepository.save(jobTitle);
	}

	// Method to delete a jobTitle

	public void deleteJobTitle(int id) {
		jobTitleRepository.deleteById(id);
	}

}
