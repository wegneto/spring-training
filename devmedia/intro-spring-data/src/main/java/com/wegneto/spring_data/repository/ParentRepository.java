package com.wegneto.spring_data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wegneto.spring_data.entity.Parent;

public interface ParentRepository extends JpaRepository<Parent, Long> {
	
}
