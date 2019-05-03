package com.dmantz.ecapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dmantz.ecapp.common.OrderCoupon;

public interface OrderCouponRepository extends JpaRepository<OrderCoupon,Integer>
{


}
