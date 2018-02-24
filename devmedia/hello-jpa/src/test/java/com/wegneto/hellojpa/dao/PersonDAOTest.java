package com.wegneto.hellojpa.dao;

import org.junit.Test;

import com.github.javafaker.Faker;
import com.wegneto.hellojpa.entity.Person;

public class PersonDAOTest {
	
	private Faker faker = new Faker();

	@Test
	public void test() {
		PersonDAO dao = new PersonDAO();
		Person p1 = new Person();
		p1.setFirstName(faker.name().firstName());
		p1.setLastName(faker.name().lastName());
		p1.setAge(faker.number().numberBetween(10, 50));
		
		new PersonDAO().save(p1);
	}

}
