package com.meibaolian.dao.customer.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.meibaolian.dao.base.impl.BaseDao;
import com.meibaolian.dao.customer.ICustomerDao;
import com.meibaolian.entity.Customer;
import com.meibaolian.util.exception.DataManagerException;
import com.meibaolian.util.tablehash.TableRules;

public class CustomerDao extends BaseDao<Customer> implements ICustomerDao{

	@Override
	public int addCustomer(Customer customer) {
		/**
		 * insert into customer (userid, addtime, customerid, customertype, phone) values(?,...,?)
		 */
		String tableName = TableRules.getCustomerRule();
		
		StringBuilder sql = new StringBuilder("insert into ");
		List<Object> list = new ArrayList<Object>();
		
		sql.append(tableName).append(" (userid, addtime, customerid, customertype, phone) values(?,?,?,?,?)");
		list.add(customer.getUserid());
		list.add(new Date());
		list.add(customer.getCustomerid());
		list.add(customer.getCustomertype());
		list.add(customer.getPhone());
		return super.add(sql.toString(), list.toArray(), tableName);
	}

	@Override
	public int delCustomer(int id) {
		String tableName = TableRules.getCustomerRule();
		StringBuilder sql = new StringBuilder("delete from ");
		sql.append(tableName).append(" where id=? ");
		return super.deleteById(sql.toString(), new Object[]{id}, tableName);
	}

	@Override
	public boolean isExistCustomer(Customer customer) throws DataManagerException {
		String tableName = TableRules.getCustomerRule();
		StringBuilder sql = new StringBuilder("select count(1) from ");
		sql.append(tableName).append(" where userid=? and customerid=?");
		long num = super.searchCount(sql.toString(), new Object[]{customer.getUserid(), customer.getCustomerid()}, tableName);
		return num > 0;
	}

}
