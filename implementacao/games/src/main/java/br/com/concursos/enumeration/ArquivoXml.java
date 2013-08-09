package br.com.concursos.enumeration;

public enum ArquivoXml {

	CMMI_v1_2("cmmi-v1.2.xml"), CMMI_v1_3("cmmi-v1.3.xml"), PMBOK_4_EDICAO("pmbok-4.edicao.xml"), PMBOK_5_EDICAO("pmbok-5.edicao.xml");

	private String descricao;

	private ArquivoXml(String descricao) {
		this.setDescricao(descricao);
	}

	/**
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * @param descricao
	 *            the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
