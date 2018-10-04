package com.sandeep.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sandeep.business.OrderBusiness;
import com.sandeep.business.OrderPaymentBusiness;
import com.sandeep.dto.BaseResponse;
import com.sandeep.dto.OrderDto;
import com.sandeep.dto.OrderListResponse;
import com.sandeep.dto.OrderPaymentDto;

/**
 * Controller class for Order APIs
 * @author sandeepsoni
 *
 */

@RestController
public class OrderController {
	
	@Autowired
	OrderBusiness orderBusiness;
	
	@Autowired
	OrderPaymentBusiness orderPaymentBusiness;
	
	@CrossOrigin
	@RequestMapping(value="/order" , method=RequestMethod.GET)
	public @ResponseBody OrderListResponse getOrderDetails(Integer pageNumber, Integer perPage){
		OrderListResponse response = null;
		response = orderBusiness.getAllOrderDetails(pageNumber, perPage);
		return response;
	}
	
	@CrossOrigin
	@RequestMapping(value="/order/{orderId}" , method=RequestMethod.GET)
	public @ResponseBody OrderDto getOrderDetailsByLoanId(@PathVariable Long orderId){
		OrderDto response = null;
		response = orderBusiness.getOrderDetailsByOrderId(orderId);
		return response;
	}
	
	@CrossOrigin
	@RequestMapping(value= "/orderDetailsByCustomer" ,method = RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE )
	public @ResponseBody List<OrderDto>  getAllOrderByCustomerDetails(Long customerId, String customerName){
		List<OrderDto> orderDetailList = orderBusiness.getAllOrderDetailsByCustomer( customerId, customerName); 
		return orderDetailList;
		
	}
	
	@CrossOrigin
	@RequestMapping(value= "/orderPayment" ,method = RequestMethod.POST, produces= MediaType.APPLICATION_JSON_VALUE )
	public @ResponseBody BaseResponse  saveOrderPayment(@RequestBody OrderPaymentDto orderPaymentDto){
		BaseResponse baseResponse = new BaseResponse();
		baseResponse = orderPaymentBusiness.saveOrderPartialPayment(orderPaymentDto);
		return baseResponse;
		
	}
	
	
	@CrossOrigin
	@RequestMapping(value= "/orderPayment/{orderId}" ,method = RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE )
	public @ResponseBody List<OrderPaymentDto>  saveOrderPayment(@PathVariable Long orderId){
		List<OrderPaymentDto>  response = new ArrayList<OrderPaymentDto>();
		response = orderPaymentBusiness.getAllPartialPayment(orderId);
		return response;
		
	}
	
	
	@CrossOrigin
	@RequestMapping(value= "/order" ,method = RequestMethod.POST, produces= MediaType.APPLICATION_JSON_VALUE )
	public @ResponseBody BaseResponse  saveOrderDetail(@RequestBody OrderDto order){
		BaseResponse baseResponse = new BaseResponse();
		baseResponse = orderBusiness.saveOrderDetails(order);
		return baseResponse;
		
	}

}
