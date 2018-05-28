package com.wegneto.blog.service;

import java.io.IOException;

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
				e.printStackTrace();
			}
		}

		return avatar;
	}

}
