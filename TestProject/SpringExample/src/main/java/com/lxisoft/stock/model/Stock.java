package com.lxisoft.stock.model;

import java.io.Serializable;

public class Stock implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long stockId;
	private String stockCode;
	private String stockName;

	public void setStockId(Long stockId)
	{
		this.stockId=stockId;
	}
	public Long getStockId()
	{
		return stockId;
	}
	public void setStockCode(String stockCode)
	{
		this.stockCode=stockCode;
	}
	public String getStockCode()
	{
		return stockCode;
	}
	public void setStockName(String stockName)
	{
		this.stockName=stockName;
	}
	public String getStockName()
	{
		return stockName;
	}
}