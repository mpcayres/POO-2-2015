package br.unb.cic.imdb.integracao;

import java.util.List;

import br.unb.cic.imdb.negocio.Genero;

/**
 * Define os metodos para manipular um 
 * Genero na camad de persistencia. 
 * 
 * @author rbonifacio
 */
public interface DAOGenero {
	public void salvar(Genero genero);
	public void editar(Long id, String titulo, String descricao);
	public void deletar(Genero genero);
	public Genero recuperaPorId(Long id);
	public List<Genero> recuperaTodos();
	public Genero recuperaPorTitulo(String titulo);
}
