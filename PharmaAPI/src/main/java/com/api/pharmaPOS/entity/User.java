package com.api.pharmaPOS.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "User")

public class User implements Serializable {

	private static final long serialVersionUID = 5642999794722889688L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "UserId")
	private int userId;

	@Column(name = "State")
	private boolean State;

	@ManyToOne
	@JoinColumn(name = "EmployeeId")
	private Employee EmployeeUser;

	@Column(name = "Email")
	private String email;

	@Column(name = "Password")
	private String password;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public boolean isState() {
		return State;
	}

	public void setState(boolean state) {
		State = state;
	}

	public Employee getEmployeeUser() {
		return EmployeeUser;
	}

	public void setEmployeeUser(Employee employeeUser) {
		EmployeeUser = employeeUser;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
