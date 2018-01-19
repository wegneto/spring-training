package com.wegneto.database.databasedemo.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.wegneto.database.databasedemo.entity.Person;

@Repository
@Transactional
public class PersonJpaRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	public Person findById(int id) {
		return entityManager.find(Person.class, id);
	}
	
	public Person update(Person person) {
		return entityManager.merge(person);
	}
	
	public Person insert(Person person) {
		return entityManager.merge(person);
	}
	
	public void delete(int id) {
		Person person = findById(id);
		entityManager.remove(person);
	}
}
