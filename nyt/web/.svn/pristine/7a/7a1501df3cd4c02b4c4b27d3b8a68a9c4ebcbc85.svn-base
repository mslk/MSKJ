package com.meibaolian.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;

public class ConfigUtil 
{
	
	
 	/**
 	 * 默认配置为测试环境
 	 */
 	public static  int SERVICEMODE=1;

 	/**
 	 * 图片服务器前缀
 	 */
 	public static String IMAGEPREFIX;
     
    /**
      * 文件上传目录
    */
    public static  String FILEROOTPATH;
     
     /**
      * 编码格式
      */
     public static final String ENCODING="UTF-8";

 	/**
 	 * 用户状态-有效
 	 */
 	public static int USERSTATUS_VALID = 0;
 	/**
 	 * 用户状态-无效
 	 */
 	public static int USERSTATUS_INVALID = 2;
	/**
	 * 用户对象
	 */
	public static final String USERINFOSUFFIX = "_info_mbl";
	
	// ============== redis连接配置 ======================
	/**
	 * redis 的url
	 */
	public static String redisUrl ;

	/**
	 * redis 端口号
	 */
	public static int redisPort ;

	/**
	 * redis 密码
	 */
	public static String redisPassword ;

	/**
	 * redis 消息超时时间 (秒)
	 */
	public static int redisMsgTime ;

	/**
	 * 最大分配的对象数
	 */
	public static final int MAXACTIVE = 200;
	/**
	 * 最大能够保持idel状态的对象数
	 */
	public static final int MAXIDLE = 200;
	/**
	 * 当池内没有返回对象时，最大等待时间
	 */
	public static final int MAXWAIT = 1000;
	/**
	 * (取连接) 当调用borrow Object方法时，是否进行有效性检查
	 */
	public static final boolean TESTONBORROW = true;
	/**
	 * (返回连接)当调用return Object方法时，是否进行有效性检查
	 */
	public static final boolean TESTONRETURN = true;


	// ============== redis连接配置 ======================
 	static{
 		Logger logger = Logger.getLogger(ConfigUtil.class);
 		try {
			
			Properties properties = new Properties();
			InputStream input = ConfigUtil.class.getClassLoader()
					.getResourceAsStream("config.properties");
			logger.debug(input);
			properties.load(input);
			SERVICEMODE = UtilHelp.stringToInt(properties.getProperty("servicemode"));
			// 公共配置
			// 针对配置
			IMAGEPREFIX=UtilHelp.notNullStr(properties.get("imagePrefix"+SERVICEMODE).toString());
			FILEROOTPATH=UtilHelp.notNullStr(properties.get("filerootpath"+SERVICEMODE).toString());
			redisUrl = UtilHelp.notNullStr(properties.get(
					"redisurl" + SERVICEMODE).toString());
			redisPort = UtilHelp.stringToInt(properties.get(
					"redisport" + SERVICEMODE).toString());
			redisPassword = UtilHelp.notNullStr(properties.get(
					"redispassword" + SERVICEMODE).toString());
			redisMsgTime = UtilHelp.stringToInt(properties.get(
					"redismsgtime" + SERVICEMODE).toString());
		 
		} catch (IOException e) {
			logger.error(e);
		}
 	}
 	/** 
 	* @Description: 获取属性配置文件中的某一属性的值（属性文件的路径应该放在根目录下，即src目录下或者classes目录下）
 	* @author: leihailong
 	* @date: 2011-4-19
 	* @param fileName 属性文件名称 如:serverAddress.properties
 	* @param propertyName 属性名 如：aaa = 123 ，则属性名为aaa
 	* @return
 	*/
 	public static String getProperty(String fileName,String propertyName) {
 		String returnstr="";
 		try {
 		  InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
 		  Properties props = new Properties();
 		  props.load(inputStream);
 		  returnstr=props.getProperty(propertyName);
 		  if(inputStream!=null)
 		  {
 			  inputStream.close();
 		  }
 		} catch (IOException e) {
 			returnstr="";
 		} 
 		return returnstr;
 	  }
     
}
