package com.dmantz.ecapp.controller;

import org.aspectj.weaver.loadtime.Options;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dmantz.ecapp.common.Product;
import com.dmantz.ecapp.repository.OptionsRepository;
import com.dmantz.ecapp.repository.ProductRepository;
import com.dmantz.ecapp.request.ProductRO;

@RestController
public class ProductController {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private OptionsRepository optionsRepository;

	@PostMapping("/addproduct")
	public String addProduct(@RequestBody ProductRO product) {
		productRepository.save(product);
		return "Saved Successfully";

	}

	@PostMapping("/addoptions")
	public String createProductOption(@RequestBody Options options) {
		optionsRepository.save(options);
		return "saved Successfully";

	}

}
