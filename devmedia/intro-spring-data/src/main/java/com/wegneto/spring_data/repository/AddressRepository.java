package com.wegneto.spring_data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wegneto.spring_data.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
