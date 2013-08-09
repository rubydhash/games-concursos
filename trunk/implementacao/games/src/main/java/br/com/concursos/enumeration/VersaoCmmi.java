package br.com.concursos.enumeration;

public enum VersaoCmmi {

	v1_2("v1.2"), v1_3("v1.3");

	private String descricao;

	private VersaoCmmi(String descricao) {
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

	public static VersaoCmmi getVersaoCmmiPorDescricao(String descricao) {
		for (VersaoCmmi versaoCmmi : VersaoCmmi.values()) {
			if (versaoCmmi.getDescricao().equals(descricao)) {
				return versaoCmmi;
			}
		}
		return null;
	}

}
