package com.api.pharmaPOS.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.api.pharmaPOS.entity.Employee;
import com.api.pharmaPOS.repository.EmployeeRepository;

@Service

public class EmployeeService {

	/*
	 * When Spring creates an instance of EmployeeService, the EmployeeRepository
	 * class is going to be injected.
	 */

	@Autowired
	private EmployeeRepository employeeRepository;

	// Method to list all employees

	public List<Employee> getAllEmployees() {
		List<Employee> employees = new ArrayList<>();
		employeeRepository.findAll().forEach(employees::add);
		return employees;
	}

	public List<Employee> getEmployeeByFirstName(String name) {
		List<Employee> employees = new ArrayList<>();
		employeeRepository.getEmployeeByFirstName(name).forEach(employees::add);
		return employees;
	}

	// Method to add a new employee

	public void addEmployee(Employee employee) {
		employeeRepository.save(employee);
	}

	// Method to find an employee by id

	public Optional<Employee> getEmployee(int id) {
		return employeeRepository.findById(id);
	}

	// Method to update an employee

	public void updateEmployee(int id, Employee employee) {
		employeeRepository.save(employee);
	}

	// Method to delete an employee

	public void deleteEmployee(int id) {
		employeeRepository.deleteById(id);
	}

	public Optional<Employee> getEmployeeByEmailandPasswordUser(String email, String password) {
		return employeeRepository.getEmployeeByEmailandPasswordUser(email, password);
	}

}
