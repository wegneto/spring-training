package com.wegneto.blog.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

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
	
	@ExceptionHandler(MaxUploadSizeExceededException.class)
	public ModelAndView genericException(HttpServletRequest request, MaxUploadSizeExceededException exception) {
		ModelAndView view = new ModelAndView("error");
		view.addObject("mensagem", "Ocorreu um erro durante a operação: o arquivo ultrapassa o tamanho permitido. Tente novamente.");
		view.addObject("url", request.getRequestURL());
		view.addObject("excecao", exception);
		
		return view;
	}
	
	@ExceptionHandler(NoHandlerFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND, code = HttpStatus.NOT_FOUND)
	public ModelAndView noHandlerFoundException(HttpServletRequest request, NoHandlerFoundException exception) {
		ModelAndView view = new ModelAndView("error");
		view.addObject("mensagem", "Ops... <br> Esta página não existe!");
		view.addObject("url", request.getRequestURL());
		view.addObject("excecao", exception);
		
		return view;
	}
	
}
