package com.wegneto.spring.mvc.dao;

import java.time.ZoneId;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.github.javafaker.Faker;
import com.wegneto.spring.mvc.domain.Gender;
import com.wegneto.spring.mvc.domain.User;

@Repository
public class UserDAOImpl implements UserDAO {

	private Faker faker = new Faker();

	private static List<User> userList;

	public UserDAOImpl() {
		createUserList();
	}

	private void createUserList() {
		if (userList == null) {
			userList = new LinkedList<>();
			for (int i = 1; i <= 10; i++) {
				Gender gender = i % 2 == 0 ? Gender.MALE : Gender.FEMALE;
				userList.add(new User(UUID.randomUUID(), faker.name().firstName(), faker.name().lastName(),
						faker.date().birthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), gender));
			}
		}
	}

	@Override
	public void save(User usuario) {
		usuario.setId(UUID.randomUUID());
		userList.add(usuario);
	}

	@Override
	public void update(User user) {
		userList.stream().filter(u -> u.getId().equals(user.getId())).forEach(u -> {
			u.setName(user.getName());
			u.setSurname(user.getSurname());
			u.setBirthday(user.getBirthday());
			u.setGender(user.getGender());
		});
	}

	@Override
	public void delete(UUID id) {
		userList.removeIf(u -> u.getId().equals(id));
	}

	@Override
	public User findById(UUID id) {
		return userList.stream().filter(u -> u.getId().equals(id)).collect(Collectors.toList()).get(0);
	}

	@Override
	public List<User> findAll() {
		return userList;
	}

}
