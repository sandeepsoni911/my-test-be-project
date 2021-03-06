package com.sandeep.business;

import java.util.List;

import com.sandeep.dto.BaseResponse;
import com.sandeep.dto.OrderDto;
import com.sandeep.dto.OrderListResponse;


public interface OrderBusiness {
	
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
	OrderListResponse  getAllOrderDetails(Integer pageNumber, Integer perPage);

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
