package com.wegneto.springdemo.app;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wegneto.springdemo.coach.Coach;

public class AnnotationBeanScopeDemoApp {
	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Coach coachOne = context.getBean("tennisCoach", Coach.class);
		Coach coachTwo = context.getBean("tennisCoach", Coach.class);
		
		boolean result = (coachOne == coachTwo);
		
		System.out.println("Pointing to the same object: " + result);
		
		System.out.println("Memory location for coachOne: " + coachOne);
		
		System.out.println("Memory location for coachTwo: " + coachTwo);
		
		context.close();
	}

}
