package com.meibaolian.web.base;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import com.meibaolian.entity.UserInfo;
import com.meibaolian.util.redis.DataToRedis;
public class WebUtil {

	static Logger logger = Logger.getLogger(WebUtil.class);
	
	/**
	 * 保存用户信息 放入redis 或者memecache 
	 * id  -->令牌
	 * 
	 * @param userinfo
	 */
	public static void saveUserToken(String id,String token)
	{
		DataToRedis.saveUserToken(id, token);
	}

	/**
	 * 获取用户信息
	 * id  -->令牌
	 * @param userinfo
	 */
	public static String getUserToken(String id) {
        
		return DataToRedis.getUserToken(id);
	}
	/**
	 * 保存用户信息
	 * @param id
	 * @param company
	 */
	public static void saveUserEntity(String id, UserInfo userinfo){
		DataToRedis.saveUserInfo(id, userinfo);
	}
	/**
	 * 获取用户信息
	 * @param id
	 * @return
	 */
	public static UserInfo getUserEntity(String id){
		return DataToRedis.getUserInfo(id);
	}
	/**
	 * 通用数据输出json  最多支持3个扩展字段
	 * @param response 
	 * @param type 枚举类型,处理结果
	 * @param values 输出集合 扩展字段 1-3 
	 */
	
	public static void outputMsgExpandJson(HttpServletResponse response,ResultType type,List<String> values) 
	{
		BaseMessage<Object> base=new BaseMessage<Object>();
		base.setStatus(type.toString());
		base.setData("");
		
		if(values!=null)
		{
			if(values.size()==1)
			{
				base.setExpand1(values.get(0));
			}
			
			if(values.size()==2)
			{
				base.setExpand1(values.get(0));
				base.setExpand2(values.get(1));
			}
			
			if(values.size()==3)
			{
				base.setExpand1(values.get(0));
				base.setExpand2(values.get(1));
				base.setExpand3(values.get(2));
			}
		}
		outputMesage(response, base);
	}
	
	public static void outputMsgJson(HttpServletResponse response,ResultType type) 
	{
		outputMsgExpandJson(response, type, null);
	}
	
	/**
	 * 输出带 有obj expand1 expand2 expand3
	 * 对象的 json
	 */
	public static void outputMsgObjJson(HttpServletResponse response,ResultType type,String expand1,String expand2,String expand3,Object obj)
	{
		if(obj==null){obj="";}
		outputMesage(response,new BaseMessage<Object>(type.toString(),expand1,expand2,expand3,obj));
	}
	/**
	 * 输出带 有obj expand1 
	 * 对象的 json
	 */
	public static void outputMsgObjJson(HttpServletResponse response,ResultType type,String expand1,Object obj)
	{
		if(obj==null){obj="";}
		outputMesage(response,new BaseMessage<Object>(type.toString(),expand1,"","",obj));
	}
	
	/**
	 * 输出只带有obj 对象的 json
	 */
	public static void outputMsgObjJson(HttpServletResponse response,ResultType type,Object obj)
	{
		outputMsgObjJson(response,type,"",obj);
	}
	
	
	/**
	 * 将list数据输出 json
	 * @param response
	 * @param message
	 */
	public static void outputSuccessJson(HttpServletResponse response,
			List<?> list) {
		outputMesage(response, new BaseMessage<Object>(ResultType.SUCCESS.toString(),"","","",list));
	}

	/**
	 * 带list page pagesize 的json 输出
	 * @param response
	 * @param list
	 * @param page
	 * @param pageSize
	 * @param countRow
	 */
	public static void outputSuccessJson(HttpServletResponse response,
			List<?> list, int page, int pageSize, long countRow) {
		outputMesage(response, new BaseMessage<Object>(ResultType.SUCCESS.toString(),  "" + page, ""
				+ pageSize, "" + countRow,list));
	}



	/**
	 * 200 有数据 400 无数据 404 服务器错误
	 * 
	 * @param type
	 * @param response
	 * @param message
	 */
	public static void outputMesage(HttpServletResponse response,
			BaseMessage<Object> base) {
		String result = "";
		try {
			result=generateJson(base);
			if(result.length() <=250){
				logger.debug("==== result ===  "+result);
			}
			if(response!=null){
			PrintWriter printWriter = response.getWriter();
			printWriter.write(result);
			printWriter.flush();
			printWriter.close();
			}
		} catch (IOException e) {
			logger.error("发送:" + result + " 错误!", e);
		}

	}
	
	private static String generateJson(BaseMessage<Object> base)
	{
		try
		{
			JSONObject jsonObj = JSONObject.fromObject(base);
			return jsonObj.toString();
		} catch (Exception e)
		{
			e.printStackTrace();
			logger.error(e);
			return null;
		}
	}

	
	
	public static void main(String[] args) {
		
		UserInfo userInfo =null;
		ResultType type=ResultType.SUCCESS;
		outputMsgObjJson(null, type, userInfo);
		userInfo =new UserInfo();
		userInfo.setAddress("a");
		userInfo.setId(1);
		outputMsgObjJson(null, type, userInfo);
//		
//		List<UserInfo> list=new ArrayList<UserInfo>();
//		list.add(userInfo);
//		list.add(userInfo);
//		list.add(userInfo);
//		list.add(userInfo);
//		
//		outputMsgObjJson(null, type, list);
//		UserInfo userInfo =null;
//		ResultType type=ResultType.SUCCESS;
//		outputMsgObjJson(null, type, userInfo);
//		userInfo =new UserInfo();
//		userInfo.setAddress("a");
//		userInfo.setId(1);
//		outputMsgObjJson(null, type, userInfo);
		
//		XMLSerializer xml = new XMLSerializer();
//		JSONObject json = JSONObject.fromObject(new BaseMessage());
//		System.out.println(xml.write(json));
		
	
		
	}
	
}
