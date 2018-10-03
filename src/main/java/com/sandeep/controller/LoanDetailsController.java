package com.sandeep.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.sandeep.business.CustomerBusiness;
import com.sandeep.business.LoanBusiness;
import com.sandeep.business.LoanPaymentBusiness;
import com.sandeep.dto.BaseResponse;
import com.sandeep.dto.CustomerDto;
import com.sandeep.dto.LoanDetailsDto;
import com.sandeep.dto.LoanPaymentDetails;

/**
 * Controller class for loan Contracts
 * @author sandeepsoni
 *
 */
@RestController
public class LoanDetailsController {

	@Autowired
	LoanBusiness loanBusiness;
	
	@Autowired
	LoanPaymentBusiness loanPaymentBusiness;
	
	@Autowired
	CustomerBusiness customerBusiness;
	
	@CrossOrigin
	@RequestMapping(value="/loan" , method=RequestMethod.POST, consumes= MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody BaseResponse saveLoan(@RequestBody LoanDetailsDto detailsDto){
		BaseResponse baseResponse = new BaseResponse();
		if(detailsDto == null){
			baseResponse.setMessage("Required details are not present");
			baseResponse.setStatus("ERROR");
			return baseResponse ;
		}
		String response =loanBusiness.saveLoanDetails(detailsDto);
		baseResponse.setMessage(response);
		baseResponse.setStatus("SUCCESS");
		return baseResponse;
	}
	
	@CrossOrigin
	@RequestMapping(value="/loan" , method=RequestMethod.GET)
	public @ResponseBody List<LoanDetailsDto> getLoanDetails(){
		List<LoanDetailsDto> response = null;
		
		response = loanBusiness.getAllLoanDetails();
		
		return response;
	}
	
	@CrossOrigin
	@RequestMapping(value="/loan/{loanId}" , method=RequestMethod.GET)
	public @ResponseBody LoanDetailsDto getLoanDetailsByLoanId(@PathVariable Long loanId){
		LoanDetailsDto response = null;
		
		response = loanBusiness.getLoanDetailsByLoanId(loanId);
		
		return response;
	}
	
	
	@CrossOrigin
	@RequestMapping(value="/loan" , method=RequestMethod.PUT, consumes= MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<LoanDetailsDto> updateLoanDetails(LoanDetailsDto detailsDto){
		List<LoanDetailsDto> response = null;
		if(detailsDto == null){
			return null;
		}
		//response = loanBusiness.getAllLoanDetails(); // write method to update loan deatils
		
		return response;
	}
	
	@CrossOrigin
	@RequestMapping(value="/loanByCustomerDetails" , method=RequestMethod.GET, consumes= MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<LoanDetailsDto> getLoanByCustName(){
		List<LoanDetailsDto> response = null;
		response = loanBusiness.getAllLoanDetails(); // write method to get loan deatils by customer name
		
		return response;
	}
	
	@CrossOrigin
	@RequestMapping(value= "/loanForm" ,method = RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE )
	public @ResponseBody ModelAndView getRegistrationPage(){
		ModelAndView model = new ModelAndView("LoanForm");
		List<CustomerDto> customerList = customerBusiness.getCustomerList();
		model.addObject("customerDtoList", customerList);
		return model;
		
	}
	
	@CrossOrigin
	@RequestMapping(value= "/loanFtl" ,method = RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE )
	public @ResponseBody ModelAndView getRegistrationPageFtl(){
		ModelAndView model = new ModelAndView("Loan.ftl");
		List<CustomerDto> customerList = customerBusiness.getCustomerList();
		model.addObject("customerDtoList", customerList);
		return model;
		
	}
	
	@CrossOrigin
	@RequestMapping(value= "/loanDetails" ,method = RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE )
	public @ResponseBody ModelAndView getAllLoanDetails(){
		ModelAndView model = new ModelAndView("LoanDetails");
		List<CustomerDto> customerList = customerBusiness.getCustomerList();
		List<LoanDetailsDto> loanDetailList = loanBusiness.getAllLoanDetails();
		model.addObject("customerDtoList", customerList);
		model.addObject("loanDetailList", loanDetailList);
		return model;
		
	}
	
	@CrossOrigin
	@RequestMapping(value= "/loanDetailsByCustomer" ,method = RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE )
	public @ResponseBody List<LoanDetailsDto>  getAllLoanByCustomerName(String customerId, String customerName){
		List<LoanDetailsDto> loanDetailList = loanBusiness.getAllLoanDetailsByCustomer( null, customerName); //To imeplement to get query params from UI as name or id
		return loanDetailList;
		
	}
	
	@CrossOrigin
	@RequestMapping(value= "/loanDetailsByCustomerId/{customerId}" ,method = RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE )
	public @ResponseBody List<LoanDetailsDto>  getAllLoanByCustomerId(@PathVariable Long customerId){
		List<LoanDetailsDto> loanDetailList = loanBusiness.getAllLoanDetailsByCustomer( customerId, null);
		return loanDetailList;
		
	}
	
	@CrossOrigin
	@RequestMapping(value= "/loanPartialPayment/{loanId}" ,method = RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE )
	public @ResponseBody List<LoanPaymentDetails> getAllPartialPaymentsByLoanId(@PathVariable Long loanId){
		List<LoanPaymentDetails> loanDetailList = loanPaymentBusiness.getAllPartialPayment(loanId);
		return loanDetailList;
		
	}
	
	
	@CrossOrigin
	@RequestMapping(value= "/loanPartialPayment" ,method = RequestMethod.POST, produces= MediaType.APPLICATION_JSON_VALUE )
	public @ResponseBody  BaseResponse savePartialPayments(@RequestBody LoanPaymentDetails loanPaymentDetails){
		BaseResponse baseResponse = new BaseResponse();
		String message = loanPaymentBusiness.saveLoanPartialPayment(loanPaymentDetails);
		if(message != null) {
			baseResponse.setMessage(message);
			baseResponse.setStatus("SUCCESS");
		}else {
			baseResponse.setMessage("Error Occurred while Processing your request.");
			baseResponse.setStatus("ERROR");
			return baseResponse ;
		}
		return baseResponse;
		
	}
	
	@CrossOrigin
	@RequestMapping(value= "/interest/{loanId}" ,method = RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE )
	public @ResponseBody Map<String, Object> calculateInterest(@PathVariable Long loanId, Date date){
		return loanPaymentBusiness.getInterest(loanId, date);
		
	}
	
	
	
	
}
