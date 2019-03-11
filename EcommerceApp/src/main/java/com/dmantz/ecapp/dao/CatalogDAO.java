package com.dmantz.ecapp.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dmantz.ecapp.common.Product;




@Repository
public class CatalogDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
 
    
	
	
	public List<Product> showMenu() {
		System.out.println("entered into showMenu() method of class CatalogDAO");		
		System.out.println("JdbcTemplate object is: " +jdbcTemplate);
	 
		//String query=" select * from catalog";
	    //String query=" select p.product_id,p.product_desc,p.search_tag,s.product_id,s.price_amt,s.url from product p,product_sku s where p.product_id=s.product_id";

	 
	 
	 
	 /*	
	String query = "SELECT p.product_id,p.product_name,psku.url,psku.price_amt,psku.product_sku_id, \r\n" +
			"o.option_name,o.option_value \r\n" +
			 "FROM product p INNER JOIN product_sku psku on p.product_id=psku.product_id \r\n" +
			 "INNER JOIN product_sku_option pskuo on pskuo.product_sku_id=psku.product_sku_id \r\n" + 
			 "INNER JOIN options o ON o.option_id=pskuo.option_id;" ;

	List results=jdbcTemplate.queryForList(query); */
	 	
		System.out.println("exit from CatalogDAO class");
		
		
		return null;
		}
}
