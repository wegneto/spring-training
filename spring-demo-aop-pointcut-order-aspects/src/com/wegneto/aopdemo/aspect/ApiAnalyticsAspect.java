package com.wegneto.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ApiAnalyticsAspect {

	@Before("forDaoPackageNoGetterSetter()")
	public void performApiAnalytics() {
		System.out.println("=====>>> Performing analytics operation");
	}

}
