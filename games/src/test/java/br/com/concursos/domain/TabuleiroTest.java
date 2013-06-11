package br.com.concursos.domain;

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

//	@Test
//	public void testCriacaoTabuleiro() {
//		assertEquals("Total de quadrantes = x * y", 12, tabuleiro.getTotalQuadrantes());
//	}
//
//	@Test(expected = TabuleiroTamanhoInvalidoException.class)
//	public void testCriacaoTabuleiroTamanhoInvalido() throws TabuleiroTamanhoInvalidoException {
//		tabuleiro = new Tabuleiro<String>(-1, -1);
//	}
//
//	@Test(expected = TabuleiroTamanhoInvalidoException.class)
//	public void testCriacaoTabuleiroTamanhoInvalidoLimiteZero() throws TabuleiroTamanhoInvalidoException {
//		tabuleiro = new Tabuleiro<String>(0, 4);
//	}
//
//	@Test
//	public void testGetTotalQuadrantesSetorHorizontal() {
//		assertEquals("Total de quadrantes na horizontal (x) = 3", 3, tabuleiro.getTotalQuadrantesSetorHorizontal());
//	}
//
//	@Test
//	public void testGetTotalQuadrantesSetorVertical() {
//		assertEquals("Total de quadrantes na vertical (y) = 4", 4, tabuleiro.getTotalQuadrantesSetorVertical());
//	}
//
//	@Test
//	public void testGetQuadrantesSetorHorizontal() {
//		assertEquals("Quadrantes horizontal (x) = 3", 3, tabuleiro.getQuadrantesSetorHorizontal(0).size());
//	}
//
//	@Test
//	public void testGetQuadrantesSetorVertical() {
//		assertEquals("Quadrantes vertical (y) = 4", 4, tabuleiro.getQuadrantesSetorVertical(0).size());
//	}
//
//	@Test
//	public void testSetTitulosQuadrantesSetorHorizontalRandomico() {
//		Object[] objetos = { "Teste1", "Teste2", "Teste3", "Teste4" };
//		tabuleiro.setTitulosQuadrantesSetorHorizontalRandomico(objetos);
//		assertNotNull("Titulo das linhas dos Quadrantes Horizontais", tabuleiro.getQuadrantesSetorHorizontal(0).get(0).getTituloLinha());
//	}
//
//	@Test
//	public void testSetTitulosQuadrantesSetorVerticalRandomico() {
//		Object[] objetos = { "Teste1", "Teste2", "Teste3"};
//		tabuleiro.setTitulosQuadrantesSetorVerticalRandomico(objetos);
//		assertNotNull("Titulo das colunas dos Quadrantes Verticais", tabuleiro.getQuadrantesSetorVertical(0).get(0).getTituloColuna());
//	}
//
//	@Test
//	public void testSetTituloQuadrantesSetorHoriozontal() {
//		tabuleiro.setTituloQuadrantesSetorHorizontal(0, "Teste");
//		assertEquals("Titulo da linha dos Quadrantes Horizontais", "Teste", tabuleiro.getQuadrantesSetorHorizontal(0).get(0).getTituloLinha());
//	}
//
//	@Test
//	public void testSetTituloQuadrantesSetorVertical() {
//		tabuleiro.setTituloQuadrantesSetorVertical(0, "Teste");
//		assertEquals("Titulo da coluna dos Quadrantes Verticais", "Teste", tabuleiro.getQuadrantesSetorVertical(0).get(0).getTituloColuna());
//	}
//
//	@Test
//	public void testGetTotalConteudo() throws ConteudoExistenteException, ConteudoExcedeLimitePermitidoException, QuadranteInvalidoException {
//		tabuleiro.addConteudo(new String("teste1"), new Quadrante<String>(0, 0));
//		tabuleiro.addConteudo(new String("teste2"), new Quadrante<String>(1, 1));
//		tabuleiro.addConteudo(new String("teste3"), new Quadrante<String>(2, 2));
//
//		assertEquals("Total de conteudos no Tabuleiro, independente de onde estiver.", 3, tabuleiro.getTotalConteudos());
//	}
//
//	@Test
//	public void testFindConteudoNaoEncontrado() {
//		assertFalse(tabuleiro.findConteudo(new String("teste")));
//	}
//
//	@Test
//	public void testFindConteudoEncontrado() throws ConteudoExistenteException, ConteudoExcedeLimitePermitidoException, QuadranteInvalidoException {
//		tabuleiro.addConteudo(new String("teste"), new Quadrante<String>(0, 0));
//		assertTrue(tabuleiro.findConteudo(new String("teste")));
//	}
//
//	@Test
//	public void testAddConteudo() throws ConteudoExistenteException, ConteudoExcedeLimitePermitidoException, QuadranteInvalidoException {
//		assertTrue(tabuleiro.addConteudo(new String("teste"), new Quadrante<String>(0, 0)));
//	}
//
//	@Test(expected = ConteudoExistenteException.class)
//	public void testAddConteudoExistente() throws ConteudoExistenteException, ConteudoExcedeLimitePermitidoException, QuadranteInvalidoException {
//		tabuleiro.addConteudo(new String("teste"), new Quadrante<String>(0, 0));
//		tabuleiro.addConteudo(new String("teste"), new Quadrante<String>(0, 0));
//	}
//
//	@Test(expected = QuadranteInvalidoException.class)
//	public void testAddConteudoQuadranteInvalidoLimiteSuperior() throws ConteudoExistenteException, ConteudoExcedeLimitePermitidoException,
//			QuadranteInvalidoException {
//		tabuleiro.addConteudo(new String("teste"), new Quadrante<String>(5, 5));
//	}
//
//	@Test(expected = QuadranteInvalidoException.class)
//	public void testAddConteudoQuadranteInvalidoLimiteInferior() throws ConteudoExistenteException, ConteudoExcedeLimitePermitidoException,
//			QuadranteInvalidoException {
//		tabuleiro.addConteudo(new String("teste"), new Quadrante<String>(-1, -1));
//	}
//
//	@Test(expected = ConteudoExcedeLimitePermitidoException.class)
//	public void testAddConteudoExcedeLimitePermitido() throws ConteudoExistenteException, ConteudoExcedeLimitePermitidoException, QuadranteInvalidoException {
//		tabuleiro.addConteudo(new String("teste1"), new Quadrante<String>(0, 0));
//		tabuleiro.addConteudo(new String("teste2"), new Quadrante<String>(0, 0));
//		tabuleiro.addConteudo(new String("teste3"), new Quadrante<String>(0, 0));
//		tabuleiro.addConteudo(new String("teste4"), new Quadrante<String>(0, 0));
//		tabuleiro.addConteudo(new String("teste5"), new Quadrante<String>(0, 0));
//		tabuleiro.addConteudo(new String("teste6"), new Quadrante<String>(0, 0));
//	}
//
//	@Test
//	public void testRemoveConteudo() throws ConteudoNaoEncontradoException, ConteudoExistenteException, ConteudoExcedeLimitePermitidoException,
//			QuadranteInvalidoException {
//		tabuleiro.addConteudo(new String("teste"), new Quadrante<String>(0, 0));
//		assertTrue(tabuleiro.removeConteudo(new String("teste")));
//	}
//
//	@Test(expected = ConteudoNaoEncontradoException.class)
//	public void testRemoveConteudoNaoEncontrado() throws ConteudoNaoEncontradoException {
//		tabuleiro.removeConteudo(new String("teste"));
//	}
//
//	@Test
//	public void testGetQuadrante() throws ConteudoNaoEncontradoException, ConteudoExistenteException, ConteudoExcedeLimitePermitidoException,
//			QuadranteInvalidoException {
//		tabuleiro.addConteudo(new String("teste"), new Quadrante<String>(0, 0));
//		assertNotNull(tabuleiro.getQuadrante(new String("teste")));
//	}
//
//	@Test(expected = ConteudoNaoEncontradoException.class)
//	public void testGetConteudoNaoEncontrado() throws ConteudoNaoEncontradoException {
//		tabuleiro.getQuadrante(new String("teste"));
//	}
//
//	@Test
//	public void testTabuleiro() {
//		assertNotNull(tabuleiro.toString());
//		// System.out.println(tabuleiro);
//	}

}
