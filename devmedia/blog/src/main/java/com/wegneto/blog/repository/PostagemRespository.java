package com.wegneto.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wegneto.blog.entity.Postagem;

public interface PostagemRespository extends JpaRepository<Postagem, Long>{

	Postagem findByPermalink(String permalink);
	
}
