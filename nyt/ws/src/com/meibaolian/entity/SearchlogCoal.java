package com.meibaolian.entity;

import java.math.BigDecimal;


/**
 * 搜索条件记录，统计分析用
 */

public class SearchlogCoal implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Fields

	private Integer id;
	private Integer userid;
	private String addtime;
	private Integer coaltype;
	private String coalname;
	private String buyername;
	private Integer minheatingtype;
	private Integer maxheatingtype;
	private Integer mincoalsize;
	private Integer maxcoalsize;
	private BigDecimal minsulphur;
	private BigDecimal maxsulphur;
	private BigDecimal minash;
	private BigDecimal maxash;
	private BigDecimal minmoisture;
	private BigDecimal maxmoisture;
	private BigDecimal minprice;
	private BigDecimal maxprice;
	private BigDecimal mintaxprice;
	private BigDecimal maxtaxprice;
	private Integer transportype;
	private String place;
	private String receiptplace;
	private Integer searchtype;
	private String coalsizename;
	private Integer placeid;
	private Integer startcountyid;
	private String startcountyname;
	private Integer startcityid;
	private String startcityname;
	private Integer startprvid;
	private String startprvname;
	private Integer receiptplaceid;
	private Integer stopcityid;
	private String stopcityname;
	private Integer stopprvid;
	private String stopprvname;
	private String stopshortname;
	private String keyword;
	// Constructors

	/** default constructor */
	public SearchlogCoal() {
	}

	/** minimal constructor */
	public SearchlogCoal(Integer userid, String addtime, Integer coaltype,
			String coalname, Integer searchtype) {
		this.userid = userid;
		this.addtime = addtime;
		this.coaltype = coaltype;
		this.coalname = coalname;
		this.searchtype = searchtype;
	}

	/** full constructor */
	public SearchlogCoal(Integer userid, String addtime, Integer coaltype,
			String coalname, String buyername, Integer minheatingtype,
			Integer maxheatingtype, Integer mincoalsize, Integer maxcoalsize,
			BigDecimal minsulphur, BigDecimal maxsulphur, BigDecimal minash, BigDecimal maxash,
			BigDecimal minmoisture, BigDecimal maxmoisture, BigDecimal minprice,
			BigDecimal maxprice, BigDecimal mintaxprice, BigDecimal maxtaxprice,
			Integer transportype, String place, String receiptplace,
			Integer searchtype) {
		this.userid = userid;
		this.addtime = addtime;
		this.coaltype = coaltype;
		this.coalname = coalname;
		this.buyername = buyername;
		this.minheatingtype = minheatingtype;
		this.maxheatingtype = maxheatingtype;
		this.mincoalsize = mincoalsize;
		this.maxcoalsize = maxcoalsize;
		this.minsulphur = minsulphur;
		this.maxsulphur = maxsulphur;
		this.minash = minash;
		this.maxash = maxash;
		this.minmoisture = minmoisture;
		this.maxmoisture = maxmoisture;
		this.minprice = minprice;
		this.maxprice = maxprice;
		this.mintaxprice = mintaxprice;
		this.maxtaxprice = maxtaxprice;
		this.transportype = transportype;
		this.place = place;
		this.receiptplace = receiptplace;
		this.searchtype = searchtype;
	}

	public SearchlogCoal(Integer userid, Integer coaltype, String coalname,
			Integer minheatingtype, Integer maxheatingtype,
			Integer mincoalsize, Integer maxcoalsize, BigDecimal minsulphur,
			BigDecimal maxsulphur, BigDecimal minash, BigDecimal maxash,
			BigDecimal minmoisture, BigDecimal maxmoisture,
			BigDecimal minprice, BigDecimal maxprice, BigDecimal mintaxprice,
			BigDecimal maxtaxprice, String place, String receiptplace,
			Integer searchtype, String coalsizename, Integer placeid,
			Integer startcountyid, String startcountyname, Integer startcityid,
			String startcityname, Integer startprvid, String startprvname) {
		super();
		this.userid = userid;
		this.coaltype = coaltype;
		this.coalname = coalname;
		this.minheatingtype = minheatingtype;
		this.maxheatingtype = maxheatingtype;
		this.mincoalsize = mincoalsize;
		this.maxcoalsize = maxcoalsize;
		this.minsulphur = minsulphur;
		this.maxsulphur = maxsulphur;
		this.minash = minash;
		this.maxash = maxash;
		this.minmoisture = minmoisture;
		this.maxmoisture = maxmoisture;
		this.minprice = minprice;
		this.maxprice = maxprice;
		this.mintaxprice = mintaxprice;
		this.maxtaxprice = maxtaxprice;
		this.place = place;
		this.receiptplace = receiptplace;
		this.searchtype = searchtype;
		this.coalsizename = coalsizename;
		this.placeid = placeid;
		this.startcountyid = startcountyid;
		this.startcountyname = startcountyname;
		this.startcityid = startcityid;
		this.startcityname = startcityname;
		this.startprvid = startprvid;
		this.startprvname = startprvname;
	}

	public SearchlogCoal(Integer userid, Integer coaltype, String coalname,
			Integer minheatingtype, Integer maxheatingtype,
			Integer mincoalsize, Integer maxcoalsize, BigDecimal minsulphur,
			BigDecimal maxsulphur, BigDecimal minash, BigDecimal maxash,
			BigDecimal minmoisture, BigDecimal maxmoisture,
			BigDecimal minprice, BigDecimal maxprice, BigDecimal mintaxprice,
			BigDecimal maxtaxprice, String place, String receiptplace,
			Integer searchtype, String coalsizename, Integer placeid,
			Integer startcountyid, String startcountyname, Integer startcityid,
			String startcityname, Integer startprvid, String startprvname,
			Integer receiptplaceid, Integer stopcityid, String stopcityname,
			Integer stopprvid, String stopprvname, String stopshortname) {
		super();
		this.userid = userid;
		this.coaltype = coaltype;
		this.coalname = coalname;
		this.minheatingtype = minheatingtype;
		this.maxheatingtype = maxheatingtype;
		this.mincoalsize = mincoalsize;
		this.maxcoalsize = maxcoalsize;
		this.minsulphur = minsulphur;
		this.maxsulphur = maxsulphur;
		this.minash = minash;
		this.maxash = maxash;
		this.minmoisture = minmoisture;
		this.maxmoisture = maxmoisture;
		this.minprice = minprice;
		this.maxprice = maxprice;
		this.mintaxprice = mintaxprice;
		this.maxtaxprice = maxtaxprice;
		this.place = place;
		this.receiptplace = receiptplace;
		this.searchtype = searchtype;
		this.coalsizename = coalsizename;
		this.placeid = placeid;
		this.startcountyid = startcountyid;
		this.startcountyname = startcountyname;
		this.startcityid = startcityid;
		this.startcityname = startcityname;
		this.startprvid = startprvid;
		this.startprvname = startprvname;
		this.receiptplaceid = receiptplaceid;
		this.stopcityid = stopcityid;
		this.stopcityname = stopcityname;
		this.stopprvid = stopprvid;
		this.stopprvname = stopprvname;
		this.stopshortname = stopshortname;
	}

	public SearchlogCoal(Integer userid, Integer searchtype, String receiptplace,
			Integer startcountyid, String startcountyname, Integer startcityid,
			String startcityname, Integer startprvid, String startprvname,
			Integer receiptplaceid, Integer stopcityid, String stopcityname,
			Integer stopprvid, String stopprvname) {
		super();
		this.userid = userid;
		this.searchtype = searchtype;
		this.receiptplace = receiptplace;
		this.startcountyid = startcountyid;
		this.startcountyname = startcountyname;
		this.startcityid = startcityid;
		this.startcityname = startcityname;
		this.startprvid = startprvid;
		this.startprvname = startprvname;
		this.receiptplaceid = receiptplaceid;
		this.stopcityid = stopcityid;
		this.stopcityname = stopcityname;
		this.stopprvid = stopprvid;
		this.stopprvname = stopprvname;
	}

	public SearchlogCoal(Integer userid, Integer searchtype, String keyword) {
		super();
		this.userid = userid;
		this.searchtype = searchtype;
		this.keyword = keyword;
	}

	// Property accessors
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserid() {
		return this.userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getAddtime() {
		return this.addtime;
	}

	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}

	public Integer getCoaltype() {
		return this.coaltype;
	}

	public void setCoaltype(Integer coaltype) {
		this.coaltype = coaltype;
	}

	public String getCoalname() {
		return this.coalname;
	}

	public void setCoalname(String coalname) {
		this.coalname = coalname;
	}

	public String getBuyername() {
		return this.buyername;
	}

	public void setBuyername(String buyername) {
		this.buyername = buyername;
	}

	public Integer getMinheatingtype() {
		return this.minheatingtype;
	}

	public void setMinheatingtype(Integer minheatingtype) {
		this.minheatingtype = minheatingtype;
	}

	public Integer getMaxheatingtype() {
		return this.maxheatingtype;
	}

	public void setMaxheatingtype(Integer maxheatingtype) {
		this.maxheatingtype = maxheatingtype;
	}

	public Integer getMincoalsize() {
		return this.mincoalsize;
	}

	public void setMincoalsize(Integer mincoalsize) {
		this.mincoalsize = mincoalsize;
	}

	public Integer getMaxcoalsize() {
		return this.maxcoalsize;
	}

	public void setMaxcoalsize(Integer maxcoalsize) {
		this.maxcoalsize = maxcoalsize;
	}

	public BigDecimal getMinsulphur() {
		return this.minsulphur;
	}

	public void setMinsulphur(BigDecimal minsulphur) {
		this.minsulphur = minsulphur;
	}

	public BigDecimal getMaxsulphur() {
		return this.maxsulphur;
	}

	public void setMaxsulphur(BigDecimal maxsulphur) {
		this.maxsulphur = maxsulphur;
	}

	public BigDecimal getMinash() {
		return this.minash;
	}

	public void setMinash(BigDecimal minash) {
		this.minash = minash;
	}

	public BigDecimal getMaxash() {
		return this.maxash;
	}

	public void setMaxash(BigDecimal maxash) {
		this.maxash = maxash;
	}

	public BigDecimal getMinmoisture() {
		return this.minmoisture;
	}

	public void setMinmoisture(BigDecimal minmoisture) {
		this.minmoisture = minmoisture;
	}

	public BigDecimal getMaxmoisture() {
		return this.maxmoisture;
	}

	public void setMaxmoisture(BigDecimal maxmoisture) {
		this.maxmoisture = maxmoisture;
	}

	public BigDecimal getMinprice() {
		return this.minprice;
	}

	public void setMinprice(BigDecimal minprice) {
		this.minprice = minprice;
	}

	public BigDecimal getMaxprice() {
		return this.maxprice;
	}

	public void setMaxprice(BigDecimal maxprice) {
		this.maxprice = maxprice;
	}

	public BigDecimal getMintaxprice() {
		return this.mintaxprice;
	}

	public void setMintaxprice(BigDecimal mintaxprice) {
		this.mintaxprice = mintaxprice;
	}

	public BigDecimal getMaxtaxprice() {
		return this.maxtaxprice;
	}

	public void setMaxtaxprice(BigDecimal maxtaxprice) {
		this.maxtaxprice = maxtaxprice;
	}

	public Integer getTransportype() {
		return this.transportype;
	}

	public void setTransportype(Integer transportype) {
		this.transportype = transportype;
	}

	public String getPlace() {
		return this.place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getReceiptplace() {
		return this.receiptplace;
	}

	public void setReceiptplace(String receiptplace) {
		this.receiptplace = receiptplace;
	}

	public Integer getSearchtype() {
		return this.searchtype;
	}

	public void setSearchtype(Integer searchtype) {
		this.searchtype = searchtype;
	}

	public String getCoalsizename() {
		return coalsizename;
	}

	public void setCoalsizename(String coalsizename) {
		this.coalsizename = coalsizename;
	}

	public Integer getPlaceid() {
		return placeid;
	}

	public void setPlaceid(Integer placeid) {
		this.placeid = placeid;
	}

	public Integer getStartcountyid() {
		return startcountyid;
	}

	public void setStartcountyid(Integer startcountyid) {
		this.startcountyid = startcountyid;
	}

	public String getStartcountyname() {
		return startcountyname;
	}

	public void setStartcountyname(String startcountyname) {
		this.startcountyname = startcountyname;
	}

	public Integer getStartcityid() {
		return startcityid;
	}

	public void setStartcityid(Integer startcityid) {
		this.startcityid = startcityid;
	}

	public String getStartcityname() {
		return startcityname;
	}

	public void setStartcityname(String startcityname) {
		this.startcityname = startcityname;
	}

	public Integer getStartprvid() {
		return startprvid;
	}

	public void setStartprvid(Integer startprvid) {
		this.startprvid = startprvid;
	}

	public String getStartprvname() {
		return startprvname;
	}

	public void setStartprvname(String startprvname) {
		this.startprvname = startprvname;
	}

	public Integer getReceiptplaceid() {
		return receiptplaceid;
	}

	public void setReceiptplaceid(Integer receiptplaceid) {
		this.receiptplaceid = receiptplaceid;
	}

	public Integer getStopcityid() {
		return stopcityid;
	}

	public void setStopcityid(Integer stopcityid) {
		this.stopcityid = stopcityid;
	}

	public String getStopcityname() {
		return stopcityname;
	}

	public void setStopcityname(String stopcityname) {
		this.stopcityname = stopcityname;
	}

	public Integer getStopprvid() {
		return stopprvid;
	}

	public void setStopprvid(Integer stopprvid) {
		this.stopprvid = stopprvid;
	}

	public String getStopprvname() {
		return stopprvname;
	}

	public void setStopprvname(String stopprvname) {
		this.stopprvname = stopprvname;
	}

	public String getStopshortname() {
		return stopshortname;
	}

	public void setStopshortname(String stopshortname) {
		this.stopshortname = stopshortname;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
}