package com.wegneto.cursospring;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.wegneto.cursospring.domain.Usuario;
import com.wegneto.cursospring.service.UsuarioService;

@Configuration
@ComponentScan
public class LembrarSenhaApplication {

	public static void main(String[] args) {
		Scanner lerDados = new Scanner(System.in);
		Usuario usuario = new Usuario("Teste", "teste@exemplo.com", "login");

		System.out.println("Deseja recuperar a senha (S/N)?");
		String resposta = lerDados.nextLine();
		if (resposta.equalsIgnoreCase("S")) {
			ApplicationContext context = new AnnotationConfigApplicationContext(LembrarSenhaApplication.class);
			UsuarioService usuarioServico = context.getBean(UsuarioService.class);

			usuarioServico.setUsuario(usuario);
			usuarioServico.lembrarSenhaPorEmail();
		}
	}
}