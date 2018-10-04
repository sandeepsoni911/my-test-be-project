package com.sandeep.business;

import java.util.List;

import com.sandeep.dto.LoanDetailsDto;
import com.sandeep.dto.LoanListResponse;

public interface LoanBusiness {

	/**
	 * TO save loan details
	 * @param detailsDto
	 * @return
	 */
	String saveLoanDetails(LoanDetailsDto detailsDto);

	/**
	 * To get all loans 
	 * @return
	 */
	LoanListResponse  getAllLoanDetails(Integer pageNumber, Integer perPage);

	/**
	 * To get all loans by customer
	 * @param customerId
	 * @param customerName
	 * @return
	 */
	List<LoanDetailsDto> getAllLoanDetailsByCustomer(Long customerId,
			String customerName);
	
	/**
	 * To get loans details
	 * by loanId
	 * @return
	 */
	LoanDetailsDto  getLoanDetailsByLoanId(Long loanId);


}
