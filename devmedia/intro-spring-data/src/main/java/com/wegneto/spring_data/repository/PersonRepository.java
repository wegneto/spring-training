package com.wegneto.spring_data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wegneto.spring_data.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

	List<Person> findByAge(Integer age);
	
	List<Person> findByAgeNot(Integer age);
	
	List<Person> findByFirstNameLike(String firstName);
	
	List<Person> findByFirstNameNotLike(String firstName);
	
}
