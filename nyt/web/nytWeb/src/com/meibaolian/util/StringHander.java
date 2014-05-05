package com.meibaolian.util;

/**
 * 
 * 字符串辅助类
 * @author zhaojian
 * @version 1.0[2014.05.04 15:36]
 * 
 */
public class StringHander {
	
	/**
	 * 判断字符串是不是空,如果是空则返回true,否则返回false
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str){
		if(null == str || "".equals(str) || str.length() ==0)
			return true;
		else 
			return false;
	}
	
	/**
	 * 判断字符串不为空,不为空则返回true,否则返回false
	 * @param str
	 * @return
	 */
	public static boolean isNotEmpty(String str){
		return !isEmpty(str);
	}
}
