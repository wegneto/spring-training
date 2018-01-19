package com.wegneto.database.databasedemo.springdata;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wegneto.database.databasedemo.entity.Person;

public interface PersonSpringDataRepository extends JpaRepository<Person, Integer> {
}