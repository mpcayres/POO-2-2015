package br.unb.cic.imdb.integracao.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import br.unb.cic.imdb.integracao.DAOAvaliacao;
import br.unb.cic.imdb.negocio.Avaliacao;

public class DAOAvaliacaoJPA implements DAOAvaliacao {
	
	private EntityManager em;

	@Override
	public void salvar(Avaliacao avaliacao) {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		em.getTransaction().begin();
		em.persist(avaliacao);
		em.getTransaction().commit();
	}

	@Override
	public List<Avaliacao> recuperaTodos() {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		return em.createQuery("FROM Avaliacao").getResultList();
	}

	@Override
	public List<Avaliacao> recuperaPorUsername(String username) {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		List<Avaliacao> avals = em.createQuery("FROM Avaliacao "
				+ "WHERE usuario = :tituloParam").setParameter("tituloParam", username).getResultList();
		return avals.size() == 1 ? avals: null;
	}

	@Override
	public List<Avaliacao> recuperaPorTrabalho(String titulo) {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		List<Avaliacao> avals = em.createQuery("FROM Avaliacao "
				+ "WHERE trabalho = :tituloParam").setParameter("tituloParam", titulo).getResultList();
		return avals.size() == 1 ? avals: null;
	}

	@Override
	public Avaliacao recuperarPorId(Long id) {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		List<Avaliacao> avals = em.createQuery("FROM Avaliacao "
				+ "WHERE id = :tituloParam").setParameter("tituloParam", id).getResultList();
		return avals.size() == 1 ? avals.get(0): null;
	}

}
