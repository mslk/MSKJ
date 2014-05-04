package com.meibaolian.dao.nyt;




import java.util.List;

import com.meibaolian.dao.base.IBaseDao;
import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.entity.VennerInfo;
import com.meibaolian.util.exception.DataManagerException;

public interface IVennerInfoDao extends IBaseDao<VennerInfo> {
	/**
	 * 发布桉木信息（求购或者供应）
	 * @throws DataManagerException
	 */
    public int addVennerInfo(VennerInfo vennerInfo);
    
    /**
	 * 修改桉木信息（求购或者供应）
	 * @throws DataManagerException
	 */
    public int updateVennerInfo(VennerInfo vennerInfo,int id);
	
	public int delVennerInfo(int userid,int id);
	
	public int delPurchaseInfo(int userid,int id);
	
	public int delSupplyInfo(int userid,int id);
	/**
	 * 是否已存在此数据
	 * @param customer
	 * @return true 已存在
	 * @throws DataManagerException
	 */
	public boolean isExistVennerInfo(VennerInfo vennerInfo) throws DataManagerException;
	
	
	
	
	/**
	 * 获取桉木求购信息
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
	 * 获取桉木供应信息
	 * @param userid
	 * @param page
	 * @param pageSize
	 * @param orders
	 * @return
	 * @throws DataManagerException
	 */
	public QueryResult<VennerInfo> searchVennerInfo (Integer userid,
			int page, int pageSize,String queryValue)
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
	public QueryResult<VennerInfo> searchVennerInfo (Integer userid,
			int page, int pageSize,int type)
			throws DataManagerException;
	
	/**
	 * 根据记录id查询
	 * @param ids 集合数组
	 * @return
	 * @throws DataManagerException
	 */
	public List<VennerInfo> searchByIds(int[] ids) throws DataManagerException;

}
