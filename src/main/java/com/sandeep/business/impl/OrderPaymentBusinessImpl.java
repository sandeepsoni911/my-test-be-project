package com.sandeep.business.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sandeep.business.OrderPaymentBusiness;
import com.sandeep.dto.BaseResponse;
import com.sandeep.dto.OrderPaymentDto;
import com.sandeep.service.OrderPaymentService;

@Component
@Transactional
public class OrderPaymentBusinessImpl implements OrderPaymentBusiness {
	
	@Autowired
	OrderPaymentService orderPaymentService;

	@Override
	public List<OrderPaymentDto> getAllPartialPayment(Long orderId) {
		
		return orderPaymentService.getAllPartialPayment(orderId);
	}

	@Override
	public BaseResponse saveOrderPartialPayment(OrderPaymentDto orderPaymentDetails) {
		BaseResponse baseResponse = new BaseResponse();
		if(orderPaymentDetails == null) {
			baseResponse.setMessage("Required details are null.");
			baseResponse.setStatus("FAILED");
		}
		baseResponse = orderPaymentService.saveOrderPartialPayment(orderPaymentDetails);
		
		return baseResponse;
	}

}
