package com.wegneto.blog.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("comentario") @Validated Comentario comentario, BindingResult result, 
			@RequestParam("permalink") String permalink) {
		
		Postagem postagem = postagemService.findByPermalink(permalink);

		if (result.hasErrors()) {
			return new ModelAndView("post", "postagem", postagem);
		}

		comentario.setPostagem(postagem);
		comentarioService.save(comentario);

		return new ModelAndView("redirect:/" + permalink);
	}

}
