package com.wegneto.springdemo.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.wegneto.springdemo.coach.Coach;
import com.wegneto.springdemo.config.SportConfig;

public class JavaConfigDemoApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
		
		Coach coach = context.getBean("tennisCoach", Coach.class);
		
		System.out.println(coach.getDailyWorkout());
		System.out.println(coach.getDailyFortune());
		
		context.close();
	}

}
