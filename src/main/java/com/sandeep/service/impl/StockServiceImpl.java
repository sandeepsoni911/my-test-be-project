package com.sandeep.service.impl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sandeep.entity.Stock;
import com.sandeep.repository.StockRepository;
import com.sandeep.service.StockService;

@Repository("StockDao")
public  class StockServiceImpl  implements StockService {
	
	private static final Logger logger = LoggerFactory.getLogger(StockServiceImpl.class);
	
	@Autowired
	StockRepository stRepo;


	public void save(Stock stock){
		logger.info("Inside save method");
		stRepo.save(stock);
	}

	public void update(Stock stock){
		logger.info("Inside update method");
		stRepo.update(stock);
	}

	public void delete(Stock stock){
		logger.info("Inside delete method");
		stRepo.delete(stock);
	}

	public Stock findByStockCode(String stockCode){
//		List list = ((Object) session).find(
//                     "from Stock where stockCode=?",stockCode
//                );
//		return (Stock)list.get(0);
		return null;
	}




	

}
