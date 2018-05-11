package com.wegneto.spring_data;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import com.wegneto.spring_data.entity.Address;
import com.wegneto.spring_data.repository.AddressRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql(scripts = { "/clear_db.sql", "/aula35.sql" })
public class Aula35Test {

	@Autowired
	private AddressRepository addressRepository;

	@Test
	public void findByAgeBetween() {
		List<Address> list = addressRepository.findByCity("West Kodyland");
		Assert.assertEquals(1, list.size());
	}
	
	@Test
	public void findByCityAndStreet() {
		List<Address> list = addressRepository.findByCityAndStreet("Lake Gianni", "17240 Ariel Row");
		Assert.assertEquals(1, list.size());
	}
	
	@Test
	public void findByAddress() {
		Address address = addressRepository.findByAddress("Lake Gianni", "17240 Ariel Row");
		Assert.assertNotNull(address);
	}

}
