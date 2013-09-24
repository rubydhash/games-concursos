package br.com.concursos.enumeration;

public enum TipoSetorEnum implements Enumeradores {
	HORIZONTAL(0, "Horizontal"),
	VERTICAL(1, "Vertical");

	private Integer codigo;

	private String descricao;

	private TipoSetorEnum(Integer codigo, String descricao) {
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

	public static TipoSetorEnum getSetorPorDescricao(String descricao) {
		for (TipoSetorEnum tipoSetor : TipoSetorEnum.values()) {
			if (tipoSetor.getDescricao().equals(descricao)) {
				return tipoSetor;
			}
		}

		return null;
	}

}
