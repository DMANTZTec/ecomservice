package com.dmantz.ecapp.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.SystemPropertyUtils;

import com.dmantz.ecapp.common.AddItem;
import com.dmantz.ecapp.common.Coupon;
import com.dmantz.ecapp.common.Order;
import com.dmantz.ecapp.common.OrderCoupon;
import com.dmantz.ecapp.common.OrderItem;
import com.dmantz.ecapp.common.OrderShippingAddress;
import com.dmantz.ecapp.common.ShippingAddress;
import com.dmantz.ecapp.dao.OrderItemRepository;
//import com.dmantz.ecapp.common.Order;
import com.dmantz.ecapp.dao.OrderRepository;
import com.dmantz.ecapp.dao.ShippingAddressRepository;
import com.dmantz.ecapp.repository.CouponRepository;
import com.dmantz.ecapp.repository.OrderCouponRepository;
import com.dmantz.ecapp.repository.OrderShiipingAddressRepo;
import com.dmantz.ecapp.request.CouponRequest;
import com.dmantz.ecapp.request.CreateOrderRequestPO;
import com.dmantz.ecapp.request.UpdateOrderRequest;
import com.dmantz.ecapp.response.OrderResponse;
import com.dmantz.ecapp.response.UpdateOrderResponse;
import com.dmantz.ecapp.response.ViewOrderResponse;

import ch.qos.logback.core.net.SyslogOutputStream;

@Service
public class OrderManagerService {
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	CouponRepository couponRepository;
	
	@Autowired
	OrderCouponRepository orderCouponRepository;
	
	@Autowired
	OrderItemRepository orderItemRepository;
	
	@Autowired
	ShippingAddressRepository shippingAddressRepository;
	
	@Autowired
	OrderShiipingAddressRepo orderShiipingAddressRepo;
	
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


	

	public ViewOrderResponse getOrder(int order_id) {
		
		ViewOrderResponse viewOrderResponse=new ViewOrderResponse();
		Optional<Order> retOrder=orderRepository.findById(order_id);
		Order order=retOrder.get();
		List<OrderItem> orderItem=order.getOrderItemObj();
		double totalAmount=0;
		double price;
		for(OrderItem o:orderItem) {
			int quantity=Integer.parseInt(o.getQuantity());
				
			price=(quantity*o.getPrice());
			totalAmount=totalAmount+price;
		}
		logger.info("total amount"+totalAmount);
		Optional<ShippingAddress> retShippingAddress=shippingAddressRepository.findById(order.getShippingAddressId());
		ShippingAddress shippingAddress=retShippingAddress.get();
		viewOrderResponse.setOrder(order);
		viewOrderResponse.setShippingAddress(shippingAddress);
		viewOrderResponse.setTotalAmount(totalAmount);
		return viewOrderResponse;
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
			
			if(orderRepository.existsById(updateOrderRequest.getOrderId())) 
			{
				logger.info("orderId exists");
	
			
		       OrderItem oiobj=	orderItemRepository.findByOrderIdAndProductSku(updateOrderRequest.getOrderId(),updateOrderRequest.getUpdateQuantity().getProductSku() );
			   logger.info("obect regarding to productsku and orderid is"+oiobj);
			 
			   if(oiobj!=null) {
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
			
				//if orderId exists for that customer no need of creating another order ,
				//then add that item to existing order
				OrderItem orderItem=orderItemRepository.findByOrderIdAndProductSku(updateOrderRequest.getOrderId(), updateOrderRequest.getAddItem().getOrderItem().getProductSku());
				System.out.println(orderItem);	
				if(orderItem!=null) 
				{
					logger.info("entry exists");
					
					orderItem.setProductId(updateOrderRequest.getAddItem().getOrderItem().getProductId());
				    orderItem.setPrice(updateOrderRequest.getAddItem().getOrderItem().getPrice());
				    orderItem.setProductName(updateOrderRequest.getAddItem().getOrderItem().getProductName());
				    orderItem.setQuantity(updateOrderRequest.getAddItem().getOrderItem().getQuantity());
				    orderItem.setGiftWrapped(updateOrderRequest.getAddItem().getOrderItem().getGiftWrapped());
				    orderItem.setMrpPrice(updateOrderRequest.getAddItem().getOrderItem().getMrpPrice());
				    orderItem.setDiscountApplied(updateOrderRequest.getAddItem().getOrderItem().getDiscountApplied());
				    orderItemRepository.save(orderItem);
				    updateOrderResponse.setStatus("orderitem object updated bcz productsku exists for that order");
				}
				else 
				{
										
					OrderItem orderItemReq=updateOrderRequest.getAddItem().getOrderItem();
					orderItemReq.setOrder_id(updateOrderRequest.getOrderId());
					orderItemRepository.save(orderItemReq);
					updateOrderResponse.setStatus("item added");
				}
						
		}
		else
		{
			logger.info("no updates you given");
			updateOrderResponse.setStatus("no updates u given");
		}
		
		//updateOrderResponse.setStatus("success");
					return updateOrderResponse;
	}
	
	//service method for add shippingAddress
		public String addShippingAddressByCustomerId(ShippingAddress shippingAddress) {
				
			logger.info("shipping Address is"+shippingAddress.toString());
			//if shipping address exists for customer then update the shippingAddress 
			//else save the new shipping address
			if((shippingAddress.getId())!=0){
				
				logger.info("update logic");
				logger.info("update the address");
				
				
			ShippingAddress sobj=	shippingAddressRepository.findByCustomerIdAndId(shippingAddress.getCustomerId(),shippingAddress.getId() );
			if(sobj!=null) {
				shippingAddressRepository.save(shippingAddress);
			}
			else {
				logger.error("please enter valid customerid and shippingid");
			}
			
			
			}
			else {
				//logger.info("else excuted");
				logger.info("new address");
				OrderShippingAddress orderShippingAddress=new OrderShippingAddress();
				ShippingAddress retrivedShippingAddress=shippingAddressRepository.save(shippingAddress);
				orderShippingAddress.setCustomerId(retrivedShippingAddress.getCustomerId());
				orderShippingAddress.setShippingAddressId(retrivedShippingAddress.getId());
				orderShiipingAddressRepo.save(orderShippingAddress);
								
			}
				
			
			//shippingAddressRepository.save(shippingAddress);
			return "shipping Address added";
		}
		
		
		public List<ShippingAddress> getShippingAddressByCustomerId(String customerId) {
			return shippingAddressRepository.findByCustomerId(customerId);
}
	
	public String deleteOrder(int order_id) {
		
		Optional<Order> order=orderRepository.findById(order_id);
		// orderItemRepository.delete(entity);
		
		Order retOrder=order.get();
		
		orderRepository.delete(retOrder);
		//orderRepository.findOne(Example<Order> example);
	
		///orderRepository.deleteById(order.);
		
				return "order deleted successfully";
	}

	public String applyCouponCode(CouponRequest couponRequest)
	{
		
		if(couponRepository.existsByCouponCode(couponRequest.getCouponCode())) 
		{
			System.out.println("coupon exists");
			Coupon c=couponRepository.findByCouponCode(couponRequest.getCouponCode());
			logger.info("coupon object is"+c);
			
			Date currentDate=new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); 
			String str=formatter.format(currentDate);
			
			
			int min=currentDate.compareTo(c.getStartingDate());
			
			int max=currentDate.compareTo(c.getEndingDate());
			if((min==1)&&(max==-1))
			{
				logger.info("coupon valid");
				OrderCoupon orderCoupon=new OrderCoupon();
				orderCoupon.setCouponId(c.getCouponId());
				orderCoupon.setOrderId(couponRequest.getOrderId());
				orderCouponRepository.save(orderCoupon);
				
				return "coupon success";
				
			}
			else {
				logger.info("coupon expired");
				return "coupon expired";
			}
			
			
		}else 
		{
			logger.info("coupon not exists");
			return "coupon invalid";
		}
		
	}

	

	
}
