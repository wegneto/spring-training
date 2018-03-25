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

import com.wegneto.spring_data.entity.Address;
import com.wegneto.spring_data.entity.Address.TypeAddress;
import com.wegneto.spring_data.entity.Document;
import com.wegneto.spring_data.entity.Person;
import com.wegneto.spring_data.entity.Phone;
import com.wegneto.spring_data.entity.Phone.TypePhone;
import com.wegneto.spring_data.repository.PersonRepository;

import ch.qos.logback.core.net.SyslogOutputStream;

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
		Person person = new Person();
		person.setFirstName("Jose");
		person.setLastName("Silva");
		person.setAge(23);
		person.setDocument(new Document("111.111.111-11", "1234566"));
		
		Address address = new Address();
		address.setCity("City");
		address.setStreet("Street");
		address.setTypeAddress(TypeAddress.HOME);
		
		person.setAddresses(Arrays.asList(address));
		person.addPhone(new Phone(TypePhone.HOME, "1111111"));
		
		personRepository.save(person);
		
		Person result = personRepository.findOne(person.getId());
		
		Assert.assertNotNull(result.getId());
		Assert.assertEquals(person.getFirstName(), result.getFirstName());
	}
	
	@Test
	public void testBatch() {
		Person person = new Person();
		person.setFirstName("Joao");
		person.setLastName("Silva");
		person.setAge(24);
		person.setDocument(new Document("111.111.111-12", "1234567"));
		
		Person p2 = new Person();
		p2.setFirstName("Antonio");
		p2.setLastName("Silva");
		p2.setAge(25);
		p2.setDocument(new Document("111.111.111-13", "1234563"));
		
		Person p3 = new Person();
		p3.setFirstName("Luiz");
		p3.setLastName("Silva");
		p3.setAge(26);
		p3.setDocument(new Document("111.111.111-14", "1234564"));
		
		List<Person> persons = personRepository.save(Arrays.asList(person, p2, p3));
		persons.forEach(System.out::println);
		
		Assert.assertEquals(3, personRepository.count());
	}
	
	@Test
	public void testDelete() {
		Person person = new Person();
		person.setFirstName("Jose");
		person.setLastName("Silva");
		person.setAge(23);
		person.setDocument(new Document("111.111.111-11", "1234566"));
		
		personRepository.save(person);
		
		Assert.assertEquals(1, personRepository.count());
		
		Person result = personRepository.findOne(person.getId());
		
		personRepository.delete(result);
		
		Assert.assertEquals(0, personRepository.count());
	}
	
}
