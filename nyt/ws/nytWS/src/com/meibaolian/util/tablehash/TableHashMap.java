package com.meibaolian.util.tablehash;

import java.util.HashMap;

import com.meibaolian.util.exception.NoDataSourceException;

/**
 * 数据库映射集合类
 * @author Administrator
 *
 */
public class TableHashMap {

	
	/**
	 * 表对应数据源 集合
	 */
	static  HashMap<String,String>  tableWithDatasource =new HashMap<String, String>();
	
	
	static{
        tableWithDatasource.put("userinfo", "default");
        tableWithDatasource.put("purchase", "default");
        tableWithDatasource.put("purchasepush", "default");
        tableWithDatasource.put("provider", "default");
        tableWithDatasource.put("providerpush", "default");
        tableWithDatasource.put("searchlog_coal", "default");
        tableWithDatasource.put("callphonelog", "default");
        tableWithDatasource.put("highwayrate", "default");
        tableWithDatasource.put("province", "default");
        tableWithDatasource.put("customer", "default");
        tableWithDatasource.put("beginstation", "default");
        tableWithDatasource.put("railwayrate", "default");
        tableWithDatasource.put("coalparticlesize", "default");
        tableWithDatasource.put("station", "default");
        tableWithDatasource.put("advertising", "default");
        tableWithDatasource.put("transportsupply", "default");
        tableWithDatasource.put("transportdemand", "default");
        tableWithDatasource.put("transportsupplypush", "default");
        tableWithDatasource.put("transportdemandpush", "default");
        tableWithDatasource.put("deliveryarea", "default");
        tableWithDatasource.put("deliveryplace", "default");
        tableWithDatasource.put("coaltype", "default");
        tableWithDatasource.put("city", "default");
        tableWithDatasource.put("county", "default");
        tableWithDatasource.put("helpcenter", "default");
        tableWithDatasource.put("quality_control", "default");
        tableWithDatasource.put("user_proposal", "default");
        tableWithDatasource.put("accesslog_login", "default");
        tableWithDatasource.put("accesslog_module", "default");
        tableWithDatasource.put("searchlog_transport", "default");
        
        tableWithDatasource.put("type_list", "default");
	}
	
	/**
	*@author chenpeng email:chen422520@163.com
	*@param  tableName 表名
	*@Description 根据表名找到对应的 数据库连接
	*@date Jul 11, 2012 10:54:02 AM
	*@return  返回对应的数据源名称
	*@version
	*@throws NoDataSourceException  没有对应的数据源异常
	*
	 */
	public static String  getDataSourceValue(String tableName) throws NoDataSourceException{
		String dataSource=tableWithDatasource.get(tableName.trim());
		if(dataSource==null || "".equals(dataSource)){
//			throw new NoDataSourceException( tableName+"无此对应数据源！");
			return "default";
		}
		return dataSource;
	}
	
	
}
