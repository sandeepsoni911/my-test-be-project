package com.sandeep.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sandeep.entity.Loan;

/**
 * Repository class for Loan entity
 * @author sandeepsoni
 *
 */
@Repository
public interface LoanRepository extends JpaRepository<Loan, String>{
	
	
	@Query("select loan from com.sandeep.entity.Loan loan")
	List<Loan>  getAllLoanDetails();
	
	@Query("select loan from com.sandeep.entity.Loan loan where loan.status='OPEN'")
	List<Loan>  getOpenLoanDetails();
	
	@Query("select loan from com.sandeep.entity.Loan loan where id=?1")
	Loan  getLoanDetailsByloanId(Long loan);
	
	@Query("select loan from com.sandeep.entity.Loan loan where loan.customer.customerId=?1 or loan.customer.customerName=?2")
	List<Loan>  getAllLoansByCustomerNameOrId(Long id, String name);
	
	

}
