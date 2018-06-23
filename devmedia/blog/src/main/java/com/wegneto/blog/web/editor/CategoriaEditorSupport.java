package com.wegneto.blog.web.editor;

import java.util.Collection;

import org.springframework.beans.propertyeditors.CustomCollectionEditor;

import com.wegneto.blog.entity.Categoria;
import com.wegneto.blog.service.CategoriaService;

public class CategoriaEditorSupport extends CustomCollectionEditor {
	
	private CategoriaService service;

	public CategoriaEditorSupport(Class<? extends Collection> collectionType, CategoriaService service) {
		super(collectionType);
		this.service = service;
	}

	@Override
	protected Object convertElement(Object element) {
		Long id = Long.valueOf(element.toString());
		
		Categoria categoria = service.findById(id);
		
		return super.convertElement(categoria);
	}

}
