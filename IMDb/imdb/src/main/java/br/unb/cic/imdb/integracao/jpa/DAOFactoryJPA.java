package br.unb.cic.imdb.integracao.jpa;

import br.unb.cic.imdb.integracao.*;

/**
 * Implementacao da classe abstrata DAOFactory 
 * com persistencia via JPA. 
 * 
 * @author rbonifacio
 */
public class DAOFactoryJPA extends DAOFactory {
	
	@Override
	public DAOAlbum createDAOAlbum() {
		return new DAOAlbumJPA();
	}
	
	@Override
	public DAOAutor createDAOAutor() {
		return new DAOAutorJPA();
	}

	@Override
	public DAOAvaliacao createDAOAvaliacao() {
		return new DAOAvaliacaoJPA();
	}

	@Override
	public DAOFaixa createDAOFaixa() {
		return new DAOFaixaJPA();
	}
	
	@Override
	public DAOFilme createDAOFilme() {
		return new DAOFilmeJPA();
	}

	@Override
	public DAOGenero createDAOGenero() {
		return new DAOGeneroJPA();
	}

	@Override
	public DAOUsuario createDAOUsuario() {
		return new DAOUsuarioJPA();
	}
}
