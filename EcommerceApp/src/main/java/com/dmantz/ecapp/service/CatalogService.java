package com.dmantz.ecapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.dmantz.ecapp.dao.CatalogDAO;
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
        cresObj.setFilterCriteria(creqObj.getFilterCriteria());
        cresObj.setProducts(creqObj.getProducts());
		return cresObj;
	}
	public List product() {
		System.out.println("entered into product() method in class CatalogService. ");
		//CatalogDAO catalogDAOObj=new CatalogDAO();
		catalogDAO.showMenu();
		System.out.println("exit from CatalogService class.");
		return null;
	}
}
