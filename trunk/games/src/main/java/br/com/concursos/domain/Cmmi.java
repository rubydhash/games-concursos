package br.com.concursos.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Named;

import br.com.concursos.business.ProcessoCmmiMapper;
import br.com.concursos.enumeration.GrupoProcessosCmmi;
import br.com.concursos.enumeration.NivelCmmi;
import br.com.concursos.enumeration.ProcessoCmmi;
import br.com.concursos.exception.ConteudoExcedeLimitePermitidoException;
import br.com.concursos.exception.ConteudoExistenteException;
import br.com.concursos.exception.ConteudoNaoEncontradoException;
import br.com.concursos.exception.QuadranteInvalidoException;

@Named
public class Cmmi extends Jogo {

	private ProcessoCmmiMapper processoCmmiMapper;

	public Cmmi() {
		this.setTamanhoTabuleiro(new TamanhoTabuleiro(4, 4));

		processoCmmiMapper = new ProcessoCmmiMapper();
		this.setMapper(processoCmmiMapper);

		List<GrupoProcessosCmmi> grupoProcessosCmmis = new ArrayList<GrupoProcessosCmmi>();
		grupoProcessosCmmis.addAll(Arrays.asList(GrupoProcessosCmmi.values()));
		this.setTitulosHorizontais(grupoProcessosCmmis);

		List<NivelCmmi> nivelCmmis = new ArrayList<NivelCmmi>();
		nivelCmmis.addAll(Arrays.asList(NivelCmmi.values()));
		this.setTitulosVerticais(nivelCmmis);
	}

	/**
	 * Adiciona um processo no Tabuleiro e remove do painel de processos disponíveis.
	 * 
	 * @param processoCmmi
	 * @param quadrante
	 * @return {@link Boolean}
	 * @throws ConteudoExistenteException
	 * @throws ConteudoExcedeLimitePermitidoException
	 * @throws QuadranteInvalidoException
	 */
	public boolean add(ProcessoCmmi processoCmmi, Quadrante quadrante) throws ConteudoExistenteException, ConteudoExcedeLimitePermitidoException,
			QuadranteInvalidoException {
		Processo processo = processoCmmiMapper.getProcessoPorProcessoCmmi(processoCmmi);
		return add(processo, quadrante);
	}

	/**
	 * Remove um processo do Tabuleiro e adiciona no painel de processos disponíveis.
	 * 
	 * @param processoCmmi
	 * @return {@link Boolean}
	 * @throws ConteudoNaoEncontradoException
	 */
	public boolean remove(ProcessoCmmi processoCmmi) throws ConteudoNaoEncontradoException {
		Processo processo = processoCmmiMapper.getProcessoPorProcessoCmmi(processoCmmi);
		return remove(processo);
	}

}
