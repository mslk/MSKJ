package com.meibaolian.action.coalparticlesize;

import com.meibaolian.action.base.BaseAction;
import com.meibaolian.entity.CoalParticleSize;
import com.meibaolian.service.coalparticlesize.ICoalParticleSizeService;

public class CoalParticleSizeManager extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	ICoalParticleSizeService coalParticleSizeService;

	private String coalTypeName;

	private int coalTypeId;

	private int particleSizeId;

	private String particleSizeName;

	public int getParticleSizeId() {
		return particleSizeId;
	}

	public void setParticleSizeId(int particleSizeId) {
		this.particleSizeId = particleSizeId;
	}

	public String getCoalTypeName() {
		return coalTypeName;
	}

	public void setCoalTypeName(String coalTypeName) {
		this.coalTypeName = coalTypeName;
	}

	public int getCoalTypeId() {
		return coalTypeId;
	}

	public void setCoalTypeId(int coalTypeId) {
		this.coalTypeId = coalTypeId;
	}

	public String getParticleSizeName() {
		return particleSizeName;
	}

	public void setParticleSizeName(String particleSizeName) {
		this.particleSizeName = particleSizeName;
	}

	public void setCoalParticleSizeService(
			ICoalParticleSizeService coalParticleSizeService) {
		this.coalParticleSizeService = coalParticleSizeService;
	}

	public String add() {

		String messageValue = "添加煤种粒度失败！";
		String targetUrlValue = "controller/coalparticlesize/add.jsp";

		if (coalTypeId > 0 && particleSizeName != null
				&& !"".equals(particleSizeName)) {
			targetUrlValue = "coal/coalParticleSizeSearch.action";
			if (coalParticleSizeService.searchByCoalParticleSizeName(
					coalTypeId, particleSizeName) == 0) {
				coalParticleSizeService
						.addCoalParticleSize(new CoalParticleSize(coalTypeId,
								particleSizeName));
				messageValue = "添加煤种粒度成功！";
			} else {
				messageValue = "粒度已经在此煤种中存在,添加粒度失败！";
			}
		}
		saveMessage(messageValue, targetUrlValue);

		return MESSAGE;
	}

	public String delete() {
		String messageValue = "删除煤种粒度失败！";
		String targetUrlValue = "coal/coalParticleSizeSearch.action";
		if (particleSizeId > 0) {
			coalParticleSizeService.deleteCoalParticleSize(particleSizeId);
			messageValue = "删除煤种粒度成功！";
		}
		saveMessage(messageValue, targetUrlValue);

		return MESSAGE;
	}

}
