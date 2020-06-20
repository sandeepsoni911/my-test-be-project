package com.sandeep.business;

import com.sandeep.entity.Stock;

public interface StockBusiness {

	void save(Stock stock);
	void update(Stock stock);
	void delete(Stock stock);
	Stock findByStockCode(String stockCode);
}
