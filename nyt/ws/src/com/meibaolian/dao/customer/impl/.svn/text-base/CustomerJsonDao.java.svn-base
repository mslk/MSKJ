package com.meibaolian.dao.customer.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.dao.base.impl.BaseDao;
import com.meibaolian.dao.customer.ICustomerJsonDao;
import com.meibaolian.entity.CustomerJson;
import com.meibaolian.util.exception.DataManagerException;
import com.meibaolian.util.tablehash.TableRules;

public class CustomerJsonDao extends BaseDao<CustomerJson> implements ICustomerJsonDao{

	@Override
	public QueryResult<CustomerJson> getCustomerJson(int userid, int customertype, int page, int pageSize) throws DataManagerException{
		
		String tableName = TableRules.getCustomerRule();
		String userTable = TableRules.getUserInfoRule();
		StringBuilder sql = new StringBuilder("select u.companyname,u.realname,u.phone as uphone, c.* from ");
		sql.append(tableName).append(" c,").append(userTable).append(" u ");
		sql.append(" where c.customerid=u.id and c.userid=? ");
		return super.search(sql.toString(), customerJsonRowMapper, tableName, page, pageSize, new Object[]{userid});
	}
	
	private static RowMapper<CustomerJson> customerJsonRowMapper = new RowMapper<CustomerJson>() {

		@Override
		public CustomerJson mapRow(ResultSet arg0, int arg1)
				throws SQLException {
			CustomerJson customerJson = new CustomerJson();
			customerJson.setId(arg0.getInt("id"));
			customerJson.setAddtime(arg0.getDate("addtime").toString());
			customerJson.setUserid(arg0.getInt("userid"));
			customerJson.setCustomerid(arg0.getInt("customerid"));
			customerJson.setCustomertype(arg0.getInt("customertype"));
			customerJson.setPhone(arg0.getString("uphone"));
			customerJson.setCompany(arg0.getString("companyname"));
			customerJson.setUsername(arg0.getString("realname")); 
			return customerJson;
		}};
}
