package com.meibaolian.web.user;

import java.util.Date;
import com.opensymphony.oscache.base.NeedsRefreshException;
import com.opensymphony.oscache.general.GeneralCacheAdministrator;

public class BaseCache extends GeneralCacheAdministrator {

	// 过期时间(单位为秒);
	private int refreshPeriod = 600;

	private static final long serialVersionUID = -4397192926052141162L;

	// 添加被缓存的对象;
	public void put(String key, Object value) {
		this.putInCache(key, value);
	}

	// 删除被缓存的对象;
	public void remove(String key) {
		this.flushEntry(key );
	}

	// 删除所有被缓存的对象;
	public void removeAll(Date date) {
		this.flushAll(date);
	}

	public void removeAll() {
		this.flushAll();
	}

	// 获取被缓存的对象;
	public String get(String key) {
		try {
			return this.getFromCache(key,
					this.refreshPeriod).toString();
		} catch (NeedsRefreshException e) {
			this.cancelUpdate(key);
			return "";
		}
	}
	// 获取被缓存的对象;
	public String getNoExpire(String key) {
		try {
			return this.getFromCache(key, -1).toString();
		} catch (NeedsRefreshException e) {
			this.cancelUpdate(key);
			Object value = e.getCacheContent();
			if(value == null) return null;
			this.putInCache(key, value);
			return value.toString();
		}
	}
	// 获取被缓存的对象;
	public Object getObject(String key) {
		try {
			return this.getFromCache(key, this.refreshPeriod);
		} catch (NeedsRefreshException e) {
			this.cancelUpdate(key);
			return null;
		}
	}
	// 获取被缓存的对象,不过期;
	public Object getObjectNoExpire(String key) {
		try {
			return this.getFromCache(key,-1);
		} catch (NeedsRefreshException e) {
			Object value = e.getCacheContent();
			this.cancelUpdate(key);
			this.putInCache(key, value);
			return value;
		}
	}
	public static void main(String[] args) {

		BaseCache base = new BaseCache();
		String token = "13534066735";
		int count = 1000;
		try {
			base.put(token,count);
			for(int i=0;i<10;i++){
//				base.put(token, 1000+i);
//				System.out.println("-----------put:"+(1000+i));
				Thread.sleep(1000);
				Object value = base.getObject(token);
				System.out.println("-----------get:" + value);
			}
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}

}