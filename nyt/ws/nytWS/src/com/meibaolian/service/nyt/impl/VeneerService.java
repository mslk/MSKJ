package com.meibaolian.service.nyt.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import com.meibaolian.cache.Freight_ratesCache;
import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.dao.nyt.impl.VeneerDao;
import com.meibaolian.entity.Freight_ratesEntity;
import com.meibaolian.entity.UserInfo;
import com.meibaolian.entity.VennerSupplyInfo;
import com.meibaolian.service.nyt.IVeneerService;
import com.meibaolian.util.OfferTransverterUtil;
import com.meibaolian.util.UtilHelp;
import com.meibaolian.util.exception.DataManagerException;
import com.meibaolian.util.exception.NoParameterException;
import com.meibaolian.web.base.WebUtil;
import com.meibaolian.web.nyt.dto.VeneerDTo;

/**
 * 单板供应
 * @author Kawin
 *
 */
public class VeneerService implements IVeneerService{
	private VeneerDao veneerDao;
	private Freight_ratesCache fr;
	public void setVeneerDao(VeneerDao veneerDao) {
		this.veneerDao = veneerDao;
	}
 
	public void setFr(Freight_ratesCache fr) {
		this.fr = fr;
	}

	@Override
	public int add(VennerSupplyInfo vo) throws NoParameterException {
		return 0;
	}

	@Override
	public int delete(Integer userid, Integer supplyId) {
		return 0;
	}
	
	@Override
	public QueryResult<VennerSupplyInfo> search(int page, int pageSize,
			VeneerDTo vo) throws DataManagerException {
			QueryResult<VennerSupplyInfo> rs = searchBase(page, pageSize, vo);
			if(null == rs) return null; 
			List<VennerSupplyInfo> ls = rs.getList();
			//获得买家地址
			String buyerPlaceReceipt = getUserPlaceReceiptByUserid("" + vo.getUserid());
			for (int i =0; i < ls.size(); i++) {
				VennerSupplyInfo vennerSupplyInfo = ls.remove(i);
				String sellPlaceReceipt = vennerSupplyInfo.getPlace_receipt();
				
				Freight_ratesEntity bean = fr.getFreight_ratesByBuyerAddressAndSellAddress(buyerPlaceReceipt, sellPlaceReceipt);
 
				if(null != bean){//有运费信息,默认是 立方米/元 
					//计算立方运费 = 立方米/元 * 数量
					double seaCubeOffer = bean.getSea_freight_rates() * vennerSupplyInfo.getNumber();
					double carCubeOffer = bean.getCar_freight_rates() * vennerSupplyInfo.getNumber();
					//计算套运费 (根据立方报价,立方数量)
					double seaCoverOffer = OfferTransverterUtil.getCoverofferByCubeofferCoverNum(seaCubeOffer, vennerSupplyInfo.getNumber());
					double carCoverOffer = OfferTransverterUtil.getCoverofferByCubeofferCoverNum(carCubeOffer, vennerSupplyInfo.getNumber());
					//计算套报价
					double freight_rates = 
							 OfferTransverterUtil.getCoverofferByCubeofferCoverNum
							(vennerSupplyInfo.getNumber(), vennerSupplyInfo.getPrice().doubleValue(), UtilHelp.strToDouble(vennerSupplyInfo.getLength()), UtilHelp.strToDouble(vennerSupplyInfo.getWidth()), UtilHelp.strToDouble(vennerSupplyInfo.getThicknessint()));
					vennerSupplyInfo.setSea_freight_rates(bean.getSea_freight_rates());
					vennerSupplyInfo.setCar_freight_rates(bean.getCar_freight_rates());
					//海到价 = 套报价 + 套海运价 
					double sear_to_feight_rates = freight_rates + seaCoverOffer;
					vennerSupplyInfo.setSea_to_freight_rates(sear_to_feight_rates);
					//汽到价 = 套报价 + 套汽运价
					vennerSupplyInfo.setCar_to_freight_rates(freight_rates + carCoverOffer);
					//议价器 discuss 将海到价作为议价,每次默认少一毛钱
				    double discuss_prices[][] = OfferTransverterUtil.getDiscuss(sear_to_feight_rates, vennerSupplyInfo.getNumber());
				    vennerSupplyInfo.setDiscuss_prices(discuss_prices);
				    ls.add(vennerSupplyInfo);
				}
			}
			rs.setList(ls);
			return rs;
	}

	 
	/**
	 * 根据查看信息用户id获取该用户的交易地址信息
	 * @param userid
	 * @return 
	 */
	private String getUserPlaceReceiptByUserid(String userid){
		if(null == userid || "".equals(userid))
			return null;
		UserInfo vo = WebUtil.getUserEntity(userid);
		if(null == vo)
			return null;
		else
			return vo.getPlace_receipt();
	}
 
	public QueryResult<VennerSupplyInfo> searchBase(int page, int pageSize,
			VeneerDTo dto) throws DataManagerException {
		List<Object> list = new ArrayList<Object>();
		LinkedHashMap<String, String> orders=new LinkedHashMap<String, String>();
		orders.put(" su.orderid ", " desc ");//先按后台干预进行排序
		StringBuilder sql=new StringBuilder();
		sql.append("  select um.realname as manager_realname,um.phone as manager_phone,su.*,To_Days(valid)-To_Days(now()) as lastday,");
		sql.append("  us.phone,us.realname,us.companyname,us.place_receipt,us.province,us.city,us.county,us.park,us.logo ");
		sql.append(" from usermanager as um, veneer_info AS su,userinfo as us ");
		sql.append(" where su.userid=us.id  ");
		sql.append(" and us.usermanagerid=um.id ");
		sql.append(" and su.type=? ");
		//不是被屏蔽的消息
		sql.append(" and su.status=0 ");
		sql.append(" and  ( su.valid>=date_format(now(),'%Y-%m-%d') ");
		sql.append(" or us.level=1  or ( us.level=2  and  date_add(su.valid, interval us.specified_date day)>=date_format(now(),'%Y-%m-%d') ) )");
		
		list.add(dto.getType());
		if(dto!=null && !"".equals(dto.getKey())){//输入关键字其它条件无效
			sql.append(" and (  su.length like ? ");
			sql.append(" or su.width like ? ");
			sql.append(" or su.thicknessint like ? ");
			sql.append(" or su.average_thickness like ? ");
			sql.append(" or su.level like ? ");
			sql.append(" or su.reference like ? ");
			sql.append(" or su.number like ? ");
			sql.append(" or su.price like ? ");
			sql.append(" or su.panel like ? ");
			sql.append(" or us.phone like ? ");
			sql.append(" or us.realname like ? ");
			sql.append(" or us.companyname like ? ");
			sql.append(" or us.place_receipt like ? ");
			sql.append(" or um.realname like ? ");
			sql.append(" or um.phone like ? ");
			list.add(UtilHelp.setSQLLikeStr(dto.getKey()));
			list.add(UtilHelp.setSQLLikeStr(dto.getKey()));
			list.add(UtilHelp.setSQLLikeStr(dto.getKey()));
			list.add(UtilHelp.setSQLLikeStr(dto.getKey()));
			list.add(UtilHelp.setSQLLikeStr(dto.getKey()));
			list.add(UtilHelp.setSQLLikeStr(dto.getKey()));
			list.add(UtilHelp.setSQLLikeStr(dto.getKey()));
			list.add(UtilHelp.setSQLLikeStr(dto.getKey()));
			list.add(UtilHelp.setSQLLikeStr(dto.getKey()));
			list.add(UtilHelp.setSQLLikeStr(dto.getKey()));
			list.add(UtilHelp.setSQLLikeStr(dto.getKey()));
			list.add(UtilHelp.setSQLLikeStr(dto.getKey()));
			list.add(UtilHelp.setSQLLikeStr(dto.getKey()));
			list.add(UtilHelp.setSQLLikeStr(dto.getKey()));
			list.add(UtilHelp.setSQLLikeStr(dto.getKey()));
			list.add(UtilHelp.setSQLLikeStr(dto.getKey()));
		}else{
			if(!"".equals(dto.getLength()))
			{
				sql.append(" and su.length =? ");
				list.add(dto.getLength());
			}
			if(!"".equals(dto.getWidth()))
			{
				sql.append(" and su.width =? ");
				list.add(dto.getWidth());
			}
			if(!"".equals(dto.getThicknessint()))
			{
				sql.append(" and su.thicknessint =? ");
				list.add(dto.getThicknessint());
			}
			
			//价格排序
			if(0 != dto.getPricesort()){
				if("1".equals(dto.getPricesort())){
					orders.put(" su.price ", " desc ");
				}else{
					orders.put(" su.price ", " asc ");
				}
			}
			//平局厚度排序
			if(0 != dto.getAveragethicknesssort()){
				if("1".equals(dto.getAveragethicknesssort())){//1 代表降序 
					 orders.put(" su.average_thickness ", " desc ");
				}else{//2代表降序
					  orders.put(" su.average_thickness ", " asc "); 
				}
			}
			
			if(!"".equals(dto.getAveragethickness()))
			{
				sql.append(" and su.average_thickness >=? ");
				list.add(dto.getAveragethickness());
			}
			
			if(!"".equals(dto.getReference()))
			{
				sql.append(" and su.reference=? ");
				list.add(dto.getReference());
			}
			
			if(!"".equals(dto.getLevel()))
			{
				sql.append(" and su.level=? ");
				list.add(dto.getLevel());
			}
			
			if(!"".equals(dto.getPanel()))
			{
				sql.append(" and su.panel=? ");
				list.add(dto.getPanel());
			}
			
			if(!"".equals(dto.getPlace_receipt()))
			{
				sql.append(" and us.place_receipt=? ");
				list.add(dto.getPlace_receipt());
			}
		}
		 
		return veneerDao.search(sql.toString(), rmpp, "",page,pageSize, list.toArray(), orders);
	}

	private static RowMapper<VennerSupplyInfo> rmpp = new RowMapper<VennerSupplyInfo>() {

		@Override
		public VennerSupplyInfo mapRow(ResultSet arg0, int arg1)
				throws SQLException {
			VennerSupplyInfo vennerInfo = new VennerSupplyInfo();
			vennerInfo.setId(arg0.getInt("id"));
			vennerInfo.setUserid(arg0.getInt("userid"));
			vennerInfo.setLength(arg0.getString("length"));
			vennerInfo.setWidth(arg0.getString("width"));
			vennerInfo.setThicknessint(arg0.getString("thicknessint"));
			vennerInfo.setAverage_thickness(arg0.getBigDecimal("average_thickness"));
			vennerInfo.setLevel(arg0.getString("level"));
			vennerInfo.setReference(arg0.getString("reference"));
			vennerInfo.setPanel(arg0.getString("panel"));
			vennerInfo.setHole_panel(arg0.getString("hole_panel"));
			vennerInfo.setMoisture(arg0.getString("moisture"));
			vennerInfo.setBark(arg0.getString("bark"));
			vennerInfo.setMildew(arg0.getString("mildew"));
			vennerInfo.setLead_time(arg0.getString("lead_time"));
			vennerInfo.setNumber(arg0.getInt("number"));
			vennerInfo.setPrice(arg0.getBigDecimal("price"));
			vennerInfo.setValid(arg0.getString("valid"));
			vennerInfo.setDescribed(arg0.getString("described"));
			vennerInfo.setType(arg0.getInt("type"));
			vennerInfo.setPlace_receipt(arg0.getString("place_receipt"));
			vennerInfo.setCompanyname(arg0.getString("companyname"));
			vennerInfo.setRealname(arg0.getString("realname"));
			vennerInfo.setPhone(arg0.getString("phone"));
			vennerInfo.setManager_phone(arg0.getString("manager_phone"));
			vennerInfo.setManager_realname(arg0.getString("manager_realname"));
			vennerInfo.setLogo(arg0.getString("logo"));
			int a=arg0.getInt("lastday");
			if(a>0)
			{
				vennerInfo.setValid("剩余" +a+"天");
			}else
			{ 
				vennerInfo.setValid("已过期" +Math.abs(a)+"天");
			}  
			vennerInfo.setAddtime(UtilHelp.dateBefore(arg0.getDate("addtime")));
			return vennerInfo;
		}
	};

}
