package com.meibaolian.service.receiptplace.imple;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.dao.receiptplace.ICityDao;
import com.meibaolian.dao.receiptplace.ICountyDao;
import com.meibaolian.dao.receiptplace.IProvinceDao;
import com.meibaolian.dto.ReceiptPlaceDto;
import com.meibaolian.entity.City;
import com.meibaolian.entity.County;
import com.meibaolian.entity.Province;
import com.meibaolian.service.receiptplace.IReceiptPlaceService;
import com.meibaolian.util.UtilHelp;

public class ReceiptPlaceService implements IReceiptPlaceService {
	
	private ICityDao cityDao;
	private ICountyDao countyDao;
	private IProvinceDao provinceDao;

	public void setCityDao(ICityDao cityDao) {
		this.cityDao = cityDao;
	}

	public void setCountyDao(ICountyDao countyDao) {
		this.countyDao = countyDao;
	}

	public void setProvinceDao(IProvinceDao provinceDao) {
		this.provinceDao = provinceDao;
	}
	//
	@Override
	public int addReceiptPlace(County county) {
		int result = 0;
		long provinceId = provinceDao.searchCountByhql(
						"select id from Province where name like ?",
						new Object[] { UtilHelp.setSQLLikeStr(county.getProvincename()) });
		if(provinceId == 0){//新的省份，添加
			Province province = new Province(county.getProvincename());
			provinceDao.add(province);
			provinceId = province.getId();
			result ++;
		}
		county.setProvinceid((int)provinceId);//更新省份id
			
		long cityId = cityDao.searchCountByhql(
					"select id from City where name like ? and provincename like ?",
					new Object[] { UtilHelp.setSQLLikeStr(county.getCityname()), 
							UtilHelp.setSQLLikeStr(county.getProvincename()) });
		if(cityId == 0){//新的城市，添加
			City city = new City(county.getCityname(), (int)provinceId, county.getProvincename());
			cityDao.add(city);
			cityId = city.getId();
			result ++;
		}
		county.setCityid((int)cityId);//更新城市id
		long countyId = countyDao.searchCountByhql(
				"select id from County where name like ? and cityname like ? and provincename like ?",
				new Object[] { UtilHelp.setSQLLikeStr(county.getName()), UtilHelp.setSQLLikeStr(county.getCityname()), UtilHelp.setSQLLikeStr(county.getProvincename()) });
		if(countyId == 0){//新的区县，添加
			countyDao.add(county);
			result ++;
		}
		//区县已存在，不处理
		return result;
	}

	@Override
	public County getReceiptPlace(Integer id) {
		
		return countyDao.get(id);
	}

	@Override
	public QueryResult<County> searchList(ReceiptPlaceDto receiptPlaceDto,
			int page, int pageSize, LinkedHashMap<String, String> orders) {
		StringBuilder where = new StringBuilder("");
		List<Object> params = new ArrayList<Object>(1);
		if(UtilHelp.isNotNullStr(receiptPlaceDto.getKeyword())){
			String keyword = UtilHelp.setSQLLikeStr(receiptPlaceDto.getKeyword());
			where.append(" and (name like ? or cityname like ? or provincename like ?)");
			params.add(keyword);
			params.add(keyword);
			params.add(keyword);
		}
		return countyDao.search(page, pageSize, where.toString(), params.toArray());
	}

	@Override
	public int updateReceiptPlace(County county) {
		int count = 0;
		County dbCounty = countyDao.get(county.getId());
		if(dbCounty != null){
			Province dbProvince = provinceDao.get(county.getProvinceid());
			City dbCity = cityDao.get(county.getCityid());
			//如果省份名变了
			if(null != dbProvince && !dbProvince.getName().equals(county.getProvincename())){
				//省份表更新名
				dbProvince.setName(county.getProvincename());
				//城市表更新省份名
				cityDao.updateBySql(" set provincename=? where provinceid=?", new Object[]{dbProvince.getName(),dbProvince.getId()});
				count ++;
			}
			//如果城市名变了
			if(null != dbCity && !dbCity.getName().equals(county.getCityname())){
				dbCity.setName(county.getCityname());
				count ++;
			}
			//更新到区县表
			dbCounty.setProvincename(county.getProvincename());
			dbCounty.setCityname(county.getCityname());
			dbCounty.setName(county.getName());
			dbCounty.setShortname(county.getShortname());
			count ++;
		}
		return count;
	}

}
