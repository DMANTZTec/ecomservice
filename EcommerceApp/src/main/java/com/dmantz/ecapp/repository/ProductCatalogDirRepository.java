package com.dmantz.ecapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dmantz.ecapp.request.ProductCatalogDir;

@Repository
public interface ProductCatalogDirRepository extends JpaRepository<ProductCatalogDir,Integer> {

}
