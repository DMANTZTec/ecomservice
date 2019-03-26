package com.dmantz.ecapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dmantz.ecapp.common.User;
import com.dmantz.ecapp.repository.UserRepository;
import com.dmantz.ecapp.request.CreateSignUpRequestPO;
import com.dmantz.ecapp.service.UserManagerService;

@RestController
public class UserController {

	@Autowired
	UserManagerService userManagerServiceObj;
	
	private static final Logger logger=LoggerFactory.getLogger(UserController.class);
	
//SAVE METHOD
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public User register(@RequestBody CreateSignUpRequestPO createSignUpRequestPOObj) {
		logger.info("results:" + createSignUpRequestPOObj.toString());
		return userManagerServiceObj.createSignUp(createSignUpRequestPOObj);

	}

//UPDATE FIRST NAME
	@RequestMapping(value = "/updateFirstName", method = RequestMethod.PUT)
	public User updateFirstName(@RequestBody CreateSignUpRequestPO createSignUpRequestPOObj) {
		logger.info("First Name is updated");
		return userManagerServiceObj.updateFirstName(createSignUpRequestPOObj);
	}

//UPDATE LAST NAME
	@RequestMapping(value = "/updatePhoneNo", method = RequestMethod.PUT)
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
//DELETE
	
//DELETE 
//	@RequestMapping(value = "/deleteUser", method = RequestMethod.DELETE)
//	public String deleteUser(@RequestBody CreateSignUpRequestPO createSignUpRequestPOObj) {
//		return userManagerServiceObj.deleteUser(createSignUpRequestPOObj);
	//}
//TOTAL UPDATE
//	@RequestMapping(value="/update/{id}")
//	public User update(@RequestBody CreateSignUpRequestPO createSignUpRequestPOObj, @PathVariable(value="id") Integer user_id)  {
//		userRepository.save(createSignUpRequestPOObj);
		
		
	//}
//	@GetMapping(value="/getting/{Id}")
//	public Optional<User> findById(@PathVariable(value="Id") Integer user_id) {
//		return userRepositoryObj.findById(user_id);
//	}

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
