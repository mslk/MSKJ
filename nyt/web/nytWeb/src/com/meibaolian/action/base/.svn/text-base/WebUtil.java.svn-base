package com.meibaolian.action.base;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionContext;
import com.meibaolian.entity.Usermanager;
import com.meibaolian.util.UtilHelp;

/**
 *  action 帮助类
 * @author Administrator
 *
 */
public class WebUtil {
	
	/**
	 * 存储登录成功后的用户
	 * @param user
	 */
	public static void saveAdmin(Usermanager user){
		if(user!=null)
		ActionContext.getContext().getSession().put("admin", user);
//			getRequest().getSession().setAttribute("admin", user);
	}
	
	/**
	 * 移除登录用户
	 */
	public static void removeAdmin(){
       		ActionContext.getContext().getSession().remove("admin");
//		getRequest().getSession().removeAttribute("admin");
	}
	
	
	/**
	 * 获取登录的用户
	 * @return
	 */
	public static Usermanager getAdmin(HttpServletRequest req){
		if(null == req){
			return (Usermanager)ActionContext.getContext().getSession().get("admin");
		}
		return (Usermanager)req.getSession().getAttribute("admin");
	}
	
	
	/**
	 * 获取本次的验证码
	 * @return
	 */
	public static String checkCode()
	{
		return UtilHelp.notNullObj(ActionContext.getContext().getSession().get("rand"));
	}
	
	
	/**
	 * 获取httprequest 
	 * @return
	 */
	public static HttpServletRequest getRequest(){
		return ServletActionContext.getRequest();
	}

	
	/**
	 * 验证是否有权限
	 * @param key
	 * @param value
	 * @return
	 */
	public static boolean  validatePurivew(String key,String value){
		
//		if(!"".equals(UtilHelp.notNullStr(key)) && !"".equals(UtilHelp.notNullStr(value)))
//		{
//			AdminInfo info=getAdmin();
//			if(info!=null){
//				 
//				if(info.getPurviews().containsKey(key)){
//					
//					List<String> list=info.getPurviews().get(key);
//					if(list!=null && list.size()>0){
//						return list.contains(value);
//					}
//				}
//			}
//		}
		return false;
		
	}
	
	
	/** 
	* @Description: 设置数据到请求作用域
	* BaseAction.java : 
	* @param key  
	* @param value
	*/
	public static  void setRequestValue(String key,Object value){
		ServletActionContext.getRequest().setAttribute(key, value);
	}
	
	/**
	 * 根据参数获取值
	 * @param name
	 * @return
	 */
	public static String getRequestValue(String name){
		return UtilHelp.notNullStr(ServletActionContext.getRequest().getParameter(name));
	}

}
