package br.com.concursos.domain;

import java.util.Set;

public class Usuario {

	private Long cpf;
	
	private String nome;
	
	private String senha;
	
	private Set<Jogo> jogos;

	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Set<Jogo> getJogos() {
		return jogos;
	}

	public void setJogos(Set<Jogo> jogos) {
		this.jogos = jogos;
	}
}
