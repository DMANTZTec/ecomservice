package com.dmantz.ecapp.request;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
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
public class ProductSkuRO {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int productSkuId;

	private String imageUrl;

	private double price;

	
	private int productId;

	private String productSkuCd;

	
	

	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "product_sku_option", joinColumns = @JoinColumn(name ="product_sku_id"), inverseJoinColumns = @JoinColumn(name = "option_id"))
	@JoinColumn(name = "optionId", referencedColumnName = "productSkuId")
	List<OptionsRO> options;

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

	public List<OptionsRO> getOptions() {
		return options;
	}

	public void setOptions(List<OptionsRO> options) {
		this.options = options;
	}

	public String getProductSkuCd() {
		return productSkuCd;
	}

	public void setProductSkuCd(String productSkuCd) {
		this.productSkuCd = productSkuCd;
	}

}