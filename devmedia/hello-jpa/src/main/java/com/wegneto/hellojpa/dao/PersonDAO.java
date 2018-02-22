package com.wegneto.hellojpa.dao;

import com.wegneto.hellojpa.entity.Person;

public class PersonDAO extends GenericDAO<Person>{

	public PersonDAO() {
		super(Person.class);
	}
	
}
