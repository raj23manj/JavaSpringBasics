package com.lu2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	// this is where we add all of our related advices for logging
	
	// let's start with an @Before advice

	//@Before("execution(public void addAccount())") // pointcut expression matches any method
	//@Before("execution(public void com.lu2code.aopdemo.dao.AccountDAO.addAccount())") // match particular class method
	//@Before("execution(public void add*())") //match any with add*  (public * add*())
    //@Before("execution(void add*())") //match any with add* with void return type
	//@Before("execution(* add*())")  // any
	
	// ###Arguments Type####
    //@Before("execution(* add*(com.lu2code.aopdemo.Account))")  // specific param type
    //@Before("execution(* add*(com.lu2code.aopdemo.Account, boolean))")
	//@Before("execution(* add*(com.lu2code.aopdemo.Account, ..))")
	//@Before("execution(* add*(..))") // any params 0 or more
	
	//###Packages###
	@Before("execution(* com.lu2code.aopdemo.dao.*.*(..))") // any modifier ,return type, package name, any class, any method
	public void beforeAddAccountAdvice() {
		
		System.out.println("\n=====>>> Executing @Before advice on addAccount()");
		
	}
	
	
}
