package br.unb.cic.imdb.integracao.memoria;

import java.util.ArrayList;
import java.util.List;

import br.unb.cic.imdb.integracao.DAOFilme;
import br.unb.cic.imdb.negocio.Autor;
import br.unb.cic.imdb.negocio.Filme;
import br.unb.cic.imdb.negocio.Genero;

public class DAOFilmeMemoria implements DAOFilme {
	
	private List<Filme> trabalhos;
	
	public DAOFilmeMemoria() {
		trabalhos = new ArrayList<>();
	}
	
	@Override
	public void salvar(Filme trabalho) {
		trabalhos.add(trabalho);
	}

	@Override
	public List<Filme> recuperaTodos() {
		return trabalhos;
	}

	@Override
	public Filme recuperaPorTitulo(String nome) {
	
		for(Filme trabalho : trabalhos) {
			if(trabalho.getTitulo().equals(nome)) {
				return trabalho;
			}
		}
		return null;
		
	}

	@Override
	public List<Filme> recuperaPorAutor(String autor) {
		List<Filme> trabAutor = new ArrayList<Filme>();
		boolean encontrado = false;
		for(Filme trabalho : trabalhos) {
			if(trabalho.getAutor().equals(autor)) {
				trabAutor.add(trabalho);
				encontrado = true;
			}
		}
		if(encontrado) return trabAutor;
		else return null;
	}

	@Override
	public List<Filme> recuperaPorGenero(String genero) {
		List<Filme> trabAutor = new ArrayList<Filme>();
		boolean encontrado = false;
		for(Filme trabalho : trabalhos) {
			if(trabalho.getGenero().equals(genero)) {
				trabAutor.add(trabalho);
				encontrado = true;
			}
		}
		if(encontrado) return trabAutor;
		else return null;
	}

	@Override
	public Filme recuperaPorId(Long id) {
		for(Filme trabalho : trabalhos) {
			if(trabalho.getId().equals(id)) {
				return trabalho;
			}
		}
		return null;
	}

	@Override
	public void editar(Long id, String titulo, int ano, int duracao, Autor autor, Genero genero) {
		for(Filme trabalho : trabalhos) {
			if(trabalho.getId().equals(id)) {
				trabalho.setTitulo(titulo);
				trabalho.setAno(ano);
				trabalho.setAutor(autor);
				trabalho.setGenero(genero);
				trabalho.setDuracao(duracao);
				break;
			}
		}
	}

	@Override
	public void deletar(Filme filme) {
		filme = null;
	}

}