package com.wegneto.springdemo.coach;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.wegneto.springdemo.service.FortuneService;

@Component
public class TennisCoach implements Coach {
	
	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;
	
	public TennisCoach() {
		System.out.println(">> TennisCoach: inside default constructor");
	}
	
	@PostConstruct
	public void init() {
		System.out.println("Inside init method");
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("Inside destroy method");
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
