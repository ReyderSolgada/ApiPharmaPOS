package com.api.pharmaPOS.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.api.pharmaPOS.entity.Supplier;
import com.api.pharmaPOS.service.SupplierService;

@RestController
@RequestMapping("/api")

public class SupplierController {

	// Dependency injection

	@Autowired
	private SupplierService supplierService;

	// Method to get all suppliers

	@RequestMapping(value="/suppliers",method=RequestMethod.GET,headers="Accept=application/json")
	public ResponseEntity<List<Supplier>> getAllSuppliers(){
		List<Supplier> lista=new ArrayList<Supplier>();
		lista= supplierService.getAllSuppliers();

		return  new ResponseEntity<List<Supplier>>(lista,HttpStatus.OK);
	}

	// Method to get suppliers by id

	@RequestMapping("/suppliers/{id}")
	public Optional<Supplier> getSupplier(@PathVariable int id) {
		return supplierService.getSupplier(id);
	}

	// Method to add a supplier

	@RequestMapping(method = RequestMethod.POST, value = "/suppliers")
	public void addSupplier(@RequestBody Supplier supplier) {
		supplierService.addSupplier(supplier);
	}

	// Method to update a supplier

	@RequestMapping(method = RequestMethod.PUT, value = "/suppliers/{id}")
	public void updateSupplier(@RequestBody Supplier supplier, @PathVariable int id) {
		supplierService.updateSupplier(id, supplier);
	}

	// Method to delete a supplier

	@RequestMapping(method = RequestMethod.DELETE, value = "/suppliers/{id}")
	public void deleteSupplier(@PathVariable int id) {
		supplierService.deleteSupplier(id);
	}

}
