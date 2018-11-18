package com.api.pharmaPOS.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.api.pharmaPOS.entity.Customer;
import com.api.pharmaPOS.service.CustomerService;

@RestController
@RequestMapping("/api")

public class CustomerController {

	@Autowired
	private CustomerService customerService;

	// Method to get all customers

	@GetMapping(value = "/CustomerList", headers = "Accept=application/json")
	public ResponseEntity<List<Customer>> getAllCustomers() {
		List<Customer> lista = new ArrayList<Customer>();
		lista = customerService.getAllCustomers();

		return new ResponseEntity<List<Customer>>(lista, HttpStatus.OK);
	}

	// Method to get customers by id

	@RequestMapping("/Customer/{id}")
	public Optional<Customer> getCustomer(@PathVariable Long id) {
		return customerService.getCustomer(id);
	}

	// Method to add a customer

	@RequestMapping(method = RequestMethod.POST, value = "/CustomerAdd")
	public void addCustomer(@RequestBody Customer customer) {
		customerService.addCustomer(customer);
	}

	// Method to update a customer

	@RequestMapping(method = RequestMethod.PUT, value = "/CustomerUpdate/{id}")
	public void updateCustomer(@RequestBody Customer customer, @PathVariable Long id) {
		customerService.updateCustomer(id, customer);
	}

	// Method to delete a customer

	@RequestMapping(method = RequestMethod.DELETE, value = "/CustomerDelete/{id}")
	public void deleteCustomer(@PathVariable Long id) {
		customerService.deleteCustomer(id);
	}

}
