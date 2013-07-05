package br.com.concursos.domain;

import br.com.concursos.business.ProcessoPmbokMapper;

public class Pmbok extends Jogo {
	
	private ProcessoPmbokMapper processoPmbokMapper;

	public Pmbok() {
		// TODO REFAZER PARA ATENDER AO PMBOK
		
		this.setMapper(processoPmbokMapper);
	}

}
