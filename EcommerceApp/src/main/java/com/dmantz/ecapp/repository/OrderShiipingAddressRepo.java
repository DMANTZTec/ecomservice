package com.dmantz.ecapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dmantz.ecapp.common.OrderShippingAddress;

public interface OrderShiipingAddressRepo extends JpaRepository<OrderShippingAddress,Integer> {

}
