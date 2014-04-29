package com.meibaolian.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.apache.log4j.Logger;

public class UtilHelp {
	
	private static Logger logger = Logger.getLogger(UtilHelp.class);
	/**
	 * 判断是否是图片 类型
	 * @param content
	 * @return
	 */
	public static  boolean validateImageFile(String contentType)
	{
		boolean result=false;
//		||"image/gif".equalsIgnoreCase(contentType)
		if("image/png".equalsIgnoreCase(contentType) ||"image/jpeg".equalsIgnoreCase(contentType))
		{
			result=true;
		}
			
		return result;
	}
	/**
	 * 判断是否是html 网页类型
	 * @param content
	 * @return
	 */
	public static  boolean validateHtmlFile(String contentType)
	{
		boolean result=false;
		if("text/html".equalsIgnoreCase(contentType))
		{
			result=true;
		}
		
		return result;
	}

	/**
	 * 过滤字符串为null的情况
	 * 
	 * @param value
	 * @return
	 */
	public static String notNullStr(String value) {
		return value == null ? "" : value;
	}
	
	/**
	 * 过滤字符串为null的情况
	 * 
	 * @param value
	 * @return
	 */
	public static String notNullObj(Object value) {
		return value == null ? "" : value.toString();
	}

	/**
	 * 字符串转换为int 类型，如果出错，默认为0
	 * 
	 * @param value
	 * @return
	 */
	public static int stringToInt(String value) {
		int v = 0;
		try {
			v = Integer.parseInt(value);
		} catch (NumberFormatException e) {

		}
		return v;
	}

	/**
	 * @Description: 判断是否为字符串，（即null 或 "" 返回也是false）
	 * @param object
	 * @return
	 */
	public static boolean isNotNullStr(String value) {
		boolean tag = true;
		if (value == null || "".equals(value)) {
			tag = false;
		}
		return tag;
	}

	/**
	 * @Description: 字符串转日期 UtilHelp.java :
	 * @param dateStr
	 *            字符串值
	 * @param formatStr
	 *            转换格式 默认 : yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public static Date stringToDate(String dateStr, String formatStr) {
		Locale systime = Locale.CHINA;

		Date date = null;

		if (isNotNullStr(dateStr)) {

			formatStr = defaultDataFormat(formatStr);

			DateFormat format = new SimpleDateFormat(formatStr, systime);
			try {
				date = format.parse(dateStr);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}

		return date;
	}

	/**
	 * 默认的日期格式
	 * @param formatStr
	 * @return
	 */
	private static String defaultDataFormat(String formatStr) 
	{
		if ("".equals(notNullStr(formatStr)))
		{
			formatStr = "yyyy-MM-dd HH:mm:ss";
		}
		return formatStr;
	}

	/**
	 * 日期转换为指定格式的 字符串
	 * 
	 * @param date
	 *            时间
	 * @param formatStr
	 *            转换格式
	 * @return
	 */
	public static String dateFormat(Date date, String formatStr) {
		if (date == null) {
			return null;
		}
		Locale systime = Locale.CHINA;
		try {
			formatStr=defaultDataFormat(formatStr);
			
			SimpleDateFormat fat = new SimpleDateFormat(formatStr,systime);
			return fat.format(date);
		} catch (RuntimeException e) {

		}
		return null;
	}

	/**
	 * 替换相应的字符串
	 * @param src  原始字符串
	 * @param target 目标字符串
	 * @param value  需要替换的字符串
	 * @return String 替换后的字符串
	 */
	public static String replace(String src, String target, String value) {
		
		  if ("".equals(notNullStr(src)) || "".equals(notNullStr(target)) || "".equals(notNullStr(value)))
		  {
//			  return value;
		  }else
		  {
			 value= value.replaceAll(src, target);
//			  StringBuffer bf = new StringBuffer("");
//			    int index = -1;
//			    String sour=value;
//			    while ((index = sour.indexOf(src)) != -1) {
//			      bf.append(sour.substring(0, index) + target);
//			      sour = sour.substring(index + src.length());
//			      index = sour.indexOf(src);
//			    }
//			    bf.append(sour);
		  }
		return value;
	}
	
	
	public static String setSQLLikeStr(String keyword){
		return "%"+keyword+"%";
	}
	
	/**
	 * 若value不为null或""，返回截取空格后的值
	 * @param value
	 * @return
	 */
	public static String trimStr(String value){
		return isNotNullStr(value) ? value.trim() : value;
	}
	/**
	 * 设置有效期的时间为23:59:59
	 * @param validdate
	 * @return
	 */
	public static String setValiddateTime(String validdate){
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String result = null;
		try {
			Date date = dateFormat.parse(validdate);
			dateFormat = new SimpleDateFormat("yyyy-MM-dd 23:59:59");
			result = dateFormat.format(date);
		} catch (ParseException e) {
//			logger.error("设置有效期的时间失败！validdate="+validdate, e);
			result = validdate;
		}
		return result;
	}
	
	/**
	 * 将对象序列化，返回字节数组
	 * @param obj
	 * @return
	 */
	public static byte[] serialize(Object obj){
		ObjectOutputStream oos = null;
		ByteArrayOutputStream baos = null;
		byte[] bytes = null;
		try {
			baos = new ByteArrayOutputStream();
			oos = new ObjectOutputStream(baos);
			oos.writeObject(obj);
			bytes = baos.toByteArray();
		} catch (IOException e) {
			logger.error("对象序列化失败！", e);
		}
		return bytes;
	}
	
	/**
	 * 将字节数组反序列化为对象
	 * @param bytes
	 * @return
	 */
	public static Object unserialize(byte[] bytes){
		ObjectInputStream ois = null;
		ByteArrayInputStream bais = null;
		Object obj = null;
		try {
			bais = new ByteArrayInputStream(bytes);
			ois = new ObjectInputStream(bais);
			obj = ois.readObject();
		} catch (IOException e) {
			logger.error("对象反序列化失败！", e);
		} catch (ClassNotFoundException e) {
			logger.error("对象反序列化失败！", e);
		}
		return obj;
	} 
	
	public static void main(String[] args) {
		
		String v="a\\a\\a\\a";
		
		System.out.println(replace("\\", "/", v));
		
	}



}
