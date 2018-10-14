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
	//@Before("execution(public void com.lu2code.aopdemo.dao.AccountDAO.addAccount())") // match particulat class method
	//@Before("execution(public void add*())") //match any with add*  (public * add*())
    //@Before("execution(void add*())") //match any with add* with void return type
	@Before("execution(* add*())")  // any
	public void beforeAddAccountAdvice() {
		
		System.out.println("\n=====>>> Executing @Before advice on addAccount()");
		
	}
	
	
}
