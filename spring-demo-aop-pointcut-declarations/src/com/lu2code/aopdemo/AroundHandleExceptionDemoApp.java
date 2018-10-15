package com.lu2code.aopdemo;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.lu2code.aopdemo.service.TrafficFortuneService;

public class AroundHandleExceptionDemoApp {
	

	private static Logger myLogger = 
			Logger.getLogger(AroundHandleExceptionDemoApp.class.getName());

	public static void main(String[] args) {
		// read spring config java class
		
		
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		TrafficFortuneService theTrafficFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
		
		myLogger.info("calling fortune service");
		
		boolean tripwire = true;
		String data = theTrafficFortuneService.getFortune(tripwire);
		
		myLogger.info("fortune service data: " + data);
		myLogger.info("finished");
		// close the context
		context.close();

	}

}
 