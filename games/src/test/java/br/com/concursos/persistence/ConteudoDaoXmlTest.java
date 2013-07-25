package br.com.concursos.persistence;

import static org.junit.Assert.*;

import javax.xml.bind.JAXBException;

import org.junit.Test;

import br.com.concursos.enumeration.ArquivoXml;

public class ConteudoDaoXmlTest {

	@Test
	public void testCarregamento() throws JAXBException {
		ConteudoDao conteudoDao = new ConteudoDaoXml(ArquivoXml.CMMI_v1_2);
		assertNotNull(conteudoDao.getConteudos());
	}

}
