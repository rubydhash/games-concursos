package br.com.concursos.domain;

public class TamanhoTabuleiro {

	private Integer linha;
	private Integer coluna;

	public TamanhoTabuleiro(Integer linha, Integer coluna) {
		this.setLinha(linha);
		this.setColuna(coluna);
	}

	public Integer getLinha() {
		return linha;
	}

	public void setLinha(Integer linha) {
		this.linha = linha;
	}

	public Integer getColuna() {
		return coluna;
	}

	public void setColuna(Integer coluna) {
		this.coluna = coluna;
	}

}
