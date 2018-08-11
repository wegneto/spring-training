package com.wegneto.blog.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.wegneto.blog.entity.Autor;
import com.wegneto.blog.service.AutorService;

@Controller
@RequestMapping("autor")
public class AutorController {

	@Autowired
	private AutorService service;
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView addAutor(@ModelAttribute("autor") Autor autor) {
		return new ModelAndView("autor/cadastro");
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("autor") @Validated Autor autor, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "autor/cadastro";
		}
		
		service.save(autor);
		return "redirect:/autor/perfil/" + autor.getId();
	}
	
	@RequestMapping(value = "/perfil/{id}", method = RequestMethod.GET)
	public ModelAndView getAutor(@PathVariable("id") Long id) {
		Autor autor = service.findById(id);
		
		ModelAndView view = new ModelAndView();
		view.addObject("autor", autor);
		view.setViewName("autor/perfil");
		
		return view;
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list() {
		Page<Autor> page = service.findByPagination(0, 5);
		
		ModelAndView view = new ModelAndView();
		view.addObject("page", page);
		view.addObject("urlPagination", "/autor/page");
		view.setViewName("autor/list");

		return view;
	}
	
	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public ModelAndView preUpdate(@PathVariable("id") Long id) {
		Autor autor = service.findById(id);
		
		ModelAndView view = new ModelAndView();
		view.addObject("autor", autor);
		view.setViewName("autor/cadastro");
		
		return view;
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable("id") Long id) {
		service.delete(id);
		return "redirect:/autor/add";
	}
	
	@RequestMapping(value = "/page/{page}", method = RequestMethod.GET)
	public ModelAndView pageAutores(@PathVariable("page") Integer pagina) {
		ModelAndView view = new ModelAndView("autor/list");

		Page<Autor> page = service.findByPagination(pagina - 1, 5);
		view.addObject("page", page);
		view.addObject("urlPagination", "/autor/page");

		return view;
	}
	
}
