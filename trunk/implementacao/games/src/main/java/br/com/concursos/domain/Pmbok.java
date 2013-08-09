package br.com.concursos.domain;

import br.com.concursos.enumeration.ArquivoXml;
import br.com.concursos.enumeration.NivelDificuldade;
import br.com.concursos.enumeration.VersaoPmbok;

public class Pmbok extends JogoTabuleiro {

	public Pmbok(VersaoPmbok versaoPmbok, NivelDificuldade nivelDificuldade) {
		super(versaoPmbok.getDescricao(), nivelDificuldade);

		if (versaoPmbok.equals(VersaoPmbok.QUARTA_EDICAO)) {
			this.setArquivoXml(ArquivoXml.PMBOK_4_EDICAO);
			this.setTamanhoTabuleiro(new TamanhoTabuleiro(9, 5));
		} else if (versaoPmbok.equals(VersaoPmbok.QUINTA_EDICAO)) {
			this.setArquivoXml(ArquivoXml.PMBOK_5_EDICAO;
			this.setTamanhoTabuleiro(new TamanhoTabuleiro(10, 5));
		}
	}

}
