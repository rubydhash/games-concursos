package br.com.concursos.enumeration;

public enum VersaoPmbok {

	QUARTA_EDICAO("4a. edição"), QUINTA_EDICAO("5a. edição");

	private String descricao;

	private VersaoPmbok(String descricao) {
		this.descricao = descricao;
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

	public static VersaoPmbok getVersaoCmmiPorDescricao(String descricao) {
		for (VersaoPmbok versaoPmbok : VersaoPmbok.values()) {
			if (versaoPmbok.getDescricao().equals(descricao)) {
				return versaoPmbok;
			}
		}
		return null;
	}

}
