package com.api.pharmaPOS.repository;

import org.springframework.data.repository.CrudRepository;
import com.api.pharmaPOS.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
