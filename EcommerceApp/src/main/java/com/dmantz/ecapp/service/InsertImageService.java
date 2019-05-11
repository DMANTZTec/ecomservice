package com.dmantz.ecapp.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dmantz.ecapp.dao.InsertImageDAO;

@Service
public class InsertImageService {
	
	@Autowired
    InsertImageDAO insertImageDAO;

	public void insertImage(String product_sku_image_id,String product_sku_id,String img_url,String image) throws IOException {
		 // byte[]
			 
			 File imgPath = new File(image);
				byte[] fileContent=Files.readAllBytes(imgPath.toPath());
				insertImageDAO.insertImage(product_sku_image_id,product_sku_id,img_url,fileContent);
			}
	}
	

