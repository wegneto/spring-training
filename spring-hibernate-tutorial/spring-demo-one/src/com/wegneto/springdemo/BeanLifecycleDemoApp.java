package com.wegneto.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifecycleDemoApp {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanLifecycle-applicationContext.xml");

		Coach coach1 = context.getBean("myCoach", Coach.class);
		
		System.out.println(coach1.getDailyWorkout());
		
		context.close();
		
	}

}
