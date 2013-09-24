package br.com.concursos.enumeration;

public enum NivelDificuldadeEnum implements Enumeradores {
	FACIL(0, "Fácil"),
	MEDIO(1, "Médio"),
	DIFICIL(2, "Difícil"),
	MUITO_DIFICIL(3, "Muito Difícil");

	private Integer codigo;

	private String descricao;

	private NivelDificuldadeEnum(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	@Override
	public Integer getCodigo() {
		return codigo;
	}

	@Override
	public String getDescricao() {
		return descricao;
	}

	public static NivelDificuldadeEnum getNivelDificuldade(String descricao) {
		for (NivelDificuldadeEnum nivelDificuldade : NivelDificuldadeEnum.values()) {
			if (nivelDificuldade.getDescricao().equals(descricao)) {
				return nivelDificuldade;
			}
		}

		return null;
	}
	
	public static NivelDificuldadeEnum getByCodigo(Integer codigo) {
		for (NivelDificuldadeEnum value : NivelDificuldadeEnum.values()) {
			if (value.getCodigo().equals(codigo)) {
				return value;
			}
		}
		
		return null;
	}

}
