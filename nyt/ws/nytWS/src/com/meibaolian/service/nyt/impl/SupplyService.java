package com.meibaolian.service.nyt.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.dao.nyt.ISupplyDao;
import com.meibaolian.dao.nyt.ISupplyExpandDao;
import com.meibaolian.entity.SupplyInfo;
import com.meibaolian.entity.SupplyInfoExpand;
import com.meibaolian.service.nyt.ISupplyService;
import com.meibaolian.util.ConfigUtil;
import com.meibaolian.util.UtilHelp;
import com.meibaolian.util.exception.DataManagerException;
import com.meibaolian.util.exception.NoParameterException;
import com.meibaolian.web.nyt.dto.SupplyDTo;

public class SupplyService implements ISupplyService {

	
	ISupplyDao supplyDao;
	
	ISupplyExpandDao supplyExpandDao;
	
	public void setSupplyDao(ISupplyDao supplyDao) {
		this.supplyDao = supplyDao;
	}

	public void setSupplyExpandDao(ISupplyExpandDao supplyExpandDao) {
		this.supplyExpandDao = supplyExpandDao;
	}



	@Override
	public int add(SupplyInfo supplyInfo) throws NoParameterException 
	{
		
		StringBuilder sql=new StringBuilder(" insert into supply_info(userid,number,price,valid,type,addtime ");
		
		List<Object> list=new ArrayList<Object>();
		list.add(supplyInfo.getUserid());
		list.add(supplyInfo.getNumber());
		list.add(supplyInfo.getPrice());
		list.add(supplyInfo.getValid());
		list.add(supplyInfo.getType());
		list.add(new Date());
		
		if(!"".equals(supplyInfo.getDescription()))
		{
			sql.append("  ,description ");
			list.add(supplyInfo.getDescription());
		}
	
		
		if(supplyInfo.getType()==2 && !"".equals(supplyInfo.getLength()) && !"".equals(supplyInfo.getWidth()) && !"".equals(supplyInfo.getThickness()))
		{
			sql.append(" ,length,width,thickness ");
			list.add(supplyInfo.getLength());
			list.add(supplyInfo.getWidth());
			list.add(supplyInfo.getThickness());
		}
		
		if(supplyInfo.getType()==3 && !"".equals(supplyInfo.getCultivated())&& !"".equals(supplyInfo.getLength())  && !"".equals(supplyInfo.getTailDirectly()) && supplyInfo.getUnit()!=null && supplyInfo.getUnit()>0)
		{
			sql.append(" ,length,cultivated,tail_directly,unit ");
			list.add(supplyInfo.getLength());
			list.add(supplyInfo.getCultivated());
			list.add(supplyInfo.getTailDirectly());
			list.add(supplyInfo.getUnit());
		}
		
		if(supplyInfo.getType()==4 && !"".equals(supplyInfo.getBrand()) && !"".equals(supplyInfo.getLevel()) && !"".equals(supplyInfo.getProducer()) )
		{
			sql.append(" ,brand ,level,producer  ");
			list.add(supplyInfo.getBrand());
			list.add(supplyInfo.getLevel());
			list.add(supplyInfo.getProducer());
		}
		
		sql.append(" ) ");
		sql.append(UtilHelp.engenderByParamCount(list.size()));
		return supplyDao.add(sql.toString(), list.toArray(), "");
	}

	@Override
	public int delete(Integer userid, Integer supplyId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(SupplyInfo supplyInfo) { 
	StringBuilder sql=new StringBuilder(" update supply_info set number=?,price=?,valid=?,type=?,description=? ");
		
		List<Object> list=new ArrayList<Object>();
		list.add(supplyInfo.getNumber());
		list.add(supplyInfo.getPrice());
		list.add(supplyInfo.getValid());
		list.add(supplyInfo.getType());
		list.add(supplyInfo.getDescription());
		  
		//胶合板
		if(supplyInfo.getType()==2)
		{
			sql.append(" ,length=?,width=?,thickness=? ");
			list.add(supplyInfo.getLength());
			list.add(supplyInfo.getWidth());
			list.add(supplyInfo.getThickness());
		}
		//原木
		if(supplyInfo.getType()==3)
		{
			sql.append(" ,length=?,cultivated=?,tail_directly=?,unit=? ");
			list.add(supplyInfo.getLength());
			list.add(supplyInfo.getCultivated());
			list.add(supplyInfo.getTailDirectly());
			list.add(supplyInfo.getUnit());
		}
		//淀粉
		if(supplyInfo.getType()==4)
		{
			sql.append(" ,brand=? ,level=?,producer=?  ");
			list.add(supplyInfo.getBrand());
			list.add(supplyInfo.getLevel());
			list.add(supplyInfo.getProducer());
		}
		
		sql.append(" where id=? ");
		list.add(supplyInfo.getId());
		return supplyDao.update(sql.toString(), list.toArray(), "");
	}


	@Override
	public QueryResult<SupplyInfoExpand> search(int page, int pageSize, SupplyDTo dto) throws DataManagerException {
		
		
		/**
		 *    select su.*,To_Days(valid)-To_Days(now()) as lastday,us.phone,us.realname,us.companyname,us.place_receipt,us.province
,us.city,us.county,us.park,us.logo
from supply_info AS su,userinfo as us
where su.userid=us.id and  ( su.valid>=date_format(now(),'%Y-%m-%d')
 or us.level=1  or ( us.level=2  and  date_add(su.valid, interval us.specified_date day)>=date_format(now(),'%Y-%m-%d')) )
		 */
		
		StringBuilder sql=new StringBuilder();
		sql.append("  select su.*,To_Days(valid)-To_Days(now()) as lastday,");
		sql.append("  us.phone,us.realname,us.companyname,us.place_receipt,us.province,us.city,us.county,us.park,us.logo ");
		sql.append(" from supply_info AS su,userinfo as us ");
		sql.append(" where su.userid=us.id  ");
		sql.append(" and su.type=? ");
		sql.append(" and su.status=0 ");
		sql.append(" and  ( su.valid>=date_format(now(),'%Y-%m-%d') ");
		sql.append(" or us.level=1  or ( us.level=2  and  date_add(su.valid, interval us.specified_date day)>=date_format(now(),'%Y-%m-%d') ) )");
		List<Object> list=new ArrayList<Object>();
		list.add(dto.getType());
		LinkedHashMap<String, String> orders=new LinkedHashMap<String, String>();
		//手动干预排序.
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
		
		
		return supplyExpandDao.search(sql.toString(), expandRow, "",page,pageSize, list.toArray(), orders);
	}

	public RowMapper<SupplyInfoExpand> expandRow=new RowMapper<SupplyInfoExpand>() {
		
		@Override
		public SupplyInfoExpand mapRow(ResultSet result, int arg1)
				throws SQLException {
			SupplyInfoExpand expand=new SupplyInfoExpand();



			expand.setId(result.getInt("id"));
			expand.setUserid(result.getInt("userid"));
			expand.setType(result.getInt("type"));
			expand.setPrice(result.getInt("price"));
			expand.setNumber(result.getInt("number"));
			expand.setAddtime(UtilHelp.dateBefore(result.getDate("addtime")));
			
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
	
	
	public RowMapper<SupplyInfo> row=new RowMapper<SupplyInfo>() {
		
		@Override
		public SupplyInfo mapRow(ResultSet result, int arg1)
				throws SQLException {
			SupplyInfo expand=new SupplyInfo();
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
	public QueryResult<SupplyInfo> search(int page, int pageSize, int userid,int type)
			throws DataManagerException {
		String sql=" select id,userid,length,width,thickness,number,price,valid ,description,cultivated,tail_directly ,unit,brand ,level,producer ,type,addtime "
				+ " from supply_info where   userid=? and type=? order by addtime desc ";
		return supplyDao.search(sql, row, "", page, pageSize, new Object[]{userid,type});
	}
//	@Override
//	public SupplyInfo getById(int id)throws DataManagerException {
//		String sql=" select id,userid,length,width,thickness,number,price,valid ,description,cultivated,tail_directly ,unit,brand ,level,producer ,type,addtime "
//				+ " from supply_info where id=? ";
//		return supplyDao.getById(sql,new Object[]{id},null, row);   
//	}
	
	@Override
	public List<SupplyInfo> searchByIds(int[] ids)
			throws DataManagerException {
		StringBuffer sql = new StringBuffer();
	 	sql.append(" select id,userid,length,width,thickness,number,price,valid ,description,cultivated,tail_directly ,unit,brand ,level,producer ,type,addtime  from supply_info where id in( ");
		for (int i : ids) {
			sql.append(i).append(",");
		}
		String _sql = sql.substring(0, sql.length()-1);
		_sql +=")";
		return supplyDao.searchList(_sql, row, "", new Object[]{});
	}
	
}
