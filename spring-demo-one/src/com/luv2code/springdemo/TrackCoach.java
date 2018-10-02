package com.luv2code.springdemo;

public class TrackCoach implements Coach {
	
	// define private field for DI
	private FortuneService fortuneService;
	
	public TrackCoach() { }
		
	// define constructor for DI
	public TrackCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "From track coach";
	}

	@Override
	public String getDailyFortune() {
		return "Track:" + fortuneService.getFortune();
	}
	
	// add an init method
	public void doMyStartupStuff() {
		System.out.println("Init process");
	}
	
	// add destroy method
	public void doMyCleanUpStuff() {
		System.out.println("Destroy process");
	}
}
