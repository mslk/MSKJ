package com.meibaolian.service.task.imple;

import java.util.LinkedHashMap;
import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.dao.task.IPushTaskDao;
import com.meibaolian.entity.PushTask;
import com.meibaolian.service.task.IPushTaskService;

public class PushTaskService implements IPushTaskService {
	

	
	
	IPushTaskDao pushTaskDao;
	
	public void setPushTaskDao(IPushTaskDao pushTaskDao) {
		this.pushTaskDao = pushTaskDao;
	}



	@Override
	public void addPushTask(PushTask task) {
		
		task.setSendtype(1); //软件推送
		task.setEdition(0);
		task.setStatus(0);
		
		task.setClickcount(0);
		task.setPushnumber(0);
		task.setNotsendnumber(0);
		task.setSendNumberr(0);
		task.setSuccessNumber(0);
		
		pushTaskDao.add(task);
	}



	@Override
	public QueryResult<PushTask> searchByStatus(int page,int pageSize,int status) {
		
//		状态  
//		 待审核:   0 未审核    2 审核未通过  
//		 审核通过: 1已审核   3   翻译完成    4   删除客服端信息 5   任务已过期(后台这步操作是需要删除)
		String where=" and (status=0 or status=2 ) ";
		
		if(status==2)
		{
			where=" and ( status=1 or status=3 or status=4 or status=5 )";
		}
		LinkedHashMap<String, String> orders=new LinkedHashMap<String, String>();
		orders.put(" addtime ", " desc ");
		return pushTaskDao.search(page, pageSize, where,null, orders);
	}



	@Override
	public PushTask getById(int taskId) {
		return pushTaskDao.get(taskId);
	}


	@Override
	public void updateTask(PushTask task) {
         pushTaskDao.update(task);		
	}



	@Override
	public void deleteTask(int taskId) {
        pushTaskDao.delete(taskId);		
	}



	@Override
	public void updateAudit(int taskId) {
		//0 待审核
		//1 审核通过
		String where=" set status=? where status=? and id=? ";
		pushTaskDao.updateBySql(where, new Object[]{1,0,taskId});
	}

}
