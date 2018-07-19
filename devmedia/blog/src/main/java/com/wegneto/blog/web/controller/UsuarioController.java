package com.wegneto.blog.web.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.wegneto.blog.entity.Avatar;
import com.wegneto.blog.entity.Perfil;
import com.wegneto.blog.entity.Usuario;
import com.wegneto.blog.service.AvatarService;
import com.wegneto.blog.service.UsuarioService;
import com.wegneto.blog.web.editor.PerfilEditorSupport;

@Controller
@RequestMapping("usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private AvatarService avatarService;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Perfil.class, new PerfilEditorSupport());
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView showForm(@ModelAttribute("usuario") Usuario usuario) {
		return new ModelAndView("usuario/cadastro");
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("usuario") Usuario usuario,
			@RequestParam(value = "file", required = false) MultipartFile file) {
		Avatar avatar = avatarService.getAvatarByUpload(file);
		usuario.setAvatar(avatar);
		usuarioService.save(usuario);

		return "redirect:/usuario/perfil/" + usuario.getId();
	}

	@RequestMapping(value = "/perfil/{id}", method = RequestMethod.GET)
	public ModelAndView perfil(@PathVariable("id") Long id) {
		Usuario usuario = usuarioService.findById(id);

		ModelAndView view = new ModelAndView();
		view.addObject("usuario", usuario);
		view.setViewName("usuario/perfil");

		return view;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView listUsuarios(ModelMap model) {
		Page<Usuario> page = usuarioService.findByPagination(0, 5);
		model.addAttribute("page", page);

		return new ModelAndView("usuario/list", model);
	}

	@RequestMapping(value = { "/update/{id}", "/update" }, method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView update(@PathVariable("id") Optional<Long> id, @ModelAttribute("usuario") Usuario usuario) {
		ModelAndView view = new ModelAndView();

		if (id.isPresent()) {
			usuario = usuarioService.findById(id.get());
			view.addObject("usuario", usuario);
			view.setViewName("usuario/atualizar");
		} else {
			usuarioService.updateNomeAndEmail(usuario);
			view.setViewName("redirect:/usuario/perfil/" + usuario.getId());
		}

		return view;
	}

	@RequestMapping(value = { "/update/senha/{id}", "/update/senha" }, method = { RequestMethod.GET,
			RequestMethod.POST })
	public ModelAndView updateSenha(@PathVariable("id") Optional<Long> id, @ModelAttribute("usuario") Usuario usuario) {
		ModelAndView view = new ModelAndView();

		if (id.isPresent()) {
			usuario = usuarioService.findById(id.get());
			view.addObject("usuario", usuario);
			view.setViewName("usuario/atualizar");
		} else {
			usuarioService.updateSenha(usuario);
			view.setViewName("redirect:/usuario/perfil/" + usuario.getId());
		}

		return view;
	}

	@RequestMapping(value = "/page/{page}", method = RequestMethod.GET)
	public ModelAndView pageUsuarios(@PathVariable("page") Integer pagina) {
		ModelAndView view = new ModelAndView("usuario/list");

		Page<Usuario> page = usuarioService.findByPagination(pagina - 1, 5);
		view.addObject("page", page);

		return view;
	}

}
