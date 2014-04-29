package com.meibaolian.util.exception;

/**
 * 没有对应的表exception
 * @author Administrator
 *
 */
public class NoTableRuleException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 构造方法
	 */
	public NoTableRuleException() {
		super();
	}

	/**
	 * 构造方法
	 * @param message
	 * @param cause
	 */
	public NoTableRuleException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * 构造方法
	 * @param message
	 */
	public NoTableRuleException(String message) {
		super(message);
	}

	/**
	 * 构造方法
	 * @param cause
	 */
	public NoTableRuleException(Throwable cause) {
		super(cause);
	}

	
	
	
}
