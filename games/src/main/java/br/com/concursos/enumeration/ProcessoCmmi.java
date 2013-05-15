package br.com.concursos.enumeration;

import java.util.ArrayList;
import java.util.List;

public enum ProcessoCmmi {

	// NÍVEL 2
	GERENCIAMENTO_DE_REQUISITOS(1, "REQM", "Gerenciamento de Requisitos", "Requirements Management", GrupoProcessosCmmi.GESTAO_DE_PROJETOS, NivelCmmi.NIVEL_2),
	PLANEJAMENTO_DE_PROJETO(2, "PP", "Planejamento de Projeto", "Project Planning", GrupoProcessosCmmi.GESTAO_DE_PROJETOS, NivelCmmi.NIVEL_2),
	MONITORAMENTO_E_CONTROLE_DE_PROJETO(3, "PMC", "Monitoramento e Controle de Projeto", "Project Monitoring and Control", GrupoProcessosCmmi.GESTAO_DE_PROJETOS, NivelCmmi.NIVEL_2),
	GERENCIAMENTO_DE_ACORDO_COM_FORNECEDOR(4, "SAM", "Gerenciamento de Acordo com Fornecedor", "Supplier Agreement Management", GrupoProcessosCmmi.GESTAO_DE_PROJETOS, NivelCmmi.NIVEL_2),
	MEDICAO_E_ANALISE(5, "MA", "Medição e Análise", "Measurement and Analysis", GrupoProcessosCmmi.SUPORTE, NivelCmmi.NIVEL_2),
	GARANTIA_DA_QUALIDADE_DE_PROCESSO_E_PRODUTO(6, "PPQA", "Garantia da Qualidade de Processo e Produto", "Process and Product Quality Assurance", GrupoProcessosCmmi.SUPORTE, NivelCmmi.NIVEL_2),
	GERENCIA_DE_CONFIGURACAO(7, "CM", "Gerência de Configuração", "Configuration Management", GrupoProcessosCmmi.SUPORTE, NivelCmmi.NIVEL_2),

	// NÍVEL 3
	DESENVOLVIMENTO_DE_REQUISITOS(8, "RD", "Desenvolvimento de Requisitos", "Requirements Development", GrupoProcessosCmmi.ENGENHARIA, NivelCmmi.NIVEL_3),
	SOLUCAO_TECNICA(9, "TS", "Solução Técnica", "Technical Solution", GrupoProcessosCmmi.ENGENHARIA, NivelCmmi.NIVEL_3),
	INTEGRACAO_DE_PRODUTO(10, "PI", "Integração de Produto", "Product Integration", GrupoProcessosCmmi.ENGENHARIA, NivelCmmi.NIVEL_3),
	VERIFICACAO(11, "VER", "Verificação", "Verification", GrupoProcessosCmmi.ENGENHARIA, NivelCmmi.NIVEL_3),
	VALIDACAO(12, "VAL", "Validação", "Validation", GrupoProcessosCmmi.ENGENHARIA, NivelCmmi.NIVEL_3),
	FOCO_DE_PROCESSO_ORGANIZACIONAL(13, "OPF", "Foco de Processo Organizacional", "Organizational Process Focus", GrupoProcessosCmmi.GESTAO_DE_PROCESSOS, NivelCmmi.NIVEL_3),
	DEFINICAO_DE_PROCESSO_ORGANIZACIONAL(14, "OPD", "Definição de Processo Organizacional", "Organizational Process Definition", GrupoProcessosCmmi.GESTAO_DE_PROCESSOS,NivelCmmi.NIVEL_3),
	TREINAMENTO_ORGANIZACIONAL(15, "OT", "Treinamento Organizacional", "Organizational Training", GrupoProcessosCmmi.GESTAO_DE_PROCESSOS, NivelCmmi.NIVEL_3),
	GERENCIAMENTO_INTEGRADO_DE_PROJETO(16, "IPM", "Gerenciamento Integrado de Projeto", "Integrated Project Management", GrupoProcessosCmmi.GESTAO_DE_PROJETOS, NivelCmmi.NIVEL_3),
	GERENCIAMENTO_DE_RISCOS(17, "RSKM", "Gerenciamento de Riscos", "Risk Management", GrupoProcessosCmmi.GESTAO_DE_PROJETOS, NivelCmmi.NIVEL_3),
	ANALISE_DE_DECISAO_E_RESOLUCAO(18, "DAR", "Análise de Decisão e Resolução", "Decision Analysis and Resolution", GrupoProcessosCmmi.SUPORTE, NivelCmmi.NIVEL_3),

	// NÍVEL 4
	DESEMPENHO_DE_PROCESSO_ORGANIZACIONAL(19, "OPP", "Desempenho de Processo Organizacional", "Organizational Process Performance", GrupoProcessosCmmi.GESTAO_DE_PROCESSOS, NivelCmmi.NIVEL_4),
	GERENCIAMENTO_QUANTITATIVO_DE_PROJETO(20, "QPM", "Gerenciamento Quantitativo de Projeto", "Quantitative Project Management", GrupoProcessosCmmi.GESTAO_DE_PROJETOS, NivelCmmi.NIVEL_4),

	// NÍVEL 5
	GESTAO_DE_PROCESSO_ORGANIZACIONAL(21, "OPM", "Gestão de Processo Organizacional", "Organizational Process Management", GrupoProcessosCmmi.GESTAO_DE_PROCESSOS, NivelCmmi.NIVEL_5),
	ANALISE_CASUAL_E_RESOLUCAO(22, "CAR", "Análise Causal e Resolução", "Causal Analysis and Resolution", GrupoProcessosCmmi.SUPORTE, NivelCmmi.NIVEL_5);

	private int numero;
	private String codigo;
	private String nome;
	private String nomeOriginal;
	private GrupoProcessosCmmi grupoProcessosCmmi;
	private NivelCmmi nivelCmmi;

	private ProcessoCmmi(int numero, String codigo, String nome, String nomeOriginal, GrupoProcessosCmmi grupoProcessosCmmi, NivelCmmi nivelCmmi) {
		this.numero = numero;
		this.codigo = codigo;
		this.nome = nome;
		this.nomeOriginal = nomeOriginal;
		this.setGrupoProcessosCmmi(grupoProcessosCmmi);
		this.nivelCmmi = nivelCmmi;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
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

	public static ProcessoCmmi getProcessoCmmiPorNumero(int numero) {
		for (ProcessoCmmi processoCmmi : ProcessoCmmi.values()) {
			if (processoCmmi.getNumero() == numero) {
				return processoCmmi;
			}
		}
		return null;
	}

	public static ProcessoCmmi getProcessoCmmiPorCodigo(String codigo) {
		for (ProcessoCmmi processoCmmi : ProcessoCmmi.values()) {
			if (processoCmmi.getCodigo().equals(codigo)) {
				return processoCmmi;
			}
		}
		return null;
	}

	public static ProcessoCmmi getProcessoCmmiPorNome(String nome) {
		for (ProcessoCmmi processoCmmi : ProcessoCmmi.values()) {
			if (processoCmmi.getNome().equals(nome)) {
				return processoCmmi;
			}
		}
		return null;
	}

	public static List<ProcessoCmmi> getProcessosCmmiPorNivel(NivelCmmi nivelCmmi) {
		List<ProcessoCmmi> processosCmmi = new ArrayList<ProcessoCmmi>();
		for (ProcessoCmmi processoCmmi : ProcessoCmmi.values()) {
			if (processoCmmi.getNivelCmmi().equals(nivelCmmi)) {
				processosCmmi.add(processoCmmi);
			}
		}
		return processosCmmi;
	}

	public static List<ProcessoCmmi> getProcessosCmmiPorGrupoProcessos(GrupoProcessosCmmi grupoProcessosCmmi) {
		List<ProcessoCmmi> processosCmmi = new ArrayList<ProcessoCmmi>();
		for (ProcessoCmmi processoCmmi : ProcessoCmmi.values()) {
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