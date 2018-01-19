package com.wegneto.database.databasedemo;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.wegneto.database.databasedemo.entity.Person;
import com.wegneto.database.databasedemo.springdata.PersonSpringDataRepository;

@SpringBootApplication
public class SpringDataDemoApplication implements CommandLineRunner {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private PersonSpringDataRepository personSpringDataRepository;
	
	public static void main(String[] args){
		SpringApplication.run(SpringDataDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("User id 10001 -> {}", personSpringDataRepository.findById(10001));
		logger.info("Inserting 10004 -> {}", personSpringDataRepository.save(new Person("Tara", "Berlin", new Date())));
		logger.info("Updating 10003 -> {}", personSpringDataRepository.save(new Person(10003, "New Name", "Berlin", new Date())));
		personSpringDataRepository.deleteById(10001);
		logger.info("All users -> {}", personSpringDataRepository.findAll());
	}
}
