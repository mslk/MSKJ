package com.meibaolian.util.exception;
/**
 * 没有对应的jdbctemplate
 * @author Administrator
 *
 */
public class NoJdbcTemplateException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    /**
     *   构造方法
     */
	public NoJdbcTemplateException() {
		super();
	}
/**
 *   构造方法
 * @param message
 * @param cause
 */
	public NoJdbcTemplateException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 *   构造方法
	 * @param message
	 */
	public NoJdbcTemplateException(String message) {
		super(message);
	}

	/**
	 *   构造方法
	 * @param cause
	 */
	public NoJdbcTemplateException(Throwable cause) {
		super(cause);
	}
	
	
	
	
	
	

}
