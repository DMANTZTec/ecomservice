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
@Table(name = "product_sku")
@Data
@NoArgsConstructor
@ToString()
public class Sku {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int productSkuId;

	private String imageUrl;

	private double price;
	private int productId;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "optionId", referencedColumnName = "productSkuId")

	List<Options> options;

	public int getProductSkuId() {
		return productSkuId;
	}

	public void setProductSkuId(int productSkuId) {
		this.productSkuId = productSkuId;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public List<Options> getOptions() {
		return options;
	}

	public void setOptions(List<Options> options) {
		this.options = options;
	}

}