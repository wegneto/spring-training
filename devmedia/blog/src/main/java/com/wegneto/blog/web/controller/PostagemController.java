package com.wegneto.blog.web.controller;

import java.util.List;

import javax.swing.text.View;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.wegneto.blog.entity.Postagem;
import com.wegneto.blog.service.CategoriaService;
import com.wegneto.blog.service.PostagemService;
import com.wegneto.blog.web.editor.CategoriaEditorSupport;
import com.wegneto.blog.web.validator.PostagemAjaxValidator;

@Controller
@RequestMapping("postagem")
public class PostagemController {

	@Autowired
	private PostagemService postagemService;

	@Autowired
	private CategoriaService categoriaService;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(List.class, new CategoriaEditorSupport(List.class, categoriaService));
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView cadastro(@ModelAttribute("postagem") Postagem postagem) {
		ModelAndView view = new ModelAndView("postagem/cadastro");
		view.addObject("categorias", categoriaService.findAll());

		return view;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("postagem") @Validated Postagem postagem, BindingResult result) {
		ModelAndView view = new ModelAndView();
		
		if (result.hasErrors()) {
			view.setViewName("postagem/cadastro");
			view.addObject("categorias", categoriaService.findAll());
		} else {
			postagemService.saveOrUpdate(postagem);
			view.setViewName("redirect:/postagem/list");
		}

		return view;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list(ModelMap model) {
		Page<Postagem> page = postagemService.findByPagination(0, 5);
		model.addAttribute("page", page);
		model.addAttribute("urlPagination", "/postagem/page");

		return new ModelAndView("postagem/list", model);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable("id") Long id) {
		postagemService.delete(id);
		return "redirect:/postagem/list";
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public ModelAndView preUpdate(@PathVariable("id") Long id, ModelMap model) {
		Postagem postagem = postagemService.findById(id);
		model.addAttribute("postagem", postagem);
		model.addAttribute("categorias", categoriaService.findAll());

		return new ModelAndView("postagem/cadastro", model);
	}

	@RequestMapping(value = "/ajax/page/{page}", method = RequestMethod.GET)
	public ModelAndView pagePostagens(@PathVariable("page") Integer pagina) {
		ModelAndView view = new ModelAndView("postagem/table-rows");

		Page<Postagem> page = postagemService.findByPagination(pagina - 1, 5);
		view.addObject("page", page);

		return view;
	}

	@RequestMapping(value = "/ajax/titulo/{titulo}/page/{page}", method = RequestMethod.GET)
	public ModelAndView searchByAjax(@PathVariable("titulo") String titulo, @PathVariable("page") Integer pagina) {
		ModelAndView view = new ModelAndView("postagem/table-rows");

		Page<Postagem> page = postagemService.findByTitulo(pagina - 1, 5, titulo);
		view.addObject("page", page);

		return view;
	}

	@RequestMapping(value = "/ajax/add", method = RequestMethod.GET)
	public ModelAndView cadastroAjax() {
		ModelAndView view = new ModelAndView("postagem/cadastro-ajax");
		view.addObject("categorias", categoriaService.findAll());

		return view;
	}

	@RequestMapping(value = "/ajax/save", method = RequestMethod.POST)
	public @ResponseBody PostagemAjaxValidator saveAjax(@Validated Postagem postagem, BindingResult result) {
		PostagemAjaxValidator validator = new PostagemAjaxValidator();

		if (result.hasErrors()) {
			validator.setStatus("FAIL");
			validator.validar(result);
			return validator;
		}

		postagemService.saveOrUpdate(postagem);

		validator.setPostagem(postagem);

		return validator;
	}

}
