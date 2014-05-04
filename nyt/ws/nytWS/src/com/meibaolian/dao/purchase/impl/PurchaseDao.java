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
import com.meibaolian.dao.purchase.IPurchaseDao;
import com.meibaolian.entity.Purchase;
import com.meibaolian.util.ConfigUtil;
import com.meibaolian.util.UtilHelp;
import com.meibaolian.util.exception.DataManagerException;
import com.meibaolian.util.tablehash.TableRules;

public class PurchaseDao extends BaseDao<Purchase> implements IPurchaseDao{

	@Override
	public int addPurchase(Purchase purchase) {
		/**
		 * insert into purchase (userid, addtime, coaltype, coalname, buyername,
		 *  heating, coalsize, sulphur, ash, moisture, price, taxprice, transportype, place, 
		 *  validdate, quantity, sortnumber, status, phone) values(?,...,?)
		 */
		String tableName = TableRules.getPurchaseRule();
		
		StringBuilder sql = new StringBuilder("insert into ");
		StringBuilder val = new StringBuilder(" values(");
		List<Object> list = new ArrayList<Object>();
		
		sql.append(tableName).append(" (userid, addtime");
		val.append("?,?");
		list.add(purchase.getUserid());
		list.add(new Date());
		
		if(purchase.getCoaltype()>0){
			sql.append(", coaltype");
			val.append(",?");
			list.add(purchase.getCoaltype());
		}
		if(UtilHelp.isNotNullStr(purchase.getCoalname())){
			sql.append(", coalname");
			val.append(",?");
			list.add(purchase.getCoalname());
		}
		if(purchase.getCoalsize() > 0){
			sql.append(",coalsize");
			val.append(",?");
			list.add(purchase.getCoalsize());
		}
		if(UtilHelp.isNotNullStr(purchase.getCoalsizename())){
			sql.append(", coalsizename");
			val.append(",?");
			list.add(purchase.getCoalsizename());
		}
		
//		if(UtilHelp.isNotNullStr(purchase.getBuyername())){
//			sql.append(",buyername");
//			val.append(",?");
//			list.add(purchase.getBuyername());
//		}
		if(purchase.getHeating() > 0){
			sql.append(",heating");
			val.append(",?");
			list.add(purchase.getHeating());
		}
		if(purchase.getSulphur().compareTo(UtilHelp.BIGDECIMAL_ZERO) > 0){
			sql.append(",sulphur");
			val.append(",?");
			list.add(purchase.getSulphur());
		}
		if(purchase.getAsh().compareTo(UtilHelp.BIGDECIMAL_ZERO) > 0){ 
			sql.append(",ash");
			val.append(",?");
			list.add(purchase.getAsh());
		}
		if(purchase.getMoisture().compareTo(UtilHelp.BIGDECIMAL_ZERO) > 0){
			sql.append(",moisture");
			val.append(",?");
			list.add(purchase.getMoisture());
		}
		/*if(purchase.getPrice().compareTo(UtilHelp.BIGDECIMAL_ZERO) > 0){
			sql.append(",price");
			val.append(",?");
			list.add(purchase.getPrice());
		}
		if(purchase.getTaxprice().compareTo(UtilHelp.BIGDECIMAL_ZERO) > 0){
			sql.append(",taxprice");
			val.append(",?");
			list.add(purchase.getTaxprice());
		}
		if(null != purchase.getTransportype()){
			sql.append(",transportype");
			val.append(",?");
			list.add(purchase.getTransportype());
		}*/
		
		if(purchase.getPlaceid() > 0){
			sql.append(",placeid");
			val.append(",?");
			list.add(purchase.getPlaceid());
		}
		if(UtilHelp.isNotNullStr(purchase.getPlace())){
			sql.append(",place");
			val.append(",?");
			list.add(purchase.getPlace());
		}
		if(UtilHelp.isNotNullStr(purchase.getStartshortname())){
			sql.append(",startshortname");
			val.append(",?");
			list.add(purchase.getStartshortname());
		}
		if(purchase.getStartcountyid() > 0){
			sql.append(",startcountyid");
			val.append(",?");
			list.add(purchase.getStartcountyid());
		}
		if(UtilHelp.isNotNullStr(purchase.getStartcountyname())){
			sql.append(",startcountyname");
			val.append(",?");
			list.add(purchase.getStartcountyname());
		}
		if(purchase.getStartcityid() > 0){
			sql.append(",startcityid");
			val.append(",?");
			list.add(purchase.getStartcityid());
		}
		if(UtilHelp.isNotNullStr(purchase.getStartcityname())){
			sql.append(",startcityname");
			val.append(",?");
			list.add(purchase.getStartcityname());
		}
		if(purchase.getStartprvid() > 0){
			sql.append(",startprvid");
			val.append(",?");
			list.add(purchase.getStartprvid());
		}
		if(UtilHelp.isNotNullStr(purchase.getStartprvname())){
			sql.append(",startprvname");
			val.append(",?");
			list.add(purchase.getStartprvname());
		}
		//
		if(purchase.getReceiptplaceid() > 0){
			sql.append(",receiptplaceid");
			val.append(",?");
			list.add(purchase.getReceiptplaceid());
		}
		if(UtilHelp.isNotNullStr(purchase.getReceiptplace())){
			sql.append(",receiptplace");
			val.append(",?");
			list.add(purchase.getReceiptplace());
		}
		if(UtilHelp.isNotNullStr(purchase.getStopshortname())){
			sql.append(",stopshortname");
			val.append(",?");
			list.add(purchase.getStopshortname());
		}
		if(purchase.getStopcityid() > 0){
			sql.append(",stopcityid");
			val.append(",?");
			list.add(purchase.getStopcityid());
		}
		if(UtilHelp.isNotNullStr(purchase.getStopcityname())){
			sql.append(",stopcityname");
			val.append(",?");
			list.add(purchase.getStopcityname());
		}
		if(purchase.getStopprvid() > 0){
			sql.append(",stopprvid");
			val.append(",?");
			list.add(purchase.getStopprvid());
		}
		if(UtilHelp.isNotNullStr(purchase.getStopprvname())){
			sql.append(",stopprvname");
			val.append(",?");
			list.add(purchase.getStopprvname());
		}
		
		if(UtilHelp.isNotNullStr(purchase.getValiddate())){
			sql.append(",validdate");
			val.append(",?");
			list.add(purchase.getValiddate());
		}
		if(purchase.getQuantity() > 0){
			sql.append(",quantity");
			val.append(",?");
			list.add(purchase.getQuantity());
		}
		
		sql.append(",sortnumber");
		val.append(",?");
		list.add(purchase.getSortnumber());
		
		sql.append(",status");
		val.append(",?");
		list.add(purchase.getStatus());
		
		if(UtilHelp.isNotNullStr(purchase.getPhone())){
			sql.append(",phone ");
			val.append(",?");
			list.add(purchase.getPhone());
		}
		sql.append(")");
		val.append(")");
		sql.append(val);
		
		return super.addRTID(sql.toString(), list.toArray(), tableName);
	}

	@Override
	public QueryResult<Purchase> searchPurchases(int userid, int page,
			int pageSize, LinkedHashMap<String, String> orders) throws DataManagerException {
		/**
		 * purid, userid, addtime, coaltype, coalname, buyername, heating, coalsize, sulphur, ash, moisture,
		 * price, taxprice, transportype, place, receiptplace, validdate, quantity, sortnumber, status, phone
		 */
		String tableName = TableRules.getPurchaseRule();
		String userTable = TableRules.getUserInfoRule();
		StringBuilder sql = new StringBuilder(
		"select u.companyname,u.realname,u.phone as uphone,p.* from ");
		sql.append(tableName).append(" p,").append(userTable).append(" u where 1=1  and p.validstatus=0 ");
		sql.append(" and p.userid=u.id and p.userid=?");//order by addtime desc 
		return super.search(sql.toString(), purchaseRowMapper, tableName, page, pageSize, new Object[]{userid}, orders);
	}

	@Override
	public int delPurchase(int purid) {
		String tableName = TableRules.getPurchaseRule();
		StringBuilder sql = new StringBuilder("delete from ");
		sql.append(tableName).append(" where purid=? ");
		return super.deleteById(sql.toString(), new Object[]{purid}, tableName);
	}

	@Override
	public int updatePurchaseValiddate(int purid, String validdate) {
		String tableName = TableRules.getPurchaseRule();
		StringBuilder sql = new StringBuilder("update ").append(tableName);
		sql.append(" set validdate=? ").append(" where purid=? ");
		return super.update(sql.toString(), new Object[]{validdate, purid}, tableName);
	}

	@Override
	public int updatePurchase(Purchase purchase) {
		String tableName = TableRules.getPurchaseRule();
		StringBuilder sql = new StringBuilder("update ").append(tableName);
		sql.append(" set heating=?,sulphur=?,ash=?,moisture=?,quantity=?,validdate=? ")
			.append(" where purid=? ");
		return super.update(sql.toString(), new Object[] {
				purchase.getHeating(), purchase.getSulphur(),
				purchase.getAsh(), purchase.getMoisture(),
				purchase.getQuantity(), purchase.getValiddate(),purchase.getPurid() }, tableName);
	}

	private static RowMapper<Purchase> purchaseRowMapper = new RowMapper<Purchase>(){

		@Override
		public Purchase mapRow(ResultSet arg0, int arg1) throws SQLException {
		
			Purchase purchase = new Purchase();
			purchase.setPurid(arg0.getInt("purid"));
			purchase.setUserid(arg0.getInt("userid"));
			purchase.setAddtime(arg0.getDate("addtime").toString());
			purchase.setCoaltype(arg0.getInt("coaltype"));
			purchase.setCoalname(arg0.getString("coalname"));
			purchase.setCompany(arg0.getString("companyname"));
//			purchase.setBuyername(arg0.getString("buyername"));
			purchase.setBuyername(arg0.getString("realname"));
			purchase.setHeating(arg0.getInt("heating"));
			purchase.setCoalsize(arg0.getInt("coalsize"));
			purchase.setSulphur(arg0.getBigDecimal("sulphur"));
			purchase.setAsh(arg0.getBigDecimal("ash"));
			purchase.setMoisture(arg0.getBigDecimal("moisture"));
			purchase.setPrice(arg0.getBigDecimal("price"));
			purchase.setTaxprice(arg0.getBigDecimal("taxprice"));
			purchase.setTransportype(arg0.getInt("transportype"));
			purchase.setPlace(arg0.getString("place"));
			purchase.setReceiptplace(arg0.getString("receiptplace"));
			purchase.setValiddate(arg0.getDate("validdate").toString());
//			purchase.setValiddate(String.valueOf(UtilHelp.getDayOffset(new Date(), arg0.getDate("validdate"))));
			purchase.setQuantity(arg0.getInt("quantity"));
//			purchase.setPhone(arg0.getString("phone"));
			purchase.setPhone(arg0.getString("uphone"));
			if(UtilHelp.isNullStr(purchase.getBuyername())){
				purchase.setBuyername(purchase.getPhone());
			}
//			purchase.setCoalsizename(ConfigUtil.coalSizeNameMap.get(purchase.getCoalsize()));
			purchase.setCoalsizename(arg0.getString("coalsizename"));
			purchase.setPlaceid(arg0.getInt("placeid"));
			purchase.setStartcountyid(arg0.getInt("startcountyid"));
			purchase.setStartcountyname(arg0.getString("startcountyname"));
			purchase.setStartcityid(arg0.getInt("startcityid"));
			purchase.setStartcityname(arg0.getString("startcityname"));
			purchase.setStartprvid(arg0.getInt("startprvid"));
			purchase.setStartprvname(arg0.getString("startprvname"));
			purchase.setStartshortname(arg0.getString("startshortname"));
			purchase.setReceiptplaceid(arg0.getInt("receiptplaceid"));
			purchase.setStopcityid(arg0.getInt("stopcityid"));
			purchase.setStopcityname(arg0.getString("stopcityname"));
			purchase.setStopprvid(arg0.getInt("stopprvid"));
			purchase.setStopprvname(arg0.getString("stopprvname"));
			purchase.setStopshortname(arg0.getString("stopshortname"));
			purchase.setSortnumber(arg0.getInt("sortnumber"));
			return purchase;
		}
		
	};
}
