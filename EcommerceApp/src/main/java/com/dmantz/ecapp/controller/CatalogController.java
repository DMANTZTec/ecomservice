package com.dmantz.ecapp.controller;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.swing.plaf.metal.MetalIconFactory.FolderIcon16;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dmantz.ecapp.common.Product;
import com.dmantz.ecapp.dao.FilterCatalogDAO;

import com.dmantz.ecapp.request.CatalogRequest;
import com.dmantz.ecapp.response.CatalogResponse;
import com.dmantz.ecapp.service.CatalogService;
import com.dmantz.ecapp.service.DisplayImageService;
import com.dmantz.ecapp.service.FilterCatalogService;
import com.dmantz.ecapp.service.InsertImageService;



@RestController

@CrossOrigin(origins="http://192.168.100.27:4200")
public class CatalogController {
	
	@Autowired
	CatalogService catalogService;
	
	@Autowired
	FilterCatalogService filterCatalog;
	
	@Autowired
	InsertImageService insertImageService;
	
	@Autowired
	DisplayImageService displayImageService;
	
	
	Logger logger=LoggerFactory.getLogger(CatalogController.class);
	
	
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
	  
	logger.info(" you have entered into product(.) method in class CatalogController.");
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
   
  
   @RequestMapping(value="ec/filterCatalog/{catalog_id}",method=RequestMethod.POST)
   public CatalogResponse filterCatalog(@PathVariable("catalog_id") int catalog_id) {
		  logger.info("this is CatalogController class's filterCatalog(.) method. ");
	
	   
		ArrayList products=(ArrayList)filterCatalog.filter(catalog_id);
	    CatalogResponse catalogResponse=new CatalogResponse();
	    catalogResponse.setProducts(products);
		return catalogResponse;
	   }
   
   
//=========================================


@RequestMapping(value="ec/insertImage",method=RequestMethod.POST)
public void insertImage(@RequestParam("product_sku_image_id") String product_sku_image_id,@RequestParam("product_sku_id") String product_sku_id,@RequestParam("url") String img_url,@RequestParam("imagePath") String image) throws IOException {
		logger.info("entered into insertImage() method.");  
       	
	   insertImageService.insertImage(product_sku_image_id,product_sku_id,img_url,image);
		
	   }

//=====================================================
@RequestMapping(value="ec/displayImage/{id}",method=RequestMethod.POST)
public ResponseEntity<byte[]> displayImage(@PathVariable("id") String imgId) throws Exception	{
	return displayImageService.displayImage(imgId);
}
}

