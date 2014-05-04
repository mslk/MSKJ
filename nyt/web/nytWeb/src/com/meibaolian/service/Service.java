package com.meibaolian.service;

import java.util.List;

/**
 * Service基础接口,普通服务接口可以继承此接口
 * @author zhaojian
 * @version 1.0[2014.05.03 14:53]
 *
 */
public interface Service<T> {
	
	/**
	 * 条件分页查询
	 * @param t
	 * @param page
	 * @param pageSize
	 * @return
	 */
//	public QueryResult<T> searchList(T t, int page, int pageSize);
	 
	/**
	 * 查询所有记录
	 * @return
	 */
	public List<T> searchList();
	 
	/**
	 * 根据id获取对象
	 * @param id
	 * @return
	 */
	public T searchById(Integer id);
	
	/**
	 * 修改对象
	 * @param t
	 * @return
	 */
	public int update(T t);
	
	/**
	 * 根据id删除对象
	 * @param id
	 * @return
	 */
	public int delete(Integer id);
	
	/**
	 * 新增对象
	 * @param t
	 * @return
	 */
	public int add(T t);
	 
}
