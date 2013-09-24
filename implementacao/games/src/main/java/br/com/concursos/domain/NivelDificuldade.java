package br.com.concursos.domain;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Embeddable;

import br.com.concursos.enumeration.NivelDificuldadeEnum;

@Embeddable
@AttributeOverride(name = "codigo", column = @Column(name = "idNivelDificuldade"))
public class NivelDificuldade extends AbstractDominio<NivelDificuldadeEnum> {

	private static final long serialVersionUID = 5261560045762673285L;

	public NivelDificuldade() {
	}

	public NivelDificuldade(NivelDificuldadeEnum nivelDificuldade) {
		super(nivelDificuldade);
	}

	@Override
	public NivelDificuldadeEnum getDominio() {
		if (this.dominio == null) {
			this.dominio = NivelDificuldadeEnum.getByCodigo(getCodigo());
		}

		return this.dominio;
	}
}
