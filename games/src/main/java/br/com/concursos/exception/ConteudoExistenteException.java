package br.com.concursos.exception;

import br.com.concursos.message.ErrorMessage;

public class ConteudoExistenteException extends Exception {

	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return ErrorMessage.CONTEUDO_EXISTENTE;
	}

}
