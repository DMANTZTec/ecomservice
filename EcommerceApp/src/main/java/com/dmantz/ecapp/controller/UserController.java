package com.dmantz.ecapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dmantz.ecapp.common.User;
import com.dmantz.ecapp.dao.UserRepository;
import com.dmantz.ecapp.request.CreateSignUpRequestPO;
import com.dmantz.ecapp.service.UserManagerService;


@RestController
public class UserController {
	
	@Autowired
	UserManagerService userManagerServiceObj;

	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public  User register(@RequestBody CreateSignUpRequestPO createSignUpRequestPOObj) {
		 return userManagerServiceObj.createSignUp(createSignUpRequestPOObj);
	
	}

	@RequestMapping(value="/updateName",method=RequestMethod.PUT)
	public User updateName(@RequestBody CreateSignUpRequestPO createSignUpRequestPOObj) {
		
		return userManagerServiceObj.updateName(createSignUpRequestPOObj);
	}
	
//	@GetMapping(value="/getting/{Id}")
//	public Optional<User> findById(@PathVariable(value="Id") Integer user_id) {
//		return userRepositoryObj.findById(user_id);
//	}
	
//	@RequestMapping(value="/update",method=RequestMethod.PUT)
//	public CreateSignUpRequestPO update(@RequestBody CreateSignUpRequestPO createSignUpRequestPOObj) {
//		return userManagerServiceObj.update(createSignUpRequestPOObj);
//	}
	
	//update name
	
	//public CreateSignUpRequestPO updateName
	//update email
	//update phone number 
	//update password
	
	
	
	
//	@RequestMapping(value="/register",method=RequestMethod.POST)
//	public String register(@RequestBody CreateSignUpRequestPO createSignUpRequestPOObj) {
//		userRepositoryObj.save(createSignUpRequestPOObj);
//		return "data inserted in the table";
//		
//	}

//	@RequestMapping(value="/findAll")
//	public List<CreateSignUpRequestPO>findAll() {
//		return userRepositoryObj.findAll();
//	}
//	
//	@RequestMapping(value="/addOrSave", method=RequestMethod.POST)
//	public CreateSignUpRequestPO save(@RequestBody CreateSignUpRequestPO createSignUpRequestPOObj) {
//		
//		return userRepositoryObj.save(createSignUpRequestPOObj);
//		
//	}
//	

}
