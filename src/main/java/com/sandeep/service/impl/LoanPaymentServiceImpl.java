package com.sandeep.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sandeep.dto.LoanPaymentDetails;
import com.sandeep.entity.LoanPayments;
import com.sandeep.repository.LoanPaymentRepository;
import com.sandeep.service.LoanPaymentService;
/**
 * Service Impl class
 * @author sandeepsoni
 *
 */

@Service
public class LoanPaymentServiceImpl implements LoanPaymentService {
	
	@Autowired
	LoanPaymentRepository loanPaymentRepository;

	@Override
	public List<LoanPaymentDetails> getAllPartialPayment(Long loanId) {
		List<LoanPaymentDetails> paymentList = null;
		List<LoanPayments> loanPaymentList = loanPaymentRepository.getAllPaymentsForLoanId(loanId);
		if(CollectionUtils.isNotEmpty(loanPaymentList)) {
			paymentList = new ArrayList<LoanPaymentDetails>();
			for(LoanPayments  lp : loanPaymentList) {
				LoanPaymentDetails loanPaymentDetails = new LoanPaymentDetails();
				loanPaymentDetails.setBalanceAmount(lp.getBalanceAmount());
				loanPaymentDetails.setComment(lp.getComment());
				loanPaymentDetails.setCreatedOn(lp.getCreatedDate());
				loanPaymentDetails.setLoanId(lp.getLoan().getLoanId());
				loanPaymentDetails.setPartialPaymentAmount(lp.getPartialAmount());
				loanPaymentDetails.setLoanPaymentId(lp.getLoanPaymentId());
				loanPaymentDetails.setInterestAmount(lp.getInterestAmount());
				loanPaymentDetails.setPaymentType(lp.getPaymentType());
				paymentList.add(loanPaymentDetails);
			}
		}
		return paymentList;
	}

	@Override
	public String saveLoanPartialPayment(LoanPaymentDetails loanPaymentDetails) {
		String response = null;
		if(loanPaymentDetails != null) {
			LoanPayments loan = new LoanPayments();
			LoanPayments loanResponse = loanPaymentRepository.save(loan);
			if(loanResponse != null) {
				response = "Successfully saved";
			}else {
				response = "Some Error occured while saving your payment details";
			}
		}
		
		return response;
	}

	@Override
	public LoanPayments getBalanceAmountForLoanId(Long loanId) {
		LoanPayments loanPaymentDetails = null;
		if(loanId != null) {
			loanPaymentDetails = loanPaymentRepository.getBalanceAmountForLoanId(loanId);
		}
		return loanPaymentDetails;
	}

}
