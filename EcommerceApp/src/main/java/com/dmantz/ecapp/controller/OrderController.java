package com.dmantz.ecapp.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dmantz.ecapp.common.Coupon;
//import com.dmantz.ecapp.common.Employee;
import com.dmantz.ecapp.common.Order;
import com.dmantz.ecapp.common.ShippingAddress;
//import com.dmantz.ecapp.dao.EmployeeRepository;
import com.dmantz.ecapp.repository.CouponRepository;
import com.dmantz.ecapp.request.CouponRequest;
import com.dmantz.ecapp.request.CreateOrderRequestPO;
import com.dmantz.ecapp.request.UpdateOrderRequest;
//import com.dmantz.ecapp.response.EmployeeResponse;
import com.dmantz.ecapp.response.OrderResponse;
import com.dmantz.ecapp.response.UpdateOrderResponse;
import com.dmantz.ecapp.response.ViewOrderResponse;
import com.dmantz.ecapp.service.OrderManagerService;

@RestController
@RequestMapping(value="/EcommerceApp")

@CrossOrigin(origins = "http://192.168.100.27:4200")

//@CrossOrigin("http://localhost:4200")

public class OrderController {
	
	@Autowired
	OrderManagerService orderManagerService;
	
	@Autowired
	CouponRepository couponRepository;
	
	//@Autowired
	//EmployeeRepository rep;
	
	
	
   
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
	public ViewOrderResponse viewOrderByOrderId(@RequestParam("order_id") int order_id) {
		return orderManagerService.getOrder(order_id);
		
	}
	
	//Request mapping for add shippingaddress
	@PostMapping(value="/addShippingAddress")
	public String addShippingAddress(@RequestBody ShippingAddress shippingAddress) {
		return orderManagerService.addShippingAddressByCustomerId(shippingAddress);
		
	}
	
	//Request mapping for get all ShippingAddresses
	@GetMapping(value="/viewShippingAddresses")
	public List<ShippingAddress> getShippingAddressOfCustomer(@RequestParam("customerId") String customerId) {
		
		return orderManagerService.getShippingAddressByCustomerId(customerId);
	}
	//Request mapping for coupons
	@RequestMapping(value="/applyCouponCode",method=RequestMethod.POST)
	public String applyCouponCode(@RequestBody CouponRequest couponRequest)
	{
		return orderManagerService.applyCouponCode(couponRequest);
	}
	
	//Request mapping for updateOrderByQuantity
	@PutMapping(value="/updateOrder")
	public UpdateOrderResponse updateOrder(@RequestBody UpdateOrderRequest updateOrderRequest)
	{
		 return orderManagerService.updateOrder( updateOrderRequest);
				
	}
	@RequestMapping(value="/createCoupon",method=RequestMethod.POST)
	public String createCoupon(@RequestBody Coupon coupon)
	{
		couponRepository.save(coupon);
		return "coupon data inserted"; 
		

	}
	
	//mapping for deleteOrder
	@RequestMapping(value="/deleteOrder",method=RequestMethod.DELETE)
	public void deleteOrder(@RequestParam("order_id") int order_id)
	{
		 orderManagerService.deleteOrder(order_id);
		
	}
	/* @PostMapping(value="/saveEmployee")
	 public EmployeeResponse save(@RequestBody Employee emp) {
		 EmployeeResponse employeeResponse=new EmployeeResponse();
		 logger.info("obj is"+emp);
		 
		 rep.save(emp);
		 employeeResponse.setResponse("object saved successfully");
		 return employeeResponse;
	 }
		
	 @PutMapping(value="/updateEmployee/{id}")
	 public EmployeeResponse update(@RequestBody Employee emp,@PathVariable("id") int id ) 
	 {
		 logger.info("obj is"+emp);
		 EmployeeResponse employeeResponse=new EmployeeResponse();
		 Optional<Employee> emp1=rep.findById(id);
		 Employee retEmp= emp1.get();
		 retEmp.setId(emp.getId());
		 retEmp.setName(emp.getName());
		 retEmp.setMobileNo(emp.getMobileNo());
		Employee obj= rep.save(retEmp);
		System.out.println("obj saved successfully"+obj);
		employeeResponse.setResponse("updated successfully");
		return employeeResponse;

	 }
	 
	 @DeleteMapping(value="/deleteMapping/{id}")
	 public EmployeeResponse delete(@PathVariable("id") int id) {
		 EmployeeResponse employeeResponse=new EmployeeResponse();
		 rep.deleteById(id);
		  employeeResponse.setResponse("deleted");
		  return employeeResponse;
	 }*/

}
