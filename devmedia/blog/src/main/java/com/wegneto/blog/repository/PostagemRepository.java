package com.wegneto.blog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wegneto.blog.entity.Postagem;

public interface PostagemRepository extends JpaRepository<Postagem, Long>{

	Postagem findByPermalink(String permalink);

	List<Postagem> findByCategoriasPermalink(String link);

	List<Postagem> findByAutorNome(String nome);
	
}
