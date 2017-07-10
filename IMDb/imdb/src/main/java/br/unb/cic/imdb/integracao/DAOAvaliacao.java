package br.unb.cic.imdb.integracao;

import java.util.List;

import br.unb.cic.imdb.negocio.Avaliacao;

public interface DAOAvaliacao {
	public void salvar(Avaliacao avaliacao);
	public Avaliacao recuperarPorId(Long id);
	public List<Avaliacao> recuperaTodos();
	public List<Avaliacao> recuperaPorUsername(String username);
	public List<Avaliacao> recuperaPorTrabalho(String titulo);
}
