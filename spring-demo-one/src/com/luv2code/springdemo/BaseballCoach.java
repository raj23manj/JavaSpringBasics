package com.luv2code.springdemo;

public class BaseballCoach implements Coach {
	
	// define private field for DI
	private FortuneService fortuneService;
	
	// define constructor for DI
	public BaseballCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "From baseball coach";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
}
