package com.dmantz.ecapp.controller;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.swing.plaf.metal.MetalIconFactory.FolderIcon16;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dmantz.ecapp.common.Product;
import com.dmantz.ecapp.request.CatalogRequest;
import com.dmantz.ecapp.response.CatalogResponse;
import com.dmantz.ecapp.service.CatalogService;



@RestController

@CrossOrigin(origins="http://192.168.0.100:4200")
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
  
   
   @RequestMapping(value = "/image/{id}", method = RequestMethod.GET,produces = MediaType.IMAGE_JPEG_VALUE)
   public ResponseEntity<byte[]> getImage(@PathVariable("id") String pathVarNumber) throws IOException {
	   
	   
	  
	   ClassLoader classLoader= getClass().getClassLoader(); 
	   File folder=new File(classLoader.getResource("images").getFile());
	   File[] fileNames=folder.listFiles();
	   System.out.println("list of files are: "+fileNames.length);
	   
	   String relativePath=null;
	   for(File fn:fileNames) {
	   String fileName=fn.getName();
	   if(fileName.contains(pathVarNumber)) {
		System.out.println(fileName); 
	     relativePath=fileName;
	   }
	   
	   }
       
	   
	   
	   ClassPathResource imgFile = new ClassPathResource("images/"+relativePath);
        byte[] bytes = StreamUtils.copyToByteArray(imgFile.getInputStream());

       return ResponseEntity
               .ok()
               .contentType(MediaType.IMAGE_JPEG)
               .body(bytes);
   }
   
}
