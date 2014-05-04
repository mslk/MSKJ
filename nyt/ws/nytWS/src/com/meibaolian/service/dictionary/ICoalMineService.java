package com.meibaolian.service.dictionary;

import java.util.List;

import com.meibaolian.entity.CoalMineJson;
import com.meibaolian.util.exception.DataManagerException;

public interface ICoalMineService {
	
	public List<CoalMineJson> getCoalMineJsonList() throws DataManagerException;
}
