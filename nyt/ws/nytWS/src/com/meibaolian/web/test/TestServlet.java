package com.meibaolian.web.test;



import org.apache.log4j.Logger;

import com.meibaolian.dao.user.IUserDao;
import com.meibaolian.web.base.BaseServlet;

public class TestServlet extends BaseServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Logger logger = Logger.getLogger(TestServlet.class);
	
	private IUserDao userDao;
	
	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	
	public static void main(String[] args) {
		
//		BaseMessage<List<UserInfo>> base=new BaseMessage<List<UserInfo>>();
//		
//		List<UserInfo> list=new ArrayList<UserInfo>();
//		UserInfo userinfo=new UserInfo();
//		userinfo.setId(1);
//		UserInfo userinfo1=new UserInfo();
//		userinfo1.setId(2);
//		
//		list.add(userinfo);
//		list.add(userinfo1);
//		
//		base.setStatus("200");
//		base.setExpand1("1");
//		base.setExpand2("2");
//		base.setExpand3("3");
//		
//		
//		base.setData(list);
//		JSONObject jsonArray = JSONObject.fromObject(base);
//		System.out.println(jsonArray.toString());
//		
//		JSONObject objs=JSONObject.fromObject(jsonArray.toString());
//		
//		//对象里面 包含的集合对象对应表
//		Map<String, Class<UserInfo>> classMap = new HashMap<String, Class<UserInfo>>(); 
//		 classMap.put("dataList", UserInfo.class); 
//		
//		 BaseMessage<List<UserInfo>> b=(BaseMessage<List<UserInfo>>) JSONObject.toBean(objs,BaseMessage.class,classMap);
//		
//		System.out.println(b.getStatus());
//		System.out.println(b.getExpand1());
//		System.out.println(b.getExpand2());
//		System.out.println(b.getExpand3());
//		List<UserInfo> userList=b.getData();
//
//		 for(UserInfo u:userList)
//		 {
//			 System.out.println(u.getId());
//		 }
//		
	}





}
