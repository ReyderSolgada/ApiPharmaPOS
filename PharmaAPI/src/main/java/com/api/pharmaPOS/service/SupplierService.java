package com.api.pharmaPOS.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.api.pharmaPOS.entity.Supplier;
import com.api.pharmaPOS.repository.SupplierRepository;

@Service

public class SupplierService {

	/*
	 * When Spring creates an instance of SupplierService, the SupplierRepository
	 * class is going to be injected.
	 */

	@Autowired
	private SupplierRepository supplierRepository;

	// Method to list all suppliers

	public List<Supplier> getAllSuppliers() {
		List<Supplier> suppliers = new ArrayList<>();
		supplierRepository.findAll().forEach(suppliers::add);
		return suppliers;
	}

	// Method to add a new supplier

	public void addSupplier(Supplier supplier) {
		supplierRepository.save(supplier);
	}

	// Method to find a supplier by id

	public Optional<Supplier> getSupplier(int id) {
		return supplierRepository.findById(id);
	}

	// Method to update a supplier

	public void updateSupplier(int id, Supplier supplier) {
		supplierRepository.save(supplier);
	}

	// Method to delete a supplier

	public void deleteSupplier(int id) {
		supplierRepository.deleteById(id);
	}

}
