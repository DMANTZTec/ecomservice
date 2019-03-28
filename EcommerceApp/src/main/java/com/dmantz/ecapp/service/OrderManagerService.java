package com.dmantz.ecapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dmantz.ecapp.common.Order;
import com.dmantz.ecapp.common.OrderItem;
import com.dmantz.ecapp.common.ShippingAddress;
//import com.dmantz.ecapp.common.Order;
import com.dmantz.ecapp.dao.OrderRepository;
import com.dmantz.ecapp.request.CreateOrderRequestPO;
import com.dmantz.ecapp.request.UpdateOrderRequest;
import com.dmantz.ecapp.response.OrderResponse;
import com.dmantz.ecapp.response.UpdateOrderResponse;

@Service
public class OrderManagerService {
	
	@Autowired
	OrderRepository orderRepository;
	
	private static final Logger logger=LoggerFactory.getLogger(OrderManagerService.class);

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
		logger.info("input updated object is"+createOrderRequestPO.getOrderItemObj().get(0).getProductName());
		

		Order order = new Order();	
		OrderResponse orderResponse=new OrderResponse();
		order.setOrderItemObj(createOrderRequestPO.getOrderItemObj());
		logger.info("order item object is"+order.getOrderItemObj());
		order.setCustomerId(createOrderRequestPO.getCustomerId());
		order.setId(createOrderRequestPO.getId());
		
		
        	 Order retOrder= orderRepository.save(order);
        	 logger.info("returnedobject"+retOrder.toString());
        	 orderResponse.setOrderId(retOrder.getId());
        	 orderResponse.setStatus("item added ");
        	
        	 
        	 return orderResponse;
        	 
	}


	public String deleteOrder(int order_id) {
			
		Optional<Order> order=orderRepository.findById(order_id);
		Order retOrder=order.get();
		orderRepository.delete(retOrder);
		//orderRepository.findOne(Example<Order> example);
	
		///orderRepository.deleteById(order.);
		
				return "order deleted successfully";
	}

	public Order getOrder(int order_id) {
		Optional<Order> retOrder=orderRepository.findById(order_id);
		Order obj=retOrder.get();
				return obj;
	}

	public Order saveOrder(CreateOrderRequestPO createOrderRequestPO) {
		Order order=new Order();
		order.setCustomerId(createOrderRequestPO.getCustomerId());
		order.setOrderItemObj(createOrderRequestPO.getOrderItemObj());
		Order retOrder=orderRepository.save(order);
				return retOrder;
	}

	//service method for add shippingAddress
	public void addShippingAddressByCustomerId(ShippingAddress shippingAddress) {
			
		
	}
	
    //service method for updateorder
	public UpdateOrderResponse updateOrder(UpdateOrderRequest updateOrderRequest) {
		//if updateOrderRequest.getUpdateQuantity is not null
		//then put logic for updating quantity on order item based on Order/Product SKU.
		UpdateOrderResponse updateOrderResponse=new UpdateOrderResponse();
		if((updateOrderRequest.getUpdateQuantity())!=null) 
			
		{
			List<OrderItem> list=new ArrayList();
			logger.info("logic for update");
			logger.info("update order"+updateOrderRequest.getUpdateQuantity());
			Optional<Order> orderObj=orderRepository.findById(updateOrderRequest.getUpdateQuantity().getOrderId());
			Order order1=orderObj.get();
			System.out.println("returned database objects is"+order1);
			OrderItem orderItemObj=  order1.getOrderItemObj().get(0);
			if((orderItemObj.getProductSku()).equals(updateOrderRequest.getUpdateQuantity().getProductSku()))
					{
				System.out.println("sku matched");
				orderItemObj.setQuantity(updateOrderRequest.getUpdateQuantity().getNewQuantity());
				list.add(orderItemObj);
				order1.setId(order1.getId());
				order1.setOrderItemObj(list);
				System.out.println("saving object "+order1);
				
				orderRepository.save(order1);
							
					}
			
		
		
		updateOrderResponse.setStatus("success");
		updateOrderResponse.setTotalQuantity(updateOrderRequest.getUpdateQuantity().getNewQuantity());
		
		
		
			
			
		}
		else if((updateOrderRequest.getAddItem())!=null) {
						System.out.println("logic for add item");
							}
		else {
			System.out.println("nothing");
		}
		
					return updateOrderResponse;
	}

}
