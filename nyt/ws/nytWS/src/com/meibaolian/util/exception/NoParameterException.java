package com.meibaolian.util.exception;

/**
 * 动态产生  sql 中  values（）异常
 *
 */
public class NoParameterException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 构造方法
	 */
	@SuppressWarnings("unused")
	private NoParameterException() {
		super();
	}

	/**
	 * 构造方法
	 * @param message
	 * @param cause
	 */
	@SuppressWarnings("unused")
	private NoParameterException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * 构造方法
	 * @param message
	 */
	public NoParameterException(String message) {
		super(message);
	}

	/**
	 * 构造方法
	 * @param cause
	 */
	@SuppressWarnings("unused")
	private NoParameterException(Throwable cause) {
		super(cause);
	}
	
	
	

}
