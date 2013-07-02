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
import br.com.concursos.exception.TitulosExcedemLimiteSetoresException;

public class Tabuleiro {

	private int limiteQuadrante = 5;

	private Quadrante[][] quadrantes;
	private List<Setor> setoresHorizontais;
	private List<Setor> setoresVerticais;

	public Tabuleiro(int linha, int coluna) throws TabuleiroTamanhoInvalidoException {
		if (linha == 0 || coluna == 0 || linha < 0 || coluna < 0) {
			throw new TabuleiroTamanhoInvalidoException();
		}

		quadrantes = new Quadrante[linha][coluna];
		setoresHorizontais = new ArrayList<Setor>();
		setoresVerticais = new ArrayList<Setor>();
		for (int i = 0; i < linha; i++) {
			Setor setorHorizontal = new Setor(i, TipoSetor.HORIZONTAL);
			for (int j = 0; j < coluna; j++) {
				quadrantes[i][j] = new Quadrante(i, j);
				if (i == 0) {
					Setor setorVertical = new Setor(j, TipoSetor.VERTICAL);
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

	// /**
	// * @return the quadrantes
	// */
	// public Quadrante[][] getQuadrantes() {
	// return quadrantes;
	// }
	//
	// /**
	// * @return the setoresHorizontais
	// */
	// public List<Setor> getSetoresHorizontais() {
	// return setoresHorizontais;
	// }
	//
	// /**
	// * @return the setoresVerticais
	// */
	// public List<Setor> getSetoresVerticais() {
	// return setoresVerticais;
	// }

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
	public List<Quadrante> getQuadrantes(Setor setor) {
		return this.getSetor(setor.getTipo()).get(setor.getNumero()).getQuadrantes();
	}

	/**
	 * @param tipoSetor
	 * @return setoresHorizontais ou setoresVerticais
	 */
	public List<Setor> getSetor(TipoSetor tipoSetor) {
		if (tipoSetor.equals(TipoSetor.HORIZONTAL)) {
			return setoresHorizontais;
		} else if (tipoSetor.equals(TipoSetor.VERTICAL)) {
			return setoresVerticais;
		}

		throw new IllegalArgumentException();
	}

	/**
	 * @param setor
	 * @return setoresHorizontais ou setoresVerticais
	 */
	public Setor getSetor(Setor setor) {
		if (setor.getTipo().equals(TipoSetor.HORIZONTAL)) {
			return setoresHorizontais.get(setor.getNumero());
		} else if (setor.getTipo().equals(TipoSetor.VERTICAL)) {
			return setoresVerticais.get(setor.getNumero());
		}

		throw new IllegalArgumentException();
	}

	/**
	 * Altera todos os títulos de um determinado Setor do Tabuleiro.
	 * 
	 * @param titulos
	 * @param tipoSetor
	 * @param boolean
	 * @throws TitulosExcedemLimiteSetoresException
	 */
	public void setTitulos(List<?> titulos, TipoSetor tipoSetor, boolean randomico) throws TitulosExcedemLimiteSetoresException {
		List<Setor> setores = getSetor(tipoSetor);

		if (randomico) {
			Collections.shuffle(Arrays.asList(titulos));
		}

		if (titulos.size() > setores.size()) {
			throw new TitulosExcedemLimiteSetoresException();
		}

		for (int i = 0; i < titulos.size(); i++) {
			setores.get(i).setTitulo(titulos.get(i));
		}
	}

	/**
	 * Altera o título de um determinado Setor do Tabuleiro.
	 * 
	 * @param titulo
	 * @param setor
	 */
	public void setTitulo(Object titulo, Setor setor) {
		setor = getSetor(setor);

		setor.setTitulo(titulo);
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
	public boolean contains(Conteudo conteudo) {
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
	public Quadrante getQuadrante(Conteudo conteudo) throws ConteudoNaoEncontradoException {
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
	public Quadrante getQuadrante(int linha, int coluna) throws QuadranteInvalidoException {
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
	public Quadrante getQuadrante(Quadrante quadrante) throws QuadranteInvalidoException {
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
	public boolean add(Conteudo conteudo, Quadrante quadrante) throws ConteudoExistenteException, QuadranteInvalidoException,
			ConteudoExcedeLimitePermitidoException {
		quadrante = getQuadrante(quadrante);

		if (quadrante.getConteudos().size() >= limiteQuadrante) {
			throw new ConteudoExcedeLimitePermitidoException();
		}

		if ((quadrante.getLinha() < 0 || quadrante.getLinha() > getTotalQuadrantes(TipoSetor.HORIZONTAL) - 1)
				|| (quadrante.getColuna() < 0 || quadrante.getColuna() > getTotalQuadrantes(TipoSetor.VERTICAL) - 1)) {
			throw new QuadranteInvalidoException();
		}

		if (contains(conteudo)) {
			throw new ConteudoExistenteException();
		}

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
	public boolean remove(Conteudo conteudo) throws ConteudoNaoEncontradoException {
		Quadrante quadrante = getQuadrante(conteudo);
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

	public int getLimiteQuadrante() {
		return limiteQuadrante;
	}

	public void setLimiteQuadrante(int limiteQuadrante) {
		this.limiteQuadrante = limiteQuadrante;
	}

	/**
	 * Verifica os conteúdos com seus respectivos Quadrantes.
	 * 
	 * @param tipoSetor
	 * @return {@link Boolean} resposta
	 * 
	 */
	public boolean verificaConteudo(TipoSetor tipoSetor) {
		boolean resposta = true;
		Object titulo = new Object();

		List<Setor> setores = getSetor(tipoSetor);
		for (Setor setor : setores) {
			List<Quadrante> quadrantes = setor.getQuadrantes();
			for (Quadrante quadrante : quadrantes) {
				List<Conteudo> conteudos = quadrante.getConteudos();
				for (Conteudo conteudo : conteudos) {
					if (tipoSetor.equals(TipoSetor.HORIZONTAL)) {
						titulo = conteudo.getTituloHorizontal();
					} else if (tipoSetor.equals(TipoSetor.VERTICAL)) {
						titulo = conteudo.getTituloVertical();
					}
					if (!setor.getTitulo().equals(titulo)) {
						conteudo.setInPlace(false);
						resposta = false;
					}
				}
			}
		}
		
		return resposta;
	}

}
