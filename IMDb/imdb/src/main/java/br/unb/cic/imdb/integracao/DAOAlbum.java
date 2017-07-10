package br.unb.cic.imdb.integracao;

import java.util.List;

import br.unb.cic.imdb.negocio.AlbumMusical;
import br.unb.cic.imdb.negocio.Autor;
import br.unb.cic.imdb.negocio.FaixaMusical;
import br.unb.cic.imdb.negocio.Genero;

public interface DAOAlbum {
	public void salvar(AlbumMusical trabalho);
	public void editar(Long id, String titulo, int ano, Autor autor, Genero gen, List<FaixaMusical> listaFaixas);
	public void deletar(AlbumMusical trabalho);
	public AlbumMusical recuperaPorId(Long id);
	public List<AlbumMusical> recuperaTodos();
	public AlbumMusical recuperaPorTitulo(String titulo);
	public List<AlbumMusical> recuperaPorAutor(String autor);
	public List<AlbumMusical> recuperaPorGenero(String genero);
}
