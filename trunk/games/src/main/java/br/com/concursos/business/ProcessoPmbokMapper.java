package br.com.concursos.business;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.concursos.domain.Processo;
import br.com.concursos.enumeration.ProcessoPmbok;

public class ProcessoPmbokMapper implements Mapper {

	@Override
	public List<Processo> getProcessos() {
		List<Processo> processos = new ArrayList<Processo>();

		List<ProcessoPmbok> processosPmbok = new ArrayList<ProcessoPmbok>();
		processosPmbok.addAll(Arrays.asList(ProcessoPmbok.values()));

		for (ProcessoPmbok processoPmbok : processosPmbok) {
			processos.add(createProcesso(processoPmbok));
		}

		return processos;
	}

	public Processo getProcessoPorProcessoPmbok(ProcessoPmbok processoPmbok) {
		return createProcesso(processoPmbok);
	}

	public ProcessoPmbok getProcessoCmmiPorProcesso(Processo processo) {
		List<ProcessoPmbok> processosPmbok = new ArrayList<ProcessoPmbok>();
		processosPmbok.addAll(Arrays.asList(ProcessoPmbok.values()));

		for (ProcessoPmbok processoPmbok : processosPmbok) {
			if (processo.equals(getProcessoPorProcessoPmbok(processoPmbok))) {
				return processoPmbok;
			}
		}

		return null;
	}

	private Processo createProcesso(ProcessoPmbok processoPmbok) {
		Processo processo = new Processo(processoPmbok.getCodigo());

		processo.setSigla(processoPmbok.getSigla());
		processo.setNome(processoPmbok.getNome());
		processo.setNomeOriginal(processoPmbok.getNomeOriginal());
		processo.setTituloHorizontal(processoPmbok.getGrupoProcessosCmmi());
		processo.setTituloVertical(processoPmbok.getNivelCmmi());
		processo.setDescricao(processoPmbok.getDescricao());

		return processo;
	}
}
