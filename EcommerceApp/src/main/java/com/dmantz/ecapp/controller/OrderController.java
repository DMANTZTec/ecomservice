package com.dmantz.ecapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dmantz.ecapp.request.CreateOrderRequestPO;
import com.dmantz.ecapp.service.OrderManagerService;

@RestController

public class OrderController {
	@Autowired
	OrderManagerService orderManagerServiceObj;

	@RequestMapping(value="/createOrder",method=RequestMethod.POST)
	public CreateOrderRequestPO createOrder(@RequestBody CreateOrderRequestPO createOrderRequestPOObj) {
		
		return orderManagerServiceObj.createOrder(createOrderRequestPOObj) ;
		
		//this is done to learn git
		//sorry mounika
	}
}
