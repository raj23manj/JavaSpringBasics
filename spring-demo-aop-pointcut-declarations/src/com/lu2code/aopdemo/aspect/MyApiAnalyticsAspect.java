package com.lu2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyApiAnalyticsAspect {
	@Before("com.lu2code.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()") // any modifier ,return type, package name, any class, any method
	public void performApiAnalytics() {	
		System.out.println("\n=====>>> Executing @Before Analytics for API");		
	}
}
