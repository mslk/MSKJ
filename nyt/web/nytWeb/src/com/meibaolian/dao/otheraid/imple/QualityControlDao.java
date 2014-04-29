package com.meibaolian.dao.otheraid.imple;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.dao.base.imple.BaseDao;
import com.meibaolian.dao.otheraid.IQualityControlDao;
import com.meibaolian.dto.QualityControlDto;
import com.meibaolian.entity.QualityControl;
import com.meibaolian.util.UtilHelp;

public class QualityControlDao extends BaseDao<QualityControl> implements IQualityControlDao {

	@Override
	public QueryResult<QualityControl> searchList(
			QualityControlDto qualityControlDto, int page, int pageSize,
			LinkedHashMap<String, String> orders) {
		StringBuilder where = new StringBuilder("");
		List<Object> params = new ArrayList<Object>(1); 
		if(UtilHelp.isNotNullStr(qualityControlDto.getKeyword())){
			where.append(" and number like ?");
			params.add(UtilHelp.setSQLLikeStr(qualityControlDto.getKeyword().trim()));
		}
		return super.search(page, pageSize, where.toString(), params.toArray(), orders);
	}

}
