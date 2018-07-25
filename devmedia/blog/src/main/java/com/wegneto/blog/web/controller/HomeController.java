package com.wegneto.blog.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.wegneto.blog.entity.Comentario;
import com.wegneto.blog.entity.Postagem;
import com.wegneto.blog.service.PostagemService;

@Controller
public class HomeController {

	@Autowired
	private PostagemService postagemService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home(ModelMap model) {
		Page<Postagem> page = postagemService.findByPagination(0, 5);
		model.addAttribute("page", page);
		model.addAttribute("urlPagination", "/page");

		return new ModelAndView("posts", model);
	}

	@RequestMapping(value = "/categoria/{link}/page/{page}", method = RequestMethod.GET)
	public ModelAndView postsByCategoria(@PathVariable("page") Integer pagina, @PathVariable("link") String link,
			ModelMap model) {
		Page<Postagem> page = postagemService.findByPaginationByCategoria(pagina - 1, 5, link);
		model.addAttribute("page", page);
		model.addAttribute("urlPagination", "/categoria/" + link + "/page");

		return new ModelAndView("posts", model);
	}

	@RequestMapping(value = "/autor/{id}/page/{page}", method = RequestMethod.GET)
	public ModelAndView postsByAutor(@PathVariable("id") Long id, @PathVariable("page") Integer pagina,
			ModelMap model) {
		Page<Postagem> page = postagemService.findByPaginationByAutor(pagina - 1, 5, id);
		model.addAttribute("page", page);
		model.addAttribute("urlPagination", "/autor/" + id + "/page");

		return new ModelAndView("posts", model);
	}

	@RequestMapping(value = "/{permalink}", method = RequestMethod.GET)
	public ModelAndView openPostagem(@PathVariable("permalink") String permalink, ModelMap model,
			@ModelAttribute("comentario") Comentario comentario) {
		Postagem postagem = postagemService.findByPermalink(permalink);

		model.addAttribute("postagem", postagem);

		return new ModelAndView("post", model);
	}

	@RequestMapping(value = "/page/{page}", method = RequestMethod.GET)
	public ModelAndView pageHome(@PathVariable("page") Integer pagina, ModelMap model) {
		Page<Postagem> page = postagemService.findByPagination(pagina - 1, 5);
		model.addAttribute("page", page);
		model.addAttribute("urlPagination", "/page");

		return new ModelAndView("posts", model);
	}

}
