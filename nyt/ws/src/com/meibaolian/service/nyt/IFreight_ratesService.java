package com.meibaolian.service.nyt;

import java.util.List;

import com.meibaolian.entity.Freight_ratesEntity;
import com.meibaolian.util.exception.DataManagerException;

public interface IFreight_ratesService 
{
  
	public List<Freight_ratesEntity> search() throws DataManagerException;
	 
}
