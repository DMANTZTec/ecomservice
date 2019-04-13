
package com.dmantz.ecapp.common;

import java.util.ArrayList;

public class ProductSku {

Integer sku;
ArrayList<Option> options;
String Image;
String price;
String productSkuCode;

public String getImage() {

	return Image;
}
public void setImage(String image) {

	Image = image;
}

public String getProductSkuCode() {
	return productSkuCode;
}
public void setProductSkuCode(String productSkuCode) {
	this.productSkuCode = productSkuCode;
}
public Integer getSku() {
	return sku;
}
public void setSku(Integer sku) {
	this.sku = sku;
}
public ArrayList<Option> getOptions() {
	return options;
}
public void setOptions(ArrayList<Option> options) {
	this.options = options;
}
public String getPrice() {
	return price;
}
public void setPrice(String price) {
	this.price = price;
}



}

