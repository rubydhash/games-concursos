package br.com.concursos.domain;

import java.util.ArrayList;
import java.util.List;

import br.com.concursos.enumeration.TipoSetor;

public class Setor<T> {

	private int numero;
	private TipoSetor tipo;
	private Object titulo;
	private List<Quadrante<T>> quadrantes;

	public Setor(int numero, TipoSetor tipo) {
		this.numero = numero;
		this.tipo = tipo;
		this.quadrantes = new ArrayList<Quadrante<T>>();
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public TipoSetor getTipo() {
		return tipo;
	}

	public void setTipo(TipoSetor tipo) {
		this.tipo = tipo;
	}

	public Object getTitulo() {
		return titulo;
	}

	public void setTitulo(Object titulo) {
		this.titulo = titulo;
	}

	public List<Quadrante<T>> getQuadrantes() {
		return quadrantes;
	}

	public void setQuadrantes(List<Quadrante<T>> quadrantes) {
		this.quadrantes = quadrantes;
	}

	public void addQuadrante(Quadrante<T> quadrante) {
		this.quadrantes.add(quadrante);
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object obj) {
		Setor<T> outroSetor;
		if (obj instanceof Setor) {
			outroSetor = (Setor<T>) obj;

			if (this.getNumero() == outroSetor.getNumero() && this.getTipo().equals(outroSetor.getTipo())) {
				return true;
			}
		}

		return false;
	}
}
