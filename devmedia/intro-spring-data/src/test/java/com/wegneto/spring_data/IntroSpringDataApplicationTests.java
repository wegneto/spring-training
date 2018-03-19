package com.wegneto.spring_data;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.wegneto.spring_data.repository.PersonRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IntroSpringDataApplicationTests {
	
	@Autowired
	private PersonRepository personRepository;

	@Test
	public void contextLoads() {
		long total = personRepository.count();
		System.out.println("#person count: " + total);
	}

}
