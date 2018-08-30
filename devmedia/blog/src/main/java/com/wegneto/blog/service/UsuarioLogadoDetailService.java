package com.wegneto.blog.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.wegneto.blog.entity.Usuario;
import com.wegneto.blog.entity.UsuarioLogado;

@Service
public class UsuarioLogadoDetailService implements UserDetailsService {

	private static final Logger logger = Logger.getLogger(UsuarioLogadoDetailService.class);

	@Autowired
	private UsuarioService usuarioService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = null;

		try {
			usuario = usuarioService.findByEmail(username);
			logger.info("Usuário {" + username + "} encontrado.");
		} catch (Exception e) {
			logger.error("Usuário {" + username + "} não encontrado.");
			throw new UsernameNotFoundException("Usuário não encontrado!");
		}

		return new UsuarioLogado(usuario);
	}

}
