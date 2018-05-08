package com.wegneto.spring_data;

import java.util.List;

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
@Sql(scripts = { "/clear_db.sql", "/aula33.sql" })
public class Aula33Test {

	@Autowired
	private PersonRepository personRepository;

	@Test
	public void findByName() {
		List<Person> persons = personRepository.findByFirstName("Winfield");
		Assert.assertEquals(1, persons.size());
	}
	
	@Test
	public void findByDocumentCPFEndsWith() {
		List<Person> persons = personRepository.findByDocumentCPFEndsWith("38");
		Assert.assertEquals(1, persons.size());
	}

}
