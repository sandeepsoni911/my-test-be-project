package com.sandeep.business.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.sandeep.business.LoanBusiness;
import com.sandeep.dto.LoanDetailsDto;
import com.sandeep.dto.LoanListResponse;
import com.sandeep.service.LoanService;

@Component
@Transactional( readOnly = true )
public class LoanBusinessImpl implements LoanBusiness {
	
	@Autowired
	LoanService loanService;

	@Override
	public String saveLoanDetails(LoanDetailsDto detailsDto) {
		return loanService.saveLoanDetails(detailsDto);
	}

	@Override
	public LoanListResponse getAllLoanDetails(Integer pageNumber, Integer perPage) {
		return loanService.getAllLoanDetails(pageNumber, perPage);
	}

	@Transactional()
	@Override
	public List<LoanDetailsDto> getAllLoanDetailsByCustomer(Long customerId,
			String customerName) {
		
		return loanService.getAllLoanDetailsByCustomer(customerId, customerName);
	}

	@Override
	public LoanDetailsDto getLoanDetailsByLoanId(Long loanId) {
		
		return loanService.getLoanDetailsByLoanId(loanId);
	}

}
