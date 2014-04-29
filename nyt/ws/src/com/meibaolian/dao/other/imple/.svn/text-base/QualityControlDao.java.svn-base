package com.meibaolian.dao.other.imple;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import com.meibaolian.dao.base.impl.BaseDao;
import com.meibaolian.dao.other.IQualityControlDao;
import com.meibaolian.entity.QualityControlEntity;
import com.meibaolian.entity.QualityControlEntityJson;
import com.meibaolian.util.exception.DataManagerException;
import com.meibaolian.util.tablehash.TableRules;

public class QualityControlDao extends BaseDao<QualityControlEntity> implements IQualityControlDao {


	static RowMapper<QualityControlEntity> qualityRow=new RowMapper<QualityControlEntity>() {
		
		@Override
		public QualityControlEntity mapRow(ResultSet result, int arg1)
				throws SQLException {
			QualityControlEntity entity=new QualityControlEntity();
			entity.setNumber(result.getString("number"));
			entity.setQuanshuifen(result.getString("quanshuifen"));
			entity.setShuifen(result.getString("shuifen"));
			entity.setHuifen(result.getString("huifen"));
			entity.setHuifafen(result.getString("huifafen"));
			entity.setJiaozha(result.getString("jiaozha"));
			entity.setGudingtan(result.getString("gudingtan"));
			entity.setQuanniu(result.getString("quanniu"));
			entity.setQing(result.getString("qing"));
			entity.setFareliang1(result.getString("fareliang1"));
			entity.setFareliang2(result.getString("fareliang2"));
			entity.setHui_dt(result.getString("hui_dt"));
			entity.setHui_st(result.getString("hui_st"));
			entity.setHui_ht(result.getString("hui_ht"));
			entity.setHui_ft(result.getString("hui_ft"));
			entity.setNianjie(result.getString("nianjie"));
			entity.setJianhui(result.getString("jianhui"));
			return entity;
		}
	};

	@Override
	public List<QualityControlEntityJson> searchByNum(String number) throws DataManagerException {
		String tableName=TableRules.getQualityControlRule();
		String sql=" select number,shuifen,quanshuifen,huifen,huifafen,jiaozha,gudingtan,"
                  +" quanniu,qing,fareliang1,fareliang2,hui_dt,hui_st,hui_ht,hui_ft,nianjie,"
                  +" jianhui from " +tableName +" where number=? ";
		QualityControlEntity entity=super.getById(sql, new Object[]{number},tableName,qualityRow);
		List<QualityControlEntityJson> list=null;
		if(entity!=null)
		{
			list=new ArrayList<QualityControlEntityJson>();
			QualityControlEntityJson json1=new QualityControlEntityJson("全水分"," Ｍｔ","％",entity.getQuanshuifen(),"GB/T211-2007",1);
			QualityControlEntityJson json2=new QualityControlEntityJson("水     分"," Ｍad ","％",entity.getShuifen(),"GB/T212-2008",2);
			QualityControlEntityJson json3=new QualityControlEntityJson("灰      分"," Ａｄ ","％",entity.getHuifen(),"GB/T212-2008",3);
			QualityControlEntityJson json4=new QualityControlEntityJson("挥发分"," Ｖd ","％",entity.getHuifafen(),"GB/T212-2008",4);
			QualityControlEntityJson json5=new QualityControlEntityJson("焦渣特征","CRC（1-8）","",entity.getJiaozha(),"GB/T212-2008",5);
			QualityControlEntityJson json6=new QualityControlEntityJson("固定碳","FCad","％",entity.getGudingtan(),"GB/T214-2007",6);
			QualityControlEntityJson json7=new QualityControlEntityJson("全    硫","St，d","％",entity.getQuanniu(),"GB/T212-2008",7);
			QualityControlEntityJson json8=new QualityControlEntityJson("  氢   ","Had","％",entity.getQing(),"GB/T476-2008",8);
			QualityControlEntityJson json9_1=new QualityControlEntityJson("发热量","Ｑgr,d","MJ/kg",entity.getFareliang1(),"GB/T213-2008",9);
			QualityControlEntityJson json9_2=new QualityControlEntityJson("发热量","Ｑnet，ar","MJ/kg",entity.getFareliang2(),"GB/T213-2008",10);
			QualityControlEntityJson json10_1=new QualityControlEntityJson("灰熔融性","DT","℃",entity.getHui_dt(),"GB/T219-2008",11);
			QualityControlEntityJson json10_2=new QualityControlEntityJson("灰熔融性","ST","℃",entity.getHui_st(),"GB/T219-2008",12);
			QualityControlEntityJson json10_3=new QualityControlEntityJson("灰熔融性","HT","℃",entity.getHui_ht(),"GB/T219-2008",13);
			QualityControlEntityJson json10_4=new QualityControlEntityJson("灰熔融性","FT","℃",entity.getHui_ft(),"GB/T219-2008",14);
			QualityControlEntityJson json11=new QualityControlEntityJson("粘结指数","GR.1.","",entity.getNianjie(),"GB/T5447-1997",15);
			QualityControlEntityJson json12=new QualityControlEntityJson("减灰（回收率）","","%",entity.getJianhui(),"GB 474-2008",16);
			list.add(json1);
			list.add(json2);
			list.add(json3);
			list.add(json4);
			list.add(json5);
			list.add(json6);
			list.add(json7);
			list.add(json8);
			list.add(json9_1);
			list.add(json9_2);
			list.add(json10_1);
			list.add(json10_2);
			list.add(json10_3);
			list.add(json10_4);
			list.add(json11);
			list.add(json12);
		}
		return list;
		
	}

}
