package com.sandeep.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sandeep.entity.Order;


/**
 * Repository class for Order Entity
 * @author sandeepsoni
 *
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, String>{
	
	@Query("select odr from com.sandeep.entity.Order odr where odr.customer.customerId=?1 or odr.customer.customerName=?2")
	List<Order>  getAllOrdersByCustomerNameOrId(Long id, String name);
	
	@Query("select odr from com.sandeep.entity.Order odr")
	List<Order>  getAllOrders(Pageable pageable);
	
	@Query("select count(odr) from com.sandeep.entity.Order odr")
	Long  getAllOrdersCount();
	
	
	@Query("select odr from com.sandeep.entity.Order odr where odr.id=?1")
	Order  getOrderDetailsByOrderId(Long orderId);
}
