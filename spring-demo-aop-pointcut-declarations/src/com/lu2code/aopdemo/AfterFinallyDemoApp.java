package com.lu2code.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.lu2code.aopdemo.dao.AccountDAO;

public class AfterFinallyDemoApp {

	public static void main(String[] args) {
		// read spring config java class
		
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		List<Account> theAccounts = null;
		// 1st add try catch
		try {
			// add a boolean flag to simulate exception
			boolean tripwire = false;
			//boolean tripwire = true;
			theAccounts = theAccountDAO.findAccounts(tripwire);
		} 
		catch(Exception e) {
			System.out.println("\n\n---Main Progam caught exception" + e);
		}
		
		
		
		System.out.println("\n\n--------------------");
		System.out.println("\n\nAccounts Main: " + theAccounts);
		System.out.println("\n\n--------------------\n");
		
		// close the context
		context.close();

	}

}
