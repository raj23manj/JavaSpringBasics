package com.lu2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LuvAopExpressions {
	//#### point cut declarations ### for reusability
	@Pointcut("execution(* com.lu2code.aopdemo.dao.*.*(..))")
	public void forDaoPackage() {}
	
	
	// match getter methods
	@Pointcut("execution(* com.lu2code.aopdemo.dao.*.get*(..))")
	public void getter() {}
	
	// match setter methods
	@Pointcut("execution(* com.lu2code.aopdemo.dao.*.set*(..))")
	public void setter() {}
	
	// combine pointcuts: include package and exclude getter/setter
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	public void forDaoPackageNoGetterSetter () {}

}
