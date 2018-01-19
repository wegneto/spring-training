package com.wegneto.database.databasedemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
	}
}
