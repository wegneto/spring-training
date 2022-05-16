package com.wegneto.springdemo;

public class CricketCoach implements Coach {
	
	private FortuneService fortuneService;
	
	private String emailAddress;
	
	private String team;

	public CricketCoach() {
		System.out.println("CricketCoach: inside no-arg constructor.");
	}
	
	public FortuneService getFortuneService() {
		return fortuneService;
	}
	
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("CricketCoach: inside setter method setFortuneService.");
		this.fortuneService = fortuneService;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		System.out.println("CricketCoach: inside setter method setEmailAddress.");
		this.emailAddress = emailAddress;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		System.out.println("CricketCoach: inside setter method setTeam.");
		this.team = team;
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
