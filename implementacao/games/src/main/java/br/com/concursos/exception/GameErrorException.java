package br.com.concursos.exception;

import br.com.concursos.message.ErrorMessage;

public class GameErrorException extends Exception {

	private static final long serialVersionUID = -2510355059896561726L;

	@Override
	public String getMessage() {
		return ErrorMessage.GAME_ERROR;
	}
}
