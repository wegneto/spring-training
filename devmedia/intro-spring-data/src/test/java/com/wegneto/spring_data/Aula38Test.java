package com.wegneto.spring_data;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.javafaker.Faker;
import com.wegneto.spring_data.entity.Phone;
import com.wegneto.spring_data.repository.PhoneRespository;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql(scripts = { "/clear_db.sql", "/aula38.sql" })
public class Aula38Test {

	@Autowired
	private PhoneRespository phoneRepository;
	
	private Faker faker = new Faker();
	
	@Test
	public void update() {
		Phone p = phoneRepository.findOne(1L);
		String newNumber = faker.phoneNumber().cellPhone();
		phoneRepository.updatePhoneNumber(newNumber, 1L);
		p = phoneRepository.findOne(1L);
		Assert.assertEquals(newNumber, p.getNumber());
	}
	
	
}
