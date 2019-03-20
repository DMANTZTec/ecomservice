package com.dmantz.ecapp.request;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "product")
@Data
@NoArgsConstructor
@ToString()
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int productId;

	private String productName;

	private String productDesc;

	private String searchTag;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "productId", referencedColumnName = "productId")
	List<Sku> SKU;

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	public String getSearchTag() {
		return searchTag;
	}

	public void setSearchTag(String searchTag) {
		this.searchTag = searchTag;
	}

	public List<Sku> getSKU() {
		return SKU;
	}

	public void setSKU(List<Sku> sKU) {
		SKU = sKU;
	}

}