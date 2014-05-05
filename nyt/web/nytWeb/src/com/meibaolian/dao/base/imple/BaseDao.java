package com.meibaolian.dao.base.imple;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;

import com.meibaolian.dao.base.DaoUtil;
import com.meibaolian.dao.base.GenericGetType;
import com.meibaolian.dao.base.IBaseDao;
import com.meibaolian.dao.base.IReader;
import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.util.UtilHelp;

/**
 * 基本数据操作类
 * 
 * @author Administrator
 * 
 * @param <T>
 */
public abstract class BaseDao<T> implements IBaseDao<T>
{

	@SuppressWarnings("unchecked")
	private Class className = GenericGetType.getGenericType(this.getClass(), 0);

	protected SessionFactory session;

	public void setSession(SessionFactory session)
	{
		this.session = session;
	}

	@Override
	public void add(Object obj)
	{
		session.getCurrentSession().save(obj);
	}

	@Override
	public void delete(Serializable id)
	{
		Object obj=get(id);
		session.getCurrentSession().delete(obj);
	}

	@Override
	/**
	 * 有待测试
	 */
	public void deleteIds(Serializable[] ids)
	{
		String hql = " delete from " + className.getName()
				+ " where id in :ids";
		session.getCurrentSession().createQuery(hql).setParameterList("ids",
				ids).executeUpdate();

		// session.createQuery(hql).setParameterList( "idd
		// ",idd_list).executeUpdate();
		for (Serializable id : ids)
		{
			delete(id);
		}
	}

	@Override
	public long searchCountByhql(String hql, Object[] objs)
	{

		Query query = session.getCurrentSession().createQuery(hql);
		setParameter(query, objs);
		Object obj = query.uniqueResult();

		try
		{
			if (obj != null)
			{
				return Long.valueOf(obj.toString()) ;
			}
		} catch (RuntimeException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;
	}

	@Override
	public void delete(String where, Object[] params)
	{

		String hql = " delete from "
				+ className.getName()
				+ ("".equals(UtilHelp.notNullStr(where)) ? "" : " where 1=1 "
						+ where);

		Query query = session.getCurrentSession().createQuery(hql);

		setParameter(query, params);
		query.executeUpdate();

	}

	@SuppressWarnings("unchecked")
	@Override
	public T get(String where, Object[] params)
	{

		String hql = " from "
				+ className.getName()
				+ ("".equals(UtilHelp.notNullStr(where)) ? " "
						: " where 1=1 " + where);

		Query query = session.getCurrentSession().createQuery(hql);

		setParameter(query, params);

		List list = query.list();

		if (list != null && list.size() == 1)
		{
			return (T) list.get(0);
		}
		return null;
	}

	@Override
	public void update(Object obj)
	{
		session.getCurrentSession().update(obj);
	}
	
	
	

	@Override
	public void updateBySql(String where, Object [] params) {
		
		String hql = " update "
			+ className.getName()+ UtilHelp.notNullStr(where);
		Query query = session.getCurrentSession().createQuery(hql);
		setParameter(query, params);
		query.executeUpdate();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public T get(Serializable id)
	{
		return (T) session.getCurrentSession().get(className, id);
	}

	@Override
	public QueryResult<T> search(int page, int pageSize, String where,
			Object[] params, LinkedHashMap<String, String> orders)
	{
         return search(page,pageSize,where,params,orders,null);
	}

	@SuppressWarnings("unchecked")
	@Override
	public QueryResult<T> search(int page, int pageSize, String where,
			Object[] params, LinkedHashMap<String, String> orders,
			String countColunm)
	{
		String sql = " from "
				+ className.getName()
				+ ("".equals(UtilHelp.notNullStr(where)) ? "" : " where 1=1 "
						+ where) + compagesOrders(orders);
		System.out.println(">>>>>>>>sql:"+sql );
		Query query = session.getCurrentSession().createQuery(sql);
		String sqlParams = setParameter(query, params);
	    System.out.println("=============sqlParams:" + sqlParams );
		if (page != -1 && pageSize != -1)
		{
			query.setFirstResult((page - 1) * pageSize).setMaxResults(pageSize);
		}
		List<T> list = query.list();
		long countNum = 0;
		if (page != -1 && pageSize != -1)
		{
			if(countColunm==null || "".equals(countColunm)){
				countColunm="id";
			}
			String sqlCount = " select count("+countColunm+") from "
					+ className.getName()
					+ ("".equals(UtilHelp.notNullStr(where)) ? ""
							: " where 1=1 " + where);
			//System.out.println(">>>>>>>>>>>>sqlCount" + sqlCount);
			query = session.getCurrentSession().createQuery(sqlCount);
			setParameter(query, params);
			Object obj = query.uniqueResult();
			if (obj != null)
				countNum = DaoUtil.objToLong(obj);
		}
		return new QueryResult<T>(list, countNum);
	}

	protected final String setParameter(Query query, Object[] params)
	{
		StringBuffer sb = new StringBuffer();
		if (query == null || params == null || params.length <= 0)
		{
			return "";
		}

		for (int i = 0; i < params.length; i++)
		{
			query.setParameter(i, params[i]);
			sb.append("【").append(params[i]).append("】");
		}
		return sb.toString();
	}

	protected static final String compagesOrders(
			LinkedHashMap<String, String> orders)
	{

		if (orders == null || orders.size() <= 0)
			return "";
		StringBuffer result = new StringBuffer(" order by ");

		Iterator<Map.Entry<String,String>> iterator=orders.entrySet().iterator();
		
		while(iterator.hasNext())
		{
			Map.Entry<String,String> entry=iterator.next();
			String key=entry.getKey();
			result.append(" ").append(key).append("  ").append(orders.get(key))
					.append(" , ");
		}
		result.deleteCharAt(result.lastIndexOf(","));
		return result.toString();
	}

	@Override
	public QueryResult<T> search(int page, int pageSize,
			LinkedHashMap<String, String> orders)
	{
		return search(page, pageSize, null, null, orders);
	}

	@Override
	public QueryResult<T> search(int page, int pageSize, String where,
			Object[] params)
	{
		return search(page, pageSize, where, params, null);
	}

	@Override
	public QueryResult<T> search(int page, int pageSize)
	{
		return search(page, pageSize, null);
	}

	@SuppressWarnings("unchecked")
	public QueryResult searchNewEntity(String hql, String countHql, int page,
			int pageSize, String where, Object[] params,
			LinkedHashMap<String, String> orders)
	{
		if (UtilHelp.isNotNullStr(where))
		{
			hql = hql + where + compagesOrders(orders);
			countHql = countHql + where + compagesOrders(orders);
		}
		Query query = session.getCurrentSession().createQuery(hql);
		String sqlParams = setParameter(query, params);
		if (page != -1 && pageSize != -1)
		{
			query.setFirstResult((page - 1) * pageSize).setMaxResults(pageSize);
		}
		List list = query.list();
		long countNum = 0;
		if (page != -1 && pageSize != -1)
		{
			query = session.getCurrentSession().createQuery(countHql);
			setParameter(query, params);
			Object obj = query.uniqueResult();
			if (obj != null)
				countNum = (Long) obj;
		}
		return new QueryResult(list, countNum);
	}

	@SuppressWarnings("unchecked")
	@Override
	public QueryResult<T> searchSQLByParamter(String sql, String sqlCount,
			int page, int pageSize, String where, Object[] params,
			LinkedHashMap<String, String> orders, IReader<T> reader)
	{

		String bsql = sql
				+ ("".equals(UtilHelp.notNullStr(where)) ? "" : " where 1=1 "
						+ where) + compagesOrders(orders);

		if (page != -1 && pageSize != -1)
		{
			bsql += " limit " + (page - 1) * pageSize + "," + pageSize;
		}
		SQLQuery sqlQuery = session.getCurrentSession().createSQLQuery(bsql);
		setParameter(sqlQuery, params);
		List<Object[]> list = sqlQuery.list();
		List<T> resultList = new ArrayList<T>();
		if (list != null)
		{
			for (int j = 0; j < list.size(); j++)
			{
				Object[] objs = list.get(j);
				if (objs != null)
				{
					resultList.add(reader.readerByList(objs));
				}
			}
		}
		long countNum = 0;
		if (page != -1 && pageSize != -1)
		{
			String bsqlCount = sqlCount
					+ ("".equals(UtilHelp.notNullStr(where)) ? ""
							: " where 1=1 " + where);
			sqlQuery = session.getCurrentSession().createSQLQuery(bsqlCount);
			setParameter(sqlQuery, params);
			Object obj = sqlQuery.uniqueResult();
			if (obj != null)
				countNum = DaoUtil.objToLong(obj);
		}
		return new QueryResult<T>(resultList, countNum);
	}

	@Override
	public long searchCountBySql(String sql, Object[] objs)
	{
		SQLQuery sqlQuery = session.getCurrentSession().createSQLQuery(sql);
		setParameter(sqlQuery, objs);
		Object obj = sqlQuery.uniqueResult();
		long countNum = 0;
		if (obj != null)
			countNum = DaoUtil.objToLong(obj);
		
		return countNum;
	}

	@Override
	public long executeUpdateSql(String sql, Object[] params) {
		SQLQuery sqlQuery = session.getCurrentSession().createSQLQuery(sql);
		setParameter(sqlQuery, params);
		return sqlQuery.executeUpdate();
	}

}
