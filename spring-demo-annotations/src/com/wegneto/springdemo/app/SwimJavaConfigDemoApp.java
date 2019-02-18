package com.wegneto.springdemo.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.wegneto.springdemo.coach.SwimCoach;
import com.wegneto.springdemo.config.SportConfig;

public class SwimJavaConfigDemoApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
		
		SwimCoach coach = context.getBean(SwimCoach.class);
		
		System.out.println(coach.getDailyWorkout());
		System.out.println(coach.getDailyFortune());
		System.out.println(coach.getEmail());
		System.out.println(coach.getTeam());
		
		context.close();
	}

}
