package br.com.concursos.domain;

import java.util.ArrayList;
import java.util.List;

public class Quadrante<E> extends ContainerElemento<E> {

	private Setor<E> setorHorizontal;
	private Setor<E> setorVertical;

	public Quadrante(Setor<E> setorHorizontal, Setor<E> setorVertical) {
		super(new ArrayList<E>());
		this.setorHorizontal = setorHorizontal;
		this.setorVertical = setorVertical;
	}

	public Quadrante(Setor<E> setorHorizontal, Setor<E> setorVertical, List<E> elementos) {
		super(elementos);
		this.setorHorizontal = setorHorizontal;
		this.setorVertical = setorVertical;
	}

	public Setor<E> getSetorHorizontal() {
		return setorHorizontal;
	}

	public Setor<E> getSetorVertical() {
		return setorVertical;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object obj) {
		Quadrante<E> outroQuadrante;
		if (obj instanceof Quadrante) {
			outroQuadrante = (Quadrante<E>) obj;

			if (getElementos().equals(outroQuadrante.getElementos())) {
				return true;
			}
		}

		return false;
	}

	@Override
	public String toString() {
		return "[" + getSetorHorizontal() + "," + getSetorVertical() + "]";
	}

}
