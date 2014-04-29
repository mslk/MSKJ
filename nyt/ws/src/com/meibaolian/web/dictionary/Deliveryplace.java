package com.meibaolian.web.dictionary;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.meibaolian.entity.DeliveryplaceChildEntity;
import com.meibaolian.entity.DeliveryplaceEntity;
import com.meibaolian.entity.DeliveryplaceJsonEntity;
import com.meibaolian.entity.DeliveryplaceParentEntity;
import com.meibaolian.service.dictionary.IDeliveryplaceService;
import com.meibaolian.util.UtilHelp;
import com.meibaolian.util.exception.DataManagerException;
import com.meibaolian.web.base.BaseServlet;
import com.meibaolian.web.base.ResultType;
import com.meibaolian.web.base.WebUtil;

public class Deliveryplace extends BaseServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	IDeliveryplaceService deliveryplaceService;

	public void setDeliveryplaceService(
			IDeliveryplaceService deliveryplaceService) {
		this.deliveryplaceService = deliveryplaceService;
	}

	Logger logger = Logger.getLogger(Deliveryplace.class);

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		int countyid = UtilHelp.strToInt(request.getParameter("countyid"));

		ResultType result = ResultType.SERVERFAIL;
		DeliveryplaceJsonEntity jsonEntity = null;
		if (countyid > 0) {
			try {
				List<DeliveryplaceEntity> list = deliveryplaceService
						.searchByCountId(countyid);
				if (list != null && list.size() > 0) {
					// type: 0 煤矿,1 站台,2 煤场
					jsonEntity = new DeliveryplaceJsonEntity();
					jsonEntity.setCountyid(countyid);
					for (DeliveryplaceEntity entity : list) {
						DeliveryplaceParentEntity parent = null;

						for (DeliveryplaceParentEntity child : jsonEntity
								.getList()) {
							if (child.getType() == entity.getType()) {
								parent = child;
								break;
							}
						}

						if (parent == null) {
							parent = new DeliveryplaceParentEntity();
							parent.setType(entity.getType());
							parent.setTypeName(entity.getTypeName());
							jsonEntity.getList().add(parent);
//							String typeName = "";
//							if (entity.getType() == 0) {
//								typeName = "煤矿";
//							} else if (entity.getType() == 1) {
//								typeName = "站台";
//							} else if (entity.getType() == 2) {
//								typeName = "煤场";
//							}
//							if (!"".equals(typeName)) {
//							}
						}
//						private Integer stationid;
						DeliveryplaceChildEntity child=new DeliveryplaceChildEntity();
						child.setStationid(entity.getStationid());
						child.setName(entity.getName());
						child.setShortname(entity.getShortname());
						child.setCountyid(entity.getCountyid());
						child.setType(entity.getType());
						child.setHeating(entity.getHeating());
						child.setSulphur(entity.getSulphur());
						child.setAsh(entity.getAsh());
						child.setMoisture(entity.getMoisture());
						parent.getList().add(child);
					}

					result = ResultType.SUCCESS;
				} else {
					result = ResultType.NODATA;
				}
			} catch (DataManagerException e) {
				logger.error(e);
			}

		} else {
			result = ResultType.PARAMTER;
		}

		WebUtil.outputMsgObjJson(response, result, jsonEntity);
	}

}
