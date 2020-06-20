package com.sandeep.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Dto class for loan details	
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class LoanDetailsDto {
	
	private Long loanId;
	
	private Long loanAmount;
	
	private Date dueDate;
	
	private String itemType;
	
	private Long customerId;
	
	private Float rateOfInterest;
	
	private String comments;
	
	private String status;
	
	private String itemName;
	
	private Integer itemQuality ;
	
	private Double weight;
	
	private String customerName;
	
	private String customerCity;
	
	private Date createdDate;
	
	
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

	

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getCustomerCity() {
		return customerCity;
	}

	public void setCustomerCity(String customerCity) {
		this.customerCity = customerCity;
	}

	/**
	 * @return the customerName
	 */
	public String getCustomerName() {
		return customerName;
	}

	/**
	 * @param customerName the customerName to set
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
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
	 * @return the customerId
	 */
	public Long getCustomerId() {
		return customerId;
	}

	/**
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
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
