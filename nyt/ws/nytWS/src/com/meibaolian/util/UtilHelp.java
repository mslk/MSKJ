package com.meibaolian.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.MathContext;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

import com.meibaolian.util.exception.DataManagerException;
import com.meibaolian.util.exception.NoParameterException;

/**
 * @author Administrator
 *
 */
public class UtilHelp {
	
	private static Logger logger = Logger.getLogger(UtilHelp.class);
	/**
	 * 
	 */
	public static final DataManagerException DATAMANAGERERROR=new DataManagerException(); 
	
	/**
	 * dao层操作失败码 操作失败状态码 对应添加，修改，查询集合有效，对应查询总数，或单项值的无效（单项值的对应FailException）
	 */
	public static final int ERRORCODE = -100;
	
	public static final MathContext MATHCONTEXT = new MathContext(3);
	
	public static final BigDecimal BIGDECIMAL_ZERO = new BigDecimal(0,MATHCONTEXT);
	
	/**
	 * 判断是否是手机号码, 移动：134、135、136、137、138、139、150、151、157(TD)、158、159、183、187、188
	 * 联通：130、131、132、152、155、156、185、186 电信：133、153、180、189、（1349卫通）
	 * 
	 * @param mobiles
	 * @return true 为手机号码,false 不是手机号码
	 */
	public static boolean isMobile(String mobiles) {
		Pattern p = Pattern
				.compile("^((13[0-9])|(15[0-9])|(18[0-9]))\\d{8}$");
		Matcher m = p.matcher(mobiles);
		return m.matches();
	}
	
	/**
	 * 验证身份证
	 * @param cardId
	 * @return
	 */
	public static boolean isCardID(String cardId) {
//		/^(/d{18,18}|/d{15,15}|/d{17,17}x)$/
		Pattern p = Pattern.compile("(^\\d{15}$)|(^\\d{17}([0-9]|X)$)");
		Matcher m = p.matcher(cardId);
		return m.matches();
	}
	
	/**
	 * 生产4位 随机码
	 * @return
	 */
	public static  String createCheckCode(){
		StringBuilder str =new StringBuilder("");
		Random rd = new Random();
		for(int i=0;i<4;i++){
			str = str.append(rd.nextInt(10));
		}
		return str.toString();
	}
	
	/**
	 * 生产时间戳 
	 * @return
	 */
	public static  String createValidateCode(){
		
//		Calendar calendar=Calendar.getInstance();
		// 2000 01
//		return calendar.get(Calendar.YEAR)+""+(calendar.get(Calendar.MONTH)+1)+calendar.get(Calendar.DAY_OF_MONTH)
//				+calendar.get(Calendar.HOUR_OF_DAY)+calendar.get(Calendar.MINUTE) +calendar.get(Calendar.SECOND);
		return dateFormatStr(new Date(), "yyyyMMddHHmmss");
	}
	
	
	/**
	 * 验证字符串中只包含数字和字母
	 * 
	 * @param value
	 * @return true 验证正确 false 不正确
	 */
	public static boolean validateNumAndChart(String value) {
		Pattern pattern = Pattern
				.compile("^\\w+$");
		return pattern.matcher(value).matches();
	}

	
	
	
	/**
	 * 经度一秒 相隔 多少米
	 */
	public static final int LONGITEM = 25;
	
	/**
	 *  纬度一秒 相隔 多少米
	 */
	public static final int LATITEM = 31;
	
	/**
	 * 根据当前的经度 纬度 算出 离当前 经度 、 纬度 、 相应距离的 上下浮动值
	 * @param value  相关的值
	 * @param searchSize   距离
	 * @param type 相应的类型 1 经度 2 纬度
	 * @param way 方向 1上 2 下
	 * @return double
	 */
	public static double reckonGPS(String value, int searchSize, int type,
			int way) {

		// 经度1度=85.39km
		// 经度1分 = 1.42km
		// 经度1秒 = 23.6m

		// 纬度1度 = 大约111km
		// 纬度1分 = 大约1.85km
		// 纬度1秒 = 大约30.9m
		if (value.indexOf(".") == -1 && searchSize <= 0 && type != 1
				&& type != 2)
			return 0;

		int du = strToInt(value.substring(0,value.indexOf(".")));
		
		 String millde = ""
				+ strToDouble("0." + value.substring(value.indexOf(".") + 1))
				* 60;

		int fen = 0;

		if (millde.indexOf(".") != -1)
		{	//millde=doubleF.format(strToDouble(millde));
		    if(millde.indexOf(".")==-1)
		    	fen=strToInt(millde);
		    else	
			    fen =strToInt(millde.substring(0,millde.indexOf(".")));
		}
//		System.out.println("millde1 :"+millde);
		millde = ""+ strToDouble("0." + millde.substring(millde.indexOf(".") + 1))
				* 60;
//		System.out.println("millde2 :"+millde);
		int second = 0;
		if (millde.indexOf(".") != -1)
		{
			if(millde.indexOf(".")==-1)
			   second=strToInt(millde);	
			else
			second=strToInt(millde.substring(0, millde.indexOf(".")));
		}
//         System.out.println("原始 度 分 秒：");
//		 System.out.println(du);
//		 System.out.println(fen);
//		 System.out.println(second);
		int addItem = 0;
		if (type == 1) {
			addItem = searchSize / LONGITEM;
		} else if (type == 2) {
			addItem = searchSize / LATITEM;
		}
//		System.out.println(addItem);
		if (way == 1) {
			second += addItem;
			if (second > 60) {
				second -= 60;
				fen += 1;
				if (fen > 60) {
					fen -= 60;
					du += 1;
				}
			}
		}else if(way==2){
			second-=addItem;
			if(second<0){
                	if(fen<=0){
                		du-=1;
                		fen+=60;
                	}
                	fen-=1;
                	second+=60;
			}
		}
//        System.out.println("相加减后  度 分 秒：");
//		 System.out.println(du);
//		 System.out.println(fen);
//		 System.out.println(second);
		return fen/ 60d + second / 3600d + du;
	}
	
	
	/**
	 * 根据两个经纬度计算距离
	 * 
	 * @author 李锦华
	 * @since:2011-9-16
	 * @param lng1
	 *            经度1
	 * @param lat1
	 *            纬度1
	 * @param lng2
	 *            经度2
	 * @param lat2
	 *            纬度2
	 * @return 米
	 */
	public static double distanceByLngLat(double lng1, double lat1,
			double lng2, double lat2) {
		double radLat1 = lat1 * Math.PI / 180;
		double radLat2 = lat2 * Math.PI / 180;
		double a = radLat1 - radLat2;
		double b = lng1 * Math.PI / 180 - lng2 * Math.PI / 180;
		double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2)
				+ Math.cos(radLat1) * Math.cos(radLat2)
				* Math.pow(Math.sin(b / 2), 2)));
		s = s * 6378137.0;// 取WGS84标准参考椭球中的地球长半径(单位:m)
		return s;
	}
	
	
	/**
	 * 根据 一固定gps 算出另一gps 在此gps的方位
	 * @param lng1
	 * @param lat1
	 * @param lng2
	 * @param lat2
	 * @return String
	 */
	public static String  computeWay(double lng1,double lat1,double lng2,double lat2){
		String result="";
		
		if(lng2>lng1 && lat2>lat1){
			result="东北";
		}
		
		if(lat2>lat1 && lng2<lng1 ){
			result="西北";
		}
		
		if(lat2<lat1 && lng2>lng1  ){
			result="东南";
		}
		
		if(lng2<lng1 &&  lat2<lat1){
			result="西南";
		}
		
		
		if(Math.abs(Math.round(lng2-lng1))==0 &&  lat2>lat1){
		result="正北";
	    }

		if(Math.abs(Math.round(lng2-lng1))==0 &&  lat2<lat1){
			result="正南";
		}
		
		if( Math.abs(Math.round(lat2-lat1))==0 && lng2<lng1 ){
			result="正西";
		}
		
		if( Math.abs(Math.round(lat2-lat1))==0 && lng2>lng1 ){
			result="正东";
		}
		
	
		return result;
	}
	



	

	/**
	 * 替换字符串
	 * 
	 * @param from
	 *            String 原始字符串
	 * @param to
	 *            String 目标字符串
	 * @param source
	 *            String 母字符串
	 * @return String 替换后的字符串
	 */
	public static String replace(String from, String to, String source) {
		String sour = source;
		if (sour == null || from == null || to == null)
			return null;
		StringBuffer bf = new StringBuffer("");
		int index = -1;
		while ((index = sour.indexOf(from)) != -1) {
			bf.append(sour.substring(0, index) + to);
			sour = sour.substring(index + from.length());
			index = sour.indexOf(from);
		}
		bf.append(sour);
		return bf.toString();
	}

	/**
	 * 剔除 字符串为null的情况
	 * 
	 * @param value
	 * @return 不为null的字符串值
	 */
	public static String strNotNull(String value) {
		if (value == null)
			return "";
		return value;
	}


	/**
	 * 字符串转换为int 类型，如果出错，默认为0
	 * 
	 * @param value
	 * @return 0 或其他
	 */
	public static int strToInt(String value) {
		int result = 0;
		try {
			if(value != null)
				result = Integer.parseInt(value);
		} catch (NumberFormatException e) {
//			return 0;
		}
		return result;
	}
	/**
	 * 字符串转换为int 类型，如果出错，默认为-1
	 * 
	 * @param value
	 * @return -1 或其他
	 */
	public static int strToIntNoZero(String value) {
		int result = 0;
		try {
			if(value != null)
				result = Integer.parseInt(value);
		} catch (NumberFormatException e) {
//			return 0;
		}
		return result;
	}
	/**
	 * 字符串转换为long 类型，如果出错，默认为0
	 * @param value
	 * @return
	 */
	public static long strToLong(String value){
		long result = 0;
		try {
			if(value != null)
				result = Long.valueOf(value);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	/**
	 * @Description: 判断是否为空字符串，（即null 或 "" 返回true）
	 * @param value 
	 * @return  true false
	 */
	public static boolean isNullStr(String value) {
		return (value == null || "".equals(value));
	}

	/**
	 * @Description: 判断是否为字符串，空字符串也返回false（即null 或 "" 返回也是false）
	 * @param value 
	 * @return  true false
	 */
	public static boolean isNotNullStr(String value) {
		if (value == null || "".equals(value)) {
			return false;
		}
		return true;
	}

	/**
	 * @Description: 判断是否为整数
	 * @param str
	 *            传入的字符串
	 * @return 是整数返回true,否则返回false , null或者"" 返回false
	 */
	public static boolean isInteger(String str) {
		if (str == null || "".equals(str)) {
			return false;
		}
		Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
		return pattern.matcher(str).matches();
	}

	/**
	 * 编码格式转换 默认为UTF-8
	 * 
	 * @param value
	 * @param type
	 * @return 转码后的字符串
	 */
	public static String decodeByType(String value, String type) {

		try {
			if ("".equals(strNotNull(type))) {
				type = "UTF-8";
			}

			if (!"".equals(strNotNull(value))) {
				return URLDecoder.decode(value, type);
			}

		} catch (UnsupportedEncodingException e) {

		}
		return "";
	}
	/**
	 * 解码两次
	 * @param value
	 * @param type
	 * @return
	 */
	public static String doubleDecode(String value, String type){
		String result = isNullStr(value) ? null : decodeByType(decodeByType(value.trim(), type),type);
		return result == null ? null : result.trim();
	}
	
	public static String doubleDecode(String value){
		return doubleDecode(value, null);
	}
	/**
	 * 编码格式转换 默认为UTF-8
	 * 
	 * @param value
	 * @param type
	 * @return 编码后的字符串
	 */
	public static String encodeByType(String value, String type) {

		try {
			if ("".equals(strNotNull(type))) {
				type = "UTF-8";
			}

			if (!"".equals(strNotNull(value))) {
				return URLEncoder.encode(value, type);
			}

		} catch (UnsupportedEncodingException e) {

		}
		return "";
	}

	/**
	 * @Description: 分割字符串
	 * @date: 2011-4-7
	 * @param str
	 *            String 原始字符串
	 * @param splitsign
	 *            String 分隔符
	 * @return String[] 分割后的字符串数组
	 */
	public static String[] split(String str, String splitsign) {
		int index;
		String string = str;
		if (string == null || splitsign == null)
			return null;
		List<String> al = new ArrayList<String>();
		while ((index = string.indexOf(splitsign)) != -1) {
			if (string.substring(0, index).length() > 0
					&& !("".equals(string.substring(0, index)))) {
				al.add(string.substring(0, index));
			}
			string = string.substring(index + splitsign.length(), string
					.length());
		}
		if (string.length() > 0 && !"".equals(string)) {
			al.add(string);
		}

		return al.toArray(new String[al.size()]);
	}

	



	

	/**
	 * @param countSize
	 * @return 动态生成sql 语句中的values 部分
	 * @throws NoParameterException
	 */
	public static String engenderByParamCount(int countSize)
			throws NoParameterException {

		if (countSize <= 0) {
			throw new NoParameterException(" 动态产生 values（）部分异常！");
		}

		StringBuilder builder = new StringBuilder(" values( ");
		for (int i = 0; i < countSize; i++) {
			builder.append(" ? ,");
		}

		builder.deleteCharAt(builder.lastIndexOf(","));
		builder.append(" ) ");
		return builder.toString();
	}

	/**
	 * @param value
	 * @param tag
	 * @return  将数据 以指定的tag 连接起来组成字符串
	 */
	public static String arrayToString(String[] value, String tag) {
		if (value == null || value.length == 0)
			return "";
		if (tag == null || "".equals(tag))
			tag = ";";
		StringBuilder builder = new StringBuilder();

		for (String v : value) {
			if (v != null && !"".equals(v))
				builder.append(v).append(tag);
		}
		return builder.toString();
	}

	/**
	 * 
	*@author chenpeng email:chen422520@163.com
	*@param value  需要转换的值 
	*@Description 
	*@date Jul 11, 2012 10:50:19 AM
	*@return  转换后的数字
	*@version
	*
	 */
	public static Long isNotNullLong(Long value) {
		if (value == null)
			return 0L;
		return value;
	}

	
   /**
   *@author chenpeng email:chen422520@163.com
   *@param parameter 参数 
   *@Description 
   *@date Jul 11, 2012 10:51:59 AM
   *@return 转换为double的值
   *@version
   *
    */
	public static double strToDouble(String parameter) {
		
		if(parameter==null || "".equals(parameter))return 0d;
		
		
		try {
			return Double.parseDouble(parameter);
		} catch (NumberFormatException e) {
			return 0d;
		}
		
	}
	/**
	 * 解析为float,空或错误返回0f
	 * @param value
	 * @return
	 */
	public static float strToFloat(String value){
		if(isNotNullStr(value)){
			try {
				return Float.valueOf(value);
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 0f;
	}
	/**
	 * 解析为BigDecimal,空或错误返回0
	 * @param value
	 * @return
	 */
	public static BigDecimal strToBigDecimal(String value){
		if(isNotNullStr(value)){
			try {
				BigDecimal bd = new BigDecimal(value.trim());
				bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
				return bd;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return BIGDECIMAL_ZERO;
	}
	/**
	 * 解析为BigDecimal,空或错误返回0
	 * @param value
	 * @param scale 保留的小数位数
	 * @return
	 */
	public static BigDecimal strToBigDecimal(String value, int scale){
		if(isNotNullStr(value)){
			try {
				BigDecimal bd = new BigDecimal(value.trim());
				bd = bd.setScale(scale, BigDecimal.ROUND_HALF_UP);
				return bd;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return BIGDECIMAL_ZERO;
	}
	
	/**
	 * 进行md5 加密
	 * 
	 * @param value
	 * @return
	 */
	public static String stringToMd5(String value) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(value.getBytes());
			byte b[] = md.digest();

			int i;

			StringBuffer buf = new StringBuffer("");
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}

//			System.out.println("result: " + buf.toString());
			return buf.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 对小数进行格式化，保留几位小数
	 * @param num 小数
	 * @param count 保留小数位数
	 * @return
	 */
	public static String numberFormat(Object num, int count){
		String pattern = ".";
		for(int i=0;i<count;i++){
			pattern+="0";
		}
		try {
			DecimalFormat df = new DecimalFormat(pattern);
			return df.format(num);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static String dateFormatStr(Date date,String pattern){
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(pattern);
			return sdf.format(date);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 判断指定日期是否大于等于当前日期
	 * @param dateStr yyyy-MM-dd
	 * @return
	 */
	public static boolean isDateValid(String dateStr){
//		java.sql.Date date = java.sql.Date.valueOf(dateStr);
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
		Date date =null;
		try {
			date= dateFormat.parse(dateStr);
		} catch (ParseException e) {
		}
		if(date==null){
			return false;
		}
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		Calendar now = Calendar.getInstance();
		boolean flag = false;
		//
		if(cal.get(Calendar.YEAR) > now.get(Calendar.YEAR)){
			flag = true;
		}else if(cal.get(Calendar.YEAR) == now.get(Calendar.YEAR)){
			if(cal.get(Calendar.MONTH) > now.get(Calendar.MONTH)){
				flag = true;
			}else if(cal.get(Calendar.MONTH) == now.get(Calendar.MONTH)){
				if(cal.get(Calendar.DAY_OF_MONTH) >= now.get(Calendar.DAY_OF_MONTH)){
					flag = true;
				}
			}
		}
		//
		/*if(cal.get(Calendar.YEAR) < now.get(Calendar.YEAR)){
			flag = false;
		}else if(cal.get(Calendar.MONTH) < now.get(Calendar.MONTH)){
			flag = false;
		}else if(cal.get(Calendar.DAY_OF_YEAR) < now.get(Calendar.DAY_OF_YEAR)){
			flag = false;
		}*/
		return flag;
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
	
	/**
	 * 发布时间 帮助
	 * @param time
	 * @return
	 */
	public static String dateBefore(Date time)
	{
	    StringBuffer sb;
		try {
			long l=System.currentTimeMillis()-time.getTime();
			   long day=l/(24*60*60*1000);
			   long hour=(l/(60*60*1000)-day*24);
			   long min=((l/(60*1000))-day*24*60-hour*60);
			   long s=(l/1000-day*24*60*60-hour*60*60-min*60);
			    
			   sb = new StringBuffer();	
			   if(day > 0)
			   {   
				   if(day<5)
				   {
					   sb.append(day+"天");
				   }else
				   {
				   SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				   sb.append(df.format(time));
				   }
			   
			   }else  if(hour > 0 )
			   {    
				   sb.append(hour+"小时");
			   
			   }else if(min > 0 )
			   {   
				   sb.append(min+"分钟");
			   
			   }else if(s>0)
			   {
				   sb.append("1分钟");
			   }
			   
			   sb.append("前发布");
			   
			   return sb.toString();
		} catch (Exception e) {
			return "";
		}
		
		
	       
		
	}
	
	
	public static String setSQLLikeStr(Object value){
		StringBuilder sb = new StringBuilder("");
		return sb.append("%").append(value).append("%").toString();
	}
	/**
	 * 获取起止日期之间的剩余天数（包含起止日期）；
	 * @param begin 起始日
	 * @param end   终止日
	 * @return 若起止为同一天，则剩余1天；若起始日在终止日后，为负数；解析错误返回0。
	 */
	public static int getDayOffset(Date begin, Date end){
		if(begin == null || end == null){
			return 0;
		}
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
		try {
			begin = dateFormat.parse(dateFormat.format(begin));
			end = dateFormat.parse(dateFormat.format(end));
		} catch (ParseException e) {
			logger.error("解析日期失败！", e);
		}
		long offset = end.getTime() - begin.getTime();
		int dayMillis = 1000*60*60*24;
		int offsetDay = (int)(offset/dayMillis);
		if(offset >= 0){
			return offsetDay + 1;
		}
		return offsetDay - 1;
	}
	
	public static int getDayOffset(Date begin, String endStr){
		if(begin == null || endStr == null){
			return 0;
		}
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
		Date end = null;
		try {
			begin = dateFormat.parse(dateFormat.format(begin));
			end = dateFormat.parse(endStr);
		} catch (ParseException e) {
			logger.error("解析日期失败！", e);
		}
		long offset = end.getTime() - begin.getTime();
		int dayMillis = 1000*60*60*24;
		int offsetDay = (int)(offset/dayMillis);
		if(offset >= 0){
			return offsetDay + 1;
		}
		return offsetDay - 1;
	}
	/**
	 * 若value不为null或""，返回截取空格后的值
	 * @param value
	 * @return
	 */
	public static String trimStr(String value){
		return isNullStr(value) ? value : value.trim();
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
			logger.error("设置有效期的时间失败！validdate="+validdate, e);
			result = validdate;
		}
		return result;
	}
	
	/**
	 * 时间格式为yyyy-mm-dd
	 * @param validdate
	 * @return
	 */
	public static String setAddTime(String addtime){
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String result = null;
		try {
			Date date = dateFormat.parse(addtime);
			dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			result = dateFormat.format(date);
		} catch (ParseException e) {
			logger.error("设置添加的时间失败！validdate="+addtime, e);
			result = addtime;
		}
		return result;
	}
	
	public static void main(String[] args) {
		
		
		
		
		try {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			System.out.println(""+df.format(new Date()));
			
		  System.out.println(	dateBefore(df.parse("2014-04-16 16:00:26")));
		  System.out.println(	dateBefore(df.parse("2014-04-15 16:00:26")));
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
//		System.out.println(createValidateCode());
//		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
//		Date begin =null;
//		Date end =null;
//		try {
//			
//			begin = dateFormat.parse("2013-10-25 19:22:30");
//			end= dateFormat.parse("2014-09-25 18:05:15");
//			dateFormat=new SimpleDateFormat("yyyy-MM-dd 23:59:59");
////			dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
////			System.out.println(getDayOffset(new Date(), end));
//			System.out.println(dateFormat.format(begin));
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println(isCardID("430722198705198"));
//		double lng=113.965393;
//		double lat=22.541031;
//		double owlng=113.9531;
//		double owlat=22.53842;
//		int range=1;
//		System.out.println(UtilHelp.reckonGPS(lng + "", range*1000, 1, 2));
//		System.out.println(UtilHelp.reckonGPS(lng + "", range*1000, 1, 1));
//		System.out.println(UtilHelp.reckonGPS(lat + "", range*1000, 2, 2));
//		System.out.println(UtilHelp.reckonGPS(lat + "", range*1000, 2, 1));
		
//		System.out.println(createValidateCode());
//		
//		String a="1223344";
//		
//		System.out.println(validateNumAndChart(a));
//		System.out.println(isDateValid("2014-10-02"));
//		BigDecimal a = strToBigDecimal("12456.78944");
//		BigDecimal b = strToBigDecimal("0.00");
//		System.out.println(a.multiply(BIGDECIMAL_ZERO));
//		System.out.println(b.compareTo(BIGDECIMAL_ZERO));
//		System.out.println(BIGDECIMAL_ZERO.scale());
		
		/*UserInfo userinfo = new UserInfo();
		userinfo.setCardid("15973");
		byte[] bytes = serialize(userinfo);
		userinfo = (UserInfo)unserialize(bytes);
		System.out.println(userinfo.getCardid());*/
	}
}
