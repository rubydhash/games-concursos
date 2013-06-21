package br.com.concursos.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import br.com.concursos.enumeration.TipoSetor;
import br.com.concursos.exception.ConteudoExistenteException;
import br.com.concursos.exception.ConteudoNaoEncontradoException;
import br.com.concursos.exception.QuadranteInvalidoException;
import br.com.concursos.exception.TabuleiroTamanhoInvalidoException;
import br.com.concursos.exception.TitulosExcedemLimiteSetoresException;

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
	public void testGetTotalQuadrantesSetorHorizontal() {
		assertEquals("Total de Quadrantes na Horizontais (x) = 3", 3, tabuleiro.getTotalQuadrantes(TipoSetor.HORIZONTAL));
	}

	@Test
	public void testGetTotalQuadrantesSetorVertical() {
		assertEquals("Total de Quadrantes na Verticais (y) = 4", 4, tabuleiro.getTotalQuadrantes(TipoSetor.VERTICAL));
	}

	@Test
	public void testGetQuadrantesSetorHorizontal() {
		Setor<String> setorHorizontal = new Setor<String>(0, TipoSetor.HORIZONTAL);
		assertEquals("Quadrantes Horizontais (x) = 3", 3, tabuleiro.getQuadrantes(setorHorizontal).size());
	}

	@Test
	public void testGetQuadrantesSetorVertical() {
		Setor<String> setorVertical = new Setor<String>(0, TipoSetor.VERTICAL);
		assertEquals("Quadrantes Verticais (y) = 4", 4, tabuleiro.getQuadrantes(setorVertical).size());
	}

	@Test
	public void testSetTitulosQuadrantesSetorHorizontal() throws TitulosExcedemLimiteSetoresException {
		Object[] objetos = { "Teste1", "Teste2", "Teste3", "Teste4" };
		tabuleiro.setTitulos(objetos, TipoSetor.HORIZONTAL, false);
		assertNotNull("Título das linhas do Tabuleiro (Quadrantes Horizontais)", tabuleiro.getSetoresHorizontais().get(0).getTitulo());
	}

	@Test
	public void testSetTitulosQuadrantesSetorVertical() throws TitulosExcedemLimiteSetoresException {
		Object[] objetos = { "Teste1", "Teste2", "Teste3" };
		tabuleiro.setTitulos(objetos, TipoSetor.VERTICAL, false);
		assertNotNull("Título das colunas do Tabuleiro (Quadrantes Verticais)", tabuleiro.getSetoresVerticais().get(0).getTitulo());
	}

	@Test
	public void testSetTitulosQuadrantesSetorHorizontalRandomico() throws TitulosExcedemLimiteSetoresException {
		Object[] objetos = { "Teste1", "Teste2", "Teste3", "Teste4" };
		tabuleiro.setTitulos(objetos, TipoSetor.HORIZONTAL, true);
		assertNotNull("Título das linhas do Tabuleiro randomicamente (Quadrantes Horizontais)", tabuleiro.getSetoresHorizontais().get(0).getTitulo());
	}

	@Test
	public void testSetTitulosQuadrantesSetorVerticalRandomico() throws TitulosExcedemLimiteSetoresException {
		Object[] objetos = { "Teste1", "Teste2", "Teste3" };
		tabuleiro.setTitulos(objetos, TipoSetor.VERTICAL, true);
		assertNotNull("Título das linhas do Tabuleiro randomicamente (Quadrantes Verticais)", tabuleiro.getSetoresVerticais().get(0).getTitulo());
	}

	@Test
	public void testGetTotalConteudo() throws ConteudoExistenteException, QuadranteInvalidoException {
		tabuleiro.add(new String("teste1"), new Quadrante<String>(0, 0));
		tabuleiro.add(new String("teste2"), new Quadrante<String>(1, 1));
		tabuleiro.add(new String("teste3"), new Quadrante<String>(2, 2));

		assertEquals("Total de conteudos no Tabuleiro, independente de onde estiver.", 3, tabuleiro.getTotalConteudo());
	}

	@Test
	public void testConteudoNaoEncontrado() {
		assertFalse(tabuleiro.contains(new String("teste")));
	}

	@Test
	public void testConteudoEncontrado() throws ConteudoExistenteException, QuadranteInvalidoException {
		tabuleiro.add(new String("teste"), new Quadrante<String>(0, 0));
		assertTrue(tabuleiro.contains(new String("teste")));
	}

	@Test
	public void testAddConteudo() throws ConteudoExistenteException, QuadranteInvalidoException {
		assertTrue(tabuleiro.add(new String("teste"), new Quadrante<String>(0, 0)));
	}

	@Test(expected = ConteudoExistenteException.class)
	public void testAddConteudoExistente() throws ConteudoExistenteException, QuadranteInvalidoException {
		tabuleiro.add(new String("teste"), new Quadrante<String>(0, 0));
		tabuleiro.add(new String("teste"), new Quadrante<String>(0, 0));
	}

	@Test(expected = QuadranteInvalidoException.class)
	public void testAddConteudoQuadranteInvalidoLimiteSuperior() throws ConteudoExistenteException, QuadranteInvalidoException {
		tabuleiro.add(new String("teste"), new Quadrante<String>(5, 5));
	}

	@Test(expected = QuadranteInvalidoException.class)
	public void testAddConteudoQuadranteInvalidoLimiteInferior() throws ConteudoExistenteException, QuadranteInvalidoException {
		tabuleiro.add(new String("teste"), new Quadrante<String>(-1, -1));
	}

	@Test
	public void testRemoveConteudo() throws ConteudoNaoEncontradoException, ConteudoExistenteException, QuadranteInvalidoException {
		tabuleiro.add(new String("teste"), new Quadrante<String>(0, 0));
		assertTrue(tabuleiro.remove(new String("teste")));
	}

	@Test(expected = ConteudoNaoEncontradoException.class)
	public void testRemoveConteudoNaoEncontrado() throws ConteudoNaoEncontradoException {
		tabuleiro.remove(new String("teste"));
	}

	@Test
	public void testGetQuadrante() throws ConteudoNaoEncontradoException, ConteudoExistenteException, QuadranteInvalidoException {
		tabuleiro.add(new String("teste"), new Quadrante<String>(0, 0));
		assertNotNull(tabuleiro.getQuadrante(new String("teste")));
	}

	@Test(expected = ConteudoNaoEncontradoException.class)
	public void testGetConteudoNaoEncontrado() throws ConteudoNaoEncontradoException {
		tabuleiro.getQuadrante(new String("teste"));
	}

	@Test
	public void testTabuleiro() {
		assertNotNull(tabuleiro.toString());
		// System.out.println(tabuleiro);
	}

}
