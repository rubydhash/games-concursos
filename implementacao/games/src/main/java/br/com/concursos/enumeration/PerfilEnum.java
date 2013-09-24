package br.com.concursos.enumeration;

public enum PerfilEnum implements Enumeradores {
	USUARIO(0, "Usuário"),
	SUPER_USUARIO(1, "Super Usuário");
	
	private Integer codigo;

	private String descricao;

	private PerfilEnum(Integer codigo, String descricao) {
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

	public static PerfilEnum getPerfil(String descricao) {
		for (PerfilEnum perfil : PerfilEnum.values()) {
			if (perfil.getDescricao().equals(descricao)) {
				return perfil;
			}
		}

		return null;
	}
	
	public static PerfilEnum getByCodigo(Integer codigo) {
		for (PerfilEnum value : PerfilEnum.values()) {
			if (value.getCodigo().equals(codigo)) {
				return value;
			}
		}
		
		return null;
	}

}
