package br.unb.cic.imdb.integracao.memoria;

import br.unb.cic.imdb.integracao.*;

/**
 * Implementacao da classe abstrata DAOFactory 
 * com persistencia em memoria. 
 * 
 * @author rbonifacio
 */
public class DAOFactoryMemoria extends DAOFactory {
	
	@Override
	public DAOAlbum createDAOAlbum() {
		return new DAOAlbumMemoria();
	}
	
	@Override
	public DAOAutor createDAOAutor() {
		return new DAOAutorMemoria();
	}
	
	@Override
	public DAOAvaliacao createDAOAvaliacao() {
		return new DAOAvaliacaoMemoria();
	}
	
	@Override
	public DAOFilme createDAOFilme() {
		return new DAOFilmeMemoria();
	}
	
	@Override
	public DAOGenero createDAOGenero() {
		return new DAOGeneroMemoria();
	}

	@Override
	public DAOFaixa createDAOFaixa() {
		return new DAOFaixaMemoria();
	}

	@Override
	public DAOUsuario createDAOUsuario() {
		return new DAOUsuarioMemoria();
	}
	
}
