package br.com.concursos.enumeration;

public enum ProcessoCmmi {

	// NÍVEL 2
	GERENCIAMENTO_DE_REQUISITOS(1),
	PLANEJAMENTO_DE_PROJETO(2),
	MONITORAMENTO_E_CONTROLE_DE_PROJETO(3),
	GERENCIAMENTO_DE_ACORDO_COM_FORNECEDOR(4),
	MEDICAO_E_ANALISE(5),
	GARANTIA_DA_QUALIDADE_DE_PROCESSO_E_PRODUTO(6),
	GERENCIA_DE_CONFIGURACAO(7),
	// NÍVEL 3
	DESENVOLVIMENTO_DE_REQUISITOS(8),
	SOLUCAO_TECNICA(9),
	INTEGRACAO_DE_PRODUTO(10),
	VERIFICACAO(11),
	VALIDACAO(12),
	FOCO_DE_PROCESSO_ORGANIZACIONAL(13),
	DEFINICAO_DE_PROCESSO_ORGANIZACIONAL(14),
	TREINAMENTO_ORGANIZACIONAL(15),
	GERENCIAMENTO_INTEGRADO_DE_PROJETO(16),
	GERENCIAMENTO_DE_RISCOS(17),
	ANALISE_DE_DECISAO_E_RESOLUCAO(18),
	// NÍVEL 4
	DESEMPENHO_DE_PROCESSO_ORGANIZACIONAL(19),
	GERENCIAMENTO_QUANTITATIVO_DE_PROJETO(20),
	// NÍVEL 5
	GESTAO_DE_PROCESSO_ORGANIZACIONAL(21),
	ANALISE_CASUAL_E_RESOLUCAO(22);

	private int codigo;

	private ProcessoCmmi(int codigo) {
		this.codigo = codigo;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public static ProcessoCmmi getProcessoCmmiPorCodigo(int codigo) {
		for (ProcessoCmmi processoCmmi : ProcessoCmmi.values()) {
			if (processoCmmi.getCodigo() == codigo) {
				return processoCmmi;
			}
		}
		return null;
	}

}