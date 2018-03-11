package com.wegneto.hellojpa.dao;

import java.util.Arrays;

import org.junit.Test;

import com.github.javafaker.Faker;
import com.wegneto.hellojpa.TestUtils;
import com.wegneto.hellojpa.entity.Address;
import com.wegneto.hellojpa.entity.Address.TypeAddress;
import com.wegneto.hellojpa.entity.Person;

public class AddressDAOTest {
	
	private Faker faker = new Faker();
	
	private PersonDAO personDAO = new PersonDAO();

	@Test
	public void insertUsingPerson() {
		Address a1 = new Address();
		a1.setCity(faker.address().city());
		a1.setStreet(faker.address().streetAddress());
		a1.setTypeAddress(TypeAddress.HOME);
		
		Address a2 = new Address();
		a2.setCity(faker.address().city());
		a2.setStreet(faker.address().streetName());
		a2.setTypeAddress(TypeAddress.WORK);
		
		Person p1 = TestUtils.createPerson();
		p1.setDocument(TestUtils.createDocument());
		p1.addPhone(TestUtils.createPhone());
		p1.addPhone(TestUtils.createPhone());
		p1.addPhone(TestUtils.createPhone());
		p1.setAddresses(Arrays.asList(a1, a2));
		
		personDAO.save(p1);
	}

}
