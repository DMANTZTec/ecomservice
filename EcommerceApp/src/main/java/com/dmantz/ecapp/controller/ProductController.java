package com.dmantz.ecapp.controller;

import java.util.List;

import javax.validation.Valid;

import org.aspectj.weaver.loadtime.Options;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dmantz.ecapp.repository.OptionsRepository;
import com.dmantz.ecapp.repository.ProductRepository;
import com.dmantz.ecapp.repository.ProductSkuRepository;
import com.dmantz.ecapp.request.ProductRO;
import com.dmantz.ecapp.request.ProductSkuRO;

@RestController
@CrossOrigin(origins ="http://localhost:4200")
public class ProductController {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private OptionsRepository optionsRepository;
	
	@Autowired
	private  ProductSkuRepository productSkuRepository;
	
	@PostMapping(value="/addproduct", consumes = MediaType.APPLICATION_JSON_VALUE, 
		    produces = MediaType.APPLICATION_JSON_VALUE)
	public @Valid ProductRO addProduct(@Valid @RequestBody(required =true) ProductRO product) {
		return productRepository.save(product);
		//return "Saved Successfully";

	}

	@PostMapping("/addoptions")
	public String createProductOption(@RequestBody Options options) {
		optionsRepository.save(options);
		return "saved Successfully";

	}
	@GetMapping("/getAllProducts")
	public List<ProductRO> getAllProducts(){
		return productRepository.findAll();
		
	}
	
	@GetMapping("/getAllSkus")
	public List<ProductSkuRO> getAllSkus() {
		return productSkuRepository.findAll();
	}
}
