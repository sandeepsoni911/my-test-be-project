package com.sandeep.service;

import java.util.List;

import com.sandeep.dto.CustomerDto;

public interface CustomerService {
	
	/**
	 * To register customer
	 * @param customerDto
	 * @return
	 */
	public String register(CustomerDto customer);
	
	
	/**
	 * To get list of all customers
	 * @return
	 */
	public List<CustomerDto> getCustomerList();
	
	/**
	 * To get customer details by id
	 * @return
	 */
	public CustomerDto getCustomerDetails( Long id);
}
