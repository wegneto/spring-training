package com.wegneto.springdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.wegneto.springdemo.coach.Coach;
import com.wegneto.springdemo.coach.SwimCoach;
import com.wegneto.springdemo.service.FortuneService;
import com.wegneto.springdemo.service.SadFortuneService;

@Configuration
@PropertySource("classpath:sport.properties")
public class SportConfig {
	
	@Bean
	public FortuneService sadFortuneService() {
		return new SadFortuneService();
	}
	
	@Bean
	public Coach swimCoach() {
		return new SwimCoach(sadFortuneService());
	}

}
