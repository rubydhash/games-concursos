package br.com.concursos.domain;

import java.util.ArrayList;
import java.util.List;

public class Quadrante<T> {

	private int linha;
	private int coluna;
	private List<T> conteudo;

	public Quadrante(int linha, int coluna) {
		this.setLinha(linha);
		this.setColuna(coluna);
		this.conteudo = new ArrayList<T>();
	}

	public Quadrante(int linha, int coluna, List<T> conteudo) {
		this.setLinha(linha);
		this.setColuna(coluna);
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

	public List<T> getConteudo() {
		return conteudo;
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
