package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Coach theCoach = context.getBean("tennisCoach", Coach.class);

		Coach aplhaCoach = context.getBean("tennisCoach", Coach.class);
				
		boolean result = (theCoach == aplhaCoach);
		
		System.out.println("Result:" + result);
		
		context.close();	

		/*
		 * For "prototype" scoped beans, Spring does not call the @PreDestroy method.  Gasp!  
		 * To get the Spring container to release resources held by prototype-scoped beans, try using a custom 
		 * https://docs.spring.io/spring/docs/current/spring-framework-reference/core.html#beans-factory-extension-bpp
		 */
		
		
	}

}
