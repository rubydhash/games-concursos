package br.com.concursos.entity;

import java.util.ArrayList;
import java.util.List;

import br.com.concursos.exception.ConteudoExcedeLimitePermitidoException;
import br.com.concursos.exception.ConteudoExistenteException;
import br.com.concursos.exception.ConteudoNaoEncontradoException;
import br.com.concursos.exception.QuadranteInvalidoException;
import br.com.concursos.exception.TabuleiroTamanhoInvalidoException;

public class Tabuleiro<T> {

	private Quadrante<T>[][] quadrantes;

	@SuppressWarnings("unchecked")
	public Tabuleiro(int linha, int coluna) throws TabuleiroTamanhoInvalidoException {
		if (linha == 0 || coluna == 0 || linha < 0 || coluna < 0) {
			throw new TabuleiroTamanhoInvalidoException();
		}

		quadrantes = new Quadrante[linha][coluna];
		for (int i = 0; i < linha; i++) {
			for (int j = 0; j < coluna; j++) {
				quadrantes[i][j] = new Quadrante<T>(i, j, new ArrayList<T>());
			}
		}
	}

	/**
	 * Retorna o total de Quadrantes do Tabuleiro.
	 * 
	 * @return totalQuadrantes
	 */
	public int getTotalQuadrantes() {
		return quadrantes.length * quadrantes[0].length;
	}

	/**
	 * Retorna o total de Quadrantes na Horizontal do Tabuleiro.
	 * 
	 * @return totalQuadrantesHorizontal
	 */
	public int getTotalQuadrantesHorizontal() {
		return quadrantes[0].length;
	}

	/**
	 * Retorna o total de Quadrantes na Vertical do Tabuleiro.
	 * 
	 * @return totalQuadrantesVertival
	 */
	public int getTotalQuadrantesVertical() {
		return quadrantes.length;
	}

	/**
	 * Retorna os Quadrantes de uma determinada linha na Vertical do Tabuleiro.
	 * 
	 * @param linha
	 * @return {@link List} {@link Quadrante}
	 */
	public List<Quadrante<T>> getQuadrantesVerticais(int coluna) {
		List<Quadrante<T>> quadrantesVerticais = new ArrayList<Quadrante<T>>();
		
		for (int i = 0; i < getTotalQuadrantesVertical(); i++) {
			quadrantesVerticais.add(quadrantes[i][coluna]);
		}

		return quadrantesVerticais;
	}

	/**
	 * Retorna os Quadrantes de uma determinada linha na Horizontal do Tabuleiro.
	 * 
	 * @param linha
	 * @return {@link List} {@link Quadrante}
	 */
	public List<Quadrante<T>> getQuadrantesHorizontais(int linha) {
		List<Quadrante<T>> quadrantesHorizontais = new ArrayList<Quadrante<T>>();
		
		for (int j = 0; j < getTotalQuadrantesHorizontal(); j++) {
			quadrantesHorizontais.add(quadrantes[linha][j]);
		}

		return quadrantesHorizontais;
	}

	/**
	 * Retorna o quantos conteúdos estão no Tabuleiro.
	 * 
	 * @return totalConteudos
	 */
	public int getTotalConteudos() {
		int totalConteudos = 0;
		for (int i = 0; i < quadrantes.length; i++) {
			for (int j = 0; j < quadrantes[i].length; j++) {
				totalConteudos += quadrantes[i][j].getConteudo().size();
			}
		}

		return totalConteudos;
	}

	/**
	 * Procura o conteúdo no Tabuleiro.
	 * 
	 * @param conteudo
	 * @return {@link Boolean}
	 */
	public boolean findConteudo(T conteudo) {
		for (int i = 0; i < quadrantes.length; i++) {
			for (int j = 0; j < quadrantes[i].length; j++) {
				List<T> conteudos = quadrantes[i][j].getConteudo();
				for (T t : conteudos) {
					if (t.equals(conteudo)) {
						return true;
					}
				}
			}
		}

		return false;
	}

	/**
	 * Retorna o Quadrante que se encontra o conteúdo no Tabuleiro.
	 * 
	 * @param conteudo
	 * @return {@link Quadrante}
	 * @throws ConteudoNaoEncontradoException
	 */
	public Quadrante<T> getConteudo(T conteudo) throws ConteudoNaoEncontradoException {
		for (int i = 0; i < quadrantes.length; i++) {
			for (int j = 0; j < quadrantes[i].length; j++) {
				List<T> conteudos = quadrantes[i][j].getConteudo();
				for (T t : conteudos) {
					if (t.equals(conteudo)) {
						return quadrantes[i][j];
					}
				}
			}
		}

		throw new ConteudoNaoEncontradoException();
	}

	/**
	 * Retorna o conteúdo do Quadrante indicado
	 * 
	 * @param linha
	 * @param coluna
	 * @return {@link List}
	 */
	private List<T> getConteudosQuadrante(int linha, int coluna) {
		return quadrantes[linha][coluna].getConteudo();
	}

	/**
	 * Adiciona o conteúdo no Tabuleiro no quadrante desejado. (somente a linha e a coluna são necessários)
	 * 
	 * @param conteudo
	 * @param quadrante
	 * @return {@link Boolean}
	 * @throws ConteudoExistenteException
	 * @throws ConteudoExcedeLimitePermitidoException
	 * @throws QuadranteInvalidoException
	 */
	public boolean addConteudo(T conteudo, Quadrante<T> quadrante) throws ConteudoExistenteException, ConteudoExcedeLimitePermitidoException,
			QuadranteInvalidoException {
		if ((quadrante.getLinha() < 0 || quadrante.getLinha() > getTotalQuadrantesHorizontal() - 1)
				|| (quadrante.getColuna() < 0 || quadrante.getColuna() > getTotalQuadrantesVertical() - 1)) {
			throw new QuadranteInvalidoException();
		}

		List<T> conteudos = getConteudosQuadrante(quadrante.getLinha(), quadrante.getColuna());

		if (findConteudo(conteudo)) {
			throw new ConteudoExistenteException();
		}

		if (conteudos.size() >= 5) {
			throw new ConteudoExcedeLimitePermitidoException();
		}

		conteudos.add(conteudo);

		return true;
	}

	/**
	 * Remove o conteúdo do Tabuleiro no quadrante desejado. (somente a linha e a coluna são necessários)
	 * 
	 * @param conteudo
	 * @param quadrante
	 * @return {@link Boolean}
	 * @throws ConteudoNaoEncontradoException
	 */
	public boolean removeConteudo(T conteudo) throws ConteudoNaoEncontradoException {
		Quadrante<T> quadrante = getConteudo(conteudo);
		quadrante.getConteudo().remove(conteudo);

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
