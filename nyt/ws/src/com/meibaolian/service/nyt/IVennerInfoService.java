package com.meibaolian.service.nyt;




import java.util.List;

import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.entity.Collect_infoEntity;
import com.meibaolian.entity.VennerInfo;
import com.meibaolian.util.exception.DataManagerException;

public interface IVennerInfoService {
	/**
	 * 添加发布信息
	 * @param customer
	 * @return
	 */
	public int addVennerInfo(VennerInfo vennerInfo);
	
	
	/**
	 * 修改桉木信息
	 * @param customer
	 * @return
	 */
	public int updateVennerInfo(VennerInfo vennerInfo,int id);
	
	
	
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
			throws DataManagerException;
	
	
	
	/**
	 * 根据用户id和类型查询用户本身的求购和供应信息
	 * @param userid
	 * @param page
	 * @param pageSize
	 * @param orders
	 * @return
	 * @throws DataManagerException
	 */
	public QueryResult<VennerInfo> searchVennerInfo(Integer userid,int page, int pageSize,int type)
			throws DataManagerException;
	

	/**
	 * 通过长，宽 ,厚 以及排序字段来查询桉木供应信息列表
	 * @param userid
	 * @param page
	 * @param pageSize
	 * @param orders
	 * @return
	 * @throws DataManagerException
	 */
	public QueryResult<VennerInfo> searchVennerInfo(Integer userid,
			int page, int pageSize,String  queryValue)
			throws DataManagerException;
	/**
	 * 删除桉木信息
	 * @param id
	 * @return
	 */
	public int delVennerInfo(int userid,int id);
	
	/**
	 * 删除胶合板 ， 原木 ，淀粉 求购信息
	 * @param id
	 * @return
	 */
	public int delPurchaseInfo(int userid,int id);
	
	/**
	 * 删除胶合板 ， 原木 ，淀粉 供应信息
	 * @param id
	 * @return
	 */
	public int delSupplyInfo(int userid,int id);
	
	/**
	 * 是否已存在此数据
	 * @param customer
	 * @return true 已存在
	 * @throws DataManagerException
	 */
	public boolean isExistVennerInfo(VennerInfo vennerInfo) throws DataManagerException;

	/**
	 * 根据记录id查询
	 * @param ids 集合数组
	 * @return
	 * @throws DataManagerException
	 */
	public List<VennerInfo> searchByIds(int[] ids) throws DataManagerException;

}
