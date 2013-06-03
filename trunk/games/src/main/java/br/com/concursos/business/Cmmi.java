package br.com.concursos.business;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import br.com.concursos.domain.Quadrante;
import br.com.concursos.domain.Tabuleiro;
import br.com.concursos.enumeration.GrupoProcessosCmmi;
import br.com.concursos.enumeration.NivelCmmi;
import br.com.concursos.enumeration.NivelDificuldade;
import br.com.concursos.enumeration.ProcessoCmmi;
import br.com.concursos.exception.ConteudoExcedeLimitePermitidoException;
import br.com.concursos.exception.ConteudoExistenteException;
import br.com.concursos.exception.ConteudoNaoEncontradoException;
import br.com.concursos.exception.GameErrorException;
import br.com.concursos.exception.QuadranteInvalidoException;
import br.com.concursos.exception.TabuleiroTamanhoInvalidoException;

@Named
public class Cmmi {

	private List<ProcessoCmmi> processos;
	private Tabuleiro<ProcessoCmmi> tabuleiro;
	private NivelDificuldade nivelDificuldade;

	public Cmmi() throws TabuleiroTamanhoInvalidoException {
		inicializa();
	}

	public List<ProcessoCmmi> getProcessos() {
		return processos;
	}

	public Tabuleiro<ProcessoCmmi> getTabuleiro() {
		return tabuleiro;
	}

	public void inicializa() throws TabuleiroTamanhoInvalidoException {
		tabuleiro = new Tabuleiro<ProcessoCmmi>(4, 4);
		processos = new ArrayList<ProcessoCmmi>();

		ProcessoCmmi[] arrayProcessos = ProcessoCmmi.values();
		for (int i = 0; i < arrayProcessos.length; i++) {
			processos.add(arrayProcessos[i]);
		}

		nivelDificuldade = NivelDificuldade.FACIL;
		montaTabuleiro();

	}

	private void montaTabuleiro() {
		if (this.nivelDificuldade.equals(NivelDificuldade.FACIL)) {
			tabuleiro.setTituloQuadrantesSetorHorizontal(0, GrupoProcessosCmmi.GESTAO_DE_PROCESSOS);
			tabuleiro.setTituloQuadrantesSetorHorizontal(1, GrupoProcessosCmmi.GESTAO_DE_PROJETOS);
			tabuleiro.setTituloQuadrantesSetorHorizontal(2, GrupoProcessosCmmi.ENGENHARIA);
			tabuleiro.setTituloQuadrantesSetorHorizontal(3, GrupoProcessosCmmi.SUPORTE);

			tabuleiro.setTituloQuadrantesSetorVertical(0, NivelCmmi.NIVEL_2);
			tabuleiro.setTituloQuadrantesSetorVertical(1, NivelCmmi.NIVEL_3);
			tabuleiro.setTituloQuadrantesSetorVertical(2, NivelCmmi.NIVEL_4);
			tabuleiro.setTituloQuadrantesSetorVertical(3, NivelCmmi.NIVEL_5);
		} else if (this.nivelDificuldade.equals(NivelDificuldade.MEDIO)) {

		} else if (this.nivelDificuldade.equals(NivelDificuldade.DIFICIL)) {

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
		tabuleiro.addConteudo(processoCmmi, quadrante);
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
		tabuleiro.removeConteudo(processoCmmi);
		processos.add(processoCmmi);

		return true;
	}

}
