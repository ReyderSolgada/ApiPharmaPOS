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
@Table(name = "Employee")

public class Employee implements Serializable {

	private static final long serialVersionUID = -1689763166618120390L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EmployeeId")
	private int employeeId;

	@Column(name = "FirstName")
	private String firstName;

	@Column(name = "MiddleName")
	private String middleName;

	@Column(name = "LastName")
	private String lastName;

	@Column(name = "HireDate")
	@Temporal(TemporalType.DATE)
	private Date hireDate;

	@Column(name = "DNI")
	private String dni;

	@Column(name = "Sex")
	private String sex;

	@Column(name = "Phone")
	private String phone;

	@Column(name = "Address")
	private String address;

	@ManyToOne
	@JoinColumn(name = "DistrictId")
	private District DistrictEmployee;

	@Column(name = "Salary")
	private double salary;

	@ManyToOne
	@JoinColumn(name = "JobTitleId")
	private JobTitle JobTitleEmployee;

	@OneToMany(mappedBy = "EmployeeUser")
	private List<User> listUser;

	@OneToMany(mappedBy = "EmployeeSalesOrder")
	private List<SalesOrder> listSalesOrder;

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
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

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public District getDistrictEmployee() {
		return DistrictEmployee;
	}

	public void setDistrictEmployee(District districtEmployee) {
		DistrictEmployee = districtEmployee;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public JobTitle getJobTitleEmployee() {
		return JobTitleEmployee;
	}

	public void setJobTitleEmployee(JobTitle jobTitleEmployee) {
		JobTitleEmployee = jobTitleEmployee;
	}

	public List<User> getListUser() {
		return listUser;
	}

	public void setListUser(List<User> listUser) {
		this.listUser = listUser;
	}

	public List<SalesOrder> getListSalesOrder() {
		return listSalesOrder;
	}

	public void setListSalesOrder(List<SalesOrder> listSalesOrder) {
		this.listSalesOrder = listSalesOrder;
	}

}
