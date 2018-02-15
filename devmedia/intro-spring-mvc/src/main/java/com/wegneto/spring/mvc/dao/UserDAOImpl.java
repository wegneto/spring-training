package com.wegneto.spring.mvc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
	public void update(User usuario) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub

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

}
