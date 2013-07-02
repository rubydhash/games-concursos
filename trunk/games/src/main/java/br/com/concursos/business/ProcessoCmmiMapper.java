package br.com.concursos.business;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.concursos.domain.Processo;
import br.com.concursos.enumeration.ProcessoCmmi;

public class ProcessoCmmiMapper {

	public static List<Processo> getProcessos() {
		List<Processo> processos = new ArrayList<Processo>();
		
		List<ProcessoCmmi> processosCmmi = new ArrayList<ProcessoCmmi>();
		processosCmmi.addAll(Arrays.asList(ProcessoCmmi.values()));

		for (ProcessoCmmi processoCmmi : processosCmmi) {
			Processo processo = new Processo(processoCmmi.getNumero());

			processo.setCodigo(processoCmmi.getCodigo());
			processo.setNome(processoCmmi.getNome());
			processo.setNomeOriginal(processoCmmi.getNomeOriginal());
			processo.setTituloHorizontal(processoCmmi.getGrupoProcessosCmmi());
			processo.setTituloVertical(processoCmmi.getNivelCmmi());

			processos.add(processo);
		}

		return processos;
	}

	public static Processo getProcessoPorProcessoCmmi(ProcessoCmmi processoCmmi) {
		Processo processo = new Processo(processoCmmi.getNumero());

		processo.setCodigo(processoCmmi.getCodigo());
		processo.setNome(processoCmmi.getNome());
		processo.setNomeOriginal(processoCmmi.getNomeOriginal());
		processo.setTituloHorizontal(processoCmmi.getGrupoProcessosCmmi());
		processo.setTituloVertical(processoCmmi.getNivelCmmi());

		return processo;
	}
	
	public static ProcessoCmmi getProcessoCmmiPorProcesso(Processo processo) {
		List<ProcessoCmmi> processosCmmi = new ArrayList<ProcessoCmmi>();
		processosCmmi.addAll(Arrays.asList(ProcessoCmmi.values()));

		for (ProcessoCmmi processoCmmi : processosCmmi) {
			if (processo.equals(getProcessoPorProcessoCmmi(processoCmmi))) {
				return processoCmmi;
			}
		}

		return null;
	}
}
