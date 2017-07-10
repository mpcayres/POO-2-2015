package br.unb.cic.imdb.integracao.memoria;

import java.util.ArrayList;
import java.util.List;

import br.unb.cic.imdb.integracao.DAOGenero;
import br.unb.cic.imdb.negocio.Genero;

/**
 * Implementacao do DAOGenero em memoria. Util 
 * particularmente para as situacoes em que queremos 
 * testar individualmente as classes, sem a necessidade 
 * de manipular uma base de dados. 
 * 
 * @author rbonifacio
 */
public class DAOGeneroMemoria implements DAOGenero {

	
	private List<Genero> generos;
	
	public DAOGeneroMemoria() {
		generos = new ArrayList<>();
	}
	
	@Override
	public void salvar(Genero genero) {
		generos.add(genero);
	}

	@Override
	public List<Genero> recuperaTodos() {
		return generos;
	}

	@Override
	public Genero recuperaPorTitulo(String titulo) {
	
		for(Genero genero : generos) {
			if(genero.getTitulo().equals(titulo)) {
				return genero;
			}
		}
		return null;
		
	}

	@Override
	public Genero recuperaPorId(Long id) {
		for(Genero genero : generos) {
			if(genero.getId().equals(id)) {
				return genero;
			}
		}
		return null;
	}
	
	@Override
	public void editar(Long id, String titulo, String descricao) {
		for(Genero genero : generos) {
			if(genero.getId().equals(id)) {
				genero.setTitulo(titulo);
				genero.setDescricao(descricao);
			}
		}
	}

	@Override
	public void deletar(Genero genero) {
		genero = null;
	}
}
