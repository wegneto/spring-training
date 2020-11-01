package com.wegneto.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class CloudLogAsyncAspect {

	@Before("com.wegneto.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
	public void logToCloudAsync() {
		System.out.println("=====>>> Logging to Cloud asynchronously");
	}

}
