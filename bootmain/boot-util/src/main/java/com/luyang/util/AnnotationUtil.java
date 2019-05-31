package com.luyang.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import com.luyang.annotation.InitFields;

public class AnnotationUtil {
	public static Object CreateObj(Class<?> clazz) {
		Object o=null;
		try {
			o = clazz.newInstance();
		} catch (InstantiationException | IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Method[] methods = o.getClass().getMethods();
		for (Method method : methods) {
			if (method.isAnnotationPresent(InitFields.class)) {
				InitFields InitFields = method.getAnnotation(InitFields.class);
				try {
					method.invoke(o, InitFields.valueString());			
				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		Field[] fields=o.getClass().getDeclaredFields();
		for(Field field:fields){
			if(field.isAnnotationPresent(InitFields.class)){
				InitFields InitFields = field.getAnnotation(InitFields.class);
				try {
					field.setAccessible(true);
					if(field.getGenericType().toString().contains(InitFields.valueString().getClass().toString())){
						System.out.println(1);
						field.set(o, InitFields.valueString());	
					}else{
						System.out.println(2);
						field.set(o, InitFields.valueInt());
					}			
				} catch (IllegalArgumentException | IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return o;
	}
	
	
}
