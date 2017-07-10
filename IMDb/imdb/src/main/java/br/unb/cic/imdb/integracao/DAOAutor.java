package br.unb.cic.imdb.integracao;

import java.util.List;

import br.unb.cic.imdb.negocio.Autor;

public interface DAOAutor {
	public void salvar(Autor autores);
	public void editar(Long id, String nome, String descricao);
	public void deletar(Autor autor);
	public Autor recuperaPorId(Long id);
	public List<Autor> recuperaTodos();
	public Autor recuperaPorNome(String titulo);
}
