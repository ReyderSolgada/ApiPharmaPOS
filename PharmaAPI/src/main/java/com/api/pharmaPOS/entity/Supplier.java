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
@Table(name = "Supplier")

public class Supplier implements Serializable {

	private static final long serialVersionUID = -7123232746201388565L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SupplierId")
	private int supplierId;

	@Column(name = "Name")
	private String name;

	@Column(name = "Address")
	private String address;

	@Column(name = "Email")
	private String email;

	@Column(name = "Phone")
	private String phone;

	@JsonIgnore
	@OneToMany(mappedBy = "SupplierProduct")
	private List<Product> listProduct;

	public int getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<Product> getListProduct() {
		return listProduct;
	}

	public void setListProduct(List<Product> listProduct) {
		this.listProduct = listProduct;
	}

}
