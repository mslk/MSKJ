package com.meibaolian.dao.base;

import java.util.Hashtable;
import org.springframework.jdbc.core.JdbcTemplate;

import com.meibaolian.util.exception.NoDataSourceException;
import com.meibaolian.util.exception.NoJdbcTemplateException;
import com.meibaolian.util.tablehash.TableHashMap;


/**
 * jdbcHash 集合
 * @author Administrator
 *
 */
public class JdbcTemplateHash {
	
   	/**
   	 * jdbctemplate 集合
   	 */
   	Hashtable<String,JdbcTemplate> jdbcTeplements;

   	/**
   	 * 
   	*@author chenpeng email:chen422520@163.com
   	*@param jdbcTeplements
   	*@Description 
   	*@date Jul 11, 2012 5:32:21 PM
   	*@version
   	*
   	 */
	public void setJdbcTeplements(
			Hashtable<String, JdbcTemplate> jdbcTeplements) {
		this.jdbcTeplements = jdbcTeplements;
	} 
   	
    
    /**
     *  
    *@author chenpeng email:chen422520@163.com
    *@param tableName
    *@Description 根据表名获取jdbcTemplate
    *@date Jul 11, 2012 5:32:35 PM
    *@return JdbcTemplate
    *@version
     * @throws NoDataSourceException 
     * @throws NoJdbcTemplateException 
    *
     */
	public JdbcTemplate getJdbcTemplateByTable(String tableName) throws NoDataSourceException, NoJdbcTemplateException{
		
		String datasource=TableHashMap.getDataSourceValue(tableName);
		
		if(this.jdbcTeplements==null )
			throw new NoDataSourceException();
		
		JdbcTemplate template=this.jdbcTeplements.get(datasource);
		
		if(template==null)
			throw new NoJdbcTemplateException(" 没有实例 " +datasource +" 这个的jdbctemplate！");
		
		return template;
	}
	

}
