package com.wegneto.database.databasedemo;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.wegneto.database.databasedemo.entity.Person;
import com.wegneto.database.databasedemo.jpa.PersonJpaRepository;

@SpringBootApplication
public class JpaDemoApplication implements CommandLineRunner {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private PersonJpaRepository personJpaRepository;
	
	public static void main(String[] args){
		SpringApplication.run(JpaDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("User id 10001 -> {}", personJpaRepository.findById(10001));
		logger.info("Inserting 10004 -> {}", personJpaRepository.insert(new Person("Tara", "Berlin", new Date())));
		logger.info("Updating 10003 -> {}", personJpaRepository.update(new Person(10003, "New Name", "Berlin", new Date())));
		personJpaRepository.delete(10001);
		logger.info("All users -> {}", personJpaRepository.findAll());
	}
}
