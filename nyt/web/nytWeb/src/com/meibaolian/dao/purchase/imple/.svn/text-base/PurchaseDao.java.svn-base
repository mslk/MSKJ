package com.meibaolian.dao.purchase.imple;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import com.meibaolian.dao.base.IReader;
import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.dao.base.imple.BaseDao;
import com.meibaolian.dao.purchase.IPurchaseDao;
import com.meibaolian.dto.PurchaseDto;
import com.meibaolian.entity.Purchase;
import com.meibaolian.entity.PurchaseInfo;
import com.meibaolian.util.ConfigUtil;
import com.meibaolian.util.UtilHelp;

public class PurchaseDao extends BaseDao<Purchase> implements IPurchaseDao {
	@Override
	public QueryResult<Purchase> searchList(PurchaseDto purchaseDto, int page,
			int pageSize, LinkedHashMap<String, String> orders) {
		//,u.companyname,u.realname,u.phone as uphone
		String sql = "select p.purid,p.userid,p.coaltype,p.transportype,p.validdate,p.sortnumber,p.quantity,p.coalname,p.coalsize,u.companyname,u.realname,u.phone,p.coalsizename,p.heating,p.sulphur,p.ash,p.moisture,p.validstatus from purchase p,userinfo u ";
		String sqlCount = "select count(1) from purchase p,userinfo u ";
		StringBuilder where = new StringBuilder(" and p.userid=u.id ");
		List<Object> params = new ArrayList<Object>(); 
		
		/*if(null != purchaseDto.getCoaltype() && purchaseDto.getCoaltype() > 0){
			where.append(" and p.coaltype=? ");
			params.add(purchaseDto.getCoaltype());
		}*/
		if(UtilHelp.isNotNullStr(purchaseDto.getCoalname())){
			where.append(" and ( p.coalname like ?)");
			String keyword =  UtilHelp.setSQLLikeStr(purchaseDto.getCoalname());
			params.add(keyword);
		}
		if(UtilHelp.isNotNullStr(purchaseDto.getCoalsizename())){
			where.append(" and ( p.coalsizename like ?)");
			params.add(UtilHelp.setSQLLikeStr(purchaseDto.getCoalsizename()));
		}
		/*if(null != purchaseDto.getTransportype() && purchaseDto.getTransportype() >-1){
			where.append(" and p.transportype=? ");
			params.add(purchaseDto.getTransportype());
		}*/
		if(null != purchaseDto.getMinheating() && purchaseDto.getMinheating() > 0){
			where.append(" and ( p.heating >= ?)");
			params.add(purchaseDto.getMinheating());
		}
		if(null != purchaseDto.getMaxheating() && purchaseDto.getMaxheating() > 0){
			where.append(" and ( p.heating <= ?)");
			params.add(purchaseDto.getMaxheating());
		}
		if(null != purchaseDto.getSulphur() && purchaseDto.getSulphur() > 0){
			where.append(" and ( p.sulphur <= ?)");
			params.add(purchaseDto.getSulphur());
		}
		if(null != purchaseDto.getAsh() && purchaseDto.getAsh() > 0){
			where.append(" and ( p.ash <= ?)");
			params.add(purchaseDto.getAsh());
		}
		if(null != purchaseDto.getMoisture() && purchaseDto.getMoisture() > 0){
			where.append(" and ( p.moisture <= ?)");
			params.add(purchaseDto.getMoisture());
		}
		if(UtilHelp.isNotNullStr(purchaseDto.getKeyword())){
			String keyword = UtilHelp.setSQLLikeStr(purchaseDto.getKeyword());
			where.append(" and ( u.realname like ? or u.phone like ?)");
			params.add(keyword);
			params.add(keyword);
		}
		if(UtilHelp.isNotNullStr(purchaseDto.getBegindate())){
			where.append(" and p.validdate >= ? ");
			params.add(UtilHelp.setValiddateTime(purchaseDto.getBegindate()));
		}
		if(UtilHelp.isNotNullStr(purchaseDto.getEnddate())){
			where.append(" and p.validdate <= ? ");
			params.add(UtilHelp.setValiddateTime(purchaseDto.getEnddate()));
		}
		if(null != purchaseDto.getStatus() && purchaseDto.getStatus() > -1){
			where.append(" and p.validstatus = ? ");
			params.add(purchaseDto.getStatus());
		}
		return super.searchSQLByParamter(sql, sqlCount, page, pageSize, where.toString(), params.toArray(), orders, listPurchaseReader);
	}
	
	private IReader<Purchase> listPurchaseReader = new IReader<Purchase>(){

		@Override
		public Purchase readerByList(Object[] objs) {
			//p.purid,p.userid,p.coaltype,p.transportype,p.validdate,p.sortnumber,p.quantity,p.coalname,u.companyname,u.realname,u.phone as uphone
			Purchase purchase = new Purchase();
			purchase.setPurid((Integer)objs[0]);
			purchase.setUserid((Integer)objs[1]);
			purchase.setCoaltype((Integer)objs[2]);
			purchase.setTransportype((Integer)objs[3]);
			purchase.setValiddate((Timestamp)objs[4]);
			purchase.setSortnumber((Integer)objs[5]);
			purchase.setQuantity((Integer)objs[6]);
			purchase.setCoalname((String)objs[7]);
			purchase.setCoalsize((Integer)objs[8]);
			purchase.setCompany((String)objs[9]);
			purchase.setBuyername((String)objs[10]);
			purchase.setPhone((String)objs[11]);
			purchase.setCoalsizename((String)objs[12]);
			purchase.setHeating((Integer)objs[13]);
			purchase.setSulphur(String.valueOf(objs[14]));
			purchase.setAsh(String.valueOf(objs[15]));
			purchase.setMoisture(String.valueOf(objs[16]));
			purchase.setValidstatus((Integer)objs[17]);
			return purchase;
		}};
}
