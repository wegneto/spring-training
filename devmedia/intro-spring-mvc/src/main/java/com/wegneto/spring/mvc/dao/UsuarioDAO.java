package com.wegneto.spring.mvc.dao;

import java.util.List;
import java.util.UUID;

import com.wegneto.spring.mvc.domain.Usuario;

public interface UsuarioDAO {

	void salvar(Usuario usuario);

	void editar(Usuario usuario);

	void excluir(UUID id);

	Usuario findById(UUID id);

	List<Usuario> findAll();

}
