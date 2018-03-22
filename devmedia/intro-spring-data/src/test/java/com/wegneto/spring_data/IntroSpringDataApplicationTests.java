package com.wegneto.spring_data;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.wegneto.spring_data.entity.Address;
import com.wegneto.spring_data.entity.Address.TypeAddress;
import com.wegneto.spring_data.entity.Document;
import com.wegneto.spring_data.entity.Person;
import com.wegneto.spring_data.entity.Phone;
import com.wegneto.spring_data.entity.Phone.TypePhone;
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
	
}
