package com.api.pharmaPOS.repository;

import org.springframework.data.repository.CrudRepository;
import com.api.pharmaPOS.entity.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {

}
