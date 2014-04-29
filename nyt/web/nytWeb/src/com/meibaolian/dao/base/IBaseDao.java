package com.meibaolian.dao.base;

import java.io.Serializable;
import java.util.LinkedHashMap;
/**
 * 基础接口
 * @author chenpeng
 *
 * @param <T>
 */
public interface IBaseDao<T> {
	
	
	
	/**
	 * 根据id得到对象
	 * @param id
	 * @return
	 */
	public  T  get(Serializable id);
	
	/**
	 * 根据组合条件得到对象
	 * @param id
	 * @return 
	 */
	public  T  get(String where,Object [] params);
	
	
	/**
	 * 新增
	 * @param obj
	 */
	public void add(Object obj);
	
	/**
	 * 删除
	 * @param id
	 */
	public  void  delete(Serializable id);
	
	/**
	 * 删除
	 * @param id
	 */
	public  void  delete(String  where,Object [] params);
	
	/**
	 * 集合删除
	 * @param ids
	 */
	public void deleteIds(Serializable [] ids);

	/**
	 * 更新
	 * @param obj
	 */
	public void update(Object obj);
	
	/**
	 *  更新
	 * @param where  完整的sql更新语句 ,除了前面的update table
	 * @param params 对应
	 */
	public void updateBySql(String where,Object [] params);
	
	
	/**
	 * 查询总数
	 * @Title:searchCountByhql
	 * @author chenpeng
	 * @data  Jun 8, 2012 2:40:31 PM
	 * @description TODO
	 * @param hql
	 * @return
	 * @return long
	 */
	public long searchCountByhql(String hql,Object [] objs);
	
	/**
	 * 查询总数
	 * @Title:searchCountBysql
	 * @author chenpeng
	 * @data  Jun 8, 2012 2:40:31 PM
	 * @description TODO
	 * @param hql
	 * @return
	 * @return long
	 */
	public long searchCountBySql(String sql,Object [] objs);
	
	
	/**
	 * 无条件查询
	 * @param page 页数
	 * @param pageSize 每页显示数
	 * @return
	 */
	public QueryResult<T> search(int page,int pageSize);
	
	/**
	 * 带条件，带排序查询
	 * @param page 页数
	 * @param pageSize 每页显示数
	 * @param sql 条件sql 不需要表名 字段名 只需要where后面的条件
	 * @param params 条件sql参数集合
	 * @param orders 排序集合
	 * @return
	 */
	public QueryResult<T> search(int page,int pageSize,String where,Object [] params,LinkedHashMap<String, String> orders);
	
	/**
	 * 带排序查询
	 * @param page 页数
	 * @param pageSize 每页显示数
	 * @param orders 排序条件
	 * @return
	 */
	public QueryResult<T> search(int page,int pageSize,LinkedHashMap<String, String> orders);
	
	/**
	 * 带条件查询
	 * @param page 页数
	 * @param pageSize 每页显示
	 * @param sql 条件sql 不需要表名 字段名 只需要where后面的条件
	 * @param params 条件sql参数集合
	 * @return
	 */
	public QueryResult<T> search(int page,int pageSize,String where,Object [] params);
	
	/**
	 * 根据sql 查询相关
	 * @param sql
	 * @param page
	 * @param pageSize
	 * @param where
	 * @param params
	 * @param orders
	 * @return
	 */
	public QueryResult<T> searchSQLByParamter(String sql,String sqlCount,int page, int pageSize,
			String where, Object[] params, LinkedHashMap<String, String> orders,IReader<T> reader);
	
	
	/**
	 * 查询 带指定列查询的（为统计 无id字段的） 查询
	 * @Title:search
	 * @author chenpeng
	 * @data  Jun 11, 2012 11:48:10 AM
	 * @description TODO
	 * @param page
	 * @param pageSize
	 * @param where
	 * @param params
	 * @param orders
	 * @param countColunm
	 * @return
	 * @return QueryResult<T>
	 */
	public QueryResult<T> search(int page, int pageSize, String where,
			Object[] params, LinkedHashMap<String, String> orders,String countColunm);
	/**
	 * 直接执行insert、update sql
	 * @param sql 完整语句
	 * @param params 填充参数
	 * @return
	 */
	public long executeUpdateSql(String sql, Object[] params);
}
