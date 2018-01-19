package com.wegneto.database.databasedemo.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.wegneto.database.databasedemo.entity.Person;

@Repository
public class PersonJdbcDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Person> findAll() {
		return jdbcTemplate.query("select * from person", new BeanPropertyRowMapper<Person>(Person.class));
	}

	public Person findById(int id) {
		return jdbcTemplate.queryForObject("select * from person where id = ?", new Object[] { id },
				new BeanPropertyRowMapper<Person>(Person.class));
	}
}
