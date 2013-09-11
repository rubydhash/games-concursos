package br.com.concursos.domain;

import java.util.ArrayList;
import java.util.List;

import br.com.concursos.enumeration.TipoSetor;
import br.com.concursos.exception.ArgumentoInvalidoException;
import br.com.concursos.exception.ElementoExistenteException;
import br.com.concursos.exception.ElementoNaoEncontradoException;
import br.com.concursos.exception.LocalizacaoInsercaoElementoNaoPreenchidaException;
import br.com.concursos.exception.TabuleiroTamanhoInvalidoException;

public class Tabuleiro<E> implements Modelo<E> {

	private List<Setor<E>> setoresHorizontais;
	private List<Setor<E>> setoresVerticais;
	private TamanhoTabuleiro tamanhoTabuleiro;
	private Setor<E> setorHorizontalInsercao;
	private Setor<E> setorVerticalInsercao;

	public Tabuleiro(TamanhoTabuleiro tamanhoTabuleiro) throws TabuleiroTamanhoInvalidoException {
		if (tamanhoTabuleiro.getLinha() == 0 || tamanhoTabuleiro.getColuna() == 0 || tamanhoTabuleiro.getLinha() < 0 || tamanhoTabuleiro.getColuna() < 0) {
			throw new TabuleiroTamanhoInvalidoException();
		}

		this.tamanhoTabuleiro = tamanhoTabuleiro;
		construct();
	}

	public List<Setor<E>> getSetoresHorizontais() {
		return setoresHorizontais;
	}

	public List<Setor<E>> getSetoresVerticais() {
		return setoresVerticais;
	}

	public TamanhoTabuleiro getTamanhoTabuleiro() {
		return tamanhoTabuleiro;
	}

	public Setor<E> getSetorHorizontalInsercao() {
		return setorHorizontalInsercao;
	}

	public void setSetorHorizontalInsercao(Setor<E> setorHorizontalInsercao) {
		this.setorHorizontalInsercao = setorHorizontalInsercao;
	}

	public Setor<E> getSetorVerticalInsercao() {
		return setorVerticalInsercao;
	}

	public void setSetorVerticalInsercao(Setor<E> setorVerticalInsercao) {
		this.setorVerticalInsercao = setorVerticalInsercao;
	}

	/**
	 * Adiciona o elemento no tabuleiro em um quadrante desejado.
	 * 
	 * @param e
	 *            elemento a ser adicionado no tabuleiro
	 * @param setorHorizontal
	 * @param setorVertical
	 * @return {@link Boolean}
	 * @throws ArgumentoInvalidoException
	 * @throws ElementoExistenteException
	 */
	public Boolean add(E e, Setor<E> setorHorizontal, Setor<E> setorVertical) throws ArgumentoInvalidoException, ElementoExistenteException {
		if ((setorHorizontal.getId() < 0 || setorHorizontal.getId() > getSetoresHorizontais().size() - 1)
				|| (setorVertical.getId() < 0 || setorVertical.getId() > getSetoresVerticais().size() - 1)) {
			throw new ArgumentoInvalidoException();
		}

		if (contains(e)) {
			throw new ElementoExistenteException();
		}

		getSetoresHorizontais().get(setorHorizontal.getId()).getQuadrantes().get(setorVertical.getId()).add(e);

		return true;
	}

	/**
	 * Especificado em {@link Modelo#add})
	 * 
	 * Obs.: Deve ser inserido um setor horizontal e um setor vertical para a inserção do elemento ({@link Setor})
	 */
	@Override
	public Boolean add(E e) throws Exception {
		if (setorHorizontalInsercao == null || setorVerticalInsercao == null) {
			throw new LocalizacaoInsercaoElementoNaoPreenchidaException();
		}

		add(e, setorHorizontalInsercao, setorVerticalInsercao);
		setSetorHorizontalInsercao(null);
		setSetorVerticalInsercao(null);

		return true;
	}

	@Override
	public void remove(E e) throws ElementoNaoEncontradoException {
		if (contains(e)) {
			Quadrante<E> quadrante = getQuadrante(e);
			quadrante.remove(e);
		} else {
			throw new ElementoNaoEncontradoException();
		}
	}

	/**
	 * Retorna o quadrante de acordo com o elemento passado ou null caso não encontre algum quadrante com o elemento.
	 * 
	 * @param e
	 *            elemento que será procurado para achar o quadrante desejado.
	 * @return {@link Quadrante}
	 */
	private Quadrante<E> getQuadrante(E e) {
		for (int i = 0; i < getSetoresHorizontais().size(); i++) {
			for (int j = 0; j < getSetoresVerticais().size(); j++) {
				if (((Quadrante<E>) getSetoresHorizontais().get(i).getQuadrantes().get(j)).contains(e)) {
					return (Quadrante<E>) getSetoresHorizontais().get(i).getQuadrantes().get(j);
				}
			}
		}

		return null;
	}

	@Override
	public Boolean contains(E e) {
		for (int i = 0; i < getSetoresHorizontais().size(); i++) {
			for (int j = 0; j < getSetoresVerticais().size(); j++) {
				if (((Quadrante<E>) getSetoresHorizontais().get(i).getQuadrantes().get(j)).contains(e)) {
					return true;
				}
			}
		}

		return false;
	}

	@Override
	public void construct() {
		setoresHorizontais = new ArrayList<Setor<E>>();
		setoresVerticais = new ArrayList<Setor<E>>();
		for (int i = 0; i < tamanhoTabuleiro.getLinha(); i++) {
			Setor<E> setorHorizontal = new Setor<E>(i, TipoSetor.HORIZONTAL);
			getSetoresHorizontais().add(setorHorizontal);

			for (int j = 0; j < tamanhoTabuleiro.getColuna(); j++) {
				Setor<E> setorVertical;

				if (i == 0) {
					setorVertical = new Setor<E>(j, TipoSetor.VERTICAL);
					getSetoresVerticais().add(setorVertical);
				} else {
					setorVertical = getSetoresVerticais().get(j);
				}

				addQuadrante(setorHorizontal, setorVertical);
			}
		}
	}

	@Override
	public Boolean isEmpty() {
		for (int i = 0; i < getSetoresHorizontais().size(); i++) {
			for (int j = 0; j < getSetoresVerticais().size(); j++) {
				if (!((Quadrante<E>) getSetoresHorizontais().get(i).getQuadrantes().get(j)).isEmpty()) {
					return false;
				}
			}
		}

		return true;
	}

	@Override
	public Integer size() {
		Integer size = 0;
		for (int i = 0; i < getSetoresHorizontais().size(); i++) {
			for (int j = 0; j < getSetoresVerticais().size(); j++) {
				size += ((Quadrante<E>) getSetoresHorizontais().get(i).getQuadrantes().get(j)).size();
			}
		}

		return size;
	}

	/**
	 * Retorna a quantidade de setores do tabuleiro
	 * 
	 * @return totalSetores total de setores, tanto horizontal quanto vertical
	 */
	public Integer sizeSetores() {
		return getSetoresHorizontais().size() + getSetoresVerticais().size();
	}

	@Override
	public void clear() {
		for (int i = 0; i < setoresHorizontais.size(); i++) {
			for (int j = 0; j < getSetoresVerticais().size(); j++) {
				((Quadrante<E>) getSetoresHorizontais().get(i).getQuadrantes().get(j)).clear();
			}
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object obj) {
		Tabuleiro<E> outroTabuleiro;
		if (obj instanceof Tabuleiro) {
			outroTabuleiro = (Tabuleiro<E>) obj;

			if (setoresHorizontais.equals(outroTabuleiro.getSetoresHorizontais()) && getSetoresVerticais().equals(outroTabuleiro.getSetoresVerticais())) {
				return true;
			}
		}

		return false;
	}

	@Override
	public String toString() {
		StringBuffer tabuleiro = new StringBuffer();
		for (int i = 0; i < getSetoresHorizontais().size(); i++) {
			for (int j = 0; j < getSetoresVerticais().size(); j++) {
				tabuleiro.append(((Quadrante<E>) getSetoresHorizontais().get(i).getQuadrantes().get(j)).getElementos());
			}

			tabuleiro.append("\n");
		}

		return tabuleiro.toString();
	}

	/**
	 * Retorna o setor de acordo com o índice passado ou null caso não encontre o setor desejado.
	 * 
	 * @param setor
	 *            contendo o id e o tipo do setor a ser consultado
	 * @return {@link Setor} setor com todas as informações preenchidas ou null caso não encontre
	 */
	private Setor<E> getSetor(Setor<E> setor) {
		if (setor.getTipo().equals(TipoSetor.HORIZONTAL)) {
			for (Setor<E> setorHorizontal : setoresHorizontais) {
				if (setorHorizontal.getId().equals(setor.getId())) {
					return setorHorizontal;
				}
			}
		} else if (setor.getTipo().equals(TipoSetor.VERTICAL)) {
			for (Setor<E> setorVertical : setoresVerticais) {
				if (setorVertical.getId().equals(setor.getId())) {
					return setorVertical;
				}
			}
		}

		return null;
	}

	public Boolean addSetor(TipoSetor tipoSetor) {
		List<Setor<E>> setoresFixos = null;
		List<Setor<E>> setoresMutaveis = null;

		if (tipoSetor.equals(TipoSetor.HORIZONTAL)) {
			setoresFixos = getSetoresHorizontais();
			setoresMutaveis = getSetoresVerticais();
		} else if (tipoSetor.equals(TipoSetor.VERTICAL)) {
			setoresFixos = getSetoresVerticais();
			setoresMutaveis = getSetoresHorizontais();
		}

		Setor<E> setorFixo = new Setor<E>(setoresFixos.size(), tipoSetor);
		setoresFixos.add(setorFixo);

		for (Setor<E> setorMutavel : setoresMutaveis) {
			if (tipoSetor.equals(TipoSetor.HORIZONTAL)) {
				addQuadrante(setorFixo, setorMutavel);
			} else {
				addQuadrante(setorMutavel, setorFixo);
			}
		}

		return true;
	}

	private void addQuadrante(Setor<E> setorHorizontal, Setor<E> setorVertical) {
		Quadrante<E> quadrante = new Quadrante<E>(setorHorizontal, setorVertical);
		setorHorizontal.addQuadrante(quadrante);
		setorVertical.addQuadrante(quadrante);
	}

	public Boolean removeSetor(Setor<E> setor) {
		if (setor.getTipo().equals(TipoSetor.HORIZONTAL)) {
			return setoresHorizontais.remove(getSetor(setor));
		} else if (setor.getTipo().equals(TipoSetor.VERTICAL)) {
			return setoresVerticais.remove(getSetor(setor));
		}

		return false;
	}

}
