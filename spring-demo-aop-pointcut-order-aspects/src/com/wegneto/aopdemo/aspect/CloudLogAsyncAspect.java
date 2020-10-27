package com.wegneto.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CloudLogAsyncAspect {

	@Before("forDaoPackageNoGetterSetter()")
	public void logToCloudAsync() {
		System.out.println("=====>>> Logging to Cloud asynchronously");
	}

}
