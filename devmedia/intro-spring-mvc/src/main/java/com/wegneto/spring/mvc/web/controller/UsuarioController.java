package com.wegneto.spring.mvc.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.wegneto.spring.mvc.dao.UsuarioDAO;

@Controller
@RequestMapping("usuario")
public class UsuarioController {

	@Autowired
	private UsuarioDAO dao;

	@RequestMapping(value = "/todos", method = RequestMethod.GET)
	public ModelAndView listarTodos(ModelMap model) {
		model.addAttribute("usuarios", dao.findAll());
		return new ModelAndView("/user/list", model);
	}

}
