package com.sandeep.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Entity class for Loan
 * @author sandeepsoni
 *
 */
@Entity
@Table(name ="loan")
public class Loan extends AbstractAuditable {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@SequenceGenerator(name="seq", initialValue=1, allocationSize=100)
	@Column(name = "id")
	private Long loanId;
	
	@Column(name = "amount")
	private Long loanAmount;
	
	@Column(name = "due_date")
	private Date dueDate;
	
	@Column(name = "item_type")
	private String itemType;
	
	@Column(name="rate_of_interest")
	private Float rateOfInterest;
	
	@Column(name = "comment")
	private String comments;
	
	@Column(name = "status")
	private String status;
	

	@Column(name = "item_name")
	private String itemName;
	
	@Column(name = "item_quality")
	private Integer itemQuality;
	
	@Column(name = "weight")
	private Double weight;
	
	@ManyToOne( fetch=FetchType.LAZY)
	@JoinColumn(name="customer_id")
	private Customer customer;
	
	@OneToMany(mappedBy="loan",  fetch = FetchType.LAZY )
	private List<LoanPayments> loanPaymentList;
	
	
	@Column(name = "khata_number")
	private Long khataNumber;

	/**
	 * @return the khataNumber
	 */
	public Long getKhataNumber() {
		return khataNumber;
	}

	/**
	 * @param khataNumber the khataNumber to set
	 */
	public void setKhataNumber(Long khataNumber) {
		this.khataNumber = khataNumber;
	}

	/**
	 * @return the loanPaymentList
	 */
	public List<LoanPayments> getLoanPaymentList() {
		return loanPaymentList;
	}

	/**
	 * @param loanPaymentList the loanPaymentList to set
	 */
	public void setLoanPaymentList(List<LoanPayments> loanPaymentList) {
		this.loanPaymentList = loanPaymentList;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/**
	 * @return the weight
	 */
	public Double getWeight() {
		return weight;
	}

	/**
	 * @param weight the weight to set
	 */
	public void setWeight(Double weight) {
		this.weight = weight;
	}

	/**
	 * @return the itemName
	 */
	public String getItemName() {
		return itemName;
	}

	/**
	 * @param itemName the itemName to set
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the itemQuality
	 */
	public Integer getItemQuality() {
		return itemQuality;
	}

	/**
	 * @param itemQuality the itemQuality to set
	 */
	public void setItemQuality(Integer itemQuality) {
		this.itemQuality = itemQuality;
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
	 * @return the loanAmount
	 */
	public Long getLoanAmount() {
		return loanAmount;
	}

	/**
	 * @param loanAmount the loanAmount to set
	 */
	public void setLoanAmount(Long loanAmount) {
		this.loanAmount = loanAmount;
	}

	/**
	 * @return the dueDate
	 */
	public Date getDueDate() {
		return dueDate;
	}

	/**
	 * @param dueDate the dueDate to set
	 */
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	/**
	 * @return the itemType
	 */
	public String getItemType() {
		return itemType;
	}

	/**
	 * @param itemType the itemType to set
	 */
	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	

	/**
	 * @return the rateOfInterest
	 */
	public Float getRateOfInterest() {
		return rateOfInterest;
	}

	/**
	 * @param rateOfInterest the rateOfInterest to set
	 */
	public void setRateOfInterest(Float rateOfInterest) {
		this.rateOfInterest = rateOfInterest;
	}

	/**
	 * @return the comments
	 */
	public String getComments() {
		return comments;
	}

	/**
	 * @param comments the comments to set
	 */
	public void setComments(String comments) {
		this.comments = comments;
	}
	
	

}
