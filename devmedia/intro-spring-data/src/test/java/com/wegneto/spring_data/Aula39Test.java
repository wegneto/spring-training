package com.wegneto.spring_data;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import com.wegneto.spring_data.entity.Person;
import com.wegneto.spring_data.repository.PersonRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql(scripts = { "/clear_db.sql", "/aula38.sql" })
public class Aula39Test {

	@Autowired
	private PersonRepository personRepository;
	
	@Test
	public void findFirst() {
		Person p1 = personRepository.findFirstByOrderByLastNameAsc();
		Assert.assertEquals("Champlin", p1.getLastName());
		
		Person p2 = personRepository.findFirstByOrderByLastNameDesc();
		Assert.assertEquals("Turner", p2.getLastName());
	}
	
	@Test
	public void findTop() {
		Person p1 = personRepository.findTopByOrderByAgeAsc();
		Assert.assertEquals(11, p1.getAge().intValue());
		
		Person p2 = personRepository.findTopByOrderByAgeDesc();
		Assert.assertEquals(42, p2.getAge().intValue());
	}
	
	
}
