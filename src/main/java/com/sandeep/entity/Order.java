package com.sandeep.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

/**
 * Order Payment Entity
 * @author sandeepsoni
 *
 */
@Entity(name="order_details")
public class Order extends AbstractAuditable {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@SequenceGenerator(name="seq", initialValue=1, allocationSize=100)
	@Column(name = "id")
	private Long orderId;
	
	@Column(name = "amount")
	private Long orderAmount;
	
	@Column(name = "due_date")
	private Date dueDate;
	
	@Column(name = "item_type")
	private String itemType;
	
	
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
	
	@OneToMany(mappedBy="order",  fetch = FetchType.LAZY )
	private List<OrderPayment> orderPaymentList;
	
	
	@Column(name = "khata_number")
	private Long khataNumber;
	
	@Column(name = "exchange_item_name")
	private String exchangeItemName;
	
	@Column(name = "exchange_item_quality")
	private Integer exchangeItemQuality;
	
	@Column(name = "exchange_weight")
	private Double exchangeItemWeight;
	
	@Column(name = "recieved_amount")
	private Long recievedAmount;

	/**
	 * @return the recievedAmount
	 */
	public Long getRecievedAmount() {
		return recievedAmount;
	}

	/**
	 * @param recievedAmount the recievedAmount to set
	 */
	public void setRecievedAmount(Long recievedAmount) {
		this.recievedAmount = recievedAmount;
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
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
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
	 * @return the exchangeItemWeight
	 */
	public Double getExchangeItemWeight() {
		return exchangeItemWeight;
	}

	/**
	 * @param exchangeItemWeight the exchangeItemWeight to set
	 */
	public void setExchangeItemWeight(Double exchangeItemWeight) {
		this.exchangeItemWeight = exchangeItemWeight;
	}

	
	
	



}
