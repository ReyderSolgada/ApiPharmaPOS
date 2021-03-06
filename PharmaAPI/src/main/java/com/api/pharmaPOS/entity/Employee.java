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

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Employee")
//@JsonRootName(value="Employees")
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
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date hireDate;

	@Column(name = "DNI")
	private String dni;

	@Column(name = "Sex")
	private String sex;

	@Column(name = "Phone")
	private String phone;
	
	@Column(name="Email")
	private String email;

	@Column(name = "Address")
	private String address;
	
	@Column(name="State")
	private boolean state;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "DistrictId")
	private District DistrictEmployee;

	@Column(name = "Salary")
	private double salary;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "JobTitleId")
	private JobTitle JobTitleEmployee;

	@JsonIgnore
	@OneToMany(mappedBy = "EmployeeUser")
	private List<User> listUser;

	@JsonIgnore
	@OneToMany(mappedBy = "EmployeeSalesOrder")
	private List<SalesOrder> listSalesOrder;

	public int getEmployeeId() {
		return employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public String getDni() {
		return dni;
	}

	public String getSex() {
		return sex;
	}

	public String getPhone() {
		return phone;
	}

	public String getEmail() {
		return email;
	}

	public String getAddress() {
		return address;
	}

	public boolean isState() {
		return state;
	}

	public District getDistrictEmployee() {
		return DistrictEmployee;
	}

	public double getSalary() {
		return salary;
	}

	public JobTitle getJobTitleEmployee() {
		return JobTitleEmployee;
	}

	public List<User> getListUser() {
		return listUser;
	}

	public List<SalesOrder> getListSalesOrder() {
		return listSalesOrder;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public void setDistrictEmployee(District districtEmployee) {
		DistrictEmployee = districtEmployee;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public void setJobTitleEmployee(JobTitle jobTitleEmployee) {
		JobTitleEmployee = jobTitleEmployee;
	}

	public void setListUser(List<User> listUser) {
		this.listUser = listUser;
	}

	public void setListSalesOrder(List<SalesOrder> listSalesOrder) {
		this.listSalesOrder = listSalesOrder;
	}

}
