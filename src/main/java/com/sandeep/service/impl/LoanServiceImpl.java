package com.sandeep.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sandeep.dto.LoanDetailsDto;
import com.sandeep.entity.Customer;
import com.sandeep.entity.Loan;
import com.sandeep.entity.LoanPayments;
import com.sandeep.repository.CustomerRepository;
import com.sandeep.repository.LoanRepository;
import com.sandeep.service.LoanService;
import com.sandeep.util.JsonUtil;
/**
 * Service implementation class for LoanService
 * @author sandeepsoni
 *
 */

@Service
public class LoanServiceImpl implements LoanService {
	
	private static final Logger logger = LoggerFactory.getLogger(LoanServiceImpl.class);
	
	
	@Autowired
	LoanRepository loanRepository;
	
	@Autowired
	CustomerRepository customerRepository;

	@Override
	public String saveLoanDetails(LoanDetailsDto loanDetailsDto) {
		try {
			logger.info("loanDTo value is :" +JsonUtil.toJson(loanDetailsDto));
		} catch (IOException e) {
			logger.error("Exception while converting to json value");
			e.printStackTrace();
		}
		String response = null;
		if(loanDetailsDto != null){
			Loan loan = new Loan();
			Customer customer = customerRepository.getLoanDetailsByloanId(loanDetailsDto.getCustomerId());
			//customer.setCustomerId(loanDetailsDto.getCustomerId());
			loan.setComments(loanDetailsDto.getComments());
			loan.setCreatedBy("Admin");
			loan.setDueDate(loanDetailsDto.getDueDate());
			loan.setItemType(loanDetailsDto.getItemType());
			loan.setLoanAmount(loanDetailsDto.getLoanAmount());
			loan.setLoanId(loanDetailsDto.getLoanId());
			loan.setRateOfInterest(loanDetailsDto.getRateOfInterest());
			loan.setStatus(loanDetailsDto.getStatus());
			loan.setItemQuality(loanDetailsDto.getItemQuality());
			loan.setItemName(loanDetailsDto.getItemName());
			loan.setWeight(loanDetailsDto.getWeight());
			loan.setStatus("OPEN");
			loan.setCustomer(customer);
			
			loan =	loanRepository.save(loan);
			if(loan != null){
				response = "Loans Details saved successfully.";
			}
		}
		return response;
	}

	@Override
	public List<LoanDetailsDto> getAllLoanDetails() {
		List<LoanDetailsDto> loanDetailList = null;
		List<Loan> loanList = loanRepository.getAllLoanDetails();
		LoanDetailsDto loanDetailsDto = null;
		if(!CollectionUtils.isEmpty(loanList)){
			loanDetailList = new ArrayList<LoanDetailsDto>();
			for(Loan loan:loanList){
				
				loanDetailsDto = new LoanDetailsDto();
				
				loanDetailsDto.setComments(loan.getComments());
				loanDetailsDto.setCustomerId(loan.getCustomer().getCustomerId());
				loanDetailsDto.setItemQuality(loan.getItemQuality());
				loanDetailsDto.setDueDate(loan.getDueDate());
				loanDetailsDto.setItemName(loan.getItemName());
				loanDetailsDto.setItemType(loan.getItemType());
				loanDetailsDto.setLoanAmount(loan.getLoanAmount());
				loanDetailsDto.setLoanId(loan.getLoanId());
				loanDetailsDto.setRateOfInterest(loan.getRateOfInterest());
				loanDetailsDto.setStatus(loan.getStatus());
				loanDetailsDto.setWeight(loan.getWeight());
				loanDetailsDto.setCustomerName(loan.getCustomer().getCustomerName());
				loanDetailsDto.setCreatedDate(loan.getCreatedDate());
				
				loanDetailList.add(loanDetailsDto);
			}
		}
		
		return loanDetailList;
	}

	@Override
	public List<LoanDetailsDto> getAllLoanDetailsByCustomer(Long customerId,
			String customerName) {List<LoanDetailsDto> loanDetailList = null;
			List<Loan> loanList =loanRepository.getAllLoansByCustomerNameOrId(customerId, customerName);
			LoanDetailsDto loanDetailsDto = null;
			if(!CollectionUtils.isEmpty(loanList)){
				loanDetailList = new ArrayList<LoanDetailsDto>();
				for(Loan loan:loanList){
					
					loanDetailsDto = new LoanDetailsDto();
					
					loanDetailsDto.setComments(loan.getComments());
					loanDetailsDto.setCustomerId(loan.getCustomer().getCustomerId());
					loanDetailsDto.setItemQuality(loan.getItemQuality());
					loanDetailsDto.setDueDate(loan.getDueDate());
					loanDetailsDto.setItemName(loan.getItemName());
					loanDetailsDto.setItemType(loan.getItemType());
					loanDetailsDto.setLoanAmount(loan.getLoanAmount());
					loanDetailsDto.setLoanId(loan.getLoanId());
					loanDetailsDto.setRateOfInterest(loan.getRateOfInterest());
					loanDetailsDto.setStatus(loan.getStatus());
					loanDetailsDto.setWeight(loan.getWeight());
					loanDetailsDto.setCustomerName(loan.getCustomer().getCustomerName());
					loanDetailsDto.setCreatedDate(loan.getCreatedDate());
					
					loanDetailList.add(loanDetailsDto);
				}
			}
			
			return loanDetailList;
	}

	@Override
	public LoanDetailsDto getLoanDetailsByLoanId(Long loanId) {
		LoanDetailsDto loanDetailsDto = null;
		Loan loan = loanRepository.getLoanDetailsByloanId(loanId);
		if(loan != null) {
			loanDetailsDto = new LoanDetailsDto();
			loanDetailsDto.setComments(loan.getComments());
			loanDetailsDto.setCustomerId(loan.getCustomer().getCustomerId());
			loanDetailsDto.setCustomerName(loan.getCustomer().getCustomerName());
			loanDetailsDto.setItemQuality(loan.getItemQuality());
			loanDetailsDto.setDueDate(loan.getDueDate());
			loanDetailsDto.setItemName(loan.getItemName());
			loanDetailsDto.setItemType(loan.getItemType());
			loanDetailsDto.setLoanAmount(loan.getLoanAmount());
			loanDetailsDto.setLoanId(loan.getLoanId());
			loanDetailsDto.setRateOfInterest(loan.getRateOfInterest());
			loanDetailsDto.setStatus(loan.getStatus());
			loanDetailsDto.setWeight(loan.getWeight());
			loanDetailsDto.setCustomerCity(loan.getCustomer().getCustomerCity());
			loanDetailsDto.setCreatedDate(loan.getCreatedDate());
			loanDetailsDto.setKhataNumber(loan.getKhataNumber());
		}
		return loanDetailsDto;
	}

	

}
