package com.meibaolian.dao.base;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
/**
 * 
 * @author 取得泛型类型
 *
 */
public class GenericGetType
{

	/**
	*@author chenpeng email:chen422520@163.com
	*@param clazz
	*@param index
	*@Description 
	*@date Jul 11, 2012 5:29:58 PM
	*@return  第一个泛型的class
	*@version
	**/
	@SuppressWarnings("rawtypes")
	public static Class getGenericType(Class clazz,int index){
		
		Type type=clazz.getGenericSuperclass();
		
		if(!( type instanceof ParameterizedType)){
			return Object.class;
		}
		
		Type [] types=((ParameterizedType)type).getActualTypeArguments();
		
		if(index>types.length || index<0){
			throw new RuntimeException(" 没有这个类");
		}
		
		if(!(types[index] instanceof Class)){
			return Object.class;
		}
		
		return (Class)types[index];
	}
	
	
	/**
	 * 
	*@author chenpeng email:chen422520@163.com
	*@param cla
	*@Description TODO
	*@date Jul 11, 2012 5:31:32 PM
	*@version
	*
	 */
	@SuppressWarnings({ "rawtypes", "javadoc" })
	public static Class getGenericType(Class cla){
	  return	getGenericType(cla,0);
	}
}
