package com.dmantz.ecapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dmantz.ecapp.common.Order;
import com.dmantz.ecapp.request.CreateOrderRequestPO;
import com.dmantz.ecapp.response.OrderResponse;
import com.dmantz.ecapp.service.OrderManagerService;

@RestController
@RequestMapping(value="/EcommerceApp")
public class OrderController {
	
	@Autowired
	OrderManagerService orderManagerService;

	@RequestMapping(value="/createOrder/{orderId}",method=RequestMethod.POST)
	public OrderResponse createOrder(@PathVariable("orderId") int orderId,@RequestBody CreateOrderRequestPO createOrderRequestPO) {
		System.out.println("oderid is"+orderId);
		System.out.println("controller method called");
		System.out.println("request object is"+createOrderRequestPO);
		return orderManagerService.createOrder(orderId,createOrderRequestPO) ;
		
			}
	
	@RequestMapping(value="/createOrder2",method=RequestMethod.POST)
	public OrderResponse createOrder2(@RequestBody CreateOrderRequestPO createOrderRequestPO) {


		System.out.println("request object is"+createOrderRequestPO);		
		return orderManagerService.createOrder2(createOrderRequestPO) ;
		
	}
	
	@GetMapping(value="/getOrder")
	
	public Order getOrder(@RequestParam("order_id") int order_id) {
		return orderManagerService.getOrder(order_id);
		
	}
	
	
	
	@RequestMapping(value="/deleteOrder",method=RequestMethod.DELETE)
	public String deleteOrder(@RequestParam("order_id") int order_id) {
		//System.out.println("order id is"+order.getId());
		
		return orderManagerService.deleteOrder(order_id);
		
	}
}