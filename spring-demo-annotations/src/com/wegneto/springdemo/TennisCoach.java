package com.wegneto.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {
	
	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;
	
	public TennisCoach() {
		System.out.println(">> TennisCoach: inside default constructor");
	}
	
	@Override
	public String getDailyWorkout() {
		return "This is your Tennis workout.";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
	
}
