package br.unb.cic.imdb.integracao;

import java.util.List;

import br.unb.cic.imdb.negocio.AlbumMusical;
import br.unb.cic.imdb.negocio.FaixaMusical;

public interface DAOFaixa {
	public void salvar(FaixaMusical faixa);
	public void editar(Long id, String titulo, int duracao, AlbumMusical album);
	public void deletar(FaixaMusical faixa);
	public FaixaMusical recuperaPorId(Long id);
	public List<FaixaMusical> recuperaTodos();
	public FaixaMusical recuperaPorTitulo(String titulo);
	public List<FaixaMusical> recuperaPorAlbum(String album);
}
