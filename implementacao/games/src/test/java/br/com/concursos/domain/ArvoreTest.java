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

import br.com.concursos.exception.ArgumentoInvalidoException;
import br.com.concursos.exception.ElementoExistenteException;
import br.com.concursos.exception.ElementoNaoEncontradoException;
import br.com.concursos.exception.ImpossivelRemoverNoRaizException;
import br.com.concursos.exception.LocalizacaoInsercaoNaoEncontradoException;
import br.com.concursos.exception.LocalizacaoInsercaoElementoNaoPreenchidaException;

public class ArvoreTest {

	private Arvore<String> arvore;
	private List<String> elementos;

	@Before
	public void init() {
		arvore = new Arvore<String>();

		elementos = new ArrayList<String>();
		elementos.add(new String("s1"));
		elementos.add(new String("s2"));
		elementos.add(new String("s3"));
		elementos.add(new String("s4"));
	}

	@Test
	public void testConstructArvore() {
		arvore = new Arvore<String>(4);
		assertEquals("Altura padrão da árvore criada deve ser igual a 4", 4, arvore.getAltura().intValue());
	}

	@Test
	public void testAddElemento() throws ArgumentoInvalidoException, ElementoExistenteException {
		assertTrue(arvore.add(elementos.get(0), new No<String>(0l)));
	}

	@Test
	public void testAddElementoSetandoNoInsercao() throws Exception {
		arvore.setNoInsercao(new No<String>(0l));
		assertTrue(arvore.add(elementos.get(0)));
	}

	@Test(expected = LocalizacaoInsercaoElementoNaoPreenchidaException.class)
	public void testAddElementoSemNoInsercao() throws Exception {
		assertTrue(arvore.add(elementos.get(0)));
	}

	@Test
	public void testRemoveElemento() throws ElementoNaoEncontradoException, ArgumentoInvalidoException, ElementoExistenteException {
		arvore.add(elementos.get(0), new No<String>(1l));
		assertTrue(arvore.contains(elementos.get(0)));

		arvore.remove(elementos.get(0));
		assertTrue(arvore.isEmpty());
	}

	@Test(expected = ElementoNaoEncontradoException.class)
	public void testRemoveElementoNaoEncontrado() throws ElementoNaoEncontradoException {
		arvore.remove(elementos.get(0));
	}

	@Test
	public void testContemNoEncontrado() {
		assertTrue(arvore.contains(new No<String>(0l)));
	}

	@Test
	public void testContemNoNaoEncontrado() {
		assertFalse(arvore.contains(new No<String>(100l)));
	}

	@Test
	public void testContemElementoNaoEncontrado() {
		assertFalse(arvore.contains(elementos.get(0)));
	}

	@Test
	public void testContemElementoEncontrado() throws Exception {
		arvore.add(elementos.get(0), new No<String>(0l));
		assertTrue(arvore.contains(elementos.get(0)));
	}

	@Test
	public void testSizeNos() {
		arvore = new Arvore<String>(4);
		assertEquals(new Integer(31), arvore.sizeNos());
	}

	@Test
	public void testArvoreVazia() {
		assertTrue(arvore.isEmpty());
	}

	@Test
	public void testIsNotEmpty() throws ArgumentoInvalidoException, ElementoExistenteException {
		arvore.add(elementos.get(0), new No<String>(0l));
		assertFalse(arvore.isEmpty());
	}

	@Test
	public void testClear() throws ArgumentoInvalidoException, ElementoExistenteException {
		arvore.add(elementos.get(0), new No<String>(0l));
		arvore.add(elementos.get(1), new No<String>(1l));

		arvore.clear();

		assertTrue(arvore.isEmpty());
	}

	@Test
	public void testClearArvore() throws ArgumentoInvalidoException, ElementoExistenteException {
		arvore.clearArvore();
		assertNull(arvore.getRaiz());
	}

	@Test
	public void testRaiz() {
		assertNotNull(arvore.getRaiz());
	}

	@Test
	public void testArvore() {
		arvore = new Arvore<String>(4);
		assertNotNull(arvore.toString());
		// System.out.println(arvore);
	}

	@Test
	public void testAddNo() throws LocalizacaoInsercaoNaoEncontradoException {
		assertTrue(arvore.addNo(new No<String>(0l)));
	}
	
	@Test(expected=LocalizacaoInsercaoNaoEncontradoException.class)
	public void testAddNoInvalido() throws LocalizacaoInsercaoNaoEncontradoException {
		assertTrue(arvore.addNo(null));
	}
	
	@Test(expected=LocalizacaoInsercaoNaoEncontradoException.class)
	public void testAddNoNaoEncontrado() throws LocalizacaoInsercaoNaoEncontradoException {
		assertTrue(arvore.addNo(new No<String>(50l)));
	}

	@Test
	public void testRemoveNo() throws ImpossivelRemoverNoRaizException {
		assertTrue(arvore.removeNo(new No<String>(2l)));
	}
	
	@Test
	public void testRemoveNoNaoExistenteArvore() throws ImpossivelRemoverNoRaizException {
		assertFalse(arvore.removeNo(new No<String>(3l)));
	}
	
	@Test(expected=ImpossivelRemoverNoRaizException.class)
	public void testRemoveNoRaiz() throws ImpossivelRemoverNoRaizException {
		assertFalse(arvore.removeNo(new No<String>(0l)));
	}
	
	@Test
	public void testRemoveNos() throws ImpossivelRemoverNoRaizException {
		arvore = new Arvore<String>(4);
		assertTrue(arvore.removeNo(new No<String>(2l)));
		assertTrue(arvore.removeNo(new No<String>(4l)));
		assertTrue(arvore.removeNo(new No<String>(15l)));
	}

}
