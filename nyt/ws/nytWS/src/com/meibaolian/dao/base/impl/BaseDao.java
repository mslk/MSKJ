package com.meibaolian.dao.base.impl;

import static com.meibaolian.util.tablehash.TableHashMap.getDataSourceValue;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.meibaolian.dao.base.IBaseDao;
import com.meibaolian.dao.base.JdbcTemplateHash;
import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.util.UtilHelp;
import com.meibaolian.util.exception.DataManagerException;
import com.meibaolian.util.exception.NoDataSourceException;
import com.meibaolian.util.exception.NoJdbcTemplateException;

/**
 * 数据操作基本类
 * 
 * 所有的 add delete update 与 查询总数 的操作 失败返回 -100 所有对象 和集合的查询 错误和没有 返回 null
 * 
 * @author Administrator
 * 
 * @param <T>
 */
@Repository(value = "baseDao")
public abstract class BaseDao<T> implements IBaseDao<T> {

	
	private Logger baseDaoLogger=Logger.getLogger(" baseDaoLogger: ");
	
	
	@Override
	public int addRTID(final String sql,final Object[] objs, String tableName) {
		
	  KeyHolder  keyHolder=new GeneratedKeyHolder();
	  
	  try {
		    String dataSource = getDataSourceValue(tableName);
			JdbcTemplate jdbcTemplateNew = this.jdbcTempleate;
			if (!"default".equals(dataSource)) {
				jdbcTemplateNew = jdbcTemplateHashs
						.getJdbcTemplateByTable(tableName);
			}
			
			jdbcTemplateNew.update(new PreparedStatementCreator(){

				@Override
				public PreparedStatement createPreparedStatement(Connection conn)
						throws SQLException {
					PreparedStatement pre=conn.prepareStatement(sql,new String[]{"shangjia_id"});
					pre=conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
					if(objs!=null && objs.length>0){
						for(int i=0;i<objs.length;i++){
							pre.setObject(i+1, objs[i]);
						}
					}
					return pre;
				}},keyHolder);
			return keyHolder.getKey().intValue();
			
	} catch (NoDataSourceException e) {
		baseDaoLogger.error("没有数据源 ：", e);
	} catch (NoJdbcTemplateException e) {
		baseDaoLogger.error("没有对应的jdbcTemplate ：", e);
	}
		return UtilHelp.ERRORCODE;
	}

	/**
	 * 默认的jdbcTemplate
	 */
	protected JdbcTemplate jdbcTempleate;

	/**
	 * jdbcTemplate 集合
	 */
	protected JdbcTemplateHash jdbcTemplateHashs;

	/**
	*@author chenpeng email:chen422520@163.com
	*@param jdbcTemplateHashs
	*@date Jul 11, 2012 11:14:39 AM
	*@version
	**/
	@Resource(name = "jdbcTeplementHashs")
	public void setJdbcTemplateHashs(JdbcTemplateHash jdbcTemplateHashs) {
		this.jdbcTemplateHashs = jdbcTemplateHashs;
	}

	/**
	*@author chenpeng email:chen422520@163.com
	*@param jdbcTemplateDf
	*@date Jul 11, 2012 11:14:51 AM
	*@version
	**/
	@Resource(name = "jdbcTempleateDefault")
	public void setJdbcTempleate(JdbcTemplate jdbcTemplateDf) {
		this.jdbcTempleate = jdbcTemplateDf;
	}

	@Override
	public int deleteById(String sql, Object[] objs, String tableName) {

		return baseManager(sql, objs, tableName);
	}

	private int baseManager(String sql, Object[] objs, String tableName) {
		try {
			String dataSource = getDataSourceValue(tableName);
			JdbcTemplate jdbcTemplateNew = this.jdbcTempleate;
			if (!"default".equals(dataSource)) {
				jdbcTemplateNew = jdbcTemplateHashs
						.getJdbcTemplateByTable(tableName);
			}
			return jdbcTemplateNew.update(sql, objs);
		} catch (NoDataSourceException e) {
			baseDaoLogger.error("没有数据源 ：", e);
		} catch (DataAccessException e) {
			baseDaoLogger.error("数据操作错误 ：", e);
		} catch (NoJdbcTemplateException e) {
			baseDaoLogger.error("没有对应的jdbcTemplate ：", e);
		}
		return UtilHelp.ERRORCODE;
	}

	@Override
	public int add(String sql, Object[] objs, String tableName) {

		return baseManager(sql, objs, tableName);
	}

	@Override
	public int update(String sql, Object[] objs, String tableName) {
		return baseManager(sql, objs, tableName);
	}
	
	@Override
	public T getById(String sql, Object[] objs, String tableName, RowMapper<T> row) throws DataManagerException {

		JdbcTemplate jdbcT = this.jdbcTempleate;
		try {
			String dataSource = getDataSourceValue(tableName);
			if (!"default".equals(dataSource)) {
				jdbcT = jdbcTemplateHashs.getJdbcTemplateByTable(tableName);
			}
			return jdbcT.queryForObject(sql, objs, row);
		} catch (NoDataSourceException e) {
			baseDaoLogger.error("没有数据源 ：", e);
		} catch (NoJdbcTemplateException e) {
			baseDaoLogger.error("没有对应的jdbcTemplate ：", e);
		} catch (DataAccessException e) {
			baseDaoLogger.error("数据操作错误 ：", e);
			if(e instanceof EmptyResultDataAccessException)return null;
		}
		throw UtilHelp.DATAMANAGERERROR;// new DataManagerException();
	}
	
	@Override
	public QueryResult<T> search(String sql, RowMapper<T> row,
			String tableName, int page, int pageSize, Object[] objs,
			LinkedHashMap<String, String> orders) throws DataManagerException {

		List<T> list = null;
		String searchSql = addOrderByParamters(sql, orders);
		Object[] objnew = null;
		if (page != -1 && pageSize != -1) {
			if (objs != null && objs.length > 0) {
				objnew = new Object[objs.length + 2];
				System.arraycopy(objs, 0, objnew, 0, objs.length);
			} else {
				objnew = new Object[2];
			}

			objnew[objnew.length - 2] = (page - 1) * pageSize;
			objnew[objnew.length - 1] = pageSize;
			searchSql += " limit ?,?";
		} else {

			objnew = objs;
		}

		try {
			String dataSource = getDataSourceValue(tableName);

			JdbcTemplate jdbcTemplateNew = this.jdbcTempleate;

			if (!"default".equals(dataSource)) {
				jdbcTemplateNew = jdbcTemplateHashs
						.getJdbcTemplateByTable(tableName);
			}

			list = jdbcTemplateNew.query(searchSql, objnew, row);
			
			baseDaoLogger.info("===== searchSql:"+searchSql);
			StringBuffer paramStr = new StringBuffer();
			for(int i=0;i<objnew.length;i++){
				paramStr.append("(") .append((i+1)).append(")").append(objnew[i]).append(",");
			}
			baseDaoLogger.info("===== params:"+paramStr.toString());
			
			if(list==null || list.size()==0)return null;
			
			long countNunmber = 0;

			if (page != -1 && pageSize != -1) {
				String sqlCount = replateTableSearchCount(sql);
				baseDaoLogger.info("===== sqlCount:"+sqlCount);
				if (!"".equals(sqlCount)) {
					countNunmber = searchCount(sqlCount, objs, tableName);
				}
			}else{
				countNunmber = list.size();
			}
			return new QueryResult<T>(list, countNunmber, page, pageSize);
		} catch (NoDataSourceException e) {
			baseDaoLogger.error("没有数据源 ：", e);
		} catch (NoJdbcTemplateException e) {
			baseDaoLogger.error("没有对应的jdbcTemplate ：", e);
		} catch (DataAccessException e) {
			if(e instanceof EmptyResultDataAccessException)return null;
			baseDaoLogger.error("", e);
		}
//		catch(NullPointerException e)
//		{
//			baseDaoLogger.error("没有数据 ：", e);
//		}
		
		throw UtilHelp.DATAMANAGERERROR;
	}

	private String addOrderByParamters(String sql,
			LinkedHashMap<String, String> orders) {
		if (orders == null || orders.size() == 0) {
			return sql;
		}
		StringBuilder builder = new StringBuilder(sql);
		builder.append("  order  by ");
		for (Entry<String, String> entry : orders.entrySet()) {
			builder.append(" ").append(entry.getKey()).append(" ").append(
					entry.getValue()).append(" , ");
		}
		builder.deleteCharAt(builder.lastIndexOf(","));
		return builder.toString();
	}

	@Override
	public long searchCount(String sql, Object[] objs, String tableName) throws DataManagerException {
		try {
			String dataSource = getDataSourceValue(tableName);
			JdbcTemplate jdbcTemplateNew = this.jdbcTempleate;
			if (!"default".equals(dataSource)) {
				jdbcTemplateNew = jdbcTemplateHashs
						.getJdbcTemplateByTable(tableName);
			}
			return jdbcTemplateNew.queryForLong(sql, objs);
		} catch (NoDataSourceException e) {
			baseDaoLogger.error("没有数据源 ：", e);
		} catch (NoJdbcTemplateException e) {
			baseDaoLogger.error("没有对应的jdbcTemplate ：", e);
		} catch (DataAccessException e) {
			baseDaoLogger.error("数据操作错误 ：", e);
		}
		throw UtilHelp.DATAMANAGERERROR;
	}


	@Override
	public QueryResult<T> search(String sql, RowMapper<T> row,
			String tableName, int page, int pageSize, Object[] objs) throws DataManagerException {
		return search(sql, row, tableName, page, pageSize, objs, null);
	}

	@Override
	public QueryResult<T> search(String sql, RowMapper<T> row,
			String tableName, int page, int pageSize) throws DataManagerException {
		return search(sql, row, tableName, page, pageSize, null, null);
	}

	@Override
	public QueryResult<T> search(String sql, RowMapper<T> row,
			String tableName, Object[] objs,
			LinkedHashMap<String, String> orders) throws DataManagerException {
		return search(sql, row, tableName, -1, -1, objs, orders);
	}

	@Override
	public QueryResult<T> search(String sql, RowMapper<T> row, String tableName) throws DataManagerException {
		return search(sql, row, tableName, -1, -1);
	}

	
	

	@Override
	public List<T> searchList(String sql, RowMapper<T> row, String tableName,
			int page, int pageSize, Object[] objs,
			LinkedHashMap<String, String> orders) throws DataManagerException {

		String searchSql = addOrderByParamters(sql, orders);
		Object[] objnew = null;
		if (page != -1 && pageSize != -1) {
			if (objs != null && objs.length > 0) {
				objnew = new Object[objs.length + 2];
				System.arraycopy(objs, 0, objnew, 0, objs.length);
			} else {
				objnew = new Object[2];
			}

			objnew[objnew.length - 2] = (page - 1) * pageSize;
			objnew[objnew.length - 1] = pageSize;
			searchSql += " limit ?,?";
		} else {

			objnew = objs;
		}

		try {
			String dataSource = getDataSourceValue(tableName);

			JdbcTemplate jdbcTemplateNew = this.jdbcTempleate;

			if (!"default".equals(dataSource)) {
				jdbcTemplateNew = jdbcTemplateHashs.getJdbcTemplateByTable(tableName);
			}
			return jdbcTemplateNew.query(searchSql, objnew, row);
		} catch (DataAccessException e) {
			baseDaoLogger.error("数据操作错误 ：", e);
			if(e instanceof EmptyResultDataAccessException)return null;
		} catch (NoDataSourceException e) {
			baseDaoLogger.error("没有数据源 ：", e);
		} catch (NoJdbcTemplateException e) {
			baseDaoLogger.error("没有对应的jdbcTemplate ：", e);
		}
		throw UtilHelp.DATAMANAGERERROR;
	}

	@Override
	public List<T> searchList(String sql, RowMapper<T> row, String tableName,
			int page, int pageSize, Object[] objs) throws DataManagerException {
		return searchList(sql,row,tableName,page,pageSize,objs,null);
	}

	@Override
	public List<T> searchList(String sql, RowMapper<T> row, String tableName,
			Object[] objs, LinkedHashMap<String, String> orders) throws DataManagerException {
		return searchList(sql,row,tableName,-1,-1,objs,orders);
	}

	@Override
	public List<T> searchList(String sql, RowMapper<T> row, String tableName,
			Object[] objs) throws DataManagerException {
		return searchList(sql, row, tableName, -1, -1, objs);
	}

	@Override
	public List<T> searchList(String sql, RowMapper<T> row, String tableName) throws DataManagerException {
		return searchList(sql, row, tableName, null);
	}

	/**
	*@author chenpeng email:chen422520@163.com
	*@param sql
	*@Description 
	*@date Jul 11, 2012 11:15:38 AM
	*@return  把查询集合语句替换为查询 集合总数的语句
	*@version
	**/
	public static String replateTableSearchCount(String sql) {
		if (sql == null || "".equals(sql)) {
			return "";

		}
		if (sql.indexOf("select") != -1 && sql.indexOf("from") != -1) {
			return sql.substring(0, sql.indexOf("select") + 6) + " count(1) "
					+ sql.substring(sql.indexOf("from"));
		}
		return "";

	}

	

}
