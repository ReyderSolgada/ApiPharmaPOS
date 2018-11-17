package com.api.pharmaPOS.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.api.pharmaPOS.entity.SalesOrder;
import com.api.pharmaPOS.service.SalesOrderService;

@RestController
@RequestMapping("/api")
public class SalesOrderController {

	@Autowired
	private SalesOrderService salesOrderService;

	// GET (all)
	@GetMapping("/salesOrder")
	public List<SalesOrder> getAllSalesOrder(){
		return salesOrderService.getAllSalesOrders();
	}
	@RequestMapping(value="/salesOrderDetail",method=RequestMethod.GET,headers="Accept=application/json")
	public ResponseEntity<List<SalesOrder>> listAllSales(){
		List<SalesOrder> lista=new ArrayList<SalesOrder>();
		lista=getAllSalesOrder();

		return  new ResponseEntity<List<SalesOrder>>(lista,HttpStatus.OK);
	}
	// GET (passing an id)

	// POST

	// PUT

	// DELETE
}
