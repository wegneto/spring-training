package com.wegneto.springdemo;

public class MyApp {
	
	public static void main(String[] args) {
		Coach theCoach = new BaseballCoach();
		
		System.out.println(theCoach.getDailyWorkout());
	}

}
