package com.wegneto.spring.mvc.domain;

public enum Gender {
	
	MALE('M'), FEMALE('F');
	
	private char description;
	
	Gender(char description) {
		this.description = description;
	}

	public char getDescription() {
		return description;
	}

	public String toString() {
		return super.toString();
	}
	
}
