package br.com.concursos.domain;

import java.util.ArrayList;
import java.util.List;

import br.com.concursos.enumeration.TipoSetor;

public class Setor<E> {

	private Integer id;
	private TipoSetor tipo;
	private List<Quadrante<E>> quadrantes;

	public Setor(Integer id, TipoSetor tipo) {
		this.id = id;
		this.tipo = tipo;
		this.quadrantes = new ArrayList<Quadrante<E>>();
	}

	public Integer getId() {
		return id;
	}

	public TipoSetor getTipo() {
		return tipo;
	}

	public List<Quadrante<E>> getQuadrantes() {
		return quadrantes;
	}

	public void addQuadrante(Quadrante<E> quadrante) {
		quadrantes.add(quadrante);
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object obj) {
		Setor<E> outroSetor;
		if (obj instanceof Setor) {
			outroSetor = (Setor<E>) obj;

			if (getId().equals(outroSetor.getId()) && getTipo().equals(outroSetor.getTipo())
					&& getQuadrantes().equals(outroSetor.getQuadrantes())) {
				return true;
			}
		}

		return false;
	}

	@Override
	public String toString() {
		return getTipo() + " (" + getId() + ")";
	}

}
