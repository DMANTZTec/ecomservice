<<<<<<< HEAD
package com.dmantz.ecapp.dao;

public class ProductDetailRow {

	Integer productId;
	String productName;
	String url;
	Integer priceAmt;
	Integer productSkuId;
	String productSkuCd;
	String optionName;
	String optionValue;

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

	public boolean increment(ProductDetailRow pdr) {
		if (this.equals(pdr) == false)
			return false;
		else
			return true;
	}

	public boolean equals(Object o) {
		ProductDetailRow pdr = (ProductDetailRow) o;
		return this.getProductId() == pdr.getProductId();
	}

	public String getProductSkuCd() {
		return productSkuCd;
	}

	public void setProductSkuCd(String productSkuCd) {
		this.productSkuCd = productSkuCd;
	}

}
=======
package com.dmantz.ecapp.dao;

public class ProductDetailRow {

	Integer productId;
	String productName;
	String url;
	Integer priceAmt;
	Integer productSkuId;
	String productSkuCd;
	String optionName;
	String optionValue;

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

}
>>>>>>> da44116197849e9205aef4f3f28f7fcc66f058df
