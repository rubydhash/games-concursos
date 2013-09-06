package br.com.concursos.exception;

import br.com.concursos.message.ErrorMessage;

public class LocalizacaoInsercaoElementoNaoPreenchidaException extends Exception {

	private static final long serialVersionUID = 6647498109740262838L;
	
	@Override
	public String getMessage() {
		return ErrorMessage.LOCALIZACAO_INSERCAO_ELEMENTO_NAO_PREENCHIDA;
	}

}
