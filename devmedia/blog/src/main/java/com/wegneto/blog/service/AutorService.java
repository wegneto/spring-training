package com.wegneto.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.wegneto.blog.entity.Autor;
import com.wegneto.blog.repository.AutorRepository;

@Service
@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
public class AutorService {

	@Autowired
	private AutorRepository repository;
	
	public Autor findById(Long id) {
		return repository.findOne(id);
	}
	
	public Autor findByNome(String nome) {
		return repository.findByNome(nome);
	}
	
	public List<Autor> findAll() {
		return repository.findAll();
	}
	
	@Transactional(readOnly = false)
	public void save(Autor autor) {
		if (autor.getId() == null) {
			repository.save(autor);			
		} else {
			repository.update(autor.getNome(), autor.getBiografia(), autor.getId());
		}
	}

	@Transactional(readOnly = false)
	public void delete(Long id) {
		repository.delete(id);
	}
	
	public Page<Autor> findByPagination(int page, int size) {
		Pageable pageable = new PageRequest(page, size);
		return repository.findAllByOrderByNomeAsc(pageable);
	}
	
}
