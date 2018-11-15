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
@Table(name = "Laboratory")

public class Laboratory implements Serializable {

	private static final long serialVersionUID = -3026070034801928622L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "LaboratoryId")
	private int laboratoryId;

	@Column(name = "Name")
	private String name;

	@JsonIgnore
	@OneToMany(mappedBy = "LaboratoryProduct")
	private List<Product> listProduct;

	public int getLaboratoryId() {
		return laboratoryId;
	}

	public void setLaboratoryId(int laboratoryId) {
		this.laboratoryId = laboratoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Product> getListProduct() {
		return listProduct;
	}

	public void setListProduct(List<Product> listProduct) {
		this.listProduct = listProduct;
	}

}
