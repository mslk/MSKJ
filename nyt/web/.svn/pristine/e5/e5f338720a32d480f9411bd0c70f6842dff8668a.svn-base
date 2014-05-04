package com.meibaolian.dao.user;

import com.meibaolian.dao.base.IBaseDao;
import com.meibaolian.entity.Usermanager;

public interface IUserManagerDao extends IBaseDao<Usermanager>
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
	 * @param oldPwd
	 * @param newPwd
	 */
	public void updatePwd(Usermanager usermanager);
}
