package br.com.concursos.domain;

import br.com.concursos.exception.ElementoNaoEncontradoException;

public interface Modelo<E> {

	/**
	 * Adiciona o elemento especificado de acordo com o local.
	 * 
	 * @param e
	 *            elemento a ser adicionado no modelo
	 * @return <tt>true</tt> se o elemento foi adicionado no local correto
	 */
	public Boolean add(E e) throws Exception;

	/**
	 * Remove o elemento do modelo.
	 * 
	 * @param e
	 *            elemento a ser removido no modelo
	 * @throws ElementoNaoEncontradoException
	 */
	public void remove(E e) throws ElementoNaoEncontradoException;

	/**
	 * Verifica se o conteúdo se encontra no modelo.
	 * 
	 * @param conteudo
	 * @return {@link Boolean}
	 */
	public Boolean contains(E e);

	/**
	 * Constrói o modelo de acordo com a especificação desejada.
	 * 
	 */
	public void construct();

	/**
	 * Retorna <tt>true</tt> se o modelo não tiver nenhum elemento.
	 * 
	 * @return <tt>true</tt> se o modelo não tiver nenhum elemento
	 */
	public Boolean isEmpty();

	/**
	 * Retorna o número de elementos contidos no modelo.
	 * 
	 * @return o número de elementos contidos no modelo
	 */
	public Integer size();

	/**
	 * Remove todos os elementos do modelo. O modelo ficará vazio depois da chamada do método.
	 * 
	 */
	public void clear();

}
