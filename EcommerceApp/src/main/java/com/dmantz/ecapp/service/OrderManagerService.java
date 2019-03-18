package com.dmantz.ecapp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dmantz.ecapp.common.Order;
//import com.dmantz.ecapp.common.Order;
import com.dmantz.ecapp.dao.OrderRepository;
import com.dmantz.ecapp.request.CreateOrderRequestPO;
import com.dmantz.ecapp.response.OrderResponse;

import ch.qos.logback.core.net.SyslogOutputStream;

@Service
public class OrderManagerService {
	
	@Autowired
	OrderRepository orderRepository;
	

	public OrderResponse createOrder(int order_Id, CreateOrderRequestPO createOrderRequestPO) {
		
		Order order = new Order();
		
		order.setOrderItemObj(createOrderRequestPO.getOrderItemObj());
		order.setCustomerId(createOrderRequestPO.getCustomerId());
		OrderResponse orderResponse = null;
/*
		System.out.println("orderid is"+order_Id);
		System.out.println(orderRepository.existsById(order_Id));
		
         if(orderRepository.existsById(order_Id)) {
        	 
        	 //order_id exists then update the object
        	 
        	 System.out.println("orderId exists");
        	 System.out.println("update the row");
        	 Optional<CreateOrderRequestPO> retrievedorder=orderRepository.findById(order_Id);
        	 CreateOrderRequestPO order= retrievedorder.get();
        	 order.getOrderItemObj().get(0).setQuantity(createOrderRequestPO.getOrderItemObj().get(0).getQuantity());
        	 CreateOrderRequestPO updatedOrder= orderRepository.save(order);
        	 orderResponse.setOrderId(updatedOrder.getId());
        	 orderResponse.setStatus("order updated");
        	 System.out.println(order.toString());
        	 
        	 
         }
         
         else
        	 
         {
        	 //orderid not exists ,save the object
        	 
        	 System.out.println("order id not exists");
        	 System.out.println("save the object");
        	 Order orderFromDB= orderRepository.save(createOrderRequestPO);	 
        	 orderResponse.setStatus("your items added to cart");
        	 orderResponse.setOrderId(createOrderRequest.getId());
        	 
        	 System.out.println("response object is"+orderResponse.toString());
        	
         }
         */
         return orderResponse;
		
		
	}

	public  OrderResponse createOrder2(CreateOrderRequestPO createOrderRequestPO) {
		

		Order order = new Order();	
		OrderResponse orderResponse=new OrderResponse();
		order.setOrderItemObj(createOrderRequestPO.getOrderItemObj());
		order.setCustomerId(createOrderRequestPO.getCustomerId());
		order.setId(createOrderRequestPO.getId());
		
        	 Order retOrder= orderRepository.save(order);
        	 orderResponse.setOrderId(retOrder.getId());
        	 orderResponse.setStatus("item added ");
        	// createOrderRequestPO.setId(retOrder.getId());
        	// createOrderRequestPO.setOrderItemObj(retOrder.getOrderItemObj());
        	// return createOrderRequestPO;
        	 
        	 return orderResponse;
        	 
	}


	public String deleteOrder(int order_id) {
			
		//orderRepository.delete(order);
		orderRepository.deleteById(order_id);
		///orderRepository.deleteById(order.);
		
				return "order deleted successfully";
	}

	public Order getOrder(int order_id) {
		Optional<Order> retOrder=orderRepository.findById(order_id);
		Order obj=retOrder.get();
				return obj;
	}

}
