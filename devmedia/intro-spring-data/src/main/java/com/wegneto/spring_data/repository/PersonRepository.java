package com.wegneto.spring_data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wegneto.spring_data.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
