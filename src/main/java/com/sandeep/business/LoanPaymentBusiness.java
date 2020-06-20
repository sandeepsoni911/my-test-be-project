package com.sandeep.business;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.sandeep.dto.LoanPaymentDetails;

/**
 * Business class for loanPayments
 * @author sandeepsoni
 *
 */
public interface LoanPaymentBusiness {
	
	/**
	 * To get all partial payments
	 * for loan id
	 * @param loanId
	 * @return
	 */
	List<LoanPaymentDetails> getAllPartialPayment(Long loanId);
	
	/**
	 * To save partial payment
	 * @param loanPaymentDetails
	 * @return
	 */
	String saveLoanPartialPayment(LoanPaymentDetails loanPaymentDetails);

	
	Map<String, Object> getInterest(Long loanId, Date interestCalculationDate);
}
