package com.luyang.intercept;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TestIntercept {
	@Pointcut("execution(* com.luyang.controller.*.*(..))")
	public void Test(){}
	
	@Before(value = "Test()")
	public void before(){
		System.out.println("before");
	}
	
	@After(value = "Test()")
	public void after(){
		System.out.println("after");
	}
	
	@AfterReturning(value = "Test()")
	public void afterReturning(){
		System.out.println("afterReturning");
	}
	
	@AfterThrowing(value = "Test()")
	public void afterThrowing(){
		System.out.println("afterThrowing");
	}
}
