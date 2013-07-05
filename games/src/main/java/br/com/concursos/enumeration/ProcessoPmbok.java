package br.com.concursos.enumeration;

import java.util.ArrayList;
import java.util.List;

public enum ProcessoPmbok {

	// NÍVEL 2
	ANALISE_CASUAL_E_RESOLUCAO(22, "CAR", "Análise Causal e Resolução", "Causal Analysis and Resolution", GrupoProcessosCmmi.SUPORTE, NivelCmmi.NIVEL_5, "");

	private int codigo;
	private String sigla;
	private String nome;
	private String nomeOriginal;
	private GrupoProcessosCmmi grupoProcessosCmmi;
	private NivelCmmi nivelCmmi;
	private String descricao;

	private ProcessoPmbok(int codigo, String sigla, String nome, String nomeOriginal, GrupoProcessosCmmi grupoProcessosCmmi, NivelCmmi nivelCmmi,
			String descricao) {
		this.codigo = codigo;
		this.sigla = sigla;
		this.nome = nome;
		this.nomeOriginal = nomeOriginal;
		this.setGrupoProcessosCmmi(grupoProcessosCmmi);
		this.nivelCmmi = nivelCmmi;
		this.setDescricao(descricao);
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNomeOriginal() {
		return nomeOriginal;
	}

	public void setNomeOriginal(String nomeOriginal) {
		this.nomeOriginal = nomeOriginal;
	}

	public GrupoProcessosCmmi getGrupoProcessosCmmi() {
		return grupoProcessosCmmi;
	}

	public void setGrupoProcessosCmmi(GrupoProcessosCmmi grupoProcessosCmmi) {
		this.grupoProcessosCmmi = grupoProcessosCmmi;
	}

	public NivelCmmi getNivelCmmi() {
		return nivelCmmi;
	}

	public void setNivelCmmi(NivelCmmi nivelCmmi) {
		this.nivelCmmi = nivelCmmi;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public static ProcessoPmbok getProcessoCmmiPorCodigo(int codigo) {
		for (ProcessoPmbok processoCmmi : ProcessoPmbok.values()) {
			if (processoCmmi.getCodigo() == codigo) {
				return processoCmmi;
			}
		}
		return null;
	}

	public static ProcessoPmbok getProcessoCmmiPorSigla(String sigla) {
		for (ProcessoPmbok processoCmmi : ProcessoPmbok.values()) {
			if (processoCmmi.getSigla().equals(sigla)) {
				return processoCmmi;
			}
		}

		return null;
	}

	public static ProcessoPmbok getProcessoCmmiPorNome(String nome) {
		for (ProcessoPmbok processoCmmi : ProcessoPmbok.values()) {
			if (processoCmmi.getNome().equals(nome)) {
				return processoCmmi;
			}
		}

		return null;
	}

	public static List<ProcessoPmbok> getProcessosCmmiPorNivel(NivelCmmi nivelCmmi) {
		List<ProcessoPmbok> processosCmmi = new ArrayList<ProcessoPmbok>();
		for (ProcessoPmbok processoCmmi : ProcessoPmbok.values()) {
			if (processoCmmi.getNivelCmmi().equals(nivelCmmi)) {
				processosCmmi.add(processoCmmi);
			}
		}

		return processosCmmi;
	}

	public static List<ProcessoPmbok> getProcessosCmmiPorGrupoProcessos(GrupoProcessosCmmi grupoProcessosCmmi) {
		List<ProcessoPmbok> processosCmmi = new ArrayList<ProcessoPmbok>();
		for (ProcessoPmbok processoCmmi : ProcessoPmbok.values()) {
			if (processoCmmi.getGrupoProcessosCmmi().equals(grupoProcessosCmmi)) {
				processosCmmi.add(processoCmmi);
			}
		}

		return processosCmmi;
	}

	@Override
	public String toString() {
		return getNome();
	}

}