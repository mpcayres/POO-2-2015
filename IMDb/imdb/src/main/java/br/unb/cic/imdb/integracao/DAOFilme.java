package br.unb.cic.imdb.integracao;

import java.util.List;

import br.unb.cic.imdb.negocio.Autor;
import br.unb.cic.imdb.negocio.Filme;
import br.unb.cic.imdb.negocio.Genero;

public interface DAOFilme {
	public void salvar(Filme trabalho);
	public void editar(Long id, String titulo, int ano, int duracao, Autor autor, Genero genero);
	public void deletar(Filme filme);
	public Filme recuperaPorId(Long id);
	public List<Filme> recuperaTodos();
	public Filme recuperaPorTitulo(String titulo);
	public List<Filme> recuperaPorAutor(String autor);
	public List<Filme> recuperaPorGenero(String genero);
}
