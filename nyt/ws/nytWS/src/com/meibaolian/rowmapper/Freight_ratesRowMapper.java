package com.meibaolian.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.meibaolian.entity.Freight_ratesEntity;

public class Freight_ratesRowMapper implements RowMapper<Freight_ratesEntity> {
	
	public Freight_ratesEntity mapRow(ResultSet rs, int arg1) throws SQLException {
		Freight_ratesEntity vo = new Freight_ratesEntity();
		vo.setId(rs.getInt("id"));
		vo.setSea_freight_rates(rs.getFloat("sea_freight_rates"));
		vo.setCar_freight_rates(rs.getFloat("car_freight_rates"));
		vo.setStart(rs.getString("start"));
		vo.setTo(rs.getString("to"));
		return vo;
	}

	public void printObject(Object obj) {
	}
	
}
