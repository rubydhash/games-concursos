package br.com.concursos.persistence;

import static org.junit.Assert.*;

import javax.xml.bind.JAXBException;

import org.junit.Test;

public class ConteudoDaoXmlTest {

	@Test
	public void testCarregamento() throws JAXBException {
		assertNotNull(ConteudoDaoXml.getInstance().getConteudos());
	}

}
