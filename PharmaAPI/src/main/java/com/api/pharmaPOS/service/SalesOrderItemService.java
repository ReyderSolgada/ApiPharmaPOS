package com.api.pharmaPOS.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.api.pharmaPOS.entity.SalesOrderItem;
import com.api.pharmaPOS.repository.SalesOrderItemRepository;

@Service

public class SalesOrderItemService {

	/*
	 * When Spring creates an instance of SalesOrderItemService, the
	 * SalesOrderItemRepository class is going to be injected.
	 */

	@Autowired
	private SalesOrderItemRepository salesOrderItemRepository;

	// Method to list all salesOrderItems

	public List<SalesOrderItem> getAllSalesOrderItems() {
		List<SalesOrderItem> salesOrderItems = new ArrayList<>();
		salesOrderItemRepository.findAll().forEach(salesOrderItems::add);
		return salesOrderItems;
	}

	// Method to add a new salesOrderItem

	public void addSalesOrderItem(SalesOrderItem salesOrderItem) {
		salesOrderItemRepository.save(salesOrderItem);
	}

	// Method to find a salesOrderItem by id

	public Optional<SalesOrderItem> getSalesOrderItem(int id) {
		return salesOrderItemRepository.findById(id);
	}

	// Method to update a salesOrderItem

	public void updateSalesOrderItem(int id, SalesOrderItem salesOrderItem) {
		salesOrderItemRepository.save(salesOrderItem);
	}

	// Method to delete a salesOrderItem

	public void deleteSalesOrderItem(int id) {
		salesOrderItemRepository.deleteById(id);
	}

}
