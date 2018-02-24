package com.wegneto.hellojpa.dao;

import java.util.List;

import com.wegneto.hellojpa.entity.Person;

public class PersonDAO extends GenericDAO<Person> {

	public PersonDAO() {
		super(Person.class);
	}

	public List<Person> findByLastName(String lastName) {
		String jpql = "from Person p where p.lastName like ?1";
		return find(jpql, lastName);
	}

	public List<Person> findAgeIsBetween(int min, int max) {
		String jpql = "from Person p where p.age between ?1 and ?2";
		return find(jpql, min, max);
	}
}
