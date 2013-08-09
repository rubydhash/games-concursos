package br.com.concursos.exception;

import br.com.concursos.message.ErrorMessage;

public class TabuleiroTamanhoInvalidoException extends Exception {

	private static final long serialVersionUID = -9002355489739401366L;

	@Override
	public String getMessage() {
		return ErrorMessage.TABULEIRO_TAMANHO_INVALIDO;
	}
}
