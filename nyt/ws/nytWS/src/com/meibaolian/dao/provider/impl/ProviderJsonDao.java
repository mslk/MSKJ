package com.meibaolian.dao.provider.impl;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.dao.base.impl.BaseDao;
import com.meibaolian.dao.provider.IProviderJsonDao;
import com.meibaolian.entity.Provider;
import com.meibaolian.entity.ProviderJson;
import com.meibaolian.entity.SearchlogCoal;
import com.meibaolian.util.ConfigUtil;
import com.meibaolian.util.UtilHelp;
import com.meibaolian.util.exception.DataManagerException;
import com.meibaolian.util.tablehash.TableRules;

public class ProviderJsonDao extends BaseDao<ProviderJson> implements
		IProviderJsonDao {

	@Override
	public QueryResult<ProviderJson> searchProviders(SearchlogCoal searchlog,
			int page, int pageSize, LinkedHashMap<String, String> orders)
			throws DataManagerException {
		/**
		 * proid, userid, addtime, coaltype, coalname, buyername, heating,
		 * coalsize, sulphur, ash, moisture, price, taxprice, transportype, sendoutplace, place, validdate,
		 * quantity, sortnumber, status, phone
		 * ----------------
		 * "select u.companyname,u.realname,u.phone as uphone,p.proid,p.userid,p.addtime,p.coaltype,p.coalname,p.buyername,p.heating,p.coalsize,p.sulphur,p.ash, p.moisture,p.price,p.taxprice,p.transportype,p.sendoutplace,p.place,p.validdate,p.quantity,p.phone from "
		 */

		String tableName = TableRules.getProviderRule();
		String userTable = TableRules.getUserInfoRule();
		
		StringBuilder sql = new StringBuilder("");
		sql.append("select u.companyname,u.realname,u.phone as uphone,p.* from ");
		sql.append(tableName).append(" p,").append(userTable).append(
				" u where 1=1 ");
		sql.append(" and p.userid=u.id ");

		List<Object> list = new ArrayList<Object>();

		/*if (searchlog.getCoaltype() > 0) {
			sql.append(" and p.coaltype=? ");
			list.add(searchlog.getCoaltype());
		}else*/ if(UtilHelp.isNotNullStr(searchlog.getCoalname())){
			sql.append(" and p.coalname like ? ");
			list.add(UtilHelp.setSQLLikeStr(searchlog.getCoalname()));
		}
		
		/*if(null != searchlog.getBuyername()){
			sql.append(" and (u.companyname like ? or u.realname like ?)");
			list.add(searchlog.getBuyername());
			list.add(searchlog.getBuyername());
		}*/
		if (searchlog.getMaxheatingtype() > 0 && searchlog.getMinheatingtype() <= searchlog.getMaxheatingtype()) {

			sql.append(" and (p.heating>=? and p.heating<=?) ");
			list.add(searchlog.getMinheatingtype());
			list.add(searchlog.getMaxheatingtype());
		}
		/*if (searchlog.getMincoalsize() > 0 && searchlog.getMaxcoalsize() > 0) {
			sql.append(" and (p.coalsize>=? and p.coalsize<=?) ");
			list.add(searchlog.getMincoalsize());
			list.add(searchlog.getMaxcoalsize());
		}*/
		/*if (searchlog.getMaxcoalsize() > 0) {//煤粒度为精确值--区间标识值，0为不限
			sql.append(" and p.coalsize=? ");
			list.add(searchlog.getMaxcoalsize());
		}else*/ if(UtilHelp.isNotNullStr(searchlog.getCoalsizename())){
			sql.append(" and p.coalsizename like ? ");
			list.add(UtilHelp.setSQLLikeStr(searchlog.getCoalsizename()));
		}
		/*if (searchlog.getMinsulphur() > 0 && searchlog.getMaxsulphur() > 0) {
			sql.append(" and (p.sulphur>=? and p.sulphur<=?) ");
			list.add(searchlog.getMinsulphur());
			list.add(searchlog.getMaxsulphur());
		}
		if (searchlog.getMinash() > 0 && searchlog.getMaxash() > 0) { 
			sql.append(" and (p.ash>=? and p.ash<=?) ");
			list.add(searchlog.getMinash());
			list.add(searchlog.getMaxash());
		}
		if (searchlog.getMinmoisture() > 0 && searchlog.getMaxmoisture() > 0) {
			sql.append(" and (p.moisture>=? and p.moisture<=?) ");
			list.add(searchlog.getMinmoisture());
			list.add(searchlog.getMaxmoisture());
		}*/
		if (searchlog.getMaxsulphur().compareTo(UtilHelp.BIGDECIMAL_ZERO) > 0) {//目标硫分匹配小于上限的
			sql.append(" and p.sulphur<=? ");
			list.add(searchlog.getMaxsulphur());
		}
		if (searchlog.getMaxash().compareTo(UtilHelp.BIGDECIMAL_ZERO) > 0) { //目标灰分匹配小于上限的
			sql.append(" and p.ash<=? ");
			list.add(searchlog.getMaxash());
		}
		if (searchlog.getMaxmoisture().compareTo(UtilHelp.BIGDECIMAL_ZERO) > 0) {//目标全水匹配小于上限的
			sql.append(" and p.moisture<=? ");
			list.add(searchlog.getMaxmoisture());
		}
		/*if (searchlog.getMaxprice().compareTo(UtilHelp.BIGDECIMAL_ZERO) > 0 && searchlog.getMinprice().compareTo(searchlog.getMaxprice()) <= 0) {
			sql.append(" and (p.price>=? and p.price<=?) ");
			list.add(searchlog.getMinprice());
			list.add(searchlog.getMaxprice());
		}
		if (searchlog.getMaxtaxprice().compareTo(UtilHelp.BIGDECIMAL_ZERO) > 0 && searchlog.getMintaxprice().compareTo(searchlog.getMaxtaxprice()) <= 0) {
			sql.append(" and (p.taxprice>=? and p.taxprice<=?) ");
			list.add(searchlog.getMintaxprice());
			list.add(searchlog.getMaxtaxprice());
		}
		if (null != searchlog.getTransportype()) {
			sql.append(" and p.transportype=? ");
			list.add(searchlog.getTransportype());
		}*/
		/*if (searchlog.getPlaceid() > 0) {//煤矿
			sql.append(" and p.placeid=? ");
			list.add(searchlog.getPlaceid());
		}else*/ if (UtilHelp.isNotNullStr(searchlog.getPlace())) {
			sql.append(" and p.place like ? ");
			list.add(UtilHelp.setSQLLikeStr(searchlog.getPlace()));
		}
		/*if (searchlog.getStartcountyid() > 0) {//区县
			sql.append(" and p.startcountyid=? ");
			list.add(searchlog.getStartcountyid());
		}else*/ if (UtilHelp.isNotNullStr(searchlog.getStartcountyname())) {
			sql.append(" and p.startcountyname like ? ");
			list.add(UtilHelp.setSQLLikeStr(searchlog.getStartcountyname()));
		}
		/*if (searchlog.getStartcityid() > 0) {//城市
			sql.append(" and p.startcityid=? ");
			list.add(searchlog.getStartcityid());
		}else*/ if (UtilHelp.isNotNullStr(searchlog.getStartcityname())) {
			sql.append(" and p.startcityname like ? ");
			list.add(UtilHelp.setSQLLikeStr(searchlog.getStartcityname()));
		}
		/*if (searchlog.getStartprvid() > 0) {//省份
			sql.append(" and p.startprvid=? ");
			list.add(searchlog.getStartprvid());
		}else */if (UtilHelp.isNotNullStr(searchlog.getStartprvname())) {
			sql.append(" and p.startprvname like ? ");
			list.add(UtilHelp.setSQLLikeStr(searchlog.getStartprvname()));
		}

		//发布后列表展示，自己在第一条，其它排除自己
		if(null != searchlog.getId() && searchlog.getId() > 0){
			sql.append(" and p.proid <>? ");
			list.add(searchlog.getId());
		}
		sql.append(" and p.validdate>=?  and p.validstatus=0 ");
		list.add(UtilHelp.dateFormatStr(new Date(), "yyyy-MM-dd"));
		
		return super.search(sql.toString(), providerRowMapper2, tableName,
				page, pageSize, list.toArray(), orders);
	}

	@Override
	public QueryResult<ProviderJson> searchProvidersWithRate(
			SearchlogCoal searchlog, int page, int pageSize,
			LinkedHashMap<String, String> orders) throws DataManagerException {
		/**
		 * ----------------
			select t.*,rate,
			    case  when price>0 && rate is not null then price+rate 
			          when price>0 && rate is null then price
			          else 0 
			    end as totalprice,
			    case  when t.taxprice>0&& rate is not null then taxprice+rate 
			          when t.taxprice>0&& rate is null then taxprice
			          else 0 
			    end as totaltaxprice 
			from 
			    (select u.companyname,u.realname,u.phone as uphone,
			    p.startprvname,p.startcityname,p.startcountyname,p.place,p.price,p.taxprice
			    from provider p,userinfo u
			    where 1=1  
			    and p.userid=u.id  
			    and p.validdate>=now() )t 
			left join highwayrate h 
			on t.startprvname=h.startprvname 
			and t.startcityname=h.startcityname
			and t.startcountyname = h.start
			and h.stopprvname='北京市'
			and h.stopcityname='北京市'
			and h.stop = '东城区'
			order  by  totalprice desc
		 * ---------------
		 */

		String tableName = TableRules.getProviderRule();
		String userTable = TableRules.getUserInfoRule();
		String highwayrateTable = TableRules.getHighwayrateRule();
		
		StringBuilder sortsql = new StringBuilder("");
		sortsql.append("select t.*,rate,");
		sortsql.append(" case  when price>0 && rate is not null then price+rate ");
		sortsql.append(" when price>0 && rate is null then price ");
		sortsql.append(" else 0 ");
		sortsql.append(" end as totalprice, ");
		
		sortsql.append(" case  when taxprice>0 && rate is not null then taxprice+rate  ");
		sortsql.append(" when taxprice>0 && rate is null then taxprice ");
		sortsql.append(" else 0 ");
		sortsql.append(" end as totaltaxprice ");
		sortsql.append(" from (");
		
		StringBuilder sql = new StringBuilder("");
		sql.append("select u.companyname,u.realname,u.phone as uphone,p.* from ");
		sql.append(tableName).append(" p,").append(userTable).append(
				" u where 1=1 ");
		sql.append(" and p.userid=u.id ");

		List<Object> list = new ArrayList<Object>();

		/*if (searchlog.getCoaltype() > 0) {
			sql.append(" and p.coaltype=? ");
			list.add(searchlog.getCoaltype());
		}else*/ if(UtilHelp.isNotNullStr(searchlog.getCoalname())){
			sql.append(" and p.coalname like ? ");
			list.add(UtilHelp.setSQLLikeStr(searchlog.getCoalname()));
		}
		
		/*if(null != searchlog.getBuyername()){
			sql.append(" and (u.companyname like ? or u.realname like ?)");
			list.add(searchlog.getBuyername());
			list.add(searchlog.getBuyername());
		}*/
		if (searchlog.getMaxheatingtype() > 0 && searchlog.getMinheatingtype() <= searchlog.getMaxheatingtype()) {

			sql.append(" and (p.heating>=? and p.heating<=?) ");
			list.add(searchlog.getMinheatingtype());
			list.add(searchlog.getMaxheatingtype());
		}
		/*if (searchlog.getMincoalsize() > 0 && searchlog.getMaxcoalsize() > 0) {
			sql.append(" and (p.coalsize>=? and p.coalsize<=?) ");
			list.add(searchlog.getMincoalsize());
			list.add(searchlog.getMaxcoalsize());
		}*/
		/*if (searchlog.getMaxcoalsize() > 0) {//煤粒度为精确值--区间标识值，0为不限
			sql.append(" and p.coalsize=? ");
			list.add(searchlog.getMaxcoalsize());
		}else*/ if(UtilHelp.isNotNullStr(searchlog.getCoalsizename())){
			sql.append(" and p.coalsizename like ? ");
			list.add(UtilHelp.setSQLLikeStr(searchlog.getCoalsizename()));
		}
		/*if (searchlog.getMinsulphur() > 0 && searchlog.getMaxsulphur() > 0) {
			sql.append(" and (p.sulphur>=? and p.sulphur<=?) ");
			list.add(searchlog.getMinsulphur());
			list.add(searchlog.getMaxsulphur());
		}
		if (searchlog.getMinash() > 0 && searchlog.getMaxash() > 0) { 
			sql.append(" and (p.ash>=? and p.ash<=?) ");
			list.add(searchlog.getMinash());
			list.add(searchlog.getMaxash());
		}
		if (searchlog.getMinmoisture() > 0 && searchlog.getMaxmoisture() > 0) {
			sql.append(" and (p.moisture>=? and p.moisture<=?) ");
			list.add(searchlog.getMinmoisture());
			list.add(searchlog.getMaxmoisture());
		}*/
		if (searchlog.getMaxsulphur().compareTo(UtilHelp.BIGDECIMAL_ZERO) > 0) {//目标硫分匹配小于上限的
			sql.append(" and p.sulphur<=? ");
			list.add(searchlog.getMaxsulphur());
		}
		if (searchlog.getMaxash().compareTo(UtilHelp.BIGDECIMAL_ZERO) > 0) { //目标灰分匹配小于上限的
			sql.append(" and p.ash<=? ");
			list.add(searchlog.getMaxash());
		}
		if (searchlog.getMaxmoisture().compareTo(UtilHelp.BIGDECIMAL_ZERO) > 0) {//目标全水匹配小于上限的
			sql.append(" and p.moisture<=? ");
			list.add(searchlog.getMaxmoisture());
		}
		/*if (searchlog.getMaxprice().compareTo(UtilHelp.BIGDECIMAL_ZERO) > 0 && searchlog.getMinprice().compareTo(searchlog.getMaxprice()) <= 0) {
			sql.append(" and (p.price>=? and p.price<=?) ");
			list.add(searchlog.getMinprice());
			list.add(searchlog.getMaxprice());
		}
		if (searchlog.getMaxtaxprice().compareTo(UtilHelp.BIGDECIMAL_ZERO) > 0 && searchlog.getMintaxprice().compareTo(searchlog.getMaxtaxprice()) <= 0) {
			sql.append(" and (p.taxprice>=? and p.taxprice<=?) ");
			list.add(searchlog.getMintaxprice());
			list.add(searchlog.getMaxtaxprice());
		}
		if (null != searchlog.getTransportype()) {
			sql.append(" and p.transportype=? ");
			list.add(searchlog.getTransportype());
		}*/
		/*if (searchlog.getPlaceid() > 0) {//煤矿
			sql.append(" and p.placeid=? ");
			list.add(searchlog.getPlaceid());
		}else*/ if (UtilHelp.isNotNullStr(searchlog.getPlace())) {
			sql.append(" and p.place like ? ");
			list.add(UtilHelp.setSQLLikeStr(searchlog.getPlace()));
		}
		/*if (searchlog.getStartcountyid() > 0) {//区县
			sql.append(" and p.startcountyid=? ");
			list.add(searchlog.getStartcountyid());
		}else*/ if (UtilHelp.isNotNullStr(searchlog.getStartcountyname())) {
			sql.append(" and p.startcountyname like ? ");
			list.add(UtilHelp.setSQLLikeStr(searchlog.getStartcountyname()));
		}
		/*if (searchlog.getStartcityid() > 0) {//城市
			sql.append(" and p.startcityid=? ");
			list.add(searchlog.getStartcityid());
		}else*/ if (UtilHelp.isNotNullStr(searchlog.getStartcityname())) {
			sql.append(" and p.startcityname like ? ");
			list.add(UtilHelp.setSQLLikeStr(searchlog.getStartcityname()));
		}
		/*if (searchlog.getStartprvid() > 0) {//省份
			sql.append(" and p.startprvid=? ");
			list.add(searchlog.getStartprvid());
		}else */if (UtilHelp.isNotNullStr(searchlog.getStartprvname())) {
			sql.append(" and p.startprvname like ? ");
			list.add(UtilHelp.setSQLLikeStr(searchlog.getStartprvname()));
		}

		//发布后列表展示，自己在第一条，其它排除自己
		if(null != searchlog.getId() && searchlog.getId() > 0){
			sql.append(" and p.proid <>? ");
			list.add(searchlog.getId());
		}
		sql.append(" and p.validdate>=?  and p.validstatus=0 ");
		list.add(UtilHelp.dateFormatStr(new Date(), "yyyy-MM-dd"));
		
		sortsql.append(sql).append(") t ") ;
		sortsql.append(" left join ").append(highwayrateTable).append(" h ");
		sortsql.append(" on t.startprvname=h.startprvname ");
		sortsql.append(" and t.startcityname=h.startcityname ");
		sortsql.append(" and t.startcountyname = h.start ");
		sortsql.append(" and h.stopprvname=? ");
		sortsql.append(" and h.stopcityname=? ");
		sortsql.append(" and h.stop=? ");
		list.add(searchlog.getStopprvname());
		list.add(searchlog.getStopcityname());
		list.add(searchlog.getReceiptplace());
		
		return super.search(sortsql.toString(), providerJsonRowMapper, tableName,
				page, pageSize, list.toArray(), orders);
	}

	private static RowMapper<ProviderJson> providerJsonRowMapper = new RowMapper<ProviderJson>() {

		@Override
		public ProviderJson mapRow(ResultSet arg0, int arg1)
				throws SQLException {

			ProviderJson providerJson = new ProviderJson();
			providerJson.setBuyername(arg0.getString("realname"));
			providerJson.setCompany(arg0.getString("companyname"));
			providerJson.setProid(arg0.getInt("proid"));
			providerJson.setUserid(arg0.getInt("userid"));
			providerJson.setAddtime(arg0.getDate("addtime").toString());
			providerJson.setCoaltype(arg0.getInt("coaltype"));
			providerJson.setCoalname(arg0.getString("coalname"));
			providerJson.setHeating(arg0.getInt("heating"));
			providerJson.setCoalsize(arg0.getInt("coalsize"));
			providerJson.setSulphur(arg0.getString("sulphur"));
			providerJson.setAsh(arg0.getString("ash"));
			providerJson.setMoisture(arg0.getString("moisture"));
			providerJson.setPrice(arg0.getString("price"));
			providerJson.setTaxprice(arg0.getString("taxprice"));
			providerJson.setTransportype(arg0.getInt("transportype"));
			providerJson.setSendoutplace(arg0.getString("sendoutplace"));
			providerJson.setPlace(arg0.getString("place"));
			providerJson.setValiddate(String.valueOf(UtilHelp.getDayOffset(new Date(), arg0.getDate("validdate"))));
//			providerJson.setValiddate(arg0.getDate("validdate").toString());
			providerJson.setQuantity(arg0.getInt("quantity"));
//			providerJson.setPhone(arg0.getString("phone"));
			providerJson.setPhone(arg0.getString("uphone"));
			if(UtilHelp.isNullStr(providerJson.getBuyername())){
				providerJson.setBuyername(providerJson.getPhone());
			}
//			providerJson.setCoalsizename(ConfigUtil.coalSizeNameMap.get(providerJson.getCoalsize()));
			providerJson.setCoalsizename(arg0.getString("coalsizename"));
			providerJson.setPlaceid(arg0.getInt("placeid"));
			providerJson.setStartcountyid(arg0.getInt("startcountyid"));
			providerJson.setStartcountyname(arg0.getString("startcountyname"));
			providerJson.setStartcityid(arg0.getInt("startcityid"));
			providerJson.setStartcityname(arg0.getString("startcityname"));
			providerJson.setStartprvid(arg0.getInt("startprvid"));
			providerJson.setStartprvname(arg0.getString("startprvname"));
			providerJson.setStartshortname(arg0.getString("startshortname"));
			providerJson.setRate(arg0.getString("rate"));
			providerJson.setTotalprice(arg0.getString("totalprice"));
			providerJson.setTotaltaxprice(arg0.getString("totaltaxprice"));
			providerJson.setSortnumber(arg0.getInt("sortnumber"));
			return providerJson;
		}

	};
	
	private static RowMapper<ProviderJson> providerRowMapper = new RowMapper<ProviderJson>(){

		@Override
		public ProviderJson mapRow(ResultSet arg0, int arg1) throws SQLException {
			
			ProviderJson providerJson = new ProviderJson();
			providerJson.setBuyername(arg0.getString("realname"));
			providerJson.setCompany(arg0.getString("companyname"));
			providerJson.setProid(arg0.getInt("proid"));
			providerJson.setUserid(arg0.getInt("userid"));
			providerJson.setAddtime(arg0.getDate("addtime").toString());
			providerJson.setCoaltype(arg0.getInt("coaltype"));
			providerJson.setCoalname(arg0.getString("coalname"));
			providerJson.setHeating(arg0.getInt("heating"));
			providerJson.setCoalsize(arg0.getInt("coalsize"));
			providerJson.setSulphur(arg0.getString("sulphur"));
			providerJson.setAsh(arg0.getString("ash"));
			providerJson.setMoisture(arg0.getString("moisture"));
			providerJson.setPrice(arg0.getString("price"));
			providerJson.setTaxprice(arg0.getString("taxprice"));
			providerJson.setTransportype(arg0.getInt("transportype"));
			providerJson.setSendoutplace(arg0.getString("sendoutplace"));
			providerJson.setPlace(arg0.getString("place"));
//			providerJson.setValiddate(String.valueOf(UtilHelp.getDayOffset(new Date(), arg0.getDate("validdate"))));
			providerJson.setValiddate(arg0.getDate("validdate").toString());
			providerJson.setQuantity(arg0.getInt("quantity"));
//			providerJson.setPhone(arg0.getString("phone"));
			providerJson.setPhone(arg0.getString("uphone"));
			if(UtilHelp.isNullStr(providerJson.getBuyername())){
				providerJson.setBuyername(providerJson.getPhone());
			}
//			providerJson.setCoalsizename(ConfigUtil.coalSizeNameMap.get(providerJson.getCoalsize()));
			providerJson.setCoalsizename(arg0.getString("coalsizename"));
			providerJson.setPlaceid(arg0.getInt("placeid"));
			providerJson.setStartcountyid(arg0.getInt("startcountyid"));
			providerJson.setStartcountyname(arg0.getString("startcountyname"));
			providerJson.setStartcityid(arg0.getInt("startcityid"));
			providerJson.setStartcityname(arg0.getString("startcityname"));
			providerJson.setStartprvid(arg0.getInt("startprvid"));
			providerJson.setStartprvname(arg0.getString("startprvname"));
			providerJson.setStartshortname(arg0.getString("startshortname"));
			providerJson.setSortnumber(arg0.getInt("sortnumber"));
			//
			if(UtilHelp.isNullStr(providerJson.getPrice())){
				providerJson.setTotalprice("0");
			}else{
				providerJson.setTotalprice(providerJson.getPrice());
			}

			if(UtilHelp.isNullStr(providerJson.getTaxprice())){
				providerJson.setTotaltaxprice("0");
			}else{
				providerJson.setTotaltaxprice(providerJson.getTaxprice());
			}
			return providerJson;
		}
		
	};
	
	private static RowMapper<ProviderJson> providerRowMapper2 = new RowMapper<ProviderJson>(){

		@Override
		public ProviderJson mapRow(ResultSet arg0, int arg1) throws SQLException {
			
			ProviderJson providerJson = new ProviderJson();
			providerJson.setBuyername(arg0.getString("realname"));
			providerJson.setCompany(arg0.getString("companyname"));
			providerJson.setProid(arg0.getInt("proid"));
			providerJson.setUserid(arg0.getInt("userid"));
			providerJson.setAddtime(arg0.getDate("addtime").toString());
			providerJson.setCoaltype(arg0.getInt("coaltype"));
			providerJson.setCoalname(arg0.getString("coalname"));
			providerJson.setHeating(arg0.getInt("heating"));
			providerJson.setCoalsize(arg0.getInt("coalsize"));
			providerJson.setSulphur(arg0.getString("sulphur"));
			providerJson.setAsh(arg0.getString("ash"));
			providerJson.setMoisture(arg0.getString("moisture"));
			providerJson.setPrice(arg0.getString("price"));
			providerJson.setTaxprice(arg0.getString("taxprice"));
			providerJson.setTransportype(arg0.getInt("transportype"));
			providerJson.setSendoutplace(arg0.getString("sendoutplace"));
			providerJson.setPlace(arg0.getString("place"));
			providerJson.setValiddate(String.valueOf(UtilHelp.getDayOffset(new Date(), arg0.getDate("validdate"))));
//			providerJson.setValiddate(arg0.getDate("validdate").toString());
			providerJson.setQuantity(arg0.getInt("quantity"));
//			providerJson.setPhone(arg0.getString("phone"));
			providerJson.setPhone(arg0.getString("uphone"));
			if(UtilHelp.isNullStr(providerJson.getBuyername())){
				providerJson.setBuyername(providerJson.getPhone());
			}
//			providerJson.setCoalsizename(ConfigUtil.coalSizeNameMap.get(providerJson.getCoalsize()));
			providerJson.setCoalsizename(arg0.getString("coalsizename"));
			providerJson.setPlaceid(arg0.getInt("placeid"));
			providerJson.setStartcountyid(arg0.getInt("startcountyid"));
			providerJson.setStartcountyname(arg0.getString("startcountyname"));
			providerJson.setStartcityid(arg0.getInt("startcityid"));
			providerJson.setStartcityname(arg0.getString("startcityname"));
			providerJson.setStartprvid(arg0.getInt("startprvid"));
			providerJson.setStartprvname(arg0.getString("startprvname"));
			providerJson.setStartshortname(arg0.getString("startshortname"));
			providerJson.setSortnumber(arg0.getInt("sortnumber"));
			//
			if(UtilHelp.isNullStr(providerJson.getPrice())){
				providerJson.setTotalprice("0");
			}else{
				providerJson.setTotalprice(providerJson.getPrice());
			}

			if(UtilHelp.isNullStr(providerJson.getTaxprice())){
				providerJson.setTotaltaxprice("0");
			}else{
				providerJson.setTotaltaxprice(providerJson.getTaxprice());
			}
			
			return providerJson;
		}
		
	};
	@Override
	public ProviderJson getById(int id) throws DataManagerException {
		String tableName = TableRules.getProviderRule();
		String userTable = TableRules.getUserInfoRule();
		StringBuilder sql = new StringBuilder(
				"select u.companyname,u.realname,u.phone as uphone,p.* from ");
		sql.append(tableName).append(" p,").append(userTable).append(
				" u where 1=1 ");
		sql.append(" and p.userid=u.id  and p.proid=?  and p.validstatus=0  ");

		return super.getById(sql.toString(), new Object[] { id }, tableName,
				providerRowMapper);
	}

	@Override
	public QueryResult<ProviderJson> searchByKey(String keyword, int page,
			int pageSize, LinkedHashMap<String, String> orders)
			throws DataManagerException {
		String tableName = TableRules.getProviderRule();
		String userTable = TableRules.getUserInfoRule();
		StringBuilder sql = new StringBuilder(
				"select u.companyname,u.realname,u.phone as uphone,p.* from ");
		sql.append(tableName).append(" p,").append(userTable).append(
				" u where 1=1  and p.validstatus=0 ");
		sql.append(" and p.userid=u.id ");
		List<Object> list = new ArrayList<Object>(1);
		sql.append(" and p.validdate>=? ");
		list.add(UtilHelp.dateFormatStr(new Date(), "yyyy-MM-dd"));
		if(keyword != null){
			keyword = "%"+keyword+"%";
//			sql.append(" and (u.realname like ? ");
//			sql.append(" or p.heating like ? ");
			sql.append(" and (p.heating like ? ");
			sql.append(" or p.price like ? ");
			sql.append(" or p.taxprice like ? ");
			sql.append(" or p.startprvname like ? ");
			sql.append(" or p.startcityname like ? ");
			sql.append(" or p.startcountyname like ? ");
			sql.append(" or p.place like ? ");
			sql.append(" or p.quantity like ? )");
			list.add(keyword);
			list.add(keyword);
			list.add(keyword);
			list.add(keyword);
			list.add(keyword);
			list.add(keyword);
			list.add(keyword);
			list.add(keyword);
		}
		
		return super.search(sql.toString(), providerRowMapper, tableName, page, pageSize, list.toArray(), orders);
	}
}
