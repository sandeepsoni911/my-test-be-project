package com.sandeep.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sandeep.entity.OrderPayment;

/**
 * Repository class for OrderPayment
 * @author sandeepsoni
 *
 */
@Repository
public interface OrderPaymentRepository extends JpaRepository<OrderPayment, String>{
	
	@Query("select op from com.sandeep.entity.OrderPayment op where op.order.orderId=?1")
	List<OrderPayment>  getAllPaymentsByOrderId(Long orderId);
	
	@Query(value="select * from order_payments where order_id=?1 order by created_on desc limit 1;", nativeQuery=true)
	OrderPayment  getBalanceAmountForOrderId(Long orderId);

}
