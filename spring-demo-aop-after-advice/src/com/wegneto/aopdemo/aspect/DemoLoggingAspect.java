package com.wegneto.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
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
	
	@After("execution(* com.wegneto.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinnalyFindAccountsAdvice(JoinPoint joinPoint) {
		String method = joinPoint.getSignature().toShortString();
		System.out.println("\n====>> Executing @After (finally) on method: " + method);
	}
	
	@AfterThrowing(
			pointcut = "execution(* com.wegneto.aopdemo.dao.AccountDAO.findAccounts(..))",
			throwing = "exception")
	public void afterThrowingFindAccountAdvice(JoinPoint joinPoint, Throwable exception) {
		String method = joinPoint.getSignature().toShortString();
		System.out.println("\n====>> Executing @AfterThrowing on method: " + method);
		
		System.out.println("\n====>> exception is: " + exception);
	}
	
	
	@AfterReturning(pointcut="execution(* com.wegneto.aopdemo.dao.AccountDAO.findAccounts(..))",
			returning="result")
	public void afterReturningFindAccountAdvice(JoinPoint joinPoint, List<Account> result) {
		String method = joinPoint.getSignature().toShortString();
		System.out.println("\n====>> Executing @AfterReturning on method: " + method);
		
		System.out.println("\n====>> result is: " + result);
		
		convertAccountNamesToUpperCase(result);
	}

	private void convertAccountNamesToUpperCase(List<Account> result) {
		for (Account account : result) {
			account.setName(account.getName().toUpperCase());
		}
	}

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