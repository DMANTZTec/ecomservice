package com.dmantz.ecapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dmantz.ecapp.repository.ProductRepository;
import com.dmantz.ecapp.request.Product;

@RestController
public class ProductController {
	
	@Autowired
	private ProductRepository productRepository;
	
	@PostMapping("/add")
	public String addProduct(@RequestBody Product product) {
		 productRepository.save(product);
		return "Saved Successfully" ;
		
	}

}
