package com.meibaolian.dao.purchase.imple;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import com.meibaolian.dao.base.IReader;
import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.dao.base.imple.BaseDao;
import com.meibaolian.dao.purchase.IPurchaseInfoDao;
import com.meibaolian.dto.PurchaseDto;
import com.meibaolian.entity.PurchaseInfo;
import com.meibaolian.util.ConfigUtil;
import com.meibaolian.util.UtilHelp;

public class PurchaseInfoDao extends BaseDao<PurchaseInfo> implements IPurchaseInfoDao {

	@Override
	public QueryResult<PurchaseInfo> searchList(PurchaseDto purchaseDto, int page,
			int pageSize, LinkedHashMap<String, String> orders) {
		//,u.companyname,u.realname,u.phone as uphone
		String sql = "select p.purid,p.userid,p.coaltype,p.transportype,p.validdate,p.sortnumber,p.quantity,p.coalname,p.coalsize,u.companyname,u.realname,u.phone from purchase p,userinfo u ";
		String sqlCount = "select count(1) from purchase p,userinfo u ";
		StringBuilder where = new StringBuilder(" and p.userid=u.id ");
		List<Object> params = new ArrayList<Object>(); 
		
		if(null != purchaseDto.getCoaltype() && purchaseDto.getCoaltype() > 0){
			where.append(" and p.coaltype=? ");
			params.add(purchaseDto.getCoaltype());
		}
		/*if(null != purchaseDto.getTransportype() && purchaseDto.getTransportype() >-1){
			where.append(" and p.transportype=? ");
			params.add(purchaseDto.getTransportype());
		}*/
		if(UtilHelp.isNotNullStr(purchaseDto.getKeyword())){
			String keyword = UtilHelp.setSQLLikeStr(purchaseDto.getKeyword());
			where.append(" and ( u.realname like ? or u.phone like ?)");
			params.add(keyword);
			params.add(keyword);
		}
		if(null != purchaseDto.getBegindate()){
			where.append(" and p.validdate > ? ");
			params.add(purchaseDto.getBegindate());
		}
		if(null != purchaseDto.getEnddate()){
			where.append(" and p.validdate < ? ");
			params.add(purchaseDto.getEnddate());
		}
		
		return super.searchSQLByParamter(sql, sqlCount, page, pageSize, where.toString(), params.toArray(), orders, listPurchaseInfoReader);
	}
	
	private IReader<PurchaseInfo> listPurchaseInfoReader = new IReader<PurchaseInfo>(){

		@Override
		public PurchaseInfo readerByList(Object[] objs) {
			//p.purid,p.userid,p.coaltype,p.transportype,p.validdate,p.sortnumber,p.quantity,p.coalname,u.companyname,u.realname,u.phone as uphone
			PurchaseInfo purchaseInfo = new PurchaseInfo();
			purchaseInfo.setPurid((Integer)objs[0]);
			purchaseInfo.setUserid((Integer)objs[1]);
			purchaseInfo.setCoaltype((Integer)objs[2]);
			purchaseInfo.setTransportype((Integer)objs[3]);
			purchaseInfo.setValiddate((Timestamp)objs[4]);
			purchaseInfo.setSortnumber((Integer)objs[5]);
			purchaseInfo.setQuantity((Integer)objs[6]);
			purchaseInfo.setCoalname((String)objs[7]);
			purchaseInfo.setCoalsize((Integer)objs[8]);
//			purchaseInfo.setCoalsizename(ConfigUtil.coalSizeNameMap.get(purchaseInfo.getCoalsize()));
			purchaseInfo.setCompany((String)objs[9]);
			purchaseInfo.setBuyername((String)objs[10]);
			purchaseInfo.setPhone((String)objs[11]);
			return purchaseInfo;
		}};

}
