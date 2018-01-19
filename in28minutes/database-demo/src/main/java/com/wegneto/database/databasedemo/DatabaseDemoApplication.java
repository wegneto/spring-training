package com.wegneto.database.databasedemo;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.wegneto.database.databasedemo.entity.Person;
import com.wegneto.database.databasedemo.jdbc.PersonJdbcDAO;

@SpringBootApplication
public class DatabaseDemoApplication implements CommandLineRunner {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private PersonJdbcDAO personJdbcDAO;

	public static void main(String[] args){
		SpringApplication.run(DatabaseDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("All users -> {}", personJdbcDAO.findAll());
		logger.info("User id 10001 -> {}", personJdbcDAO.findById(10001));
		logger.info("Deleting 10002 -> # of rows deleted {}", personJdbcDAO.deleteById(10002));
		logger.info("Inserting 10004 -> {}", personJdbcDAO.insert(new Person(10004, "Tara", "Berlin", new Date())));
		logger.info("Updating 10003 -> {}", personJdbcDAO.update(new Person(10003, "New Name", "Berlin", new Date())));
		
	}
}
