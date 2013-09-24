package br.com.concursos.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

import br.com.concursos.enumeration.Enumeradores;

@MappedSuperclass
public abstract class AbstractDominio<T extends Enumeradores> implements Serializable {

	private static final long serialVersionUID = 5949150396551055633L;

	@Transient
	protected T dominio;

	@Column(nullable = false)
	private Integer codigo;

	public AbstractDominio() {
	}

	public AbstractDominio(T dominio) {
		super();
		setDominio(dominio);
	}

	public abstract T getDominio();

	public void setDominio(T dominio) {
		this.dominio = dominio;
		this.codigo = dominio != null ? this.dominio.getCodigo() : null;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return getDominio().getDescricao();
	}

	@Override
	public String toString() {
		return this.getCodigo() + " - " + this.getDescricao();
	}
}
