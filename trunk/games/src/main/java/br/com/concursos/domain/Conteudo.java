package br.com.concursos.domain;

public class Conteudo {

	private int numero;
	private boolean inPlace = true;
	private Object tituloHorizontal;
	private Object tituloVertical;

	public Conteudo(int numero) {
		this.numero = numero;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public boolean isInPlace() {
		return inPlace;
	}

	public void setInPlace(boolean inPlace) {
		this.inPlace = inPlace;
	}

	public Object getTituloHorizontal() {
		return tituloHorizontal;
	}

	public void setTituloHorizontal(Object tituloHorizontal) {
		this.tituloHorizontal = tituloHorizontal;
	}

	public Object getTituloVertical() {
		return tituloVertical;
	}

	public void setTituloVertical(Object tituloVertical) {
		this.tituloVertical = tituloVertical;
	}

	@Override
	public boolean equals(Object obj) {
		Conteudo outroConteudo;
		if (obj instanceof Conteudo) {
			outroConteudo = (Conteudo) obj;

			if (this.getNumero() == outroConteudo.getNumero()) {
				return true;
			}
		}

		return false;
	}

	@Override
	public String toString() {
		return "Conteúdo " + this.getNumero();
	}

}
