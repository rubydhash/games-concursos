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

import br.com.concursos.domain.Conteudo;
import br.com.concursos.enumeration.ArquivoXml;
import br.com.concursos.exception.ConteudoNaoEncontradoException;

@XmlRootElement(name = "conteudosRoot")
@XmlAccessorType(XmlAccessType.FIELD)
public class ConteudoDaoXml implements ConteudoDao {

	@XmlElement(name = "conteudo")
	@XmlElementWrapper(name = "conteudos")
	private List<Conteudo> conteudos;

	private ArquivoXml arquivoXml;

	@SuppressWarnings("unused")
	private ConteudoDaoXml() {

	}

	public ConteudoDaoXml(ArquivoXml arquivoXml) throws JAXBException {
		this.arquivoXml = arquivoXml;
		carregaXml();
	}

	/**
	 * Carrega um determinado arquivo XML
	 * 
	 */
	private void carregaXml() throws JAXBException {
		JAXBContext context = JAXBContext.newInstance(ConteudoDaoXml.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		ConteudoDaoXml conteudoDaoXml = (ConteudoDaoXml) unmarshaller.unmarshal(new File("src/main/resources/arquivos/" + getArquivoXml().getDescricao()));
		this.conteudos = conteudoDaoXml.getConteudos();
	}

	/**
	 * @return conteudos
	 */
	public List<Conteudo> getConteudos() {
		return conteudos;
	}

	@Override
	public Conteudo findBy(int codigo) throws ConteudoNaoEncontradoException {
		Conteudo conteudoFinded = new Conteudo();
		for (Conteudo conteudo : conteudos) {
			if (conteudo.equals(conteudoFinded)) {
				return conteudo;
			}

		}

		throw new ConteudoNaoEncontradoException();
	}

	/**
	 * @return the arquivoXml
	 */
	public ArquivoXml getArquivoXml() {
		return arquivoXml;
	}

}
