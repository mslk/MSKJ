package com.meibaolian.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public class HttpSendMsg {

	/**
	 * 短信接口
	 */
	public static String sendUrl = "http://www.stongnet.com/sdkhttp/sendsms.aspx";

	/**
	 *   
	 * reg 注册号（由华兴软通指定），不可为空
	 */
//	public static String registerNo = "101100-WEB-HUAX-332371";
	public static String registerNo = "101100-WEB-HUAX-340362";

	static final String SUFFIX="【榆林煤炭交易中心】";
	
	/**
	 * pwd 密码（由华兴软通指定），不可为空
	 */
//	public static String registerPwd = "IAACIHOO";
	public static String registerPwd = "CHNHTQVU";
	
	
	public static void main(String[] args) {
		sendMSMcode("18520883289","124");
	}
//	
	
	/**
	 * 
	 * @param phone
	 *            11 位手机号码
	 * @param msg
	 *            短信内容
	 * @return
	 */
	public static boolean sendMSMcode(String phone, String msg) {
		boolean result = false;

		if (UtilHelp.isMobile(phone)) {

			List<NameValuePair> params = new ArrayList<NameValuePair>();

			params.add(new BasicNameValuePair("reg", registerNo));
			params.add(new BasicNameValuePair("pwd", registerPwd));
			params.add(new BasicNameValuePair("sourceadd", ""));
			params.add(new BasicNameValuePair("phone", phone));
			params.add(new BasicNameValuePair("content", msg+SUFFIX));
			String resultValue = HttpClientUtil.post(sendUrl, params,"");
			System.out.println("params"+params);
			if (resultValue != null && resultValue.indexOf("result=0") != -1) {
				result = true;
			}
		}

		return result;
	}

}
