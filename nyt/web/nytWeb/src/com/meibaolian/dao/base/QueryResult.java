package com.meibaolian.dao.base;

import java.util.List;
/**
 * 查询结果集通用类
 * @author Administrator
 *
 * @param <T>
 */
public class QueryResult<T> {

	
	/**
	 * 显示集合
	 */
	private List<T> queryList;
	
	/**
	 * 总行数
	 */
	private  long totalRow;
	
	public List<T> getQueryList() {
		return queryList;
	}

	public void setQueryList(List<T> queryList) {
		this.queryList = queryList;
	}

	public long getTotalRow() {
		return totalRow;
	}

	public void setTotalRow(long totalRow) {
		this.totalRow = totalRow;
	}

	public QueryResult(List<T> queryList, long totalRow) {
		this.queryList = queryList;
		this.totalRow = totalRow;
	}
	
	
	
	
}
