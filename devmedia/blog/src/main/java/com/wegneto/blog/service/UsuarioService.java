package com.wegneto.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.wegneto.blog.entity.Avatar;
import com.wegneto.blog.entity.Usuario;
import com.wegneto.blog.repository.UsuarioRepository;

@Service
@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repository;
	
	public List<Usuario> findAll() {
		return repository.findAll();
	}
	
	public Usuario findByEmail(String email) {
		return repository.findByEmail(email);
	}
	
	public Usuario findByAvatar(Avatar avatar) {
		return repository.findByAvatar(avatar);
	}
	
	public Usuario findById(Long id) {
		return repository.findOne(id);
	}

}
