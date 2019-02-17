package com.wegneto.springdemo;

public class SwimCoach implements Coach {
	
	private FortuneService fortuneService;
	
	public SwimCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "This is your SWIM workout.";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
