package com.wegneto.spring_data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wegneto.spring_data.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

	List<Person> findByAge(Integer age);
	
	List<Person> findByAgeNot(Integer age);
	
	List<Person> findByFirstNameLike(String firstName);
	
	List<Person> findByFirstNameNotLike(String firstName);
	
	Person findByFirstNameAndLastName(String firstName, String lastName);
	
	List<Person> findByFirstNameOrLastName(Integer age, String firstName);
	
	List<Person> findByAgeBetween(Integer min, Integer max);
	
	List<Person> findByAgeGreaterThan(Integer age);
	
	List<Person> findByAgeLessThan(Integer age);
	
	List<Person> findByAgeGreaterThanEqual(Integer age);
	
	List<Person> findByAgeLessThanEqual(Integer age);
	
	List<Person> findByFirstNameGreaterThan(String firstName);
	
	List<Person> findByAgeIn(Integer... ages);
	
	List<Person> findByAgeNotIn(Integer... ages);
	
}
