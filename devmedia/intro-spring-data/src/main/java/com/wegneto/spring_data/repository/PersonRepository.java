package com.wegneto.spring_data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.wegneto.spring_data.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

	List<Person> findByAge(Integer age);
	
	List<Person> findByAgeNot(Integer age);
	
	List<Person> findByFirstNameLike(String firstName);
	
	List<Person> findByFirstNameNotLike(String firstName);
	
	Person findByFirstNameAndLastName(String firstName, String lastName);
	
	List<Person> findByFirstNameOrLastName(Integer age, String firstName);
	
	List<Person> findByAgeGreaterThan(Integer age);
	
	List<Person> findByAgeLessThan(Integer age);
	
	List<Person> findByAgeGreaterThanEqual(Integer age);
	
	List<Person> findByAgeLessThanEqual(Integer age);
	
	List<Person> findByFirstNameGreaterThan(String firstName);
	
	List<Person> findByAgeIn(Integer... ages);
	
	List<Person> findByAgeNotIn(Integer... ages);
	
	List<Person> findByDocumentIsNull();
	
	@Query("select p from Person p where p.firstName like ?1")
	List<Person> findByFirstName(String firstName);
	
	@Query("select p from Person p where p.document.cpf like %?1")
	List<Person> findByDocumentCPFEndsWith(String value);
	
	@Query("select p from Person p where p.age >= :min and p.age <= :max ")
	List<Person> findByAgeBetween(@Param("min") Integer start, @Param("max") Integer end);
	
	@Query("select p from Person p where p.firstName in (:firstNames) ")
	List<Person> findByFirstNames(@Param("firstNames") String...firstNames);
	
	Person findFirstByOrderByLastNameDesc();
	
	Person findFirstByOrderByLastNameAsc();
	
	Person findTopByOrderByAgeAsc();
	
	Person findTopByOrderByAgeDesc();
	
}
