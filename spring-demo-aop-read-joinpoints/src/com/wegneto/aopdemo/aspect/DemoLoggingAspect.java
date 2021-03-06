package com.wegneto.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.wegneto.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class DemoLoggingAspect {

	@Before("com.wegneto.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint joinPoint) {
		System.out.println("=====>>> Executing @Before advice on method");
		
		//display the method signature
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		System.out.println("Method Signature: " + methodSignature);
		
		//display method arguments
		
		//get arguments
		Object[] args = joinPoint.getArgs();
		
		//loop arguments
		for (Object arg : args) {
			System.out.println(arg);
			
			if(arg instanceof Account) {
				Account account = (Account) arg;
				System.out.println("Account name: " + account.getName());
				System.out.println("Account level: " + account.getLevel());
			}
		}
	}
}