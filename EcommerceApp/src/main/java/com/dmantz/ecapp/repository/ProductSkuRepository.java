package com.dmantz.ecapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dmantz.ecapp.request.ProductSkuRO;

public interface ProductSkuRepository extends JpaRepository<ProductSkuRO,Integer> {

}
