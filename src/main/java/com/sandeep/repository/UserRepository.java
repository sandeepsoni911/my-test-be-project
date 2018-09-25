package com.sandeep.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sandeep.entity.User;

public interface UserRepository  extends JpaRepository<User , String>{
	
	@Query("select user from com.sandeep.entity.User user where username=?1 and password=?2")
	User  getLoanDetailsByloanId(String userName, String password);

}
