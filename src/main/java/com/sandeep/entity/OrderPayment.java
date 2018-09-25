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

/**
 * Order Payment Entity
 * @author sandeepsoni
 *
 */
@Entity(name="order_payments")
public class OrderPayment extends AbstractAuditable {

	
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@SequenceGenerator(name="seq", initialValue=1, allocationSize=100)
	@Column(name = "id")
	private Long orderPaymentId;
	
	@Column(name = "amount")
	private Long partialAmount;
	
	
	@ManyToOne( fetch=FetchType.LAZY)
	@JoinColumn(name="order_Id")
	private Order order;
	
	@Column(name = "balance_loan_amount")
	private Long balanceAmount;
	
	@Column(name = "comment")
	private String comment;
	
	
	@Column(name = "payment_type")
	private String paymentType;


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
	 * @return the order
	 */
	public Order getOrder() {
		return order;
	}


	/**
	 * @param order the order to set
	 */
	public void setOrder(Order order) {
		this.order = order;
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
