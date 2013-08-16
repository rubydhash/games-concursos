package br.com.concursos.domain;

import br.com.concursos.exception.ElementoNaoEncontradoException;

public class Arvore<E> implements Modelo<E> {

	private No<E> noRaiz;
	private Integer altura;

	public Arvore(Integer altura) {
		this.altura = altura;
		construct();
	}

	public No<E> getNoRaiz() {
		return noRaiz;
	}

	public Integer getAltura() {
		return altura;
	}

	@Override
	public Boolean add(E e) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(E e) throws ElementoNaoEncontradoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Boolean contains(E e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void construct() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Boolean isEmpty() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer size() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

}
