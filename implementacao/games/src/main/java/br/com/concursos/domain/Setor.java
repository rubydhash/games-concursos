package br.com.concursos.domain;

import java.util.ArrayList;
import java.util.List;

import br.com.concursos.enumeration.TipoSetor;

public class Setor {

	private int numero;
	private TipoSetor tipo;
	private Object titulo;
	private List<Quadrante> quadrantes;

	public Setor(int numero, TipoSetor tipo) {
		this.numero = numero;
		this.tipo = tipo;
		this.quadrantes = new ArrayList<Quadrante>();
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

	public List<Quadrante> getQuadrantes() {
		return quadrantes;
	}

	public void setQuadrantes(List<Quadrante> quadrantes) {
		this.quadrantes = quadrantes;
	}

	public void addQuadrante(Quadrante quadrante) {
		this.quadrantes.add(quadrante);
	}

	@Override
	public boolean equals(Object obj) {
		Setor outroSetor;
		if (obj instanceof Setor) {
			outroSetor = (Setor) obj;

			if (this.getNumero() == outroSetor.getNumero() && this.getTipo().equals(outroSetor.getTipo())) {
				return true;
			}
		}

		return false;
	}
}
