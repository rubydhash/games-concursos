package br.com.concursos.domain;

import java.util.List;

public class ContainerElemento<E> {

	private List<E> elementos;

	public ContainerElemento(List<E> elementos) {
		this.elementos = elementos;
	}

	public List<E> getElementos() {
		return elementos;
	}

	public Boolean add(E e) {
		return getElementos().add(e);
	}

	public Boolean remove(E e) {
		return getElementos().remove(e);
	}

	public Boolean contains(E e) {
		return getElementos().contains(e);
	}

	public Integer size() {
		return getElementos().size();
	}

	public Boolean isEmpty() {
		return getElementos().isEmpty();
	}

	public void clear() {
		getElementos().clear();
	}
	
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
	
	@Override
	public String toString() {
		return super.toString();
	}

}
