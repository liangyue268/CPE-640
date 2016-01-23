package com.bean;

import java.util.List;

public class pageBean 
{
	private int nowPage = 1   ;  
	private int perPageRows = 8; 
	
	private int allPages  ;     
	private long totalRows;     
	
	private List result;         
	
	public int getAllPages() 
	{
		return allPages;
	}
	public void setAllPages(int allPages) 
	{
		this.allPages = allPages;
	}
	public int getNowPage() 
	{
		return nowPage;
	}
	public void setNowPage(int nowPage) 
	{
		this.nowPage = nowPage;
	}
	public int getPerPageRows() 
	{
		return perPageRows;
	}
	public void setPerPageRows(int perPageRows) 
	{
		this.perPageRows = perPageRows;
	}
	public long getTotalRows() 
	{
		return totalRows;
	}
	public void setTotalRows(long totalRows) 
	{
		this.totalRows = totalRows;
	}
	public List getResult() 
	{
		return result;
	}
	public void setResult(List result) 
	{
		this.result = result;
	}
}
