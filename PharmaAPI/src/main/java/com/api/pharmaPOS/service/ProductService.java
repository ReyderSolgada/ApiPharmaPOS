package com.api.pharmaPOS.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.api.pharmaPOS.entity.Product;
import com.api.pharmaPOS.repository.ProductRepository;

@Service

public class ProductService {

	/*
	 * When Spring creates an instance of ProductService, the ProductRepository
	 * class is going to be injected.
	 */

	@Autowired
	private ProductRepository productRepository;

	// Method to list all products

	public List<Product> getAllProducts() {
		List<Product> products = new ArrayList<>();
		productRepository.findAll().forEach(products::add);
		return products;
	}
	public List<Product> getProductByDescription(String name){
		List<Product> products = new ArrayList<>();
		productRepository.getProductByDescription(name).forEach(products::add);
		return products;
	}

	// Method to add a new product

	public void addProduct(Product product) {
		productRepository.save(product);
	}

	// Method to find a product by id

	public Optional<Product> getProduct(int id) {
		return productRepository.findById(id);
	}

	// Method to update a product

	public void updateProduct(int id, Product product) {
		productRepository.save(product);
	}

	// Method to delete a product

	public void deleteProduct(int id) {
		productRepository.deleteById(id);
	}

}
