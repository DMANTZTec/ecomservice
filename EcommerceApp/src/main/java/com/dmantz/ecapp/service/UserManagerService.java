package com.dmantz.ecapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.dmantz.ecapp.common.User;
import com.dmantz.ecapp.dao.UserRepository;
import com.dmantz.ecapp.request.CreateSignUpRequestPO;

@Service
public class UserManagerService {

	@Autowired
	UserRepository userRepositoryObj;


	

	public  User createSignUp(@RequestBody CreateSignUpRequestPO createSignUpRequestPOObj) {

		User userObj = new User();
		
		
		userObj.setUser_id(createSignUpRequestPOObj.getUser_id());
		userObj.setName(createSignUpRequestPOObj.getName());
		userObj.setEmail_id(createSignUpRequestPOObj.getEmail_id());
		userObj.setPhone_number(createSignUpRequestPOObj.getPhone_number());
		userObj.setPassword(createSignUpRequestPOObj.getPassword());

		return userRepositoryObj.save(userObj);

		//return userRepositoryObj.findById(createSignUpRequestPOObj.getUser_id());
		//return userRepositoryObj.findAll();
	}

	public User updateName(@RequestBody CreateSignUpRequestPO createSignUpRequestPOObj) {
		
		User userObj = new User();
		
		userObj.setUser_id(createSignUpRequestPOObj.getUser_id());
		userObj.setName(createSignUpRequestPOObj.getName());
		userObj.setEmail_id(createSignUpRequestPOObj.getEmail_id());
		userObj.setPhone_number(createSignUpRequestPOObj.getPhone_number());
		userObj.setPassword(createSignUpRequestPOObj.getPassword());
		
		
		Optional<User> updateObj = userRepositoryObj.findById(userObj.getUser_id());
		User userUpdate = updateObj.get();
		userUpdate.setName(createSignUpRequestPOObj.getName());
		//update.setEmail_id(createSignUpRequestPOObj.getEmail_id());
		//update.setPassword(createSignUpRequestPOObj.getPassword());
		return 	userRepositoryObj.save(userUpdate);
		//return userRepositoryObj.save(createSignUpRequestPOObj);

	}
}

