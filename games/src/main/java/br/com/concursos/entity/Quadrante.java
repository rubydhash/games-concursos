package br.com.concursos.entity;

import java.util.ArrayList;
import java.util.List;

public class Quadrante<T> {

	private int linha;
	private int coluna;
	private List<T> conteudo;

	public Quadrante(int linha, int coluna) {
		this.linha = linha;
		this.coluna = coluna;
		this.conteudo = new ArrayList<T>();
	}

	public Quadrante(int linha, int coluna, List<T> conteudo) {
		this.linha = linha;
		this.coluna = coluna;
		this.conteudo = conteudo;
	}

	public int getLinha() {
		return linha;
	}

	public int getColuna() {
		return coluna;
	}

	public List<T> getConteudo() {
		return conteudo;
	}
}
