package com.wegneto.hellojpa.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.wegneto.hellojpa.util.JPAUtil;

public abstract class GenericDAO<T extends Serializable> {
	
	private Class<T> aClass;
	
	protected GenericDAO(Class<T> aClass) {
		this.aClass = aClass;
	}
	
	protected EntityManager getEntityManager() {
		return JPAUtil.getInstance().getEntityManager();
	}
	
	public void save(T entity) {
		EntityManager manager = getEntityManager();
		manager.getTransaction().begin();
		manager.persist(entity);
		manager.getTransaction().commit();
		manager.close();
	}
	
	public void update(T entity) {
		EntityManager manager = getEntityManager();
		manager.getTransaction().begin();
		manager. merge(entity);
		manager.getTransaction().commit();
		manager.close();
	}
	
	public void delete(Long id) {
		EntityManager manager = getEntityManager();
		manager.getTransaction().begin();
		manager. remove(manager.getReference(aClass, id));
		manager.getTransaction().commit();
		manager.close();
	}
	
	public T findById(Long id) {
		EntityManager manager = getEntityManager();
		manager.getTransaction().begin();
		
		T entity = (T) manager.find(aClass, id);
		
		manager.getTransaction().commit();
		manager.close();

		return entity;
	}
	
	public List<T> findAll() {
		EntityManager manager = getEntityManager();
		manager.getTransaction().begin();
		
		Query query = manager.createQuery("from " + aClass.getSimpleName());
		List<T> resultList = query.getResultList();
		
		manager.getTransaction().commit();
		manager.close();

		return resultList;
	}

}
