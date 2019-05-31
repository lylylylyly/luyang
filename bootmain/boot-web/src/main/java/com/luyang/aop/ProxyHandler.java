package com.luyang.aop;

import org.springframework.aop.framework.AopContext;

public class ProxyHandler{
	public static Object getProxy(){
		return AopContext.currentProxy();
	}
}
