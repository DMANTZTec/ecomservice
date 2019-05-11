package com.dmantz.ecapp.request;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product_sku_option")
public class ProductSkuOptions {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int productSkuOptionsId;

	public int getProductSkuOptionsId() {
		return productSkuOptionsId;
	}

	public void setProductSkuOptionsId(int productSkuOptionsId) {
		this.productSkuOptionsId = productSkuOptionsId;
	}

}
