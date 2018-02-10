package com.wegneto.spring.mvc.domain;

import java.time.LocalDate;
import java.util.UUID;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

public class User {

	private UUID id;

	private String name;

	private String surname;

	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate birthday;

	public User() {
	}

	public User(UUID id, String name, String surname) {
		this.id = id;
		this.name = name;
		this.surname = surname;
	}
	
	public User(UUID id, String name, String surname, LocalDate birthday) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.birthday = birthday;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", surname=" + surname + "]";
	}

}
