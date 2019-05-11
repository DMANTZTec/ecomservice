package com.dmantz.ecapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dmantz.ecapp.dao.DisplayImageDAO;

@Service
public class DisplayImageService {

	@Autowired
	DisplayImageDAO displayImageDAO;
	
	public ResponseEntity<byte[]> displayImage(String imgId) throws Exception {
	
		
		return displayImageDAO.displayImage(imgId);
	}	

}
