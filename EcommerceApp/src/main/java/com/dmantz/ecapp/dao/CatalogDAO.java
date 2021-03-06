package com.dmantz.ecapp.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.LinkedCaseInsensitiveMap;

import com.dmantz.ecapp.common.FilterCriteria;
import com.dmantz.ecapp.common.Product;
import com.dmantz.ecapp.request.CatalogRequest;




@Repository
public class CatalogDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
 
    
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	public List<ProductDetailRow> getProductList(CatalogRequest catalogReq) {
		System.out.println("entered into getProductList() method of class CatalogDAO");		
		System.out.println("JdbcTemplate object is: " +jdbcTemplate);
	    System.out.println("NamedParameterJdbcTemplate object is: "+namedParameterJdbcTemplate);
		//String query=" select * from catalog";
	    //String query=" select p.product_id,p.product_desc,p.search_tag,s.product_id,s.price_amt,s.url from product p,product_sku s where p.product_id=s.product_id";

	 Integer catalogId=catalogReq.getFilterCriteria().getCatalogId();
	//System.out.println("value of catalogId is: "+catalogId);
	 
	 HashMap paramMap=null;
	String query="SELECT p.product_id,p.product_name,psku.url,psku.price_amt,psku.product_sku_id,psku.product_sku_cd, \r\n" +
			"o.option_name,o.option_value \r\n" +
			 "FROM product p INNER JOIN product_sku psku on p.product_id=psku.product_id \r\n" +
			 "INNER JOIN product_sku_option pskuo on pskuo.products_sku_id=psku.product_sku_id \r\n" + 
			 "INNER JOIN options o ON o.option_id=pskuo.option_id" ; 
	 
     FilterCriteria fc=catalogReq.getFilterCriteria();
    String filterEnabled=fc.getFilterEnabled();
    System.out.println("value of catalogId is "+catalogId+" and value of filterEnabled is "+filterEnabled);
	
	
	
	
	if(catalogId==null || catalogId==0) {	 
	   query=query;       
     paramMap=new HashMap();             	
	 paramMap.put("product_id",1);
	
	
	 }
	
	else {
	    query=query+" INNER JOIN product_catalog_dir pcd ON p.product_id=pcd.catalog_id where catalog_id=:catalog_id";
	    paramMap=new HashMap();             	
		paramMap.put("catalog_id",catalogId);
	 }
	
	
	 
	 List<ProductDetailRow> results=namedParameterJdbcTemplate.query(query,paramMap, new BeanPropertyRowMapper<ProductDetailRow>(ProductDetailRow.class));
	 	System.out.println("size of results: "+results.size());
        
	  /*Iterator iterator=results.iterator();       
        while(iterator.hasNext()) {
        	ProductDetailRow productDetailRow = (ProductDetailRow)iterator.next();
            System.out.println("rows are: "+productDetailRow.getProductId()+" "+productDetailRow.getOptionName()+" "+productDetailRow.optionValue+" "+productDetailRow.getPriceAmt());
       
       }
*/		
	 	System.out.println("exit from CatalogDAO class");
		return results;
		}
}
