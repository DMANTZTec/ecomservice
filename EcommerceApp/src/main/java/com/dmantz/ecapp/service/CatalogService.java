package com.dmantz.ecapp.service;

import java.util.ArrayList;
import java.util.Iterator;
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
        cresObj.setProducts(creqObj.getProducts());
		return cresObj;
	}
	public List<Product> product(CatalogRequest catalogReq) {
		System.out.println("entered into product() method in class CatalogService. ");
		//CatalogDAO catalogDAOObj=new CatalogDAO();
		
		
		List<ProductDetailRow> productDetailRow=catalogDAO.showMenu(catalogReq);
		System.out.println("productDetailRows are: "+productDetailRow);
		List<ProductDetailRow> filteredProducts=productDetailRow.stream().filter(result -> result.getProductId()==1).collect(Collectors.toList());
		System.out.println("filteredProducts are: "+filteredProducts);
	    Product product=null;
	    ProductSku productSku=null;
	    Option option=null;
	    ArrayList listTwo=new ArrayList();
	    ArrayList listThree=new ArrayList();
	    for(ProductDetailRow pdrOne:filteredProducts) {
			//System.out.println("size of pdr: "+pdr.getProductId()+" "+pdr.getProductName());
			product=new Product();
			product.setProductId(pdrOne.getProductId());
						
			productSku=new ProductSku();     
			productSku.setImage(pdrOne.getUrl());
			
			option=new Option();
			option.setOptionName(pdrOne.getOptionName());
			   option.setOptionValue(pdrOne.getOptionValue());
			   listThree.add(option);
			productSku.setOptions(listThree);			
			listTwo.add(productSku);
		    product.setProductSkus(listTwo);
			
		   
		}
		List<Product> list=new ArrayList<Product>();
		list.add(product);
		
		//getting all products
		
		System.out.println("exit from CatalogService class.");
		return list;
	}
}
