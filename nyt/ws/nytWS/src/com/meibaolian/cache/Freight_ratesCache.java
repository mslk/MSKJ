package com.meibaolian.cache;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.meibaolian.entity.Freight_ratesEntity;
import com.meibaolian.service.nyt.IFreight_ratesService;
import com.meibaolian.util.UtilHelp;
import com.meibaolian.util.exception.DataManagerException;

/**
 * 海汽运价缓存
 * @author Kawin
 *
 */
public class Freight_ratesCache {
	private Freight_ratesCache(){}
	private IFreight_ratesService freight_ratesService = null;
	/*
	 *存储海汽运价键值信息
	 *键: 开始地址&结束地址(不区分先后顺序)
	 *值: 海汽运价实体
	 */
	private static Map<String, Freight_ratesEntity> frMap = new HashMap<String, Freight_ratesEntity>();

	/** 根据买卖人地址查询海汽运价,未找到返回null  
	 * @param buyerAddress 买方地址(省市区)
	 * @param sellAddress 卖方地址(省市区)
	 * @return
	 * @throws DataManagerException
	 */ 
	public Freight_ratesEntity getFreight_ratesByBuyerAddressAndSellAddress(String buyerAddress, String sellAddress) throws DataManagerException{
		if(UtilHelp.isNullStr(buyerAddress) || UtilHelp.isNullStr(sellAddress)) return null;
			
		String compositionAddress = Freight_ratesEntity.creatCompositionAddress(buyerAddress, sellAddress);
		Freight_ratesEntity vo = frMap.get(compositionAddress);
		if(null == vo){
			frMap.clear();//先清空,再put
			List<Freight_ratesEntity> ls = freight_ratesService.search();
			for (Freight_ratesEntity freight_ratesEntity : ls) {
				String _compositionAddress1 = Freight_ratesEntity.creatCompositionAddress(freight_ratesEntity.getStart(), freight_ratesEntity.getTo());  
				String _compositionAddress2 = Freight_ratesEntity.creatCompositionAddress(freight_ratesEntity.getTo(), freight_ratesEntity.getStart());
				 frMap.put(_compositionAddress1, freight_ratesEntity);
				 frMap.put(_compositionAddress2, freight_ratesEntity);
			}
		}
		return frMap.get(compositionAddress);
	}

	public void setFreight_ratesService(IFreight_ratesService freight_ratesService) {
		this.freight_ratesService = freight_ratesService;
	}

}
