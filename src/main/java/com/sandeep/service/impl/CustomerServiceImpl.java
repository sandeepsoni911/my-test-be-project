package com.sandeep.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.sandeep.dto.CustomerDto;
import com.sandeep.entity.Customer;
import com.sandeep.repository.CustomerRepository;
import com.sandeep.service.CustomerService;
/**
 * Service layer for customer
 * @author sandeepsoni
 *
 */
@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	CustomerRepository customerRepository;
	
	@Override
	public String register(CustomerDto customer) {
		String response = "Error occured while registration";
		if(customer != null){
			Customer custObj = new Customer();
			custObj.setCustomerAddress(customer.getAddress());
			custObj.setCustomerCity(customer.getCity());
			custObj.setCustomerName(customer.getName());
			custObj.setCustomerPhone(customer.getPhone());
			custObj.setGender(customer.getGender());
			custObj.setFatherName(customer.getFatherName());
			custObj.setStatus("ACTIVE");
			
			custObj = customerRepository.save(custObj);
			
			if(custObj != null){
				response = "Successfully Registered!";
			}
		}
		return response;
	}

	@Override
	public List<CustomerDto> getCustomerList() {
		List<CustomerDto> responseList = null;
		CustomerDto customerDto = null;
		List<Customer> custList = customerRepository.findAll();
		if(!CollectionUtils.isEmpty(custList)){
			responseList = new ArrayList<CustomerDto> ();
			
			for(Customer custObj : custList){
				customerDto = new CustomerDto();
				customerDto.setId(custObj.getCustomerId());
				customerDto.setName(custObj.getCustomerName());
				customerDto.setCity(custObj.getCustomerCity());
				customerDto.setAddress(custObj.getCustomerAddress());
				customerDto.setPhone(custObj.getCustomerPhone());
				customerDto.setGender(custObj.getGender());
				customerDto.setFatherName(custObj.getFatherName());
				responseList.add(customerDto);
			}
		}
		return responseList;
	}

	@Override
	public CustomerDto getCustomerDetails(Long id) {
		CustomerDto customerDto = null;
		Customer custObj  = customerRepository.getCustomerDetailsById(id);
		if(custObj != null) {
			customerDto = new CustomerDto();
			customerDto.setAddress(custObj.getCustomerAddress());
			customerDto.setCity(custObj.getCustomerCity());
			customerDto.setGender(custObj.getGender());
			customerDto.setId(custObj.getCustomerId());
			customerDto.setName(custObj.getCustomerName());
			customerDto.setPhone(custObj.getCustomerPhone());
			customerDto.setStatus(custObj.getStatus());
			customerDto.setFatherName(custObj.getFatherName());
			//customerDto.setPhotoPath(custObj.getCus);
		}
		return customerDto;
	}

}
