package br.com.concursos.domain;

import java.util.ArrayList;
import java.util.List;

public class No<E> extends ContainerElemento<E> {

	private Integer id;
	private No<E> pai;
	private List<No<E>> filhos;

	public No(Integer id) {
		super(new ArrayList<E>());
		this.id = id;
	}

	public No(Integer id, List<E> elementos) {
		super(elementos);
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public No<E> getPai() {
		return pai;
	}

	public void setPai(No<E> pai) {
		this.pai = pai;
	}

	public List<No<E>> getFilhos() {
		return filhos;
	}

	public Boolean add(No<E> filho) {
		return getFilhos().add(filho);
	}

	@Override
	public String toString() {
		return "Id: " + this.getId() + " | " + this.getFilhos().toString();
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object obj) {
		No<E> outroNo;
		if (obj instanceof No) {
			outroNo = (No<E>) obj;

			if (this.getElementos().equals(outroNo.getElementos())) {
				return true;
			}
		}

		return false;
	}

}
