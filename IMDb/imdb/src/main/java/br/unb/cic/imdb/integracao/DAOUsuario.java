package br.unb.cic.imdb.integracao;

import java.time.LocalDate;
import java.util.List;

import br.unb.cic.imdb.negocio.Usuario;

public interface DAOUsuario {
	public void salvar(Usuario usuario);
	public void editar(Long id, String user, String senha, String nome, LocalDate dataNasc, boolean gerencia);
	public void deletar(Usuario user);
	public Usuario recuperaPorId(Long id);
	public List<Usuario> recuperaTodos();
	public Usuario recuperaPorUsername(String username);
}
