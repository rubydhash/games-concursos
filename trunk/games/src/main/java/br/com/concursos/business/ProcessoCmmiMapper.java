package br.com.concursos.business;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.concursos.domain.Processo;
import br.com.concursos.enumeration.ProcessoCmmi;

public class ProcessoCmmiMapper implements Mapper {

	@Override
	public List<Processo> getProcessos() {
		List<Processo> processos = new ArrayList<Processo>();

		List<ProcessoCmmi> processosCmmi = new ArrayList<ProcessoCmmi>();
		processosCmmi.addAll(Arrays.asList(ProcessoCmmi.values()));

		for (ProcessoCmmi processoCmmi : processosCmmi) {
			processos.add(createProcesso(processoCmmi));
		}

		return processos;
	}

	public Processo getProcessoPorProcessoCmmi(ProcessoCmmi processoCmmi) {
		return createProcesso(processoCmmi);
	}

	public ProcessoCmmi getProcessoCmmiPorProcesso(Processo processo) {
		List<ProcessoCmmi> processosCmmi = new ArrayList<ProcessoCmmi>();
		processosCmmi.addAll(Arrays.asList(ProcessoCmmi.values()));

		for (ProcessoCmmi processoCmmi : processosCmmi) {
			if (processo.equals(getProcessoPorProcessoCmmi(processoCmmi))) {
				return processoCmmi;
			}
		}

		return null;
	}

	private Processo createProcesso(ProcessoCmmi processoCmmi) {
		Processo processo = new Processo(processoCmmi.getCodigo());

		processo.setSigla(processoCmmi.getSigla());
		processo.setNome(processoCmmi.getNome());
		processo.setNomeOriginal(processoCmmi.getNomeOriginal());
		processo.setTituloHorizontal(processoCmmi.getGrupoProcessosCmmi());
		processo.setTituloVertical(processoCmmi.getNivelCmmi());
		processo.setDescricao(processoCmmi.getDescricao());

		return processo;
	}

}
