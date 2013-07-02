package br.com.concursos.domain;

public interface Jogo {

	public void inicializa() throws Exception;

	public void finaliza() throws Exception;

	public boolean add(Processo processo, Quadrante quadrante) throws Exception;

	public boolean remove(Processo processo) throws Exception;
}
