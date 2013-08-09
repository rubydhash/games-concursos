package br.com.concursos.domain;

import java.util.ArrayList;
import java.util.List;

public class Quadrante {

	private int linha;
	private int coluna;
	private List<Conteudo> conteudos;

	public Quadrante(int linha, int coluna) {
		this.setLinha(linha);
		this.setColuna(coluna);
		this.conteudos = new ArrayList<Conteudo>();
	}

	public Quadrante(int linha, int coluna, List<Conteudo> conteudos) {
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

	public List<Conteudo> getConteudos() {
		return conteudos;
	}

	public boolean add(Conteudo conteudo) {
		return conteudos.add(conteudo);
	}

	public boolean remove(Conteudo conteudo) {
		return conteudos.remove(conteudo);
	}

	public boolean contains(Conteudo conteudo) {
		return conteudos.contains(conteudo);
	}

	public int getTotalConteudo() {
		return conteudos.size();
	}

	@Override
	public String toString() {
		return "[" + getLinha() + "," + getColuna() + "]";
	}

	@Override
	public boolean equals(Object obj) {
		Quadrante outroQuadrante;
		if (obj instanceof Quadrante) {
			outroQuadrante = (Quadrante) obj;

			if (this.getLinha() == outroQuadrante.getLinha() && this.getColuna() == outroQuadrante.getColuna()) {
				return true;
			}
		}

		return false;
	}
}
