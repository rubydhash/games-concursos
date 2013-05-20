package br.com.concursos.entity;

import java.util.ArrayList;
import java.util.List;

public class Quadrante<T> {

	private int linha;
	private Object linhaTitulo;
	private int coluna;
	private Object colunaTitulo;
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

	public Object getLinhaTitulo() {
		return linhaTitulo;
	}

	public void setLinhaTitulo(Object linhaTitulo) {
		this.linhaTitulo = linhaTitulo;
	}

	public int getColuna() {
		return coluna;
	}

	public Object getColunaTitulo() {
		return colunaTitulo;
	}

	public void setColunaTitulo(Object colunaTitulo) {
		this.colunaTitulo = colunaTitulo;
	}

	public List<T> getConteudo() {
		return conteudo;
	}

	@Override
	public String toString() {
		return "[" + linha + "," + coluna + "]";
	}

}
