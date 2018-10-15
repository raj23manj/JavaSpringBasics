package com.lu2code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.lu2code.aopdemo.service.TrafficFortuneService;

public class AroundDemoApp {

	public static void main(String[] args) {
		// read spring config java class
		
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		TrafficFortuneService theTrafficFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
		
		System.out.println("calling fortune service");
		
		String data = theTrafficFortuneService.getFortune();
		
		System.out.println("fortune service data: " + data);
		System.out.println("finished");
		// close the context
		context.close();

	}

}
