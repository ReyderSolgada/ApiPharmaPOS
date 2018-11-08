package com.api.pharmaPOS.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "District")

public class District implements Serializable {

	private static final long serialVersionUID = -724095859475975457L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DistrictId")
	private int districtId;

	@Column(name = "Name")
	private String name;
	
	@JsonIgnore
	@OneToMany(mappedBy = "DistrictCustomer")
	private List<Customer> listDistrictCustomer;
	
	@JsonIgnore
	@OneToMany(mappedBy = "DistrictEmployee")
	private List<Employee> listDistrictEmployee;

	public int getDistrictId() {
		return districtId;
	}

	public void setDistrictId(int districtId) {
		this.districtId = districtId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Customer> getListDistrictCustomer() {
		return listDistrictCustomer;
	}

	public void setListDistrictCustomer(List<Customer> listDistrictCustomer) {
		this.listDistrictCustomer = listDistrictCustomer;
	}

	public List<Employee> getListDistrictEmployee() {
		return listDistrictEmployee;
	}

	public void setListDistrictEmployee(List<Employee> listDistrictEmployee) {
		this.listDistrictEmployee = listDistrictEmployee;
	}

}
