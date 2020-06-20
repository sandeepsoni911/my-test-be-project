package com.sandeep.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * DTO for loan payment details
 * @author sandeepsoni
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class LoanPaymentDetails {
	
	private Long loanId;
	
	private Long partialPaymentAmount;
	
	private Long balanceAmount;
	
	private Long loanPaymentId;
	
	private String comment;
	
	private Date createdOn;
	
	private Double interestAmount;
	
	private String paymentType;

	/**
	 * @return the paymentType
	 */
	public String getPaymentType() {
		return paymentType;
	}

	/**
	 * @param paymentType the paymentType to set
	 */
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	/**
	 * @return the interestAmount
	 */
	public Double getInterestAmount() {
		return interestAmount;
	}

	/**
	 * @param interestAmount the interestAmount to set
	 */
	public void setInterestAmount(Double interestAmount) {
		this.interestAmount = interestAmount;
	}

	/**
	 * @return the loanId
	 */
	public Long getLoanId() {
		return loanId;
	}

	/**
	 * @param loanId the loanId to set
	 */
	public void setLoanId(Long loanId) {
		this.loanId = loanId;
	}

	/**
	 * @return the partialPaymentAmount
	 */
	public Long getPartialPaymentAmount() {
		return partialPaymentAmount;
	}

	/**
	 * @param partialPaymentAmount the partialPaymentAmount to set
	 */
	public void setPartialPaymentAmount(Long partialPaymentAmount) {
		this.partialPaymentAmount = partialPaymentAmount;
	}

	/**
	 * @return the balanceAmount
	 */
	public Long getBalanceAmount() {
		return balanceAmount;
	}

	/**
	 * @param balanceAmount the balanceAmount to set
	 */
	public void setBalanceAmount(Long balanceAmount) {
		this.balanceAmount = balanceAmount;
	}

	/**
	 * @return the loanPaymentId
	 */
	public Long getLoanPaymentId() {
		return loanPaymentId;
	}

	/**
	 * @param loanPaymentId the loanPaymentId to set
	 */
	public void setLoanPaymentId(Long loanPaymentId) {
		this.loanPaymentId = loanPaymentId;
	}

	/**
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * @param comment the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	/**
	 * @return the createdOn
	 */
	public Date getCreatedOn() {
		return createdOn;
	}

	/**
	 * @param createdOn the createdOn to set
	 */
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	
	

}
