package com.meibaolian.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.meibaolian.entity.Collect_infoEntity;

/**
 * 我的收藏
 * 
 * @author Kawin
 * 
 */
public class Collect_infoRowMapper implements RowMapper<Collect_infoEntity> {
	public Collect_infoEntity mapRow(ResultSet rs, int arg1) throws SQLException {
		Collect_infoEntity vo = new Collect_infoEntity();
		vo.setId(rs.getInt("id"));
		vo.setUserid(rs.getInt("userid"));
		vo.setType(rs.getInt("type"));
		vo.setMtype(rs.getInt("mtype"));
		vo.setMid(rs.getInt("mid"));
		vo.setAddtime(rs.getString("addtime"));
		return vo;
	}

	public void printObject(Object obj) {
	}
}
