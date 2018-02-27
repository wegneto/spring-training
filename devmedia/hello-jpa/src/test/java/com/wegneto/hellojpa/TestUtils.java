package com.wegneto.hellojpa;

import com.github.javafaker.Faker;
import com.wegneto.hellojpa.entity.Person;

public class TestUtils {
	
	private static Faker faker = new Faker();

	public static Person createPerson() {
		Person person = new Person();
		person.setFirstName(faker.name().firstName());
		person.setLastName(faker.name().lastName());
		person.setAge(faker.number().numberBetween(10, 50));
		return person;
	}
	
	public static String generateDocumentNumber(String number) {
		while(number.indexOf("x") != -1) {
			number = number.replaceFirst("x", Integer.toString(faker.number().numberBetween(0, 9)));
		}
		
		return number;
	}

}
