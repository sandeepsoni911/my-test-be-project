package com.sandeep.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sandeep.business.CustomerBusiness;
import com.sandeep.dto.CustomerDto;
import com.sandeep.dto.CustomerListResponse;
import com.sandeep.service.CustomerService;

/**
 * Implementation class for customerBusiness contracts
 * @author sandeepsoni
 *
 */
@Component
public class CustomerBusinessImpl implements CustomerBusiness{

	@Autowired
	CustomerService customerService;
	
	@Override
	public String register(CustomerDto customer) {
		return customerService.register(customer);
	}

	@Override
	public List<CustomerDto> getCustomerList() {
		return customerService.getCustomerList();
	}

	@Override
	public CustomerDto getCustomerDetails(Long id) {
		return customerService.getCustomerDetails(id);
	}

	@Override
	public List<CustomerDto> serachCustomers(String searchString) {
		
		return customerService.serachCustomers(searchString);
	}
	
	
	@Override
	public CustomerListResponse getCustomerDetailList(Integer pageNumber, Integer perPage) {
		
		return customerService.getCustomerDetailList(pageNumber, perPage);
	}

}
