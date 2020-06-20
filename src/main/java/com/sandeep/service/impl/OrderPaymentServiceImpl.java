package com.sandeep.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sandeep.dto.BaseResponse;
import com.sandeep.dto.OrderPaymentDto;
import com.sandeep.entity.Order;
import com.sandeep.entity.OrderPayment;
import com.sandeep.repository.OrderPaymentRepository;
import com.sandeep.repository.OrderRepository;
import com.sandeep.service.OrderPaymentService;
/**
 * Implementation class for OrderPaymentService
 * @author sandeepsoni
 *
 */
@Service
public class OrderPaymentServiceImpl implements OrderPaymentService {
	
	@Autowired
	OrderPaymentRepository orderPaymentRepository;
	
	@Autowired
	OrderRepository orderRepository;

	@Override
	public List<OrderPaymentDto> getAllPartialPayment(Long orderId) {
		List<OrderPaymentDto> responseList = null;
		List<OrderPayment>  response = orderPaymentRepository.getAllPaymentsByOrderId(orderId);
		if(CollectionUtils.isNotEmpty(response)) {
			responseList = new ArrayList<OrderPaymentDto>();
			for(OrderPayment payment : response) {
				responseList.add(convertToOrderDTO(payment));
			}
		}
		return responseList;
	}
	
	
	/**
	 * Convert To DTO
	 * @param payment
	 * @return
	 */
	private OrderPaymentDto convertToOrderDTO(OrderPayment payment) {
		OrderPaymentDto orderDTO = null;
		if(payment != null) {
			 orderDTO = new OrderPaymentDto();
			 orderDTO.setBalanceAmount(payment.getBalanceAmount());
			 orderDTO.setComment(payment.getComment());
			 orderDTO.setCreatedOn(payment.getCreatedDate());
			 orderDTO.setOrderId(payment.getOrder().getOrderId());
			 orderDTO.setOrderPaymentId(payment.getOrderPaymentId());
			 orderDTO.setPartialPaymentAmount(payment.getPartialAmount());
			 orderDTO.setPaymentType(payment.getPaymentType());
		}
		return orderDTO;
	}

	@Override
	public BaseResponse saveOrderPartialPayment(OrderPaymentDto orderPaymentDetails) {
		BaseResponse baseResponse = new BaseResponse();
		Order order = orderRepository.getOrderDetailsByOrderId(orderPaymentDetails.getOrderId());
		if(order == null) {
			baseResponse.setMessage("System doesn't found any order with orderId :"
									+orderPaymentDetails.getOrderId());
			baseResponse.setStatus("FAILED");
			return baseResponse;
		}
		OrderPayment orderPaymentBalance =orderPaymentRepository.getBalanceAmountForOrderId(orderPaymentDetails.getOrderId());
		Long pendingAmount = orderPaymentBalance!=null?orderPaymentBalance.getBalanceAmount()
							:(order.getOrderAmount()-order.getRecievedAmount());
		OrderPayment orderPayment = converToOrderPayment(orderPaymentDetails);
		
		orderPayment.setBalanceAmount(pendingAmount-orderPaymentDetails.getPartialPaymentAmount());
		if((pendingAmount-orderPaymentDetails.getPartialPaymentAmount()) == 0) {
			order.setStatus("Closed");
		}
		orderPayment.setOrder(order);
		orderPayment = orderPaymentRepository.save(orderPayment);
		if(orderPayment != null) {
			baseResponse.setMessage("Successfully Saved Payment Details");
			baseResponse.setStatus("SUCCESS");
		}else {
			baseResponse.setMessage("An error occured while saving details.");
			baseResponse.setStatus("FAILED");
		}
		return baseResponse;
	}

	/**
	 * To convert to Entity Object
	 * @param orderPaymentDetails
	 * @return
	 */
	private OrderPayment converToOrderPayment(OrderPaymentDto details) {
		OrderPayment orderPayment = null;
		if(details != null) {
			orderPayment = new OrderPayment();
			orderPayment.setBalanceAmount(details.getBalanceAmount());
			orderPayment.setComment(details.getComment());
			orderPayment.setCreatedBy("USER");
			orderPayment.setLastModifiedBy("USER");
			orderPayment.setLastModifiedDate(new Date());
			orderPayment.setCreatedDate(details.getCreatedOn());
			//orderPayment.setOrder(order);
			orderPayment.setOrderPaymentId(details.getOrderPaymentId());
			orderPayment.setPartialAmount(details.getPartialPaymentAmount());
			orderPayment.setPaymentType(details.getPaymentType());
			
		}
		return orderPayment;
	}

}
