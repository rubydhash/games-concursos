package br.com.concursos.domain;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Embeddable;

import br.com.concursos.enumeration.PerfilEnum;

@Embeddable
@AttributeOverride(name = "codigo", column = @Column(name = "idPerfil"))
public class Perfil extends AbstractDominio<PerfilEnum> {

	private static final long serialVersionUID = -8204737235009331966L;

	public Perfil() {
	}

	public Perfil(PerfilEnum perfil) {
		super(perfil);
	}

	@Override
	public PerfilEnum getDominio() {
		if (this.dominio == null) {
			this.dominio = PerfilEnum.getByCodigo(getCodigo());
		}

		return this.dominio;
	}
}
