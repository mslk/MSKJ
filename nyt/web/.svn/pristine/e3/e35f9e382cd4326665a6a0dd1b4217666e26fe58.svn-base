package com.meibaolian.service.otheraid.imple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.meibaolian.dao.otheraid.IImportDateDao;
import com.meibaolian.service.otheraid.IImportDateService;
import com.meibaolian.util.UtilHelp;

public class ImportDateService implements IImportDateService {

	private IImportDateDao importDateDao;
	//
	public void setImportDateDao(IImportDateDao importDateDao) {
		this.importDateDao = importDateDao;
	}

	//
	@Override
	public void importAreaData(List<String[]> dataList) {
		
	}

	@Override
	public void importPlaceData(List<String[]> dataList, int type) {

	}

	@Override
	public List<Integer> importRateData(List<String[]> dataList, int type) {
		
		String rateTableName = null;
		String rateClassName = null;
		if(type == 0){
			rateTableName = "railwayrate";
			rateClassName = "RailwayRate";
		}else{
			rateTableName = "highwayrate";
			rateClassName = "HighwayRate";
		}
		List<Integer> errDataList = new ArrayList<Integer>(1);
		String[] tmp = null;
		String[] arr = null;
		boolean flag = false;
		//1.验证发货地表  2.验证到货地表  3.验证运价表
		for(int i=0; i < dataList.size(); i++ ){
			arr = Arrays.copyOfRange(dataList.get(i),0,dataList.get(i).length);
			tmp = Arrays.copyOfRange(arr, 0, 6);
			flag = checkPlaceInfo(tmp);
			arr = setSqlLikeStr(arr);
			if(flag){
				tmp = Arrays.copyOfRange(arr, 0, 3);
				long count = importDateDao.searchCountByhql("select count(countyname) from DeliveryArea where countyname like ? and cityname like ? and provincename like ?", tmp);
				if(count == 0){//发货地不存在
					flag = false;
				}else{
					tmp = Arrays.copyOfRange(arr, 3, 6);
					count = importDateDao.searchCountByhql("select count(name) from County where name like ? and cityname like ? and provincename like ?", tmp);
					if(count == 0){//收货地不存在
						flag = false;
					}else{
						tmp = Arrays.copyOfRange(arr, 0, 6);
						//id
						count = importDateDao.searchCountByhql("select id from "+ rateClassName +" where start like ? and startcityname like ? and startprvname like ? and stop like ? and stopcityname like ? and stopprvname like ?", tmp);
						arr = dataList.get(i);//
						if(count == 0){//运价数据不存在，添加
							count = importDateDao.executeUpdateSql("insert into "+ rateTableName +" (start,startcityname,startprvname,stop,stopcityname,stopprvname,rate,distance) values(?,?,?,?,?,?,?,?)", arr);
						}else{//更新已有运价数据
							arr = Arrays.copyOf(arr, arr.length+1);
							arr[arr.length-1] = String.valueOf(count);
							count = importDateDao.executeUpdateSql("update "+ rateTableName +" set start=?,startcityname=?,startprvname=?,stop=?,stopcityname=?,stopprvname=?,rate=?,distance=? where id=?", arr);
							count++;//若值未变，不会更新，返回0
						}
						if(count == 0){
							flag = false;
						}
					}
				}
			}
			if(!flag){
				errDataList.add(i+2);//第一行为标题
			}
		}
		return errDataList;
	}

	@Override
	public void importStationData(List<String[]> dataList) {
		
	}
	/**
	 * 验证起止地信息
	 * @param placeArr
	 * @return
	 */
	private boolean checkPlaceInfo(String[] placeArr){
		if(placeArr == null || placeArr.length == 0){
			return false;
		}
		for(int i=0; i < placeArr.length; i++ ){
			if(!UtilHelp.isNotNullStr(placeArr[i])){
				return false;
			}
		}
		return true;
	}
	/**
	 * 为起止地信息字段值前后加上"%"，以作模糊匹配
	 * @param placeArr
	 * @return
	 */
	private String[] setSqlLikeStr(String[] placeArr){
		for(int i=0; i < placeArr.length; i++ ){
			placeArr[i] = UtilHelp.setSQLLikeStr(placeArr[i]);
		}
		return placeArr;
	}
}
