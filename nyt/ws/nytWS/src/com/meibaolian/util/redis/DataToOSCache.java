package com.meibaolian.util.redis;


import org.apache.log4j.Logger;
import redis.clients.jedis.Jedis;

import com.meibaolian.entity.UserInfo;
import com.meibaolian.util.ConfigUtil;
import com.meibaolian.util.UtilHelp;
import com.meibaolian.web.user.BaseCache;

public class DataToOSCache
{

	static Logger logger = Logger.getLogger(DataToOSCache.class);
	
	static BaseCache baseCache=new BaseCache();

	/**
	 * 获取手机验证码
	 * @param key
	 * @param type  1 获取登录验证码  2 获取修改密码验证码
	 */
	public static String getPhoneCheck(String key,int type)
	{
		String suffix="";
		if(type==1)
		{
			suffix=ConfigUtil.PHONECHECK;
		}else
		{
			suffix=ConfigUtil.UPDATECHECK;
		}
		return baseCache.get(key + suffix);
//		Jedis jedis = RedisConnector.getJedis();
//		boolean isRight=true;
//		String result="";
//		try
//		{
//			if (jedis != null) 
//			{
//				result=UtilHelp.strNotNull(jedis.get(key+ConfigUtil.PHONECHECK));
//			}
//		} catch (RuntimeException e)
//		{
//			logger.error("redis 操作错误 !", e);
//			isRight=false;
//		} finally
//		{
//			RedisConnector.freeJedis(isRight,jedis);
//		}
//		return result;
		
	}
	/**
	 * 存储手机验证码
	 * 存储时间默认是 300 秒
	 * @param key
	 * @param value
	 * @param type
	 */
	public static void savePhoneCheck(String key,String value,int type)
	{
		
		if(type==2)
		{
			baseCache.put(key + ConfigUtil.UPDATECHECK, value);
		}else{
		    baseCache.put(key + ConfigUtil.PHONECHECK, value);
		}
//		Jedis jedis = RedisConnector.getJedis();
//		boolean isRight=true;
//		try
//		{
//			if (jedis != null)
//			{
//				jedis.setex(key+ConfigUtil.PHONECHECK,300, value);
//			}
//		} catch (RuntimeException e)
//		{
//			logger.error("redis 操作错误 !", e);
//			isRight=false;
//		} finally
//		{
//			RedisConnector.freeJedis(isRight,jedis);
//		}
		
	}
	
	/**
	 * 存用户的token
	 * @param token
	 * @param value
	 * @return
	 */
	public static void saveUserToken(String token,String value)
	{
		baseCache.put(token + ConfigUtil.TOKENSUFFIX, value);
//		saveValueToRedis(token + ConfigUtil.TOKENSUFFIX,value,ConfigUtil.sessiontimeout);
	}
	
	/**
	 * 获取用户的 token
	 * @param token
	 * @return
	 */
	public static String getUserToken(String token)
	{
		return baseCache.getNoExpire(token + ConfigUtil.TOKENSUFFIX);
//		return getValueByKey(token+ConfigUtil.TOKENSUFFIX,ConfigUtil.sessiontimeout);
	}
	
	/**
	 * 保存用户信息
	 * @param id
	 * @param userinfo
	 */
	public static void saveUserInfo(String id, UserInfo userinfo){
		baseCache.put(id + ConfigUtil.USERINFOSUFFIX, userinfo);
	}
	/**
	 * 获取用户信息
	 * @param id
	 * @return
	 */
	public static UserInfo getUserInfo(String id){
		return (UserInfo)baseCache.getObjectNoExpire(id + ConfigUtil.USERINFOSUFFIX);
	}
	/**
	 * 获取key 对应的value
	 * @param key
	 * @param value
	 */
	public static String getValueByKey(String key,int time)
	{
		Jedis jedis = RedisConnector.getJedis();
		boolean isRight=true;
		String result="";
		try
		{
			if (jedis != null)
			{
				if(time<=0)
				{
					time=ConfigUtil.redisMsgTime;
				}
				result=jedis.get(key);
				jedis.expire(key, time);
			}
		} catch (RuntimeException e)
		{
			logger.error("redis 操作错误 !", e);
			isRight=false;
		} finally
		{
			RedisConnector.freeJedis(isRight,jedis);
		}
		return result;
		
	}
	
	
	/**
	 * 向redis 存入相关信息
	 * @param key
	 * @param value
	 * @param time 过期时间,如果不填,默认为redis的过期时间
	 */
	public static void saveValueToRedis(String key, String value,int time)
	{
		Jedis jedis = RedisConnector.getJedis();
		boolean isRight=true;
		try
		{
			if (jedis != null)
			{
				if(time<=0)
				{
					time=ConfigUtil.redisMsgTime;
				}
				jedis.setex(key,time, value);
				logger.debug("加入redis : key:"+key +" value:" +value);

			}
		} catch (RuntimeException e)
		{
			logger.error("redis 操作错误 !", e);
			logger.error("存入失败:" + key + " : " + value);
			isRight=false;
			
		} finally
		{
			    RedisConnector.freeJedis(isRight,jedis);
		
		}
	}

}
