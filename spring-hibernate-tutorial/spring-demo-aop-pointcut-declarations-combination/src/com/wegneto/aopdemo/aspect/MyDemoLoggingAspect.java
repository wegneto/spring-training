package com.wegneto.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
	@Pointcut("execution(* com.wegneto.aopdemo.dao.*.*(..))")
	private void forDaoPackage() {}
	
	@Pointcut("execution(* com.wegneto.aopdemo.dao.*.get*(..))")
	private void forGetterMethods() {}
	
	@Pointcut("execution(* com.wegneto.aopdemo.dao.*.set*(..))")
	private void forSetterMethods() {}
	
	@Pointcut("forDaoPackage() && !(forGetterMethods() || forSetterMethods())")
	private void forDaoPackageNoGetterSetter() {
	}
	
	@Before("forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice() {
		System.out.println("\n=====>>> Executing @Before advice on com.wegneto.aopdemo.dao.*.*(..)");
	}
	
	@Before("forDaoPackageNoGetterSetter()")
	public void performSomeOperation() {
		System.out.println("=====>>> Performing some operation");
	}

}