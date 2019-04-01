package com.dmantz.ecapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dmantz.ecapp.common.ShippingAddress;

public interface ShippingAddressRepository extends JpaRepository<ShippingAddress,Integer> {
public ShippingAddress findByCustomerId(String customerId);
public ShippingAddress findByCustomerIdAndId(String customerId,int Id);
}
