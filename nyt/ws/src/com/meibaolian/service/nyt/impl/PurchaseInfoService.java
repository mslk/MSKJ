package com.meibaolian.service.nyt.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.dao.nyt.IPurchaseExpandDao;
import com.meibaolian.dao.nyt.IPurchaseInfoDao;
import com.meibaolian.entity.PurchaseInfo;
import com.meibaolian.entity.PurchaseInfoExpand;
import com.meibaolian.entity.SupplyInfo;
import com.meibaolian.service.nyt.IPurchaseInfoService;
import com.meibaolian.util.ConfigUtil;
import com.meibaolian.util.UtilHelp;
import com.meibaolian.util.exception.DataManagerException;
import com.meibaolian.util.exception.NoParameterException;
import com.meibaolian.web.nyt.dto.PurchaseDTo;

public class PurchaseInfoService implements IPurchaseInfoService {
	IPurchaseInfoDao purchaseInfoDao;
	
	IPurchaseExpandDao purchaseExpandDao;

	public void setPurchaseExpandDao(IPurchaseExpandDao purchaseExpandDao) {
		this.purchaseExpandDao = purchaseExpandDao;
	}

	public void setPurchaseInfoDao(IPurchaseInfoDao purchaseInfoDao) {
		this.purchaseInfoDao = purchaseInfoDao;
	}

	@Override
	public int add(PurchaseInfo purchaseInfo) throws NoParameterException 
	{
		
		StringBuilder sql=new StringBuilder(" insert into purchase_info(userid,number,price,valid,type,addtime ");
		
		List<Object> list=new ArrayList<Object>();
		list.add(purchaseInfo.getUserid());
		list.add(purchaseInfo.getNumber());
		list.add(purchaseInfo.getPrice());
		list.add(purchaseInfo.getValid());
		list.add(purchaseInfo.getType());
		list.add(new Date());
		
		if(!"".equals(purchaseInfo.getDescription()))
		{
			sql.append("  ,description ");
			list.add(purchaseInfo.getDescription());
		}
	
		
		if(purchaseInfo.getType()==2 && !"".equals(purchaseInfo.getLength()) && !"".equals(purchaseInfo.getWidth()) && !"".equals(purchaseInfo.getThickness()))
		{
			sql.append(" ,length,width,thickness ");
			list.add(purchaseInfo.getLength());
			list.add(purchaseInfo.getWidth());
			list.add(purchaseInfo.getThickness());
		}
		
		if(purchaseInfo.getType()==3 && !"".equals(purchaseInfo.getCultivated())&& !"".equals(purchaseInfo.getLength())  && !"".equals(purchaseInfo.getTailDirectly()) && purchaseInfo.getUnit()!=null && purchaseInfo.getUnit()>0)
		{
			sql.append(" ,length,cultivated,tail_directly,unit ");
			list.add(purchaseInfo.getLength());
			list.add(purchaseInfo.getCultivated());
			list.add(purchaseInfo.getTailDirectly());
			list.add(purchaseInfo.getUnit());
		}
		
		if(purchaseInfo.getType()==4 && !"".equals(purchaseInfo.getBrand()) && !"".equals(purchaseInfo.getLevel()) && !"".equals(purchaseInfo.getProducer()) )
		{
			sql.append(" ,brand ,level,producer  ");
			list.add(purchaseInfo.getBrand());
			list.add(purchaseInfo.getLevel());
			list.add(purchaseInfo.getProducer());
		}
		
		sql.append(" ) ");
		sql.append(UtilHelp.engenderByParamCount(list.size()));
		return purchaseInfoDao.add(sql.toString(), list.toArray(), "");
	}

	@Override
	public int delete(Integer userid, Integer supplyId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(PurchaseInfo purchaseInfo) {
	StringBuilder sql=new StringBuilder(" update purchase_info set number=?,price=?,valid=?,type=?,description=? ");
		
		List<Object> list=new ArrayList<Object>();
		list.add(purchaseInfo.getNumber());
		list.add(purchaseInfo.getPrice());
		list.add(purchaseInfo.getValid());
		list.add(purchaseInfo.getType());
		list.add(purchaseInfo.getDescription());
		
		if(purchaseInfo.getType()==2)
		{
			sql.append(" ,length=?,width=?,thickness=? ");
			list.add(purchaseInfo.getLength());
			list.add(purchaseInfo.getWidth());
			list.add(purchaseInfo.getThickness());
		}
		
		if(purchaseInfo.getType()==3)
		{
			sql.append(" ,length=?,cultivated=?,tail_directly=?,unit=? ");
			list.add(purchaseInfo.getLength());
			list.add(purchaseInfo.getCultivated());
			list.add(purchaseInfo.getTailDirectly());
			list.add(purchaseInfo.getUnit());
		}
		
		if(purchaseInfo.getType()==4)
		{
			sql.append(" ,brand=? ,level=?,producer=?  ");
			list.add(purchaseInfo.getBrand());
			list.add(purchaseInfo.getLevel());
			list.add(purchaseInfo.getProducer());
		}
		
		sql.append(" where id=?");
		list.add(purchaseInfo.getId()); 
		return purchaseInfoDao.update(sql.toString(), list.toArray(), "");
	}

	@Override
	public QueryResult<PurchaseInfo> search() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QueryResult<PurchaseInfoExpand> search(int page, int pageSize,
			PurchaseDTo dto) throws DataManagerException {
		/**
		 *    select su.*,To_Days(valid)-To_Days(now()) as lastday,us.phone,us.realname,us.companyname,us.place_receipt,us.province
,us.city,us.county,us.park,us.logo
from purchase_info AS su,userinfo as us
where su.userid=us.id and  ( su.valid>=date_format(now(),'%Y-%m-%d')
 or us.level=1  or ( us.level=2  and  date_add(su.valid, interval us.specified_date day)>=date_format(now(),'%Y-%m-%d')) )
		 */
		
		StringBuilder sql=new StringBuilder();
		sql.append("  select su.*,To_Days(valid)-To_Days(now()) as lastday,");
		sql.append("  us.phone,us.realname,us.companyname,us.place_receipt,us.province,us.city,us.county,us.park,us.logo ");
		sql.append(" from purchase_info AS su,userinfo as us ");
		sql.append(" where su.userid=us.id  ");
		sql.append(" and su.type=? ");
		sql.append(" and su.status=0 ");
		sql.append(" and  ( su.valid>=date_format(now(),'%Y-%m-%d') ");
		sql.append(" or us.level=1  or ( us.level=2  and  date_add(su.valid, interval us.specified_date day)>=date_format(now(),'%Y-%m-%d') ) )");
		List<Object> list=new ArrayList<Object>();
		list.add(dto.getType());
		LinkedHashMap<String, String> orders=new LinkedHashMap<String, String>();
		orders.put("orderid", "desc");
		
		if(dto!=null && !"".equals(dto.getKey()))
		{
			sql.append(" and (  su.number like ? ");
			sql.append(" or su.price like ? ");
			sql.append(" or su.description like ? ");
			sql.append(" or us.phone like ? ");
			sql.append(" or us.realname like ? ");
			sql.append(" or us.companyname like ? ");
			sql.append(" or us.place_receipt like ? ");
			list.add(UtilHelp.setSQLLikeStr(dto.getKey()));
			list.add(UtilHelp.setSQLLikeStr(dto.getKey()));
			list.add(UtilHelp.setSQLLikeStr(dto.getKey()));
			list.add(UtilHelp.setSQLLikeStr(dto.getKey()));
			list.add(UtilHelp.setSQLLikeStr(dto.getKey()));
			list.add(UtilHelp.setSQLLikeStr(dto.getKey()));
			list.add(UtilHelp.setSQLLikeStr(dto.getKey()));
			
			sql.append(" or us.phone like ? ");
			sql.append(" or us.realname like ? ");
			sql.append(" or us.companyname like ? ");
			sql.append(" or us.place_receipt like ? ");
			sql.append(" or us.park like ? ");
			list.add(UtilHelp.setSQLLikeStr(dto.getKey()));
			list.add(UtilHelp.setSQLLikeStr(dto.getKey()));
			list.add(UtilHelp.setSQLLikeStr(dto.getKey()));
			list.add(UtilHelp.setSQLLikeStr(dto.getKey()));
			list.add(UtilHelp.setSQLLikeStr(dto.getKey()));

			
			if(dto.getType()==2)
			{
				sql.append(" or su.length like ? ");
				sql.append(" or su.width like ? ");
				sql.append(" or su.thickness like ? ");
				list.add(UtilHelp.setSQLLikeStr(dto.getKey()));
				list.add(UtilHelp.setSQLLikeStr(dto.getKey()));
				list.add(UtilHelp.setSQLLikeStr(dto.getKey()));
			}
			else if(dto.getType()==3)
			{
				sql.append(" or su.cultivated like ? ");
				sql.append(" or su.tail_directly like ? ");
				list.add(UtilHelp.setSQLLikeStr(dto.getKey()));
				list.add(UtilHelp.setSQLLikeStr(dto.getKey()));
			}
			else if(dto.getType()==4)
			{
				sql.append(" or su.brand like ?");
				sql.append(" or su.level like ?");
				sql.append(" or su.producer like ?");
				list.add(UtilHelp.setSQLLikeStr(dto.getKey()));
				list.add(UtilHelp.setSQLLikeStr(dto.getKey()));
				list.add(UtilHelp.setSQLLikeStr(dto.getKey()));
			}
			
			sql.append("  ) "); 
			orders.put(" su.addtime ", " desc ");
			
		}else
		{
			if(dto.getPriceOrder()!=0)
			{
				if(dto.getPriceOrder()==2)
				orders.put(" su.price ", " desc ");
				else
				orders.put(" su.price ", " asc ");
			}
			
			if(dto.getNumOrder()!=0)
			{
				if(dto.getNumOrder()==2)
				orders.put(" su.number ", " desc ");
				else
				orders.put(" su.number ", " asc ");
			}
			
			
			if(dto.getType()==2)
			{
				if(!"".equals(dto.getLength()))
				{
					sql.append(" and su.length=? ");
					list.add(dto.getLength());
				}
				
				if(!"".equals(dto.getWidth()))
				{
				sql.append(" and su.width=? ");
				list.add(dto.getWidth());
				}
				if(!"".equals(dto.getThickness()))
				{
				sql.append(" and su.thickness =? ");
				list.add(dto.getThickness());
				}
			}
			else if(dto.getType()==3)
			{
				if(!"".equals(dto.getCultivated()))
				{
				sql.append(" and su.cultivated= ? ");
				list.add(dto.getCultivated());
				}
				
				if(!"".equals(dto.getLength()))
				{
					sql.append(" and su.length=? ");
					list.add(dto.getLength());
				}
				
				if(!"".equals(dto.getTail_directly()))
				{
				sql.append(" and su.tail_directly=? ");
				list.add(dto.getTail_directly());
				}
			}
			else if(dto.getType()==4)
			{
				if(!"".equals(dto.getBrand()))
				{
				sql.append(" and su.brand =? ");
				list.add(dto.getBrand());
				}
				if(dto.getLevel()>0)
				{
				sql.append(" and su.level = ? ");
				list.add(dto.getLevel());
				}
//				if(!"".equals(dto.g)))
//				{
//				sql.append(" and su.producer = ? ");
//				}
				
			}
			
		}
		
		
		return purchaseExpandDao.search(sql.toString(), expandRow, "",page,pageSize, list.toArray(), orders);
	}

	public RowMapper<PurchaseInfoExpand> expandRow=new RowMapper<PurchaseInfoExpand>() {
		
		@Override
		public PurchaseInfoExpand mapRow(ResultSet result, int arg1)
				throws SQLException {
			PurchaseInfoExpand expand=new PurchaseInfoExpand();

			expand.setId(result.getInt("id"));
			expand.setUserid(result.getInt("userid"));
			expand.setType(result.getInt("type"));
			expand.setPrice(result.getInt("price"));
			expand.setNumber(result.getInt("number"));
			String logo=UtilHelp.strNotNull(result.getString("logo"));
			expand.setLogo("".equals(logo)?"":ConfigUtil.IMAGEPREFIX+logo);
			int a=result.getInt("lastday");
			if(a>0)
			{
			    expand.setValid("剩余" +a+"天");
			}else
			{
				
				expand.setValid("已过期" +Math.abs(a)+"天");
			}
			expand.setDescription(result.getString("description"));
			
			expand.setAddtime(UtilHelp.dateBefore(result.getDate("addtime")));
			
			expand.setLength(result.getString("length"));
			expand.setWidth(result.getString("width"));
			expand.setThickness(result.getString("thickness"));
			
			expand.setCultivated(result.getString("cultivated"));
			expand.setTailDirectly(result.getString("tail_directly"));
			expand.setUnit(result.getInt("unit"));
			
			expand.setBrand(result.getString("brand"));
			expand.setLevel(result.getInt("level"));
			expand.setProducer(result.getString("producer"));
			
//			us.phone,us.realname,us.companyname,us.place_receipt,us.province,us.city,us.county,us.park
			expand.setPhone(result.getString("phone"));
			expand.setRealname(result.getString("realname"));
			expand.setCompanyname(result.getString("companyname"));
			expand.setPlace_receipt(result.getString("place_receipt"));
			expand.setProvince(result.getString("province"));
			expand.setCity(result.getString("city"));
			expand.setCounty(result.getString("county"));
			expand.setPark(result.getString("park"));

			return expand;
		}
	};

public RowMapper<PurchaseInfo> row=new RowMapper<PurchaseInfo>() {
		
		@Override
		public PurchaseInfo mapRow(ResultSet result, int arg1)
				throws SQLException {
			PurchaseInfo expand=new PurchaseInfo();
			expand.setId(result.getInt("id"));
			expand.setUserid(result.getInt("userid"));
			expand.setType(result.getInt("type"));
			expand.setPrice(result.getInt("price"));
			expand.setNumber(result.getInt("number"));
			expand.setAddtime(result.getString("addtime"));
			expand.setDescription(result.getString("description"));
			
			expand.setLength(result.getString("length"));
			expand.setWidth(result.getString("width"));
			expand.setThickness(result.getString("thickness"));
			expand.setCultivated(result.getString("cultivated"));
			expand.setTailDirectly(result.getString("tail_directly"));
			expand.setUnit(result.getInt("unit"));
			
			expand.setBrand(result.getString("brand"));
			expand.setLevel(result.getInt("level"));
			expand.setProducer(result.getString("producer"));
			

			return expand;
		}
	};


	@Override
	public QueryResult<PurchaseInfo> search(int page, int pageSize, int userid,int type)
			throws DataManagerException {
		String sql=" select id,userid,length,width,thickness,number,price,valid ,description,cultivated,tail_directly ,unit,brand ,level,producer ,type,addtime "
				+ " from purchase_info where userid=? and type=?  order by addtime desc ";
		return purchaseInfoDao.search(sql, row, "", page, pageSize, new Object[]{userid,type});
	}

//	@Override
//	public PurchaseInfo getById(int id) throws DataManagerException {
//		String sql=" select id,userid,length,width,thickness,number,price,valid ,description,cultivated,tail_directly ,unit,brand ,level,producer ,type,addtime from purchase_info where id=? ";
//		return purchaseInfoDao.getById(sql,new Object[]{id},null, row);   
//	}
	
	@Override
	public List<PurchaseInfo> searchByIds(int[] ids)
			throws DataManagerException {
		StringBuffer sql = new StringBuffer();
	 	sql.append(" select id,userid,length,width,thickness,number,price,valid ,description,cultivated,tail_directly ,unit,brand ,level,producer ,type,addtime from purchase_info where id in( ");
		for (int i : ids) {
			sql.append(i).append(",");
		}
		String _sql = sql.substring(0, sql.length()-1);
		_sql +=")";
		return purchaseInfoDao.searchList(_sql, row, "", new Object[]{});
	}
	
}
