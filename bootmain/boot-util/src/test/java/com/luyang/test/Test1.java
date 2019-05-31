package com.luyang.test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;

import com.luyang.annotation.InitFields;
import com.luyang.util.AnnotationUtil;

public class Test1 {
	@Test
	public void test1() {

		A a = new A();

		Method[] methods = A.class.getMethods();

		for (Method method : methods) {
			if (method.isAnnotationPresent(InitFields.class)) {
				System.out.println(method.getName());
				InitFields init = method.getAnnotation(InitFields.class);
				try {
					method.invoke(a, init.valueString());
				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		System.out.println(a.getAaa());
	}

	@Test
	public void test2() {
		A a = (A) AnnotationUtil.CreateObj(A.class);
		System.out.println(a);
	}
}
