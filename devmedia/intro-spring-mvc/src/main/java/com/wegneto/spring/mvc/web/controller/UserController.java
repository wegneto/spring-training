package com.wegneto.spring.mvc.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.wegneto.spring.mvc.dao.UserDAO;
import com.wegneto.spring.mvc.domain.Gender;
import com.wegneto.spring.mvc.domain.User;

@Controller
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserDAO dao;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView listAll(ModelMap model) {
		model.addAttribute("users", dao.findAll());
		return new ModelAndView("/user/list", model);
	}

	@GetMapping("/create")
	public String create(@ModelAttribute("user") User user, ModelMap model) {
		model.addAttribute("genders", Gender.values());
		return "/user/add";
	}

	@PostMapping("/save")
	public String save(@Valid @ModelAttribute("user") User user, BindingResult bindingResult,
			RedirectAttributes redirectAttributes) {
		if (bindingResult.hasErrors()) {
			return "/user/add";
		}
		
		dao.save(user);
		redirectAttributes.addFlashAttribute("message", "Usuário salvo com sucesso.");
		return "redirect:/user/";
	}

	@GetMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable("id") Long id, ModelMap model) {
		User usuario = dao.findById(id);
		model.addAttribute("user", usuario);
		return new ModelAndView("/user/add", model);
	}

	@PostMapping("/update")
	public ModelAndView update(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
		if (bindingResult.hasErrors()) {
			return new ModelAndView("/user/add");
		}
		
		dao.update(user);
		redirectAttributes.addFlashAttribute("message", "Usuário editado com sucesso.");
		return new ModelAndView("redirect:/user/");
	}

	@GetMapping("/remove/{id}")
	public String remove(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
		dao.delete(id);
		redirectAttributes.addFlashAttribute("message", "Usuário excluido com sucesso.");
		return "redirect:/user/";
	}

}
