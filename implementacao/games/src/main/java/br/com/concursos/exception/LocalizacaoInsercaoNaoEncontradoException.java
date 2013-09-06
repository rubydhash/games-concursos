package br.com.concursos.exception;

import br.com.concursos.message.ErrorMessage;

public class LocalizacaoInsercaoNaoEncontradoException extends Exception {

	private static final long serialVersionUID = 8858111769080651638L;

	@Override
	public String getMessage() {
		return ErrorMessage.LOCALIZACAO_INSERCAO_NAO_ENCONTRADO;
	}

}
