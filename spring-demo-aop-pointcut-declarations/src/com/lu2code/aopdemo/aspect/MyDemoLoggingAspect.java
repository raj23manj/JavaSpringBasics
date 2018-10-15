package com.lu2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
	
//	//#### point cut declarations ### for reusability
//	@Pointcut("execution(* com.lu2code.aopdemo.dao.*.*(..))")
//	private void forDaoPackage() {}
//	
//	
//	// match getter methods
//	@Pointcut("execution(* com.lu2code.aopdemo.dao.*.get*(..))")
//	private void getter() {}
//	
//	// match setter methods
//	@Pointcut("execution(* com.lu2code.aopdemo.dao.*.set*(..))")
//	private void setter() {}
//	
//	// combine pointcuts: include package and exclude getter/setter
//	@Pointcut("forDaoPackage() && !(getter() || setter())")
//	private void forDaoPackageNoGetterSetter () {}

	//###Packages###
//	@Before("forDaoPackage()") // any modifier ,return type, package name, any class, any method
//	public void beforeAddAccountAdvice() {	
//		System.out.println("\n=====>>> Executing @Before advice on addAccount()");		
//	}
//	
//	@Before("forDaoPackage()") // any modifier ,return type, package name, any class, any method
//	public void performApiAnalytics() {	
//		System.out.println("\n=====>>> Executing @Before Analytics for API");		
//	}
	
	
	@Before("com.lu2code.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()") // any modifier ,return type, package name, any class, any method
	public void beforeAddAccountAdvice() {	
		System.out.println("\n=====>>> Executing @Before advice on addAccount()");		
	}
	
//	@Before("forDaoPackageNoGetterSetter()") // any modifier ,return type, package name, any class, any method
//	public void performApiAnalytics() {	
//		System.out.println("\n=====>>> Executing @Before Analytics for API");		
//	}
	
	
//	@Before("forDaoPackageNoGetterSetter()") // any modifier ,return type, package name, any class, any method
//	public void loggingToCloudAsync() {	
//		System.out.println("\n=====>>> Logging to cloud");		
//	}
	
}
