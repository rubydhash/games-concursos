package br.com.concursos.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.com.concursos.enumeration.TipoSetor;
import br.com.concursos.exception.ConteudoExcedeLimitePermitidoException;
import br.com.concursos.exception.ConteudoExistenteException;
import br.com.concursos.exception.ConteudoNaoEncontradoException;
import br.com.concursos.exception.QuadranteInvalidoException;
import br.com.concursos.exception.TabuleiroTamanhoInvalidoException;
import br.com.concursos.exception.TitulosExcedemLimiteSetoresException;

public class TabuleiroTest {

	private Tabuleiro tabuleiro;
	private Quadrante quadrante;
	private List<Conteudo> conteudos;
	private List<Object> titulos;

	@Before
	public void init() throws TabuleiroTamanhoInvalidoException {
		tabuleiro = new Tabuleiro(4, 3);
		quadrante = new Quadrante(0, 0);
		
		conteudos = new ArrayList<Conteudo>();
		conteudos.add(new Conteudo(0));
		conteudos.add(new Conteudo(1));
		conteudos.add(new Conteudo(2));
		conteudos.add(new Conteudo(3));
		
		titulos = new ArrayList<Object>();
		titulos.add("Teste 0");
		titulos.add("Teste 1");
		titulos.add("Teste 2");
		titulos.add("Teste 3");
	}

	@Test
	public void testCriacaoTabuleiro() {
		assertEquals("Total de quadrantes = x * y", 12, tabuleiro.getTotalQuadrantes());
	}

	@Test(expected = TabuleiroTamanhoInvalidoException.class)
	public void testCriacaoTabuleiroTamanhoInvalido() throws TabuleiroTamanhoInvalidoException {
		tabuleiro = new Tabuleiro(-1, -1);
	}

	@Test(expected = TabuleiroTamanhoInvalidoException.class)
	public void testCriacaoTabuleiroTamanhoInvalidoLimiteZero() throws TabuleiroTamanhoInvalidoException {
		tabuleiro = new Tabuleiro(0, 4);
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
		Setor setorHorizontal = new Setor(0, TipoSetor.HORIZONTAL);
		assertEquals("Quadrantes Horizontais (x) = 3", 3, tabuleiro.getQuadrantes(setorHorizontal).size());
	}

	@Test
	public void testGetQuadrantesSetorVertical() {
		Setor setorVertical = new Setor(0, TipoSetor.VERTICAL);
		assertEquals("Quadrantes Verticais (y) = 4", 4, tabuleiro.getQuadrantes(setorVertical).size());
	}

	@Test
	public void testSetTitulosQuadrantesSetorHorizontal() throws TitulosExcedemLimiteSetoresException {
		tabuleiro.setTitulos(titulos, TipoSetor.HORIZONTAL, false);
		assertNotNull("Título das linhas do Tabuleiro (Quadrantes Horizontais)", tabuleiro.getSetor(new Setor(0, TipoSetor.HORIZONTAL)).getTitulo());
	}

	@Test
	public void testSetTitulosQuadrantesSetorVertical() throws TitulosExcedemLimiteSetoresException {
		titulos.remove(0);
		tabuleiro.setTitulos(titulos, TipoSetor.VERTICAL, false);
		assertNotNull("Título das colunas do Tabuleiro (Quadrantes Verticais)", tabuleiro.getSetor(new Setor(0, TipoSetor.VERTICAL)).getTitulo());
	}

	@Test
	public void testSetTitulosQuadrantesSetorHorizontalRandomico() throws TitulosExcedemLimiteSetoresException {
		tabuleiro.setTitulos(titulos, TipoSetor.HORIZONTAL, true);
		assertNotNull("Título das linhas do Tabuleiro randomicamente (Quadrantes Horizontais)", tabuleiro.getSetor(new Setor(0, TipoSetor.HORIZONTAL)).getTitulo());
	}

	@Test
	public void testSetTitulosQuadrantesSetorVerticalRandomico() throws TitulosExcedemLimiteSetoresException {
		titulos.remove(0);
		tabuleiro.setTitulos(titulos, TipoSetor.VERTICAL, true);
		assertNotNull("Título das linhas do Tabuleiro randomicamente (Quadrantes Verticais)", tabuleiro.getSetor(new Setor(0, TipoSetor.VERTICAL)).getTitulo());
	}
	
	@Test
	public void testSetTituloQuadranteSetorHorizontal()   {
		tabuleiro.setTitulo(conteudos.get(0), new Setor(0, TipoSetor.HORIZONTAL));
		assertNotNull("Título das linhas do Tabuleiro (Quadrantes Horizontais)", tabuleiro.getSetor(new Setor(0, TipoSetor.HORIZONTAL)).getTitulo());
	}
	
	@Test
	public void testSetTituloQuadranteSetorVertical()   {
		tabuleiro.setTitulo(conteudos.get(0), new Setor(0, TipoSetor.VERTICAL));
		assertNotNull("Título das linhas do Tabuleiro (Quadrantes Horizontais)", tabuleiro.getSetor(new Setor(0, TipoSetor.VERTICAL)).getTitulo());
	}

	@Test
	public void testGetTotalConteudo() throws ConteudoExistenteException, QuadranteInvalidoException, ConteudoExcedeLimitePermitidoException {
		tabuleiro.add(conteudos.get(0), new Quadrante(0, 0));
		tabuleiro.add(conteudos.get(1), new Quadrante(1, 1));
		tabuleiro.add(conteudos.get(2), new Quadrante(2, 2));

		assertEquals("Total de conteudos no Tabuleiro, independente de onde estiver.", 3, tabuleiro.getTotalConteudo());
	}
	
	@Test(expected = ConteudoExcedeLimitePermitidoException.class)
	public void testAddProcessoSelecionadoAcimaDoLimitePermitidoNoMesmoQuadrante() throws ConteudoExistenteException,
			QuadranteInvalidoException, ConteudoExcedeLimitePermitidoException {
		tabuleiro.add(new Conteudo(0), quadrante);
		tabuleiro.add(new Conteudo(1), quadrante);
		tabuleiro.add(new Conteudo(2), quadrante);
		tabuleiro.add(new Conteudo(3), quadrante);
		tabuleiro.add(new Conteudo(4), quadrante);
		tabuleiro.add(new Conteudo(5), quadrante);
	}

	@Test
	public void testConteudoNaoEncontrado() {
		assertFalse(tabuleiro.contains(conteudos.get(0)));
	}

	@Test
	public void testConteudoEncontrado() throws ConteudoExistenteException, QuadranteInvalidoException, ConteudoExcedeLimitePermitidoException {
		tabuleiro.add(conteudos.get(0), new Quadrante(0, 0));
		assertTrue(tabuleiro.contains(new Conteudo(0)));
	}

	@Test
	public void testAddConteudo() throws ConteudoExistenteException, QuadranteInvalidoException, ConteudoExcedeLimitePermitidoException {
		assertTrue(tabuleiro.add(conteudos.get(0), new Quadrante(0, 0)));
	}

	@Test(expected = ConteudoExistenteException.class)
	public void testAddConteudoExistente() throws ConteudoExistenteException, QuadranteInvalidoException, ConteudoExcedeLimitePermitidoException {
		tabuleiro.add(conteudos.get(0), new Quadrante(0, 0));
		tabuleiro.add(conteudos.get(0), new Quadrante(0, 0));
	}

	@Test(expected = QuadranteInvalidoException.class)
	public void testAddConteudoQuadranteInvalidoLimiteSuperior() throws ConteudoExistenteException, QuadranteInvalidoException, ConteudoExcedeLimitePermitidoException {
		tabuleiro.add(conteudos.get(0), new Quadrante(5, 5));
	}

	@Test(expected = QuadranteInvalidoException.class)
	public void testAddConteudoQuadranteInvalidoLimiteInferior() throws ConteudoExistenteException, QuadranteInvalidoException, ConteudoExcedeLimitePermitidoException {
		tabuleiro.add(conteudos.get(0), new Quadrante(-1, -1));
	}

	@Test
	public void testRemoveConteudo() throws ConteudoNaoEncontradoException, ConteudoExistenteException, QuadranteInvalidoException, ConteudoExcedeLimitePermitidoException {
		tabuleiro.add(conteudos.get(0), new Quadrante(0, 0));
		assertTrue(tabuleiro.remove(conteudos.get(0)));
	}

	@Test(expected = ConteudoNaoEncontradoException.class)
	public void testRemoveConteudoNaoEncontrado() throws ConteudoNaoEncontradoException {
		tabuleiro.remove(conteudos.get(0));
	}

	@Test
	public void testGetQuadrante() throws ConteudoNaoEncontradoException, ConteudoExistenteException, QuadranteInvalidoException,
			ConteudoExcedeLimitePermitidoException {
		tabuleiro.add(conteudos.get(0), new Quadrante(0, 0));
		assertNotNull(tabuleiro.getQuadrante(conteudos.get(0)));
	}

	@Test(expected = ConteudoNaoEncontradoException.class)
	public void testGetConteudoNaoEncontrado() throws ConteudoNaoEncontradoException {
		tabuleiro.getQuadrante(conteudos.get(0));
	}

	@Test
	public void testTabuleiro() {
		assertNotNull(tabuleiro.toString());
		// System.out.println(tabuleiro);
	}
	
	@Test
	public void testVerificaTabuleiroComSucesso() throws ConteudoExistenteException, QuadranteInvalidoException, ConteudoExcedeLimitePermitidoException {
		conteudos.get(0).setTituloHorizontal("Teste");
		tabuleiro.setTitulo("Teste", new Setor(0, TipoSetor.HORIZONTAL));
		tabuleiro.add(conteudos.get(0), new Quadrante(0, 0));
		assertTrue("Conteúdo se encontra em posição correta. Mesma posição do título do setor.", tabuleiro.verificaConteudo(TipoSetor.HORIZONTAL));
	}
	
	@Test
	public void testVerificaTabuleiroComErro() throws ConteudoExistenteException, QuadranteInvalidoException, ConteudoExcedeLimitePermitidoException {
		conteudos.get(0).setTituloHorizontal("Teste");
		tabuleiro.setTitulo("Teste1", new Setor(0, TipoSetor.HORIZONTAL));
		tabuleiro.add(conteudos.get(0), new Quadrante(0, 0));
		assertFalse("Conteúdo não se encontra na posição correta.", tabuleiro.verificaConteudo(TipoSetor.HORIZONTAL));
	}

}
