package com.wegneto.spring_data;

import java.util.Random;

import com.github.javafaker.Faker;
import com.wegneto.spring_data.entity.Address;
import com.wegneto.spring_data.entity.Address.TypeAddress;
import com.wegneto.spring_data.entity.Document;
import com.wegneto.spring_data.entity.Person;
import com.wegneto.spring_data.entity.Phone;
import com.wegneto.spring_data.entity.Phone.TypePhone;

public class TestUtils {

	private static Faker faker = new Faker();

	private final static Random RANDOM = new Random();

	public static Person createPerson() {
		Person person = new Person();
		person.setFirstName(faker.name().firstName());
		person.setLastName(faker.name().lastName());
		person.setAge(faker.number().numberBetween(10, 50));
		return person;
	}

	public static Document createDocument() {
		Document document = new Document();
		document.setCpf(generateDocumentNumber("xxx.xxx.xxx-xx"));
		document.setRg(generateDocumentNumber("xxxxxxxx-xx"));
		return document;
	}

	public static Phone createPhone() {
		Phone phone = new Phone();
		phone.setNumber(faker.phoneNumber().phoneNumber());
		int rand = RANDOM.nextInt(11);
		if (rand % 2 == 0) {
			phone.setTypePhone(TypePhone.HOME);
		} else if (rand % 3 == 0) {
			phone.setTypePhone(TypePhone.MOBILE);
		} else {
			phone.setTypePhone(TypePhone.WORK);
		}

		return phone;
	}
	
	public static Address createAddress() {
		Address address = new Address();
		address.setCity(faker.address().cityName());
		address.setStreet(faker.address().streetAddress());

		int rand = RANDOM.nextInt(11);
		if (rand % 2 == 0) {
			address.setTypeAddress(TypeAddress.HOME);
		} else {
			address.setTypeAddress(TypeAddress.WORK);
		}
		
		return address;
	}

	public static String generateDocumentNumber(String number) {
		while (number.indexOf("x") != -1) {
			number = number.replaceFirst("x", Integer.toString(faker.number().numberBetween(0, 9)));
		}

		return number;
	}

}
