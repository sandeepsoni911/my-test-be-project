package com.sandeep.service;

import java.util.List;

import com.sandeep.dto.BaseResponse;
import com.sandeep.dto.OrderDto;

/**
 * Service class for Orders
 * @author sandeepsoni
 *
 */
public interface OrderService {
	
	/**
	 * TO save loan details
	 * @param detailsDto
	 * @return
	 */
	BaseResponse saveOrderDetails(OrderDto detailsDto);

	/**
	 * To get all loans 
	 * @return
	 */
	List<OrderDto>  getAllOrderDetails();

	/**
	 * To get all loans by customer
	 * @param customerId
	 * @param customerName
	 * @return
	 */
	List<OrderDto> getAllOrderDetailsByCustomer(Long customerId,
			String customerName);
	
	/**
	 * To get loans details
	 * by loanId
	 * @return
	 */
	OrderDto  getOrderDetailsByOrderId(Long orderId);



}