package com.meibaolian.entity.user;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

import com.meibaolian.entity.UserInfo;

/**
 *  管理员类
 * @author Administrator
 *
 */
public class AdminInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private UserInfo  userInfo;
	
	private HashMap<String,List<String>> purviews;

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public HashMap<String, List<String>> getPurviews() {
		return purviews;
	}

	public void setPurviews(HashMap<String, List<String>> purviews) {
		this.purviews = purviews;
	}
	
}
