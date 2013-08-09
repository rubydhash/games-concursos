package br.com.concursos.exception;

import br.com.concursos.message.FatalMessage;

public class ErroGeralSistemaException extends Exception {

	private static final long serialVersionUID = -3616559653398031336L;

	@Override
	public String getMessage() {
		return FatalMessage.ERRO_GERAL_SISTEMA;
	}
}
