package br.com.concursos.exception;

import br.com.concursos.message.ErrorMessage;

public class ImpossivelRemoverNoRaizException extends Exception {

	private static final long serialVersionUID = -3974458952676760633L;

	@Override
	public String getMessage() {
		return ErrorMessage.IMPOSSIVEL_REMOVER_NO_RAIZ;
	}

}
