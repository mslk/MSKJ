package com.meibaolian.dao.searchlog.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.meibaolian.dao.base.impl.BaseDao;
import com.meibaolian.dao.searchlog.ISearchlogDao;
import com.meibaolian.entity.SearchlogCoal;
import com.meibaolian.util.UtilHelp;
import com.meibaolian.util.tablehash.TableRules;

public class SearchlogDao extends BaseDao<SearchlogCoal> implements ISearchlogDao{

	@Override
	public int addSearchLog(SearchlogCoal searchlog) {
		/**
		 * insert into searchlog 
		 * (userid,addtime,coaltype,buyername,coalnameminheatingtype,
		 * minheatingtype,maxheatingtype,mincoalsize,maxcoalsize,
		 * minsulphur,maxsulphur,minash,maxash,minmoisture,maxmoisture,minprice,maxprice,mintaxprice,
		 * maxtaxprice,transportype,place,searchtype)
		 * values(?,...,?)
		 */
		String tableName = TableRules.getSearchlogRule();
		
		StringBuilder sql = new StringBuilder("insert into ");
		StringBuilder val = new StringBuilder(" values(");
		List<Object> list = new ArrayList<Object>();
		
		sql.append(tableName).append(" (addtime");
		val.append("?");
		list.add(new Date());
		
		int count = -1;
		if(null != searchlog.getCoaltype() && searchlog.getCoaltype()>0){
			sql.append(", coaltype");
			val.append(",?");
			list.add(searchlog.getCoaltype());
			count++;
		}
		if(UtilHelp.isNotNullStr(searchlog.getCoalname())){
			sql.append(", coalname");
			val.append(",?");
			list.add(searchlog.getCoalname());
			count++;
		}
		if(UtilHelp.isNotNullStr(searchlog.getCoalsizename())){
			sql.append(", coalsizename");
			val.append(",?");
			list.add(searchlog.getCoalsizename());
			count++;
		}

		if(null != searchlog.getUserid() && 0 <= searchlog.getUserid()){
			sql.append(",userid");
			val.append(",?");
			list.add(searchlog.getUserid());
		}
//		if(null != searchlog.getBuyername()){
//			sql.append(",buyername");
//			val.append(",?");
//			list.add(searchlog.getBuyername());
//			count++;
//		}
		if(null != searchlog.getMinheatingtype() && searchlog.getMinheatingtype() > 0){
			sql.append(",minheatingtype");
			val.append(",?");
			list.add(searchlog.getMinheatingtype());
			count++;
		}
		if(null != searchlog.getMaxheatingtype() && searchlog.getMaxheatingtype() > 0){
			sql.append(",maxheatingtype");
			val.append(",?");
			list.add(searchlog.getMaxheatingtype());
			count++;
		}
		if(null != searchlog.getMincoalsize() && searchlog.getMincoalsize() > 0){
			sql.append(",mincoalsize");
			val.append(",?");
			list.add(searchlog.getMincoalsize());
			count++;
		}
		if(null != searchlog.getMaxcoalsize() && searchlog.getMaxcoalsize() > 0){
			sql.append(",maxcoalsize");
			val.append(",?");
			list.add(searchlog.getMaxcoalsize());
			count++;
		}
		if(null != searchlog.getMinsulphur() && searchlog.getMinsulphur().compareTo(UtilHelp.BIGDECIMAL_ZERO) > 0){
			sql.append(",minsulphur");
			val.append(",?");
			list.add(searchlog.getMinsulphur());
			count++;
		}
		if(null != searchlog.getMaxsulphur() && searchlog.getMaxsulphur().compareTo(UtilHelp.BIGDECIMAL_ZERO) > 0){
			sql.append(",maxsulphur");
			val.append(",?");
			list.add(searchlog.getMaxsulphur());
			count++;
		}
		if(null != searchlog.getMinash() && searchlog.getMinash().compareTo(UtilHelp.BIGDECIMAL_ZERO) > 0){
			sql.append(",minash");
			val.append(",?");
			list.add(searchlog.getMinash());
			count++;
		}
		if(null != searchlog.getMaxash() && searchlog.getMaxash().compareTo(UtilHelp.BIGDECIMAL_ZERO) > 0){
			sql.append(",maxash");
			val.append(",?");
			list.add(searchlog.getMaxash());
			count++;
		}
		if(null != searchlog.getMinmoisture() && searchlog.getMinmoisture().compareTo(UtilHelp.BIGDECIMAL_ZERO) > 0){
			sql.append(",minmoisture");
			val.append(",?");
			list.add(searchlog.getMinmoisture());
			count++;
		}
		if(null != searchlog.getMaxmoisture() && searchlog.getMaxmoisture().compareTo(UtilHelp.BIGDECIMAL_ZERO) > 0){
			sql.append(",maxmoisture");
			val.append(",?");
			list.add(searchlog.getMaxmoisture());
			count++;
		}
		/*if(searchlog.getMinprice().compareTo(UtilHelp.BIGDECIMAL_ZERO) > 0){
			sql.append(",minprice");
			val.append(",?");
			list.add(searchlog.getMinprice());
			count++;
		}
		if(searchlog.getMaxprice().compareTo(UtilHelp.BIGDECIMAL_ZERO) > 0){
			sql.append(",maxprice");
			val.append(",?");
			list.add(searchlog.getMaxprice());
			count++;
		}
		if(searchlog.getMintaxprice().compareTo(UtilHelp.BIGDECIMAL_ZERO) > 0){
			sql.append(",mintaxprice");
			val.append(",?");
			list.add(searchlog.getMintaxprice());
			count++;
		}
		if(searchlog.getMaxtaxprice().compareTo(UtilHelp.BIGDECIMAL_ZERO) > 0){
			sql.append(",maxtaxprice");
			val.append(",?");
			list.add(searchlog.getMaxtaxprice());
			count++;
		}
		if(null != searchlog.getTransportype()){
			sql.append(",transportype");
			val.append(",?");
			list.add(searchlog.getTransportype());
		}*/
		if(UtilHelp.isNotNullStr(searchlog.getPlace())){
			sql.append(",place");
			val.append(",?");
			list.add(searchlog.getPlace());
			count++;
		}
		if(null != searchlog.getPlaceid() && searchlog.getPlaceid() > 0){
			sql.append(",placeid");
			val.append(",?");
			list.add(searchlog.getPlaceid());
			count++;
		}
		if(null != searchlog.getStartcountyid() && searchlog.getStartcountyid() > 0){
			sql.append(",startcountyid");
			val.append(",?");
			list.add(searchlog.getStartcountyid());
			count++;
		}
		if(UtilHelp.isNotNullStr(searchlog.getStartcountyname())){
			sql.append(",startcountyname");
			val.append(",?");
			list.add(searchlog.getStartcountyname());
			count++;
		}
		if(null != searchlog.getStartcityid() && searchlog.getStartcityid() > 0){
			sql.append(",startcityid");
			val.append(",?");
			list.add(searchlog.getStartcityid());
			count++;
		}
		if(UtilHelp.isNotNullStr(searchlog.getStartcityname())){
			sql.append(",startcityname");
			val.append(",?");
			list.add(searchlog.getStartcityname());
			count++;
		}
		if(null != searchlog.getStartprvid() && searchlog.getStartprvid() > 0){
			sql.append(",startprvid");
			val.append(",?");
			list.add(searchlog.getStartprvid());
			count++;
		}
		if(UtilHelp.isNotNullStr(searchlog.getStartprvname())){
			sql.append(",startprvname");
			val.append(",?");
			list.add(searchlog.getStartprvname());
			count++;
		}
		//
		if(null != searchlog.getReceiptplaceid() && searchlog.getReceiptplaceid() > 0){
			sql.append(",receiptplaceid");
			val.append(",?");
			list.add(searchlog.getReceiptplaceid());
			count++;
		}
		if(UtilHelp.isNotNullStr(searchlog.getReceiptplace())){
			sql.append(",receiptplace");
			val.append(",?");
			list.add(searchlog.getReceiptplace());
			count++;
		}
		if(null != searchlog.getStopcityid() && searchlog.getStopcityid() > 0){
			sql.append(",stopcityid");
			val.append(",?");
			list.add(searchlog.getStopcityid());
			count++;
		}
		if(UtilHelp.isNotNullStr(searchlog.getStopcityname())){
			sql.append(",stopcityname");
			val.append(",?");
			list.add(searchlog.getStopcityname());
			count++;
		}
		if(null != searchlog.getStopprvid() && searchlog.getStopprvid() > 0){
			sql.append(",stopprvid");
			val.append(",?");
			list.add(searchlog.getStopprvid());
			count++;
		}
		if(UtilHelp.isNotNullStr(searchlog.getStopprvname())){
			sql.append(",stopprvname");
			val.append(",?");
			list.add(searchlog.getStopprvname());
			count++;
		}
		//
		if(UtilHelp.isNotNullStr(searchlog.getKeyword())){
			sql.append(",keyword");
			val.append(",?");
			list.add(searchlog.getKeyword());
			count++;
		}
		sql.append(",searchtype)");
		val.append(",?)");
		sql.append(val);
		list.add(searchlog.getSearchtype());
		
		if(count > -1){
			count = super.add(sql.toString(), list.toArray(), tableName);
		}
		return count;
	}

}
