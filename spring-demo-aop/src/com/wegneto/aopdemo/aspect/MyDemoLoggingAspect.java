package com.wegneto.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
	@Before("execution(* add*(com.wegneto.aopdemo.Account))")
	public void beforeAddAccountAdvice() {
		System.out.println("=====>>> Executing @Before advice on add*(Account)");
	}

}