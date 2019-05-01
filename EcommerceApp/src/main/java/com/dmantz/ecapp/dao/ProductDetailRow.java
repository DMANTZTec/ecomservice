
package com.dmantz.ecapp.dao;

public class ProductDetailRow {

	public Integer parentCatalogId;
	public Integer level;
	public Integer catalog_id;
	Integer productId;
	String productName;
	String url;
	Integer priceAmt;
	Integer productSkuId;
	String productSkuCd;
	String optionName;
	String optionValue;

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Integer getCatalog_id() {
		return catalog_id;
	}

	public void setCatalog_id(Integer catalog_id) {
		this.catalog_id = catalog_id;
	}

	public String getProductSkuCd() {
		return productSkuCd;
	}

	public void setProductSkuCd(String productSkuCd) {
		this.productSkuCd = productSkuCd;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getPriceAmt() {
		return priceAmt;
	}

	public void setPriceAmt(Integer priceAmt) {
		this.priceAmt = priceAmt;
	}

	public Integer getProductSkuId() {
		return productSkuId;
	}

	public void setProductSkuId(Integer productSkuId) {
		this.productSkuId = productSkuId;
	}

	public String getOptionName() {
		return optionName;
	}

	public void setOptionName(String optionName) {
		this.optionName = optionName;
	}

	public String getOptionValue() {
		return optionValue;
	}

	public void setOptionValue(String optionValue) {
		this.optionValue = optionValue;
	}

	public Integer getParentCatalogId() {
		return parentCatalogId;
	}

	public void setParentCatalogId(Integer parentCatalogId) {
		this.parentCatalogId = parentCatalogId;
	}

}
