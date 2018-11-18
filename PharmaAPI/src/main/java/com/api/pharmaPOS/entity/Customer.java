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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Customer")

public class Customer implements Serializable {

	private static final long serialVersionUID = 599396647275854919L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CustomerId")
	private Long CustomerId;

	@Column(name = "FirstName")
	private String firstName;

	@Column(name = "MiddleName")
	private String middleName;

	@Column(name = "LastName")
	private String lastName;

	@Column(name = "Sex")
	private String sex;

	@Column(name = "RUC")
	private String ruc;

	@Column(name = "DNI")
	private String dni;

	@Column(name = "Address")
	private String address;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "DistrictId")
	private District DistrictCustomer;

	@Column(name = "RegisterDate")
	@Temporal(TemporalType.DATE)
	private Date registerDate;

	@Column(name = "Type")
	private String type;

	@JsonIgnore
	@OneToMany(mappedBy = "CustomerSalesOrder")
	private List<SalesOrder> listSalesOrder;

	public Long getCustomerId() {
		return CustomerId;
	}

	public void setCustomerId(Long customerId) {
		CustomerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public District getDistrictCustomer() {
		return DistrictCustomer;
	}

	public void setDistrictCustomer(District districtCustomer) {
		DistrictCustomer = districtCustomer;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<SalesOrder> getListSalesOrder() {
		return listSalesOrder;
	}

	public void setListSalesOrder(List<SalesOrder> listSalesOrder) {
		this.listSalesOrder = listSalesOrder;
	}

}
