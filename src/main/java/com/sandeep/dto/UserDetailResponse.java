package com.sandeep.dto;

import org.springframework.security.core.userdetails.UserDetails;

public class UserDetailResponse {
	
	private String message;
	
	private String status;
	
	private UserDto userDetails;

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the userDetails
	 */
	public UserDto getUserDetails() {
		return userDetails;
	}

	/**
	 * @param userDetails the userDetails to set
	 */
	public void setUserDetails(UserDto userDetails) {
		this.userDetails = userDetails;
	}
	
	
	

}
