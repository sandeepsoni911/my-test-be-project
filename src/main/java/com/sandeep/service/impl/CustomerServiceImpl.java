package com.sandeep.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.sandeep.dto.CustomerDto;
import com.sandeep.dto.CustomerListResponse;
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

	@Override
	public CustomerListResponse serachCustomers(String searchString ,
			Integer pageNumber, Integer perPage) {
		CustomerListResponse response = new CustomerListResponse();
		List<CustomerDto> responseList = null;
		CustomerDto customerDto = null;
		response.setPageNumber(pageNumber);
		pageNumber = pageNumber == null ? 0 : pageNumber - 1;
		perPage = perPage == null ? 10 : perPage;
		response.setStatus("SUCCESS");
		response.setMessage("No Records Found.");
		try {
			Pageable pageable = new PageRequest(pageNumber, perPage);
			List<Customer> custList = customerRepository.searchCustomerDetailsByIdOrName(searchString, pageable);
			Long totalCount = customerRepository.searchCustomerDetailsCountByIdOrName(searchString);
			if (!CollectionUtils.isEmpty(custList)) {
				response.setMessage(totalCount.intValue()+" Records Found.");
				response.setTotalCount(totalCount.intValue());
				response.setPerPage(perPage);
				responseList = new ArrayList<CustomerDto>();

				for (Customer custObj : custList) {
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
		} catch (Exception e) {
			response.setStatus("FAILED");
			response.setMessage(e.getMessage());
		}
		response.setData(responseList);
		return response;

	}

	@Override
	public CustomerListResponse getCustomerDetailList(Integer pageNumber, Integer perPage) {
		CustomerListResponse response  = new CustomerListResponse();
		List<CustomerDto> responseList = null;
		CustomerDto customerDto = null;
		response.setPageNumber(pageNumber);
		pageNumber = pageNumber==null?0:pageNumber-1;
		perPage = perPage ==null?10:perPage;
		
		response.setStatus("SUCCESS");
		List<Customer> custList =  null;
		try {
			Pageable pageable = new PageRequest(pageNumber, perPage);
			custList = customerRepository.getAllCustomers(pageable);
			Long totalCount = customerRepository.getAllCustomersCount();
			response.setMessage("No Records Found.");
			if(!CollectionUtils.isEmpty(custList)){
				
				response.setPerPage(perPage);
				int count = totalCount!= null?totalCount.intValue():0;
				response.setTotalCount(count);
				response.setStatus("SUCCESS");
				response.setMessage(count+ " Records Found.");
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
		}catch(Exception e) {
			response.setStatus("FAILED");
			response.setMessage(e.getMessage());
		}
		
		response.setData(responseList);
		return response;
	}

}
