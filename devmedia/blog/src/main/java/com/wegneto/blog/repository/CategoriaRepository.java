package com.wegneto.blog.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.wegneto.blog.entity.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
	
	Categoria findByDescricao(String descricao);
	
	Page<Categoria> findAllByOrderByDescricaoAsc(Pageable pageable);

}
