package com.sandeep.controller;



import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mysql.jdbc.StringUtils;
import com.sandeep.business.CustomerBusiness;
import com.sandeep.dto.BaseResponse;
import com.sandeep.dto.CustomerDto;
import com.sandeep.dto.CustomerListResponse;

/**
 * Controller class for customers APIs
 * @author sandeepsoni
 *
 */

@RestController
public class CustomerController {
	
	@Autowired
	CustomerBusiness  customerBusiness;

	@CrossOrigin
	@RequestMapping(value= "/registerApi" ,method = RequestMethod.GET )
	public @ResponseBody BaseResponse registerCustomer( @RequestBody CustomerDto customerDto){
		BaseResponse baseResponse = new BaseResponse();
		if(customerDto == null){
			baseResponse.setMessage("Required details are not present");
			baseResponse.setStatus("ERROR");
			return baseResponse ;
		}
		
		String response = customerBusiness.register(customerDto);
		baseResponse.setMessage(response);
		baseResponse.setStatus("SUCCESS");
		return baseResponse;
		
	}
	
	@CrossOrigin
	@RequestMapping(value= "/registerCustomer" ,method = RequestMethod.POST, consumes= "application/json" )
	public @ResponseBody BaseResponse registerCustomers( @RequestBody CustomerDto customerDto){
		BaseResponse baseResponse = new BaseResponse();
		if(customerDto == null){
			baseResponse.setMessage("Required details are not present");
			baseResponse.setStatus("ERROR");
			return baseResponse ;
		}
		String response = customerBusiness.register(customerDto);
		baseResponse.setMessage(response);
		baseResponse.setStatus("SUCCESS");
		return baseResponse;
		
	}
	
	@CrossOrigin
	@RequestMapping(value= "/customers" ,method = RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE )
	public @ResponseBody List<CustomerDto> getCustomerDetails(){
		
		return customerBusiness.getCustomerList();
		
	}
	
	@CrossOrigin
	@RequestMapping(value= "/customers/{id}" ,method = RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE )
	public @ResponseBody CustomerDto getCustomerDetails(@PathVariable Long id){
		
		return customerBusiness.getCustomerDetails(id);
		
	}
	
	
	@RequestMapping(value = "/countries")
	public ModelAndView getListingPackagePage(HttpServletRequest request,
			@RequestParam( value = "zip", defaultValue="" )  String zip) {
		ModelAndView model = new ModelAndView("Countries");
		
		List<String> countries = new ArrayList<String>();
		countries.add("India");
		countries.add("United States");
		countries.add("Germany");
		countries.add("France");
		
		model.addObject("countries" , countries);
		model.addObject("message", "Below are countries name");
		return model;
	}
	
	@CrossOrigin
	@RequestMapping(value= "/register" ,method = RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE )
	public @ResponseBody ModelAndView getRegistrationPage(){
		ModelAndView model = new ModelAndView("Register");
		return model;
		
	}
	

	@CrossOrigin
	@RequestMapping(value= "/searchCustomer/{searchString}" ,method = RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE )
	public @ResponseBody List<CustomerDto> serachCustomers(@PathVariable String searchString){
		List<CustomerDto> response = null;
		if(!StringUtils.isNullOrEmpty(searchString)) {
			response = 	customerBusiness.serachCustomers(searchString);
		}
		
		return response;
		
	}
	
	@CrossOrigin
	@RequestMapping(value= "/customersList" ,method = RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE )
	public @ResponseBody CustomerListResponse getCustomerDetails(Integer pageNumber, Integer perPage){
		CustomerListResponse response = null;
		response = customerBusiness.getCustomerDetailList(pageNumber, perPage);
		return response;
		
	}
   
	
	
}
