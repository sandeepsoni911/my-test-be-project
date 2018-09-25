package com.sandeep.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Entity class for Loan
 * @author sandeepsoni
 *
 */
@Entity
@Table(name ="loan_payments")
public class LoanPayments extends AbstractAuditable {
	
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@SequenceGenerator(name="seq", initialValue=1, allocationSize=100)
	@Column(name = "id")
	private Long LoanPaymentId;
	
	@Column(name = "amount")
	private Long partialAmount;
	
	
	@ManyToOne( fetch=FetchType.LAZY)
	@JoinColumn(name="loan_Id")
	private Loan loan;
	
	@Column(name = "balance_loan_amount")
	private Long balanceAmount;
	
	@Column(name = "comment")
	private String comment;
	
	@Column(name = "interest_amount")
	private Double interestAmount;
	
	@Column(name = "payment_type")
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
	 * @return the loanPaymentId
	 */
	public Long getLoanPaymentId() {
		return LoanPaymentId;
	}

	/**
	 * @param loanPaymentId the loanPaymentId to set
	 */
	public void setLoanPaymentId(Long loanPaymentId) {
		LoanPaymentId = loanPaymentId;
	}

	/**
	 * @return the partialAmount
	 */
	public Long getPartialAmount() {
		return partialAmount;
	}

	/**
	 * @param partialAmount the partialAmount to set
	 */
	public void setPartialAmount(Long partialAmount) {
		this.partialAmount = partialAmount;
	}

	/**
	 * @return the loan
	 */
	public Loan getLoan() {
		return loan;
	}

	/**
	 * @param loan the loan to set
	 */
	public void setLoan(Loan loan) {
		this.loan = loan;
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
	
	
	
	
	
	
	
	
	
	
	
	

}
