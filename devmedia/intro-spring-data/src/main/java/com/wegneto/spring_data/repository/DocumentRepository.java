package com.wegneto.spring_data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

import com.wegneto.spring_data.entity.Document;

public interface DocumentRepository extends JpaRepository<Document, Long> {
	
	@Procedure(procedureName = "procReplaceCPF")
	String replaceCPF(Long id);
	
	@Procedure
	String storedProcedureReplaceCPF(Long id);

}
