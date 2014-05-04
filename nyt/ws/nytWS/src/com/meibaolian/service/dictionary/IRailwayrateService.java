package com.meibaolian.service.dictionary;

import java.util.List;

import com.meibaolian.entity.Railwayrate;
import com.meibaolian.util.exception.DataManagerException;

public interface IRailwayrateService {
	
	public List<Railwayrate> getRailwayrateList(int city, String stop) throws DataManagerException;
}
