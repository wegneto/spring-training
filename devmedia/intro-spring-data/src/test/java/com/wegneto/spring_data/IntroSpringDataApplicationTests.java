package com.wegneto.spring_data;

import java.util.Arrays;
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
@Sql(scripts = {"/test.sql"})
public class IntroSpringDataApplicationTests {
	
	@Autowired
	private PersonRepository personRepository;
	
	@Test
	public void contextLoads() {
		long total = personRepository.count();
		System.out.println("#person count: " + total);
	}
	
	@Test
	public void testSave() {
		Person person = TestUtils.createPerson();
		person.setDocument(TestUtils.createDocument());
		person.addAddress(TestUtils.createAddress());
		person.addPhone(TestUtils.createPhone());
		
		personRepository.save(person);
		
		Person result = personRepository.findOne(person.getId());
		
		Assert.assertNotNull(result.getId());
		Assert.assertEquals(person.getFirstName(), result.getFirstName());
	}
	
	@Test
	public void testBatch() {
		Person p1 = TestUtils.createPerson();
		p1.setDocument(TestUtils.createDocument());
		
		Person p2 = TestUtils.createPerson();
		p2.setDocument(TestUtils.createDocument());
		
		Person p3 = TestUtils.createPerson();
		p3.setDocument(TestUtils.createDocument());
		
		List<Person> persons = personRepository.save(Arrays.asList(p1, p2, p3));
		persons.forEach(System.out::println);
		
		Assert.assertEquals(3, personRepository.count());
	}
	
	@Test
	public void testDelete() {
		Person person = TestUtils.createPerson();
		person.setDocument(TestUtils.createDocument());
		
		personRepository.save(person);
		
		Assert.assertEquals(1, personRepository.count());
		
		Person result = personRepository.findOne(person.getId());
		
		personRepository.delete(result);
		
		Assert.assertEquals(0, personRepository.count());
	}
	
}
