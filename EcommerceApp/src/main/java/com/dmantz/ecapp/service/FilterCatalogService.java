package com.dmantz.ecapp.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dmantz.ecapp.common.Option;
import com.dmantz.ecapp.common.Product;
import com.dmantz.ecapp.common.ProductSku;
import com.dmantz.ecapp.dao.FilterCatalogDAO;
import com.dmantz.ecapp.dao.ProductDetailRow;

@Service
public class FilterCatalogService {
	
	@Autowired
	FilterCatalogDAO filterCatalogDAO;
	
	Logger logger=LoggerFactory.getLogger(FilterCatalogService.class);
	
	
	public List<Product> filter(int catalog_id) {
		logger.info(" you have entered into class FilterCatalog's filter(.) method. ");
		
List<ProductDetailRow> productDetailRow=filterCatalogDAO.filter(catalog_id);
		
		
		
		Map<Integer,List<ProductDetailRow>> mappedProducts=null;
		//groupedProducts
		mappedProducts=productDetailRow.stream().collect(Collectors.groupingBy(ProductDetailRow::getProductId));
				
		/*
		for each key in Map {
		
			Create a new Product
			Add product level details using (0)th element of Product Detail Rows
			
			groupedProductSkus:
			
			for each key in Map {
			
				Create a new Product Sku Object
				Add SKU details from (0)th element
				For each row {
					create a new Option Object
					add Option to Product SKU
				}
				Add product SKU to Product
			}
				
					
		
		*/
		
		
		ArrayList retProductList=new ArrayList();
		Product product=null;
		ProductSku sku=null;
		Option option=null;
		int j=0;
		for(Map.Entry<Integer,List<ProductDetailRow>> pro : mappedProducts.entrySet()) {  
		
		ArrayList skuList=new ArrayList();
		
		System.out.println("Number of Products:" + mappedProducts.size());
		product=new Product();
		ProductDetailRow pdr=pro.getValue().get(0);
		product.setProductId(pdr.getProductId());
		product.setProductName(pdr.getProductName());
		Map<Integer,List<ProductDetailRow>> mappedSkus=null;
		mappedSkus=pro.getValue().stream().collect(Collectors.groupingBy(ProductDetailRow::getProductSkuId));
		System.out.println("Number of Rows for Product:" + mappedSkus.size());

		for(Map.Entry<Integer,List<ProductDetailRow>> proSku:mappedSkus.entrySet()) {
			ArrayList options=new ArrayList();
			  sku=new ProductSku();			  
			  ProductDetailRow pdrow=proSku.getValue().get(0);
//			  System.out.println("pdrow product is: "+pdrow.getProductId()+" pdr product is: "+pdr.getProductId());
//			  if(pdr.getProductId()==pdrow.getProductId()) {
//				  
				  System.out.println("inside ProductSku ");
				  sku.setImage(pdrow.getUrl());
				  sku.setPrice(pdrow.getPriceAmt().toString());
				  sku.setSku(pdrow.getProductSkuId());
				//  sku.setProductSkuCode(pdrow.getProductSkuId());
// code for options started
				  Map<String,List<ProductDetailRow>> mappedOptions=null;
					mappedOptions=proSku.getValue().stream().collect(Collectors.groupingBy(ProductDetailRow::getOptionName));
				  for(Map.Entry<String,List<ProductDetailRow>> opt:mappedOptions.entrySet()) {
					option=new Option();
					ProductDetailRow prow=opt.getValue().get(0);
				    System.out.println("inside option's loop ");
				    option.setOptionName(prow.getOptionName());
				    option.setOptionValue(prow.getOptionValue());
				    options.add(option);
				    sku.setOptions(options);
				  }
// code for options	ended		  
				  skuList.add(sku);  
			      	  
//			  }    
                System.out.println("mappedSkus for loop is over and pdrow's productId is: "+pdrow.getProductId());
		  }System.out.println("\n\n");
		 
			  
		  
		  product.setProductSkus(skuList);
		  retProductList.add(product);
		
		}
		
		logger.info("exit from CatalogService class.");
		return retProductList;

		
		
	}}
