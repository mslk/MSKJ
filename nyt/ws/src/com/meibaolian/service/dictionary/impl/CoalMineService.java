package com.meibaolian.service.dictionary.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.meibaolian.dao.dictionary.ICoalMineDao;
import com.meibaolian.entity.CoalMine;
import com.meibaolian.entity.CoalMineJson;
import com.meibaolian.entity.MinCoalMine;
import com.meibaolian.service.dictionary.ICoalMineService;
import com.meibaolian.util.exception.DataManagerException;

public class CoalMineService implements ICoalMineService {
	
	private ICoalMineDao coalMineDao;
	
	@Override
	public List<CoalMineJson> getCoalMineJsonList() throws DataManagerException {

		List<CoalMine> list = coalMineDao.getCoalMineList();
		
		if(list != null && !list.isEmpty()){
			
			Map<Integer,CoalMineJson> map = new HashMap<Integer,CoalMineJson>();//煤矿
			CoalMineJson stationJson = null;//站台
			CoalMineJson coalYardJson = null;//煤场
			List<CoalMineJson> cmjList = new ArrayList<CoalMineJson>();
			
			for(CoalMine coalMine: list){
				
				if(coalMine.getType() == 0){
					CoalMineJson coalMineJson = map.get(coalMine.getCountyid());
					if(coalMineJson == null){
						coalMineJson = new CoalMineJson();
						coalMineJson.setCountyid(coalMine.getCountyid());
						coalMineJson.setCounty(coalMine.getCounty());
						coalMineJson.setType(coalMine.getType());
						map.put(coalMine.getCountyid(), coalMineJson);
						cmjList.add(coalMineJson);
					}
					coalMineJson.getList().add(new MinCoalMine(coalMine));
				}
				if(coalMine.getType() == 1){
					if(stationJson == null){
						stationJson = new CoalMineJson();
						stationJson.setCountyid(coalMine.getCountyid());
						stationJson.setCounty("站台");
						stationJson.setType(coalMine.getType());
						cmjList.add(stationJson);
					}
					stationJson.getList().add(new MinCoalMine(coalMine));
				}
				if(coalMine.getType() == 2){
					if(coalYardJson == null){
						coalYardJson = new CoalMineJson();
						coalYardJson.setCountyid(coalMine.getCountyid());
						coalYardJson.setCounty("煤场");
						coalYardJson.setType(coalMine.getType());
						cmjList.add(coalYardJson);
					}
					coalYardJson.getList().add(new MinCoalMine(coalMine));
				}
			}
			map.clear();
			return cmjList;
		}
		return null;
	}

	public void setCoalMineDao(ICoalMineDao coalMineDao) {
		this.coalMineDao = coalMineDao;
	}

}
