package com.dmantz.ecapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dmantz.ecapp.dao.OrderRepository;
import com.dmantz.ecapp.request.CreateOrderRequestPO;
import com.dmantz.ecapp.response.OrderResponse;

@Service
public class OrderManagerService {
	
	@Autowired
	OrderRepository orderRepository;
	
  
	//@Autowired
	OrderResponse orderResponseObj=new OrderResponse();
	

	public OrderResponse createOrder(CreateOrderRequestPO createOrderRequestPOObj) {
		orderRepository.save(createOrderRequestPOObj);	
		CreateOrderRequestPO orderObj=orderRepository.save(createOrderRequestPOObj);
		if((orderObj.getCustomerId()).equals("null")){
			orderResponseObj.setStatus("please enter customerId");
			orderResponseObj.setOrderId(orderObj.getOrderId());
			System.out.println("response object is"+orderResponseObj.toString());
						return orderResponseObj;
		}
		else {
			orderResponseObj.setStatus("your Item added to cart");
			orderResponseObj.setOrderId(orderObj.getOrderId());
			System.out.println("response object is"+orderResponseObj.toString());
			return orderResponseObj;
		}
				//System.out.println(obj.getCustomerId());
		
		
	}

}
