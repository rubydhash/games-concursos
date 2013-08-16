package br.com.concursos.exception;

import javax.ejb.ApplicationException;

@ApplicationException(rollback = true)
public class GameBusinessException extends Exception {

	private static final long serialVersionUID = 6589148326168101182L;

	public GameBusinessException(String message) {
		super(message);
	}
}
