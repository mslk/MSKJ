package com.meibaolian.util.redis;

import org.apache.log4j.Logger;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import com.meibaolian.util.ConfigUtil;

/**
 * 建立redis连接池，从连接池获取连接对象操作redis存储内容
 * 
 * @author liaolm
 * 
 */
public class RedisConnector
{

	/**
	 * redis连接池
	 */
	private static JedisPool pool = null;

	private static Logger logger = Logger.getLogger(RedisConnector.class);

	// static
	// {
	// init();//建立redis连接池
	// }
	/**
	 * 建立redis连接池
	 */
	public static void init()
	{
		try
		{
			JedisPoolConfig config = new JedisPoolConfig();
			config.setMaxActive(ConfigUtil.MAXACTIVE);
			config.setMaxIdle(ConfigUtil.MAXIDLE);
			config.setMaxWait(ConfigUtil.MAXWAIT);
			config.setTestOnBorrow(ConfigUtil.TESTONBORROW);
			config.setTestOnReturn(ConfigUtil.TESTONRETURN);
			pool = new JedisPool(config, ConfigUtil.redisUrl,
					ConfigUtil.redisPort, 0, ConfigUtil.redisPassword);
		} catch (RuntimeException e)
		{
			logger.error("建立redis连接池失败！", e);
		} catch (Exception e)
		{
			logger.error("未知异常！", e);
		}
	}

	/**
	 * 若当前连接对象为空，则从redis连接池获取新连接
	 * 
	 * @return
	 * @throws Exception
	 */
	public static Jedis getJedis()
	{
		Jedis jedis = null;
		try
		{
			if (pool == null)
				init();

			if (pool != null)
			{
				jedis = pool.getResource();
			}
		} catch (Exception e)
		{
			logger.error("获取redis连接失败！", e);
		}
		return jedis;
	}

	/**
	 * 将正常将的接释放回redis连接池
	 */
	private static void freeJedisSuccuess(Jedis jedis)
	{
		try
		{
			pool.returnResource(jedis);
		} catch (Exception e)
		{
			logger.error("释放redis连接失败！", e);
		}
	}

	/**
	 * 将错误的连接释放回redis连接池
	 */
	private static void freeJedisFail(Jedis jedis)
	{
		try
		{
			pool.returnBrokenResource(jedis);
		} catch (Exception e)
		{
			logger.error("释放redis连接失败！", e);
		}
	}

	/**
	 * 将错误的连接释放回redis连接池
	 */
	public static void freeJedis(boolean isRight, Jedis jedis)
	{
		try
		{
			if (isRight)
			{
				freeJedisSuccuess(jedis);
			} else
			{
				freeJedisFail(jedis);
			}
		} catch (Exception e)
		{
			logger.error("释放redis连接失败！", e);
		}
	}

}
