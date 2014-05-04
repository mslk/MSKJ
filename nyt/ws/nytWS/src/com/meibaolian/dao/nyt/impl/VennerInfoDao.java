package com.meibaolian.dao.nyt.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
















import org.springframework.jdbc.core.RowMapper;

import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.dao.base.impl.BaseDao;
import com.meibaolian.dao.nyt.IVennerInfoDao;
import com.meibaolian.entity.VennerInfo;
import com.meibaolian.util.UtilHelp;
import com.meibaolian.util.exception.DataManagerException;
import com.meibaolian.util.tablehash.TableRules;

public class VennerInfoDao extends BaseDao<VennerInfo> implements IVennerInfoDao{
	
	@Override
	public int addVennerInfo(VennerInfo vennerInfo) {
		String tableName = TableRules.getVeneer_info();
		
		StringBuilder sql = new StringBuilder("insert into ");
		List<Object> list = new ArrayList<Object>();
		
		sql.append(tableName).append(" (userid, length, width,thicknessint, average_thickness,level,reference,panel,hole_panel,moisture,bark,mildew,lead_time, number,price,valid,described,type,addtime) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		list.add(vennerInfo.getUserid());
		list.add(vennerInfo.getLength());
		list.add(vennerInfo.getWidth());
		list.add(vennerInfo.getThicknessint());
		list.add(vennerInfo.getAverage_thickness());
		list.add(vennerInfo.getLevel());
		list.add(vennerInfo.getReference());
		list.add(vennerInfo.getPanel());
		list.add(vennerInfo.getHole_panel());
		list.add(vennerInfo.getMoisture());
		list.add(vennerInfo.getBark());
		list.add(vennerInfo.getMildew());
		list.add(vennerInfo.getLead_time());
		list.add(vennerInfo.getNumber());
		list.add(vennerInfo.getPrice());
		list.add(vennerInfo.getValid());
		list.add(vennerInfo.getDescribed());
		list.add(vennerInfo.getType());
		list.add(new Date());
		return super.add(sql.toString(), list.toArray(), tableName);
	}

	@Override
	public int updateVennerInfo(VennerInfo vennerInfo,int id) {
		String tableName = TableRules.getVeneer_info();
		StringBuilder sql = new StringBuilder();
		sql.append(" update  ").append(tableName);
		sql.append(" set length=? ,width=?,thicknessint=?,average_thickness=?,level=?,reference=?,panel=?,hole_panel=?,moisture=?,bark=?,mildew=?,lead_time=?, number=?,price=?,valid=?,described=? where userid=? and id=? ");
		List<Object> list = new ArrayList<Object>();
		list.add(vennerInfo.getLength());
		list.add(vennerInfo.getWidth());
		list.add(vennerInfo.getThicknessint());
		list.add(vennerInfo.getAverage_thickness());
		list.add(vennerInfo.getLevel());
		list.add(vennerInfo.getReference());
		list.add(vennerInfo.getPanel());
		list.add(vennerInfo.getHole_panel());
		list.add(vennerInfo.getMoisture());
		list.add(vennerInfo.getBark());
		list.add(vennerInfo.getMildew());
		list.add(vennerInfo.getLead_time());
		list.add(vennerInfo.getNumber());
		list.add(vennerInfo.getPrice());
		list.add(vennerInfo.getValid());
		list.add(vennerInfo.getDescribed());
		list.add(vennerInfo.getUserid());
		list.add(id);
		return super.update(sql.toString(), list.toArray(),
				tableName);
	}
	
	@Override
	public int delVennerInfo(int userid,int id) {
		String tableName = TableRules.getVeneer_info();
		StringBuilder sql = new StringBuilder("delete from ");
		sql.append(tableName).append(" where userid=? and id=? ");
		return super.deleteById(sql.toString(), new Object[]{userid,id}, tableName);
	}
	
	@Override
	public int delPurchaseInfo(int userid,int id) {
		String tableName = "purchase_info";
		StringBuilder sql = new StringBuilder("delete from ");
		sql.append(tableName).append(" where userid=? and id=? ");
		return super.deleteById(sql.toString(), new Object[]{userid,id}, tableName);
	}
	
	@Override
	public int delSupplyInfo(int userid,int id) {
		String tableName = "supply_info";
		StringBuilder sql = new StringBuilder("delete from ");
		sql.append(tableName).append(" where userid=? and id=? ");
		return super.deleteById(sql.toString(), new Object[]{userid,id}, tableName);
	}

	@Override
	public boolean isExistVennerInfo(VennerInfo vennerInfo) throws DataManagerException {
		String tableName = TableRules.getVeneer_info();
		StringBuilder sql = new StringBuilder("select count(1) from ");
		sql.append(tableName).append(" where userid=? ");
		long num = super.searchCount(sql.toString(), new Object[]{vennerInfo.getUserid()}, tableName);
		return num > 0;
	}

	
	
	
	public QueryResult<VennerInfo> searchVennerInfo(Integer userid,
			int page, int pageSize,String length,String width,String thicknessint,String pricesort,String averagethicknesssort,String referencesort,String levelsort)
			throws DataManagerException {
		String tableName = TableRules.getVeneer_info();
		String userTable = TableRules.getUserInfoRule();
		String pricesortsql=" order by orderid desc ";
		 if("1".equals(pricesort))//1 代表降序
		 {
			 pricesortsql=" order by price desc ";
		 }else if("2".equals(pricesort))//2代表升序
		 {
			 pricesortsql="order by price ";
		 }
		String averagethicknesssortsql="";
		if("".equals(pricesortsql)){
			 if("1".equals(averagethicknesssort))//1 代表降序
			 {
				 averagethicknesssortsql=" order by average_thickness desc";
			 }else if("2".equals(averagethicknesssort))//2代表升序
			 {
				 averagethicknesssortsql=" order by average_thickness ";
			 }
		 
		}else
		{
			
			if("1".equals(averagethicknesssort))//1 代表降序
			 {
				 averagethicknesssortsql="  average_thickness desc";
			 }else if("2".equals(averagethicknesssort))//2代表升序
			 {
				 averagethicknesssortsql="  average_thickness ";
			 }
		}
		List<Object> params = new ArrayList<Object>(0);
		//Datediff(DATE_ADD(t.valid,INTERVAL u.specified_date DAY),now()) 
		StringBuilder sql = new StringBuilder(
				"select u.place_receipt,u.companyname,u.logo, u.realname,u.phone ,u.specified_date,To_Days(valid)-To_Days(now())as datenum,t.* from ");
		sql.append(tableName).append(" t,").append(userTable).append(" u ").append(" where 1=1  and t.userid=u.id and t.type=2 and t.status=0 ");
        sql.append(" and  ( t.valid>=date_format(now(),'%Y-%m-%d') ");	
        sql.append("or u.level=1 or u.level=2 and date_add(t.valid, interval u.specified_date day)>=date_format(now(),'%Y-%m-%d')) ");
		
		if(!"".equals(length))
		{
			sql.append(" and t.length=? ");
			params.add(length);
		}
		if(!"".equals(width))
		{
			sql.append(" and t.width=? ");
			params.add(width);
		}
		if(!"".equals(thicknessint))
		{
			sql.append(" and t.thicknessint=? ");
			params.add(thicknessint);
		}
		if(!"".equals(referencesort))
		{
			sql.append(" and t.reference=?");
			params.add(referencesort);
			
		}
		if(!"".equals(levelsort))
		{
			sql.append(" and t.level=?");
			params.add(levelsort);
			
		}
		
		if(!"".equals(pricesortsql) && "".equals(averagethicknesssortsql))
		{
			sql.append(pricesortsql);
		}else if(!"".equals(pricesortsql) && !"".equals(averagethicknesssortsql))
		{
			sql.append(pricesortsql).append(",");
		}
		if(!"".equals(averagethicknesssortsql))
		{
			sql.append(averagethicknesssortsql);
		}
		if("0".equals(pricesort)&& "0".equals(averagethicknesssort))
		{
			sql.append(" order by  addtime desc");
			
		}
		return super.search(sql.toString(), vennerInfoRowMapper2,
				tableName, page, pageSize, params.toArray());
	}
	
	public QueryResult<VennerInfo> searchVennerInfo (Integer userid,
			int page, int pageSize,String queryValue)
			throws DataManagerException {
		String tableName = TableRules.getVeneer_info();
		String userTable = TableRules.getUserInfoRule();
		
		List<Object> params = new ArrayList<Object>(0);
		StringBuilder sql = new StringBuilder(
				"select u.place_receipt,u.companyname,u.logo, u.realname,u.phone,u.specified_date,To_Days(valid)-To_Days(now()) as datenum,t.* from ");
		sql.append(tableName).append(" t,").append(userTable).append(" u ")
				.append(" where 1=1  and t.userid=u.id and t.type=2 and t.status=0 ");
		sql.append(" and  ( t.valid>=date_format(now(),'%Y-%m-%d') ");	
		sql.append("or u.level=1 or u.level=2 and date_add(t.valid, interval u.specified_date day)>=date_format(now(),'%Y-%m-%d')) ");
		
		if(!"".equals(queryValue))
		{
			sql.append(" and (  t.length like ? ");
			sql.append(" or t.width like ? ");
			sql.append(" or t.thicknessint like ? ");
			sql.append(" or t.average_thickness like ? ");
			sql.append(" or t.level like ? ");
			sql.append(" or t.reference like ? ");
			sql.append(" or t.panel like ? ");
			sql.append(" or t.hole_panel like ? ");
			sql.append(" or t.moisture like ? ");
			sql.append(" or t.bark like ? ");
			sql.append(" or t.mildew like ? ");
			sql.append(" or t.lead_time like ? ");
			sql.append(" or t.number like ? ");
			sql.append(" or t.price like ? ");
			sql.append(" or t.described like ? ");
			params.add(UtilHelp.setSQLLikeStr(queryValue));
			params.add(UtilHelp.setSQLLikeStr(queryValue));
			params.add(UtilHelp.setSQLLikeStr(queryValue));
			params.add(UtilHelp.setSQLLikeStr(queryValue));
			params.add(UtilHelp.setSQLLikeStr(queryValue));
			params.add(UtilHelp.setSQLLikeStr(queryValue));
			params.add(UtilHelp.setSQLLikeStr(queryValue));
			params.add(UtilHelp.setSQLLikeStr(queryValue));
			params.add(UtilHelp.setSQLLikeStr(queryValue));
			params.add(UtilHelp.setSQLLikeStr(queryValue));
			params.add(UtilHelp.setSQLLikeStr(queryValue));
			params.add(UtilHelp.setSQLLikeStr(queryValue));
			params.add(UtilHelp.setSQLLikeStr(queryValue));
			params.add(UtilHelp.setSQLLikeStr(queryValue));
			params.add(UtilHelp.setSQLLikeStr(queryValue));
			sql.append(" or u.place_receipt like ? ");
			sql.append(" or u.companyname like ? ");
			sql.append(" or u.phone like ? ");
			sql.append(" or u.realname like ? ");
			params.add(UtilHelp.setSQLLikeStr(queryValue));
			params.add(UtilHelp.setSQLLikeStr(queryValue));
			params.add(UtilHelp.setSQLLikeStr(queryValue));
			params.add(UtilHelp.setSQLLikeStr(queryValue));
			sql.append("  ) "); 
			sql.append(" order by t.orderid desc ");
			sql.append(" order by  t.addtime desc");
		}
		
		
		
		return super.search(sql.toString(), vennerInfoRowMapper2,
				tableName, page, pageSize, params.toArray());
	}
	
	public QueryResult<VennerInfo> searchVennerInfo (Integer userid,
			int page, int pageSize,int type)
			throws DataManagerException {
		String tableName = TableRules.getVeneer_info();
		String userTable = TableRules.getUserInfoRule();
		
		List<Object> params = new ArrayList<Object>(0);
		StringBuilder sql = new StringBuilder(
				"select u.place_receipt,u.companyname,u.logo, u.realname,u.phone,u.specified_date,t.* from ");
		sql.append(tableName).append(" t,").append(userTable).append(" u ")
				.append(" where 1=1  and t.userid=u.id ");
		sql.append(" and t.type=? ");
		params.add(type);
		sql.append(" and t.userid=? ");
		params.add(userid);
	//	sql.append(" order by t.orderid desc ");
		sql.append(" order by  t.addtime desc");
		
		return super.search(sql.toString(), vennerInfoRowMapper,
				tableName, page, pageSize, params.toArray());
	}
	
	private static RowMapper<VennerInfo> vennerInfoRowMapper2 = new RowMapper<VennerInfo>() {

		@Override
		public VennerInfo mapRow(ResultSet arg0, int arg1)
				throws SQLException {
			VennerInfo vennerInfo = new VennerInfo();
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
			vennerInfo.setLogo(arg0.getString("logo"));
			vennerInfo.setRealname(arg0.getString("realname"));
			vennerInfo.setPhone(arg0.getString("phone"));
			String datenum=arg0.getString("datenum");
	        int datenums=Integer.parseInt(datenum);
			if(datenums>0)
			{
				String datenumstr="剩余"+datenum+"天";
				vennerInfo.setDatenum(datenumstr);
			}else
			{
				vennerInfo.setDatenum("已过期"+Math.abs(datenums)+"天");
			}
			
			vennerInfo.setAddtime(UtilHelp.dateBefore(arg0.getDate("addtime")));
			
			return vennerInfo;
		}
	};

	private static RowMapper<VennerInfo> vennerInfoRowMapper = new RowMapper<VennerInfo>() {

		@Override
		public VennerInfo mapRow(ResultSet arg0, int arg1)
				throws SQLException {
			VennerInfo vennerInfo = new VennerInfo();
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
			vennerInfo.setLogo(arg0.getString("logo"));
			vennerInfo.setRealname(arg0.getString("realname"));
			vennerInfo.setPhone(arg0.getString("phone"));
			vennerInfo.setAddtime(UtilHelp.setAddTime(arg0.getString("addtime")));
			
			return vennerInfo;
		}
	};

	@Override
	public List<VennerInfo> searchByIds(int[] ids)
			throws DataManagerException {
		String tableName = TableRules.getVeneer_info();
		String userTable = TableRules.getUserInfoRule();
		
		StringBuilder sql = new StringBuilder(
				"select u.place_receipt,u.companyname,u.logo, u.realname,u.phone,u.specified_date,t.* from ");
		sql.append(tableName).append(" t,").append(userTable).append(" u ")
				.append(" where 1=1  and t.userid=u.id ");
		sql.append(" and t.id in( ");
		for (int i : ids) {
			sql.append(i).append(",");
		}
		String _sql = sql.substring(0, sql.length()-1);
		_sql +=")";
		return super.searchList(_sql, vennerInfoRowMapper, tableName, new Object[]{});
	}
	
	
	public static void main(String[] args) {
		StringBuffer str = new StringBuffer("abcde");
	    String s = str.substring(0, str.length()-1);
		System.out.println(s);
	}
}
