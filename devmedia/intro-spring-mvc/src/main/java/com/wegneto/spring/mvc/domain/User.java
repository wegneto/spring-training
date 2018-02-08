package com.wegneto.spring.mvc.domain;

import java.util.UUID;

public class User {

	private UUID id;

	private String name;

	private String surname;

	public User() {
	}

	public User(UUID id, String name, String surname) {
		this.id = id;
		this.name = name;
		this.surname = surname;
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

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", surname=" + surname + "]";
	}
	
}
