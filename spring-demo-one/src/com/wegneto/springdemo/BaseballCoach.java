package com.wegneto.springdemo;

public class BaseballCoach implements Coach {
	
	private FortuneService fortuneService;
	
	public BaseballCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "This is your today's Baseball workout";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
