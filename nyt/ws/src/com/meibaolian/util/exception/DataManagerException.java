package com.meibaolian.util.exception;

/**操作数据库 异常
 *@Title DataManagerException.java
 *@package com.mythlink.util.exception
 *@author chenpeng email:chen422520@163.com
 *@Description TODO
 *@data Jul 13, 2012 9:55:49 AM
 *@version
 **/
public class DataManagerException extends Exception
{
     /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
      * 构造方法
      */
	public DataManagerException()
	{
		super();
	}

    /**
     * 构造方法
     * @param message
     * @param cause
     */
	public DataManagerException(String message, Throwable cause)
	{
		super(message, cause);
	}

	/**
	 * 构造方法
	 * @param message
	 */
	public DataManagerException(String message)
	{
		super(message);
	}

	/**
	 * 构造方法
	 * @param cause
	 */
	public DataManagerException(Throwable cause)
	{
		super(cause);
	}

	
	
}
