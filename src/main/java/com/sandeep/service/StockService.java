package com.sandeep.service;

import com.sandeep.entity.Stock;

public interface StockService {
	
	void save(Stock stock);
	void update(Stock stock);
	void delete(Stock stock);
	Stock findByStockCode(String stockCode);

}
