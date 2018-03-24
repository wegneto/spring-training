package com.wegneto.spring_data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.wegneto.spring_data.entity.Person;
import com.wegneto.spring_data.repository.PersonRepository;

@SpringBootApplication
//@ImportResource(value = "spring-data.xml")
public class IntroSpringDataApplication implements CommandLineRunner {
	
	@Autowired
	private PersonRepository personRepository;

	public static void main(String[] args) {
		SpringApplication.run(IntroSpringDataApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		testConfiguration();
	}

	private void testConfiguration() {
		long total = personRepository.count();
		System.out.println("#person count: " + total);
		
		List<Person> persons = personRepository.findAll();
		persons.forEach(System.out::println);
	}
	
	
}
