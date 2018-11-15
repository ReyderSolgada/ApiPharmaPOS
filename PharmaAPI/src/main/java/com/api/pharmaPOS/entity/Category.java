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
@Table(name = "Category")

public class Category implements Serializable {

	private static final long serialVersionUID = -1795580679379704894L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CategoryId")
	private int categoryId;

	@Column(name = "Name")
	private String name;

	@JsonIgnore
	@OneToMany(mappedBy = "CategoryProduct")
	private List<Product> listProduct;

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
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
