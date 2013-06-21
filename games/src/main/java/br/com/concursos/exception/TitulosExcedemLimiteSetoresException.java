package br.com.concursos.exception;

import br.com.concursos.message.ErrorMessage;

public class TitulosExcedemLimiteSetoresException extends Exception {

	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return ErrorMessage.TITULOS_EXCEDEM_LIMITE_SETORES;
	}
}
