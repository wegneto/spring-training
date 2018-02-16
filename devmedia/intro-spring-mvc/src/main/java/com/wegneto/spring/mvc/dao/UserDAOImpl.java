package com.wegneto.spring.mvc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.wegneto.spring.mvc.domain.Gender;
import com.wegneto.spring.mvc.domain.User;

@Repository
@Transactional
public class UserDAOImpl implements UserDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void save(User user) {
		entityManager.persist(user);
	}

	@Override
	public void update(User user) {
		entityManager.merge(user);
	}

	@Override
	public void delete(Long id) {
		entityManager.remove(entityManager.getReference(User.class, id));
	}

	@Transactional(readOnly = true)
	public User findById(Long id) {
		String jpql = "from User u where u.id = :id";
		TypedQuery<User> query = entityManager.createQuery(jpql, User.class);
		query.setParameter("id", id);
		return query.getSingleResult();
	}

	@Transactional(readOnly = true)
	public List<User> findAll() {
		String jpql = "from User u";
		TypedQuery<User> query = entityManager.createQuery(jpql, User.class);
		return query.getResultList();
	}

	@Transactional(readOnly = true)
	public List<User> findByGender(Gender gender) {
		String jpql = "from User u where u.gender = :gender";
		TypedQuery<User> query = entityManager.createQuery(jpql, User.class);
		query.setParameter("gender", gender);
		return query.getResultList();
	}

	@Transactional(readOnly = true)
	public List<User> findByName(String name) {
		String jpql = "from User u where u.name like :name or u.surname like :surname";
		TypedQuery<User> query = entityManager.createQuery(jpql, User.class);
		query.setParameter("name", "%"+name+"%");
		query.setParameter("surname", "%"+name+"%");
		return query.getResultList();
	}

}
