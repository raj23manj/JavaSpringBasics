//package com.lu2code.aopdemo.aspect;
//
//
//import java.util.List;
//import java.util.logging.Logger;
//
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.After;
//import org.aspectj.lang.annotation.AfterReturning;
//import org.aspectj.lang.annotation.AfterThrowing;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.aspectj.lang.reflect.MethodSignature;
//import org.springframework.core.annotation.Order;
//import org.springframework.stereotype.Component;
//
//import com.lu2code.aopdemo.Account;
//
//@Aspect
//@Component
//@Order(2)
//public class MyDemoLoggingAspectOriginal { 
//
//	
////	//#### point cut declarations ### for reusability
////	@Pointcut("execution(* com.lu2code.aopdemo.dao.*.*(..))")
////	private void forDaoPackage() {}
////	
////	
////	// match getter methods
////	@Pointcut("execution(* com.lu2code.aopdemo.dao.*.get*(..))")
////	private void getter() {}
////	
////	// match setter methods
////	@Pointcut("execution(* com.lu2code.aopdemo.dao.*.set*(..))")
////	private void setter() {}
////	
////	// combine pointcuts: include package and exclude getter/setter
////	@Pointcut("forDaoPackage() && !(getter() || setter())")
////	private void forDaoPackageNoGetterSetter () {}
//
//	//###Packages###
////	@Before("forDaoPackage()") // any modifier ,return type, package name, any class, any method
////	public void beforeAddAccountAdvice() {	
////		System.out.println("\n=====>>> Executing @Before advice on addAccount()");		
////	}
////	
////	@Before("forDaoPackage()") // any modifier ,return type, package name, any class, any method
////	public void performApiAnalytics() {	
////		System.out.println("\n=====>>> Executing @Before Analytics for API");		
////	}
//	
//	
//	@Before("com.lu2code.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()") // any modifier ,return type, package name, any class, any method
//	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {	
//		System.out.println("\n=====>>> Executing @Before advice on addAccount()");	
//		
//		// display the method signature
//		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
//		System.out.println("\nMethod SIgnature: " + methodSig);
//		
//		// display method arguments
//		
//		Object[] args = theJoinPoint.getArgs();
//		
//		for(Object tempArg : args) {
//			System.out.println(tempArg);
//			
//			if (tempArg instanceof Account)  {
//				// downcast and print Account specific stuff
//				Account theAccount = (Account) tempArg;
//				
//				System.out.println("accountName :" + theAccount.getName());
//				System.out.println("accountLevel :" + theAccount.getLevel());
//				
//			}
//		}
//	}
//	 
////	@Before("forDaoPackageNoGetterSetter()") // any modifier ,return type, package name, any class, any method
////	public void performApiAnalytics() {	
////		System.out.println("\n=====>>> Executing @Before Analytics for API");		
////	}
//	
//	
////	@Before("forDaoPackageNoGetterSetter()") // any modifier ,return type, package name, any class, any method
////	public void loggingToCloudAsync() {	
////		System.out.println("\n=====>>> Logging to cloud");		
////	}
//	
//	
//	// add a new advice for @AfterReturning on the findAccounts method
//	@AfterReturning(
//			pointcut="execution(* com.lu2code.aopdemo.dao.AccountDAO.findAccounts(..))",
//			returning="result") // here returning should be same as param below
//	public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result) {
//		
//		String method = theJoinPoint.getSignature().toShortString();
//		System.out.println("\n ========> Executing @AfterReturning on method: " + method);
//		
//		System.out.println("\n ========> result is: " + result);
//		
//		// post processing data
//		// convert account names to upper case
//		convertAccountNamesToUpperCase(result);
//		
//		System.out.println("\n ========> result is: " + result);
//		
//	}
//
//	private void convertAccountNamesToUpperCase(List<Account> result) {
//		for(Account tempAccount : result) {
//			String theUpperName = tempAccount.getName().toUpperCase();
//			tempAccount.setName(theUpperName);
//		}
//	}
//	
//	// AfterThrowing advice
//	@AfterThrowing(
//			    pointcut="execution(* com.lu2code.aopdemo.dao.AccountDAO.findAccounts(..))",
//				throwing="theExc"
//			)
//	public void afterTHrowingFindAccountAdvice(JoinPoint theJoinPoint, Throwable theExc) {
//		String method = theJoinPoint.getSignature().toShortString();
//		System.out.println("\n ========> Executing @AfterThrowing on method: " + method);
//		
//		System.out.println("\n ========> THe exception is: " + theExc);
//
//	}
//	
//	// After Finally, remember after runs first followed by after throwing. After runs for error or success 
//	@After("execution(* com.lu2code.aopdemo.dao.AccountDAO.findAccounts(..))")
//	public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint) {
//		String method = theJoinPoint.getSignature().toShortString();
//		System.out.println("\n ========> Executing @AfterFinally on method: " + method);
//	}
//	
//	// Around Advice, happens at start and end, notice here JoinPoint is different "ProceedingJoinPoint"
//	@Around("execution(* com.lu2code.aopdemo.service.*.getFortune(..))")
//    public Object aroundGetFortune(
//    			ProceedingJoinPoint theProceedingJoinPoint 
//    		) throws Throwable {
//		
//		// print out method we are advising on
//		String method = theProceedingJoinPoint.getSignature().toShortString();
//		System.out.println("\n ========> Executing @AfterThrowing on method: " + method);
//		
//		
//		// get begin timestamp
//		long begin = System.currentTimeMillis();
//		
//		// execute method
//		// the ProceedingJoinPoint here is used to proceed the execution of the method that is called up, here getFortune
//		Object result = theProceedingJoinPoint.proceed();
//		
//		
//		
//		//get end timestamp
//		long end = System.currentTimeMillis();
//		
//		//compute duration and display it
//		long duration = end - begin;
//		
//		System.out.println("\n======> Duration: " + duration/1000.0 + "seconds");
//		
//		// result consists of the calling program result returned by getFortune
//    	return result; 
//    }
//	
//	 
//}
