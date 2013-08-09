package br.com.concursos.enumeration;

public enum NivelDificuldade {
	FACIL("Fácil"), MEDIO("Médio"), DIFICIL("Difícil"), MUITO_DIFICIL("Muito Difícil");

	private String descricao;

	private NivelDificuldade(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public static NivelDificuldade getNivelDificuldade(String descricao) {
		for (NivelDificuldade nivelDificuldade : NivelDificuldade.values()) {
			if (nivelDificuldade.getDescricao().equals(descricao)) {
				return nivelDificuldade;
			}
		}

		return null;
	}
}
