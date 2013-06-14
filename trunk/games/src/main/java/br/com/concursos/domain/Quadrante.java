package br.com.concursos.domain;

import java.util.ArrayList;
import java.util.List;

public class Quadrante<T> {

	private int linha;
	private int coluna;
	private List<T> conteudos;

	public Quadrante(int linha, int coluna) {
		this.setLinha(linha);
		this.setColuna(coluna);
		this.conteudos = new ArrayList<T>();
	}

	public Quadrante(int linha, int coluna, List<T> conteudos) {
		this.setLinha(linha);
		this.setColuna(coluna);
		this.conteudos = conteudos;
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

	public List<T> getConteudos() {
		return conteudos;
	}

	public boolean add(T t) {
		return conteudos.add(t);
	}

	public boolean remove(T t) {
		return conteudos.remove(t);
	}

	public boolean contains(T t) {
		return conteudos.contains(t);
	}

	public int getTotalConteudo() {
		return conteudos.size();
	}

	@Override
	public String toString() {
		return "[" + getLinha() + "," + getColuna() + "]";
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object obj) {
		Quadrante<T> outroQuadrante;
		if (obj instanceof Quadrante) {
			outroQuadrante = (Quadrante<T>) obj;

			if (this.getLinha() == outroQuadrante.getLinha() && this.getColuna() == outroQuadrante.getColuna()) {
				return true;
			}
		}

		return false;
	}
}
