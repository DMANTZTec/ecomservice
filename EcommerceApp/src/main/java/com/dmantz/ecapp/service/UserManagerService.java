
package com.dmantz.ecapp.service;

import java.util.Optional;

//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.dmantz.ecapp.common.User;
import com.dmantz.ecapp.repository.UserRepository;
import com.dmantz.ecapp.request.CreateSignUpRequestPO;

@Service
public class UserManagerService {

	@Autowired
	UserRepository userRepositoryObj;

	//SAVE METHOD 
	public String register(@RequestBody CreateSignUpRequestPO createSignUpRequestPOObj) {

		User userObj = new User();

		userObj.setUser_id(createSignUpRequestPOObj.getUser_id());
		userObj.setFirstName(createSignUpRequestPOObj.getFirstName());
		userObj.setLastName(createSignUpRequestPOObj.getLastName());
		userObj.setEmail_id(createSignUpRequestPOObj.getEmail_id());
		userObj.setPassword(createSignUpRequestPOObj.getPassword());
		userRepositoryObj.save(userObj);

		return "registration Sucessful";
	}
	//GET METHOD by EmailId
	//	public User getUserEId(String email_id) {
	//		Optional<User> retUser = userRepositoryObj.;
	//		User obj = retUser.get();
	//		return obj;
	//	}

	//DELETE METHOD
	public String deleteUser(int user_id) {
		userRepositoryObj.deleteById(user_id);
		return "order deleted successfully";
	}

	//GET METHOD
	public User getUser(int user_id) {
		Optional<User> retUser = userRepositoryObj.findById(user_id);
		User obj = retUser.get();
		return obj;
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

		return userRepositoryObj.save(userUpdate);

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

	//	public User update(@RequestBody CreateSignUpRequestPO createSignUpRequestPOObj) {
	//
	//		User userObj = new User();
	//
	//		userObj.setUser_id(createSignUpRequestPOObj.getUser_id());
	//		userObj.setEmail_id(createSignUpRequestPOObj.getEmail_id());
	//		userObj.setFirstName(createSignUpRequestPOObj.getFirstName());
	//		userObj.setLastName(createSignUpRequestPOObj.getLastName());
	//		userObj.setPassword(createSignUpRequestPOObj.getPassword()); 
	//
	//		Optional<User> updateObj = userRepositoryObj.findById(userObj.getUser_id());
	//		User userUpdate = updateObj.get();
	//		
	//		return "Updated"; 
	//	public void update(@PathVariable Integer user_id, CreateSignUpRequestPO createSignUpRequestPOObj) {
	//		
	//		userRepositoryObj.save(createSignUpRequestPOObj);
	//		
	//	
	//	}
}
