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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wegneto.blog.entity.Avatar;
import com.wegneto.blog.service.AvatarService;

@Controller
@RequestMapping("avatar")
public class AvatarController {
	
	private static final Logger LOGGER = Logger.getLogger(AvatarController.class);

	@Autowired
	private AvatarService avatarService;
	
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
	
}
