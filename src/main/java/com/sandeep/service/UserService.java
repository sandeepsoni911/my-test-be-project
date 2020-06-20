package com.sandeep.service;

import com.sandeep.dto.UserDto;

/**
 * To have contracts for Users
 * @author sandeepsoni
 *
 */
public interface UserService {
	
	/**
	 * To get user details
	 * @param userName
	 * @param password
	 * @return
	 */
	public UserDto getUserDetails(UserDto userDto);

}
