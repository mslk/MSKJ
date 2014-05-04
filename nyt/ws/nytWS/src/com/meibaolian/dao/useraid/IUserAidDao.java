package com.meibaolian.dao.useraid;

import com.meibaolian.dao.base.IBaseDao;
import com.meibaolian.entity.UserAid;

public interface IUserAidDao extends IBaseDao<UserAid>{

	
	/**
	 * 记录用户号码拨打次数
	 * @param uuid 用户uuid
	 * @param phone 用户手机号码
	 * @param num 拨打次数
	 * @return
	 */
	public int addCallPhoneLog(String uuid,String phone,int num);
}
