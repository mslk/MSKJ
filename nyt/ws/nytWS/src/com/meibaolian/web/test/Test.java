package com.meibaolian.web.test;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import com.meibaolian.util.HttpClientUtil;

public class Test {

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		
		
//		List<NameValuePair> params = new ArrayList<NameValuePair>();
//		
//		/**
//		 * 用户登录名前缀 
//		 * 供应商 sup
//		 * 求购商 buy
//		 */
//		String loginProfirx="sup";
//		
//		/**
//		 * 0	供应商
//         * 1	采购商
//		 */
//		int type=1;
//		
//		/**
//		 * 前 5万为供应商,
//		 * 后 5万为求购商
//		 */
//		int count=20;
//		
//		/**
//		 * 手机号码
//		 */
//		long phone=18700000041L;
//		
//		String url="http://192.168.1.66:8080/meibaolianWS/userRegister";
//		
//		for(int i=1;i<=count;i++)
//		{
//			
//			if(i==50000)
//			{
//				loginProfirx="buy";
//				type=1;
//			}
//			
//			DataToRedis.savePhoneCheck(phone+"", "8888");
//			params.add(new BasicNameValuePair("loginname",loginProfirx+phone));
//			params.add(new BasicNameValuePair("pwd","111111"));
//			params.add(new BasicNameValuePair("phone",""+phone));
//			params.add(new BasicNameValuePair("code","8888"));
//			params.add(new BasicNameValuePair("realname","readname:"+phone));
//			params.add(new BasicNameValuePair("companyname","companyname:"+phone));
//			params.add(new BasicNameValuePair("address",""));
//			params.add(new BasicNameValuePair("type",""+type));
//			System.out.println(phone+" : " +HttpClientUtil.post(url, params,""));
//			params.clear();
//			++phone;
//		}

		
		Object obj=new Object();
		System.out.println(obj);
		
		
	}
	
	public static void main1(String[] args) throws UnsupportedEncodingException 
	{
		
		List<NameValuePair> params = new ArrayList<NameValuePair>();
//		http://www.mythlink.com:8099/zxgserver/zxg_user_login.php?l=Lankou&p=111111
		String url="http://www.mythlink.com:8099/zxgserver/zxg_user_login.php";
//		params.add(new BasicNameValuePair("l","Lankou"));
//		params.add(new BasicNameValuePair("p","111111"));
	   	System.out.println(System. getProperty("file.encoding"));

   
		String body=HttpClientUtil.get(url, params,"GBK");
		System.out.println("r1 :" +body);
		System.out.println("r:"+new String(body.getBytes(),"UTF8"));
		
		
	}

}
