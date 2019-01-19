package com.wegneto.springdemo;

public class CricketCoach implements Coach {
	
	private FortuneService fortuneService;

	public CricketCoach() {
		System.out.println("CricketCoach: inside no-arg constructor.");
	}
	
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("CricketCoach: inside setter method setFortuneService.");
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "This is your today's Cricket workout";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
}
