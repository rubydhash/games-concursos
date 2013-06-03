package br.com.concursos.domain;

import java.util.ArrayList;
import java.util.List;

public class Quadrante<T> {

	private int linha;
	private int coluna;
	private Object tituloLinha;
	private Object tituloColuna;
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

	public void setLinha(int linha) {
		this.linha = linha;
	}

	public int getColuna() {
		return coluna;
	}

	public void setColuna(int coluna) {
		this.coluna = coluna;
	}

	public Object getTituloLinha() {
		return tituloLinha;
	}

	public void setTituloLinha(Object tituloLinha) {
		this.tituloLinha = tituloLinha;
	}

	public Object getTituloColuna() {
		return tituloColuna;
	}

	public void setTituloColuna(Object tituloColuna) {
		this.tituloColuna = tituloColuna;
	}

	public List<T> getConteudo() {
		return conteudo;
	}

	@Override
	public String toString() {
		return "[" + linha + "," + coluna + "]";
	}

}
