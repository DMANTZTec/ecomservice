package com.dmantz.ecapp.dao;

import java.io.ByteArrayInputStream;
import java.sql.Types;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.support.SqlLobValue;
import org.springframework.jdbc.support.lob.DefaultLobHandler;
import org.springframework.stereotype.Repository;

@Repository
public class InsertImageDAO {

	 @Autowired
	    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
    public void insertImage(String product_sku_image_id,String product_sku_id,String img_url,byte[] imageData) {
    	MapSqlParameterSource in = new MapSqlParameterSource();
	      in.addValue("product_sku_image_id", product_sku_image_id);
	      in.addValue("product_sku_id", product_sku_id);
	      in.addValue("img_url", img_url);
	      in.addValue("image",  new SqlLobValue(new ByteArrayInputStream(imageData), 
	         imageData.length, new DefaultLobHandler()), Types.BLOB);

	     
	     String SQL="insert into product_sku_image (product_sku_image_id,product_sku_id,img_url,image) values (:product_sku_image_id,:product_sku_id,:img_url,:image )";
	      System.out.println("namedParameterJdbcTemplate object is: "+namedParameterJdbcTemplate);
	      
	      
	      namedParameterJdbcTemplate.update(SQL, in);
    }
}
