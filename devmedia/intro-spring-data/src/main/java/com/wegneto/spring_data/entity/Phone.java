package com.wegneto.spring_data.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "phones")
public class Phone implements Serializable {

	public enum TypePhone {
		HOME, WORK, MOBILE
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Enumerated(EnumType.STRING)
	@Column(name = "type_phone", nullable = false)
	private TypePhone typePhone;

	@Column(nullable = false)
	private String number;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "person_id")
	private Person person;

	public Phone() {
		super();
	}

	public Phone(TypePhone typePhone, String number) {
		super();
		this.typePhone = typePhone;
		this.number = number;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TypePhone getTypePhone() {
		return typePhone;
	}

	public void setTypePhone(TypePhone typePhone) {
		this.typePhone = typePhone;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Phone other = (Phone) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Phone [id=" + id + ", typePhone=" + typePhone + ", number=" + number + ", person=" + person + "]";
	}

}
