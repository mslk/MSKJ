package com.meibaolian.service.receiptplace;

import java.util.LinkedHashMap;

import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.dto.ReceiptPlaceDto;
import com.meibaolian.entity.County;

public interface IReceiptPlaceService {
	
	public QueryResult<County> searchList(ReceiptPlaceDto receiptPlaceDto, int page, int pageSize, LinkedHashMap<String, String> orders);
	
	public County getReceiptPlace(Integer id);
	 
	public int updateReceiptPlace(County county);
	
	public int addReceiptPlace(County county);
}
