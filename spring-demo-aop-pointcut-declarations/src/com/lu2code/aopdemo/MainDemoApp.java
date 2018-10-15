package com.lu2code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.lu2code.aopdemo.dao.AccountDAO;
import com.lu2code.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		// read spring config java class
		
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		MembershipDAO theMembershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
		
		Account account = new Account();
		
		// call the business method
		theAccountDAO.addAccount(account, true);
		theAccountDAO.doWork();
		
		
		//call the account getters and setters
		theAccountDAO.setName("foobar");
		theAccountDAO.setServiceCode("silver");
		
		String name = theAccountDAO.getName();
		String code = theAccountDAO.getServiceCode();
		
		//theMembershipDAO.addAccount();
		theMembershipDAO.addSillyMember();
		theMembershipDAO.goToSleep();
		
		// do it again
		
//		System.out.println("calling again");
//		
//		theAccountDAO.addAccount();
//		theMembershipDAO.addAccount();
		
		
		// close the context
		context.close();

	}

}
