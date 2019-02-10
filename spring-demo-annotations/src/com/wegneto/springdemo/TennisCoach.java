package com.wegneto.springdemo;

import org.springframework.stereotype.Component;

@Component("someCoach")
public class TennisCoach implements Coach {

	@Override
	public String getDailyWorkout() {
		return "This is your Tennis workout.";
	}

}
