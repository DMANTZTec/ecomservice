package com.dmantz.ecapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dmantz.ecapp.common.Option;
import com.dmantz.ecapp.common.Product;
import com.dmantz.ecapp.common.ProductSku;
import com.dmantz.ecapp.dao.CatalogDAO;
import com.dmantz.ecapp.dao.ProductDetailRow;
import com.dmantz.ecapp.request.CatalogRequest;
import com.dmantz.ecapp.response.CatalogResponse;



@Service
public class CatalogService {
	

@Autowired
CatalogDAO catalogDAO;
	public CatalogResponse catalog(CatalogRequest catalogReq) {
	    System.out.println("this is CatalogService's catalog(.) method.");
	    CatalogResponse cresObj= new CatalogResponse();
		CatalogRequest creqObj= catalogReq;
        //cresObj.setFilterCriteria(creqObj.getFilterCriteria());
        /*cresObj.setProducts(creqObj.getProducts());*/
		return cresObj;
	}
	public List<Product> product(CatalogRequest catalogReq) {
		System.out.println("entered into product() method in class CatalogService. ");
		
		List<ProductDetailRow> productDetailRow=catalogDAO.showMenu(catalogReq);
		
		
		/*List<ProductDetailRow> filteredProducts=productDetailRow.stream().filter(result -> result.getProductId()==productId ).collect(Collectors.toList());
		*/
		
		//System.out.println("size of filteredProducts are: "+filteredProducts.size());
		/*int i=1;
		List<ProductDetailRow> filteredProducts=null;
		
		for(ProductDetailRow products:productDetailRow) { 
		 
		 
		 
		 
		 filteredProducts=productDetailRow.stream().filter(result -> result.getProductId()==i).collect(Collectors.toList());
		 System.out.println();
		 i++; 
		  
		}
*/		List<Product> list=new ArrayList<Product>();
		
		
		
		
		System.out.println("exit from CatalogService class.");
		return list;
	}
}

