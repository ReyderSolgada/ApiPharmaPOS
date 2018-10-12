package com.api.pharmaPOS.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable

public class SalesOrderItemPK implements Serializable {

	private static final long serialVersionUID = -7739574480589657865L;

	@Column(name = "SalesOrderItemId")
	private int salesOrderItemId;

	@Column(name = "ProductId")
	private int ProductId;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ProductId;
		result = prime * result + salesOrderItemId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SalesOrderItemPK other = (SalesOrderItemPK) obj;
		if (ProductId != other.ProductId)
			return false;
		if (salesOrderItemId != other.salesOrderItemId)
			return false;
		return true;
	}

	public int getSalesOrderItemId() {
		return salesOrderItemId;
	}

	public void setSalesOrderItemId(int salesOrderItemId) {
		this.salesOrderItemId = salesOrderItemId;
	}

	public int getProductId() {
		return ProductId;
	}

	public void setProductId(int productId) {
		ProductId = productId;
	}

}
