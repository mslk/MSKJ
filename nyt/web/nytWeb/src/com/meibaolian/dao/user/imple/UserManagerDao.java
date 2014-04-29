package com.meibaolian.dao.user.imple;

import com.meibaolian.dao.base.imple.BaseDao;
import com.meibaolian.dao.user.IUserManagerDao;
import com.meibaolian.entity.Usermanager;

public class UserManagerDao extends BaseDao<Usermanager> implements IUserManagerDao {

	@Override
	public Usermanager searchByNameAndPwd(String name, String pwd) {
		String where="  and status=0  and loginname=?  and password=?   ";// ; 
		return super.get(where, new Object[]{name,pwd});
	}

	@Override
	public void updatePwd(Usermanager usermanager) {
		super.update(usermanager);
	}

	


}
