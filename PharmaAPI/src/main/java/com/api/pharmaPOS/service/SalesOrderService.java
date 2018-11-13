package com.api.pharmaPOS.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.api.pharmaPOS.entity.SalesOrder;
import com.api.pharmaPOS.repository.SalesOrderRepository;

@Service

public class SalesOrderService {

	/*
	 * When Spring creates an instance of SalesOrderService, the
	 * SalesOrderRepository class is going to be injected.
	 */

	@Autowired
	private SalesOrderRepository salesOrderRepository;

	// Method to list all salesOrders

	public List<SalesOrder> getAllSalesOrders() {
		List<SalesOrder> salesOrders = new ArrayList<>();
		salesOrderRepository.findAll().forEach(salesOrders::add);
		return salesOrders;
	}

	// Method to add a new salesOrder

	public void addSalesOrder(SalesOrder salesOrder) {
		salesOrderRepository.save(salesOrder);
	}

	// Method to find a salesOrder by id

	public Optional<SalesOrder> getSalesOrder(int id) {
		return salesOrderRepository.findById(id);
	}

	// Method to update a salesOrder

	public void updateSalesOrder(int id, SalesOrder salesOrder) {
		salesOrderRepository.save(salesOrder);
	}

	// Method to delete a salesOrder

	public void deleteSalesOrder(int id) {
		salesOrderRepository.deleteById(id);
	}

}
