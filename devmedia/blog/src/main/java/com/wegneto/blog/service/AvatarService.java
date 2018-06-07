package com.wegneto.blog.service;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.wegneto.blog.entity.Avatar;
import com.wegneto.blog.repository.AvatarRepository;

@Service
@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
public class AvatarService {
	
	private static final Logger LOGGER = Logger.getLogger(AvatarService.class);

	@Autowired
	private AvatarRepository avatarRepository;

	@Transactional(readOnly = false)
	public void saveOrUpdate(Avatar avatar) {
		avatarRepository.save(avatar);
	}

	public Avatar getAvatarByUpload(MultipartFile file) {
		Avatar avatar = new Avatar();

		if (file != null && file.getSize() > 0) {
			try {
				avatar.setTitulo(file.getOriginalFilename());
				avatar.setTipo(file.getContentType());
				avatar.setAvatar(file.getBytes());
			} catch (IOException e) {
				LOGGER.error("Ocorreu um erro ao fazer o upload do arquivo: " + e.getMessage());
			}
		}

		return avatar;
	}

	public Avatar findById(Long id) {
		return avatarRepository.findOne(id);
	}

}
