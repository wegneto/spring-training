package com.wegneto.spring.mvc.dao;

import java.util.List;
import java.util.UUID;

import com.wegneto.spring.mvc.domain.Usuario;

public interface UserDAO {

	void save(Usuario usuario);

	void update(Usuario usuario);

	void delete(UUID id);

	Usuario findById(UUID id);

	List<Usuario> findAll();

}
