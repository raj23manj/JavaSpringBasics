package com.lu2code.aopdemo;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.lu2code.aopdemo.service.TrafficFortuneService;

public class AroundWIthLoggerDemoApp {
	

	private static Logger myLogger = 
			Logger.getLogger(AroundWIthLoggerDemoApp.class.getName());

	public static void main(String[] args) {
		// read spring config java class
		
		
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		TrafficFortuneService theTrafficFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
		
		myLogger.info("calling fortune service");
		
		String data = theTrafficFortuneService.getFortune();
		
		myLogger.info("fortune service data: " + data);
		myLogger.info("finished");
		// close the context
		context.close();

	}

}
 