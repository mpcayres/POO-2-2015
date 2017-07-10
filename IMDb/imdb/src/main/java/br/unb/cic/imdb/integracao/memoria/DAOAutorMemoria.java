package br.unb.cic.imdb.integracao.memoria;

import java.util.ArrayList;
import java.util.List;

import br.unb.cic.imdb.integracao.DAOAutor;
import br.unb.cic.imdb.negocio.Autor;


public class DAOAutorMemoria implements DAOAutor {
	
		private List<Autor> autores;
		
		public DAOAutorMemoria() {
			autores = new ArrayList<>();
		}
		
		@Override
		public void salvar(Autor autor) {
			autores.add(autor);
		}

		@Override
		public List<Autor> recuperaTodos() {
			return autores;
		}

		@Override
		public Autor recuperaPorNome(String nome) {
			
			for(Autor autor : autores) {
				if(autor.getNome().equals(nome)) {
					return autor;
				}
			}
			return null;
			
		}

		@Override
		public Autor recuperaPorId(Long id) {
			for(Autor autor : autores) {
				if(autor.getId().equals(id)) {
					return autor;
				}
			}
			return null;
		}

		@Override
		public void editar(Long id, String nome, String descricao) {
			for(Autor autor : autores) {
				if(autor.getId().equals(id)) {
					autor.setNome(nome);
					autor.setDescricao(descricao);
				}
			}
		}

		@Override
		public void deletar(Autor autor) {
			autor = null;
		}
}
