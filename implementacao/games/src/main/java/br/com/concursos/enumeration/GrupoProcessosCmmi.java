package br.com.concursos.enumeration;

public enum GrupoProcessosCmmi {
	GESTAO_DE_PROCESSOS("Grupo de Processos"), GESTAO_DE_PROJETOS("Grupo de Projetos"), ENGENHARIA("Engenharia"), SUPORTE("Suporte");

	private String descricao;

	private GrupoProcessosCmmi(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public static GrupoProcessosCmmi getGrupoProcessosCmmi(String descricao) {
		for (GrupoProcessosCmmi grupoProcessosCmmi : GrupoProcessosCmmi.values()) {
			if (grupoProcessosCmmi.getDescricao().equals(descricao)) {
				return grupoProcessosCmmi;
			}
		}

		return null;
	}

}
