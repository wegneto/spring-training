package com.wegneto.hellojpa.dao;

import static com.wegneto.hellojpa.TestUtils.createPerson;
import static com.wegneto.hellojpa.TestUtils.generateDocumentNumber;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Arrays;
import java.util.Collections;

import org.junit.Assert;
import org.junit.Test;

import com.github.javafaker.Faker;
import com.wegneto.hellojpa.entity.Document;
import com.wegneto.hellojpa.entity.Person;
import com.wegneto.hellojpa.entity.Phone;
import com.wegneto.hellojpa.entity.Phone.TypePhone;

public class PersonDAOTest {
	
	private Faker faker = new Faker();

	private PersonDAO personDAO = new PersonDAO();

	//@Test
	public void successfullyInsert() {
		long count = personDAO.count();

		Person p1 = createPerson();
		assertNull(p1.getId());

		p1 = new PersonDAO().save(p1);
		assertNotNull(p1.getId());
		assertEquals(count + 1, personDAO.count());
	}

	//@Test
	public void successfullyFindById() {
		Person p1 = createPerson();
		p1 = personDAO.save(p1);

		Person result = personDAO.findById(p1.getId());
		assertNotNull(p1.getId());
		assertEquals(p1, result);
	}

	//@Test
	public void findByCpf() {
		Person person = createPerson();
		person.setDocument(
				new Document(generateDocumentNumber("xxx.xxx.xxx-xx"), generateDocumentNumber("xxxxxxxx-xx")));
		person = personDAO.save(person);

		Person dbRecord = personDAO.findByCpf(person.getDocument().getCpf());

		Assert.assertEquals(person, dbRecord);
	}

	//@Test
	public void insertPhoneNumber() {
		Person person = createPerson();
		person.setDocument(
				new Document(generateDocumentNumber("xxx.xxx.xxx-xx"), generateDocumentNumber("xxxxxxxx-xx")));

		Phone phone1 = new Phone(TypePhone.HOME, faker.phoneNumber().phoneNumber());
		person.addPhone(phone1);
		
		Phone phone2 = new Phone(TypePhone.MOBILE, faker.phoneNumber().cellPhone());
		person.addPhone(phone2);
		
		Phone phone3 = new Phone(TypePhone.WORK, faker.phoneNumber().phoneNumber());
		person.addPhone(phone3);
		
		personDAO.save(person);

		assertNotNull(person.getId());
		assertNotNull(phone1.getId());
		assertNotNull(phone2.getId());
		assertNotNull(phone3.getId());
	}
	
	@Test
	public void updatePhoneByPerson() {
		Person person = createPerson();
		person.setDocument(new Document(generateDocumentNumber("xxx.xxx.xxx-xx"), generateDocumentNumber("xxxxxxxx-xx")));

		Phone phone1 = new Phone(TypePhone.HOME, faker.phoneNumber().phoneNumber());
		person.addPhone(phone1);
		
		Phone phone2 = new Phone(TypePhone.MOBILE, faker.phoneNumber().cellPhone());
		person.addPhone(phone2);
		
		Phone phone3 = new Phone(TypePhone.WORK, faker.phoneNumber().phoneNumber());
		person.addPhone(phone3);
		
		personDAO.save(person);
		
		Person p2 = personDAO.findById(person.getId());
		for (Phone phone : p2.getPhones()) {
			if (TypePhone.HOME == phone.getTypePhone()) {
				phone.setTypePhone(TypePhone.MOBILE);
			}
		}
		
		personDAO.update(p2);
	}

}
