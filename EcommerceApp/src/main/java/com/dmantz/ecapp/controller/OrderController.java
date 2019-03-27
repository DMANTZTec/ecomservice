package com.dmantz.ecapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dmantz.ecapp.common.Order;
import com.dmantz.ecapp.common.ShippingAddress;
import com.dmantz.ecapp.request.CreateOrderRequestPO;
import com.dmantz.ecapp.request.UpdateOrderRequest;
import com.dmantz.ecapp.response.OrderResponse;
import com.dmantz.ecapp.service.OrderManagerService;

@RestController
@RequestMapping(value="/EcommerceApp")

public class OrderController {
	
	@Autowired
	OrderManagerService orderManagerService;
   
	private static final Logger logger=LoggerFactory.getLogger(OrderController.class);
	
	@PostMapping(value="/saveOrder")
	public Order saveOrder(@RequestBody CreateOrderRequestPO createOrderRequestPO) 
	{
				return orderManagerService.saveOrder(createOrderRequestPO);
		
	}
	
		
	//mapping for createOrder2request
	@RequestMapping(value="/createOrder2",method=RequestMethod.POST)
	public OrderResponse createOrder2(@RequestBody CreateOrderRequestPO createOrderRequestPO) 
	{


		logger.info("request object is"+createOrderRequestPO);		
		return orderManagerService.createOrder2(createOrderRequestPO) ;
		
	}
	
	//mapping for viewOrder
	@GetMapping(value="/viewOrder")
	public Order viewOrderByOrderId(@RequestParam("order_id") int order_id) {
		return orderManagerService.getOrder(order_id);
		
	}
	
	//Request mapping for add shippingaddress
	@PostMapping(value="/addShippingAddress")
	public String addShippingAddress(@RequestBody ShippingAddress shippingAddress) {
		orderManagerService.addShippingAddressByCustomerId(shippingAddress);
		return  "hello";
	}
	
	//Request mapping for updateOrderByQuantity
	@PutMapping(value="/updateOrder")
	public String updateOrder(@RequestBody UpdateOrderRequest updateOrderRequest)
	{
		 return orderManagerService.updateOrder( updateOrderRequest);
				
	}
	
	//mapping for deleteOrder
	@RequestMapping(value="/deleteOrder",method=RequestMethod.DELETE)
	public void deleteOrder(@RequestParam("order_id") int order_id)
	{
		 orderManagerService.deleteOrder(order_id);
		
	}
}
