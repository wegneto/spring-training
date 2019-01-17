package com.wegneto.springdemo;

public class BaseballCoach implements Coach {
	
	@Override
	public String getDailyWorkout() {
		return "This is your today's Baseball workout";
	}

}
