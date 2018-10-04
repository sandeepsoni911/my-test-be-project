package com.sandeep.business.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.sandeep.business.OrderBusiness;
import com.sandeep.dto.BaseResponse;
import com.sandeep.dto.OrderDto;
import com.sandeep.dto.OrderListResponse;
import com.sandeep.service.OrderService;

/**
 * Business Impl class
 * @author sandeepsoni
 *
 */
@Component
@Transactional()
public class OrderBusinessImpl implements OrderBusiness {
	
	private static final Logger logger = LoggerFactory.getLogger(OrderBusinessImpl.class);
	
	@Autowired
	OrderService orderService;

	@Override
	public BaseResponse saveOrderDetails(OrderDto detailsDto) {
		BaseResponse response = new BaseResponse();
		if(detailsDto != null) {
			response = orderService.saveOrderDetails(detailsDto);
		}
		
		return response;
	}

	@Override
	public OrderListResponse getAllOrderDetails(Integer pageNumber, Integer perPage) {
		logger.info("Fetching all order details");
		return orderService.getAllOrderDetails(pageNumber, perPage);
	}

	@Override
	public List<OrderDto> getAllOrderDetailsByCustomer(Long customerId, String customerName) {
		logger.info("Fetching all order details for customer id: {}, customerName : {}", customerId, customerName);
		return  orderService.getAllOrderDetailsByCustomer(customerId, customerName);
	}

	@Override
	public OrderDto getOrderDetailsByOrderId(Long orderId) {
		logger.info("Fetching all order details for orderId : {}", orderId);
		return orderService.getOrderDetailsByOrderId(orderId);
	}

}
