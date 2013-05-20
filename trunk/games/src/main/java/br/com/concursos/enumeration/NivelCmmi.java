package br.com.concursos.enumeration;

public enum NivelCmmi {
	NIVEL_1("Nível 1"), NIVEL_2("Nível 2"), NIVEL_3("Nível 3"), NIVEL_4("Nível 4"), NIVEL_5("Nível 5");

	private String descricao;

	private NivelCmmi(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public static NivelCmmi getNivelCmmi(String descricao) {
		for (NivelCmmi nivelCmmi : NivelCmmi.values()) {
			if (nivelCmmi.getDescricao().equals(descricao)) {
				return nivelCmmi;
			}
		}

		return null;
	}
}
