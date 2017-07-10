package br.unb.cic.imdb.integracao.jpa;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.unb.cic.imdb.integracao.DAOUsuario;
import br.unb.cic.imdb.negocio.Usuario;

public class DAOUsuarioJPA implements DAOUsuario {
	
	private EntityManager em;

	@Override
	public void salvar(Usuario usuario) {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		em.getTransaction().begin();
		em.persist(usuario);
		em.getTransaction().commit();
	}

	@Override
	public List<Usuario> recuperaTodos() {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		return em.createQuery("FROM Usuario").getResultList();
	}

	@Override
	public Usuario recuperaPorUsername(String username) {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		List<Usuario> users = em.createQuery("FROM Usuario "
				+ "WHERE username = :tituloParam").setParameter("tituloParam", username).getResultList();
		return users.size() == 1 ? users.get(0): null;
	}

	@Override
	public Usuario recuperaPorId(Long id) {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		List<Usuario> users = em.createQuery("FROM Usuario "
				+ "WHERE id = :tituloParam").setParameter("tituloParam", id).getResultList();
		return users.size() == 1 ? users.get(0): null;
	}

	@Override
	public void editar(Long id, String user, String senha, String nome, LocalDate dataNasc, boolean gerencia) {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		em.getTransaction().begin();
		Query query =  em.createQuery("UPDATE Usuario SET "
				+ "username = :userParam, senha = :descParam, nome =:nomeParam, "
				+ "dataNasc = :nascParam, gerencia = :gerParam "
				+ "WHERE id = :idParam");
		query.setParameter("idParam", id);
		query.setParameter("nomeParam", nome);
		query.setParameter("descParam", senha);
		query.setParameter("userParam", user);
		query.setParameter("nascParam", dataNasc);
		query.setParameter("gerParam", gerencia);
		query.executeUpdate();
		em.getTransaction().commit();
	}

	@Override
	public void deletar(Usuario user) {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		em.getTransaction().begin();
		Query query =  em.createQuery("DELETE Usuario WHERE id = :idParam");
		query.setParameter("idParam", user.getId());
		query.executeUpdate();
		em.getTransaction().commit();
	}

}
