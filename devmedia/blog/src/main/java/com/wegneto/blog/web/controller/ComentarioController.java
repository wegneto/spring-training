package com.wegneto.blog.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wegneto.blog.entity.Comentario;
import com.wegneto.blog.entity.Postagem;
import com.wegneto.blog.service.ComentarioService;
import com.wegneto.blog.service.PostagemService;

@Controller
@RequestMapping(value = "comentario")
public class ComentarioController {

	@Autowired
	private ComentarioService comentarioService;
	
	@Autowired
	private PostagemService postagemService;
	
	public String save(@ModelAttribute("comentario") Comentario comentario, @RequestParam("permalink") String permalink) {
		Postagem postagem = postagemService.findByPermalink(permalink);
		
		comentario.setPostagem(postagem);
		
		comentarioService.save(comentario);
		
		return "redirect:/" + permalink;
	}
	
}
