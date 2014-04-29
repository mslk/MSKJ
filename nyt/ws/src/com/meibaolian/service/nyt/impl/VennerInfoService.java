package com.meibaolian.service.nyt.impl;


import java.util.List;

import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.dao.nyt.IVennerInfoDao;
import com.meibaolian.entity.VennerInfo;
import com.meibaolian.service.nyt.IVennerInfoService;
import com.meibaolian.util.exception.DataManagerException;

public class VennerInfoService implements IVennerInfoService{
	 IVennerInfoDao vennerInfoDao;
	
	public void setVennerInfoDao(IVennerInfoDao vennerInfoDao) {
		this.vennerInfoDao = vennerInfoDao;
	}

	@Override
	public int addVennerInfo(VennerInfo vennerInfo) {
		return vennerInfoDao.addVennerInfo(vennerInfo);
	}

	/**
	 * 修改桉木信息
	 * @param customer
	 * @return
	 */
	public int updateVennerInfo(VennerInfo vennerInfo,int id)
	{
		return vennerInfoDao.updateVennerInfo(vennerInfo, id);
	}
	
	/**
	 * 根据用户id和类型查询用户本身的求购和供应信息
	 * @param userid,type
	 * @param page
	 * @param pageSize
	 * @param orders
	 * @return
	 * @throws DataManagerException
	 */
	public QueryResult<VennerInfo> searchVennerInfo(Integer userid,
			int page, int pageSize,int type)
			throws DataManagerException {
		return vennerInfoDao.searchVennerInfo(userid,
				page, pageSize,type);
	}
	
	/**
	 * 通过长，宽 ,厚 以及排序字段来查询列表
	 * @param userid
	 * @param page
	 * @param pageSize
	 * @param orders
	 * @return
	 * @throws DataManagerException
	 */
	public QueryResult<VennerInfo> searchVennerInfo(Integer userid,
			int page, int pageSize,String length,String width,String thicknessint,String pricesort,String averagethicknesssort,String referencesort,String levelsort)
			throws DataManagerException {
		return vennerInfoDao.searchVennerInfo(userid,
				page, pageSize,length,width, thicknessint,pricesort, averagethicknesssort, referencesort, levelsort);
	}
	
	
	/**
	 * 通过长，宽 ,厚 以及排序字段来查询桉木供应列表
	 * @param userid
	 * @param page
	 * @param pageSize
	 * @param orders
	 * @return
	 * @throws DataManagerException
	 */
	public QueryResult<VennerInfo> searchVennerInfo (Integer userid,
			int page, int pageSize,String queryValue)
			throws DataManagerException {
		return vennerInfoDao.searchVennerInfo(userid,
				page, pageSize,queryValue);
	}
	
	@Override
	public int delVennerInfo(int userid ,int id) {
		return vennerInfoDao.delVennerInfo(userid,id);
	}

	@Override
	public int delPurchaseInfo(int userid ,int id) {
		return vennerInfoDao.delPurchaseInfo(userid,id);
	}
	
	@Override
	public int delSupplyInfo(int userid ,int id) {
		return vennerInfoDao.delSupplyInfo(userid,id);
	}

	@Override
	public boolean isExistVennerInfo(VennerInfo vennerInfo) throws DataManagerException{
		return vennerInfoDao.isExistVennerInfo(vennerInfo);
	}

	@Override
	public List<VennerInfo> searchByIds(int[] ids) throws DataManagerException {
		return vennerInfoDao.searchByIds(ids);
	}
	 
}
