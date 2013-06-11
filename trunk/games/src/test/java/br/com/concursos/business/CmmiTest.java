package br.com.concursos.business;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.com.concursos.business.Cmmi;
import br.com.concursos.domain.Quadrante;
import br.com.concursos.enumeration.ProcessoCmmi;
import br.com.concursos.exception.ConteudoExcedeLimitePermitidoException;
import br.com.concursos.exception.ConteudoExistenteException;
import br.com.concursos.exception.ConteudoNaoEncontradoException;
import br.com.concursos.exception.GameErrorException;
import br.com.concursos.exception.QuadranteInvalidoException;
import br.com.concursos.exception.TabuleiroTamanhoInvalidoException;

public class CmmiTest {

	private Cmmi cmmi;
	private Quadrante<ProcessoCmmi> quadrante;

	@Before
	public void init() throws TabuleiroTamanhoInvalidoException {
		cmmi = new Cmmi();
		quadrante = new Quadrante<ProcessoCmmi>(0, 0);
	}

//	@Test
//	public void testInicializaGame() throws TabuleiroTamanhoInvalidoException {
//		cmmi.inicializa();
//		List<ProcessoCmmi> processos = cmmi.getProcessos();
//
//		assertEquals("A lista de processos deve conter todos os 22 processos existentes no CMMI.", 22, processos.size());
//		assertNotNull(cmmi.getTabuleiro());
//	}
//
//	@Test
//	public void testFinalizaComSucessoGame() throws GameErrorException {
//		// assertTrue(cmmi.finaliza());
//	}
//
//	@Test(expected = GameErrorException.class)
//	public void testFinalizaComErrosGame() throws GameErrorException {
//		cmmi.finaliza();
//	}
//
//	@Test
//	public void testAddProcessoSelecionado() throws ConteudoExistenteException, ConteudoExcedeLimitePermitidoException, QuadranteInvalidoException {
//		assertTrue(cmmi.addProcessoSelecionado(ProcessoCmmi.ANALISE_CASUAL_E_RESOLUCAO, quadrante));
//	}
//
//	@Test(expected = ConteudoExistenteException.class)
//	public void testAddProcessoSelecionadoExistente() throws ConteudoExistenteException, ConteudoExcedeLimitePermitidoException, QuadranteInvalidoException {
//		cmmi.addProcessoSelecionado(ProcessoCmmi.ANALISE_CASUAL_E_RESOLUCAO, quadrante);
//		cmmi.addProcessoSelecionado(ProcessoCmmi.ANALISE_CASUAL_E_RESOLUCAO, quadrante);
//	}
//
//	@Test(expected = ConteudoExcedeLimitePermitidoException.class)
//	public void testAddProcessoSelecionadoAcimaDoLimitePermitidoNoMesmoQuadrante() throws ConteudoExistenteException, ConteudoExcedeLimitePermitidoException,
//			QuadranteInvalidoException {
//		cmmi.addProcessoSelecionado(ProcessoCmmi.ANALISE_CASUAL_E_RESOLUCAO, quadrante);
//		cmmi.addProcessoSelecionado(ProcessoCmmi.ANALISE_DE_DECISAO_E_RESOLUCAO, quadrante);
//		cmmi.addProcessoSelecionado(ProcessoCmmi.DEFINICAO_DE_PROCESSO_ORGANIZACIONAL, quadrante);
//		cmmi.addProcessoSelecionado(ProcessoCmmi.DESEMPENHO_DE_PROCESSO_ORGANIZACIONAL, quadrante);
//		cmmi.addProcessoSelecionado(ProcessoCmmi.DESENVOLVIMENTO_DE_REQUISITOS, quadrante);
//		cmmi.addProcessoSelecionado(ProcessoCmmi.FOCO_DE_PROCESSO_ORGANIZACIONAL, quadrante);
//	}
//
//	@Test
//	public void testRemoveProcessoSelecionado() throws ConteudoExistenteException, ConteudoExcedeLimitePermitidoException, QuadranteInvalidoException,
//			ConteudoNaoEncontradoException {
//		cmmi.addProcessoSelecionado(ProcessoCmmi.ANALISE_CASUAL_E_RESOLUCAO, quadrante);
//		assertTrue(cmmi.removeProcessoSelecionado(ProcessoCmmi.ANALISE_CASUAL_E_RESOLUCAO));
//	}
//
//	@Test(expected = ConteudoNaoEncontradoException.class)
//	public void testRemoveProcessoSelecionadoNaoEncontrado() throws ConteudoNaoEncontradoException {
//		cmmi.removeProcessoSelecionado(ProcessoCmmi.ANALISE_CASUAL_E_RESOLUCAO);
//	}
//
}
