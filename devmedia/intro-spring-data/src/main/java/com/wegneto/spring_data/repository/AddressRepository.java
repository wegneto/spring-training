package com.wegneto.spring_data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wegneto.spring_data.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

	List<Address> findByCityStartingWith(String city);
	
	List<Address> findByStreetEndingWith(String street);
	
}
