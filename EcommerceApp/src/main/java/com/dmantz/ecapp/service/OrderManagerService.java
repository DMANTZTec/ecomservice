package com.dmantz.ecapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.SystemPropertyUtils;

import com.dmantz.ecapp.common.Order;
import com.dmantz.ecapp.common.OrderItem;
import com.dmantz.ecapp.common.ShippingAddress;
import com.dmantz.ecapp.dao.OrderItemRepository;
//import com.dmantz.ecapp.common.Order;
import com.dmantz.ecapp.dao.OrderRepository;
import com.dmantz.ecapp.dao.ShippingAddressRepository;
import com.dmantz.ecapp.request.CreateOrderRequestPO;
import com.dmantz.ecapp.request.UpdateOrderRequest;
import com.dmantz.ecapp.response.OrderResponse;
import com.dmantz.ecapp.response.UpdateOrderResponse;

@Service
public class OrderManagerService {
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	OrderItemRepository orderItemRepository;
	
	@Autowired
	ShippingAddressRepository shippingAddressRepository;
	
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

	
	
    //service method for updateorder
	public UpdateOrderResponse updateOrder(UpdateOrderRequest updateOrderRequest) {
		
		//if updateOrderRequest.getUpdateQuantity is not null
		//then put logic for updating quantity on order item based on Order/Product SKU.
		UpdateOrderResponse updateOrderResponse=new UpdateOrderResponse();
		if((updateOrderRequest.getUpdateQuantity())!=null) 
			
		{
			//checks for orderid exists in the repository or not
			if(orderRepository.existsById(updateOrderRequest.getOrderId())) 
			{
				logger.info("orderId exists");
	
			//find the orderitem related to order_id and productsku
		       OrderItem oiobj=	orderItemRepository.findByOrderIdAndProductSku(updateOrderRequest.getOrderId(),updateOrderRequest.getUpdateQuantity().getProductSku() );
			   logger.info("obect regarding to productsku and orderid is"+oiobj);
			 //then checks the object if it is not null update the quantity
			   if(oiobj!=null) {
				   //update the quantity
				   oiobj.setQuantity(updateOrderRequest.getUpdateQuantity().getNewQuantity());
				   logger.info("updated quantity object is"+oiobj);
				   orderItemRepository.save(oiobj);
				   updateOrderResponse.setStatus("quantity updated");
			   }
			   
			   
				
				//System.out.println("returned order"+iobj);
			}
			
			
		}
		else if((updateOrderRequest.getAddItem())!=null)
		{
						logger.info("logic for add item");
			
						
						orderItemRepository.findByProductSku("samsung-BK-5");
						logger.info("orderItem corresponds to productsku is"+orderItemRepository.findByProductSku("SAMSUNG-BK-5"));
						//if orderId exists for that customer no need of creating another order ,
						//then add that item to existing order
						
					if((orderRepository.existsById(updateOrderRequest.getOrderId()))) {
						logger.info("orderid exists ");
						Optional<Order> obj=orderRepository.findById(updateOrderRequest.getOrderId());
						Order retOrder=obj.get();
						logger.info("order belongs to orderid is"+retOrder);
						OrderItem iobj=new OrderItem();
						//then add item fields to the orderItemInstance
						iobj.setProductSku(updateOrderRequest.getAddItem().getProductSku());
						iobj.setQuantity(updateOrderRequest.getAddItem().getQuantity());
						iobj.setOrder_id(updateOrderRequest.getOrderId());
						
						logger.info("item object is"+iobj);
						//insert the orderitem to the database
						orderItemRepository.save(iobj);
						updateOrderResponse.setStatus("item added");
						
						//orderRepository.save(retOrder);
						
						
						
						
					}
						
							
		}
		else
		{
			logger.info("nothing");
			updateOrderResponse.setStatus("no updates u given");
		}
		
		//updateOrderResponse.setStatus("success");
					return updateOrderResponse;
	}
	
	//service method for add shippingAddress
		public void addShippingAddressByCustomerId(ShippingAddress shippingAddress) {
				
			System.out.println("shipping Address is"+shippingAddress.toString());
			shippingAddressRepository.save(shippingAddress);
		}
	
	public String deleteOrder(int order_id) {
		
		Optional<Order> order=orderRepository.findById(order_id);
		Order retOrder=order.get();
		orderRepository.delete(retOrder);
		//orderRepository.findOne(Example<Order> example);
	
		///orderRepository.deleteById(order.);
		
				return "order deleted successfully";
	}

}
