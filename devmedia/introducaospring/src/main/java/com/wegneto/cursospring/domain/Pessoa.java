package com.wegneto.cursospring.domain;

import org.springframework.stereotype.Component;

@Component
public class Pessoa {

	private String nome;
	private int idade;

	public Pessoa() {
		System.out.println("Criando pessoa...");
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String pessoa) {
		this.nome = pessoa;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	@Override
	public String toString() {
		return "Pessoa [pessoa=" + nome + ", idade=" + idade + "]";
	}

}
