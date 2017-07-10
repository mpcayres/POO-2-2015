package br.unb.cic.imdb.integracao.memoria;

import java.util.ArrayList;
import java.util.List;

import br.unb.cic.imdb.integracao.DAOAvaliacao;
import br.unb.cic.imdb.negocio.Avaliacao;

public class DAOAvaliacaoMemoria implements DAOAvaliacao {

	private List<Avaliacao> avaliacoes;
	
	public DAOAvaliacaoMemoria() {
		avaliacoes = new ArrayList<>();
	}
	
	@Override
	public void salvar(Avaliacao avaliacao) {
		avaliacoes.add(avaliacao);
	}

	@Override
	public List<Avaliacao> recuperaTodos() {
		return avaliacoes;
	}

	@Override
	public List<Avaliacao> recuperaPorUsername(String username) {
		List<Avaliacao> avalUser = new ArrayList<>();
		boolean encontrado = false;
		for(Avaliacao aval : avaliacoes) {
			if(aval.getUsuario().equals(username)) {
				avalUser.add(aval);
				encontrado = true;
			}
		}
		if(encontrado) return avalUser;
		else return null;
	}

	@Override
	public List<Avaliacao> recuperaPorTrabalho(String titulo) {
		List<Avaliacao> avalTrab = new ArrayList<>();
		boolean encontrado = false;
		for(Avaliacao aval : avaliacoes) {
			if(aval.getAlbum().equals(titulo) || aval.getFilme().equals(titulo)) {
				avalTrab.add(aval);
				encontrado = true;
			}
		}
		if(encontrado) return avalTrab;
		else return null;
	}

	@Override
	public Avaliacao recuperarPorId(Long id) {
		for(Avaliacao aval : avaliacoes) {
			if(aval.getId().equals(id)) {
				return aval;
			}
		}
		return null;
	}

}
