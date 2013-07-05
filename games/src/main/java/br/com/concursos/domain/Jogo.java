package br.com.concursos.domain;

import java.util.ArrayList;
import java.util.List;

import br.com.concursos.business.Mapper;
import br.com.concursos.enumeration.NivelDificuldade;
import br.com.concursos.enumeration.TipoSetor;
import br.com.concursos.exception.ConteudoExcedeLimitePermitidoException;
import br.com.concursos.exception.ConteudoExistenteException;
import br.com.concursos.exception.ConteudoNaoEncontradoException;
import br.com.concursos.exception.GameErrorException;
import br.com.concursos.exception.QuadranteInvalidoException;
import br.com.concursos.exception.TabuleiroTamanhoInvalidoException;
import br.com.concursos.exception.TitulosExcedemLimiteSetoresException;

public abstract class Jogo {

	private List<Processo> processos;
	private Tabuleiro tabuleiro;
	private NivelDificuldade nivelDificuldade;
	private Mapper mapper;
	private List<?> titulosHorizontais;
	private List<?> titulosVerticais;
	private TamanhoTabuleiro tamanhoTabuleiro;
	private String versao;

	/**
	 * Prepara os Processos e o Tabuleiro.
	 * 
	 * @throws TabuleiroTamanhoInvalidoException
	 * @throws TitulosExcedemLimiteSetoresException
	 */
	public void inicializa() throws TabuleiroTamanhoInvalidoException, TitulosExcedemLimiteSetoresException {
		resetTabuleiro();
		resetProcessos();
		resetDificuldade();
	}

	/**
	 * Verifica se os processos estao no devido lugar do Tabuleiro.
	 * 
	 * @throws GameErrorException
	 */
	public void finaliza() throws GameErrorException {
		if (!(tabuleiro.verificaConteudo(TipoSetor.HORIZONTAL) && tabuleiro.verificaConteudo(TipoSetor.VERTICAL))) {
			throw new GameErrorException();
		}
	}

	/**
	 * Adiciona o processo no Tabuleiro e remove do painel de processos disponíveis.
	 * 
	 * @param processo
	 * @param quadrante
	 * @return {@link Boolean}
	 * @throws ConteudoExcedeLimitePermitidoException
	 * @throws QuadranteInvalidoException
	 * @throws ConteudoExistenteException
	 */
	public boolean add(Processo processo, Quadrante quadrante) throws ConteudoExistenteException, QuadranteInvalidoException,
			ConteudoExcedeLimitePermitidoException {
		tabuleiro.add(processo, quadrante);
		processos.remove(processo);

		return true;
	}

	/**
	 * Remove o processo do Tabuleiro e adiciona no painel de processos disponíveis.
	 * 
	 * @param processo
	 * @return {@link Boolean}
	 * @throws ConteudoNaoEncontradoException
	 */
	public boolean remove(Processo processo) throws ConteudoNaoEncontradoException {
		tabuleiro.remove(processo);
		processos.add(processo);

		return true;
	}

	/**
	 * Reinicializa a lista de processos.
	 * 
	 */
	private void resetProcessos() {
		processos = getMapper().getProcessos();
	}

	/**
	 * Reinicializa o tabuleiro.
	 * 
	 * @throws TabuleiroTamanhoInvalidoException
	 * @throws TitulosExcedemLimiteSetoresException
	 */
	private void resetTabuleiro() throws TabuleiroTamanhoInvalidoException {
		tabuleiro = new Tabuleiro(getTamanhoTabuleiro());
	}

	/**
	 * Reinicializa o nível de Dificuldade.
	 * 
	 * @throws TitulosExcedemLimiteSetoresException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void resetDificuldade() throws TitulosExcedemLimiteSetoresException {
		if (this.getNivelDificuldade().equals(NivelDificuldade.FACIL)) {
			tabuleiro.setTitulos(getTitulosHorizontais(), TipoSetor.HORIZONTAL, false);
			tabuleiro.setTitulos(getTitulosVerticais(), TipoSetor.VERTICAL, false);
		} else if (this.getNivelDificuldade().equals(NivelDificuldade.MEDIO)) {
			tabuleiro.setTitulos(getTitulosHorizontais(), TipoSetor.HORIZONTAL, true);
			tabuleiro.setTitulos(getTitulosVerticais(), TipoSetor.VERTICAL, true);
		} else if (this.getNivelDificuldade().equals(NivelDificuldade.DIFICIL)) {
			tabuleiro.setTitulos(getTitulosHorizontais(), TipoSetor.VERTICAL, true);
			tabuleiro.setTitulos(getTitulosVerticais(), TipoSetor.HORIZONTAL, true);
		} else if (this.getNivelDificuldade().equals(NivelDificuldade.MUITO_DIFICIL)) {
			List titulosHorizontais = new ArrayList();
			for (int i = 0; i < this.titulosHorizontais.size(); i++) {
				if (i % 2 == 0) {
					titulosHorizontais.add(getTitulosHorizontais().get(i));
				} else {
					titulosHorizontais.add(getTitulosVerticais().get(i));
				}
			}

			List titulosVerticais = new ArrayList();
			for (int i = 0; i < getTitulosVerticais().size(); i++) {
				if (i % 2 == 0) {
					titulosVerticais.add(getTitulosVerticais().get(i));
				} else {
					titulosVerticais.add(getTitulosHorizontais().get(i));
				}
			}

			tabuleiro.setTitulos(titulosHorizontais, TipoSetor.HORIZONTAL, true);
			tabuleiro.setTitulos(titulosVerticais, TipoSetor.VERTICAL, true);
		}
	}

	/** -- GETTERS AND SETTERS -- */

	/**
	 * @return the processos
	 */
	public List<Processo> getProcessos() {
		return processos;
	}

	/**
	 * @return the tabuleiro
	 */
	public Tabuleiro getTabuleiro() {
		return tabuleiro;
	}

	/**
	 * @return the nivelDificuldade
	 */
	public NivelDificuldade getNivelDificuldade() {
		return nivelDificuldade;
	}

	/**
	 * @param nivelDificuldade
	 *            the nivelDificuldade to set
	 */
	public void setNivelDificuldade(NivelDificuldade nivelDificuldade) {
		this.nivelDificuldade = nivelDificuldade;
	}

	/**
	 * @return the mapper
	 */
	public Mapper getMapper() {
		return mapper;
	}

	/**
	 * @param mapper
	 *            the mapper to set
	 */
	public void setMapper(Mapper mapper) {
		this.mapper = mapper;
	}

	/**
	 * @return the titulosHorizontais
	 */
	public List<?> getTitulosHorizontais() {
		return titulosHorizontais;
	}

	/**
	 * @param titulosHorizontais
	 *            the titulosHorizontais to set
	 */
	public void setTitulosHorizontais(List<?> titulosHorizontais) {
		this.titulosHorizontais = titulosHorizontais;
	}

	/**
	 * @return the titulosVerticais
	 */
	public List<?> getTitulosVerticais() {
		return titulosVerticais;
	}

	/**
	 * @param titulosVerticais
	 *            the titulosVerticais to set
	 */
	public void setTitulosVerticais(List<?> titulosVerticais) {
		this.titulosVerticais = titulosVerticais;
	}

	/**
	 * @return the tamanhoTabuleiro
	 */
	public TamanhoTabuleiro getTamanhoTabuleiro() {
		return tamanhoTabuleiro;
	}

	/**
	 * @param tamanhoTabuleiro
	 *            the tamanhoTabuleiro to set
	 */
	public void setTamanhoTabuleiro(TamanhoTabuleiro tamanhoTabuleiro) {
		this.tamanhoTabuleiro = tamanhoTabuleiro;
	}

	/**
	 * @return the versao
	 */
	public String getVersao() {
		return versao;
	}

	/**
	 * @param versao the versao to set
	 */
	public void setVersao(String versao) {
		this.versao = versao;
	}

}
