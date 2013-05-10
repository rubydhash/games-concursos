package br.com.concursos.entity;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import br.com.concursos.enumeration.ProcessoCmmi;

@Named
public class Cmmi {

	private List<ProcessoCmmi> processos;

	public Cmmi() {
		processos = new ArrayList<ProcessoCmmi>();
		inicializaListaProcessos();
	}

	public List<ProcessoCmmi> getProcessos() {
		return processos;
	}

	public void setProcessos(List<ProcessoCmmi> processos) {
		this.processos = processos;
	}

	private void inicializaListaProcessos() {
		ProcessoCmmi[] arrayProcessos = ProcessoCmmi.values();
		for (int i = 0; i < arrayProcessos.length; i++) {
			getProcessos().add(arrayProcessos[i]);
		}
	}

}
