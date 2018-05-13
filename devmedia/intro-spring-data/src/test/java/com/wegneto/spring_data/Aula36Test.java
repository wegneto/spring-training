package com.wegneto.spring_data;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import com.wegneto.spring_data.repository.AddressRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql(scripts = { "/clear_db.sql", "/aula35.sql" })
public class Aula36Test {

	@Autowired
	private AddressRepository addressRepository;
	
	@Test
	public void concatAddress() {
		String address = addressRepository.concatAddress(1L);
		Assert.assertNotNull(address);
		Assert.assertEquals("West Kodyland - 78426 Nikolas Pike", address);
	}
	
	@Test
	public void concatAddress2() {
		String address = addressRepository.concatAddress2(2L);
		Assert.assertNotNull(address);
		Assert.assertEquals("North Stephaniemouth - 71343 Carolyne Ford", address);
	}

}
