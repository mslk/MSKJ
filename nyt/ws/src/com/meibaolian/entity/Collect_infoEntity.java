package com.meibaolian.entity;

/**
 * 我的收藏
 * @author Kawin
 *
 */
public class Collect_infoEntity {
	private int id;
	private int userid;
	private int type;
	private int mtype;
	private int mid;
	private String addtime;

	public Collect_infoEntity(int id, int userid, int type, int mtype, int mid,
			String addtime) {
		this.id = id;
		this.userid = userid;
		this.type = type;
		this.mtype = mtype;
		this.mid = mid;
		this.addtime = addtime;
	}

	public Collect_infoEntity() {
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public void setType(int type) {
		this.type = type;
	}

	public void setMtype(int mtype) {
		this.mtype = mtype;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}

	public int getId() {
		return id;
	}

	public int getUserid() {
		return userid;
	}

	public int getType() {
		return type;
	}

	public int getMtype() {
		return mtype;
	}

	public int getMid() {
		return mid;
	}

	public String getAddtime() {
		return addtime;
	}
}
