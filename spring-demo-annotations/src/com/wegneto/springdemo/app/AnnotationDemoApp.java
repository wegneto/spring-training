package com.wegneto.springdemo.app;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wegneto.springdemo.coach.Coach;
import com.wegneto.springdemo.coach.TennisCoach;

public class AnnotationDemoApp {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Coach coach = context.getBean(TennisCoach.class);
		
		System.out.println(coach.getDailyWorkout());
		System.out.println(coach.getDailyFortune());
		
		context.close();
	}

}
