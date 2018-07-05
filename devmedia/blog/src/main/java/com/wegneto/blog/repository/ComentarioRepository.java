package com.wegneto.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wegneto.blog.entity.Comentario;

public interface ComentarioRepository extends JpaRepository<Comentario, Long> {

}
