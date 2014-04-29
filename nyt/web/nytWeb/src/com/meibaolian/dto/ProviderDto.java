package com.meibaolian.dto;


public class ProviderDto {
	
	private String keyword;//关键字
	private Integer coaltype;//煤类型
	private String coalname;//煤类型名称
	private String begindate;//开始日期
	private String enddate;//结束日期
	private Integer coalsize;//煤粒度
	private String coalsizename;//煤粒度名称
	private Integer minheating;//最小发热量
	private Integer maxheating;//最大发热量
	private Double sulphur;//硫分
	private Double ash;//灰分
	private Double moisture;//全水
	private Integer status;//状态
	
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public Integer getCoaltype() {
		return coaltype;
	}
	public void setCoaltype(Integer coaltype) {
		this.coaltype = coaltype;
	}
	public String getBegindate() {
		return begindate;
	}
	public void setBegindate(String begindate) {
		this.begindate = begindate;
	}
	public String getEnddate() {
		return enddate;
	}
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}
	public String getCoalname() {
		return coalname;
	}
	public void setCoalname(String coalname) {
		this.coalname = coalname;
	}
	public Integer getCoalsize() {
		return coalsize;
	}
	public void setCoalsize(Integer coalsize) {
		this.coalsize = coalsize;
	}
	public String getCoalsizename() {
		return coalsizename;
	}
	public void setCoalsizename(String coalsizename) {
		this.coalsizename = coalsizename;
	}
	public Integer getMinheating() {
		return minheating;
	}
	public void setMinheating(Integer minheating) {
		this.minheating = minheating;
	}
	public Integer getMaxheating() {
		return maxheating;
	}
	public void setMaxheating(Integer maxheating) {
		this.maxheating = maxheating;
	}
	public Double getSulphur() {
		return sulphur;
	}
	public void setSulphur(Double sulphur) {
		this.sulphur = sulphur;
	}
	public Double getAsh() {
		return ash;
	}
	public void setAsh(Double ash) {
		this.ash = ash;
	}
	public Double getMoisture() {
		return moisture;
	}
	public void setMoisture(Double moisture) {
		this.moisture = moisture;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
}
