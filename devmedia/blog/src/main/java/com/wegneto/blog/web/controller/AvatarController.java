package com.wegneto.blog.web.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.wegneto.blog.entity.Avatar;
import com.wegneto.blog.entity.Usuario;
import com.wegneto.blog.service.AvatarService;
import com.wegneto.blog.service.UsuarioService;
import com.wegneto.blog.web.validator.AvatarValidator;

@Controller
@RequestMapping("avatar")
public class AvatarController {
	
	private static final Logger LOGGER = Logger.getLogger(AvatarController.class);

	@Autowired
	private AvatarService avatarService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping(value = "/load/{id}", method = RequestMethod.GET)
	public ResponseEntity<byte[]> loadAvatar(@PathVariable("id") Long id) {
		Avatar avatar = avatarService.findById(id);
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.valueOf(avatar.getTipo()));
		
		InputStream inputStream = new ByteArrayInputStream(avatar.getAvatar());
		try {
			return new ResponseEntity<>(IOUtils.toByteArray(inputStream), headers, HttpStatus.OK);
		} catch (IOException e) {
			LOGGER.error("Ocorreu um erro ao recuperar o avatar.", e.getCause());
		} finally {
			try {
				inputStream.close();
			} catch (IOException e) {
				LOGGER.error("Ocorreu um erro ao fechar o stream do arquivo.", e.getCause());
			}
		}
		
		return null;
	}
	
	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public ModelAndView preUpdate(@PathVariable("id") Long id, @ModelAttribute("avatar") Avatar avatar) {
		ModelAndView view = new ModelAndView("avatar/atualizar");
		
		view.addObject("id", id);
		
		return view;
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@ModelAttribute("avatar") @Validated Avatar avatar, BindingResult result) {
		AvatarValidator validator = new AvatarValidator();
		validator.validate(avatar, result);
		
		if (result.hasErrors()) {
			return "avatar/atualizar";
		}
		
		Long id = avatar.getId();
		avatar = avatarService.getAvatarByUpload(avatar.getFile());
		avatar.setId(id);
		
		avatarService.saveOrUpdate(avatar);
		
		Usuario usuario = usuarioService.findByAvatar(avatar);
		
		return "redirect:/usuario/perfil/" + usuario.getId();
	}
	
}
