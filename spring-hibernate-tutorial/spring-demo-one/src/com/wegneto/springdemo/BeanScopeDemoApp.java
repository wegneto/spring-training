package com.wegneto.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");

		Coach coach1 = context.getBean("myCoach", Coach.class);

		Coach coach2 = context.getBean("myCoach", Coach.class);

		// check if they are the same
		boolean result = (coach1 == coach2);

		// print out the results
		System.out.println("Pointing to the same object: " + result);

		System.out.println("Memory location for coach1: " + coach1);
		System.out.println("Memory location for coach2: " + coach2);
		
		context.close();
		
	}

}
