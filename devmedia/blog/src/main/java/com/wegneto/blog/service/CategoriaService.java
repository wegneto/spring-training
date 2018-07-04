package com.wegneto.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.wegneto.blog.entity.Categoria;
import com.wegneto.blog.repository.CategoriaRepository;
import com.wegneto.blog.util.MyReplaceString;

@Service
@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
public class CategoriaService {

	@Autowired
	private CategoriaRepository repository;

	@Transactional(readOnly = false)
	public void saveOrUpdate(Categoria categoria) {
		String permalink = MyReplaceString.formatarPermalink(categoria.getDescricao());
		categoria.setPermalink(permalink);
		repository.save(categoria);
	}

	@Transactional(readOnly = false)
	public void delete(Long id) {
		repository.delete(id);
	}

	public Categoria findById(Long id) {
		return repository.findOne(id);
	}

	public Categoria findByDescricao(String descricao) {
		return repository.findByDescricao(descricao);
	}

	public List<Categoria> findAll() {
		Sort sort = new Sort(new Order(Direction.ASC, "descricao"));
		return repository.findAll(sort);
	}

}
