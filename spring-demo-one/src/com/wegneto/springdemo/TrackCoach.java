package com.wegneto.springdemo;

public class TrackCoach implements Coach {
	
	private FortuneService fortuneService;

	public TrackCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	public TrackCoach() {
	}

	@Override
	public String getDailyWorkout() {
		return "This is your today's Track workout";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
