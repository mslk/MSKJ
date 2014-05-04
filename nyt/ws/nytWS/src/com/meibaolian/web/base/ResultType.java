package com.meibaolian.web.base;
/**
 * 操作结果
 * @author Administrator
 *
 */
public enum ResultType {
	
	/**
	 * 操作成功 
	 */
	SUCCESS("000"),
	/**
	 * 参数异常
	 */
	PARAMTER("001"),
	/**
	 * 验证码错误
	 */
	CODEERROR("002"),
	/**
	 * 用户或密码错误
	 */
	USERERROR("003"),
	/**
	 * 账号被禁用
	 */
	USEREDISABLED("006"), 
	/**
	 * 用户已设置密码,不能通过验证码登录
	 */
	USEREHAVEPWD("007"),
	/**
	 * 数据已存在
	 */
	DATAEXIST("008"),
	/**
	 * 禁止访问
	 */
	FORBIDDEN("009"),
	/**
	 * 回话超时
	 */
	TIMEOUT("098"),
	/**
	 * 无数据
	 */
	NODATA("099"),
	/**
	 * 操作失败
	 */
	SERVERFAIL("100");	
	
	private ResultType(String value){
	  this.value=value;	
	}
	
	private String value;

	
	@Override
	public String toString(){
		return value;
	}
}
