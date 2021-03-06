package com.dmantz.ecapp.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dmantz.ecapp.common.User;
import com.dmantz.ecapp.request.CreateSignUpRequestPO;
import com.dmantz.ecapp.request.LoginRequest;
import com.dmantz.ecapp.response.UserRegistrationRes;
import com.dmantz.ecapp.service.UserManagerService;

@RestController
@CrossOrigin(origins = "http://192.168.0.100:4200")
public class UserController {

	@Autowired
	UserManagerService userManagerServiceObj;

	private static final Logger logger=LoggerFactory.getLogger(UserController.class);

	//SAVE METHOD
	@RequestMapping(value = "/register", method = RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
	public UserRegistrationRes register(@RequestBody CreateSignUpRequestPO createSignUpRequestPOObj) {
		logger.info("results:" + createSignUpRequestPOObj.toString());
		return userManagerServiceObj.register(createSignUpRequestPOObj);

	}
	
	//GET ALL USERS
	@GetMapping(value="/allUsers")
	public List<User> getAllUser(){
		return userManagerServiceObj.getAllUser();
	}
	
	//GET USER
	@GetMapping(value="/getUser")
	public User getUser(@RequestParam("user_id") int user_id) {
		logger.info("Selected User Details Are Displayed");
		return userManagerServiceObj.getUser(user_id);
	}
	
	//GET USER USING EMAILID
	@GetMapping(value="/getUser/emailId")
	public User getUserEId(@RequestParam("email_id") String email_id) {
		logger.info("Selected User Details Are Displayed Using Email_Id");
		return userManagerServiceObj.getUserEId(email_id);
	}

	//DELETE USER
	@RequestMapping(value="/deleteUser",method=RequestMethod.DELETE)
	public String deleteUser(@RequestParam("user_id") int user_id) {
		logger.info("Selected User Details Deleted");
		return userManagerServiceObj.deleteUser(user_id);
	}

	//UPDATE FIRST NAME
	@RequestMapping(value = "/updateFirstName", method = RequestMethod.PUT)
	public User updateFirstName(@RequestBody CreateSignUpRequestPO createSignUpRequestPOObj) {
		logger.info("First Name is updated");
		return userManagerServiceObj.updateFirstName(createSignUpRequestPOObj);
	}

	//UPDATE LAST NAME
	@RequestMapping(value = "/updateLastName", method = RequestMethod.PUT)
	public User updateLastName(@RequestBody CreateSignUpRequestPO createSignUpRequestPOObj) {
		logger.info("Last Name is updated");
		return userManagerServiceObj.updateLastName(createSignUpRequestPOObj);
	}

	//UPDATE EMAILID
	@RequestMapping(value = "/updateEmailId", method = RequestMethod.PUT)
	public User updateEmailId(@RequestBody CreateSignUpRequestPO createSignUpRequestPOObj) {
		logger.info("EmailId is updated");
		return userManagerServiceObj.updateEmailId(createSignUpRequestPOObj);
	}

	//UPDATE PASSWORD
	@RequestMapping(value = "/updatePassword", method = RequestMethod.PUT)
	public User updatePassword(@RequestBody CreateSignUpRequestPO createSignUpRequestPOObj) {
		logger.info("Password is updated");
		return userManagerServiceObj.updatePassword(createSignUpRequestPOObj);
	}

	//UPDATE MOBILE NUMBER
	@RequestMapping(value = "/updateMobileNumber", method = RequestMethod.PUT)
	public User updateMobileNumber(@RequestBody CreateSignUpRequestPO createSignUpRequestPOObj) {
		logger.info("MobileNumber is updated");
		return userManagerServiceObj.updateMobileNumber(createSignUpRequestPOObj);
	}

	// USER LOGIN
	@PostMapping(value="/userLogin")
	public User userLogin(@RequestBody LoginRequest loginRequest)	{
		logger.info("object is"+loginRequest);
		return userManagerServiceObj.userLogin(loginRequest);
	}
	
	//request mapping for checking email 
		@PostMapping(value="/checkUserEmail")
		public String checkUserEmail(@RequestBody CreateSignUpRequestPO createSignUpRequestPO) {
			
			return userManagerServiceObj.checkExistence(createSignUpRequestPO.getEmail_id());
		}
		
		//request mapping for reset password
		@PostMapping(value="/resetPassword")
		public UserRegistrationRes resetUserPassword(@RequestBody CreateSignUpRequestPO createSignUpRequestPO) {
			logger.info("ip request object"+createSignUpRequestPO);
			return userManagerServiceObj.resetPassword(createSignUpRequestPO);
			
			
		}
		
		
		}