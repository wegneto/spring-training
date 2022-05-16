package com.wegneto.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DemoLoggingAspect {
	
	@Before("execution(* com.wegneto.aopdemo.dao.*.*(..))")
	public void beforeAddAccountAdvice() {
		System.out.println("=====>>> Executing @Before advice on com.wegneto.aopdemo.dao.*.*(..)");
	}

}