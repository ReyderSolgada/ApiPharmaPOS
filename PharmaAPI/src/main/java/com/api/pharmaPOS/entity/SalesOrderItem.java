package com.api.pharmaPOS.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "SalesOrderItem")

public class SalesOrderItem implements Serializable {

	private static final long serialVersionUID = 6258432831235789616L;

	@EmbeddedId
	private SalesOrderItemPK pk;

	@Column(name = "Quantity")
	private int quantity;

	@Column(name = "UnitPrice")
	private double unitPrice;

	@ManyToOne
	@JoinColumn(name = "SalesOrderItemId", referencedColumnName = "SalesOrderId", insertable = false, updatable = false)
	private SalesOrder SalesOrderSalesOrderItem;

	@ManyToOne
	@JoinColumn(name = "ProductId", referencedColumnName = "ProductId", insertable = false, updatable = false)
	private Product ProductSalesOrderItem;

	public SalesOrderItemPK getPk() {
		return pk;
	}

	public void setPk(SalesOrderItemPK pk) {
		this.pk = pk;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public SalesOrder getSalesOrderSalesOrderItem() {
		return SalesOrderSalesOrderItem;
	}

	public void setSalesOrderSalesOrderItem(SalesOrder salesOrderSalesOrderItem) {
		SalesOrderSalesOrderItem = salesOrderSalesOrderItem;
	}

	public Product getProductSalesOrderItem() {
		return ProductSalesOrderItem;
	}

	public void setProductSalesOrderItem(Product productSalesOrderItem) {
		ProductSalesOrderItem = productSalesOrderItem;
	}

}
