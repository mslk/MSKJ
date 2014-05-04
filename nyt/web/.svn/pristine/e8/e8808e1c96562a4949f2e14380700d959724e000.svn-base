package com.meibaolian.action.task;

import com.meibaolian.action.base.BaseAction;
import com.meibaolian.action.base.PageView;
import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.entity.PushTask;
import com.meibaolian.service.task.IPushTaskService;

public class PushTaskSeach extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	IPushTaskService pushTaskService;
	
	public void setPushTaskService(IPushTaskService pushTaskService) {
		this.pushTaskService = pushTaskService;
	}

	//推送任务id
	private int taskId;
	
	/**
	 * 查询相关状态的推送任务
	 * 1 待审核
	 * 2 审核通过
	 */
	private int status;
	
	/**
	 * 查询类型, 默认1  1 :普通查询展示  2: 跳到修改的页面 展示
	 */
	private int type=1;
	
	
	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
    
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String detail()
	{
        PushTask task=pushTaskService.getById(taskId);
        
        String result="detail";
        
        if(type==2)
        {
        	result="detailToEdit";
        }
        
        if(task!=null)
        {
        	savePageObj(task);
        }else
        {
        	result=MESSAGE;
        	saveMessage("没有找到相关数据!", "pushTask/taskSearch_searchList.action");
        }
		return result;
	}



	public String searchList()
	{
	
		QueryResult<PushTask> query=null;
		
		//查看待审核
		if(status<=1)
		{
			status=1;
		}else 
		{
			status=2;
		}
		query=pushTaskService.searchByStatus(getPage(),PAGESIZE , status);
		savePageView(new PageView<PushTask>(query, getPage(), PAGESIZE));
		return "list";
	}
	
	
}
