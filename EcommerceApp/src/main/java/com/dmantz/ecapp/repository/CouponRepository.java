package com.dmantz.ecapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dmantz.ecapp.common.Coupon;
@Repository
public interface CouponRepository extends JpaRepository<Coupon,Integer> {
Coupon findByCouponCode(String couponCode);

}
