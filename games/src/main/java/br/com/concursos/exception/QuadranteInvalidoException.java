package br.com.concursos.exception;

import br.com.concursos.message.ErrorMessage;

public class QuadranteInvalidoException extends Exception {

	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return ErrorMessage.QUADRANTE_INVALIDO;
	}

}
