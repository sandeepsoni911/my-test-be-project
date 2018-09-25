package com.sandeep.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sandeep.dto.BaseResponse;
import com.sandeep.dto.OrderDto;
import com.sandeep.entity.Customer;
import com.sandeep.entity.Order;
import com.sandeep.repository.CustomerRepository;
import com.sandeep.repository.OrderRepository;
import com.sandeep.service.OrderService;
/**
 * Implementation class for OrderService
 * @author sandeepsoni
 *
 */
@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	CustomerRepository customerRepository;

	@Override
	public BaseResponse saveOrderDetails(OrderDto detailsDto) {
		BaseResponse response = new BaseResponse();
		Order order = convertToOrderEntity(detailsDto);
		
		order = orderRepository.save(order);
		
		if(order != null) {
			response.setMessage("Saved Successfully.");
			response.setMessage("SUCCESS");
		}else {
			response.setMessage("An Error Occurred.");
			response.setMessage("FAILED");
		}
		
		return response;
	}

	/**
	 * To conver to Entity
	 * @param detailsDto
	 * @return
	 */
	private Order convertToOrderEntity(OrderDto dto) {
		
		Order order = null;
		if(dto != null) {
			Customer customer = customerRepository.getCustomerDetailsById(dto.getCustomerId());
			order = new Order();
			order.setComments(dto.getComments());
			order.setCreatedBy("User");
			order.setCreatedDate(dto.getCreatedDate());
			order.setCustomer(customer);
			order.setDueDate(dto.getDueDate());
			order.setExchangeItemName(dto.getExchangeItemName());
			order.setExchangeItemQuality(dto.getExchangeItemQuality());
			order.setExchangeItemWeight(dto.getExchangeWeight());
			order.setItemName(dto.getItemName());
			order.setItemQuality(dto.getItemQuality());
			order.setItemType(dto.getItemType());
			order.setKhataNumber(dto.getKhataNumber());
			order.setLastModifiedBy("User");
			order.setLastModifiedDate(new Date());
			order.setOrderAmount(dto.getOrderAmount());
			order.setRecievedAmount(dto.getReceivedAmount());
			order.setStatus("OPEN");
			order.setWeight(dto.getWeight());
		}
		return order;
	}

	@Override
	public List<OrderDto> getAllOrderDetails() {
		List<OrderDto> orderDetailsList = null;
		List<Order> orderList = orderRepository.getAllOrders();
		if(CollectionUtils.isNotEmpty(orderList)) {
			orderDetailsList = new ArrayList<OrderDto>();
			for(Order order : orderList) {
				OrderDto dto = convertToOrderDto(order);
				orderDetailsList.add(dto);
			}
		}
		return orderDetailsList;
	}

	/**
	 * To convert To OrderDto
	 * @param orderDetailsList
	 * @param order
	 */
	private OrderDto convertToOrderDto( Order order) {
		OrderDto dto = null;
		if(order != null) {
			dto = new OrderDto();	
			dto.setComments(order.getComments());
			dto.setCreatedDate(order.getCreatedDate());
			dto.setCustomerCity(order.getCustomer().getCustomerCity());
			dto.setCustomerId(order.getCustomer().getCustomerId());
			dto.setCustomerName(order.getCustomer().getCustomerName());
			dto.setDueDate(order.getDueDate());
			dto.setExchangeItemName(order.getExchangeItemName());
			dto.setExchangeItemQuality(order.getExchangeItemQuality());
			dto.setExchangeWeight(order.getExchangeItemWeight());
			dto.setItemName(order.getItemName());
			dto.setOrderAmount(order.getOrderAmount());
			dto.setItemQuality(order.getItemQuality());
			dto.setItemType(order.getItemType());
			dto.setKhataNumber(order.getKhataNumber());
			dto.setOrderId(order.getOrderId());
			dto.setStatus(order.getStatus());
			dto.setWeight(order.getWeight());
			dto.setReceivedAmount(order.getRecievedAmount());
		}
		return dto;
		
	}

	@Override
	public List<OrderDto> getAllOrderDetailsByCustomer(Long customerId, String customerName) {
		List<OrderDto> orderDetailsList = null;
		List<Order> orderList = orderRepository.getAllOrdersByCustomerNameOrId(customerId, customerName);
		if(CollectionUtils.isNotEmpty(orderList)) {
			orderDetailsList = new ArrayList<OrderDto>();
			for(Order order : orderList) {
				OrderDto dto = convertToOrderDto(order);
				orderDetailsList.add(dto);
			}
		}
		return orderDetailsList;
	}

	@Override
	public OrderDto getOrderDetailsByOrderId(Long orderId) {
		OrderDto orderDetails = null;
		Order order = orderRepository.getOrderDetailsByOrderId(orderId);
		if(order != null) {
			orderDetails = new OrderDto();
			orderDetails = convertToOrderDto(order);
		}
		return orderDetails;
	}

}
