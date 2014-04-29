package com.meibaolian.service.otheraid.imple;

import java.math.BigDecimal;

import com.meibaolian.dao.base.IReader;
import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.dao.otheraid.ICallPhoneLogDao;
import com.meibaolian.entity.CallPhoneLog;
import com.meibaolian.service.otheraid.ICallPhoneLogService;
import com.meibaolian.util.UtilHelp;

public class CallPhoneLogService implements ICallPhoneLogService {
	
	ICallPhoneLogDao callPhoneLogDao ;
	
	public void setCallPhoneLogDao(ICallPhoneLogDao callPhoneLogDao) {
		this.callPhoneLogDao = callPhoneLogDao;
	}

	
	public static IReader<CallPhoneLog> callPhoneLogRead=new IReader<CallPhoneLog>() {
		
		@Override
		public CallPhoneLog readerByList(Object[] objs) 
		{
			CallPhoneLog callPhoneLog=new CallPhoneLog();
			callPhoneLog.setPhone((String)objs[0]);
			callPhoneLog.setNumber(((BigDecimal)objs[1]).intValue());
			return callPhoneLog;
		}
	};
	
	@Override
	public QueryResult<CallPhoneLog> searchByPhone(String phone,int page,int pageSize) {
		
		
		String sql =" select phone,sum(number) as countNumb from callphonelog ";
		String sqlCount=" select count(1) from ( select count(1) from callphonelog ";
		Object [] obj=null;
		
		if(!"".equals(UtilHelp.notNullStr(phone)))
		{
			sql +="  where phone like  ? ";
			sqlCount+=" where phone like ? ";
			obj=new Object[]{"%"+phone+"%"};
		}
		sql+=" group by phone  order by countNumb desc ";
		sqlCount+=" group by phone ) as a";
		
		return callPhoneLogDao.searchSQLByParamter(sql, sqlCount, page, pageSize, null, obj, null, callPhoneLogRead);
	}

}
