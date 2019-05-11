package com.dmantz.ecapp.dao;

import java.util.HashMap;
import java.util.List;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dmantz.ecapp.common.Product;

@Repository

public class FilterCatalogDAO {
	
	@Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	
	Logger logger=LoggerFactory.getLogger(FilterCatalogDAO.class);
	
	
	public List<ProductDetailRow> filter(int catalog_id) {
		logger.info("you have entered class FilterCatalogDAO's filter(.) method.");
		
		String query = "SELECT p.product_id,p.product_name,psku.url,psku.price_amt,psku.product_sku_id,psku.product_sku_cd, \r\n" +
				"o.option_name,o.option_value \r\n" +
				 "FROM product p INNER JOIN product_sku psku on p.product_id=psku.product_id \r\n" +
				 "INNER JOIN product_sku_option pskuo on pskuo.product_sku_id=psku.product_sku_id \r\n" + 
			 "INNER JOIN options o ON o.option_id=pskuo.option_id \r\n"+
				 "INNER JOIN product_catalog_dir pcd ON p.product_id=pcd.catalog_id where catalog_id=:catalog_id";
	     
	String query_filter_criteria="";
		
		
	    HashMap paramMap=new HashMap();                 	
		paramMap.put("product_id",1);
		paramMap.put("catalog_id", catalog_id);
		
		List<ProductDetailRow> results=namedParameterJdbcTemplate.query(query,paramMap, new BeanPropertyRowMapper<ProductDetailRow>(ProductDetailRow.class));
		 	System.out.println("size of results: "+results.size());
	        
		  /*Iterator iterator=results.iterator();       
	        while(iterator.hasNext()) {
	        	ProductDetailRow productDetailRow = (ProductDetailRow)iterator.next();
	            System.out.println("rows are: "+productDetailRow.getProductId()+" "+productDetailRow.getOptionName()+" "+productDetailRow.optionValue+" "+productDetailRow.getPriceAmt());
	       
	       }
	*/		
		 	logger.info("exit from CatalogDAO class");
			return results;
	
	}
}
