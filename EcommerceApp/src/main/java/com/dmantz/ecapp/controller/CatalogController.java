package com.dmantz.ecapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dmantz.ecapp.common.Product;
import com.dmantz.ecapp.request.CatalogRequest;
import com.dmantz.ecapp.response.CatalogResponse;
import com.dmantz.ecapp.service.CatalogService;

@RestController
public class CatalogController {
	
	@Autowired
	CatalogService catalogService;
	
	
	@RequestMapping(value="ec/product",method=RequestMethod.POST) 
	public CatalogResponse product(@RequestBody CatalogRequest catalogReq) {
		System.out.println("this is CatalogController's catalog(.) method. ");
	    	
		/* CatalogService cs=new CatalogService();
	    ProductInfo pi=cs.catalog(productInfo); */
		
		//CatalogService catalogserviceObj=new CatalogService();
         
		return catalogService.product(catalogReq);
	}
   @RequestMapping(value="ec/catalog",method=RequestMethod.POST)
   public CatalogResponse catalog(@RequestBody CatalogRequest catalogReq) {
	  
	System.out.println(" you have entered into product(.) method in class CatalogController.");
    //CatalogService catalogServiceObj=new CatalogService();
   ArrayList products=(ArrayList)catalogService.catalog(catalogReq);
    CatalogResponse catalogResponse=new CatalogResponse();
    catalogResponse.setProducts(products);
	return catalogResponse;
   }
}
