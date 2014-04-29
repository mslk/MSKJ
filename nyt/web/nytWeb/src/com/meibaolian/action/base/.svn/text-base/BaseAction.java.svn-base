/**   
* @Title: 基础acton 类 
* @Package com.pro.action 
* @Description: TODO 
* @author LHL  
* @date 2011-6-1 下午05:53:17 
* @version V1.0   
*/
package com.meibaolian.action.base;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
/**   
 * @Title: BaseAction.java 
 * @Package com.pro.action 
 * @Description: TODO 
 * @version V1.0      
 */
public class BaseAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	 
	
	public static final Integer PAGESIZE = 10;
	
	public static final String SYSTEMSHOW ="advertising";
	
	public static final String MESSAGE="message";
	
	
	/**
	 * 分页展示
	 */
	public static final String SHOWRESULT="result";
	
	/**
	 * 跳转Url
	 */
	public static final String TARGETURL="targetUrl";
	
	private Integer page;
	
	public Integer getPage() {
		return page==null?1:(page<1?1:page);
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	
	public void saveMessage(String messageValue ,String targetUrlValue)
	{
		WebUtil.setRequestValue(MESSAGE, messageValue);
		WebUtil.setRequestValue(TARGETURL, targetUrlValue);
	}
	
	public void savePageView(PageView<?> result)
	{
		WebUtil.setRequestValue(SHOWRESULT, result);
	}
	
	public void saveList(List<?> list)
	{
		WebUtil.setRequestValue(SHOWRESULT, list);
	}
	
	
	public void savePageObj(Object obj)
	{
		WebUtil.setRequestValue(SHOWRESULT,obj);
	}
	
}
