package com.sandeep.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sandeep.business.CustomerBusiness;
import com.sandeep.dto.BaseResponse;
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
	public BaseResponse register(CustomerDto customer) {
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
	public CustomerListResponse serachCustomers(String searchString,
						Integer pageNumber, Integer perPage) {
		pageNumber = pageNumber ==null?1:pageNumber;
		perPage = perPage ==null?10:perPage;
		
		return customerService.serachCustomers(searchString, pageNumber, perPage);
	}
	
	
	@Override
	public CustomerListResponse getCustomerDetailList(Integer pageNumber, Integer perPage) {
		
		return customerService.getCustomerDetailList(pageNumber, perPage);
	}

}
