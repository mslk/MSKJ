package com.meibaolian.dao.user.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.RowMapper;

import com.meibaolian.dao.base.impl.BaseDao;
import com.meibaolian.dao.user.IUserDao;
import com.meibaolian.entity.UserInfo;
import com.meibaolian.util.ConfigUtil;
import com.meibaolian.util.UtilHelp;
import com.meibaolian.util.exception.DataManagerException;
import com.meibaolian.util.exception.NoParameterException;
import com.meibaolian.util.tablehash.TableRules;

public class UserDao extends BaseDao<UserInfo> implements IUserDao {

	Logger logger = Logger.getLogger(UserDao.class);

	// public static RowMapper<UserInfo> userRow = new RowMapper<UserInfo>() {
	// @Override
	// public UserInfo mapRow(ResultSet result, int arg1) throws SQLException {
	// UserInfo user = new UserInfo();
	// user.setId(result.getInt("id"));
	// user.setPhone(result.getString("phone"));
	// user.setLoginname(result.getString("loginname"));
	// user.setPassword(result.getString("password"));
	// user.setType(result.getInt("type"));
	// return user;
	// }
	// };

	public static RowMapper<UserInfo> userRowMapper = new RowMapper<UserInfo>() {

		@Override
		public UserInfo mapRow(ResultSet result, int arg1) throws SQLException {
			UserInfo user = new UserInfo();
			user.setId(result.getInt("id"));
			user.setType(result.getInt("type"));
			user.setLoginname(result.getString("loginname"));
			user.setPassword(result.getString("password"));
			user.setPhone(result.getString("phone"));
			user.setRealname(result.getString("realname"));
			user.setStatus(result.getInt("status"));
			user.setPushstatus(result.getInt("pushstatus"));
			// 以下为买、卖会员特拥有字段
			user.setCompanyname(result.getString("companyname"));
			user.setRegistertime(result.getString("registertime"));
			user.setAddress(result.getString("address"));
			
			user.setPlace_receipt(result.getString("place_receipt"));
			user.setProvince(result.getString("province"));
			user.setCity(result.getString("city"));
			user.setCounty(result.getString("county"));
			
			user.setQq(result.getString("qq"));
			user.setFax(result.getString("fax"));
			user.setTelephone(result.getString("telephone"));
			
			user.setPark(result.getString("park"));
			String logo=result.getString("logo");
			user.setLogo(logo!=null && !"".equals(logo)?ConfigUtil.IMAGEPREFIX+logo:"");
			
			
			// 以下为物流会员特拥有字段
//			user.setCardid(result.getString("cardid"));
//			user.setCarnumber(result.getString("carnumber"));
//			user.setFrame(result.getString("frame"));
//			user.setEngine(result.getString("engine"));
			return user;
		}
	};

	@Override
	public int addUserInfo(UserInfo userInfo) throws NoParameterException {

		String tableName = TableRules.getUserInfoRule();
		StringBuilder sql = new StringBuilder(" insert into  ");
		sql.append(tableName).append(" (phone,registertime ");
		// " (type,loginname,password,realname,phone,registertime ");
		List<Object> list = new ArrayList<Object>();
		// list.add(userInfo.getType());
		// list.add(userInfo.getLoginname());
		// list.add(userInfo.getPassword());
		// list.add(userInfo.getRealname());
		list.add(userInfo.getPhone());
		list.add(new Date());
		int number = 2;
		// if (!"".equals(userInfo.getAddress())) {
		// sql.append(",address ");
		// list.add(userInfo.getAddress());
		// number++;
		// }
		// if (!"".equals(userInfo.getCompnayname())) {
		// sql.append(",compnayname ");
		// list.add(userInfo.getCompnayname());
		// number++;
		// }

		sql.append(" ) ");
		sql.append(UtilHelp.engenderByParamCount(number));

		return super.add(sql.toString(), list.toArray(), tableName);
	}

	@Override
	public UserInfo searchUser(String phone, String pwd)
			throws DataManagerException {
		String tableName = TableRules.getUserInfoRule();
		StringBuilder sql = new StringBuilder(" select * from ");
		sql.append(tableName);
		sql.append(" where  phone=? and password=?  ");
		return super.getById(sql.toString(), new Object[] { phone, pwd },
				tableName, userRowMapper);
	}

	@Override
	public UserInfo searchUser(String phone) throws DataManagerException {
		String tableName = TableRules.getUserInfoRule();
		StringBuilder sql = new StringBuilder(" select * from ");
		sql.append(tableName);
		sql.append(" where  phone=?  ");
		return super.getById(sql.toString(), new Object[] { phone }, tableName,
				userRowMapper);
	}

	@Override
	public long searchName(String loginName) throws DataManagerException {
		String tableName = TableRules.getUserInfoRule();
		StringBuilder sql = new StringBuilder(" select count(1) from ");
		sql.append(tableName);
		sql.append(" where  loginname=?  ");

		return super.searchCount(sql.toString(), new Object[] { loginName },
				tableName);
	}

	@Override
	public long searchPhone(String phone) throws DataManagerException {
		String tableName = TableRules.getUserInfoRule();
		StringBuilder sql = new StringBuilder(" select count(1) from ");
		sql.append(tableName);
		sql.append(" where  phone=?  ");

		return super.searchCount(sql.toString(), new Object[] { phone },
				tableName);
	}

	@Override
	public int editContacts(UserInfo userInfo) {
		String tableName = TableRules.getUserInfoRule();
		StringBuilder sql = new StringBuilder(" update ");
		sql.append(tableName).append(" set  id=id ");

		List<Object> list = new ArrayList<Object>();
		if (userInfo != null) {
			if (!"".equals(userInfo.getRealname())) {
				sql.append(" , realname=? ");
				list.add(userInfo.getRealname());
			}

			//if (!"".equals(userInfo.getCompanyname())) {
				sql.append(" , companyname=? ");
				list.add(UtilHelp.strNotNull(userInfo.getCompanyname()));
			//}
			//if (!"".equals(userInfo.getAddress())) {
				sql.append(" , address =? ");
				list.add(UtilHelp.strNotNull(userInfo.getAddress()));
			//}
			
			if(!"".equals(userInfo.getCardid()))
			{
				sql.append(" , cardid =? ");
				list.add(userInfo.getCardid());
			}
			if(!"".equals(userInfo.getCarnumber()))
			{
				sql.append(" , carnumber =? ");
				list.add(userInfo.getCarnumber());
			}
			if(!"".equals(userInfo.getFrame()))
			{
				sql.append(" , frame =? ");
				list.add(userInfo.getFrame());
			}
			if(!"".equals(userInfo.getEngine()))
			{
				sql.append(" , engine =? ");
				list.add(userInfo.getEngine());
			}
			
			sql.append(" where id= ? ");
			list.add(userInfo.getId());
		}

		if (list.size() == 0) {
			return 0;
		} else {
			return super.update(sql.toString(), list.toArray(), tableName);
		}
	}

	@Override
	public int updatePushStatus(int uuid, int status) {
		String tableName = TableRules.getUserInfoRule();
		StringBuilder sql = new StringBuilder();
		sql.append(" update  ").append(tableName);
		sql.append(" set pushstatus=? where id=? ");
		return super.update(sql.toString(), new Object[] { status, uuid },
				tableName);
	}

	@Override
	public UserInfo getById(int id) throws DataManagerException {
		String tableName = TableRules.getUserInfoRule();
		StringBuilder sql = new StringBuilder(" select * from ");
		sql.append(tableName);
		sql.append(" where status=0 and id=?  ");
		return super.getById(sql.toString(), new Object[] { id }, tableName,
				userRowMapper);
	}

	@Override
	public int updateUserPwd(String phone, String oldPwd, String newPwd) {
		String tableName = TableRules.getUserInfoRule();
		String sql = " update " + tableName
				+ " set password=? where  phone=? and password=? ";
		return super.update(sql, new Object[] { newPwd.toLowerCase(), phone,
				oldPwd.toLowerCase() }, tableName);
	}

	@Override
	public int updateUserPwd(String phone, String newPwd) {
		String tableName = TableRules.getUserInfoRule();
		String sql = " update " + tableName + " set password=? where  phone=? ";
		return super.update(sql, new Object[] { newPwd.toLowerCase(), phone },
				tableName);
	}

	@Override
	public int updateUserContacts(UserInfo userInfo,int updateType) {

		String tableName = TableRules.getUserInfoRule();
		StringBuilder sql = new StringBuilder(" update ");
		sql.append(tableName).append(" set ");
		sql.append(" password=? , ");
		sql.append(" realname=?  ");

		List<Object> list = new ArrayList<Object>();
		
		list.add(userInfo.getPassword());
		list.add(userInfo.getRealname());

		if(updateType==1)
		{
		sql.append(" , type=?  ");
		list.add(userInfo.getType());
		}

		if (!"".equals(UtilHelp.strNotNull(userInfo.getCompanyname()))) {
			sql.append(" ,companyname=? ");
			list.add(userInfo.getCompanyname());
		}

		if (!"".equals(UtilHelp.strNotNull(userInfo.getAddress()))) {
			sql.append(" ,address=? ");
			list.add(userInfo.getAddress());
		}

		if (!"".equals(UtilHelp.strNotNull(userInfo.getPlace_receipt()))) {
			sql.append(" ,place_receipt=? ");
			list.add(userInfo.getPlace_receipt());
		}
		
		if (!"".equals(UtilHelp.strNotNull(userInfo.getTelephone()))) {
			sql.append(" ,telephone=? ");
			list.add(userInfo.getTelephone());
		}
		
		if (!"".equals(UtilHelp.strNotNull(userInfo.getFax()))) {
			sql.append(" ,fax=? ");
			list.add(userInfo.getFax());
		}
		
		if (!"".equals(UtilHelp.strNotNull(userInfo.getQq()))) {
			sql.append(" ,qq=? ");
			list.add(userInfo.getQq());
		}
		
		if (!"".equals(UtilHelp.strNotNull(userInfo.getLogo()))) {
			sql.append(" ,logo=? ");
			list.add(userInfo.getLogo());
		}
		
		if (!"".equals(UtilHelp.strNotNull(userInfo.getProvince()))) {
			sql.append(" ,province=? ");
			list.add(userInfo.getProvince());
		}
		
		if (!"".equals(UtilHelp.strNotNull(userInfo.getCity()))) {
			sql.append(" ,city=? ");
			list.add(userInfo.getCity());
		}
		if (!"".equals(UtilHelp.strNotNull(userInfo.getCounty()))) {
			sql.append(" ,county=? ");
			list.add(userInfo.getCounty());
		}
		if (!"".equals(UtilHelp.strNotNull(userInfo.getPark()))) {
			sql.append(" ,park=? ");
			list.add(userInfo.getPark());
		}
		
//		if (!"".equals(UtilHelp.strNotNull(userInfo.getCardid()))) {
//			sql.append(" ,cardid=? ");
//			list.add(userInfo.getCardid());
//		}
//		if (!"".equals(UtilHelp.strNotNull(userInfo.getCarnumber()))) {
//			sql.append(" ,carnumber=? ");
//			list.add(userInfo.getCarnumber());
//		}
//		if (!"".equals(UtilHelp.strNotNull(userInfo.getFrame()))) {
//			sql.append(" ,frame=? ");
//			list.add(userInfo.getFrame());
//		}
//		if (!"".equals(UtilHelp.strNotNull(userInfo.getEngine()))) {
//			sql.append(" ,engine=? ");
//			list.add(userInfo.getEngine());
//		}
		// 建议只有用户是游客的情况下才能完善 type=100
		sql.append(" where id=?   ");
		list.add(userInfo.getId());
		if(updateType==1)
		{
			sql.append(" and type=100 ");
		}
		return super.update(sql.toString(), list.toArray(), tableName);
	}

	@Override
	public int deleteUserByPhone(String phone) {
		String tableName = TableRules.getUserInfoRule();
		StringBuilder sql = new StringBuilder(" delete from ");
		sql.append(tableName).append(" where phone=? ");
		return super.deleteById(sql.toString(), new Object[] { phone },
				tableName);
	}

}
