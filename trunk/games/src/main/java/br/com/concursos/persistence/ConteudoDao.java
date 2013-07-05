package br.com.concursos.persistence;

import java.util.List;

import br.com.concursos.domain.Conteudo;

public interface ConteudoDao {

	public List<Conteudo> getConteudos() throws Exception;
}
