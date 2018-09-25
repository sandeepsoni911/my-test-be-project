package com.sandeep.business;


import java.util.List;

import com.sandeep.dto.BaseResponse;
import com.sandeep.dto.OrderPaymentDto;

/**
 * Interface for OrderPayment
 * @author sandeepsoni
 *
 */
public interface OrderPaymentBusiness {
	
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
