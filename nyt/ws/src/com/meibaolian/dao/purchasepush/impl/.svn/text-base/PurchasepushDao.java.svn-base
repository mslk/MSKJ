package com.meibaolian.dao.purchasepush.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.meibaolian.dao.base.impl.BaseDao;
import com.meibaolian.dao.purchasepush.IPurchasepushDao;
import com.meibaolian.entity.Purchasepush;
import com.meibaolian.entity.SearchlogCoal;
import com.meibaolian.util.UtilHelp;
import com.meibaolian.util.tablehash.TableRules;

public class PurchasepushDao extends BaseDao<Purchasepush> implements IPurchasepushDao{

	@Override
	public int addPurchasepush(SearchlogCoal searchlog, int status) {
		/**
		  * (userid,addtime,coaltype,buyername,coalnameminheatingtype,
		 * minheatingtype,maxheatingtype,mincoalsize,maxcoalsize,
		 * minsulphur,maxsulphur,minash,maxash,minmoisture,maxmoisture,minprice,maxprice,mintaxprice,
		 * maxtaxprice,transportype,place, status) values(?,...,?)
		 */
		String tableName = TableRules.getPurchasepushRule();
		
		StringBuilder sql = new StringBuilder("insert into ");
		StringBuilder val = new StringBuilder(" values(");
		List<Object> list = new ArrayList<Object>();
		
		sql.append(tableName).append(" (userid, addtime");
		val.append("?,?");
		list.add(searchlog.getUserid());
		list.add(new Date());
		
		if(searchlog.getCoaltype()>0){
			sql.append(", coaltype");
			val.append(",?");
			list.add(searchlog.getCoaltype());
		}
		if(UtilHelp.isNotNullStr(searchlog.getCoalname())){
			sql.append(", coalname");
			val.append(",?");
			list.add(searchlog.getCoalname());
		}
		if(UtilHelp.isNotNullStr(searchlog.getCoalsizename())){
			sql.append(", coalsizename");
			val.append(",?");
			list.add(searchlog.getCoalsizename());
		}
		
		if(null != searchlog.getBuyername()){
			sql.append(",buyername");
			val.append(",?");
			list.add(searchlog.getBuyername());
		}
		if(searchlog.getMinheatingtype() > 0){
			sql.append(",minheatingtype");
			val.append(",?");
			list.add(searchlog.getMinheatingtype());
		}
		if(searchlog.getMaxheatingtype() > 0){
			sql.append(",maxheatingtype");
			val.append(",?");
			list.add(searchlog.getMaxheatingtype());
		}
		if(searchlog.getMincoalsize() > 0){
			sql.append(",mincoalsize");
			val.append(",?");
			list.add(searchlog.getMincoalsize());
		}
		if(searchlog.getMaxcoalsize() > 0){
			sql.append(",maxcoalsize");
			val.append(",?");
			list.add(searchlog.getMaxcoalsize());
		}
		if(searchlog.getMinsulphur().compareTo(UtilHelp.BIGDECIMAL_ZERO) > 0){
			sql.append(",minsulphur");
			val.append(",?");
			list.add(searchlog.getMinsulphur());
		}
		if(searchlog.getMaxsulphur().compareTo(UtilHelp.BIGDECIMAL_ZERO) > 0){
			sql.append(",maxsulphur");
			val.append(",?");
			list.add(searchlog.getMaxsulphur());
		}
		if(searchlog.getMinash().compareTo(UtilHelp.BIGDECIMAL_ZERO) > 0){
			sql.append(",minash");
			val.append(",?");
			list.add(searchlog.getMinash());
		}
		if(searchlog.getMaxash().compareTo(UtilHelp.BIGDECIMAL_ZERO) > 0){
			sql.append(",maxash");
			val.append(",?");
			list.add(searchlog.getMaxash());
		}
		if(searchlog.getMinmoisture().compareTo(UtilHelp.BIGDECIMAL_ZERO) > 0){
			sql.append(",minmoisture");
			val.append(",?");
			list.add(searchlog.getMinmoisture());
		}
		if(searchlog.getMaxmoisture().compareTo(UtilHelp.BIGDECIMAL_ZERO) > 0){
			sql.append(",maxmoisture");
			val.append(",?");
			list.add(searchlog.getMaxmoisture());
		}
		/*if(searchlog.getMinprice().compareTo(UtilHelp.BIGDECIMAL_ZERO) > 0){
			sql.append(",minprice");
			val.append(",?");
			list.add(searchlog.getMinprice());
		}
		if(searchlog.getMaxprice().compareTo(UtilHelp.BIGDECIMAL_ZERO) > 0){
			sql.append(",maxprice");
			val.append(",?");
			list.add(searchlog.getMaxprice());
		}
		if(searchlog.getMintaxprice().compareTo(UtilHelp.BIGDECIMAL_ZERO) > 0){
			sql.append(",mintaxprice");
			val.append(",?");
			list.add(searchlog.getMintaxprice());
		}
		if(searchlog.getMaxtaxprice().compareTo(UtilHelp.BIGDECIMAL_ZERO) > 0){
			sql.append(",maxtaxprice");
			val.append(",?");
			list.add(searchlog.getMaxtaxprice());
		}*/
		if(null != searchlog.getTransportype()){
			sql.append(",transportype");
			val.append(",?");
			list.add(searchlog.getTransportype());
		}
		if(UtilHelp.isNotNullStr(searchlog.getPlace())){
			sql.append(",place");
			val.append(",?");
			list.add(searchlog.getPlace());
		}
		if(searchlog.getPlaceid() > 0){
			sql.append(",placeid");
			val.append(",?");
			list.add(searchlog.getPlaceid());
		}
		if(searchlog.getStartcountyid() > 0){
			sql.append(",startcountyid");
			val.append(",?");
			list.add(searchlog.getStartcountyid());
		}
		if(UtilHelp.isNotNullStr(searchlog.getStartcountyname())){
			sql.append(",startcountyname");
			val.append(",?");
			list.add(searchlog.getStartcountyname());
		}
		if(searchlog.getStartcityid() > 0){
			sql.append(",startcityid");
			val.append(",?");
			list.add(searchlog.getStartcityid());
		}
		if(UtilHelp.isNotNullStr(searchlog.getStartcityname())){
			sql.append(",startcityname");
			val.append(",?");
			list.add(searchlog.getStartcityname());
		}
		if(searchlog.getStartprvid() > 0){
			sql.append(",startprvid");
			val.append(",?");
			list.add(searchlog.getStartprvid());
		}
		if(UtilHelp.isNotNullStr(searchlog.getStartprvname())){
			sql.append(",startprvname");
			val.append(",?");
			list.add(searchlog.getStartprvname());
		}
		sql.append(",status)");
		val.append(",?)");
		list.add(status);

		sql.append(val);
		
		return super.add(sql.toString(), list.toArray(), tableName);
	}

	@Override
	public int updatePurchasepush(int userid, int status) {
		String tableName = TableRules.getPurchasepushRule();
		StringBuilder sql = new StringBuilder("update ").append(tableName);
		sql.append(" set status=? where userid=?");
		return super.update(sql.toString(), new Object[]{status, userid}, tableName);
	}

}
