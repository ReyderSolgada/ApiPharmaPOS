package com.api.pharmaPOS.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.api.pharmaPOS.entity.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {
	String query="select * from product where Description like ?1%";

	@Query(value = query, nativeQuery = true)
	 Collection<Product> getProductByDescription(String name);
}
