package com.wegneto.blog.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	public String save(@ModelAttribute("autor") Autor autor) {
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
		List<Autor> autores = service.findAll();
		
		ModelAndView view = new ModelAndView();
		view.addObject("autores", autores);
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
	
}
