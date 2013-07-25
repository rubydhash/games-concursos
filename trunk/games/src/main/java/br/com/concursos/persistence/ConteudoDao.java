package br.com.concursos.persistence;

import java.util.List;

import br.com.concursos.domain.Conteudo;
import br.com.concursos.exception.ConteudoNaoEncontradoException;

public interface ConteudoDao {

	public List<Conteudo> getConteudos();
	
	public Conteudo findBy(int codigo) throws ConteudoNaoEncontradoException;
}
