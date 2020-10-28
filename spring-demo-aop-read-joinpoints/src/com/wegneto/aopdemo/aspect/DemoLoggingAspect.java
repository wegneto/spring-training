package com.wegneto.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class DemoLoggingAspect {

	@Before("com.wegneto.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice() {
		System.out.println("=====>>> Executing @Before advice on com.wegneto.aopdemo.dao.*.*(..)");
	}

}