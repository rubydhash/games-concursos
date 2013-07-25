package br.com.concursos.domain;

public class Conteudo {

	private int codigo;
	private String sigla;
	private String nome;
	private String nomeOriginal;
	private String descricao;
	private String tituloHorizontal;
	private String tituloVertical;
	private boolean inPlace = true;

	/**
	 * @return the codigo
	 */
	public int getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo
	 *            the codigo to set
	 */
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	/**
	 * @return the sigla
	 */
	public String getSigla() {
		return sigla;
	}

	/**
	 * @param sigla
	 *            the sigla to set
	 */
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome
	 *            the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the nomeOriginal
	 */
	public String getNomeOriginal() {
		return nomeOriginal;
	}

	/**
	 * @param nomeOriginal
	 *            the nomeOriginal to set
	 */
	public void setNomeOriginal(String nomeOriginal) {
		this.nomeOriginal = nomeOriginal;
	}

	/**
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * @param descricao
	 *            the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	/**
	 * @return the tituloHorizontal
	 */
	public String getTituloHorizontal() {
		return tituloHorizontal;
	}

	/**
	 * @param tituloHorizontal
	 *            the tituloHorizontal to set
	 */
	public void setTituloHorizontal(String tituloHorizontal) {
		this.tituloHorizontal = tituloHorizontal;
	}

	/**
	 * @return the tituloVertical
	 */
	public String getTituloVertical() {
		return tituloVertical;
	}

	/**
	 * @param tituloVertical
	 *            the tituloVertical to set
	 */
	public void setTituloVertical(String tituloVertical) {
		this.tituloVertical = tituloVertical;
	}

	/**
	 * @return the inPlace
	 */
	public boolean isInPlace() {
		return inPlace;
	}

	/**
	 * @param inPlace
	 *            the inPlace to set
	 */
	public void setInPlace(boolean inPlace) {
		this.inPlace = inPlace;
	}

	@Override
	public boolean equals(Object obj) {
		Conteudo outroConteudo;
		if (obj instanceof Conteudo) {
			outroConteudo = (Conteudo) obj;

			if (this.getCodigo() == outroConteudo.getCodigo()) {
				return true;
			}
		}

		return false;
	}

	@Override
	public String toString() {
		return "Conteúdo " + this.getCodigo() + ": " + this.nome;
	}

}
