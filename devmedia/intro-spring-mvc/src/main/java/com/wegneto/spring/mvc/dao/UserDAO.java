package com.wegneto.spring.mvc.dao;

import java.util.List;
import java.util.UUID;

import com.wegneto.spring.mvc.domain.User;

public interface UserDAO {

	void save(User usuario);

	void update(User usuario);

	void delete(UUID id);

	User findById(UUID id);

	List<User> findAll();

}
