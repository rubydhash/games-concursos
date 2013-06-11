package br.com.concursos.enumeration;

public enum TipoSetor {
	HORIZONTAL("Horizontal"), VERTICAL("Vertical");

	private String descricao;

	private TipoSetor(String descricao) {
		this.setDescricao(descricao);
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public static TipoSetor getSetorPorDescricao(String descricao) {
		for (TipoSetor tipoSetor : TipoSetor.values()) {
			if (tipoSetor.getDescricao().equals(descricao)) {
				return tipoSetor;
			}
		}

		return null;
	}
}
