package com.meibaolian.service.user;

import com.meibaolian.entity.Usermanager;

public interface IUserManagerService
{
	/**
	 * 根据用户名、密码查询用户
	 * @param name
	 * @param pwd
	 * @return
	 */
	public Usermanager searchByNameAndPwd(String name,String pwd);
	
	
	/**
	 * 修改用户密码
	 */
	public void updatePwd(Usermanager usermanager);
	

}
