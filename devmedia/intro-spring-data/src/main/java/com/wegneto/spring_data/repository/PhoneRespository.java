package com.wegneto.spring_data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.wegneto.spring_data.entity.Phone;

public interface PhoneRespository extends JpaRepository<Phone, Long> {
	
	@Modifying
	@Transactional(readOnly = false)
	@Query("update Phone p set p.number = ?1 where p.id = ?2")
	int updatePhoneNumber(String number, Long id);

}
