package br.com.concursos.persistence;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.log4j.Logger;

import br.com.concursos.domain.Conteudo;

@XmlRootElement(name = "conteudosRoot", namespace = "http://www.gamesconcursos.com.br/conteudos")
@XmlAccessorType(XmlAccessType.FIELD)
public class ConteudoDaoXml implements ConteudoDao {

	private static Logger log = Logger.getLogger(ConteudoDaoXml.class);

	@XmlElement(name = "conteudo", namespace = "http://www.gamesconcursos.com.br/conteudos")
	@XmlElementWrapper(name = "conteudos", namespace = "http://www.gamesconcursos.com.br/conteudos")
	private List<Conteudo> conteudos;

	private static ConteudoDaoXml conteudoDao;

	private ConteudoDaoXml() {
	}

	/**
	 * Acesso único ao objeto!
	 * 
	 * @throws JAXBException
	 */
	public static ConteudoDaoXml getInstance() throws JAXBException {
		if (conteudoDao == null) {
			carregaXML();
		}

		return conteudoDao;
	}

	/**
	 * Carrega arquivo XML do CMMI v1.2
	 * 
	 * @throws JAXBException
	 */
	public static void carregaXML() throws JAXBException {
		JAXBContext context;
		log.debug("Carregando arquivo XML do jogo CMMI v1.2");

		context = JAXBContext.newInstance(ConteudoDaoXml.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		conteudoDao = (ConteudoDaoXml) unmarshaller.unmarshal(new File("src/main/resources/arquivos/cmmi-v1.2.xml"));

		log.debug("Arquivo XML de metadados do jogo CMMI v1.2 - carregado com sucesso!");
	}

	/**
	 * @return the conteudosCmmi
	 */
	public List<Conteudo> getConteudos() {
		return conteudos;
	}
}
