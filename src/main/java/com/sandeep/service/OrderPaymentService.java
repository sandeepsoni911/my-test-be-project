package com.sandeep.service;

import java.util.List;

import com.sandeep.dto.BaseResponse;
import com.sandeep.dto.OrderPaymentDto;

/**
 * Service class for OrderPayment
 * @author sandeepsoni
 *
 */
public interface OrderPaymentService {

	
	/**
	 * To get all partial payments
	 * for loan id
	 * @param loanId
	 * @return
	 */
	List<OrderPaymentDto> getAllPartialPayment(Long orderId);
	
	/**
	 * To save partial payment
	 * @param loanPaymentDetails
	 * @return
	 */
	BaseResponse saveOrderPartialPayment(OrderPaymentDto orderPaymentDetails);

	
	



}
