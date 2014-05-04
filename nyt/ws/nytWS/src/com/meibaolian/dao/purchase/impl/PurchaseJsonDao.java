package com.meibaolian.dao.purchase.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.dao.base.impl.BaseDao;
import com.meibaolian.dao.purchase.IPurchaseJsonDao;
import com.meibaolian.entity.PurchaseJson;
import com.meibaolian.entity.SearchlogCoal;
import com.meibaolian.util.ConfigUtil;
import com.meibaolian.util.UtilHelp;
import com.meibaolian.util.exception.DataManagerException;
import com.meibaolian.util.tablehash.TableRules;

public class PurchaseJsonDao extends BaseDao<PurchaseJson> implements IPurchaseJsonDao {


	@Override
	public QueryResult<PurchaseJson> searchPurchases(SearchlogCoal searchlog, int page, int pageSize, LinkedHashMap<String, String> orders) throws DataManagerException {
		/**
		 * purid, userid, addtime, coaltype, coalname, buyername, heating, coalsize, sulphur, ash, moisture,
		 * price, taxprice, transportype, place, validdate, quantity, sortnumber, status, phone
		 * 
		 * "select u.companyname,u.realname,u.phone as uphone,p.purid,p.userid,p.addtime,p.coaltype,p.coalname,p.buyername,p.heating,p.coalsize,p.sulphur,p.ash, p.moisture,p.price,p.taxprice,p.transportype,p.place,p.receiptplace,p.validdate,p.quantity,p.phone from "
		 */
			
		String tableName = TableRules.getPurchaseRule();
		String userTable = TableRules.getUserInfoRule();
		StringBuilder sql = new StringBuilder(
				"select u.companyname,u.realname,u.phone as uphone,p.* from ");
		sql.append(tableName).append(" p,").append(userTable).append(" u where 1=1  and p.validstatus=0 ");
		sql.append(" and p.userid=u.id ");
		
		List<Object> list = new ArrayList<Object>();

		/*if (searchlog.getCoaltype() > 0) {
			sql.append(" and p.coaltype=? ");
			list.add(searchlog.getCoaltype());
		}else*/ if(UtilHelp.isNotNullStr(searchlog.getCoalname())){
			sql.append(" and p.coalname like ? ");
			list.add(UtilHelp.setSQLLikeStr(searchlog.getCoalname()));
		}
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
		/*if (searchlog.getMaxprice().compareTo(UtilHelp.BIGDECIMAL_ZERO) > 0 && searchlog.getMinprice().compareTo(searchlog.getMaxprice()) <= 0 ) {
			sql.append(" and (p.price>=? and p.price<=?) ");
			list.add(searchlog.getMinprice());
			list.add(searchlog.getMaxprice());
		}
		if (searchlog.getMaxtaxprice().compareTo(UtilHelp.BIGDECIMAL_ZERO) > 0 && searchlog.getMintaxprice().compareTo(searchlog.getMaxtaxprice()) <=0) {
			sql.append(" and (p.taxprice>=? and p.taxprice<=?) ");
			list.add(searchlog.getMintaxprice());
			list.add(searchlog.getMaxtaxprice());
		}
		if(null != searchlog.getTransportype() ){
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
		}else*/ if (UtilHelp.isNotNullStr(searchlog.getStartprvname())) {
			sql.append(" and p.startprvname like ? ");
			list.add(UtilHelp.setSQLLikeStr(searchlog.getStartprvname()));
		}
		//发布后列表展示，自己在第一条，其它排除自己
		if(null != searchlog.getId() && searchlog.getId() > 0){
			sql.append(" and p.purid <>? ");
			list.add(searchlog.getId());
		}
		sql.append(" and p.validdate>=? ");
		list.add(UtilHelp.dateFormatStr(new Date(), "yyyy-MM-dd"));
		
		return super.search(sql.toString(), purchaseJsonRowMapper, tableName, page, pageSize, list.toArray(), orders);
	}
	


	@Override
	public PurchaseJson getById(int id) throws DataManagerException {
		String tableName = TableRules.getPurchaseRule();
		String userTable = TableRules.getUserInfoRule();
		StringBuilder sql = new StringBuilder(
				"select u.companyname,u.realname,u.phone as uphone,p.* from ");
		sql.append(tableName).append(" p,").append(userTable).append(" u where 1=1  and p.validstatus=0 ");
		sql.append(" and p.userid=u.id and p.purid=? ");
		return super.getById(sql.toString(), new Object[]{id}, tableName, purchaseRowMapper);
	}

	@Override
	public QueryResult<PurchaseJson> searchByKey(String keyword, int page,
			int pageSize, LinkedHashMap<String, String> orders)
			throws DataManagerException {
		String tableName = TableRules.getPurchaseRule();
		String userTable = TableRules.getUserInfoRule();
		StringBuilder sql = new StringBuilder(
				"select u.companyname,u.realname,u.phone as uphone,p.* from ");
		sql.append(tableName).append(" p,").append(userTable).append(" u where 1=1  and p.validstatus=0 ");
		sql.append(" and p.userid=u.id ");
		List<Object> list = new ArrayList<Object>(1);
		sql.append(" and p.validdate>=? ");
		list.add(UtilHelp.dateFormatStr(new Date(), "yyyy-MM-dd"));
		if(keyword != null){
			keyword = "%"+keyword+"%";
//			sql.append(" and (u.realname like ? ");
//			sql.append(" or p.heating like ? ");
//			sql.append(" or p.receiptplace like ? ");
			
			sql.append(" and (p.heating like ? ");
			sql.append(" or p.quantity like ?) ");
//			list.add(keyword);
//			list.add(keyword);
			list.add(keyword);
			list.add(keyword);
		}
		return super.search(sql.toString(), purchaseJsonRowMapper, tableName, page, pageSize, list.toArray(), orders);
	}

	@Override
	public QueryResult<PurchaseJson> searchByPlace(SearchlogCoal searchlog,
			int page, int pageSize, LinkedHashMap<String, String> orders)
			throws DataManagerException {
		
		String tableName = TableRules.getPurchaseRule();
		String userTable = TableRules.getUserInfoRule();
		StringBuilder sql = new StringBuilder(
				"select u.companyname,u.realname,u.phone as uphone,p.* from ");
		sql.append(tableName).append(" p,").append(userTable).append(" u where 1=1  and p.validstatus=0 ");
		sql.append(" and p.userid=u.id ");
		
		List<Object> list = new ArrayList<Object>();
		
		sql.append(" and p.validdate>=? ");
		list.add(UtilHelp.dateFormatStr(new Date(), "yyyy-MM-dd"));
		
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
		//
		/*if (searchlog.getReceiptplaceid() > 0) {//区县
			sql.append(" and p.receiptplaceid=? ");
			list.add(searchlog.getReceiptplaceid());
		}else*/ if (UtilHelp.isNotNullStr(searchlog.getReceiptplace())) {
			sql.append(" and p.receiptplace like ? ");
			list.add(UtilHelp.setSQLLikeStr(searchlog.getReceiptplace()));
		}
		/*if (searchlog.getStopcityid() > 0) {//城市
			sql.append(" and p.stopcityid=? ");
			list.add(searchlog.getStopcityid());
		}else*/ if (UtilHelp.isNotNullStr(searchlog.getStopcityname())) {
			sql.append(" and p.stopcityname like ? ");
			list.add(UtilHelp.setSQLLikeStr(searchlog.getStopcityname()));
		}
		/*if (searchlog.getStopprvid() > 0) {//省份
			sql.append(" and p.stopprvid=? ");
			list.add(searchlog.getStopprvid());
		}else */if (UtilHelp.isNotNullStr(searchlog.getStopprvname())) {
			sql.append(" and p.stopprvname like ? ");
			list.add(UtilHelp.setSQLLikeStr(searchlog.getStopprvname()));
		}
		
		
		return super.search(sql.toString(), purchaseJsonRowMapper, tableName, page, pageSize, list.toArray(), orders);
	}

	private static RowMapper<PurchaseJson> purchaseJsonRowMapper = new RowMapper<PurchaseJson>(){

		@Override
		public PurchaseJson mapRow(ResultSet arg0, int arg1)
				throws SQLException {

			PurchaseJson purchaseJson = new PurchaseJson();
			purchaseJson.setBuyername(arg0.getString("realname"));
			purchaseJson.setCompany(arg0.getString("companyname"));
			purchaseJson.setPurid(arg0.getInt("purid"));
			purchaseJson.setUserid(arg0.getInt("userid"));
			purchaseJson.setAddtime(arg0.getDate("addtime").toString());
			purchaseJson.setCoaltype(arg0.getInt("coaltype"));
			purchaseJson.setCoalname(arg0.getString("coalname"));
			purchaseJson.setHeating(arg0.getInt("heating"));
			purchaseJson.setCoalsize(arg0.getInt("coalsize"));
			purchaseJson.setSulphur(arg0.getString("sulphur"));
			purchaseJson.setAsh(arg0.getString("ash"));
			purchaseJson.setMoisture(arg0.getString("moisture"));
			purchaseJson.setPrice(arg0.getString("price"));
			purchaseJson.setTaxprice(arg0.getString("taxprice"));
			purchaseJson.setTransportype(arg0.getInt("transportype"));
			purchaseJson.setPlace(arg0.getString("place"));
			purchaseJson.setReceiptplace(arg0.getString("receiptplace"));
//			purchaseJson.setValiddate(arg0.getDate("validdate").toString());
			purchaseJson.setValiddate(String.valueOf(UtilHelp.getDayOffset(new Date(), arg0.getDate("validdate"))));
			purchaseJson.setQuantity(arg0.getInt("quantity"));
//			purchaseJson.setPhone(arg0.getString("phone"));
			purchaseJson.setPhone(arg0.getString("uphone"));
			if(UtilHelp.isNullStr(purchaseJson.getBuyername())){
				purchaseJson.setBuyername(purchaseJson.getPhone());
			}
//			purchaseJson.setCoalsizename(ConfigUtil.coalSizeNameMap.get(purchaseJson.getCoalsize()));
			purchaseJson.setCoalsizename(arg0.getString("coalsizename"));
			purchaseJson.setPlaceid(arg0.getInt("placeid"));
			purchaseJson.setStartcountyid(arg0.getInt("startcountyid"));
			purchaseJson.setStartcountyname(arg0.getString("startcountyname"));
			purchaseJson.setStartcityid(arg0.getInt("startcityid"));
			purchaseJson.setStartcityname(arg0.getString("startcityname"));
			purchaseJson.setStartprvid(arg0.getInt("startprvid"));
			purchaseJson.setStartprvname(arg0.getString("startprvname"));
			purchaseJson.setStartshortname(arg0.getString("startshortname"));
			purchaseJson.setReceiptplaceid(arg0.getInt("receiptplaceid"));
			purchaseJson.setStopcityid(arg0.getInt("stopcityid"));
			purchaseJson.setStopcityname(arg0.getString("stopcityname"));
			purchaseJson.setStopprvid(arg0.getInt("stopprvid"));
			purchaseJson.setStopprvname(arg0.getString("stopprvname"));
			purchaseJson.setStopshortname(arg0.getString("stopshortname"));
			purchaseJson.setSortnumber(arg0.getInt("sortnumber"));
			return purchaseJson;
		}
		
	};
	private static RowMapper<PurchaseJson> purchaseRowMapper = new RowMapper<PurchaseJson>(){

		@Override
		public PurchaseJson mapRow(ResultSet arg0, int arg1)
				throws SQLException {

			PurchaseJson purchaseJson = new PurchaseJson();
			purchaseJson.setBuyername(arg0.getString("realname"));
			purchaseJson.setCompany(arg0.getString("companyname"));
			purchaseJson.setPurid(arg0.getInt("purid"));
			purchaseJson.setUserid(arg0.getInt("userid"));
			purchaseJson.setAddtime(arg0.getDate("addtime").toString());
			purchaseJson.setCoaltype(arg0.getInt("coaltype"));
			purchaseJson.setCoalname(arg0.getString("coalname"));
			purchaseJson.setHeating(arg0.getInt("heating"));
			purchaseJson.setCoalsize(arg0.getInt("coalsize"));
			purchaseJson.setSulphur(arg0.getString("sulphur"));
			purchaseJson.setAsh(arg0.getString("ash"));
			purchaseJson.setMoisture(arg0.getString("moisture"));
			purchaseJson.setPrice(arg0.getString("price"));
			purchaseJson.setTaxprice(arg0.getString("taxprice"));
			purchaseJson.setTransportype(arg0.getInt("transportype"));
			purchaseJson.setPlace(arg0.getString("place"));
			purchaseJson.setReceiptplace(arg0.getString("receiptplace"));
			purchaseJson.setValiddate(arg0.getDate("validdate").toString());
//			purchaseJson.setValiddate(String.valueOf(UtilHelp.getDayOffset(new Date(), arg0.getDate("validdate"))));
			purchaseJson.setQuantity(arg0.getInt("quantity"));
//			purchaseJson.setPhone(arg0.getString("phone"));
			purchaseJson.setPhone(arg0.getString("uphone"));
			if(UtilHelp.isNullStr(purchaseJson.getBuyername())){
				purchaseJson.setBuyername(purchaseJson.getPhone());
			}
//			purchaseJson.setCoalsizename(ConfigUtil.coalSizeNameMap.get(purchaseJson.getCoalsize()));
			purchaseJson.setCoalsizename(arg0.getString("coalsizename"));
			purchaseJson.setPlaceid(arg0.getInt("placeid"));
			purchaseJson.setStartcountyid(arg0.getInt("startcountyid"));
			purchaseJson.setStartcountyname(arg0.getString("startcountyname"));
			purchaseJson.setStartcityid(arg0.getInt("startcityid"));
			purchaseJson.setStartcityname(arg0.getString("startcityname"));
			purchaseJson.setStartprvid(arg0.getInt("startprvid"));
			purchaseJson.setStartprvname(arg0.getString("startprvname"));
			purchaseJson.setStartshortname(arg0.getString("startshortname"));
			purchaseJson.setReceiptplaceid(arg0.getInt("receiptplaceid"));
			purchaseJson.setStopcityid(arg0.getInt("stopcityid"));
			purchaseJson.setStopcityname(arg0.getString("stopcityname"));
			purchaseJson.setStopprvid(arg0.getInt("stopprvid"));
			purchaseJson.setStopprvname(arg0.getString("stopprvname"));
			purchaseJson.setStopshortname(arg0.getString("stopshortname"));
			purchaseJson.setSortnumber(arg0.getInt("sortnumber"));
			return purchaseJson;
		}
		
	};
}
