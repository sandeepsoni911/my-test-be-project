package com.sandeep.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Order Payment DTO
 * @author sandeepsoni
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderPaymentDto {

	
	private Long orderId;
	
	private Long partialPaymentAmount;
	
	private Long balanceAmount;
	
	private Long orderPaymentId;
	
	private String comment;
	
	private Date createdOn;
	
	private String paymentType;

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
	 * @return the orderPaymentId
	 */
	public Long getOrderPaymentId() {
		return orderPaymentId;
	}

	/**
	 * @param orderPaymentId the orderPaymentId to set
	 */
	public void setOrderPaymentId(Long orderPaymentId) {
		this.orderPaymentId = orderPaymentId;
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
	
	

}
