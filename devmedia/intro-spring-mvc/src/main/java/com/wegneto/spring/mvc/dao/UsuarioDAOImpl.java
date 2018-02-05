package com.wegneto.spring.mvc.dao;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.github.javafaker.Faker;
import com.wegneto.spring.mvc.domain.Usuario;

@Repository
public class UsuarioDAOImpl implements UsuarioDAO {

	private Faker faker = new Faker();

	private static List<Usuario> userList;

	public UsuarioDAOImpl() {
		createUserList();
	}

	private void createUserList() {
		if (userList == null) {
			userList = new LinkedList<>();
			for (int i = 1; i <= 10; i++) {
				userList.add(new Usuario(UUID.randomUUID(), faker.name().firstName(), faker.name().lastName()));
			}
		}
	}

	@Override
	public void salvar(Usuario usuario) {
		usuario.setId(UUID.randomUUID());
		userList.add(usuario);
	}

	@Override
	public void editar(Usuario usuario) {
		userList.stream().filter(u -> u.getId().equals(usuario.getId())).forEach(u -> {
			u.setNome(usuario.getNome());
			u.setSobrenome(usuario.getSobrenome());
		});
	}

	@Override
	public void excluir(UUID id) {
		userList.removeIf(u -> u.getId().equals(id));
	}

	@Override
	public Usuario findById(UUID id) {
		return userList.stream().filter(u -> u.getId().equals(id))
				.collect(Collectors.toList()).get(0);
	}

	@Override
	public List<Usuario> findAll() {
		return userList;
	}

}
