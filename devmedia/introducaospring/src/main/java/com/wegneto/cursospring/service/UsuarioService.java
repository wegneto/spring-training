package com.wegneto.cursospring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wegneto.cursospring.domain.Mailer;
import com.wegneto.cursospring.domain.Usuario;

@Service
public class UsuarioService {

	private Usuario usuario;
	 
    @Autowired
    private Mailer mailer;
 
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
 
    public void lembrarSenhaPorEmail() {
        mailer.setDestinatario(usuario.getEmail());
        mailer.setMensagem("A senha do usuário " + usuario.getLogin() + " é xxx");
        mailer.enviarEmail();
    }
}
