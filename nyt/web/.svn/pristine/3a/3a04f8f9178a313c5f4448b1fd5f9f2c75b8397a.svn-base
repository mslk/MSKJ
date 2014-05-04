package com.meibaolian.service.task;

import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.entity.PushTask;

public interface IPushTaskService {

	
	/**
	 * 新增推送信息
	 * @param task
	 * @return
	 */
	public void addPushTask(PushTask task);
	
	
	/**
	 * 查询推送任务列表
	 * @param  status 根据status 状态来查询 
	 * 1 待审核
	 * 2 审核通过
	 * 默认根据时间降序
	 * @return
	 */
	public QueryResult<PushTask>  searchByStatus(int page,int pageSize,int status);
	
	
	/**
	 * 获取推送信息
	 * @param taskId
	 * @return
	 */
	public PushTask getById(int taskId);
	
	/**
	 * 修改任务信息
	 * @param task
	 */
	public void updateTask(PushTask task);
	
	/**
	 * 删除任务
	 * @param taskId
	 */
	public void deleteTask(int taskId);
	
	/**
	 * 更新任务状态为审核通过
	 * @param taskId
	 */
	public void updateAudit(int taskId);
	
}
