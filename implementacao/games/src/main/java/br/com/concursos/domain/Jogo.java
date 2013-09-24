package br.com.concursos.domain;

import java.util.Date;
import java.util.List;

import br.com.concursos.enumeration.NivelDificuldadeEnum;

public class Jogo {

	private Long id;

	private String nome;

	private String versao;

	private Date dataCriacao;

	private List<Item> itens;

	private Modelo<Item> modelo;
	
	private Usuario usuario;
	
	private NivelDificuldadeEnum nivelDificuldade;

	public void inicializa() {

	}

	public void finaliza() {

	}

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

	public String getVersao() {
		return versao;
	}

	public void setVersao(String versao) {
		this.versao = versao;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public List<Item> getItens() {
		return itens;
	}

	public void setItens(List<Item> itens) {
		this.itens = itens;
	}

	public Modelo<Item> getModelo() {
		return modelo;
	}

	public void setModelo(Modelo<Item> modelo) {
		this.modelo = modelo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public NivelDificuldadeEnum getNivelDificuldade() {
		return nivelDificuldade;
	}

	public void setNivelDificuldade(NivelDificuldadeEnum nivelDificuldade) {
		this.nivelDificuldade = nivelDificuldade;
	}

}
