package com.sandeep.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sandeep.entity.Customer;

/**
 * Repository for customer entitiy
 * @author sandeepsoni
 *
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer , String>{
	
	@Query("select customer from com.sandeep.entity.Customer customer where id=?1")
	Customer  getLoanDetailsByloanId(Long customerId);
	
	@Query("select customer from com.sandeep.entity.Customer customer where id=?1")
	Customer  getCustomerDetailsById(Long customerId);

}
