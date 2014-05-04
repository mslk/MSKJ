package com.meibaolian.dao.nyt.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.dao.base.impl.BaseDao;
import com.meibaolian.dao.nyt.ICollect_infoDao;
import com.meibaolian.entity.Collect_infoEntity;
import com.meibaolian.rowmapper.Collect_infoRowMapper;
import com.meibaolian.util.exception.DataManagerException;

public class Collect_infoDao extends BaseDao<Collect_infoEntity> implements ICollect_infoDao{

	@Override
	public int addCollect(Collect_infoEntity vo) {
		StringBuilder sql = new StringBuilder(" insert into collect_info(userid, type , mtype, mid, addtime)values(?,?,?,?,?)");
		List<Object> list = new ArrayList<Object>();
		 
		list.add(vo.getUserid());
		list.add(vo.getType());
		list.add(vo.getMtype());
		list.add(vo.getMid());
		list.add(new Date());
		return super.add(sql.toString(), list.toArray(), "");
	}

	@Override
	public int delCollect(int id) {
		StringBuilder sql = new StringBuilder("delete from collect_info  where id=? ");
		return super.deleteById(sql.toString(), new Object[]{id}, "");
	}

	@Override
	public boolean isExistCollect(Collect_infoEntity vo) throws DataManagerException {
		StringBuilder sql = new StringBuilder("select count(1) from collect_info  where userid=? and type=? and mtype=? and mid=?");
		long num = super.searchCount(sql.toString(), new Object[]{vo.getUserid(), vo.getType(), vo.getMtype(), vo.getMid()}, "");
		return num > 0;
	}

	@Override
	public QueryResult<Collect_infoEntity> getCollect_infoBean(
			Collect_infoEntity vo, int page, int pageSize)
			throws DataManagerException {
		String sql = "select * from collect_info where userid=? and type=? and mtype=? order by addtime desc";
		return super.search(sql, new Collect_infoRowMapper(), "", page, pageSize, new Object[]{vo.getUserid(), vo.getType(), vo.getMtype()});
	}
	
}
