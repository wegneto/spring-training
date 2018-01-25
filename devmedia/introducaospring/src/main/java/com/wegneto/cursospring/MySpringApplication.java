package com.wegneto.cursospring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.wegneto.cursospring.domain.Pessoa;

@Configuration
@ComponentScan
public class MySpringApplication {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(MySpringApplication.class);

		Pessoa pessoa = context.getBean(Pessoa.class);
		pessoa.setNome("Teste");
		pessoa.setIdade(30);
		System.out.println(pessoa);
	}

}
