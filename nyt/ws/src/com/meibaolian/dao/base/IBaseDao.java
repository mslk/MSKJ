package com.meibaolian.dao.base;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import com.meibaolian.util.exception.DataManagerException;
/**
 * 基本dao接口
 * @author Administrator
 *
 * @param <T>
 */
public interface IBaseDao<T> {
	
	/**
	 * 添加
	 * @param sql
	 * @param objs
	 * @param tableName
	 * @return 1 成功 0 失败
	 */
	public int  add(String sql,Object []objs ,String tableName);
	
	/**
	 * 添加数据后返回 这条数据的自动增长id
	 * @param sql
	 * @param objs 数组集合参数
	 * @param tableName
	 * @return 返回 自动增长的id
	 */
	public int addRTID(String sql,Object [] objs,String tableName);
	
	
	/**
	 * 更新
	 * @param sql
	 * @param objs
	 * @param tableName
	 * @return 0 失败  大于0 成功
	 */
	public int update(String sql,Object []objs,String tableName);
	
	/**
	 * 删除
	 * @param sql
	 * @param objs
	 * @param tableName
	 * @return  0 失败  大于0 成功
	 */
	public int deleteById(String sql,Object [] objs,String tableName);
	
	/**
	 * 根据id 查询
	 * @param sql
	 * @param objs
	 * @param tableName
	 * @param row
	 * @return 查询到的对象，或者null（无数据或者相关异常）
	 * @throws DataManagerException 
	 */
	public T getById(String sql,Object [] objs,String tableName,RowMapper<T> row) throws DataManagerException;
	
	/**
	 * 查询总数
	 * @param sql
	 * @param objs
	 * @param tableName
	 * @return 数据总数
	 * @throws DataManagerException 
	 */
	public long searchCount(String sql,Object [] objs,String tableName) throws  DataManagerException;
	
    /**
     * 查询集合
     * @param sql  查询sql
     * @param row  jdbctemplate的读取器
     * @param tableName  真实表名
     * @param page    页数
     * @param pageSize  每页显示数
     * @param objs  参数列表
     * @param orders  排序集合
     * @return 集合
     * @throws DataManagerException 
     */
	public QueryResult<T> search(String sql,RowMapper<T> row, String tableName,int page,int pageSize,Object []objs,LinkedHashMap<String, String> orders) throws DataManagerException;
	
    /**
     * 查询集合
     * @param sql  查询sql
     * @param row  jdbctemplate的读取器
     * @param tableName  真实表名
     * @return 集合
     * @throws DataManagerException 
     */
	public QueryResult<T> search(String sql,RowMapper<T> row, String tableName) throws DataManagerException;
	
    /**
     * 查询集合
     * @param sql  查询sql
     * @param row  jdbctemplate的读取器
     * @param tableName  真实表名
     * @param objs  参数列表
     * @param orders  排序集合
     * @return 集合
     * @throws DataManagerException 
     */
	public QueryResult<T> search(String sql,RowMapper<T> row, String tableName,Object []objs,LinkedHashMap<String, String> orders) throws DataManagerException;
	
    /**
     * 查询集合
     * @param sql  查询sql
     * @param row  jdbctemplate的读取器
     * @param tableName  真实表名
     * @param page    页数
     * @param pageSize  每页显示数
     * @return 集合
     * @throws DataManagerException 
     */
	public QueryResult<T> search(String sql,RowMapper<T> row, String tableName,int page,int pageSize) throws DataManagerException;
	
    /**
     * 查询集合
     * @param sql  查询sql
     * @param row  jdbctemplate的读取器
     * @param tableName  真实表名
     * @param page    页数
     * @param pageSize  每页显示数
     * @param objs  参数列表
     * @return 集合
     * @throws DataManagerException 
     */
	public QueryResult<T> search(String sql,RowMapper<T> row, String tableName,int page,int pageSize,Object []objs) throws DataManagerException;

    /**
     * 查询集合
     * @param sql  查询sql
     * @param row  jdbctemplate的读取器
     * @param tableName  真实表名
     * @param page    页数
     * @param pageSize  每页显示数
     * @param objs  参数列表
     * @param orders  排序集合
     * @return 集合
     * @throws DataManagerException 
     */
	public List<T> searchList(String sql,RowMapper<T> row, String tableName,int page,int pageSize,Object []objs,LinkedHashMap<String, String> orders) throws DataManagerException;
	
    /**
     * 查询集合
     * @param sql  查询sql
     * @param row  jdbctemplate的读取器
     * @param tableName  真实表名
     * @return 集合
     * @throws DataManagerException 
     */
	public List<T> searchList(String sql,RowMapper<T> row, String tableName) throws DataManagerException;
	
    /**
     * 查询集合
     * @param sql  查询sql
     * @param row  jdbctemplate的读取器
     * @param tableName  真实表名
     * @param objs  参数列表
     * @return 集合
     * @throws DataManagerException 
     */
	public List<T> searchList(String sql,RowMapper<T> row, String tableName,Object []objs) throws DataManagerException;
	
    /**
     * 查询集合
     * @param sql  查询sql
     * @param row  jdbctemplate的读取器
     * @param tableName  真实表名
     * @param page    页数
     * @param pageSize  每页显示数
     * @param objs  参数列表
     * @return 集合
     * @throws DataManagerException 
     */
	public List<T> searchList(String sql,RowMapper<T> row, String tableName,int page,int pageSize,Object []objs) throws DataManagerException;
	
    /**
     * 查询集合
     * @param sql  查询sql
     * @param row  jdbctemplate的读取器
     * @param tableName  真实表名
     * @param objs  参数列表
     * @param orders  排序集合
     * @return 集合
     * @throws DataManagerException 
     */
	public List<T> searchList(String sql,RowMapper<T> row, String tableName,Object []objs,LinkedHashMap<String, String> orders) throws DataManagerException;
	
	
}
