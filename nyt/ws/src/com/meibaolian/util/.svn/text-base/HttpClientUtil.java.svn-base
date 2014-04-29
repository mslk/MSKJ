package com.meibaolian.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;


/**
 * 用来获取网络连接地址源代码
 * 
 * @author wangzi6hao
 * 
 */
public class HttpClientUtil {
	private static Logger logger = Logger.getLogger(HttpClientUtil.class);

	/**
	 * Get请求
	 * 
	 * @param url
	 * @param params
	 * @param encoding 编码格式,默认 utf8
	 * @return 获取源码
	 */
	public static String get(String url, List<NameValuePair> params,String encoding) {
		HttpClient hc = getHttpClient();
		String body = null;
		try {
			
			if(encoding==null || "".equals(encoding))
			{
				encoding="UTF-8";
			}
			
			// Get请求
			HttpGet httpget = new HttpGet(url);
			if(params != null && !params.isEmpty()){
				// 设置参数
				String str = EntityUtils.toString(new UrlEncodedFormEntity(params,
						encoding));
				httpget.setURI(new URI(httpget.getURI().toString() + "?" + str));
				logger.debug("=======发送请求：\n"+httpget.getURI().toString());
			}
			httpget.setHeader("Content-type", "text/html; charset="+encoding);
			// 发送请求
			HttpResponse httpresponse = hc.execute(httpget);
			// 获取返回数据
			HttpEntity entity = httpresponse.getEntity();
			if (entity != null) {
//				body = EntityUtils.toString(entity);
				body = EntityUtils.toString(entity,encoding);
				logger.debug("=================返回内容为:\n" + body);
			}
			EntityUtils.consume(entity);
		} catch (ParseException e) {
			logger.error("解析字符格式出错", e);
		} catch (UnsupportedEncodingException e) {
			logger.error("解析编码格式出错", e);
		} catch (IOException e) {
			logger.error("解析IO异常出错", e);
		} catch (URISyntaxException e) {
			logger.error("地址格式出错", e);
		} finally {
			hc.getConnectionManager().shutdown();
		}
		return body;
	}

	/**
	 * // Post请求
	 * 
	 * @param url
	 * @param params
	 * @param encoding
	 * @return 获取源码
	 */
	public static String post(String url, List<NameValuePair> params,String encoding) {
		HttpClient hc = getHttpClient();

		String body = null;
		try {
			if(encoding==null || "".equals(encoding))
			{
				encoding="UTF-8";
			}
			// Post请求
			HttpPost httppost = new HttpPost(url);
			// 设置参数与参数编码
			httppost.setEntity(new UrlEncodedFormEntity(params, encoding));
			// 发送请求
			HttpResponse httpresponse = hc.execute(httppost);

			// 获取返回数据,使用指定编码格式解析
			HttpEntity entity = httpresponse.getEntity();

			if (entity != null) {
				body = EntityUtils.toString(entity, encoding);
				logger.debug("=================返回内容为:\n" + body);
			}
			EntityUtils.consume(entity);
		} catch (ClientProtocolException e) {
			logger.error("http协议出错", e);
		} catch (ParseException e) {
			logger.error("解析字符格式出错", e);
		} catch (UnsupportedEncodingException e) {
			logger.error("解析编码格式出错", e);
		} catch (IOException e) {
			logger.error("IO异常出错", e);
		} finally {
			hc.getConnectionManager().shutdown();
		}
		return body;
	}

	/**
	 * 发送xml到服务器
	 * 
	 * @param url
	 * @param xml
	 * @param encoding
	 * @return 返回服务器响应内容
	 */
	public static String postXml(String url, String xml,String encoding) {
		HttpClient hc = getHttpClient();

		String body = null;
		try {
			// Post请求

			HttpPost httppost = new HttpPost(url);
			// 设置参数与参数编码
			httppost.setEntity(new StringEntity(xml, encoding));
			// 发送请求
			HttpResponse httpresponse = hc.execute(httppost);
			// 获取返回数据,使用指定编码格式解析
			HttpEntity entity = httpresponse.getEntity();

			if (entity != null) {
				body = EntityUtils.toString(entity, encoding);
				logger.debug("=================返回内容为:\n" + body);
			}
			EntityUtils.consume(entity);
		} catch (ClientProtocolException e) {
			logger.error("http协议出错", e);
		} catch (ParseException e) {
			logger.error("解析字符格式出错", e);
		} catch (UnsupportedEncodingException e) {
			logger.error("解析编码格式出错", e);
		} catch (IOException e) {
			logger.error("IO异常出错", e);
		} finally {
			hc.getConnectionManager().shutdown();
		}
		return body;
	}

	/**
	 * 获取网络连接<br>
	 * 设置默认连接默认超时时间
	 * 
	 * @return
	 */
	private static HttpClient getHttpClient() {
		HttpParams httpParams = new BasicHttpParams();
		HttpConnectionParams.setConnectionTimeout(httpParams, 30 * 1000);// 设置连接服务器超时时间
		HttpConnectionParams.setSoTimeout(httpParams, 30 * 1000);// 与服务器 Socket
																	// 超时时间
		HttpConnectionParams.setSocketBufferSize(httpParams, 8192);// Socket缓存大小

		// 设置重定向，缺省为 true
		// HttpClientParams.setRedirecting(httpParams, false);
		HttpClient hc = new DefaultHttpClient(httpParams);
		return hc;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		List<NameValuePair> params = new ArrayList<NameValuePair>();
/*		String userid = "18603027934";
		String shopid = "888";
		String shopname = "家乐园";
		String clsname = "餐饮";
		String couid = "123";
		String discount = "全单9折优惠";
		String mobile = "18620363994";
		String bankno = "6225888877779999";

		params.add(new BasicNameValuePair("userid", userid));
		params.add(new BasicNameValuePair("shopid", shopid));
		params.add(new BasicNameValuePair("shopname", shopname));
		params.add(new BasicNameValuePair("clsname", clsname));
		params.add(new BasicNameValuePair("couid", couid));
		params.add(new BasicNameValuePair("clsname", clsname));
		params.add(new BasicNameValuePair("discount", discount));
		params.add(new BasicNameValuePair("mobile", mobile));
		params.add(new BasicNameValuePair("bankno", bankno));*/
		
//		params.add(new BasicNameValuePair("province", "广东"));
//		params.add(new BasicNameValuePair("city", "深圳"));
//		params.add(new BasicNameValuePair("lng", "113.96125"));
//		params.add(new BasicNameValuePair("lat", "22.543314"));
//		params.add(new BasicNameValuePair("range", "1"));
//		params.add(new BasicNameValuePair("page", "1"));
//		params.add(new BasicNameValuePair("pagesize", "10"));
//		params.add(new BasicNameValuePair("state", "1"));
//		String str = HttpClientUtil.get("http://api.ulpos.com/v1/coupon/coupon", params);
		//1234567890123456789
		params.add(new BasicNameValuePair("cardno", "6225987659987258082"));
		HttpClientUtil.get("http://api.ulpos.com/v1/verify/checkcardno", params,"");
		
	}
	
	
}
