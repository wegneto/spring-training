package com.wegneto.spring_data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.wegneto.spring_data.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

	List<Address> findByCityStartingWith(String city);

	List<Address> findByStreetEndingWith(String street);

	List<Address> findByCityOrderByTypeAddressDesc(String city);

	List<Address> findByCity(String city);

	List<Address> findByCityAndStreet(String city, String street);

	@Query(value = "select * from address where city like ?1 and street like ?2", nativeQuery = true)
	Address findByAddress(String city, String street);

	String concatAddress(Long id);

	@Query(value = "select funcConcatAddress(?1)", nativeQuery = true)
	String concatAddress2(Long id);

}
