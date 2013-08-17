package br.com.concursos.domain;

import java.util.ArrayList;
import java.util.List;

import br.com.concursos.enumeration.TipoSetor;
import br.com.concursos.exception.ElementoExistenteException;
import br.com.concursos.exception.ElementoNaoEncontradoException;
import br.com.concursos.exception.LocalizacaoNaoPreenchidaException;
import br.com.concursos.exception.QuadranteInvalidoException;
import br.com.concursos.exception.TabuleiroTamanhoInvalidoException;

public class Tabuleiro<E> implements Modelo<E> {

	private List<Setor<E>> setoresHorizontais;
	private List<Setor<E>> setoresVerticais;
	private TamanhoTabuleiro tamanhoTabuleiro;
	private Setor<E> setorHorizontal;
	private Setor<E> setorVertical;

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

	public Setor<E> getSetorHorizontal() {
		return setorHorizontal;
	}

	public void setSetorHorizontal(Setor<E> setorHorizontal) {
		this.setorHorizontal = setorHorizontal;
	}

	public Setor<E> getSetorVertical() {
		return setorVertical;
	}

	public void setSetorVertical(Setor<E> setorVertical) {
		this.setorVertical = setorVertical;
	}

	/**
	 * Adiciona o conteúdo no tabuleiro no quadrante desejado.
	 * 
	 * @param conteudo
	 * @param setorHorizontal
	 * @param setorVertical
	 * @return {@link Boolean}
	 * @throws QuadranteInvalidoException
	 * @throws ElementoExistenteException
	 */
	public Boolean add(E e, Setor<E> setorHorizontal, Setor<E> setorVertical) throws QuadranteInvalidoException, ElementoExistenteException {
		if ((setorHorizontal.getId() < 0 || setorHorizontal.getId() > getSetoresHorizontais().size() - 1)
				|| (setorVertical.getId() < 0 || setorVertical.getId() > getSetoresVerticais().size() - 1)) {
			throw new QuadranteInvalidoException();
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
	 * Obs.: Deve ser inserido um setorHorizontal e um setorVertical ({@link Setor})
	 */
	@Override
	public Boolean add(E e) throws Exception {
		if (setorHorizontal == null || setorVertical == null) {
			throw new LocalizacaoNaoPreenchidaException();
		}

		add(e, setorHorizontal, setorVertical);
		setSetorHorizontal(null);
		setSetorVertical(null);

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
	 * Recupera o quadrante referente ao elemento no tabuleiro.
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
			Setor<E> setorHorizontal = new Setor<>(i, TipoSetor.HORIZONTAL);
			getSetoresHorizontais().add(setorHorizontal);

			for (int j = 0; j < tamanhoTabuleiro.getColuna(); j++) {
				Setor<E> setorVertical;

				if (i == 0) {
					setorVertical = new Setor<>(j, TipoSetor.VERTICAL);
					getSetoresVerticais().add(setorVertical);
				} else {
					setorVertical = getSetoresVerticais().get(j);
				}

				Quadrante<E> quadrante = new Quadrante<>(setorHorizontal, setorVertical);
				setorHorizontal.addQuadrante(quadrante);
				setorVertical.addQuadrante(quadrante);
			}
		}
	}

	@Override
	public Boolean isEmpty() {
		for (int i = 0; i < getSetoresHorizontais().size(); i++) {
			for (int j = 0; j < getSetoresVerticais().size(); j++) {
				if (!((Quadrante<E>) getSetoresHorizontais().get(i).getQuadrantes().get(j)).getElementos().isEmpty()) {
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

}
