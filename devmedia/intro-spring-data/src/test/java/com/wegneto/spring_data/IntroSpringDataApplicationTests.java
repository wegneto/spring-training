package com.wegneto.spring_data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
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
	
	@Test
	public void testFindAndSort() {
		Order orderAsc = new Order(Direction.ASC, "lastName");
		Sort sort = new Sort(orderAsc);
		
		List<Person> insertList = new ArrayList<>();
		for(int i = 0; i < 10; i++) {
			insertList.add(TestUtils.createPerson());
		}
		personRepository.save(insertList);
		
		List<Person> persons = personRepository.findAll(sort);
		System.out.println("==== Ordered list =====");
		persons.forEach(System.out::println);
	}
	
	@Test
	public void testFindByAge() {
		Person p1 = TestUtils.createPerson();
		int age1 = 21;
		p1.setAge(age1);
		p1.setDocument(TestUtils.createDocument());
		
		Person p2 = TestUtils.createPerson();
		int age2 = 22;
		p2.setAge(age2);
		p2.setDocument(TestUtils.createDocument());
		
		Person p3 = TestUtils.createPerson();
		int age3 = 23;
		p3.setAge(age3);
		p3.setDocument(TestUtils.createDocument());
		
		personRepository.save(Arrays.asList(p1, p2, p3));
		
		long count = personRepository.count();
		List<Person> result = personRepository.findByAge(age1);
		
		Assert.assertEquals(3, count);
		Assert.assertEquals(1, result.size());	
	}
	
}
