package com.meibaolian.action.task;

import java.sql.Timestamp;
import java.util.Date;

import com.meibaolian.action.base.BaseAction;
import com.meibaolian.entity.PushTask;
import com.meibaolian.service.task.IPushTaskService;
import com.meibaolian.util.UtilHelp;

public class PushTaskManager extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private IPushTaskService pushTaskService;

	private int id;

	private String title;

	private String beginTime;

	private String endTime;

	private String description;

	public void setPushTaskService(IPushTaskService pushTaskService) {
		this.pushTaskService = pushTaskService;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * 新增任务
	 * 
	 * @return
	 */
	public String add() {

		String message = "新增推送失败!";
		String targetUrl = "controller/task/add.jsp";

		if (title != null && !"".equals(UtilHelp.notNullStr(title))
				&& beginTime != null
				&& !"".equals(UtilHelp.notNullStr(beginTime))
				&& endTime != null && !"".equals(UtilHelp.notNullStr(endTime))
				&& description != null
				&& !"".equals(UtilHelp.notNullStr(description))
				&& description.length() <= 500) {
			Date b = UtilHelp.stringToDate(beginTime, "");
			Date e = UtilHelp.stringToDate(endTime, "");

			if (e.getTime() > b.getTime()) {
				PushTask pushTask = new PushTask();
				pushTask.setTitle(title);
				pushTask.setSysdescription(description);
				pushTask.setBegintime(new Timestamp(b.getTime()));
				pushTask.setEndtime(new Timestamp(e.getTime()));
				pushTask.setAddtime(new Timestamp(new Date().getTime()));
				pushTaskService.addPushTask(pushTask);
				message = "新增推送成功!";
				targetUrl = "pushTask/taskSearch_searchList.action";// 跳向推送任务列表
			}
			// else
			// {
			// message="提交数据结束时间小于开始时间!";
			// }
		}
		saveMessage(message, targetUrl);
		return MESSAGE;
	}
	
	public String delete()
	{
		String message="删除失败!";
		
		if(id>0)
		{
			PushTask task=pushTaskService.getById(id);
			
			if(task!=null && task.getStatus()==0)
			{
				pushTaskService.deleteTask(id);
				message="删除成功!";
			}
			
		}
        saveMessage(message,"pushTask/taskSearch_searchList.action"); 		
		
		return MESSAGE;
	}

	/**
	 * 更新
	 * 
	 * @return
	 */
	public String update() {

		String message = "修改推送任务失败!";
		String targetUrl = "controller/task/add.jsp";

		if (id > 0 && title != null && !"".equals(UtilHelp.notNullStr(title))
				&& beginTime != null
				&& !"".equals(UtilHelp.notNullStr(beginTime))
				&& endTime != null && !"".equals(UtilHelp.notNullStr(endTime))
				&& description != null
				&& !"".equals(UtilHelp.notNullStr(description))
				&& description.length() <= 500) {
			Date b = UtilHelp.stringToDate(beginTime, "");
			Date e = UtilHelp.stringToDate(endTime, "");

			if (e.getTime() > b.getTime()) {
				PushTask pushTask = pushTaskService.getById(id);
				//只有未审核的任务才能修改
				if (pushTask != null && pushTask.getStatus()==0) {
					pushTask.setTitle(title);
					pushTask.setSysdescription(description);
					pushTask.setBegintime(new Timestamp(b.getTime()));
					pushTask.setEndtime(new Timestamp(e.getTime()));
					pushTask.setAddtime(new Timestamp(new Date().getTime()));
					pushTaskService.updateTask(pushTask);
					message = "修改任务成功!";
					targetUrl = "pushTask/taskSearch_searchList.action";// 跳向推送任务列表
				} 
			}
			// else
			// {
			// message="提交数据结束时间小于开始时间!";
			// }
		}

		saveMessage(message, targetUrl);
		return MESSAGE;
	}

	/**
	 * 更新任务状态, 审核通过
	 * @return
	 */
	public String updateAudit()
	{
		String message="审核通过失败!";
		String targetUrl="pushTask/taskSearch_detail.action?status=1&taskId="+id;
		if(id>0)
		{
			PushTask pushTask=pushTaskService.getById(id);
			targetUrl="pushTask/taskSearch_detail.action?status=2&taskId="+id;
			if(pushTask!=null && pushTask.getStatus()==0)
			{
				message="审核通过成功!";
				pushTaskService.updateAudit(id);
			}else
			{
				message="不存在的数据!";
			}
			
		}
		saveMessage(message, targetUrl);
		return MESSAGE;
	}
}
