package com.meibaolian.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import org.apache.log4j.Logger;



/**
 * 相关配置属性
 * 
 * @author Administrator
 * 
 */
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
	 * 文件上传根目录
	 */
	public static final String FILEROOTPATH = null;
	
	/**
	 * 手机验证码
	 */
	public static final String PHONECHECK = "_code_mbl";
	
	/**
	 * 手机验证码有效时间
	 */
	public static int phoneCheckTime;
	
	/**
	 * 忘记密码时验证码
	 */
	public static final String UPDATECHECK = "_updatecode_mbl";
	
	/**
	 * 用户token 后缀
	 */
	public static final String TOKENSUFFIX = "_token_mbl";
	/**
	 * 用户对象
	 */
	public static final String USERINFOSUFFIX = "_info_mbl";
	/**
	 * 会话过期值，秒
	 */
	public static  int sessiontimeout;
   
	/**
	 * 默认页数
	 */
	public static final int PAGE = 1;

	/**
	 * 默认每页显示数
	 */
	public static final int PAGESIZE = 20;


	/**
	 * 编码格式
	 */
	public static final String ENCODING = "utf-8";


    //图片地址
	public static final String PATHPREFIX="http://10.123.11.135:8000/uhz_images/";
	public static  String uploadPath; //图片上传地址
	public static  String tempPath;  // 图片临时地址
	
	
	
	/**
	 * 煤炭搜索类型，1-(卖方搜索)求购信息
	 */
	public static final int searchtype_Purchase = 1;
	/**
	 * 煤炭搜索类型，0-(买方搜索)供应信息
	 */
	public static final int searchtype_Provider = 0;
	/**
	 * 物流搜索类型，1-找货
	 */
	public static final int searchtype_demand = 1;
	/**
	 * 物流搜索类型，0-找车
	 */
	public static final int searchtype_supply = 0;
	/**
	 * 排序编号到字段的映射
	 */
	private static Map<Integer,String> orderColumnMap = new HashMap<Integer,String>();
	/**
	 * 运输方式-铁路
	 */
	public static final int TRANSPORTTYPE_RAILWAY = 0;
	/**
	 * 运输方式-公路
	 */
	public static final int TRANSPORTTYPE_HIGNWAY = 1;
	/**
	 * 读取服务配置文件是否成功,默认失败
	 */
	public static boolean serviceConfig;

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

	/**
 	 * 用户状态-有效
 	 */
 	public static int USERSTATUS_VALID = 0;
 	/**
 	 * 用户状态-无效
 	 */
 	public static int USERSTATUS_INVALID = 2;

	
	static 
	{
		Logger logger = Logger.getLogger(ConfigUtil.class);
		boolean value = false;
		try
		{
			
//			//正数升序，负数降序
//			orderColumnMap.put(1, "realname");//报价人
//			orderColumnMap.put(2, "place");//交货地
//			orderColumnMap.put(3, "quantity");//数量
//			orderColumnMap.put(4, "price");//不含税价格
//			orderColumnMap.put(5, "validdate");//有效期
//			orderColumnMap.put(6, "sortnumber");//默认排序
//			orderColumnMap.put(7, "heating");//发热量
//			orderColumnMap.put(8, "ash");//灰分
//			orderColumnMap.put(9, "sulphur");//硫分
//			orderColumnMap.put(10, "moisture");//全水
//			orderColumnMap.put(11, "taxprice");//含税价格
//			orderColumnMap.put(12, "totalprice");//不含税总价
//			orderColumnMap.put(13, "totaltaxprice");//含税总价
			
			Properties properties = new Properties();
			InputStream input = ConfigUtil.class.getClassLoader()
					.getResourceAsStream("config.properties");
			logger.debug(input);
			properties.load(input);
			SERVICEMODE = UtilHelp.strToInt(properties.getProperty("servicemode"));
			 
			// 公共配置
	         sessiontimeout = UtilHelp.strToInt(properties.get("sessiontimeout")
					.toString());
	         phoneCheckTime=UtilHelp.strToInt(properties.get("phonechecktime")
					.toString());

			// 针对配置
	            uploadPath=UtilHelp.strNotNull(properties.get("uploadPath"+SERVICEMODE).toString());
	            tempPath=UtilHelp.strNotNull(properties.get("tempPath"+SERVICEMODE).toString());
	            IMAGEPREFIX=UtilHelp.strNotNull(properties.get("imagePrefix"+SERVICEMODE).toString());
				redisUrl = UtilHelp.strNotNull(properties.get(
						"redisurl" + SERVICEMODE).toString());
				redisPort = UtilHelp.strToInt(properties.get(
						"redisport" + SERVICEMODE).toString());
				redisPassword = UtilHelp.strNotNull(properties.get(
						"redispassword" + SERVICEMODE).toString());
				redisMsgTime = UtilHelp.strToInt(properties.get(
						"redismsgtime" + SERVICEMODE).toString());
			

				if ( sessiontimeout<=0 || "".equals(redisUrl) || redisPort <= 0
						|| "".equals(redisPassword) || redisMsgTime <= 0)
				{
					value = false;
				} else
				{
					value = true;
				}


		} catch (IOException e)
		{
			logger.error("配置错误!", e);
		} catch (Exception e)
		{
			logger.error("配置错误!", e);
		}

		finally
		{
			serviceConfig = value;
		}

	}
	/**
	 * 出售单表排序
	 */
	public static final int ORDERTYPE_PROVIDER = 0;
	/**
	 * 求购单表排序
	 */
	public static final int ORDERTYPE_PURCHASE = 1;
	/**
	 * 找车表排序
	 */
	public static final int ORDERTYPE_TRANSPORTDEMAND = 2;
	/**
	 * 找货表排序
	 */
	public static final int ORDERTYPE_TRANSPORTSUPPLY = 3;
	/**
	 * 出售单、运价表联合排序
	 */
	public static final int ORDERTYPE_PROVIDER_RATE = 4;
	/**
	 * 获取排序字段名
	 * @param orderNum
	 * @param type 排序字段所属的表
	 * @return
	 */
	public static String getOrderColumn(int orderNum, int type){
		if(orderNum == 0){
			return orderColumnMap.get(6);
		}
		//买方查询出售单含运价
		if (type == ORDERTYPE_PROVIDER_RATE && (orderNum == 3 || orderNum == 4
				|| orderNum == 7 || orderNum == 11 || orderNum == 12
				|| orderNum == 13)) {
			return orderColumnMap.get(orderNum);
		}
		//买、卖方查询求购单
		if (type == ORDERTYPE_PURCHASE && (orderNum == 3 || (orderNum >= 7 && orderNum <= 10) )) {
			return orderColumnMap.get(orderNum);
		}
		//卖方查询出售单
		if (type == ORDERTYPE_PROVIDER && (orderNum == 3 || orderNum == 4 || orderNum >= 7  )) {
			return orderColumnMap.get(orderNum);
		}
		//找车、找货无产地
		if(type == ORDERTYPE_TRANSPORTDEMAND || type == ORDERTYPE_TRANSPORTSUPPLY){
			return orderColumnMap.get(6);
		}
		return orderColumnMap.get(6);
	}
	/**
	 * 返回排序字段映射
	 * @param order
	 * @param type
	 * @return
	 */
	public static LinkedHashMap<String, String> getOrderMap(int order, int type){
		//先人工排序，再其他
		/*String column = orderColumnMap.get(6);
		LinkedHashMap<String, String> orders = new LinkedHashMap<String, String> (1);
		orders.put(column, "desc");
		if(order != 0){
			//正数升序，负数降序
			column = getOrderColumn(Math.abs(order), type);
			orders.put(column, order>0?"asc":"desc");
		}*/
		//默认人工排序
		LinkedHashMap<String, String> orders = new LinkedHashMap<String, String> (1);
		String column = getOrderColumn(Math.abs(order), type);
		//正数升序，负数降序
		orders.put(column, (order > 0 ? "asc" : "desc") );
		return orders;
	}
}
