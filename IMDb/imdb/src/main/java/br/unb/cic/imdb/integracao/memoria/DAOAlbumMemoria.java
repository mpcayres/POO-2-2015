package br.unb.cic.imdb.integracao.memoria;

import java.util.ArrayList;
import java.util.List;

import br.unb.cic.imdb.integracao.DAOAlbum;
import br.unb.cic.imdb.negocio.AlbumMusical;
import br.unb.cic.imdb.negocio.Autor;
import br.unb.cic.imdb.negocio.FaixaMusical;
import br.unb.cic.imdb.negocio.Genero;


public class DAOAlbumMemoria implements DAOAlbum {

		private List<AlbumMusical> trabalhos;
		
		public DAOAlbumMemoria() {
			trabalhos = new ArrayList<>();
		}
		
		@Override
		public void salvar(AlbumMusical trabalho) {
			trabalhos.add(trabalho);
		}

		@Override
		public List<AlbumMusical> recuperaTodos() {
			return trabalhos;
		}

		@Override
		public AlbumMusical recuperaPorTitulo(String nome) {
		
			for(AlbumMusical trabalho : trabalhos) {
				if(trabalho.getTitulo().equals(nome)) {
					return trabalho;
				}
			}
			return null;
		}

		@Override
		public List<AlbumMusical> recuperaPorAutor(String autor) {
			List<AlbumMusical> trabAutor = new ArrayList<AlbumMusical>();
			boolean encontrado = false;
			for(AlbumMusical trabalho : trabalhos) {
				if(trabalho.getAutor().equals(autor)) {
					trabAutor.add(trabalho);
					encontrado = true;
				}
			}
			if(encontrado) return trabAutor;
			else return null;
		}

		@Override
		public List<AlbumMusical> recuperaPorGenero(String genero) {
			List<AlbumMusical> trabAutor = new ArrayList<AlbumMusical>();
			boolean encontrado = false;
			for(AlbumMusical trabalho : trabalhos) {
				if(trabalho.getGenero().equals(genero)) {
					trabAutor.add(trabalho);
					encontrado = true;
				}
			}
			if(encontrado) return trabAutor;
			else return null;
		}

		@Override
		public AlbumMusical recuperaPorId(Long id) {
			for(AlbumMusical trabalho : trabalhos) {
				if(trabalho.getId().equals(id)) {
					return trabalho;
				}
			}
			return null;
		}

		@Override
		public void editar(Long id, String titulo, int ano, Autor autor, Genero gen, List<FaixaMusical> listaFaixas) {
			for(AlbumMusical trabalho : trabalhos) {
				if(trabalho.getId().equals(id)) {
					trabalho.setTitulo(titulo);
					trabalho.setAno(ano);
					trabalho.setAutor(autor);
					trabalho.setGenero(gen);
					trabalho.setListaFaixas(listaFaixas);
					break;
				}
			}
		}

		@Override
		public void deletar(AlbumMusical trabalho) {
			trabalho = null;
		}

}
