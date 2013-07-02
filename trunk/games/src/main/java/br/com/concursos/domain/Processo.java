package br.com.concursos.domain;

public class Processo extends Conteudo {

	private String codigo;
	private String nome;
	private String nomeOriginal;
	private String descricao;

	public Processo(int numero) {
		super(numero);
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public boolean equals(Object obj) {
		Processo outroProcesso;
		if (obj instanceof Processo) {
			outroProcesso = (Processo) obj;

			if (this.getNumero() == outroProcesso.getNumero() && this.getCodigo().equals(outroProcesso.getCodigo())
					&& this.nome.equals(outroProcesso.getNome())) {
				return true;
			}
		}

		return false;
	}

	@Override
	public String toString() {
		if (nome == null && nome.isEmpty()) {
			return super.toString();
		}

		return super.toString() + ": " + nome;
	}

}
