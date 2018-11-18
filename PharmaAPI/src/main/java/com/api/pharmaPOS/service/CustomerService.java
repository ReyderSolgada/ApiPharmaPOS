package com.api.pharmaPOS.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.api.pharmaPOS.entity.Customer;
import com.api.pharmaPOS.repository.CustomerRepository;

@Service

public class CustomerService {

	/*
	 * When Spring creates an instance of CustomerService, the CustomerRepository
	 * class is going to be injected.
	 */

	@Autowired
	private CustomerRepository customerRepository;

	// Method to list all customers

	public List<Customer> getAllCustomers() {
		List<Customer> customers = new ArrayList<>();
		customerRepository.findAll().forEach(customers::add);
		return customers;
	}

	// Method to add a new customer

	public void addCustomer(Customer customer) {
		customerRepository.save(customer);
	}

	// Method to find a customer by id

	public Optional<Customer> getCustomer(Long id) {
		return customerRepository.findById(id);
	}

	// Method to update a customer

	public void updateCustomer(Long id, Customer customer) {
		customerRepository.save(customer);
	}

	// Method to delete a customer

	public void deleteCustomer(Long id) {
		customerRepository.deleteById(id);
	}

}
