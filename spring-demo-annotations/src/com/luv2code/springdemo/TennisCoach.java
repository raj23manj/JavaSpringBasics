package com.luv2code.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope("prototype") //"singleton" is default
public class TennisCoach implements Coach {
	
//	private FortuneService fortuneService; // for normal below commented methods
	
	@Autowired // set using reflection this is field injection
	//@Qualifier("restService") see the difference
	@Qualifier("randomFortuneService") // when multiple implementations of interface is there to specify specific one
	private FortuneService fortuneService;
	
	// other properties
	@Value("${foo.email}")
	private String email;
	    
	@Value("${foo.team}")
	private String team;
	
	/* for constructor it is different
	@Autowired
    public TennisCoach(@Qualifier("randomFortuneService") FortuneService theFortuneService) {

        System.out.println(">> TennisCoach: inside constructor using @autowired and @qualifier");
        
        fortuneService = theFortuneService;
    }
	 */
	
	
	public TennisCoach() {
		System.out.println("inside constructor team: " + team + " email: " + "email");
	}
	
//	@Autowired //constructor injection
//	public void TennisCoach(FortuneService theFortuneService) {
//		fortuneService = theFortuneService;
//	}
	
//	@Autowired   //as setter
//	public void setFortuneService(FortuneService theFortuneService) {
//		System.out.println("autowiring the service");
//		fortuneService = theFortuneService;
//	}
	
//	@Autowired // as normal method
//	public void initFortuneService(FortuneService theFortuneService) {
//		System.out.println("autowiring the service");
//		fortuneService = theFortuneService;
//	}

	@Override
	public String getDailyWorkout() {
		System.out.println("inside getDailyWorkout team: " + team + " email: " + email);
		return "Tennis Coach Workout";
	}

	@Override
	public String getDailyFortune() {		
		return fortuneService.getFortune();
	}
	
	// bean life cycle pre and post calls
	// init method
	@PostConstruct
	public void doMyStartUpStuff() {
		System.out.println("Init tennis init bean");
	}
	
	@PreDestroy
	public void doMyCleanUpStuff() {
		System.out.println("Destroy tennis destroy bean");
	}

}
