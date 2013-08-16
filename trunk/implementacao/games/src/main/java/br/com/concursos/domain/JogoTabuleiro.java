package br.com.concursos.domain;

public abstract class JogoTabuleiro {

	// private List<Conteudo> conteudos;
	// private Tabuleiro tabuleiro;
	// private NivelDificuldade nivelDificuldade;
	// private ConteudoDao conteudoDao;
	// private List<?> titulosHorizontais;
	// private List<?> titulosVerticais;
	// private String versao;
	// private ArquivoXml arquivoXml;
	// private TamanhoTabuleiro tamanhoTabuleiro;
	//
	// public void preparaJogo(String versao, NivelDificuldade nivelDificuldade, List<?> titulosHorizontais, List<?> titulosVerticais, ArquivoXml arquivoXml,
	// TamanhoTabuleiro tamanhoTabuleiro) {
	// this.versao = versao;
	// this.nivelDificuldade = nivelDificuldade;
	// this.titulosHorizontais = titulosHorizontais;
	// this.titulosVerticais = titulosVerticais;
	// this.arquivoXml = arquivoXml;
	// this.tamanhoTabuleiro = tamanhoTabuleiro;
	// }
	//
	// /**
	// * Inicializa o Jogo.
	// *
	// * @throws TabuleiroTamanhoInvalidoException
	// * @throws TitulosExcedemLimiteSetoresException
	// * @throws JAXBException
	// */
	// public void inicializa() throws TabuleiroTamanhoInvalidoException, TitulosExcedemLimiteSetoresException, JAXBException {
	// inicializaTabuleiro();
	// inicializaConteudos();
	// inicializaDificuldade();
	// }
	//
	// /**
	// * Inicializa a lista de conteúdos do Jogo.
	// *
	// * @throws JAXBException
	// *
	// */
	// private void inicializaConteudos() throws JAXBException {
	// conteudoDao = new ConteudoDaoXml(getArquivoXml());
	// conteudos = getConteudoDao().getConteudos();
	// }
	//
	// /**
	// * Inicializa o tabuleiro.
	// *
	// * @throws TabuleiroTamanhoInvalidoException
	// * @throws TitulosExcedemLimiteSetoresException
	// */
	// private void inicializaTabuleiro() throws TabuleiroTamanhoInvalidoException {
	// tabuleiro = new Tabuleiro(getTamanhoTabuleiro());
	// }
	//
	// /**
	// * Inicializa o Nível de Dificuldade.
	// *
	// * @throws TitulosExcedemLimiteSetoresException
	// */
	// @SuppressWarnings({ "rawtypes", "unchecked" })
	// private void inicializaDificuldade() throws TitulosExcedemLimiteSetoresException {
	// if (this.getNivelDificuldade().equals(NivelDificuldade.FACIL)) {
	// tabuleiro.setTitulos(getTitulosHorizontais(), TipoSetor.HORIZONTAL, false);
	// tabuleiro.setTitulos(getTitulosVerticais(), TipoSetor.VERTICAL, false);
	// } else if (this.getNivelDificuldade().equals(NivelDificuldade.MEDIO)) {
	// tabuleiro.setTitulos(getTitulosHorizontais(), TipoSetor.HORIZONTAL, true);
	// tabuleiro.setTitulos(getTitulosVerticais(), TipoSetor.VERTICAL, true);
	// } else if (this.getNivelDificuldade().equals(NivelDificuldade.DIFICIL)) {
	// tabuleiro.setTitulos(getTitulosHorizontais(), TipoSetor.VERTICAL, true);
	// tabuleiro.setTitulos(getTitulosVerticais(), TipoSetor.HORIZONTAL, true);
	// } else if (this.getNivelDificuldade().equals(NivelDificuldade.MUITO_DIFICIL)) {
	// List titulosHorizontais = new ArrayList();
	// for (int i = 0; i < this.titulosHorizontais.size(); i++) {
	// if (i % 2 == 0) {
	// titulosHorizontais.add(getTitulosHorizontais().get(i));
	// } else {
	// titulosHorizontais.add(getTitulosVerticais().get(i));
	// }
	// }
	//
	// List titulosVerticais = new ArrayList();
	// for (int i = 0; i < getTitulosVerticais().size(); i++) {
	// if (i % 2 == 0) {
	// titulosVerticais.add(getTitulosVerticais().get(i));
	// } else {
	// titulosVerticais.add(getTitulosHorizontais().get(i));
	// }
	// }
	//
	// tabuleiro.setTitulos(titulosHorizontais, TipoSetor.HORIZONTAL, true);
	// tabuleiro.setTitulos(titulosVerticais, TipoSetor.VERTICAL, true);
	// }
	// }
	//
	// /**
	// * Verifica se os conteudos estão no devido lugar do Tabuleiro.
	// *
	// * @throws GameErrorException
	// */
	// public void finaliza() throws GameErrorException {
	// if (!(tabuleiro.verificaConteudo(TipoSetor.HORIZONTAL) && tabuleiro.verificaConteudo(TipoSetor.VERTICAL))) {
	// throw new GameErrorException();
	// }
	// }
	//
	// /**
	// * Adiciona um conteúdo do Tabuleiro e remove do painel disponível.
	// *
	// * @param conteudo
	// * @param quadrante
	// * @return {@link Boolean}
	// * @throws ConteudoExcedeLimitePermitidoException
	// * @throws QuadranteInvalidoException
	// * @throws ConteudoExistenteException
	// */
	// public boolean add(Conteudo conteudo, Quadrante quadrante) throws ConteudoExistenteException, QuadranteInvalidoException,
	// ConteudoExcedeLimitePermitidoException {
	// tabuleiro.add(conteudo, quadrante);
	// conteudos.remove(conteudo);
	//
	// return true;
	// }
	//
	// /**
	// * Adiciona um conteúdo de código específico do Tabuleiro e o remove do painel disponível.
	// *
	// * @param codigo
	// * @param quadrante
	// * @return {@link Boolean}
	// * @throws ConteudoExcedeLimitePermitidoException
	// * @throws QuadranteInvalidoException
	// * @throws ConteudoExistenteException
	// * @throws ConteudoNaoEncontradoException
	// */
	// public boolean add(int codigo, Quadrante quadrante) throws ConteudoExistenteException, QuadranteInvalidoException,
	// ConteudoExcedeLimitePermitidoException,
	// ConteudoNaoEncontradoException {
	// Conteudo conteudo = this.getConteudoDao().findBy(codigo);
	// tabuleiro.add(conteudo, quadrante);
	// conteudos.remove(conteudo);
	//
	// return true;
	// }
	//
	// /**
	// * Remove um conteúdo do Tabuleiro e adiciona no painel disponível.
	// *
	// * @param conteudo
	// * @return {@link Boolean}
	// * @throws ConteudoNaoEncontradoException
	// */
	// public boolean remove(Conteudo conteudo) throws ConteudoNaoEncontradoException {
	// tabuleiro.remove(conteudo);
	// conteudos.add(conteudo);
	//
	// return true;
	// }
	//
	// /**
	// * Remove um um conteúdo de código específico do Tabuleiro e o remove do painel disponível.
	// *
	// * @param codigo
	// * @return {@link Boolean}
	// * @throws ConteudoNaoEncontradoException
	// */
	// public boolean remove(int codigo) throws ConteudoNaoEncontradoException {
	// Conteudo conteudo = this.getConteudoDao().findBy(codigo);
	// return remove(conteudo);
	// }
	//
	// /** -- GETTERS AND SETTERS -- */
	//
	// /**
	// * @return the conteudos
	// */
	// public List<Conteudo> getConteudos() {
	// return conteudos;
	// }
	//
	// /**
	// * @return the tabuleiro
	// */
	// public Tabuleiro getTabuleiro() {
	// return tabuleiro;
	// }
	//
	// /**
	// * @return the nivelDificuldade
	// */
	// public NivelDificuldade getNivelDificuldade() {
	// return nivelDificuldade;
	// }
	//
	// /**
	// * @return the titulosHorizontais
	// */
	// public List<?> getTitulosHorizontais() {
	// return titulosHorizontais;
	// }
	//
	// /**
	// * @return the titulosVerticais
	// */
	// public List<?> getTitulosVerticais() {
	// return titulosVerticais;
	// }
	//
	// /**
	// * @return the versao
	// */
	// public String getVersao() {
	// return versao;
	// }
	//
	// /**
	// * @return the conteudoDao
	// */
	// public ConteudoDao getConteudoDao() {
	// return conteudoDao;
	// }
	//
	// /**
	// * @return the arquivoXml
	// */
	// public ArquivoXml getArquivoXml() {
	// return arquivoXml;
	// }
	//
	// /**
	// * @return the tamanhoTabuleiro
	// */
	// public TamanhoTabuleiro getTamanhoTabuleiro() {
	// return tamanhoTabuleiro;
	// }

}
