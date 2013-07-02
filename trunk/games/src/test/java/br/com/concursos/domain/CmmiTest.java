package br.com.concursos.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.com.concursos.domain.Cmmi;
import br.com.concursos.domain.Processo;
import br.com.concursos.domain.Quadrante;
import br.com.concursos.enumeration.ProcessoCmmi;
import br.com.concursos.exception.ConteudoExcedeLimitePermitidoException;
import br.com.concursos.exception.ConteudoExistenteException;
import br.com.concursos.exception.ConteudoNaoEncontradoException;
import br.com.concursos.exception.GameErrorException;
import br.com.concursos.exception.QuadranteInvalidoException;
import br.com.concursos.exception.TabuleiroTamanhoInvalidoException;
import br.com.concursos.exception.TitulosExcedemLimiteSetoresException;

public class CmmiTest {

	private Cmmi cmmi;
	private Quadrante quadrante;

	@Before
	public void init() throws TabuleiroTamanhoInvalidoException, TitulosExcedemLimiteSetoresException {
		cmmi = new Cmmi();
		quadrante = new Quadrante(0, 0);
	}

	@Test
	public void testInicializaGame() throws TabuleiroTamanhoInvalidoException, TitulosExcedemLimiteSetoresException {
		cmmi.inicializa();
		List<Processo> processos = cmmi.getProcessos();

		assertEquals("A lista de processos deve conter todos os 22 processos existentes no CMMI.", 22, processos.size());
		assertNotNull(cmmi.getTabuleiro());
	}

	@Test
	public void testFinalizaComSucessoGame() throws Exception {
		cmmi.finaliza();
	}

	@Test(expected = GameErrorException.class)
	public void testFinalizaComErrosGame() throws Exception {
		cmmi.add(ProcessoCmmi.ANALISE_CASUAL_E_RESOLUCAO, quadrante);
		cmmi.finaliza();
	}

	@Test
	public void testAddProcessoCmmi() throws ConteudoExistenteException, QuadranteInvalidoException, ConteudoExcedeLimitePermitidoException {
		assertTrue(cmmi.add(ProcessoCmmi.ANALISE_CASUAL_E_RESOLUCAO, quadrante));
	}

	@Test(expected = ConteudoExistenteException.class)
	public void testAddProcessoCmmiExistente() throws ConteudoExistenteException, QuadranteInvalidoException, ConteudoExcedeLimitePermitidoException {
		cmmi.add(ProcessoCmmi.ANALISE_CASUAL_E_RESOLUCAO, quadrante);
		cmmi.add(ProcessoCmmi.ANALISE_CASUAL_E_RESOLUCAO, quadrante);
	}

	@Test(expected = ConteudoExcedeLimitePermitidoException.class)
	public void testAddProcessoCmmiAcimaDoLimitePermitidoNoMesmoQuadrante() throws ConteudoExistenteException,
			QuadranteInvalidoException, ConteudoExcedeLimitePermitidoException {
		cmmi.add(ProcessoCmmi.ANALISE_CASUAL_E_RESOLUCAO, quadrante);
		cmmi.add(ProcessoCmmi.ANALISE_DE_DECISAO_E_RESOLUCAO, quadrante);
		cmmi.add(ProcessoCmmi.DEFINICAO_DE_PROCESSO_ORGANIZACIONAL, quadrante);
		cmmi.add(ProcessoCmmi.DESEMPENHO_DE_PROCESSO_ORGANIZACIONAL, quadrante);
		cmmi.add(ProcessoCmmi.DESENVOLVIMENTO_DE_REQUISITOS, quadrante);
		cmmi.add(ProcessoCmmi.FOCO_DE_PROCESSO_ORGANIZACIONAL, quadrante);
	}

	@Test
	public void testRemoveProcessoCmmi() throws ConteudoExistenteException, QuadranteInvalidoException,
 ConteudoNaoEncontradoException,
			ConteudoExcedeLimitePermitidoException {
		cmmi.add(ProcessoCmmi.ANALISE_CASUAL_E_RESOLUCAO, quadrante);
		assertTrue(cmmi.remove(ProcessoCmmi.ANALISE_CASUAL_E_RESOLUCAO));
	}

	@Test(expected = ConteudoNaoEncontradoException.class)
	public void testRemoveProcessoCmmiNaoEncontrado() throws ConteudoNaoEncontradoException {
		cmmi.remove(ProcessoCmmi.ANALISE_CASUAL_E_RESOLUCAO);
	}

}
