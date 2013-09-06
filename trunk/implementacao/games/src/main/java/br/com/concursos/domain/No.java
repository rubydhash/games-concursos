package br.com.concursos.domain;

import java.util.ArrayList;
import java.util.List;

public class No<E> extends ContainerElemento<E> {

	private Long id;
	private No<E> pai;
	private List<No<E>> filhos;

	public No(Long id) {
		super(new ArrayList<E>());
		filhos = new ArrayList<No<E>>();
		this.id = id;
	}

	public No(Long id, List<E> elementos) {
		super(elementos);
		filhos = new ArrayList<No<E>>();
		this.id = id;
	}

	public Long getId() {
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
		return "Id: " + this.getId();
	}

	/**
	 * Compara o id e os elementos internos do no.
	 * 
	 * @param obj
	 *            outro nó a ser comparado
	 * @return {@link Boolean}
	 */
	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object obj) {
		No<E> outroNo;
		if (obj instanceof No) {
			outroNo = (No<E>) obj;

			if (id.equals(outroNo.getId())) {
				return true;
			}
		}

		return false;
	}
	
	@Override
	public int hashCode() {
		return id.hashCode();
	}	

}
