package br.com.concursos.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Named;

import br.com.concursos.business.ProcessoCmmiMapper;
import br.com.concursos.enumeration.GrupoProcessosCmmi;
import br.com.concursos.enumeration.NivelCmmi;
import br.com.concursos.enumeration.NivelDificuldade;
import br.com.concursos.enumeration.ProcessoCmmi;
import br.com.concursos.enumeration.TipoSetor;
import br.com.concursos.exception.ConteudoExcedeLimitePermitidoException;
import br.com.concursos.exception.ConteudoExistenteException;
import br.com.concursos.exception.ConteudoNaoEncontradoException;
import br.com.concursos.exception.GameErrorException;
import br.com.concursos.exception.QuadranteInvalidoException;
import br.com.concursos.exception.TabuleiroTamanhoInvalidoException;
import br.com.concursos.exception.TitulosExcedemLimiteSetoresException;

@Named
public class Cmmi implements Jogo {

	private List<Processo> processos;
	private Tabuleiro tabuleiro;
	private NivelDificuldade nivelDificuldade;

	public Cmmi() throws TabuleiroTamanhoInvalidoException, TitulosExcedemLimiteSetoresException {
		inicializa();
	}

	public List<Processo> getProcessos() {
		return processos;
	}

	public Tabuleiro getTabuleiro() {
		return tabuleiro;
	}

	/**
	 * Prepara os processos e o Tabuleiro.
	 * 
	 * @throws TabuleiroTamanhoInvalidoException
	 * @throws TitulosExcedemLimiteSetoresException
	 */
	public void inicializa() throws TabuleiroTamanhoInvalidoException, TitulosExcedemLimiteSetoresException {
		setNivelDificuldade(NivelDificuldade.FACIL);
		resetTabuleiro();
		resetProcessos();
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
	 * Adiciona um processo no Tabuleiro e remove do painel de processos disponíveis.
	 * 
	 * @param processoCmmi
	 * @param quadrante
	 * @return {@link Boolean}
	 * @throws ConteudoExistenteException
	 * @throws ConteudoExcedeLimitePermitidoException
	 * @throws QuadranteInvalidoException
	 */
	public boolean add(ProcessoCmmi processoCmmi, Quadrante quadrante) throws ConteudoExistenteException, ConteudoExcedeLimitePermitidoException,
			QuadranteInvalidoException {
		Processo processo = ProcessoCmmiMapper.getProcessoPorProcessoCmmi(processoCmmi);
		tabuleiro.add(processo, quadrante);
		processos.remove(processo);

		return true;
	}

	/**
	 * Remove um processo do Tabuleiro e adiciona no painel de processos disponíveis.
	 * 
	 * @param processoCmmi
	 * @return {@link Boolean}
	 * @throws ConteudoNaoEncontradoException
	 */
	public boolean remove(ProcessoCmmi processoCmmi) throws ConteudoNaoEncontradoException {
		Processo processo = ProcessoCmmiMapper.getProcessoPorProcessoCmmi(processoCmmi);
		tabuleiro.remove(processo);
		processos.add(processo);

		return true;
	}

	/**
	 * Reinicializa a lista de processos.
	 * 
	 */
	private void resetProcessos() {
		processos = ProcessoCmmiMapper.getProcessos();
	}

	/**
	 * Reinicializa o tabuleiro.
	 * 
	 * @throws TabuleiroTamanhoInvalidoException
	 * @throws TitulosExcedemLimiteSetoresException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void resetTabuleiro() throws TabuleiroTamanhoInvalidoException, TitulosExcedemLimiteSetoresException {
		tabuleiro = new Tabuleiro(4, 4);

		List<GrupoProcessosCmmi> grupoProcessosCmmis = new ArrayList<GrupoProcessosCmmi>();
		grupoProcessosCmmis.addAll(Arrays.asList(GrupoProcessosCmmi.values()));

		List<NivelCmmi> nivelCmmis = new ArrayList<NivelCmmi>();
		nivelCmmis.addAll(Arrays.asList(NivelCmmi.values()));

		if (this.getNivelDificuldade().equals(NivelDificuldade.FACIL)) {
			tabuleiro.setTitulos(grupoProcessosCmmis, TipoSetor.HORIZONTAL, false);
			tabuleiro.setTitulos(nivelCmmis, TipoSetor.VERTICAL, false);
		} else if (this.getNivelDificuldade().equals(NivelDificuldade.MEDIO)) {
			tabuleiro.setTitulos(grupoProcessosCmmis, TipoSetor.HORIZONTAL, true);
			tabuleiro.setTitulos(nivelCmmis, TipoSetor.VERTICAL, true);
		} else if (this.getNivelDificuldade().equals(NivelDificuldade.DIFICIL)) {
			tabuleiro.setTitulos(grupoProcessosCmmis, TipoSetor.VERTICAL, true);
			tabuleiro.setTitulos(nivelCmmis, TipoSetor.HORIZONTAL, true);
		} else if (this.getNivelDificuldade().equals(NivelDificuldade.MUITO_DIFICIL)) {
			List titulosHorizontais = new ArrayList();
			titulosHorizontais.add(grupoProcessosCmmis.get(0));
			titulosHorizontais.add(grupoProcessosCmmis.get(2));
			titulosHorizontais.add(nivelCmmis.get(1));
			titulosHorizontais.add(nivelCmmis.get(3));

			List titulosVerticais = new ArrayList();
			titulosHorizontais.add(grupoProcessosCmmis.get(1));
			titulosHorizontais.add(grupoProcessosCmmis.get(3));
			titulosHorizontais.add(nivelCmmis.get(0));
			titulosHorizontais.add(nivelCmmis.get(2));
			
			tabuleiro.setTitulos(titulosHorizontais, TipoSetor.HORIZONTAL, true);
			tabuleiro.setTitulos(titulosVerticais, TipoSetor.VERTICAL, true);
		}
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

}
