package com.wegneto.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wegneto.blog.entity.Avatar;
import com.wegneto.blog.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	Usuario findByEmail(String email);
	
	Usuario findByAvatar(Avatar avatar);
	
}
