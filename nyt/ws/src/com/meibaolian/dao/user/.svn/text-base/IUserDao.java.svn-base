package com.meibaolian.dao.user;

import com.meibaolian.dao.base.IBaseDao;
import com.meibaolian.entity.UserInfo;
import com.meibaolian.util.exception.DataManagerException;
import com.meibaolian.util.exception.NoParameterException;

public interface IUserDao extends IBaseDao<UserInfo>
{

	
	/**
	 * 查看手机号码是否已经绑定
	 * @param phone 手机号码
	 * @return
	 * @throws DataManagerException 
	 */
	public long searchPhone(String phone) throws DataManagerException;
	
	
	/**
	 * 查询用户名 是否已经注册
	 * @param loginName  用户名
	 * @return
	 * @throws DataManagerException 
	 */
	public long searchName(String loginName) throws DataManagerException;
	
	
	/**
	 * 注册用户信息
	 * @param userinfo
	 * @return
	 * @throws NoParameterException 
	 */
	public int addUserInfo(UserInfo userInfo) throws NoParameterException;
	
	/**
	 * 用户登录
	 * @param phone 手机号码
	 * @param pwd   密码
	 * @return 
	 * @throws DataManagerException 
	 */
	public UserInfo searchUser(String phone,String pwd) throws DataManagerException;
	
	/**
	 * 用户登录
	 * @param phone 手机号码
	 * @return 
	 * @throws DataManagerException 
	 */
	public UserInfo searchUser(String phone) throws DataManagerException;
	
	
	/**
	 * * 修改用户密码
	 * @param uuid
	 * @param phone
	 * @param oldPwd
	 * @param newPwd
	 * @return
	 */
	public int updateUserPwd(String phone,String oldPwd,String newPwd);
	
	/**
	 * * 修改用户密码
	 * @param uuid
	 * @param phone
	 * @param oldPwd
	 * @param newPwd
	 * @return
	 */
	public int updateUserPwd(String phone,String newPwd);
	
	
	/**
	 * 修改用户通讯信息
	 * @param  realname
	 * @param uuid
	 * @param company
	 * @param address
	 * @return
	 */
	public int editContacts(UserInfo userInfo);
	
	/**
	 * 完善用户信息
	 * @param UserInfo
	 * @return
	 */
	public int updateUserContacts(UserInfo userInfo,int updateType);
	
	/**
	 * 更新用户推送状态
	 * @param uuid  
	 * @param status  0 开启 1 关闭
	 * @return
	 */
	public int updatePushStatus(int uuid,int status);
	
	/**
	 * 按用户id获取信息
	 * @param id
	 * @return
	 */
	public UserInfo getById(int id) throws DataManagerException;
	
	/**
	 * 根据手机号码删除用户
	 * @param phone
	 * @return
	 */
	public int deleteUserByPhone(String phone);
	
}
