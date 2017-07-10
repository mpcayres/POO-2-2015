package br.unb.cic.imdb.negocio;

import java.time.LocalDate;
import java.util.List;

import br.unb.cic.imdb.integracao.*;

/**
 * Classe de fachada (Facade class) que vai servir de comunicacao 
 * entre a camada de apresentacao (ui) e a camada de negocio. Caso 
 * se torne excessivamente complexa, essa classe deve ser sub-dividida.
 *  
 */
public class IMDBFacade {
	
	private DAOAlbum daoAlbum;
	private DAOAutor daoAutor;
	private DAOAvaliacao daoAvaliacao;
	private DAOFaixa daoFaixa;
	private DAOFilme daoFilme;
	private DAOGenero daoGenero;
	private DAOUsuario daoUsuario;
	
	public IMDBFacade() {}

	
	public void adicionaAlbum(AlbumMusical trabalho) {
		if(recuperarAlbumPorTitulo(trabalho.getTitulo()) == null) {
			daoAlbum.salvar(trabalho);
		}
		else { 
			throw new IllegalArgumentException();
		}
	}

	public List<AlbumMusical> recuperarAlbuns() {
		return daoAlbum.recuperaTodos();
	}

	public AlbumMusical recuperarAlbumPorTitulo(String titulo) {
		return daoAlbum.recuperaPorTitulo(titulo);
	}
	
	public List<AlbumMusical> recuperarAlbumPorAutor(String autor) {
		return daoAlbum.recuperaPorAutor(autor);
	}
	
	public List<AlbumMusical> recuperarAlbumPorGenero(String genero) {
		return daoAlbum.recuperaPorGenero(genero);
	}
	
	public void setDaoAlbum(DAOAlbum daoTrabalho) {
		this.daoAlbum = daoTrabalho;
	}
	
	public void editaAlbum(Long id, String titulo, int ano, Autor autor, Genero gen, List<FaixaMusical> listaFaixas) {
		daoAlbum.editar(id, titulo, ano, autor, gen, listaFaixas);
	}
	
	public void deletaAlbum(AlbumMusical album){
		daoAlbum.deletar(album);
	}
	
	public void adicionaAutor(Autor autor){
		if(recuperarAutorPorNome(autor.getNome()) == null) {
			daoAutor.salvar(autor);
		}
		else { 
			throw new IllegalArgumentException();
		}
	}
	
	public List<Autor> recuperarAutor() {
		return daoAutor.recuperaTodos();
	}
	
	public Autor recuperarAutorPorNome(String nome) {
		return daoAutor.recuperaPorNome(nome);
	}
	
	public void setDaoAutor(DAOAutor daoAutor) {
		this.daoAutor = daoAutor;
	}
	
	public void editaAutor(Long id, String nome, String descricao){
		daoAutor.editar(id, nome, descricao);
	}
	
	public void deletaAutor(Autor autor){
		daoAutor.deletar(autor);
	}
	
	public void adicionaAvaliacao(Avaliacao aval){
		daoAvaliacao.salvar(aval);
	}
	
	public List<Avaliacao> recuperarAvaliacao() {
		return daoAvaliacao.recuperaTodos();
	}
	
	public List<Avaliacao> recuperarAvaliacaoPorUsername(String nome) {
		return daoAvaliacao.recuperaPorUsername(nome);
	}
	
	public List<Avaliacao> recuperarAvaliacaoPorTrabalho(String titulo) {
		return daoAvaliacao.recuperaPorTrabalho(titulo);
	}
	
	public void setDaoAvaliacao(DAOAvaliacao daoAvaliacao) {
		this.daoAvaliacao = daoAvaliacao;
	}
	
	public void adicionaFaixa(FaixaMusical faixa) {
		if(recuperarFaixaPorTitulo(faixa.getTitulo()) == null) {
			daoFaixa.salvar(faixa);
		}
		else { 
			throw new IllegalArgumentException();
		}
	}

	public List<FaixaMusical> recuperarFaixas() {
		return daoFaixa.recuperaTodos();
	}

	public FaixaMusical recuperarFaixaPorTitulo(String titulo) {
		return daoFaixa.recuperaPorTitulo(titulo);
	}
	
	public List<FaixaMusical> recuperarFaixasPorAlbum(String album) {
		return daoFaixa.recuperaPorAlbum(album);
	}
	
	public void setDaoFaixa(DAOFaixa daoFaixa) {
		this.daoFaixa = daoFaixa;
	}
	
	public void editaFaixa(Long id, String titulo, int duracao, AlbumMusical album){
		daoFaixa.editar(id, titulo, duracao, album);
	}
	
	public void deletaFaixa(FaixaMusical faixa){
		daoFaixa.deletar(faixa);
	}
	
	public void adicionaFilme(Filme trabalho) {
		if(recuperarFilmePorTitulo(trabalho.getTitulo()) == null) {
			daoFilme.salvar(trabalho);
		}
		else { 
			throw new IllegalArgumentException();
		}
	}

	public List<Filme> recuperarFilmes() {
		return daoFilme.recuperaTodos();
	}

	public Filme recuperarFilmePorTitulo(String titulo) {
		return daoFilme.recuperaPorTitulo(titulo);
	}
	
	public List<Filme> recuperarFilmePorAutor(String autor) {
		return daoFilme.recuperaPorAutor(autor);
	}
	
	public List<Filme> recuperarFilmePorGenero(String genero) {
		return daoFilme.recuperaPorGenero(genero);
	}
	
	public void setDaoFilme(DAOFilme daoTrabalho) {
		this.daoFilme = daoTrabalho;
	}
	
	public void editaFilme(Long id, String titulo, int ano, int duracao, Autor autor, Genero genero){
		daoFilme.editar(id, titulo, ano, duracao, autor, genero);
	}
	
	public void deletaFilme(Filme filme){
		daoFilme.deletar(filme);
	}

	public void adicionaGenero(Genero genero) {
		if(recuperarGeneroPorTitulo(genero.getTitulo()) == null) {
			daoGenero.salvar(genero);
		}
		else { 
			throw new IllegalArgumentException();
		}
	}

	public List<Genero> recuperarGeneros() {
		return daoGenero.recuperaTodos();
	}

	public Genero recuperarGeneroPorTitulo(String titulo) {
		return daoGenero.recuperaPorTitulo(titulo);
	}
	
	public void setDaoGenero(DAOGenero daoGenero) {
		this.daoGenero = daoGenero;
	}
	
	public void editaGenero(Long id, String titulo, String descricao){
		daoGenero.editar(id, titulo, descricao);
	}
	
	public void deletaGenero(Genero genero){
		daoGenero.deletar(genero);
	}
	
	public void adicionaUsuario(Usuario user) {
		if(recuperarUsuarioPorUsername(user.getUser()) == null) {
			daoUsuario.salvar(user);
		}
		else { 
			throw new IllegalArgumentException();
		}
	}

	public List<Usuario> recuperarUsuarios() {
		return daoUsuario.recuperaTodos();
	}

	public Usuario recuperarUsuarioPorUsername(String username) {
		return daoUsuario.recuperaPorUsername(username);
	}
	
	public void setDaoUsuario(DAOUsuario daoUsuario) {
		this.daoUsuario = daoUsuario;
	}
	
	public void editaUsuario(Long id, String user, String senha, String nome, LocalDate dataNasc, boolean gerencia){
		daoUsuario.editar(id, user, senha, nome, dataNasc, gerencia);
	}
	
	public void deletaUsuario(Usuario user){
		daoUsuario.deletar(user);
	}
}
