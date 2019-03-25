
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

//SAVE METHOD 
	public User createSignUp(@RequestBody CreateSignUpRequestPO createSignUpRequestPOObj) {

		User userObj = new User();

		userObj.setUser_id(createSignUpRequestPOObj.getUser_id());
		userObj.setFirstName(createSignUpRequestPOObj.getFirstName());
		userObj.setLastName(createSignUpRequestPOObj.getLastName());
		userObj.setEmail_id(createSignUpRequestPOObj.getEmail_id());
		userObj.setPassword(createSignUpRequestPOObj.getPassword());

		return userRepositoryObj.save(userObj);

		// return userRepositoryObj.findById(createSignUpRequestPOObj.getUser_id());
		// return userRepositoryObj.findAll();
	}

//UPDATE FIRST NAME
	public User updateFirstName(@RequestBody CreateSignUpRequestPO createSignUpRequestPOObj) {

		User userObj = new User();

		userObj.setUser_id(createSignUpRequestPOObj.getUser_id());
		userObj.setEmail_id(createSignUpRequestPOObj.getEmail_id());
		userObj.setFirstName(createSignUpRequestPOObj.getFirstName());
		userObj.setLastName(createSignUpRequestPOObj.getLastName());
		userObj.setPassword(createSignUpRequestPOObj.getPassword());

		Optional<User> updateObj = userRepositoryObj.findById(userObj.getUser_id());
		User userUpdate = updateObj.get();
		userUpdate.setFirstName(createSignUpRequestPOObj.getFirstName());
		// update.setEmail_id(createSignUpRequestPOObj.getEmail_id());
		// update.setPassword(createSignUpRequestPOObj.getPassword());
		return userRepositoryObj.save(userUpdate);
		// return userRepositoryObj.save(createSignUpRequestPOObj);

	}

//UPDATE LAST NAME
	public User updateLastName(@RequestBody CreateSignUpRequestPO createSignUpRequestPOObj) {

		User userObj = new User();

		userObj.setUser_id(createSignUpRequestPOObj.getUser_id());
		userObj.setEmail_id(createSignUpRequestPOObj.getEmail_id());
		userObj.setFirstName(createSignUpRequestPOObj.getFirstName());
		userObj.setLastName(createSignUpRequestPOObj.getLastName());
		userObj.setPassword(createSignUpRequestPOObj.getPassword());

		Optional<User> updateObj = userRepositoryObj.findById(userObj.getUser_id());
		User userUpdate = updateObj.get();
		userUpdate.setLastName(createSignUpRequestPOObj.getLastName());
		;

		return userRepositoryObj.save(userUpdate);

	}

//UPDATE EMAIL_ID
	public User updateEmailId(@RequestBody CreateSignUpRequestPO createSignUpRequestPOObj) {

		User userObj = new User();

		userObj.setUser_id(createSignUpRequestPOObj.getUser_id());
		userObj.setEmail_id(createSignUpRequestPOObj.getEmail_id());
		userObj.setFirstName(createSignUpRequestPOObj.getFirstName());
		userObj.setLastName(createSignUpRequestPOObj.getLastName());
		userObj.setPassword(createSignUpRequestPOObj.getPassword());

		Optional<User> updateObj = userRepositoryObj.findById(userObj.getUser_id());
		User userUpdate = updateObj.get();
		userUpdate.setEmail_id(createSignUpRequestPOObj.getEmail_id());

		return userRepositoryObj.save(userUpdate);

	}

//UPDATE PASSWORD	
	public User updatePassword(@RequestBody CreateSignUpRequestPO createSignUpRequestPOObj) {

		User userObj = new User();

		userObj.setUser_id(createSignUpRequestPOObj.getUser_id());
		userObj.setEmail_id(createSignUpRequestPOObj.getEmail_id());
		userObj.setFirstName(createSignUpRequestPOObj.getFirstName());
		userObj.setLastName(createSignUpRequestPOObj.getLastName());
		userObj.setPassword(createSignUpRequestPOObj.getPassword());

		Optional<User> updateObj = userRepositoryObj.findById(userObj.getUser_id());
		User userUpdate = updateObj.get();
		userUpdate.setPassword(createSignUpRequestPOObj.getPassword());

		return userRepositoryObj.save(userUpdate);

	}

	public String deleteUser(CreateSignUpRequestPO createSignUpRequestPOObj) {
		
		User userObj = new User();

		userObj.setUser_id(createSignUpRequestPOObj.getUser_id());
		userObj.setEmail_id(createSignUpRequestPOObj.getEmail_id());
		userObj.setFirstName(createSignUpRequestPOObj.getFirstName());
		userObj.setLastName(createSignUpRequestPOObj.getLastName());
		userObj.setPassword(createSignUpRequestPOObj.getPassword());

		Optional<User> deleteObj = userRepositoryObj.findById(userObj.getUser_id());
		User deleteUser = deleteObj.get();
		userRepositoryObj.delete(deleteUser);
		return "deleted";
	}

}
