package com.wegneto.hellojpa;

import java.util.List;

import com.github.javafaker.Faker;
import com.wegneto.hellojpa.dao.PersonDAO;
import com.wegneto.hellojpa.entity.Person;

public class AppHelloJpa {

	private static Faker faker = new Faker();

	public static void main(String[] args) {
		System.out.println("Hello Jpa!");
		insertPerson();
		findPersonById();
		findAllPersons();
		countAllPersons();
	}

	private static void countAllPersons() {
		Long count = new PersonDAO().count();
		System.out.println("Number of records: " + count);
	}

	private static void findAllPersons() {
		System.out.println("==== findAllPersons ====");
		List<Person> persons = new PersonDAO().findAll();
		for (Person person : persons) {
			System.out.println(person.toString());
		}
	}

	private static void findPersonById() {
		System.out.println("==== findPersonById ====");
		Person p1 = new PersonDAO().findById(1L);
		System.out.println(p1.toString());
	}

	private static void insertPerson() {
		System.out.println("==== insertPerson ====");
		Person p1 = new Person();
		p1.setFirstName(faker.name().firstName());
		p1.setLastName(faker.name().lastName());
		p1.setAge(faker.number().numberBetween(10, 50));

		new PersonDAO().save(p1);
		System.out.println(p1.toString());

		Person p2 = new Person();
		p2.setFirstName(faker.name().firstName());
		p2.setLastName(faker.name().lastName());
		p2.setAge(faker.number().numberBetween(10, 50));

		new PersonDAO().save(p2);
		System.out.println(p2.toString());

		Person p3 = new Person();
		p3.setFirstName(faker.name().firstName());
		p3.setLastName(faker.name().lastName());
		p3.setAge(faker.number().numberBetween(10, 50));

		new PersonDAO().save(p3);
		System.out.println(p3.toString());
	}
}
