package com.dmantz.ecapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dmantz.ecapp.dao.OrderDao;
import com.dmantz.ecapp.request.CreateOrderRequestPO;

@Service
public class OrderManagerService {
	@Autowired
	OrderDao orderDaoObj;

	public CreateOrderRequestPO createOrder(CreateOrderRequestPO createOrderRequestPOObj) {
				return orderDaoObj.createOrder(createOrderRequestPOObj);
	}

}
