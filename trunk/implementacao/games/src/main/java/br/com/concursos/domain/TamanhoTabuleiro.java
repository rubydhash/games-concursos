package br.com.concursos.domain;

public class TamanhoTabuleiro {

	private int linha;
	private int coluna;

	public TamanhoTabuleiro(int linha, int coluna) {
		this.linha = linha;
		this.coluna = coluna;
	}

	/**
	 * @return the linha
	 */
	public int getLinha() {
		return linha;
	}

	/**
	 * @param linha
	 *            the linha to set
	 */
	public void setLinha(int linha) {
		this.linha = linha;
	}

	/**
	 * @return the coluna
	 */
	public int getColuna() {
		return coluna;
	}

	/**
	 * @param coluna
	 *            the coluna to set
	 */
	public void setColuna(int coluna) {
		this.coluna = coluna;
	}

}
