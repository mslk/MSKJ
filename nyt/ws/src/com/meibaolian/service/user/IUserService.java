package com.meibaolian.service.user;

import com.meibaolian.entity.UserInfo;
import com.meibaolian.util.exception.DataManagerException;
import com.meibaolian.util.exception.NoParameterException;

public interface IUserService 
{

	
	/**
	 * 根据id 查询到用户信息
	 * @param id
	 * @return
	 * @throws DataManagerException 
	 */
	public UserInfo getById(int id) throws DataManagerException;
	
	
	/**
	 * 查看手机号码是否已经绑定
	 * @param phone 手机号码
	 * @return 1 手机号码已经绑定  0 未绑定
	 * @throws DataManagerException 
	 */
	public long searchPhone(String phone) throws DataManagerException;
	
	
	/**
	 * 注册用户信息
	 * @param phone
	 * @return 0  注册失败 1 注册成功   3 已经注册
	 * @throws NoParameterException 
	 * @throws DataManagerException 
	 */
	public int addUserInfo(String phone) throws NoParameterException, DataManagerException;
	
	/**
	 * 用户登录
	 * @param phone 手机号码
	 * @param pwd   密码
	 * @return 1 存在  0 不存在  
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
	 * @param phone
	 * @param address
	 * @return
	 */
	public int editContacts(UserInfo userInfo);
	
	
	/**
	 * 完善用户信息
	 * @param UserInfo
	 * @param updateType 1 完善   其他修改用户信息
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
	 * 根据手机号码删除用户
	 * @param phone
	 * @return
	 */
	public int deleteUserByPhone(String phone);
}
