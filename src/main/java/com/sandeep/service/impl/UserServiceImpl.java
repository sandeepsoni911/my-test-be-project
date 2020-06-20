package com.sandeep.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sandeep.dto.UserDto;
import com.sandeep.entity.User;
import com.sandeep.repository.UserRepository;
import com.sandeep.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;

	@Override
	public UserDto getUserDetails(UserDto userDto) {
		UserDto userDetails = null;
		User user = userRepository.getLoanDetailsByloanId(userDto.getUserName()
				, userDto.getPassword());
		if(user!= null){
			userDetails = new UserDto();
			userDetails.setId(user.getUserId());
			userDetails.setRoles(user.getUserRole());
			userDetails.setUserName(user.getUserName());
			userDetails.setAuthToken("token_"+userDetails.hashCode());
		}
		return userDetails;
	}

}
