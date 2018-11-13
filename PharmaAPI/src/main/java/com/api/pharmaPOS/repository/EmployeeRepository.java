package com.api.pharmaPOS.repository;

import org.springframework.data.repository.CrudRepository;
import com.api.pharmaPOS.entity.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

}
