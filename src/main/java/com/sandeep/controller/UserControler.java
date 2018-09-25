package com.sandeep.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sandeep.dto.BaseResponse;
import com.sandeep.dto.UserDetailResponse;
import com.sandeep.dto.UserDto;
import com.sandeep.service.UserService;

/**
 * Controller class for Users APIs
 * @author sandeepsoni
 *
 */

@RestController
public class UserControler {
	
	@Autowired
	UserService userService;
	
	
	
	@CrossOrigin()
	@RequestMapping(value= "/login" ,method = RequestMethod.POST, consumes= "application/json" )
	public UserDetailResponse getUserDetails(@RequestBody UserDto userDto) throws Exception {
		UserDetailResponse response = new UserDetailResponse();
		if(userDto == null || StringUtils.isEmpty(userDto.getUserName()) || StringUtils.isEmpty(userDto.getPassword()))  {
			throw new Exception("Username/password cannot be null.");
		}
		UserDto userDetails = userService.getUserDetails(userDto);
		if(userDetails != null) {
			response.setUserDetails(userDetails);
			response.setStatus("SUCCESS");
			response.setMessage("Logged in Successfully.");
		}else {
			response.setStatus("FAILED");
			response.setMessage("Please enter correct Username/Password.");
		}
		return response;
		
	}

}
