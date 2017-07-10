package br.unb.cic.imdb.integracao.memoria;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.unb.cic.imdb.integracao.DAOUsuario;
import br.unb.cic.imdb.negocio.Usuario;

public class DAOUsuarioMemoria implements DAOUsuario {

	private List<Usuario> users;
	
	public DAOUsuarioMemoria() {
		users = new ArrayList<>();
	}
	
	@Override
	public void salvar(Usuario usuario) {
		users.add(usuario);
	}

	@Override
	public List<Usuario> recuperaTodos() {
		return users;
	}

	@Override
	public Usuario recuperaPorUsername(String username) {
		for(Usuario user : users) {
			if(user.getUser().equals(username)) {
				return user;
			}
		}
		return null;
	}

	@Override
	public Usuario recuperaPorId(Long id) {
		for(Usuario user : users) {
			if(user.getId().equals(id)) {
				return user;
			}
		}
		return null;
	}

	@Override
	public void editar(Long id, String user, String senha, String nome, LocalDate dataNasc, boolean gerencia) {
		for(Usuario useraux : users) {
			if(useraux.getId().equals(id)) {
				useraux.setUser(user);
				useraux.setSenha(senha);
				useraux.setNome(nome);
				useraux.setDataNasc(dataNasc);
				useraux.setGerencia(gerencia);
			}
		}
	}

	@Override
	public void deletar(Usuario user) {
		user = null;
	}

}
