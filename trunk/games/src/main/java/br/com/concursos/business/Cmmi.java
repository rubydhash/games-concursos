package br.com.concursos.business;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Named;

import br.com.concursos.domain.Quadrante;
import br.com.concursos.domain.Tabuleiro;
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
public class Cmmi {

	private List<ProcessoCmmi> processos;
	private Tabuleiro<ProcessoCmmi> tabuleiro;
	private NivelDificuldade nivelDificuldade;

	public Cmmi() throws TabuleiroTamanhoInvalidoException, TitulosExcedemLimiteSetoresException {
		inicializa();
	}

	public List<ProcessoCmmi> getProcessos() {
		return processos;
	}

	public Tabuleiro<ProcessoCmmi> getTabuleiro() {
		return tabuleiro;
	}

	public void inicializa() throws TabuleiroTamanhoInvalidoException, TitulosExcedemLimiteSetoresException {
		tabuleiro = new Tabuleiro<ProcessoCmmi>(4, 4);
		processos = new ArrayList<ProcessoCmmi>();
		processos.addAll(Arrays.asList(ProcessoCmmi.values()));

		nivelDificuldade = NivelDificuldade.FACIL;
		montaTabuleiro();
	}

	private void montaTabuleiro() throws TitulosExcedemLimiteSetoresException {
		if (this.nivelDificuldade.equals(NivelDificuldade.FACIL)) {
			tabuleiro.setTitulos(GrupoProcessosCmmi.values(), TipoSetor.HORIZONTAL, false);
			tabuleiro.setTitulos(NivelCmmi.values(), TipoSetor.VERTICAL, false);
		} else if (this.nivelDificuldade.equals(NivelDificuldade.MEDIO)) {
			tabuleiro.setTitulos(GrupoProcessosCmmi.values(), TipoSetor.HORIZONTAL, true);
			tabuleiro.setTitulos(NivelCmmi.values(), TipoSetor.VERTICAL, true);
		} else if (this.nivelDificuldade.equals(NivelDificuldade.DIFICIL)) {
			/** TODO Misturar os objetos */
			// tabuleiro.setTitulos(GrupoProcessosCmmi.values(), TipoSetor.HORIZONTAL, true);
			// tabuleiro.setTitulos(NivelCmmi.values(), TipoSetor.VERTICAL, true);
		}
	}

	/**
	 * Verifica se os processos estao no devido lugar do Tabuleiro.
	 * 
	 * @return {@link Boolean}
	 * @throws GameErrorException
	 */
	public boolean finaliza() throws GameErrorException {
		if (verificaTabuleiro()) {
			throw new GameErrorException();
		}

		return true;
	}

	private boolean verificaTabuleiro() {
		return true;
	}

	/**
	 * Adiciona o processo no Tabuleiro e remove do painel de processos disponiveis.
	 * 
	 * @param processoCmmi
	 * @param quadrante
	 * @return {@link Boolean}
	 * @throws ConteudoExistenteException
	 * @throws ConteudoExcedeLimitePermitidoException
	 * @throws QuadranteInvalidoException
	 */
	public boolean addProcessoSelecionado(ProcessoCmmi processoCmmi, Quadrante<ProcessoCmmi> quadrante) throws ConteudoExistenteException,
			ConteudoExcedeLimitePermitidoException, QuadranteInvalidoException {

		quadrante = tabuleiro.getQuadrante(quadrante);

		if (quadrante.getConteudos().size() >= 5) {
			throw new ConteudoExcedeLimitePermitidoException();
		}

		tabuleiro.add(processoCmmi, quadrante);
		processos.remove(processoCmmi);

		return true;
	}

	/**
	 * Remove o processo do Tabuleiro e adiciona no painel de processos disponiveis.
	 * 
	 * @param processoCmmi
	 * @return {@link Boolean}
	 * @throws ConteudoNaoEncontradoException
	 */
	public boolean removeProcessoSelecionado(ProcessoCmmi processoCmmi) throws ConteudoNaoEncontradoException {
		tabuleiro.remove(processoCmmi);
		processos.add(processoCmmi);

		return true;
	}

}
