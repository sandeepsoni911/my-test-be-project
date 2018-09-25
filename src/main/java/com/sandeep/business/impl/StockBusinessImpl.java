/**
 * 
 */
package com.sandeep.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sandeep.business.StockBusiness;
import com.sandeep.entity.Stock;
import com.sandeep.service.StockService;

/**
 * @author sandeepsoni
 *
 */
@Service
public class StockBusinessImpl implements StockBusiness {

	@Autowired
	StockService stockDao;

	public void setStockDao(StockService stockDao) {
		this.stockDao = stockDao;
	}

	public void save(Stock stock){
		stockDao.save(stock);
	}

	public void update(Stock stock){
		stockDao.update(stock);
	}

	public void delete(Stock stock){
		stockDao.delete(stock);
	}

	public Stock findByStockCode(String stockCode){
		return stockDao.findByStockCode(stockCode);
	}}
