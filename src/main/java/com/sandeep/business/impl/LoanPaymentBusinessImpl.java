package com.sandeep.business.impl;

import java.time.Duration;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.sandeep.dto.LoanPaymentDetails;
import com.sandeep.entity.Loan;
import com.sandeep.entity.LoanPayments;
import com.sandeep.repository.LoanPaymentRepository;
import com.sandeep.repository.LoanRepository;
import com.sandeep.service.LoanPaymentService;
import com.sandeep.service.LoanService;


/**
 * Business Impl class
 * @author sandeepsoni
 *
 */
@Component
@Transactional()
public class LoanPaymentBusinessImpl implements com.sandeep.business.LoanPaymentBusiness {
	
	private static final Logger logger = LoggerFactory.getLogger(LoanPaymentBusinessImpl.class);
	
	@Autowired
	LoanService loanService;

	@Autowired
	LoanPaymentService loanPaymentService;
	
	@Autowired
	LoanRepository loanRepository;
	
	@Autowired
	LoanPaymentRepository loanPaymentRepository;
	
	@Override
	public List<LoanPaymentDetails> getAllPartialPayment(Long loanId) {
		
		return loanPaymentService.getAllPartialPayment(loanId);
	}

	@Override
	public String saveLoanPartialPayment(LoanPaymentDetails loanPaymentDetails) {
		String response = null;
		if(loanPaymentDetails != null && loanPaymentDetails.getLoanId() != null ) {
			Loan loan =	loanRepository.getLoanDetailsByloanId(loanPaymentDetails.getLoanId());
			if(loan != null) {
				LoanPayments loanPayments =	loanPaymentService.getBalanceAmountForLoanId(loanPaymentDetails.getLoanId());
				
					LoanPayments partialPayment = new LoanPayments();
					partialPayment.setComment(loanPaymentDetails.getComment());
					Map<String, Object> interestResponse = calculateInterestAmount(loanPayments, loan,loanPaymentDetails.getCreatedOn() );
					Double interestAmount = (Double)interestResponse.get("INTEREST");
					partialPayment.setInterestAmount(interestAmount.doubleValue());
					Long balanceAmount = null;
					if( "Payment".equals(loanPaymentDetails.getPaymentType())) {
						partialPayment.setPaymentType("PARTIAL_PAYMENT");
						if(loanPayments != null) {
							balanceAmount = (loanPayments.getBalanceAmount()
									-loanPaymentDetails.getPartialPaymentAmount()+interestAmount.longValue());
						}else {
							balanceAmount = (loan.getLoanAmount()
									-loanPaymentDetails.getPartialPaymentAmount()+interestAmount.longValue());
						}
					}else {
						partialPayment.setPaymentType("ADDITIONAL_LOAN");
						if(loanPayments != null) {
							balanceAmount = (loanPayments.getBalanceAmount()
									+loanPaymentDetails.getPartialPaymentAmount()+interestAmount.longValue());
						}else {
							balanceAmount = (loan.getLoanAmount()
									+loanPaymentDetails.getPartialPaymentAmount()+interestAmount.longValue());
						}
					}
					
					
					if(balanceAmount != null && balanceAmount == 0) {
						loan.setStatus("CLOSED");
					}
					partialPayment.setLoan(loan);
					partialPayment.setBalanceAmount(balanceAmount);
					partialPayment.setPartialAmount(loanPaymentDetails.getPartialPaymentAmount());
					partialPayment.setLastModifiedBy("APPLICATION");
					partialPayment.setCreatedDate(loanPaymentDetails.getCreatedOn()!=null
							?loanPaymentDetails.getCreatedOn():new Date());
					
					LoanPayments partialPayments = loanPaymentRepository.save(partialPayment);
					if(partialPayments != null) {
						response = "SUCCESS";
					}else {
						response = "ERROR";
					}
			}
		}
		
		return response;
	}

	/**
	 * To calculate Interest
	 * @param partialPayment
	 * @param loan
	 * @return
	 */
	public Map<String, Object> calculateInterestAmount(LoanPayments partialPayment, Loan loan, Date paymentDate) {
		Map<String, Object> response = null;
		if (loan != null) {
			response = new HashMap<String, Object>();
			Long amount = null;
			Long daysBetween = null;
			LocalDate todaysDate = new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			LocalDate startDate = loan.getCreatedDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			Float rate = loan.getRateOfInterest();
			if (partialPayment != null && partialPayment.getCreatedDate() != null) { // calculate interest based on
																						// balance amount on last
																						// partial payment
				startDate = partialPayment.getCreatedDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
				amount = partialPayment.getBalanceAmount();
			} else { // calculate interest based on main loan amount
				amount = loan.getLoanAmount();
			}
			if(paymentDate != null) {
				todaysDate = paymentDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			}
			
			daysBetween = Duration.between(startDate.atStartOfDay(), todaysDate.atStartOfDay()).toDays();
			daysBetween = daysBetween==0?1:daysBetween;
			logger.info("days difference is : {} for dates dateBefore : {} and dateAfter: {}", daysBetween, startDate,
					daysBetween);

			Double month = (double) (365/12);
			Double interest = (Double) (amount * (rate / 100) * (daysBetween / month));
			logger.info("calculated interest is : {}", interest);
			response.put("INTEREST", interest);
			response.put("DAYS", daysBetween);
		}
		return response;
	}

	@Override
	public Map<String, Object> getInterest(Long loanId, Date interestCalculationDate) {
		Map<String, Object> response = null;
		if(loanId != null) {
			Loan loan =	loanRepository.getLoanDetailsByloanId(loanId);
			if(loan != null) {
				response = new HashMap<String, Object>();
				LoanPayments loanPayments =	loanPaymentService.getBalanceAmountForLoanId(loanId);
				response = calculateInterestAmount(loanPayments, loan,interestCalculationDate );
			}
		}
		return response;
	}

}
