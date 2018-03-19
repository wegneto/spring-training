package com.wegneto.spring_data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wegneto.spring_data.entity.Phone;

public interface PhoneRespository extends JpaRepository<Phone, Long> {

}
