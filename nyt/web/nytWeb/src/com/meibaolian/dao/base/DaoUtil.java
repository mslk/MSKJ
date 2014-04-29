package com.meibaolian.dao.base;

import java.util.Date;

public class DaoUtil {
	
	/**
	 * obj 转string
	 * @param obj
	 * @return
	 */
	public static String objToString(Object obj){
		if(obj==null) return "";
		
		try {
			return (String)obj;
		} catch (RuntimeException e) {
			
		}
		return "";
	}
	
	/**
	 * obj 转int
	 * @param obj
	 * @return
	 */
	public static Integer objToInteger(Object obj){
		if(obj==null) return null;
		
		try {
			return (Integer)obj;
		} catch (RuntimeException e) {
			
		}
		return null;
	}
	/**
	 * obj 转util Date
	 * @param obj
	 * @return
	 */
	public static Date objToDate(Object obj){
		if(obj==null) return null;
		
		try {
			return (Date)obj;
		} catch (RuntimeException e) {
			
		}
		return null;
	}
	/**
	 * obj 转long
	 * @param obj
	 * @return
	 */
	public static long objToLong(Object obj){
		if(obj==null) return 0;
		
		try {
			return Long.parseLong(obj.toString());
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
