package com.api.pharmaPOS.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "SalesOrder")

public class SalesOrder implements Serializable {

	private static final long serialVersionUID = -8607805496267950560L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "OrderId")
	private int orderId;

	@Column(name = "Serial")
	private String serial;

	@Column(name = "OrderDate")
	@Temporal(TemporalType.DATE)
	private Date orderDate;

	@ManyToOne
	@JoinColumn(name = "CustomerId")
	private Customer CustomerSalesOrder;

	@ManyToOne
	@JoinColumn(name = "EmployeeId")
	private Employee EmployeeSalesOrder;

	@Column(name = "State")
	private String State;

	@OneToMany(mappedBy = "SalesOrderSalesOrderItem")
	private List<SalesOrderItem> listSalesOrderItem;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Customer getCustomerSalesOrder() {
		return CustomerSalesOrder;
	}

	public void setCustomerSalesOrder(Customer customerSalesOrder) {
		CustomerSalesOrder = customerSalesOrder;
	}

	public Employee getEmployeeSalesOrder() {
		return EmployeeSalesOrder;
	}

	public void setEmployeeSalesOrder(Employee employeeSalesOrder) {
		EmployeeSalesOrder = employeeSalesOrder;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}

	public List<SalesOrderItem> getListSalesOrderItem() {
		return listSalesOrderItem;
	}

	public void setListSalesOrderItem(List<SalesOrderItem> listSalesOrderItem) {
		this.listSalesOrderItem = listSalesOrderItem;
	}

}
