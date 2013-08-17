package br.com.concursos.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.com.concursos.enumeration.TipoSetor;
import br.com.concursos.exception.ElementoExistenteException;
import br.com.concursos.exception.ElementoNaoEncontradoException;
import br.com.concursos.exception.LocalizacaoNaoPreenchidaException;
import br.com.concursos.exception.QuadranteInvalidoException;
import br.com.concursos.exception.TabuleiroTamanhoInvalidoException;

public class TabuleiroTest {

	private Tabuleiro<String> tabuleiro;
	private List<String> elementos;

	@Before
	public void init() throws TabuleiroTamanhoInvalidoException {
		tabuleiro = new Tabuleiro<String>(new TamanhoTabuleiro(4, 3));

		elementos = new ArrayList<String>();
		elementos.add(new String("s1"));
		elementos.add(new String("s2"));
		elementos.add(new String("s3"));
		elementos.add(new String("s4"));
	}

	@Test
	public void testCriacaoTabuleiro() throws TabuleiroTamanhoInvalidoException {
		Tabuleiro<String> tabuleiroCriado = new Tabuleiro<String>(new TamanhoTabuleiro(4, 3));
		assertEquals("Total de setores horizontais = 4", 4, tabuleiroCriado.getSetoresHorizontais().size());
		assertEquals("Total de setores verticais = 3", 3, tabuleiroCriado.getSetoresVerticais().size());
	}

	@Test(expected = TabuleiroTamanhoInvalidoException.class)
	public void testCriacaoTabuleiroTamanhoInvalido() throws TabuleiroTamanhoInvalidoException {
		new Tabuleiro<String>(new TamanhoTabuleiro(-1, -1));
	}

	@Test(expected = TabuleiroTamanhoInvalidoException.class)
	public void testCriacaoTabuleiroTamanhoInvalidoLimiteZero() throws TabuleiroTamanhoInvalidoException {
		new Tabuleiro<String>(new TamanhoTabuleiro(0, 4));
	}

	@Test
	public void testSize() throws ElementoExistenteException, QuadranteInvalidoException {
		tabuleiro.add(elementos.get(0), new Setor<String>(1, TipoSetor.HORIZONTAL), new Setor<String>(1, TipoSetor.VERTICAL));
		tabuleiro.add(elementos.get(1), new Setor<String>(1, TipoSetor.HORIZONTAL), new Setor<String>(1, TipoSetor.VERTICAL));
		tabuleiro.add(elementos.get(2), new Setor<String>(3, TipoSetor.HORIZONTAL), new Setor<String>(2, TipoSetor.VERTICAL));

		assertEquals("Total de elementos no tabuleiro, independente de onde estiver.", 3, tabuleiro.size().intValue());
	}

	@Test
	public void testElementoNaoEncontrado() {
		assertFalse(tabuleiro.contains(elementos.get(0)));
	}

	@Test
	public void testElementoEncontrado() throws ElementoExistenteException, QuadranteInvalidoException {
		tabuleiro.add(elementos.get(0), new Setor<String>(1, TipoSetor.HORIZONTAL), new Setor<String>(1, TipoSetor.VERTICAL));
		assertTrue(tabuleiro.contains(elementos.get(0)));
	}

	@Test
	public void testAddElemento() throws QuadranteInvalidoException, ElementoExistenteException {
		assertTrue(tabuleiro.add(elementos.get(0), new Setor<String>(1, TipoSetor.HORIZONTAL), new Setor<String>(1, TipoSetor.VERTICAL)));
	}

	@Test(expected = ElementoExistenteException.class)
	public void testAddElementoExistente() throws QuadranteInvalidoException, ElementoExistenteException {
		tabuleiro.add(elementos.get(0), new Setor<String>(1, TipoSetor.HORIZONTAL), new Setor<String>(1, TipoSetor.VERTICAL));
		tabuleiro.add(elementos.get(0), new Setor<String>(1, TipoSetor.HORIZONTAL), new Setor<String>(1, TipoSetor.VERTICAL));
	}

	@Test(expected = QuadranteInvalidoException.class)
	public void testAddElementoQuadranteInvalidoLimiteSuperiorHorizontal() throws ElementoExistenteException, QuadranteInvalidoException {
		tabuleiro.add(elementos.get(0), new Setor<String>(4, TipoSetor.HORIZONTAL), new Setor<String>(1, TipoSetor.VERTICAL));
	}

	@Test(expected = QuadranteInvalidoException.class)
	public void testAddElementoQuadranteInvalidoLimiteSuperiorVertical() throws ElementoExistenteException, QuadranteInvalidoException {
		tabuleiro.add(elementos.get(0), new Setor<String>(1, TipoSetor.HORIZONTAL), new Setor<String>(3, TipoSetor.VERTICAL));
	}

	@Test(expected = QuadranteInvalidoException.class)
	public void testAddElementoQuadranteInvalidoLimiteInferior() throws ElementoExistenteException, QuadranteInvalidoException {
		tabuleiro.add(elementos.get(0), new Setor<String>(-1, TipoSetor.HORIZONTAL), new Setor<String>(-1, TipoSetor.VERTICAL));
	}

	@Test(expected = LocalizacaoNaoPreenchidaException.class)
	public void testAddElementoSemSetor() throws Exception {
		tabuleiro.add(elementos.get(0));
	}

	@Test
	public void testAddElementoSetandoSetor() throws Exception {
		tabuleiro.setSetorHorizontal(new Setor<String>(1, TipoSetor.HORIZONTAL));
		tabuleiro.setSetorVertical(new Setor<String>(1, TipoSetor.VERTICAL));
		assertTrue(tabuleiro.add(elementos.get(0)));
		assertNull(tabuleiro.getSetorHorizontal());
		assertNull(tabuleiro.getSetorVertical());
	}

	@Test
	public void testRemoveElemento() throws QuadranteInvalidoException, ElementoExistenteException, ElementoNaoEncontradoException {
		tabuleiro.add(elementos.get(0), new Setor<String>(1, TipoSetor.HORIZONTAL), new Setor<String>(1, TipoSetor.VERTICAL));
		tabuleiro.remove(elementos.get(0));
	}

	@Test(expected = ElementoNaoEncontradoException.class)
	public void testRemoveElementoNaoEncontrado() throws ElementoNaoEncontradoException, QuadranteInvalidoException, ElementoExistenteException {
		tabuleiro.remove(elementos.get(0));
	}

	@Test
	public void testTabuleiro() throws TabuleiroTamanhoInvalidoException {
		assertNotNull(tabuleiro.toString());
		// System.out.println(tabuleiro);
	}

	@Test
	public void testIgualdadeTabuleiroElementosLugarIdentico() throws QuadranteInvalidoException, ElementoExistenteException, TabuleiroTamanhoInvalidoException {
		tabuleiro.add(elementos.get(0), new Setor<String>(0, TipoSetor.HORIZONTAL), new Setor<String>(1, TipoSetor.VERTICAL));
		tabuleiro.add(elementos.get(1), new Setor<String>(1, TipoSetor.HORIZONTAL), new Setor<String>(2, TipoSetor.VERTICAL));
		tabuleiro.add(elementos.get(2), new Setor<String>(0, TipoSetor.HORIZONTAL), new Setor<String>(1, TipoSetor.VERTICAL));
		tabuleiro.add(elementos.get(3), new Setor<String>(1, TipoSetor.HORIZONTAL), new Setor<String>(2, TipoSetor.VERTICAL));

		Tabuleiro<String> modeloOficial = new Tabuleiro<String>(new TamanhoTabuleiro(4, 3));
		modeloOficial.add(elementos.get(0), new Setor<String>(0, TipoSetor.HORIZONTAL), new Setor<String>(1, TipoSetor.VERTICAL));
		modeloOficial.add(elementos.get(1), new Setor<String>(1, TipoSetor.HORIZONTAL), new Setor<String>(2, TipoSetor.VERTICAL));
		modeloOficial.add(elementos.get(2), new Setor<String>(0, TipoSetor.HORIZONTAL), new Setor<String>(1, TipoSetor.VERTICAL));
		modeloOficial.add(elementos.get(3), new Setor<String>(1, TipoSetor.HORIZONTAL), new Setor<String>(2, TipoSetor.VERTICAL));

		assertTrue("Elementos iguais de outro tabuleiro.", tabuleiro.equals(modeloOficial));
	}

	@Test
	public void testIgualdadeTabuleiroElementosLugarDiferente() throws QuadranteInvalidoException, ElementoExistenteException,
			TabuleiroTamanhoInvalidoException {
		tabuleiro.add(elementos.get(0), new Setor<String>(0, TipoSetor.HORIZONTAL), new Setor<String>(1, TipoSetor.VERTICAL));
		tabuleiro.add(elementos.get(1), new Setor<String>(1, TipoSetor.HORIZONTAL), new Setor<String>(2, TipoSetor.VERTICAL));
		tabuleiro.add(elementos.get(2), new Setor<String>(0, TipoSetor.HORIZONTAL), new Setor<String>(1, TipoSetor.VERTICAL));
		tabuleiro.add(elementos.get(3), new Setor<String>(1, TipoSetor.HORIZONTAL), new Setor<String>(2, TipoSetor.VERTICAL));

		Tabuleiro<String> modeloOficial = new Tabuleiro<String>(new TamanhoTabuleiro(4, 3));
		modeloOficial.add(elementos.get(0), new Setor<String>(0, TipoSetor.HORIZONTAL), new Setor<String>(1, TipoSetor.VERTICAL));
		modeloOficial.add(elementos.get(1), new Setor<String>(1, TipoSetor.HORIZONTAL), new Setor<String>(2, TipoSetor.VERTICAL));
		modeloOficial.add(elementos.get(3), new Setor<String>(0, TipoSetor.HORIZONTAL), new Setor<String>(1, TipoSetor.VERTICAL));
		modeloOficial.add(elementos.get(2), new Setor<String>(1, TipoSetor.HORIZONTAL), new Setor<String>(2, TipoSetor.VERTICAL));

		assertFalse("Elementos diferentes de outro tabuleiro.", tabuleiro.equals(modeloOficial));
	}

	@Test
	public void testTabuleiroVazio() {
		assertTrue(tabuleiro.isEmpty());
	}

	@Test
	public void testLimpaTabuleiro() throws QuadranteInvalidoException, ElementoExistenteException {
		tabuleiro.add(elementos.get(0), new Setor<String>(0, TipoSetor.HORIZONTAL), new Setor<String>(1, TipoSetor.VERTICAL));
		tabuleiro.add(elementos.get(1), new Setor<String>(1, TipoSetor.HORIZONTAL), new Setor<String>(2, TipoSetor.VERTICAL));
		tabuleiro.add(elementos.get(2), new Setor<String>(0, TipoSetor.HORIZONTAL), new Setor<String>(1, TipoSetor.VERTICAL));
		tabuleiro.add(elementos.get(3), new Setor<String>(1, TipoSetor.HORIZONTAL), new Setor<String>(2, TipoSetor.VERTICAL));

		tabuleiro.clear();

		assertTrue(tabuleiro.isEmpty());
	}

}
