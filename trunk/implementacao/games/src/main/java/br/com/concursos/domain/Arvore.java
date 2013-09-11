package br.com.concursos.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.concursos.exception.ArgumentoInvalidoException;
import br.com.concursos.exception.ElementoExistenteException;
import br.com.concursos.exception.ElementoNaoEncontradoException;
import br.com.concursos.exception.ImpossivelRemoverNoRaizException;
import br.com.concursos.exception.LocalizacaoInsercaoNaoEncontradoException;
import br.com.concursos.exception.LocalizacaoInsercaoElementoNaoPreenchidaException;

public class Arvore<E> implements Modelo<E> {

	private Long countIdNo = 0l;
	private Integer sizeNos = 0;
	private Integer altura;
	private No<E> noInsercao;

	private Map<No<E>, List<No<E>>> mapNos = new HashMap<No<E>, List<No<E>>>();

	public Arvore() {
		this.altura = 1;
		construct();
	}

	public Arvore(Integer altura) {
		this.altura = altura;
		construct();
	}

	public No<E> getRaiz() {
		return getNo(new No<E>(0l));
	}

	public Integer getAltura() {
		return altura;
	}

	public No<E> getNoInsercao() {
		return noInsercao;
	}

	public void setNoInsercao(No<E> noInsercao) {
		this.noInsercao = noInsercao;
	}

	/**
	 * Especificado em {@link Modelo#add})
	 * 
	 * Obs.: Deve ser inserido um nó para a inserção do elemento ({@link No})
	 */
	@Override
	public Boolean add(E e) throws Exception {
		if (noInsercao == null) {
			throw new LocalizacaoInsercaoElementoNaoPreenchidaException();
		}

		add(e, noInsercao);
		setNoInsercao(null);

		return true;
	}

	/**
	 * Adiciona o conteúdo no tabuleiro no quadrante desejado.
	 * 
	 * @param e
	 *            elemento a ser adicionado na árvore
	 * @param no
	 * @return {@link Boolean}
	 * @throws ArgumentoInvalidoException
	 * @throws ElementoExistenteException
	 */
	public Boolean add(E e, No<E> no) throws ArgumentoInvalidoException, ElementoExistenteException {
		if (no.getId() < 0 || no.getId() > sizeNos() - 1) {
			throw new ArgumentoInvalidoException();
		}

		if (contains(e)) {
			throw new ElementoExistenteException();
		}

		getNo(no).add(e);

		return true;
	}

	@Override
	public void remove(E e) throws ElementoNaoEncontradoException {
		if (contains(e)) {
			No<E> no = getNo(e);
			no.remove(e);
		} else {
			throw new ElementoNaoEncontradoException();
		}
	}

	@Override
	public Boolean contains(E e) {
		for (No<E> no : mapNos.keySet()) {
			if (no.contains(e)) {
				return true;
			}
		}

		return false;
	}

	public Boolean contains(No<E> no) {
		return mapNos.containsKey(getNo(no));
	}

	@Override
	public void construct() {
		List<No<E>> pais = new ArrayList<No<E>>();
		List<No<E>> filhos = new ArrayList<No<E>>();

		No<E> raiz = adicionaNovoNo(null);
		pais.add(raiz);

		for (int i = 0; i < altura; i++) {
			for (No<E> noPai : pais) {
				for (int x = 0; x < 2; x++) {
					No<E> filho = adicionaNovoNo(noPai);
					filhos.add(filho);
				}
			}
			pais = filhos;
			filhos = new ArrayList<No<E>>();
		}
	}

	private No<E> adicionaNovoNo(No<E> noPai) {
		No<E> noAdicionado = new No<E>(countIdNo++);
		noAdicionado.setPai(noPai);
		if (noPai != null) {
			noPai.add(noAdicionado);
		}

		sizeNos++;
		mapNos.put(noAdicionado, noAdicionado.getFilhos());

		return noAdicionado;
	}

	/**
	 * Retorna o nó de acordo com o índice passado ou null caso não encontre o nó desejado.
	 * 
	 * @param no
	 *            contendo o id a ser consultado
	 * @return {@link No} nó com todas as informações preenchidas ou null caso não encontre
	 */
	private No<E> getNo(No<E> no) {
		for (No<E> noSearch : mapNos.keySet()) {
			if (noSearch.getId().equals(no.getId())) {
				return noSearch;
			}
		}

		return null;
	}

	/**
	 * Retorna o nó de acordo com o elemento passado ou null caso não encontre algum nó com o elemento.
	 * 
	 * @param no
	 *            nó contendo o id a ser consultado
	 * @return {@link No} nó com todas as informações preenchidas ou null caso não encontre
	 */
	private No<E> getNo(E e) {
		for (No<E> no : mapNos.keySet()) {
			if (no.contains(e)) {
				return no;
			}
		}

		return null;
	}

	@Override
	public Boolean isEmpty() {
		for (No<E> no : mapNos.keySet()) {
			if (!no.isEmpty()) {
				return false;
			}
		}

		return true;
	}

	@Override
	public Integer size() {
		return null;
	}

	public Integer sizeNos() {
		return sizeNos;
	}

	@Override
	public void clear() {
		for (No<E> no : mapNos.keySet()) {
			no.clear();
		}
	}

	public void clearArvore() {
		mapNos.clear();
	}

	@Override
	public String toString() {
		return mapNos.toString();
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

	public Boolean addNo(No<E> noPai) throws LocalizacaoInsercaoNaoEncontradoException {
		if (noPai == null) {
			throw new LocalizacaoInsercaoNaoEncontradoException();
		}
		
		No<E> pai = getNo(noPai);
		if (pai == null) {
			throw new LocalizacaoInsercaoNaoEncontradoException();
		}

		adicionaNovoNo(noPai);

		return true;
	}

	public Boolean removeNo(No<E> no) throws ImpossivelRemoverNoRaizException {
		if (no.getId().equals(0l)) {
			throw new ImpossivelRemoverNoRaizException();
		}
		
		No<E> noRemovido = getNo(no);
		if (noRemovido == null) {
			return false;
		}

		mapNos.remove(noRemovido);
		Collection<List<No<E>>> lista = mapNos.values();
		for (List<No<E>> list : lista) {
			if (list.contains(noRemovido)) {
				return list.remove(noRemovido);
			}
		}

		return false;
	}

}
