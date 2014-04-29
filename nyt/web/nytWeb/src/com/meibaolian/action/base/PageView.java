package com.meibaolian.action.base;

import java.util.List;

import com.meibaolian.dao.base.QueryResult;

/**
 * 页面分页通用类
 * 
 * @author Administrator
 * 
 * @param <T>
 */
public class PageView<T> {

	/**
	 * 显示集合
	 */
	private List<T> queryList;

	/**
	 * 总页数
	 */
	private int totalPage;

	/**
	 * 当前页数
	 */
	private int currentlyPage;

	/**
	 * 每页显示数
	 */
	private int pageSize;
	/**
	 * 总行数
	 */
	private long totalRow;

	/**
	 * 页数 展示
	 */
	private PageStartToStop rowDisplay;

	public List<T> getQueryList() {
		return queryList;
	}

	public void setQueryList(List<T> queryList) {
		this.queryList = queryList;
	}

	public int getCurrentlyPage() {
		return currentlyPage;
	}

	public void setCurrentlyPage(int currentlyPage) {
		this.currentlyPage = currentlyPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public long getTotalRow() {
		return totalRow;
	}

	public void setTotalRow(long totalRow) {
		this.totalRow = totalRow;
		int midl = (int) totalRow / this.pageSize
				+ ((int) totalRow % this.pageSize == 0 ? 0 : 1);
		this.setTotalPage(midl);
		rowDisplay = new PageStartToStop(this.currentlyPage, this.totalPage);
	}

	public PageStartToStop getRowDisplay() {
		return rowDisplay;
	}

	public void setRowDisplay(PageStartToStop rowDisplay) {
		this.rowDisplay = rowDisplay;
	}

	public PageView(QueryResult<T> result, int currentlyPage, int pageSize) {

		this.currentlyPage = currentlyPage;
		this.pageSize = pageSize;
		if (result != null) {
			this.queryList = result.getQueryList();
			this.setTotalRow(result.getTotalRow());
		}
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

}
