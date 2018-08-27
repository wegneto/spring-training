package com.wegneto.blog.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionController {

	@ExceptionHandler(Exception.class)
	public ModelAndView genericException(HttpServletRequest request, Exception exception) {
		ModelAndView view = new ModelAndView("error");
		view.addObject("mensagem", "Ocorreu um erro durante a operação. Tente novamente.");
		view.addObject("url", request.getRequestURL());
		view.addObject("excecao", exception);
		
		return view;
	}
	
}
