package com.meibaolian.util.redis;


import org.apache.log4j.Logger;

import redis.clients.jedis.Jedis;

import com.meibaolian.entity.UserInfo;
import com.meibaolian.util.ConfigUtil;
import com.meibaolian.util.UtilHelp;

public class DataToRedis
{

	static Logger logger = Logger.getLogger(DataToRedis.class);
	
	/**
	 * 保存用户信息
	 * @param id
	 * @param userinfo
	 */
	public static void saveUserInfo(String id, UserInfo userinfo){
		saveObject(id + ConfigUtil.USERINFOSUFFIX, userinfo, -1);
	}
	/**
	 * 获取用户信息
	 * @param id
	 * @return
	 */
	public static UserInfo getUserInfo(String id){
		return (UserInfo)getObject(id + ConfigUtil.USERINFOSUFFIX);
	}
	/**
	 * 更新用户状态
	 * @param id
	 * @param status
	 */
	public static void updateUserInfoStatus(int id, int status){
		UserInfo userInfo = getUserInfo(String.valueOf(id));
		if(userInfo != null){
			userInfo.setStatus(status);
			saveUserInfo(String.valueOf(id), userInfo);
		}
	}
	
	/**
	 * 获取key 对应的value
	 * @param key
	 * @param value
	 */
	public static String getValueByKey(String key)
	{
		Jedis jedis = RedisConnector.getJedis();
		boolean isRight=true;
		String result="";
		try
		{
			if (jedis != null)
			{
//				if(time<=0)
//				{
//					time=ConfigUtil.redisMsgTime;
//				}
				result=jedis.get(key);
//				jedis.expire(key, time);
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
	public static void saveValueToRedis(String key, String value, int time)
	{
		Jedis jedis = RedisConnector.getJedis();
		boolean isRight=true;
		try
		{
			if (jedis != null)
			{
				if(time<=0)
				{
					jedis.set(key, value);
				}else{
					jedis.setex(key,time, value);
				}
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
	
	/**
	 * 向redis存入对象
	 * @param key
	 * @param obj
	 * @param time
	 */
	public static void saveObject(String key, Object obj, int time){
		Jedis jedis = RedisConnector.getJedis();
		boolean isRight=true;
		try
		{
			if (jedis != null)
			{
				if(time > 0){
					jedis.setex(key.getBytes(), time, UtilHelp.serialize(obj));
				}else{
					jedis.set(key.getBytes(), UtilHelp.serialize(obj));
				}
				logger.debug("加入redis : key:"+key +" value:" +obj);
			}
		} catch (RuntimeException e)
		{
			logger.error("redis 操作错误 !", e);
			logger.error("存入失败:" + key + " : " + obj);
			isRight=false;
			
		} finally
		{
			    RedisConnector.freeJedis(isRight,jedis);
		
		}
	}
	/**
	 * 从redis取对象
	 * @param key
	 * @return
	 */
	public static Object getObject(String key){
		Jedis jedis = RedisConnector.getJedis();
		boolean isRight=true;
		Object obj = null;
		try
		{
			if (jedis != null)
			{
				byte[] bytes = jedis.get(key.getBytes());
				if(bytes != null && bytes.length > 0){
					obj = UtilHelp.unserialize(bytes);
				}
				logger.debug("redis 取对象: key:"+key +" value:" +obj);
			}
		} catch (RuntimeException e)
		{
			logger.error("redis 操作错误 !", e);
			logger.error("存入失败:" + key + " : " + obj);
			isRight=false;
			
		} finally
		{
			    RedisConnector.freeJedis(isRight,jedis);
		}
		return obj;
	}
}
