package com.wegneto.blog.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.wegneto.blog.entity.Postagem;
import com.wegneto.blog.repository.PostagemRepository;
import com.wegneto.blog.util.MyReplaceString;

@Service
@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
public class PostagemService {

	@Autowired
	private PostagemRepository repository;
	
	@Transactional(readOnly = false)
	public void saveOrUpdate(Postagem postagem) {
		if (postagem.getId() == null) {
			save(postagem);
		} else {
			update(postagem);
		}
	}
	
	private void save(Postagem postagem) {
		postagem.setPermalink(MyReplaceString.formatarPermalink(postagem.getTitulo()));
		postagem.setDataPostagem(LocalDateTime.now());
		repository.save(postagem);
		
	}

	private void update(Postagem postagem) {
		Postagem dbRecord = repository.findOne(postagem.getId());
		
		dbRecord.setTitulo(postagem.getTitulo());
		dbRecord.setTexto(postagem.getTexto());
		dbRecord.setCategorias(postagem.getCategorias());
		repository.save(dbRecord);
	}

	public Postagem findById(Long id) {
		return repository.findOne(id);
	}
	
	public Postagem findByPermalink(String permalink) {
		return repository.findByPermalink(permalink);
	}
	
	public List<Postagem> findAll() {
		return repository.findAll();
	}
	
	@Transactional(readOnly = false)
	public void delete(Long id) {
		repository.delete(id);
	}
	
}
