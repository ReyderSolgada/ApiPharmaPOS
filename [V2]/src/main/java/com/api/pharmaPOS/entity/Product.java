package com.api.pharmaPOS.entity;

import java.io.Serializable;
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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Product")

public class Product implements Serializable {

	private static final long serialVersionUID = 6836503332520974692L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ProductId")
	private int productId;

	@Column(name = "Description")
	private String description;

	@Column(name = "Price")
	private double price;

	@Column(name = "Stock")
	private int stock;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "CategoryId")
	private Category CategoryProduct;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "SupplierId")
	private Supplier SupplierProduct;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "LaboratoryId")
	private Laboratory LaboratoryProduct;

	@JsonIgnore
	@OneToMany(mappedBy = "ProductSalesOrderItem")
	private List<SalesOrderItem> listSalesOrderItem;

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public Category getCategoryProduct() {
		return CategoryProduct;
	}

	public void setCategoryProduct(Category categoryProduct) {
		CategoryProduct = categoryProduct;
	}

	public Supplier getSupplierProduct() {
		return SupplierProduct;
	}

	public void setSupplierProduct(Supplier supplierProduct) {
		SupplierProduct = supplierProduct;
	}

	public Laboratory getLaboratoryProduct() {
		return LaboratoryProduct;
	}

	public void setLaboratoryProduct(Laboratory laboratoryProduct) {
		LaboratoryProduct = laboratoryProduct;
	}

	public List<SalesOrderItem> getListSalesOrderItem() {
		return listSalesOrderItem;
	}

	public void setListSalesOrderItem(List<SalesOrderItem> listSalesOrderItem) {
		this.listSalesOrderItem = listSalesOrderItem;
	}

}
