package br.com.concursos.exception;

import br.com.concursos.message.ErrorMessage;

public class ElementoExistenteException extends Exception {


	private static final long serialVersionUID = -887879367327606488L;

	@Override
	public String getMessage() {
		return ErrorMessage.ELEMENTO_EXISTENTE;
	}

}
