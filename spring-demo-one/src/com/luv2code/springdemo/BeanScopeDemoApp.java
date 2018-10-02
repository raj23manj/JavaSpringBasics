package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

	public static void main(String[] args) {
		// load spring config file
		
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");
		
		// retrieve bean from spring container
		Coach theCoach = context.getBean("myCoach", Coach.class);
		Coach aplhaCoach = context.getBean("myCoach", Coach.class);
		
		boolean result = (theCoach == aplhaCoach);
		
		System.out.println("Result:" + result);
		
		context.close();
	}

}
