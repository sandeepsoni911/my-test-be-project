package com.sandeep.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Order DTO 
 * @author sandeepsoni
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderDto {
	
	private Long orderId;
	
	private Long orderAmount;
	
	private Date dueDate;
	
	private String itemType;
	
	private Long customerId;
	
	private String comments;
	
	private String status;
	
	private String itemName;
	
	private Integer itemQuality ;
	
	private Double weight;
	
	private String customerName;
	
	private String customerCity;
	
	private Date createdDate;
	
	private Long khataNumber;
	
	private String exchangeItemName;
	
	private Integer exchangeItemQuality ;
	
	private Double exchangeWeight;
	
	private Long receivedAmount;

	

	/**
	 * @return the receivedAmount
	 */
	public Long getReceivedAmount() {
		return receivedAmount;
	}

	/**
	 * @param receivedAmount the receivedAmount to set
	 */
	public void setReceivedAmount(Long receivedAmount) {
		this.receivedAmount = receivedAmount;
	}

	/**
	 * @return the orderId
	 */
	public Long getOrderId() {
		return orderId;
	}

	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	/**
	 * @return the orderAmount
	 */
	public Long getOrderAmount() {
		return orderAmount;
	}

	/**
	 * @param orderAmount the orderAmount to set
	 */
	public void setOrderAmount(Long orderAmount) {
		this.orderAmount = orderAmount;
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
	 * @return the customerCity
	 */
	public String getCustomerCity() {
		return customerCity;
	}

	/**
	 * @param customerCity the customerCity to set
	 */
	public void setCustomerCity(String customerCity) {
		this.customerCity = customerCity;
	}

	/**
	 * @return the createdDate
	 */
	public Date getCreatedDate() {
		return createdDate;
	}

	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

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
	 * @return the exchangeItemName
	 */
	public String getExchangeItemName() {
		return exchangeItemName;
	}

	/**
	 * @param exchangeItemName the exchangeItemName to set
	 */
	public void setExchangeItemName(String exchangeItemName) {
		this.exchangeItemName = exchangeItemName;
	}

	/**
	 * @return the exchangeItemQuality
	 */
	public Integer getExchangeItemQuality() {
		return exchangeItemQuality;
	}

	/**
	 * @param exchangeItemQuality the exchangeItemQuality to set
	 */
	public void setExchangeItemQuality(Integer exchangeItemQuality) {
		this.exchangeItemQuality = exchangeItemQuality;
	}

	/**
	 * @return the exchangeWeight
	 */
	public Double getExchangeWeight() {
		return exchangeWeight;
	}

	/**
	 * @param exchangeWeight the exchangeWeight to set
	 */
	public void setExchangeWeight(Double exchangeWeight) {
		this.exchangeWeight = exchangeWeight;
	}
	
	

}
