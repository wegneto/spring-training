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
@Sql(scripts = { "/clear_db.sql", "/aula34.sql" })
public class Aula34Test {

	@Autowired
	private PersonRepository personRepository;

	@Test
	public void findByAgeBetween() {
		List<Person> persons = personRepository.findByAgeBetween(40, 44);
		Assert.assertEquals(4, persons.size());
	}
	
	@Test
	public void findByFirstNames() {
		List<Person> persons = personRepository.findByFirstNames("Sally", "Mossie", "Teste");
		Assert.assertEquals(2, persons.size());
	}

}
