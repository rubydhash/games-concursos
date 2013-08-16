package br.com.concursos.exception;

import br.com.concursos.message.ErrorMessage;

public class LocalizacaoNaoPreenchidaException extends Exception {

	private static final long serialVersionUID = 6647498109740262838L;
	
	@Override
	public String getMessage() {
		return ErrorMessage.LOCALIZACAO_NAO_PREENCHIDA;
	}

}
