package com.dmantz.ecapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dmantz.ecapp.repository.ProductCatalogDirRepository;
import com.dmantz.ecapp.request.ProductCatalogDir;

@RestController
public class ProductCatalogDirController {
	
	@Autowired
	private ProductCatalogDirRepository productCatalogDirRepository;
	
	
	@PostMapping("/addPCD")
	public String addProductCatalogDir(@RequestBody ProductCatalogDir productCatalogDir) {
		 productCatalogDirRepository.save(productCatalogDir);
		 return "ProductCatalogDir Added succefully";
	}

}
