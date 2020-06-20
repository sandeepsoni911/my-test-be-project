package com.sandeep.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sandeep.entity.Stock;

@Repository("stRepo")

public interface StockRepository extends JpaRepository<Stock, String>{

	@Query("update com.sandeep.entity.Stock st set st.stockCode= '234'  where st.stockId = '111'")
	void update(Stock stock);

}
