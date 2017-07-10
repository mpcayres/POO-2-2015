package br.unb.cic.imdb.integracao.memoria;

import java.util.ArrayList;
import java.util.List;

import br.unb.cic.imdb.integracao.DAOFaixa;
import br.unb.cic.imdb.negocio.AlbumMusical;
import br.unb.cic.imdb.negocio.FaixaMusical;

public class DAOFaixaMemoria implements DAOFaixa {
	
	private List<FaixaMusical> faixas;
	
	public DAOFaixaMemoria() {
		faixas = new ArrayList<>();
	}

	@Override
	public void salvar(FaixaMusical faixa) {
		faixas.add(faixa);
	}

	@Override
	public List<FaixaMusical> recuperaTodos() {
		return faixas;
	}

	@Override
	public FaixaMusical recuperaPorTitulo(String titulo) {
		for(FaixaMusical faixa : faixas) {
			if(faixa.getTitulo().equals(titulo)) {
				return faixa;
			}
		}
		return null;
	}

	@Override
	public List<FaixaMusical> recuperaPorAlbum(String album) {
		List<FaixaMusical> faixasAlbum = new ArrayList<>();
		boolean encontrado = false;
		for(FaixaMusical faixa : faixas) {
			if(faixa.getAlbum().equals(album)) {
				faixasAlbum.add(faixa);
				encontrado = true;
			}
		}
		if(encontrado) return faixasAlbum;
		else return null;
	}

	@Override
	public FaixaMusical recuperaPorId(Long id) {
		for(FaixaMusical faixa : faixas) {
			if(faixa.getId().equals(id)) {
				return faixa;
			}
		}
		return null;
	}

	@Override
	public void editar(Long id, String titulo, int duracao, AlbumMusical album) {
		for(FaixaMusical faixa : faixas) {
			if(faixa.getId().equals(id)) {
				faixa.setTitulo(titulo);
				faixa.setDuracao(duracao);
			}
		}
	}

	@Override
	public void deletar(FaixaMusical faixa) {
		faixa = null;
		
	}

}
