package com.dmantz.ecapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dmantz.ecapp.request.CreateSignUpRequestPO;
import com.dmantz.ecapp.service.UserManagerService;

@RestController
public class UserController {
	
	@Autowired
	UserManagerService userManagerServiceObj;
	
	
	@RequestMapping(value="/signUp",method=RequestMethod.POST)
	public CreateSignUpRequestPO createSignUp(@RequestBody CreateSignUpRequestPO CreateSignUpRequestPOObj) {
		
		return userManagerServiceObj.createSignUp(CreateSignUpRequestPOObj);
	}

}
