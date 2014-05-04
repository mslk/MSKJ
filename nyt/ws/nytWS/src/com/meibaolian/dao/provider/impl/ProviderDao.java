package com.meibaolian.dao.provider.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.dao.base.impl.BaseDao;
import com.meibaolian.dao.provider.IProviderDao;
import com.meibaolian.entity.Provider;
import com.meibaolian.util.ConfigUtil;
import com.meibaolian.util.UtilHelp;
import com.meibaolian.util.exception.DataManagerException;
import com.meibaolian.util.tablehash.TableRules;

public class ProviderDao extends BaseDao<Provider> implements IProviderDao{

	@Override
	public int addProvider(Provider provider) {
		/**
		 * insert into provider (userid, addtime, coaltype, coalname, buyername,
		 *  heating, coalsize, sulphur, ash, moisture, price, taxprice, transportype, sendoutplace, place, 
		 *  validdate, quantity, sortnumber, status, phone) values(?,...,?)
		 */
		String tableName = TableRules.getProviderRule();
		
		StringBuilder sql = new StringBuilder("insert into ");
		StringBuilder val = new StringBuilder(" values(");
		List<Object> list = new ArrayList<Object>();
		
		sql.append(tableName).append(" (userid, addtime");
		val.append("?,?");
		list.add(provider.getUserid());
		list.add(new Date());
		
		if(provider.getCoaltype()>0){
			sql.append(", coaltype");
			val.append(",?");
			list.add(provider.getCoaltype());
		}
		if(UtilHelp.isNotNullStr(provider.getCoalname())){
			sql.append(", coalname");
			val.append(",?");
			list.add(provider.getCoalname());
		}
		if(provider.getCoalsize() > 0){
			sql.append(",coalsize");
			val.append(",?");
			list.add(provider.getCoalsize());
		}
		if(UtilHelp.isNotNullStr(provider.getCoalsizename())){
			sql.append(", coalsizename");
			val.append(",?");
			list.add(provider.getCoalsizename());
		}
		if(UtilHelp.isNotNullStr(provider.getBuyername())){
			sql.append(",buyername");
			val.append(",?");
			list.add(provider.getBuyername());
		}
		if(provider.getHeating() > 0){
			sql.append(",heating");
			val.append(",?");
			list.add(provider.getHeating());
		}
		if(provider.getSulphur().compareTo(UtilHelp.BIGDECIMAL_ZERO) > 0){
			sql.append(",sulphur");
			val.append(",?");
			list.add(provider.getSulphur());
		}
		if(provider.getAsh().compareTo(UtilHelp.BIGDECIMAL_ZERO) > 0){ 
			sql.append(",ash");
			val.append(",?");
			list.add(provider.getAsh());
		}
		if(provider.getMoisture().compareTo(UtilHelp.BIGDECIMAL_ZERO) > 0){
			sql.append(",moisture");
			val.append(",?");
			list.add(provider.getMoisture());
		}
		if(provider.getPrice().compareTo(UtilHelp.BIGDECIMAL_ZERO) > 0){
			sql.append(",price");
			val.append(",?");
			list.add(provider.getPrice());
		}
		if(provider.getTaxprice().compareTo(UtilHelp.BIGDECIMAL_ZERO) > 0){
			sql.append(",taxprice");
			val.append(",?");
			list.add(provider.getTaxprice());
		}
		/*if(null != provider.getTransportype()){
			sql.append(",transportype");
			val.append(",?");
			list.add(provider.getTransportype());
		}*/
		/*sql.append(",transportype");
		val.append(",?");
		list.add(provider.getTransportype());
		
		sql.append(",sendoutplace");
		val.append(",?");
		list.add(provider.getSendoutplace());
		*/
		if(provider.getPlaceid() > 0){
			sql.append(",placeid");
			val.append(",?");
			list.add(provider.getPlaceid());
		}
		if(UtilHelp.isNotNullStr(provider.getPlace())){
			sql.append(",place");
			val.append(",?");
			list.add(provider.getPlace());
		}
		if(UtilHelp.isNotNullStr(provider.getStartshortname())){
			sql.append(",startshortname");
			val.append(",?");
			list.add(provider.getStartshortname());
		}
		if(provider.getStartcountyid() > 0){
			sql.append(",startcountyid");
			val.append(",?");
			list.add(provider.getStartcountyid());
		}
		if(UtilHelp.isNotNullStr(provider.getStartcountyname())){
			sql.append(",startcountyname");
			val.append(",?");
			list.add(provider.getStartcountyname());
		}
		if(provider.getStartcityid() > 0){
			sql.append(",startcityid");
			val.append(",?");
			list.add(provider.getStartcityid());
		}
		if(UtilHelp.isNotNullStr(provider.getStartcityname())){
			sql.append(",startcityname");
			val.append(",?");
			list.add(provider.getStartcityname());
		}
		if(provider.getStartprvid() > 0){
			sql.append(",startprvid");
			val.append(",?");
			list.add(provider.getStartprvid());
		}
		if(UtilHelp.isNotNullStr(provider.getStartprvname())){
			sql.append(",startprvname");
			val.append(",?");
			list.add(provider.getStartprvname());
		}
		if(UtilHelp.isNotNullStr(provider.getValiddate())){
			sql.append(",validdate");
			val.append(",?");
			list.add(provider.getValiddate());
		}
		if(provider.getQuantity() > 0){
			sql.append(",quantity");
			val.append(",?");
			list.add(provider.getQuantity());
		}
		
		sql.append(",sortnumber");
		val.append(",?");
		list.add(provider.getSortnumber());
		
		sql.append(",status");
		val.append(",?");
		list.add(provider.getStatus());
		
		if(UtilHelp.isNotNullStr(provider.getPhone())){
			sql.append(",phone ");
			val.append(",?");
			list.add(provider.getPhone());
		}
		sql.append(")");
		val.append(")");
		sql.append(val);
		
		return super.addRTID(sql.toString(), list.toArray(), tableName);
	}


	@Override
	public QueryResult<Provider> searchProviders(int userid, int page,
			int pageSize, LinkedHashMap<String, String> orders) throws DataManagerException {
		/**
		 * proid, userid, addtime, coaltype, coalname, buyername, heating, coalsize, sulphur, ash, moisture, 
		 * price, taxprice, transportype, sendoutplace, place, validdate, quantity, sortnumber, status, phone
		 */
		String tableName = TableRules.getProviderRule();
		String userTable = TableRules.getUserInfoRule();
		StringBuilder sql = new StringBuilder(
		"select u.companyname,u.realname,u.phone as uphone,p.* from ");
		sql.append(tableName).append(" p,").append(userTable).append(" u where 1=1 and p.validstatus=0 ");
		sql.append(" and p.userid=u.id and p.userid=?");//order by addtime desc 
		return super.search(sql.toString(), providerRowMapper, tableName, page, pageSize, new Object[]{userid}, orders);
	}
	
	
	@Override
	public int delProvider(int proid) {
		String tableName = TableRules.getProviderRule();
		StringBuilder sql = new StringBuilder("delete from ");
		sql.append(tableName).append(" where proid=? ");
		return super.deleteById(sql.toString(), new Object[]{proid}, tableName);
	}

	@Override
	public int updateProviderValiddate(int proid, String validdate) {
		String tableName = TableRules.getProviderRule();
		StringBuilder sql = new StringBuilder("update ").append(tableName);
		sql.append(" set validdate=? ").append(" where proid=? ");
		return super.update(sql.toString(), new Object[]{validdate, proid}, tableName);
	}
	
	@Override
	public int updateProvider(Provider provider) {
		String tableName = TableRules.getProviderRule();
		StringBuilder sql = new StringBuilder("update ").append(tableName);
		sql.append(" set heating=?,sulphur=?,ash=?,moisture=?,price=?,taxprice=?,quantity=?,validdate=? ")
		   .append(" where proid=? ");
		return super.update(sql.toString(), new Object[] {
				provider.getHeating(), provider.getSulphur(),
				provider.getAsh(), provider.getMoisture(), provider.getPrice(),
				provider.getTaxprice(), provider.getQuantity(),
				provider.getValiddate(), provider.getProid() }, tableName);
	}

	private static RowMapper<Provider> providerRowMapper = new RowMapper<Provider>(){

		@Override
		public Provider mapRow(ResultSet arg0, int arg1) throws SQLException {
			
			Provider provider = new Provider();
			provider.setProid(arg0.getInt("proid"));
			provider.setUserid(arg0.getInt("userid"));
			provider.setAddtime(arg0.getDate("addtime").toString());
			provider.setCoaltype(arg0.getInt("coaltype"));
			provider.setCoalname(arg0.getString("coalname"));
//			provider.setBuyername(arg0.getString("buyername"));
			provider.setBuyername(arg0.getString("realname"));
			provider.setCompany(arg0.getString("companyname"));
			provider.setHeating(arg0.getInt("heating"));
			provider.setCoalsize(arg0.getInt("coalsize"));
			provider.setSulphur(arg0.getBigDecimal("sulphur"));
			provider.setAsh(arg0.getBigDecimal("ash"));
			provider.setMoisture(arg0.getBigDecimal("moisture"));
			provider.setPrice(arg0.getBigDecimal("price"));
			provider.setTaxprice(arg0.getBigDecimal("taxprice"));
			provider.setTransportype(arg0.getInt("transportype"));
			provider.setSendoutplace(arg0.getString("sendoutplace"));
			provider.setPlace(arg0.getString("place"));
			provider.setValiddate(arg0.getDate("validdate").toString());
//			provider.setValiddate(String.valueOf(UtilHelp.getDayOffset(new Date(), arg0.getDate("validdate"))));
			provider.setQuantity(arg0.getInt("quantity"));
//			provider.setPhone(arg0.getString("phone"));
			provider.setPhone(arg0.getString("uphone"));
			if(UtilHelp.isNullStr(provider.getBuyername())){
				provider.setBuyername(provider.getPhone());
			}
//			provider.setCoalsizename(ConfigUtil.coalSizeNameMap.get(provider.getCoalsize()));
			provider.setCoalsizename(arg0.getString("coalsizename"));
			provider.setPlaceid(arg0.getInt("placeid"));
			provider.setStartcountyid(arg0.getInt("startcountyid"));
			provider.setStartcountyname(arg0.getString("startcountyname"));
			provider.setStartcityid(arg0.getInt("startcityid"));
			provider.setStartcityname(arg0.getString("startcityname"));
			provider.setStartprvid(arg0.getInt("startprvid"));
			provider.setStartprvname(arg0.getString("startprvname"));
			provider.setStartshortname(arg0.getString("startshortname"));
			provider.setSortnumber(arg0.getInt("sortnumber"));
			return provider;
		}
		
	};


}
