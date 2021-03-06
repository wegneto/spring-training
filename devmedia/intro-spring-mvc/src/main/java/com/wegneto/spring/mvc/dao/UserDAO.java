package com.wegneto.spring.mvc.dao;

import java.util.List;

import com.wegneto.spring.mvc.domain.Gender;
import com.wegneto.spring.mvc.domain.User;

public interface UserDAO {

	void save(User user);

	void update(User user);

	void delete(Long id);

	User findById(Long id);

	List<User> findAll();
	
	List<User> findByGender(Gender gender);
	
	List<User> findByName(String name);

}
