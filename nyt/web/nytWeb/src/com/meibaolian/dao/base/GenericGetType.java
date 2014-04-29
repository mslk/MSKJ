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

	@SuppressWarnings("unchecked")
	public static Class getGenericType(Class clazz,int index){
		
		Type type=clazz.getGenericSuperclass();
		
		if(!( type instanceof ParameterizedType)){
			return Object.class;
		}
		
		Type [] types=((ParameterizedType)type).getActualTypeArguments();
		
		if(index>types.length || index<0){
			throw new RuntimeException("没有这个类");
		}
		if(!(types[index] instanceof Class)){
			return Object.class;
		}
		
		return (Class)types[index];
	}
	
	@SuppressWarnings("unchecked")
	public static Class getGenericType(Class cla){
	  return	getGenericType(cla,0);
	}
}
