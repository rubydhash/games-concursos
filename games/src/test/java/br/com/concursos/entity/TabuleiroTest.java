package br.com.concursos.entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import br.com.concursos.exception.ConteudoExcedeLimitePermitidoException;
import br.com.concursos.exception.ConteudoExistenteException;
import br.com.concursos.exception.ConteudoNaoEncontradoException;
import br.com.concursos.exception.QuadranteInvalidoException;
import br.com.concursos.exception.TabuleiroTamanhoInvalidoException;

public class TabuleiroTest {

	private Tabuleiro<String> tabuleiro;

	@Before
	public void init() throws TabuleiroTamanhoInvalidoException {
		tabuleiro = new Tabuleiro<String>(4, 3);
	}

	@Test
	public void testCriacaoTabuleiro() {
		assertEquals("Total de quadrantes = x * y", 12, tabuleiro.getTotalQuadrantes());
	}

	@Test(expected = TabuleiroTamanhoInvalidoException.class)
	public void testCriacaoTabuleiroTamanhoInvalido() throws TabuleiroTamanhoInvalidoException {
		tabuleiro = new Tabuleiro<String>(-1, -1);
	}

	@Test(expected = TabuleiroTamanhoInvalidoException.class)
	public void testCriacaoTabuleiroTamanhoInvalidoLimiteZero() throws TabuleiroTamanhoInvalidoException {
		tabuleiro = new Tabuleiro<String>(0, 4);
	}

	@Test
	public void testGetTotalQuadrantesHorizontal() {
		assertEquals("Total de quadrantes na horizontal (x) = 3", 3, tabuleiro.getTotalQuadrantesHorizontal());
	}

	@Test
	public void testGetTotalQuadrantesVertical() {
		assertEquals("Total de quadrantes na vertical (y) = 4", 4, tabuleiro.getTotalQuadrantesVertical());
	}

	@Test
	public void testGetQuadrantesHorizontal() {
		assertEquals("Quadrantes horizontal (x) = 3", 3, tabuleiro.getQuadrantesHorizontais(0).size());
	}

	@Test
	public void testGetQuadrantesVertical() {
		assertEquals("Quadrantes vertical (y) = 4", 4, tabuleiro.getQuadrantesVerticais(0).size());
	}

	@Test
	public void testGetTotalConteudo() throws ConteudoExistenteException, ConteudoExcedeLimitePermitidoException, QuadranteInvalidoException {
		tabuleiro.addConteudo(new String("teste1"), new Quadrante<String>(0, 0));
		tabuleiro.addConteudo(new String("teste2"), new Quadrante<String>(1, 1));
		tabuleiro.addConteudo(new String("teste3"), new Quadrante<String>(2, 2));

		assertEquals("Total de conteúdos no Tabuleiro, independente de onde estiver.", 3, tabuleiro.getTotalConteudos());
	}

	@Test
	public void testFindConteudoNaoEncontrado() {
		assertFalse(tabuleiro.findConteudo(new String("teste")));
	}

	@Test
	public void testFindConteudoEncontrado() throws ConteudoExistenteException, ConteudoExcedeLimitePermitidoException, QuadranteInvalidoException {
		tabuleiro.addConteudo(new String("teste"), new Quadrante<String>(0, 0));
		assertTrue(tabuleiro.findConteudo(new String("teste")));
	}

	@Test
	public void testAddConteudo() throws ConteudoExistenteException, ConteudoExcedeLimitePermitidoException, QuadranteInvalidoException {
		assertTrue(tabuleiro.addConteudo(new String("teste"), new Quadrante<String>(0, 0)));
	}

	@Test(expected = ConteudoExistenteException.class)
	public void testAddConteudoExistente() throws ConteudoExistenteException, ConteudoExcedeLimitePermitidoException, QuadranteInvalidoException {
		tabuleiro.addConteudo(new String("teste"), new Quadrante<String>(0, 0));
		tabuleiro.addConteudo(new String("teste"), new Quadrante<String>(0, 0));
	}

	@Test(expected = QuadranteInvalidoException.class)
	public void testAddConteudoQuadranteInvalidoLimiteSuperior() throws ConteudoExistenteException, ConteudoExcedeLimitePermitidoException,
			QuadranteInvalidoException {
		tabuleiro.addConteudo(new String("teste"), new Quadrante<String>(5, 5));
	}

	@Test(expected = QuadranteInvalidoException.class)
	public void testAddConteudoQuadranteInvalidoLimiteInferior() throws ConteudoExistenteException, ConteudoExcedeLimitePermitidoException,
			QuadranteInvalidoException {
		tabuleiro.addConteudo(new String("teste"), new Quadrante<String>(-1, -1));
	}

	@Test(expected = ConteudoExcedeLimitePermitidoException.class)
	public void testAddConteudoExcedeLimitePermitido() throws ConteudoExistenteException, ConteudoExcedeLimitePermitidoException, QuadranteInvalidoException {
		tabuleiro.addConteudo(new String("teste1"), new Quadrante<String>(0, 0));
		tabuleiro.addConteudo(new String("teste2"), new Quadrante<String>(0, 0));
		tabuleiro.addConteudo(new String("teste3"), new Quadrante<String>(0, 0));
		tabuleiro.addConteudo(new String("teste4"), new Quadrante<String>(0, 0));
		tabuleiro.addConteudo(new String("teste5"), new Quadrante<String>(0, 0));
		tabuleiro.addConteudo(new String("teste6"), new Quadrante<String>(0, 0));
	}

	@Test
	public void testRemoveConteudo() throws ConteudoNaoEncontradoException, ConteudoExistenteException, ConteudoExcedeLimitePermitidoException,
			QuadranteInvalidoException {
		tabuleiro.addConteudo(new String("teste"), new Quadrante<String>(0, 0));
		assertTrue(tabuleiro.removeConteudo(new String("teste")));
	}

	@Test(expected = ConteudoNaoEncontradoException.class)
	public void testRemoveConteudoNaoEncontrado() throws ConteudoNaoEncontradoException {
		tabuleiro.removeConteudo(new String("teste"));
	}

	@Test
	public void testGetConteudo() throws ConteudoNaoEncontradoException, ConteudoExistenteException, ConteudoExcedeLimitePermitidoException,
			QuadranteInvalidoException {
		tabuleiro.addConteudo(new String("teste"), new Quadrante<String>(0, 0));
		assertNotNull(tabuleiro.getConteudo(new String("teste")));
	}

	@Test(expected = ConteudoNaoEncontradoException.class)
	public void testGetConteudoNaoEncontrado() throws ConteudoNaoEncontradoException {
		tabuleiro.getConteudo(new String("teste"));
	}

	@Test
	public void testTabuleiro() {
		assertNotNull(tabuleiro.toString());
		// System.out.println(tabuleiro);
	}

}
