package com.meibaolian.dao.base;

import java.util.List;
/**
 * 数据集合
 * @author Administrator
 *
 * @param <T>
 */
public class QueryResult<T> {
	
	
	private List<T> list;
	
	private int page;
	
	private int pageSize;
	
	private Long countNumber;

	/**
	 * 
	*@author chenpeng email:chen422520@163.com
	*@date Jul 11, 2012 5:33:50 PM
	*@version
	 * @return List
	*
	 */
	public List<T> getList() {
		return list;
	}

	/**
	 * 
	*@author chenpeng email:chen422520@163.com
	*@param list
	*@date Jul 11, 2012 5:34:12 PM
	*@version
	*
	 */
	public void setList(List<T> list) {
		this.list = list;
	}

	/**
	 * 
	*@author chenpeng email:chen422520@163.com
	*@date Jul 11, 2012 5:34:22 PM
	*@return Long
	*@version
	*
	 */
	public Long getCountNumber() {
		return countNumber;
	}

	/**
	 * 
	*@author chenpeng email:chen422520@163.com
	*@param countNumber
	*@date Jul 11, 2012 5:34:32 PM
	*@version
	*
	 */
	public void setCountNumber(Long countNumber) {
		this.countNumber = countNumber;
	}

	
	/**
	 * @return the page
	 */
	public int getPage()
	{
		return page;
	}

	/**
	 * @param page the page to set
	 */
	public void setPage(int page)
	{
		this.page = page;
	}

	/**
	 * @return the pageSize
	 */
	public int getPageSize()
	{
		return pageSize;
	}

	/**
	 * @param pageSize the pageSize to set
	 */
	public void setPageSize(int pageSize)
	{
		this.pageSize = pageSize;
	}

	/**
	 * 构造方法
	 * @param list
	 * @param countRow
	 * @param page
	 * @param pageSize
	 */
	public QueryResult(List<T> list, long countRow,int page,int pageSize) {
		this.list = list;
		this.countNumber = countRow;
		this.page=page;
		this.pageSize=pageSize;
	}


	
	

}
