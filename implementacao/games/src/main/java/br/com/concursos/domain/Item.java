package br.com.concursos.domain;

public class Item {

	private Long id;

	private String nome;

	private String nomeIngles;

	private String descricao;

	private Jogo jogo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNomeIngles() {
		return nomeIngles;
	}

	public void setNomeIngles(String nomeIngles) {
		this.nomeIngles = nomeIngles;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Jogo getJogo() {
		return jogo;
	}

	public void setJogo(Jogo jogo) {
		this.jogo = jogo;
	}
}
