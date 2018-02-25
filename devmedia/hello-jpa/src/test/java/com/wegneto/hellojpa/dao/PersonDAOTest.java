package com.wegneto.hellojpa.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import com.github.javafaker.Faker;
import com.wegneto.hellojpa.entity.Person;

public class PersonDAOTest {

	private Faker faker = new Faker();

	private PersonDAO personDAO = new PersonDAO();

	@Test
	public void successfullyInsert() {
		long count = personDAO.count();

		Person p1 = createPerson();
		assertNull(p1.getId());

		p1 = new PersonDAO().save(p1);
		assertNotNull(p1.getId());
		assertEquals(count + 1, personDAO.count());
	}

	@Test
	public void successfullyFindById() {
		Person p1 = createPerson();
		p1 = personDAO.save(p1);

		Person result = personDAO.findById(p1.getId());
		assertNotNull(p1.getId());
		assertEquals(p1, result);
	}

	private Person createPerson() {
		Person p1 = new Person();
		p1.setFirstName(faker.name().firstName());
		p1.setLastName(faker.name().lastName());
		p1.setAge(faker.number().numberBetween(10, 50));
		return p1;
	}

}
