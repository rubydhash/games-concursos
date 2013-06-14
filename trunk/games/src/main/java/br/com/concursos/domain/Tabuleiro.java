package br.com.concursos.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import br.com.concursos.enumeration.TipoSetor;
import br.com.concursos.exception.ConteudoExcedeLimitePermitidoException;
import br.com.concursos.exception.ConteudoExistenteException;
import br.com.concursos.exception.ConteudoNaoEncontradoException;
import br.com.concursos.exception.QuadranteInvalidoException;
import br.com.concursos.exception.TabuleiroTamanhoInvalidoException;

public class Tabuleiro<T> {

	private Quadrante<T>[][] quadrantes;
	private List<Setor<T>> setoresHorizontais;
	private List<Setor<T>> setoresVerticais;

	@SuppressWarnings("unchecked")
	public Tabuleiro(int linha, int coluna) throws TabuleiroTamanhoInvalidoException {
		if (linha == 0 || coluna == 0 || linha < 0 || coluna < 0) {
			throw new TabuleiroTamanhoInvalidoException();
		}

		quadrantes = new Quadrante[linha][coluna];
		setoresHorizontais = new ArrayList<Setor<T>>();
		setoresVerticais = new ArrayList<Setor<T>>();
		for (int i = 0; i < linha; i++) {
			Setor<T> setorHorizontal = new Setor<T>(i, TipoSetor.HORIZONTAL);
			for (int j = 0; j < coluna; j++) {
				quadrantes[i][j] = new Quadrante<T>(i, j);
				if (i == 0) {
					Setor<T> setorVertical = new Setor<T>(j, TipoSetor.VERTICAL);
					setorVertical.addQuadrante(quadrantes[i][j]);
					setoresVerticais.add(setorVertical);
				} else {
					setoresVerticais.get(j).addQuadrante(quadrantes[i][j]);
				}

				setorHorizontal.addQuadrante(quadrantes[i][j]);
			}
			setoresHorizontais.add(setorHorizontal);
		}
	}

	/**
	 * Retorna o total de Quadrantes do Tabuleiro.
	 * 
	 * @return totalQuadrantes
	 */
	public int getTotalQuadrantes() {
		return setoresHorizontais.size() * setoresVerticais.size();
	}

	/**
	 * Retorna o total de Quadrantes por Tipo de Setor (Horizontal ou Vertical)
	 * 
	 * @return totalQuadrantesSetor
	 */
	public int getTotalQuadrantes(TipoSetor tipoSetor) {
		if (tipoSetor.equals(TipoSetor.HORIZONTAL)) {
			return setoresHorizontais.get(0).getQuadrantes().size();
		}

		return setoresVerticais.get(0).getQuadrantes().size();
	}
	
	/**
	 * Retorna o total de Quadrantes por Tipo de Setor (Horizontal ou Vertical)
	 * 
	 * @return totalQuadrantesSetor
	 */
	public int getTotal(TipoSetor tipoSetor) {
		if (tipoSetor.equals(TipoSetor.HORIZONTAL)) {
			return setoresHorizontais.size();
		}

		return setoresVerticais.size();
	}

	/**
	 * Retorna os Quadrantes de um determinado setor do Tabuleiro.
	 * 
	 * @param Setor
	 * @return {@link List} {@link Quadrante}
	 */
	public List<Quadrante<T>> getQuadrantes(Setor<T> setor) {
		List<Quadrante<T>> quadrantes = new ArrayList<Quadrante<T>>();

		if (setor.getTipo().equals(TipoSetor.HORIZONTAL)) {
			quadrantes = setoresHorizontais.get(setor.getNumero()).getQuadrantes();
		} else {
			quadrantes = setoresVerticais.get(setor.getNumero()).getQuadrantes();
		}

		return quadrantes;
	}

	/**
	 * @return the quadrantes
	 */
	public Quadrante<T>[][] getQuadrantes() {
		return quadrantes;
	}

	/**
	 * @return the setoresHorizontais
	 */
	public List<Setor<T>> getSetoresHorizontais() {
		return setoresHorizontais;
	}

	/**
	 * @return the setoresVerticais
	 */
	public List<Setor<T>> getSetoresVerticais() {
		return setoresVerticais;
	}

	/**
	 * Altera todos os títulos de um determinado Setor do Tabuleiro.
	 * 
	 * @param titulos
	 * @param tipoSetor
	 */
	public void setTitulos(Object[] titulos, TipoSetor tipoSetor) {
		if (tipoSetor.equals(TipoSetor.HORIZONTAL)) {
			if (titulos.length != setoresHorizontais.size()) {
				throw new IllegalArgumentException();
			}

			for (int i = 0; i < titulos.length; i++) {
				setoresHorizontais.get(i).setTitulo(titulos[i]);
			}
		} else if (tipoSetor.equals(TipoSetor.VERTICAL)) {
			if (titulos.length != setoresVerticais.size()) {
				throw new IllegalArgumentException();
			}

			for (int i = 0; i < titulos.length; i++) {
				setoresVerticais.get(i).setTitulo(titulos[i]);
			}
		}
	}

	/**
	 * Altera todos os títulos randomicamente de um determinado Setor do Tabuleiro.
	 * 
	 * @param titulos
	 * @param tipoSetor
	 */
	public void setTitulosRandomico(Object[] titulos, TipoSetor tipoSetor) {
		Collections.shuffle(Arrays.asList(titulos));
		this.setTitulos(titulos, tipoSetor);
	}

	/**
	 * Retorna o quantos conteúdos estão no Tabuleiro.
	 * 
	 * @return totalConteudos
	 */
	public int getTotalConteudo() {
		int totalConteudos = 0;
		for (int i = 0; i < quadrantes.length; i++) {
			for (int j = 0; j < quadrantes[i].length; j++) {
				totalConteudos += quadrantes[i][j].getTotalConteudo();
			}
		}

		return totalConteudos;
	}

	/**
	 * Procura o conteudo no Tabuleiro.
	 * 
	 * @param conteudo
	 * @return {@link Boolean}
	 */
	public boolean contains(T conteudo) {
		for (int i = 0; i < quadrantes.length; i++) {
			for (int j = 0; j < quadrantes[i].length; j++) {
				if (quadrantes[i][j].contains(conteudo)) {
					return true;
				}
			}
		}

		return false;
	}

	/**
	 * Retorna o Quadrante que se encontra o conteudo no Tabuleiro.
	 * 
	 * @param conteudo
	 * @return {@link Quadrante}
	 * @throws ConteudoNaoEncontradoException
	 */
	public Quadrante<T> getQuadrante(T conteudo) throws ConteudoNaoEncontradoException {
		if (!this.contains(conteudo)) {
			throw new ConteudoNaoEncontradoException();
		}

		for (int i = 0; i < quadrantes.length; i++) {
			for (int j = 0; j < quadrantes[i].length; j++) {
				if (quadrantes[i][j].contains(conteudo)) {
					return quadrantes[i][j];
				}
			}
		}

		throw new ConteudoNaoEncontradoException();
	}

	/**
	 * Retorna o Quadrante que se encontra o conteudo no Tabuleiro.
	 * 
	 * @param linha
	 * @param coluna
	 * @return {@link Quadrante}
	 * @throws QuadranteInvalidoException
	 */
	public Quadrante<T> getQuadrante(int linha, int coluna) throws QuadranteInvalidoException {
		if ((linha < 0 || coluna > getTotalQuadrantes(TipoSetor.HORIZONTAL) - 1) || (linha < 0 || coluna > getTotalQuadrantes(TipoSetor.VERTICAL) - 1)) {
			throw new QuadranteInvalidoException();
		}

		return quadrantes[linha][coluna];
	}

	/**
	 * Retorna o Quadrante que se encontra o conteudo no Tabuleiro.
	 * 
	 * @param quadrante
	 * @return {@link Quadrante}
	 * @throws QuadranteInvalidoException
	 */
	public Quadrante<T> getQuadrante(Quadrante<T> quadrante) throws QuadranteInvalidoException {
		if ((quadrante.getLinha() < 0 || quadrante.getColuna() > getTotalQuadrantes(TipoSetor.HORIZONTAL) - 1)
				|| (quadrante.getLinha() < 0 || quadrante.getColuna() > getTotalQuadrantes(TipoSetor.VERTICAL) - 1)) {
			throw new QuadranteInvalidoException();
		}

		return quadrantes[quadrante.getLinha()][quadrante.getColuna()];
	}

	/**
	 * Adiciona o conteudo no Tabuleiro no quadrante desejado. (somente a linha e a coluna sao necessarios)
	 * 
	 * @param conteudo
	 * @param quadrante
	 * @return {@link Boolean}
	 * @throws ConteudoExistenteException
	 * @throws QuadranteInvalidoException
	 * @throws ConteudoExcedeLimitePermitidoException
	 */
	public boolean add(T conteudo, Quadrante<T> quadrante) throws ConteudoExistenteException, QuadranteInvalidoException,
			ConteudoExcedeLimitePermitidoException {
		quadrante = getQuadrante(quadrante);

		if ((quadrante.getLinha() < 0 || quadrante.getLinha() > getTotalQuadrantes(TipoSetor.HORIZONTAL) - 1)
				|| (quadrante.getColuna() < 0 || quadrante.getColuna() > getTotalQuadrantes(TipoSetor.VERTICAL) - 1)) {
			throw new QuadranteInvalidoException();
		}

		if (quadrante.getConteudos().size() >= 5) {
			throw new ConteudoExcedeLimitePermitidoException();
		}

		if (contains(conteudo)) {
			throw new ConteudoExistenteException();
		}

		quadrante = getQuadrante(quadrante.getLinha(), quadrante.getColuna());
		quadrante.add(conteudo);

		return true;
	}

	/**
	 * Remove o conteúdo do Tabuleiro no quadrante desejado.
	 * 
	 * @param conteudo
	 * @param quadrante
	 * @return {@link Boolean}
	 * @throws ConteudoNaoEncontradoException
	 */
	public boolean remove(T conteudo) throws ConteudoNaoEncontradoException {
		Quadrante<T> quadrante = getQuadrante(conteudo);
		quadrante.remove(conteudo);

		return true;
	}

	@Override
	public String toString() {
		StringBuffer tabuleiro = new StringBuffer();
		for (int i = 0; i < quadrantes.length; i++) {
			for (int j = 0; j < quadrantes[i].length; j++) {
				tabuleiro.append(quadrantes[i][j]);
			}

			tabuleiro.append("\n");
		}

		return tabuleiro.toString();
	}

}
