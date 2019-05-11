package com.dmantz.ecapp.request;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "product_catalog_dir")
public class ProductCatalogDir {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "product_catalog_id")
	private int productCatalogId;

	/*
	 * @ManyToOne(cascade = CascadeType.ALL)
	 * 
	 * @JoinColumn(name = "catalogId", referencedColumnName = "catalogId") private
	 * CatalogRequestObj catalogRequestObj;
	 */
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "productId", referencedColumnName = "productId") private
	ProductRO productRO;
	
	@Column(name = "catalog_id")
	private int catalogId;

	@Column(name = "primary_flg")
	private String primaryFlg;

	public int getProductCatalogId() {
		return productCatalogId;
	}

	public void setProductCatalogId(int productCatalogId) {
		this.productCatalogId = productCatalogId;
	}

	public String getPrimaryFlg() {
		return primaryFlg;
	}

	public void setPrimaryFlg(String primaryFlg) {
		this.primaryFlg = primaryFlg;
	}

	public int getCatalogId() {
		return catalogId;
	}

	public void setCatalogId(int catalogId) {
		this.catalogId = catalogId;
	}

}
