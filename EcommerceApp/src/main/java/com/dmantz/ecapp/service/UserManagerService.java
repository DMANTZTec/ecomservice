
package com.dmantz.ecapp.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.dmantz.ecapp.common.User;
import com.dmantz.ecapp.controller.UserController;
import com.dmantz.ecapp.repository.UserRepository;
import com.dmantz.ecapp.request.CreateSignUpRequestPO;
import com.dmantz.ecapp.request.LoginRequest;
import com.dmantz.ecapp.response.UserRegistrationRes;

@Service
public class UserManagerService {

	@Autowired
	UserRepository userRepositoryObj;

	private static final Logger logger=LoggerFactory.getLogger(UserController.class);

	//SAVE METHOD 
	public UserRegistrationRes register(@RequestBody CreateSignUpRequestPO createSignUpRequestPOObj) {

		User userObj = new User();
		UserRegistrationRes userRegistrationRes=new UserRegistrationRes();

		userObj.setUser_id(createSignUpRequestPOObj.getUser_id());
		userObj.setFirstName(createSignUpRequestPOObj.getFirstName());
		userObj.setLastName(createSignUpRequestPOObj.getLastName());
		userObj.setEmailId(createSignUpRequestPOObj.getEmail_id());
		userObj.setPassword(createSignUpRequestPOObj.getPassword());
		userObj.setMobileNumber(createSignUpRequestPOObj.getMobileNumber());

		userRepositoryObj.save(userObj);
		userRegistrationRes.setStatus("registration Sucessful");
		System.out.println(userRegistrationRes.toString());
		return userRegistrationRes;
	}
	
	//GET METHOD by EmailId
	public User getUserEId(String emailId) {
		User user=userRepositoryObj.findByEmailId(emailId);
		System.out.println(user);
		return user;
	}

	//DELETE METHOD
	public String deleteUser(int user_id) {
		userRepositoryObj.deleteById(user_id);
		return "order deleted successfully";
	}

	//GET ALL METHOD
	public List<User> getAllUser() {
		return userRepositoryObj.findAll();
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
		userObj.setFirstName(createSignUpRequestPOObj.getFirstName());
		userObj.setLastName(createSignUpRequestPOObj.getLastName());
		userObj.setEmailId(createSignUpRequestPOObj.getEmail_id());
		userObj.setPassword(createSignUpRequestPOObj.getPassword());
		userObj.setMobileNumber(createSignUpRequestPOObj.getMobileNumber());

		Optional<User> updateObj = userRepositoryObj.findById(userObj.getUser_id());
		User userUpdate = updateObj.get();
		userUpdate.setFirstName(createSignUpRequestPOObj.getFirstName());

		return userRepositoryObj.save(userUpdate);

	}

	//UPDATE LAST NAME
	public User updateLastName(@RequestBody CreateSignUpRequestPO createSignUpRequestPOObj) {

		User userObj = new User();

		userObj.setUser_id(createSignUpRequestPOObj.getUser_id());
		userObj.setFirstName(createSignUpRequestPOObj.getFirstName());
		userObj.setLastName(createSignUpRequestPOObj.getLastName());
		userObj.setEmailId(createSignUpRequestPOObj.getEmail_id());
		userObj.setPassword(createSignUpRequestPOObj.getPassword());
		userObj.setMobileNumber(createSignUpRequestPOObj.getMobileNumber());

		Optional<User> updateObj = userRepositoryObj.findById(userObj.getUser_id());
		User userUpdate = updateObj.get();
		userUpdate.setLastName(createSignUpRequestPOObj.getLastName());

		return userRepositoryObj.save(userUpdate);

	}

	//UPDATE EMAIL_ID
	public User updateEmailId(@RequestBody CreateSignUpRequestPO createSignUpRequestPOObj) {

		User userObj = new User();

		userObj.setUser_id(createSignUpRequestPOObj.getUser_id());
		userObj.setFirstName(createSignUpRequestPOObj.getFirstName());
		userObj.setLastName(createSignUpRequestPOObj.getLastName());
		userObj.setEmailId(createSignUpRequestPOObj.getEmail_id());
		userObj.setPassword(createSignUpRequestPOObj.getPassword());
		userObj.setMobileNumber(createSignUpRequestPOObj.getMobileNumber());

		Optional<User> updateObj = userRepositoryObj.findById(userObj.getUser_id());
		User userUpdate = updateObj.get();
		userUpdate.setEmailId(createSignUpRequestPOObj.getEmail_id());

		return userRepositoryObj.save(userUpdate);

	}

	//UPDATE PASSWORD	
	public User updatePassword(@RequestBody CreateSignUpRequestPO createSignUpRequestPOObj) {

		User userObj = new User();

		userObj.setUser_id(createSignUpRequestPOObj.getUser_id());
		userObj.setFirstName(createSignUpRequestPOObj.getFirstName());
		userObj.setLastName(createSignUpRequestPOObj.getLastName());
		userObj.setEmailId(createSignUpRequestPOObj.getEmail_id());
		userObj.setPassword(createSignUpRequestPOObj.getPassword());
		userObj.setMobileNumber(createSignUpRequestPOObj.getMobileNumber());

		Optional<User> updateObj = userRepositoryObj.findById(userObj.getUser_id());
		User userUpdate = updateObj.get();
		userUpdate.setPassword(createSignUpRequestPOObj.getPassword());

		return userRepositoryObj.save(userUpdate);

	}
	//UPDATE MOBILE NUMBER
	public User updateMobileNumber(@RequestBody CreateSignUpRequestPO createSignUpRequestPOObj) {

		User userObj = new User();

		userObj.setUser_id(createSignUpRequestPOObj.getUser_id());
		userObj.setFirstName(createSignUpRequestPOObj.getFirstName());
		userObj.setLastName(createSignUpRequestPOObj.getLastName());
		userObj.setEmailId(createSignUpRequestPOObj.getEmail_id());
		userObj.setPassword(createSignUpRequestPOObj.getPassword());
		userObj.setMobileNumber(createSignUpRequestPOObj.getMobileNumber());

		Optional<User> updateObj = userRepositoryObj.findById(userObj.getUser_id());
		User userUpdate = updateObj.get();
		userUpdate.setFirstName(createSignUpRequestPOObj.getFirstName());

		return userRepositoryObj.save(userUpdate);

	}

	//USER LOGIN
	public User userLogin(LoginRequest loginRequest) 
	{
		User userObj=new User();
		try {

			User user = userRepositoryObj.findByEmailIdAndPassword(loginRequest.getEmailId(), loginRequest.getPassword());
			if(user!=null) 
			{
				logger.info("user exists in db");
				user.setLoginStatus("login success");
				return user;

			}
			else 
			{
				logger.info("user not found with that credentials");
				userObj.setLoginStatus("not a valid user please enter valid credentials or else do register");
				return userObj;
			}
		}
		catch(Exception e) 
		{
			logger.error("error"+e);
			return null;
		}
	}

	public String checkExistence(String email_id) {
		
		try 
		{
			if(userRepositoryObj.existsByEmailId(email_id)) 
			{
				return "registerd Email" ;
			
			}else
			{
				return "email not correct please enter your registerd email";
			}
			
			
		}catch(Exception e) {
			logger.error("error desc"+e);
			return "exception occurs";
		}
		
	}

	public UserRegistrationRes resetPassword(CreateSignUpRequestPO createSignUpRequestPO)
	{
		User user=new User();
		UserRegistrationRes userRegistrationRes=new UserRegistrationRes();
		logger.info("ip request object"+createSignUpRequestPO);
		try {
			if(userRepositoryObj.existsByEmailId(createSignUpRequestPO.getEmail_id()))
			{
			user=userRepositoryObj.findByEmailId(createSignUpRequestPO.getEmail_id());
			user.setPassword(createSignUpRequestPO.getPassword());
			User ret=userRepositoryObj.save(user);
			if(ret!=null) 
			{
				logger.info("updated");
				userRegistrationRes.setStatus("reset password successfully");
			}
			else 
			{
				userRegistrationRes.setStatus("user not found in db with that credentials");
			}
			return userRegistrationRes;
			}else {
				userRegistrationRes.setStatus("not registerd email plz login");
				return userRegistrationRes;
			}
 
		}
		catch(Exception e) {
			
			userRegistrationRes.setStatus("exception ocuured");
			logger.error("error "+e);
			return userRegistrationRes;
		}
		
	}
}