package br.com.concursos.enumeration;

import java.util.ArrayList;
import java.util.List;

public enum ProcessoCmmi {

	GERENCIAMENTO_DE_REQUISITOS(1, "REQM", "Gerenciamento de Requisitos", "Requirements Management", NivelCmmi.NIVEL_2),
	PLANEJAMENTO_DE_PROJETO(2, "PP", "Planejamento de Projeto", "Project Planning", NivelCmmi.NIVEL_2),
	ACOMPANHAMENTO_E_CONTROLE_DE_PROJETO(3, "PMC", "Acompanhamento e Controle de Projeto", "Project Monitoring and Control", NivelCmmi.NIVEL_2),
	GERENCIAMENTO_DE_ACORDO_COM_FORNECEDOR(4, "SAM", "Gerenciamento de Acordo com Fornecedor", "Supplier Agreement Management", NivelCmmi.NIVEL_2),
	MEDICAO_E_ANALISE(5, "MA", "Medição e Análise", "Measurement and Analysis", NivelCmmi.NIVEL_2),
	GARANTIA_DA_QUALIDADE_DE_PROCESSO_E_PRODUTO(6, "PPQA", "Garantia da Qualidade de Processo e Produto", "Process and Product Quality Assurance", NivelCmmi.NIVEL_2),
	GERENCIA_DE_CONFIGURACAO(7, "CM", "Gerência de Configuração", "Configuration Management", NivelCmmi.NIVEL_2),

	DESENVOLVIMENTO_DE_REQUISITOS(8, "RD", "Desenvolvimento de Requisitos", "Requirements Development", NivelCmmi.NIVEL_3),
	SOLUCAO_TECNICA(9, "TS", "Solução Técnica", "Technical Solution", NivelCmmi.NIVEL_3),
	INTEGRACAO_DE_PRODUTO(10, "PI", "Integração de Produto", "Product Integration", NivelCmmi.NIVEL_3),
	VERIFICACAO(11, "VER", "Verificação", "Verification", NivelCmmi.NIVEL_3),
	VALIDACAO(12, "VAL", "Validação", "Validation", NivelCmmi.NIVEL_3),
	FOCO_DE_PROCESSO_ORGANIZACIONAL(13, "OPF", "Foco de Processo Organizacional", "Organizational Process Focus", NivelCmmi.NIVEL_3),
	DEFINICAO_DE_PROCESSO_ORGANIZACIONAL(14, "OPD", "Definição de Processo Organizacional", "Organizational Process Definition", NivelCmmi.NIVEL_3),
	TREINAMENTO_ORGANIZACIONAL(15, "OT", "Treinamento Organizacional", "Organizational Training", NivelCmmi.NIVEL_3),
	GERENCIAMENTO_INTEGRADO_DE_PROJETO(16, "IPM", "Gerenciamento Integrado de Projeto", "Integrated Project Management", NivelCmmi.NIVEL_3),
	GERENCIAMENTO_DE_RISCOS(17, "RSKM", "Gerenciamento de Riscos", "Risk Management", NivelCmmi.NIVEL_3),
	ANALISE_DE_DECISAO_E_RESOLUCAO(18, "DAR", "Análise de Decisão e Resolução", "Decision Analysis and Resolution", NivelCmmi.NIVEL_3),

	DESEMPENHO_DE_PROCESSO_ORGANIZACIONAL(19, "OPP", "Desempenho de Processo Organizacional", "Organizational Process Performance", NivelCmmi.NIVEL_4),
	GERENCIAMENTO_QUANTITATIVO_DE_PROJETO(20, "QPM", "Gerenciamento Quantitativo de Projeto", "Quantitative Project Management", NivelCmmi.NIVEL_4),

	GESTAO_DE_PROCESSO_ORGANIZACIONAL(21, "OPM", "Gestão de Processo Organizacional", "Organizational Process Management", NivelCmmi.NIVEL_5),
	ANALISE_CASUAL_E_RESOLUCAO(22, "CAR", "Análise Causal e Resolução", "Causal Analysis and Resolution", NivelCmmi.NIVEL_5);

	private int numero;
	private String codigo;
	private String nome;
	private String nomeOriginal;
	private NivelCmmi nivelCmmi;

	private ProcessoCmmi(int numero, String codigo, String nome, String nomeOriginal, NivelCmmi nivelCmmi) {
		this.numero = numero;
		this.codigo = codigo;
		this.nome = nome;
		this.nomeOriginal = nomeOriginal;
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

	@Override
	public String toString() {
		return getNome();
	}
	
}