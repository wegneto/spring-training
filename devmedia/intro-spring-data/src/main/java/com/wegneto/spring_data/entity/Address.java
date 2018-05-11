package com.wegneto.spring_data.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "address")
@NamedQuery(name = "Address.findByCity", query = "select a from Address a where a.city like ?1")
@NamedNativeQueries(
		@NamedNativeQuery(
				name = "Address.findByCityAndStreet", 
				query = "select * from address where city like ?1 and street like ?2", 
				resultClass = Address.class))
public class Address implements Serializable {

	public enum TypeAddress {
		HOME, WORK
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String city;

	@Column(nullable = false)
	private String street;

	@Enumerated(EnumType.STRING)
	@Column(name = "type_address", nullable = false)
	private TypeAddress typeAddress;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "person_address", joinColumns = @JoinColumn(name = "id_address"), inverseJoinColumns = @JoinColumn(name = "id_person"))
	private List<Person> persons;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public TypeAddress getTypeAddress() {
		return typeAddress;
	}

	public void setTypeAddress(TypeAddress typeAddress) {
		this.typeAddress = typeAddress;
	}

	public List<Person> getPersons() {
		return persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
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
		Address other = (Address) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", city=" + city + ", street=" + street + ", typeAddress=" + typeAddress
				+ ", persons=" + persons + "]";
	}

}
