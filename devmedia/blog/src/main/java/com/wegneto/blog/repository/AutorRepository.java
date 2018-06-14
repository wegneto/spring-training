package com.wegneto.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.wegneto.blog.entity.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long> {
	
	Autor findByNome(String nome);

	@Modifying
	@Query("update Autor set nome = ?1, biografia = ?2 where id = ?3")
	void update(String nome, String biografia, Long id);
	
}
