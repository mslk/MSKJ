package com.meibaolian.util.exception;

/**
 * 没有数据源
 * @author Administrator
 *
 */
public class NoDataSourceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 *   构造方法
	 */
	public NoDataSourceException() {
		super();
	}

	/**
	 *   构造方法
	 * @param message
	 * @param cause
	 */
	public NoDataSourceException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 *   构造方法
	 * @param message
	 */
	public NoDataSourceException(String message) {
		super(message);
	}

	/**
	 *   构造方法
	 * @param cause
	 */
	public NoDataSourceException(Throwable cause) {
		super(cause);
	}
	
	
	

}
