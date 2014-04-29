package com.meibaolian.service.dictionary;

import java.util.List;

import com.meibaolian.entity.HighwayrateEntity;
import com.meibaolian.util.exception.DataManagerException;

public interface IHighwayrateService {
	
	public List<HighwayrateEntity> getHighwayrateList(int city, String stop) throws DataManagerException;
}
