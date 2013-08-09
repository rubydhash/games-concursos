package br.com.concursos.enumeration;

import java.util.ArrayList;
import java.util.List;

public enum ProcessoPmbok {

	// NÍVEL 2
	ANALISE_CASUAL_E_RESOLUCAO(22);

	private int codigo;

	private ProcessoPmbok(int codigo) {
		this.codigo = codigo;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public static ProcessoPmbok getProcessoCmmiPorCodigo(int codigo) {
		for (ProcessoPmbok processoCmmi : ProcessoPmbok.values()) {
			if (processoCmmi.getCodigo() == codigo) {
				return processoCmmi;
			}
		}
		return null;
	}

}