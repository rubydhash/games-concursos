package br.com.concursos.domain;

import java.util.List;

import br.com.concursos.enumeration.TipoSetor;

public class Setor<T> {

	private int numero;
	private TipoSetor tipo;
	private String titulo;
	private List<Quadrante<T>> quadrantes;

	public Setor(int numero) {
		this.numero = numero;
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

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public List<Quadrante<T>> getQuadrantes() {
		return quadrantes;
	}

	public void setQuadrantes(List<Quadrante<T>> quadrantes) {
		this.quadrantes = quadrantes;
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
