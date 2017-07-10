package br.unb.cic.imdb.integracao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.unb.cic.imdb.integracao.DAOAutor;
import br.unb.cic.imdb.negocio.Autor;

public class DAOAutorJPA implements DAOAutor {
	
	private EntityManager em;

	@Override
	public void salvar(Autor autor) {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		em.getTransaction().begin();
		em.persist(autor);
		em.getTransaction().commit();
	}

	@Override
	public List<Autor> recuperaTodos() {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		return em.createQuery("FROM Autor").getResultList();
	}

	@Override
	public Autor recuperaPorNome(String nome) {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		List<Autor> autores = em.createQuery("FROM Autor "
				+ "WHERE nome = :nomeParam").setParameter("nomeParam", nome).getResultList();
		return autores.size() == 1 ? autores.get(0): null;
	}

	@Override
	public Autor recuperaPorId(Long id) {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		List<Autor> autores = em.createQuery("FROM Autor "
				+ "WHERE id = :nomeParam").setParameter("nomeParam", id).getResultList();
		return autores.size() == 1 ? autores.get(0): null;
	}

	@Override
	public void editar(Long id, String nome, String descricao) {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		em.getTransaction().begin();
		Query query =  em.createQuery("UPDATE Autor SET "
				+ "nome = :nomeParam, descricao = :descParam "
				+ "WHERE id = :idParam");
		query.setParameter("idParam", id);
		query.setParameter("nomeParam", nome);
		query.setParameter("descParam", descricao);
		query.executeUpdate();
		em.getTransaction().commit();
	}

	@Override
	public void deletar(Autor autor) {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		em.getTransaction().begin();
		Query query =  em.createQuery("DELETE Autor WHERE id = :idParam");
		query.setParameter("idParam", autor.getId());
		query.executeUpdate();
		em.getTransaction().commit();		
	}

}
