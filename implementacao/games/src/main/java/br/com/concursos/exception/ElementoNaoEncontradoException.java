package br.com.concursos.exception;

import br.com.concursos.message.ErrorMessage;

public class ElementoNaoEncontradoException extends Exception {

	private static final long serialVersionUID = -5111031881848420030L;

	@Override
	public String getMessage() {
		return ErrorMessage.ELEMENTO_NAO_ENCONTRADO;
	}
}
