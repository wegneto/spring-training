package com.wegneto.blog.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.wegneto.blog.entity.Comentario;
import com.wegneto.blog.repository.ComentarioRepository;

@Service
@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
public class ComentarioService {

	@Autowired
	private ComentarioRepository repository;
	
	@Transactional(readOnly = false)
	public void save(Comentario comentario) {
		comentario.setDataComentario(LocalDateTime.now());
		repository.save(comentario);
	}
	
}
